package com.community.provider;

import com.community.exception.CustomizeErrorCode;
import com.community.exception.CustomizeException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class TencentCloudProvider {
    // 1 初始化用户身份信息（secretId, secretKey）。
    // SECRETID和SECRETKEY请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
    @Value("${qcloud.ufile.SecretId}")
    private String secretId;
    @Value("${qcloud.ufile.SecretKey}")
    private String secretKey;
    @Value("${qcloud.ufile.bucketName}")
    private String bucketName;
    @Value("${qcloud.ufile.region}")
    private String regionLocation;
    @Value("${qcloud.ufile.expiresTime}")
    private Long expiresTime;
    @Value("${qcloud.ufile.cosPath}")
    private String cosPath;


    public String upload(InputStream inputFileStream, String fileName) {
        // 创建 COSCredentials 对象
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region(regionLocation);
        ClientConfig clientConfig = new ClientConfig(region);
        // 创建 COSClient 对象
        COSClient cosClient = new COSClient(cred, clientConfig);

        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            objectMetadata.setContentLength(inputFileStream.available());
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
        // 获取文件名字（随机生成 + 后缀）
        String genFileName;
        String[] fileSplitter = fileName.split("\\.");
        if (fileSplitter.length > 1) {
            genFileName = UUID.randomUUID().toString() + "." + fileSplitter[fileSplitter.length - 1];
        } else {
            return null;
        }
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = cosPath + genFileName;

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputFileStream, objectMetadata);

        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            if (putObjectResult.getETag() != null) {
                cosClient.shutdown();
                // 获取返回的url（获取请求预签名）
                GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, key);
                // 设置过期时间
                Date expiration = new Date(System.currentTimeMillis() + expiresTime);
                generatePresignedUrlRequest.setExpiration(expiration);
                URL url = cosClient.generatePresignedUrl(generatePresignedUrlRequest);
                return url.toString();
            } else {
                throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
            }
        } catch (CosServiceException e) {
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        } catch (CosClientException e) {
            e.printStackTrace();
            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
        }
    }
}

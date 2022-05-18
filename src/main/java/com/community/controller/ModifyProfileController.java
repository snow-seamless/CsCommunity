package com.community.controller;

import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.provider.TencentCloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ModifyProfileController {
    @Autowired
    private TencentCloudProvider tencentCloudProvider;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/modifyProfile/{action}")
    public String modifyProfile(@PathVariable(name = "action") String action,
                                HttpServletRequest request,
                                Model model) throws IOException {
        // 获取头像同时保存到服务器端
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("avatarPath");
        String uploadImageUrl = tencentCloudProvider.upload(file.getInputStream(), file.getOriginalFilename());
        User user = (User) request.getSession().getAttribute("user");
        // 更新头像的信息
        user.setAvatarUrl(uploadImageUrl);
        userMapper.updateByPrimaryKey(user);
        model.addAttribute("user", user);
        return "personalPage";
    }
}

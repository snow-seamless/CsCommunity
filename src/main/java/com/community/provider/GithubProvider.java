package com.community.provider;

import com.alibaba.fastjson.JSON;
import com.community.dto.AccessTokenDTO;
import com.community.provider.dto.GithubUser;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class GithubProvider {
    @Value("${github.client.id}")
    private String clientID;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectURI;
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        accessTokenDTO.setRedirectURI(redirectURI);
        accessTokenDTO.setClientID(clientID);
        accessTokenDTO.setClientSecret(clientSecret);
        OkHttpClient client = new OkHttpClient();
        String url = "https://github.com/login/oauth/access_token?" +
                "client_id=" + accessTokenDTO.getClientID() +
                "&client_secret=" + accessTokenDTO.getClientSecret() +
                "&redirect_uri=" + accessTokenDTO.getRedirectURI() +
                "&code=" + accessTokenDTO.getCode() +
                "&state=" + accessTokenDTO.getState();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token " + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

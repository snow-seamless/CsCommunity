package com.community.controller;

import com.community.model.User;
import com.community.provider.GithubProvider;
import com.community.dto.AccessTokenDTO;
import com.community.dto.GithubUser;
import com.community.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@Slf4j
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientID;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectURI;

    @Autowired
    private UserService userService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response,
                           Model model) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirectURI(redirectURI);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClientID(clientID);
        accessTokenDTO.setClientSecret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);

        if (githubUser != null && githubUser.getId() != null) {
            // 登录成功，写cookie和session
            User user = new User();
            user.setAccountId(githubUser.getId().toString());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountName(githubUser.getName());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.createOrUpdate(user);
            // 手动写入cookie
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            // 登陆失败
            String timeout = "网络原因，请求超时！请重新登陆！";
            log.error("callback get github error,{}", githubUser);
            model.addAttribute("GitHubFail", timeout);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().invalidate();
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}

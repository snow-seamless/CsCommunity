package com.community.controller;

import com.community.model.User;
import com.community.provider.GithubProvider;
import com.community.dto.AccessTokenDTO;
import com.community.provider.dto.GithubUser;
import com.community.service.UserService;
import com.community.strategy.LoginUserInfo;
import com.community.strategy.UserStrategy;
import com.community.strategy.UserStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@Slf4j
public class AuthorizeController {
    @Autowired
    private UserStrategyFactory userStrategyFactory;

    @Autowired
    private UserService userService;

    @GetMapping("/callback/{type}")
    public String newCallback(@PathVariable(name = "type") String type,
                           @RequestParam(name = "code") String code,
                           @RequestParam(name = "state", required = false) String state,
                           HttpServletResponse response,
                           Model model) {
        UserStrategy userStrategy = userStrategyFactory.getStrategy(type);
        LoginUserInfo loginUserInfo = userStrategy.getUser(code, state);
        if (loginUserInfo != null && loginUserInfo.getId() != null) {
            // 登录成功，写cookie和session
            User user = new User();
            user.setAccountId(loginUserInfo.getId().toString());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountName(loginUserInfo.getName());
            user.setAvatarUrl(loginUserInfo.getAvatarUrl());
            user.setType(type);
            userService.createOrUpdate(user);
            // 手动写入cookie
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/";
        } else {
            // 登陆失败
            String timeout = "网络原因，请求超时！请重新登陆！";
            log.error("callback get github error,{}", loginUserInfo);
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
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }
}

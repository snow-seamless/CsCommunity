package com.community.controller;

import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.model.UserExample;
import com.community.service.MD5Service;
import com.community.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MD5Service md5Service;

    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String Login(HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String rememberFlag = request.getParameter("rememberFlag");
        UserExample userExample = new UserExample();
        userExample.createCriteria().
                andAccountIdEqualTo(account);

        List<User> users = userMapper.selectByExample(userExample);
        String dbPassword = users.get(0).getPassword();
        String dbSalt = users.get(0).getSalt();
        String inputPassword = md5Service.getMd5Password(password, dbSalt);
        if (dbPassword.equals(inputPassword)) {
            if (users != null && users.size() != 0) {
                User user = users.get(0);
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                userMapper.updateByPrimaryKey(user);
                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/");
                if (rememberFlag != null) {
                    cookie.setMaxAge(60 * 60 * 24);
                }
                response.addCookie(cookie);
                return "redirect:/";
            } else {
                model.addAttribute("loginFail", "fail");
                return "login";
            }
        } else {
            model.addAttribute("loginFail", "passwordError");
            return "login";
        }
    }
}

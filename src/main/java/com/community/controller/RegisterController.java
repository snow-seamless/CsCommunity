package com.community.controller;


import com.community.dto.ResultDTO;
import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.model.UserExample;
import com.community.service.MD5Service;
import com.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
public class RegisterController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MD5Service md5Service;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registering(HttpServletRequest request,
                              HttpServletResponse response,
                              Model model) {
        String account = request.getParameter("account");
        String accountName = request.getParameter("accountName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // 对密码进行md5加密
        String salt = UUID.randomUUID().toString().toUpperCase();
        password = md5Service.getMd5Password(password, salt);

        String code = request.getParameter("code");
        Cookie[] cookies = request.getCookies();

        User user = new User();
        user.setSalt(salt);
        user.setStatus(0);
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("activeCode")) {
                String value = cookie.getValue();
                if (value.equals(code)) {
                    user.setStatus(1);
                    break;
                }
            }
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(account)
                .andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() != 0 && users.get(0).getAccountId().equals(account)) {
            model.addAttribute("signupSuccess", "fail-dup-account");
            return "register";
        }
        if (users.size() != 0 && users.get(0).getEmail().equals(email)) {
            model.addAttribute("signupSuccess", "fail-dup-email");
            return "register";
        }
        if (user.getStatus() == 1 && users.size() == 0) {
            user.setAccountName(accountName);
            user.setAccountId(account);
            user.setEmail(email);
            user.setPassword(password);
            user.setAvatarUrl("https://community-1309955505.cos.ap-chengdu.myqcloud.com/images%2Fdefault-user-avatar.png");
            userService.createOrUpdate(user);
            model.addAttribute("signupSuccess", "success");
        } else {
            // 注册失败
            model.addAttribute("signupSuccess", "fail");
        }
        return "register";
    }

    // 接收发送邮件的请求
    @ResponseBody
    @GetMapping("/sendActiveEmail/{email}")
    public ResultDTO sendActiveEmail(@PathVariable(name = "email") String email,
                                     HttpServletResponse response) {
        // 使用cookie存储验证码用于校验
        UserExample userExample = new UserExample();
        userExample.createCriteria().
                andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() != 0) {
            return ResultDTO.errorOf(300, "该用户已经存在，请直接登录！");
        }
        String activeCode = userService.sendEmail(email, "ActiveCode");
        Cookie cookie = new Cookie("activeCode", activeCode);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 5); // 五分钟期限
        response.addCookie(cookie);
        return ResultDTO.okOf(activeCode);
    }
}

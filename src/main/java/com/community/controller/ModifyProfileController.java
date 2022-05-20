package com.community.controller;

import com.alibaba.fastjson.JSONObject;
import com.community.dto.ResultDTO;
import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.model.UserExample;
import com.community.provider.TencentCloudProvider;
import com.community.service.MD5Service;
import com.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ModifyProfileController {
    @Autowired
    private TencentCloudProvider tencentCloudProvider;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MD5Service md5Service;

    @Autowired
    private UserService userService;

    @PostMapping("/modifyProfile/{action}")
    public String modifyProfile(@PathVariable(name = "action") String action,
                                HttpServletRequest request,
                                Model model) throws IOException, ParseException {
        if ("avatar".equals(action)) {
            // 获取头像同时保存到服务器端
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("avatarPath");
            String uploadImageUrl = tencentCloudProvider.upload(file.getInputStream(), file.getOriginalFilename());
            User user = (User) request.getSession().getAttribute("user");
            // 更新头像的信息
            user.setAvatarUrl(uploadImageUrl);
            user.setGmtModified(System.currentTimeMillis());
            userMapper.updateByPrimaryKey(user);
            model.addAttribute("user", user);
            return "redirect:/personalPage/info";
        } else if ("baseInfo".equals(action)) {
            // 修改基本信息
            User user = (User) request.getSession().getAttribute("user");
            // 获取表单提交来的信息
            user.setAccountName(request.getParameter("inputAccountName"));
            user.setUniversity(request.getParameter("inputUniversity"));
            user.setBio(request.getParameter("inputBio"));
            String birth = request.getParameter("inputBrith");
            if (!birth.isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(birth);
                user.setBirth(date);
            } else {
                Date emptyDate = null;
                user.setBirth(emptyDate);
            }
            user.setQqNumber(request.getParameter("inputQQNumber"));
            user.setWechat(request.getParameter("inputWeChat"));
            user.setGender(Integer.valueOf(request.getParameter("genderOption")));
            user.setPhoneNumber(request.getParameter("inputPhoneNumber"));
            user.setGmtModified(System.currentTimeMillis());
            // 更新信息
            userMapper.updateByPrimaryKey(user);
            model.addAttribute("user", user);
            return "redirect:/personalPage/info";
        }
        return "redirect:/";
    }

    // 查看密码是否输入正确
    @ResponseBody
    @GetMapping("/checkPassword/{userId}/{password}")
    public ResultDTO checkPassword(@PathVariable(name = "userId") String userId,
                                   @PathVariable(name = "password") String password,
                                   HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        ResultDTO resultDTO = new ResultDTO<>();
        if (!user.getAccountId().equals(userId)) {
            resultDTO.setMessage("用户不存在！");
            return resultDTO;
        }
        // 校验原来的password是否正确
        User dbUser = userMapper.selectByPrimaryKey(userId);
        if (dbUser == null) {
            resultDTO.setMessage("用户不存在！");
            return resultDTO;
        }
        String dbPwd = dbUser.getPassword();
        String inputPwd = md5Service.getMd5Password(password, dbUser.getSalt());
        if (dbPwd.equals(inputPwd)) {
            return ResultDTO.okOf("matched");
        } else {
            return ResultDTO.errorOf("unmatched");
        }
    }

    // 修改密码以及邮箱
    @ResponseBody
    @PostMapping("/modifySecurity/{action}")
    public ResultDTO modifySecurity(@PathVariable(name = "action") String action,
                                    HttpServletRequest request,
                                    Model model) {
        if ("password".equals(action)) {
            // 修改密码
            User user = (User) request.getSession().getAttribute("user");
            String newPwd = request.getParameter("newPassword");
            user.setPassword(md5Service.getMd5Password(newPwd, user.getSalt()));
            user.setGmtModified(System.currentTimeMillis());
            userMapper.updateByPrimaryKey(user);
            model.addAttribute("user", user);
            return ResultDTO.okOf();
        } else if ("email".equals(action)) {
            // 修改邮箱
            User user = (User) request.getSession().getAttribute("user");
            String newEmail = request.getParameter("newEmail");
            user.setEmail(newEmail);
            user.setGmtModified(System.currentTimeMillis());
            userMapper.updateByPrimaryKey(user);
            model.addAttribute("user", user);
            return ResultDTO.okOf();
        }
        return ResultDTO.errorOf("出错了！");
    }

    @ResponseBody
    @GetMapping("/sendModifyEmail/{email}")
    public ResultDTO sendModifyEmail(@PathVariable(name = "email") String email,
                                     HttpServletResponse response) {
        // 使用cookie存储验证码用于校验
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null || users.size() != 0) {
            return ResultDTO.errorOf(100, "该邮箱已被绑定，请重新输入！");
        }
        String modifyCode = userService.sendEmail(email, "modifyCode");
        Cookie cookie = new Cookie("modifyCode", modifyCode);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 5);
        response.addCookie(cookie);
        return ResultDTO.okOf(modifyCode);
    }
}

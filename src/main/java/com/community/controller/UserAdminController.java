package com.community.controller;

import com.community.model.User;
import com.community.result.Result;
import com.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @title UserAdminController
 * @description <TODO>
 * @auther Zachary
 * @create 2022/5/25 10:09
 */
@RestController
@RequestMapping("/admin/user/userSet")
@CrossOrigin
public class UserAdminController {
    @Autowired
    private UserService userService;
    @GetMapping("findAll")
    public Result findAllUserSet() {
        //调用service的方法
        List<User> list = userService.list();
        return Result.ok(list);
    }
}


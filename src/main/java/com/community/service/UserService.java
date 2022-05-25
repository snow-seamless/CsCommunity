package com.community.service;

import com.community.mapper.UserExtMapper;
import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RandomCodeService randomCodeService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserExtMapper userExtMapper;

    public List<User> list(){
        List<User> userList = userExtMapper.selectUsersAll();
        return userList;
    }

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            // 插入新的记录
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insertSelective(user);
        } else {
            // 更新
            User dbUser = userList.get(0);
            User updateUser = new User();
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setToken(user.getToken());
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAccountName(user.getAccountName());
            updateUser.setEmail(user.getEmail());
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria()
                    .andAccountIdEqualTo(dbUser.getAccountId());
            userMapper.updateByExampleSelective(updateUser, userExample);
        }
    }

    public String sendEmail(String email, String character) {
        // 创建激活码
        String code = randomCodeService.createActiveCode();
        // 主题
        String subject = "来自CsCommunity网站的激活邮件";
        // 上面的激活码发送到用户注册邮箱
        // String context = "<a href=\"http://localhost:8887/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        String context = "<a href=\"\">Please complete in 5 minutes " + character + ":" + code + "</a>";
        //发送激活邮件
        mailService.sendMimeMail(email, subject, context);
        return code;
    }
}

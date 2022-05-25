package com.community.mapper;


import com.community.model.User;

import java.util.List;

/**
 * @title UserExtMapper
 * @description <TODO>
 * @auther Zachary
 * @create 2022/5/25 10:31
 */

public interface UserExtMapper {
    List<User> selectUsersAll();
}

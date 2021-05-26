package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    //查询全部用户
    List<User> getUserList();


    //insert一个用户
    int addUser(User user);


    //修改用户
    int updateUser(User user);

    //删除用户
    int delateUser(int id);
}

package com.dao;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test() {

        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行SQL
        //方式一：getmapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();


        //方式二：
        //List<User> userList = sqlSession.selectList("com.com.dao.UserDao.getUserList");



        for (User user : userList){
            System.out.println(user);
        }

        //关闭sqlsession
        sqlSession.close();
    }


}

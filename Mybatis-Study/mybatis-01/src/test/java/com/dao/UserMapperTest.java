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
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

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

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById(1);
        System.out.println(userById);


        sqlSession.close();

    }

    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.addUser(new User(4, "哈哈", "123456789"));
        if (result > 0) {
            System.out.println("插入成功！");
        }

        //提交事务
        sqlSession.commit();

        sqlSession.close();


    }


    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("Userid", 5);
        map.put("password", "2222223");

        mapper.addUser2(map);

        //提交事务
        sqlSession.commit();

        sqlSession.close();


    }
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4, "呵呵", "66666"));
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void delateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.delateUser(4);
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }
}

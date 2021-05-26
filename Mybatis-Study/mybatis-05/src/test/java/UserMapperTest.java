import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);
        sqlSession.close();

     /*   List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        User userById = mapper.getUserById(1);
        System.out.println(userById);


        mapper.addUser(new User(6, "hello", "333333"));


        mapper.updateUser(new User(6, "to", "99999"));

     */


    }
}

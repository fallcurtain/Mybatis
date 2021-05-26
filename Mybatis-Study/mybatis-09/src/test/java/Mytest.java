import com.dao.UserMapper;
import com.pojo.User;
import com.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {


    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);

        System.out.println(user);
        sqlSession1.close();

//        User user = mapper.queryUserById(1);
//        System.out.println(user);
//
//        //mapper.UpdateUser(new User(2,"aaaa","bbbb"));
//
//        //手动清理缓存
//        sqlSession.clearCache();
//
//        System.out.println("===========================================");
//        User user2 = mapper.queryUserById(1);
//        System.out.println(user2);
//
//        System.out.println(user==user2);
//        sqlSession.close();
    }
}

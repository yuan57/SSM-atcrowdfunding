package junit.test;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.manager.dao.UserMapper;
import com.yuanxiulin.atcrowdfunding.util.MD5Util;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class Test03 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring*.xml");
        SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0; i < 100; i++) {
            User user = new User();
            String uuid = UUID.randomUUID().toString().substring(0, 5);
            String v = (int) ((Math.random() * 9 + 1) * 100000) + "";
            user.setLoginacct(v);
            user.setUsername(uuid);
            user.setUserpswd(MD5Util.digest(i + "" + uuid));
            user.setEmail(uuid + "@qq.com");
            user.setCreatetime("2020-04-18 09:41:00");
            mapper.insert(user);
            System.out.println("完成！！");

        }

    }
}

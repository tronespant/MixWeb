package com.room.mixweb;

import com.room.mixweb.domain.User;
import com.room.mixweb.model.TestDao;
import com.room.mixweb.model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 2:112019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void test(){
        if (sqlSessionTemplate==null){
            System.out.println("为空！！");
        }
        SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession();
        UserMapper mapper1 = session.getMapper(UserMapper.class);
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);

        List<User> list = mapper.find();
        UserService us=new UserService();
        us.findUser(applicationContext);
        for (User user:list){

            System.out.println(user.getId()+user.getAge());
        }
      /*  for (Map.Entry<String,Object> entry:result.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }*/
    }

}

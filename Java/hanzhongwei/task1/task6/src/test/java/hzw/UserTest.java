package hzw;


import hzw.mapper.UserMapper;
import hzw.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
    private Logger logger = Logger.getLogger("UserTest.class");

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findIdUser(){
        logger.info("测试获取用户ID信息=====================");
        Long id = new Long(1);
        User user = userMapper.findIdUser(id);
        logger.info("获取的用户信息是："+user);
    }

    //@Test
    public void addUser(){
        logger.info("测试增加用户信息=====================");
        User user = new User();
        user.setUserName("111");
        user.setPassword("111");
        user.setSalt("42342523");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.addUser(user);
        logger.info(""+user.getUserId());
    }

    @Test
    public void delelteUser(){
        logger.info("测试删除用户信息=====================");
        Long id = new Long(3);
        userMapper.deleteUser(id);
        logger.info("删除结束");
    }

    //@Test
    public void updateUser(){
        logger.info("测试更新用户信息=====================");
        User user =new User();
        Long id = new Long(4);
        user.setUserId(id);
        user.setUserName("333");
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.updateUser(user);
        logger.info("更新结束");
    }

    //@Test
    public void findListUser(){
        logger.info("测试查询全部用户信息=====================");
        List<User> list = userMapper.findListUser();
        for (User s:list){
            logger.info(s.toString());
        }
    }

    //@Test
    public void findNameUser(){
        logger.info("测试查询用户姓名信息=====================");
        User list = userMapper.findNameUser("333");
        logger.info(list.toString());
    }

    
}

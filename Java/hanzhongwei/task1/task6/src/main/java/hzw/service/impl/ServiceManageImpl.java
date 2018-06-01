package hzw.service.impl;

import com.whalin.MemCached.MemCachedClient;
import hzw.mapper.ProfessionMapper;
import hzw.mapper.StudentsMapper;
import hzw.mapper.UserMapper;
import hzw.model.Profession;
import hzw.model.Students;
import hzw.model.User;
import hzw.service.ServiceManage;
import hzw.util.MemcacheUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ServiceManageImpl implements ServiceManage {
    @Autowired
    StudentsMapper studentsMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProfessionMapper professionMapper;



    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ServiceManageImpl.class);

    @Override
    public Students findByIdStudents(Long id) {
        return studentsMapper.findIdStudents(id);
    }

    @Override
    public List<Students> findListStudents() {
        List<Students> students;
        if (MemcacheUtil.get("students") != null){
            students = (List<Students>) MemcacheUtil.get("students");
            logger.info("这是从缓存里取出来的数据"+students+"================");
            return students;
        }else {
            students = studentsMapper.findListStudents();
            boolean isSuccess = MemcacheUtil.add("students",studentsMapper.findListStudents());
            logger.info("这是从数据库拿出来的数据");
            logger.info("是否成功：" + isSuccess);
            return students;
        }
    }

    @Override
    public List<Profession> findListProfession() {
        List<Profession> professions;
        if (MemcacheUtil.get("profession") != null){
            professions = (List<Profession>) MemcacheUtil.get("profession");
            logger.info("这是从缓存里取出来的数据"+professions+"================");
            return professions;
        }else {
            professions = professionMapper.findListProfession();
            MemcacheUtil.set("profession",professionMapper.findListProfession());
            logger.info("这是从数据库拿出来的数据");
            return professions;
        }
    }

    @Override
    public User findNameUser(String userName) {
        User user;
        if (MemcacheUtil.get("user") != null){
            user = (User) MemcacheUtil.get("user");
            logger.info("这是从缓存里取出来的数据"+user+"================");
            return user;
        }else {
            user = userMapper.findNameUser(userName);
            MemcacheUtil.set("user",userMapper.findNameUser(userName));
            logger.info("这是从数据库拿出来的数据");
            return user;
        }
    }

    @Override
    public List<User> findListUser() {
        List<User> users;
        if (MemcacheUtil.get("users") != null){
            users = (List<User>) MemcacheUtil.get("users");
            logger.info("这是从缓存里取出来的数据"+users+"================");
            return users;
        }else {
            users = userMapper.findListUser();
            boolean isSuccess = MemcacheUtil.set("users",userMapper.findListUser());
            logger.info("是否成功：" + isSuccess);
            logger.info("这是从数据库拿出来的数据");
            return users;
        }
    }

    @Override
    public void insertUser(User user) {
        user.setSalt("zhongwei");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.addUser(user);
        MemcacheUtil.add("user",user);
        logger.info("将数据放入缓存中"+MemcacheUtil.get("user"));
    }

    @Override
    public Integer countStudent() {
        Integer a;
        if (MemcacheUtil.get("a") != null){
            a = (Integer) MemcacheUtil.get("a");
            logger.info("这是从缓存里取出来的数据"+a+"================");
            return a;
        }else {
            a = studentsMapper.countStudent();
            boolean isSuccess = MemcacheUtil.set("a",a);
            logger.info("是否成功：" + isSuccess);
            logger.info("将数据放入缓存中");
            return a;
        }
    }

    @Override
    public Integer countWork() {
        Integer b;
        if (MemcacheUtil.get("b") != null){
            b = (Integer) MemcacheUtil.get("b");
            logger.info("这是从缓存里取出来的数据"+b+"================");
            return b;
        }else {
            b = studentsMapper.countWork();
            boolean isSuccess = MemcacheUtil.set("b",b);
            logger.info("是否成功：" + isSuccess);
            logger.info("将数据放入缓存中");
            return b;
        }
    }
}

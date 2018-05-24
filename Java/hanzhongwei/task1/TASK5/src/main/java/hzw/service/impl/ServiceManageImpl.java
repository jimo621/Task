package hzw.service.impl;

import hzw.mapper.ProfessionMapper;
import hzw.mapper.StudentsMapper;
import hzw.mapper.UserMapper;
import hzw.model.Profession;
import hzw.model.Students;
import hzw.model.User;
import hzw.service.ServiceManage;
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

    @Override
    public Students findByIdStudents(Long id) {
        return studentsMapper.findIdStudents(id);
    }

    @Override
    public List<Students> findListStudents() {
        return studentsMapper.findListStudents();
    }

    @Override
    public List<Profession> findListProfession() {
        return professionMapper.findListProfession();
    }

    @Override
    public User findNameUser(String userName) {
        return userMapper.findNameUser(userName);
    }

    @Override
    public List<User> findListUser() {
        return userMapper.findListUser();
    }

    @Override
    public void insertUser(User user) {
        user.setSalt("zhongwei");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.addUser(user);
    }

    @Override
    public Integer countStudent() {
        return studentsMapper.countStudent();
    }

    @Override
    public Integer countWork() {
        return studentsMapper.countWork();
    }
}

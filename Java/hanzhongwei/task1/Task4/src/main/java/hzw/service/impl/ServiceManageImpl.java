package hzw.service.impl;

import hzw.mapper.ProfessionMapper;
import hzw.mapper.StudentMapper;
import hzw.model.Profession;
import hzw.model.Student;
import hzw.service.ServiceManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceManageImpl")
public class ServiceManageImpl implements ServiceManage {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ProfessionMapper professionMapper;

    public Student findByIdStudent(Integer id) {
        return studentMapper.findByIdStudent(id);
    }

    public List<Student> findListStudent() {
        return studentMapper.findListStudent();
    }

    public boolean insertStudent(Student student) {
        return false;
    }

    public boolean deleteStudent(Integer id) {
        return false;
    }

    public boolean updateStudent(Student student) {
        return false;
    }

    public Integer countStudent() {
        Integer countStudent = studentMapper.countStudent();
        return countStudent;
    }

    public Integer countWork(){
        Integer countWork = studentMapper.countWork();
        return countWork;
    }

    public List<Profession> findByListProfession() {
        return professionMapper.findByListProfession();
    }

}


package hzw.service.impl;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import hzw.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student findIdStudent(Integer id) {
        return studentMapper.findIdStudent(id);
    }

    @Override
    public Student getID(Long id) {
        return studentMapper.getID(id);
    }

    @Override
    public Integer insertStudent(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        return studentMapper.insertStudent(student);
    }

    @Override
    public Integer deleteStudent(Integer id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Integer updateStudent(Student student) {
        student.setUpdate_at(System.currentTimeMillis());
        return studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> findListStudent() {
        return studentMapper.findListStudent();
    }

    @Override
    public List<Student> findNameStudent(String name) {
        return studentMapper.findNameStudent(name);
    }
}

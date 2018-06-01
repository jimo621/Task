package hzw.service.impl;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import hzw.service.StudentService;
import hzw.util.DESUtil;
import hzw.util.MemcacheUtil;
import hzw.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public Student findIdStudent(Integer id) {
        return studentMapper.findIdStudent(id);
    }

    @Override
    public Student getID(Long id) {
        Student student;
        if (MemcacheUtil.get("sName"+id) != null) {
            student = (Student) MemcacheUtil.get("sName"+id);
            System.out.println("这是缓存中的数据");
            return student;
        }else {
            student = studentMapper.getID(id);
            if (studentMapper.getID(id) != null) {
                //如果查询数据库不为空，将数据写入缓存中
                MemcacheUtil.set("sName"+id,student);
                return student;
            }else {
                //如果查询数据为空，将该值写入缓存中，设计一个很短的失效时间
                MemcacheUtil.set("sName"+id,student,60);
                return student;
            }
        }
    }

    @Override
    public Integer insertStudent(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        return studentMapper.insertStudent(student);
    }

    @Override
    public Integer deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
        MemcacheUtil.delete("sName"+id);
        return studentMapper.deleteStudent(id);
    }

    @Override
    public Integer updateStudent(Student student) {
        student.setUpdate_at(System.currentTimeMillis());
        Integer a = studentMapper.updateStudent(student);
        MemcacheUtil.delete("sName"+student.getsId());
        return a;
    }

    @Override
    public List<Student> findListStudent() {
        List<Student> students;
        if (MemcacheUtil.get("sStudent") != null) {
            students = (List<Student>) MemcacheUtil.get("sStudent");
            System.out.println("这是从缓存里取出来的数据"+students+"================");
            return students;
        }else {
            students = studentMapper.findListStudent();
            boolean isSuccess = MemcacheUtil.set("sStudent",studentMapper.findListStudent());
            System.out.println("放入缓存是否成功：" + isSuccess);
            return students;
        }
    }

    @Override
    public List<Student> findNameStudent(String name) {
        return studentMapper.findNameStudent(name);
    }
}

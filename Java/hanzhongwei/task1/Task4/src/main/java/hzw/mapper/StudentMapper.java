package hzw.mapper;

import hzw.model.Student;

import java.util.List;

public interface StudentMapper {
    // 根据id查找学员
   Student findByIdStudent(Integer id);
    // 获取所有学员数据
    List<Student> findListStudent();
   // 插入学员
    boolean insertStudent(Student student);
    // 删除学员
    boolean deleteStudent(Integer id);
    // 更新学员
    boolean updateStudent(Student student);


    // 统计学员数
    Integer countStudent();

    // 统计工作数
    Integer countWork();
}

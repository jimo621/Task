package hzw;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    private Logger logger = Logger.getLogger("StudentTest.class");

    @Autowired
    private StudentMapper studentMapper;

    //@Test
    public void findIdStudent(){
        logger.info("测试获取学员ID信息=====================");
        Integer id = 1;
        Student student = studentMapper.findIdStudent(id);
        logger.info("获取的用户信息是："+student);
    }

    @Test
    public void getID(){
        Long id = Long.valueOf(1);
        long id1 = 1;
        Student student = studentMapper.getID(id);
        logger.info("获取的用户信息是："+student);
    }

    //@Test
    public void insertStudent(){
        logger.info("测试增加学员信息=====================");
        Student student = new Student();
        student.setsName("宣仪");
        student.setQQ(2144324);
        student.setsType("练习生");
        student.setsTime("2018年2月25日");
        student.setsSchool("天美");
        student.setsNumber("UI-313");
        student.setsDaily("日报");
        student.setsWish("闭门修仙，变小仙女");
        student.setsCoach("常雷雷");
        student.setsWhence("知乎");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        Integer id = studentMapper.insertStudent(student);
        logger.info(""+id);
        logger.info(""+student.getsId());
    }

    //@Test
    public void delelteStudent(){
        logger.info("测试删除学员信息=====================");
        Integer id = 3;
        Integer b = studentMapper.deleteStudent(id);
        logger.info(""+b);
    }

    //@Test
    public void updateStudent(){
        logger.info("测试更新学员信息=====================");
        Student student =new Student();
        student.setsId(Long.valueOf(4));
        student.setsName("孟美岐");
        student.setUpdate_at(System.currentTimeMillis());
        Integer a = studentMapper.updateStudent(student);
        logger.info(""+a);
    }

    //@Test
    public void findListStudent(){
        logger.info("测试查询全部学员信息=====================");
        List<Student> list = studentMapper.findListStudent();
        for (Student s:list){
            logger.info(s.toString());
        }
    }

    //@Test
    public void findNameStudent(){
        logger.info("测试查询学员姓名信息=====================");
        List<Student> list = studentMapper.findNameStudent("宣仪");
        for (Student s:list){
            logger.info(s.toString());
        }
    }
}

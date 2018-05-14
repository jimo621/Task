package hzw;

import hzw.mapper.ProfessionMapper;
import hzw.mapper.StudentMapper;
import hzw.model.Profession;
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
    @Autowired
    private ProfessionMapper professionMapper;

    @Test
    public void getId(){
        logger.info("测试查询id=====================");
        Integer stuId = 1;
        Student s = studentMapper.findByIdStudent(stuId);
        logger.info(s.toString());
    }

    @Test
    public void getfull(){
        logger.info("测试全表=====================");
        List<Student> list = studentMapper.findListStudent();
        for(Student  s:list){
            logger.info(s.toString());
        }
    }

    @Test
    public void stuCount(){
        logger.info("测试计数=====================");
        int a = studentMapper.countStudent();
        logger.info("总数是===="+a);
    }

    @Test
    public void workCount(){
        logger.info("测试工作计数=====================");
        int b = studentMapper.countWork();
        logger.info("工作人数是："+b);
    }

    @Test
    public void  getPro(){
        logger.info("测试pro=====================");
        List<Profession> pro = professionMapper.findByListProfession();
        for(Profession p:pro){
            logger.info(p.toString());
        }
    }
}

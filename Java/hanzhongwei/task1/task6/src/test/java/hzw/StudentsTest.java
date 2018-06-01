package hzw;

import hzw.mapper.StudentsMapper;
import hzw.model.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentsTest {
    private Logger logger = Logger.getLogger("StudentsTest.class");

    @Autowired
    private StudentsMapper studentsMapper;

    @Test
    public void findIdStudents(){
        logger.info("测试获取用户ID信息=====================");
        Long id = new Long(1);
        Students students = studentsMapper.findIdStudents(id);
        logger.info("获取的用户信息是："+students);
    }

    //@Test
    public void addStudents(){
        logger.info("测试增加用户信息=====================");
        Students students = new Students();
        students.setStuName("孟美岐");
        students.setStuIntroduction("这是一个美丽的姑娘");
        students.setStuWork(1);
        students.setStuSuper(1);
        students.setStuProfession("舞美");
        students.setStuPortrait("/");
        students.setCreate_at(System.currentTimeMillis());
        students.setUpdate_at(System.currentTimeMillis());
        studentsMapper.addStudents(students);
        logger.info(""+students.getStuId());
    }

    //@Test
    public void delelteStudents(){
        logger.info("测试删除用户信息=====================");
        Long id = new Long(3);
        studentsMapper.deleteStudents(id);
        logger.info("删除结束");
    }

    //@Test
    public void updateStudents(){
        logger.info("测试更新用户信息=====================");
        Students students =new Students();
        Long id = new Long(4);
        students.setStuId(id);
        students.setStuName("宣仪");
        students.setUpdate_at(System.currentTimeMillis());
        studentsMapper.updateStudents(students);
        logger.info("更新结束");
    }

    //@Test
    public void findListStudents(){
        logger.info("测试查询全部用户信息=====================");
        List<Students> list = studentsMapper.findListStudents();
        for (Students s:list){
            logger.info(s.toString());
        }
    }

    //@Test
    public void findNameStudents(){
        logger.info("测试查询用户姓名信息=====================");
        List<Students> list = studentsMapper.findNameStudents("宣仪");
        for (Students s:list){
            logger.info(s.toString());
        }
    }

    @Test
    public void stuCount(){
        logger.info("测试计数=====================");
        int a = studentsMapper.countStudent();
        logger.info("总数是===="+a);
    }

    @Test
    public void workCount(){
        logger.info("测试工作计数=====================");
        int b = studentsMapper.countWork();
        logger.info("工作人数是："+b);
    }
}

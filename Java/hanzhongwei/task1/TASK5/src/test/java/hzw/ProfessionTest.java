package hzw;

import hzw.mapper.ProfessionMapper;
import hzw.model.Profession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProfessionTest {
    private Logger logger = Logger.getLogger("ProfessionTest.class");

    @Autowired
    private ProfessionMapper professionMapper;

    @Test
    public void findIdProfession(){
        logger.info("测试获取用户ID信息=====================");
        Long id = new Long(1);
        Profession profession = professionMapper.findIdProfession(id);
        logger.info("获取的用户信息是："+profession);
    }

    //@Test
    public void addProfession(){
        logger.info("测试增加用户信息=====================");
        Profession Professions = new Profession();
        Professions.setProName("WEB工程师");
        Professions.setProIntroduction("这是一个美丽的姑娘");
        Professions.setProThreshold(1);
        Professions.setProDifficulty(2);
        Professions.setProCompany(324);
        Professions.setProSalary1("5-8");
        Professions.setProSalary2("8-12");
        Professions.setProSalary3("10-15");
        Professions.setProPrompt("你需要掌握xxx");
        Professions.setCreate_at(System.currentTimeMillis());
        Professions.setUpdate_at(System.currentTimeMillis());
        for (int i =0;i<=5;i++){
            professionMapper.addProfession(Professions);
            logger.info(""+Professions.getProId());

        }
    }

    //@Test
    public void deleteProfession(){
        logger.info("测试删除用户信息=====================");
        Long id = new Long(3);
        professionMapper.deleteProfession(id);
        logger.info("删除结束");
    }

    //@Test
    public void updateProfession(){
        logger.info("测试更新用户信息=====================");
        Profession Professions =new Profession();
        Long id = new Long(4);
        Professions.setProId(id);
        Professions.setProName("JAVA工程师");
        Professions.setUpdate_at(System.currentTimeMillis());
        professionMapper.updateProfession(Professions);
        logger.info("更新结束");
    }

    //@Test
    public void findListProfession(){
        logger.info("测试查询全部用户信息=====================");
        List<Profession> list = professionMapper.findListProfession();
        for (Profession s:list){
            logger.info(s.toString());
        }
    }

    //@Test
    public void findNameProfession(){
        logger.info("测试查询用户姓名信息=====================");
        List<Profession> list = professionMapper.findNameProfession("JAVA工程师");
        for (Profession s:list){
            logger.info(s.toString());
        }
    }
}

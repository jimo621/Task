package hzw;

import hzw.util.MemcacheUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MemcacheTest {
    private Logger logger = Logger.getLogger("MemcacheTest.class");

    @Test
    public void test() {
        //设置key
        boolean isSuccess = MemcacheUtil.set("name", "qiyongkang");
        logger.info("是否成功：" + isSuccess);
        Object obj = MemcacheUtil.get("name");
        logger.info("获取name:" + obj);
    }

}

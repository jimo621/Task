package hzw.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JspTag extends TagSupport {
    private static Logger logger = LoggerFactory.getLogger(JspTag.class);

    //jsp传过来的是字符串类型的
    private String value;

    @Override
    public int doStartTag() throws JspException {
        if (!value.equals("")) {
            String vv = "" + value;
            try {
                //将字符串转换为long, trim()除去空格,转换时不能有空格
                long timeLong = Long.valueOf(vv.trim());
                logger.debug("Long 开始转换为 String : " + timeLong);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date judt = new Date(timeLong * 1000);
                String s = simpleDateFormat.format(judt);
                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("转换失败");
            }
        } else {
            /* 为空时返回空值,不处理 jsp会解析出错*/
            String s = "";
            try {
                pageContext.getOut().write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error("时间值为空");
        }
        return super.doStartTag();
    }

    //传入的时间格式String
    public void setValue(String value) {
        this.value = value;
    }
}

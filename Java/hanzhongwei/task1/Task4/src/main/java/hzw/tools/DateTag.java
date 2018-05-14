package hzw.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTag extends TagSupport {
    private static final long serialVersionUID = 6464168398214506236L;
    private static Logger logger = LoggerFactory.getLogger(JspTag.class);
    private String value;

    @Override
    public int doStartTag() throws JspException {
        String vv = ""+value ;
        long time = Long.valueOf(vv);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        String s = dateformat.format(c.getTime());
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("转换失败");
        }
        return super .doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

}

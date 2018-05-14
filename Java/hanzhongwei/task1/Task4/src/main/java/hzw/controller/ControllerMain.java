package hzw.controller;

import hzw.model.Profession;
import hzw.model.Student;
import hzw.service.ServiceManage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class ControllerMain {
    @Autowired
    ServiceManage serviceManage;

    private static Logger logger = LoggerFactory.getLogger(ControllerMain.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView one(){
        logger.info("进入首页");
        ModelAndView mav = new ModelAndView();
        List<Student> list = serviceManage.findListStudent();
        int a = serviceManage.countStudent();
        int b = serviceManage.countWork();
        mav.addObject("stu",list);
        mav.addObject("a",a);
        mav.addObject("b",b);
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value = "/pro",method = RequestMethod.GET)
    public ModelAndView profession(){
        logger.info("进入职业推荐页");
        ModelAndView mav = new ModelAndView();
        List<Profession> profession =  serviceManage.findByListProfession();
        mav.addObject("pro",profession);
        mav.setViewName("profession");
        return mav;
    }

    @RequestMapping(value = "/company",method = RequestMethod.GET)
    public ModelAndView company(){
        logger.info("进入推荐企业页");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("company");
        return mav;
    }

}



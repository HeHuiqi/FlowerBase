package com.hhq.hq;

import com.hhq.hq.HqConfig.ApplicationJavaConfig;
import com.hhq.hq.HqDAO.HqUser;
import com.hhq.hq.HqDAO.HqUserDAO;
import com.hhq.hq.HqDAO.HqUserDAOImp;
import com.hhq.hq.HqSpringDI.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static  void main(String[] args){


        ApplicationContext context = null;



        //xml配置
        String xmlConfigPath = "classpath:/spring/applicationContext.xml";
//        context = new ClassPathXmlApplicationContext(xmlConfigPath);

        //java配置
        context = new AnnotationConfigApplicationContext(ApplicationJavaConfig.class);

//        Hello hello = (Hello)context.getBean(Hello.class);
//        hello.sayHello();

//        HqAutoHello autoHello = (HqAutoHello)context.getBean(HqAutoHello.class);
//        autoHello.spellCheck();

//        HqSpeak speak = (HqSpeak)context.getBean(HqPerson.class);
//        speak.speak("欢迎DI");

//        HqSchool school = (HqSchool) context.getBean(HqSchool.class);
//        school.zhaoPin();

        HqUserDAO userDAO = (HqUserDAO)context.getBean(HqUserDAOImp.class);
        HqUser user = userDAO.getUser(2);
        System.out.println(user);

    }
}

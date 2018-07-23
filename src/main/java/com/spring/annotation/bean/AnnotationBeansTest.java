package com.spring.annotation.bean;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeansTest {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_annotation.xml");
        UserSerVice userSerVice = (UserSerVice) ctx.getBean("userSerVice");
        userSerVice.add();

        UserController userController = (UserController) ctx.getBean("userController");
        userController.execute();
    }

}

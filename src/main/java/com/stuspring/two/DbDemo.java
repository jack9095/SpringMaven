package com.stuspring.two;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class DbDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans_properties.xml");
        try {
            DataSource dataSource = (DataSource) context.getBean("dataSource2");
            Connection connection = dataSource.getConnection();
            System.out.println("connection = " + connection);
        } catch (Exception e) {
            System.out.println("异常 = " + e);
        }
    }
}

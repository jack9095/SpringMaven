package com.stuspring.two;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class DbDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_properties.xml");
        try {
            DataSource dataSource = (DataSource) ctx.getBean("dataSource");
            Connection connection = dataSource.getConnection();
            System.out.println("connection = " + connection);
        } catch (Exception e) {
            System.out.println("异常 = " + e);
        }
    }
}

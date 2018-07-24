package aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试
 */
public class Test {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans_aop.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
        arithmeticCalculator.add(2,4);
    }

}

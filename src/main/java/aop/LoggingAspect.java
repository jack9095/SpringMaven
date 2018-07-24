package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * https://blog.csdn.net/napoay/article/details/72245979
 * 加入日志切面
 * 切面的优先级可以用@Order注解指定，传入的整数值越小，优先级越高。
 */
@Order(1)
@Aspect
@Component
public class LoggingAspect {
    /**
     *  复用切点表达式
     *  定义一个方法用于声明切入点表达式。一般地，该方法不需要再写其它代码。
     *  外部类引用可以使用包名加方法名的方法
     */
    @Pointcut("execution(public int aop.ArithmeticCalculatorImpl.*(int,int))")
    public void declareJoinPointExpression(){
    }

    /**
     * 前置通知 方法开始之前执行
     * @param joinPoint
     */
    @Before("execution(public int aop.ArithmeticCalculatorImpl.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> agrs = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + agrs);
    }

    /**
     * 后置通知，方法执行完之后执行，不论方法是否出现异常
     * 后置通知中不能访问目标方法的执行结果
     */
    @After("execution(public int aop.ArithmeticCalculatorImpl.*(int,int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " ends with " + args);
    }

}

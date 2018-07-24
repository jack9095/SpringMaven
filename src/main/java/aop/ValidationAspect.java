package aop;

import org.aspectj.lang.JoinPoint;

/**
 * 参数验证切面
 */
public class ValidationAspect {

    public void validateArgs(JoinPoint joinPoint){
        System.out.println("validationMethod......fly");
    }

}

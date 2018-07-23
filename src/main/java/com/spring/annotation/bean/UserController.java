package com.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 控制层
 */
@Controller
public class UserController {

    /**
     * @Autowired注解会自动装配具有兼容类型的单个Bean属性：
     * 构造器、普通字段，一切具有参数的方法都可以用@Autowired注解
     * 默认情况下，所有使用@Autowired注解的属性都需要被设置。当Spring找不到匹配的Bean装配属性时会抛出异常。若某一属性允许不被设置，可以设置@Autowired注解的required属性为false
     * 默认情况下， 当IOC容器中存在多个类型兼容的Bean时，通过类型的自动装配将会无法工作，此时可以在@Qualifier注解里提供Bean的名称。Spring允许对方法的入参标注@Qualifier已指定注入的Bean的名称。
     * @Autowired注解也可以应用在数组类型的属性上，此时Spring会把所有匹配的Bean进行自动装配
     * @Autowired注解也可以应用在集合属性上，此时Spring读取积累的类型信息，然后自动装配所有与之兼容的Bean。
     * @Autowired注解用在java.util.map上时，若该map的键值为String，那么Spring将自动装配与之Map类值兼容的Bean，此时Bean的名称作为键值。
     */
    @Autowired
    private UserSerVice userSerVice;

    public void execute(){
        System.out.println("UserController execute...");
        userSerVice.add();
        System.out.println("UserController execute...fly");
    }
}

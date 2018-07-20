package annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)   // 作用域
//@Target({ElementType.TYPE,ElementType.METHOD})   // 作用域
@Retention(RetentionPolicy.RUNTIME)  // 源码、编译时、运行时
@Inherited                   // 允许子继承
@Documented                  //生成javadoc时会包含注解
public @interface Despring {  // 注解的名字为Description

    String desc() default "怀念与想念";
    int age() default 18;
    String name() default "大卫";
}

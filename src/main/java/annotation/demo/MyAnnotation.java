package annotation.demo;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {

    String desc() default "怀念与想念";
    int age() default 18;
    String name() default "大卫";
}

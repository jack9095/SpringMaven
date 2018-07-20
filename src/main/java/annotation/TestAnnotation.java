package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotation {
    Annotation[] annotation = null;

    public static void main(String[] args) {
        try {
            new TestAnnotation().getAnnotation();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getAnnotation() throws ClassNotFoundException {
        Class<?> stu = Class.forName("annotation.demo.ChildPerson");//静态加载类
        boolean isEmpty = stu.isAnnotationPresent(annotation.Despring.class);//判断stu是不是使用了我们刚才定义的注解接口
        if (isEmpty) {
            annotation = stu.getAnnotations();//获取注解接口中的
            for (Annotation a : annotation) {
                Despring my = (Despring) a;//强制转换成Despring类型
                System.out.println(stu + ":\n" + my.name() + " des: " + my.desc() + " my age: " + my.age());
            }
        }

        Method[] method = stu.getMethods();//
        System.out.println("Method");
        for (Method m : method) {
            boolean ismEmpty = m.isAnnotationPresent(annotation.Despring.class);
            if (ismEmpty) {
                Annotation[] aa = m.getAnnotations();
                for (Annotation a : aa) {
                    Despring an = (Despring) a;
                    System.out.println(m + ":\n" + an.name() + " des: " + an.desc() + " my age: " + an.age());
                }
            }
        }
        //get Fields by force
        System.out.println("get Fileds by force !");
        Field[] field = stu.getDeclaredFields();
        for (Field f : field) {
            f.setAccessible(true);
            System.out.println(f.getName());
        }
        System.out.println("get methods in interfaces !");
        Class<?> interfaces[] = stu.getInterfaces();
        for (Class<?> c : interfaces) {
            Method[] imethod = c.getMethods();
            for (Method m : imethod) {
                System.out.println(m.getName());
            }
        }
    }

}

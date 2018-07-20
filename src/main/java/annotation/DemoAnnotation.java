package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试
 * 通过反射解析注解
 */
public class DemoAnnotation {

    public static void main(String[] args) {
        //1.使用类加载器加载类
        try {
            Class<?> mClass = Class.forName("annotation.PersonAnnotation");
            //2.找到类上面的注解
            boolean isExist = mClass.isAnnotationPresent(Despring.class);
            if (isExist) {
                // 3 拿到注解实例
                Despring annotation = mClass.getAnnotation(Despring.class);

                // 4 获取注解中的值
                System.out.println("描述 = " + annotation.age() + " 名称 = " + annotation.name() + " 年龄 = " + annotation.age());
            }

            //5.找到方法上的注解
            Method[] ms = mClass.getMethods();//得到类上的所有方法
            for (Method m : ms) {  //遍历
                boolean isExistMethod = m.isAnnotationPresent(Despring.class);
                if (isExistMethod) {

                    Despring annotation = m.getAnnotation(Despring.class);
                    System.out.println("描述1 = " + annotation.age() + " 名称 = " + annotation.name() + " 年龄 = " + annotation.age());
                }
            }

            //6.另一种解析方法

            for (Method m:ms){
                Annotation[] anns=m.getAnnotations();
                for (Annotation a:anns){
                    if (a instanceof Despring){
                        Despring annotation = (Despring) a;
                        System.out.println("描述2 = " + annotation.age() + " 名称 = " + annotation.name() + " 年龄 = " + annotation.age());
                    }
                }
            }


            Field field = PersonAnnotation.class.getDeclaredField("age");//获取成员变量value
            Field fieldName = PersonAnnotation.class.getDeclaredField("name");//获取成员变量value
            field.setAccessible(true);//将value设置成可访问的
            fieldName.setAccessible(true);//将value设置成可访问的
            if(field.isAnnotationPresent(Despring.class)){//判断成员变量是否有注解
                Despring myAnnotation = field.getAnnotation(Despring.class);//获取定义在成员变量中的注解Despring
                int valueAge = myAnnotation.age();//获取定义在PersonAnnotation的Despring里面属性值
                String valueName = myAnnotation.name();//获取定义在PersonAnnotation的Despring里面属性值
                PersonAnnotation personAnnotation = new PersonAnnotation();
                field.setInt(personAnnotation, valueAge);//将注解的值28可以赋给成员变量value
//                fieldName.setChar(personAnnotation, valueName);//将注解的值28可以赋给成员变量value
                System.out.println("数据 = " + personAnnotation);//验证结果
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("异常 = " + e);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

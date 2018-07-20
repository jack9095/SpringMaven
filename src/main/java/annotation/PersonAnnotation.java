package annotation;

/**
 * 使用注解
 */
public class PersonAnnotation {

    @Despring(desc = "假如生活欺骗了你----> 普希金", name = "北京")
    private String name;

    @Despring(age = 28)
    private int age;

    @Override
    public String toString() {
        return "PersonAnnotation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package annotation.demo;

@MyAnnotation
public class ChildPerson implements BasePerson{

    @Override
    @MyAnnotation(name = "北京")
    public void name() {

    }

    @Override
    @MyAnnotation(desc = "相见不如怀念")
    public void say() {

    }

    @Override
    @MyAnnotation(age = 90)
    public void age() {

    }
}

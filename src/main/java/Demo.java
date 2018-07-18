import com.stuspring.Car;
import com.stuspring.HelloWord;
import com.stuspring.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args){
        HelloWord helloWord = new HelloWord();
        helloWord.setName("枫丹白露");
        helloWord.sayHello();

        //1.创建IOC容器对象
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        //2.从IOC容器中获取对象
        HelloWord hw2= (HelloWord) ctx.getBean("hw2");
        //3.调用sayHello方法
        hw2.sayHello();

        Car car= (Car) ctx.getBean("car1");
        System.out.println(car.toString());

        Person person = (Person) ctx.getBean("person");
        System.out.println(person.toString());

        Person person1 = (Person) ctx.getBean("person1");
        System.out.println(person1.toString());
    }
}

package jdbc.bean;

import jdbc.bean.IStudentDao;
import jdbc.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 插入、更新、删除、查询 （每一个单独执行）
 */
public class TestJDBC {

    private ApplicationContext ctx = null;
    JdbcTemplate jdbcTemplate;
    {
        ctx = new ClassPathXmlApplicationContext("beans_jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

//    @Test//增
//    public void demo1() {
//        Student student = new Student();
//        student.setPhone("18868870989");
//        student.setSex("nn");
//        student.setName("beijing");
//        IStudentDao dao = (IStudentDao) ctx.getBean("studentDao");
//        dao.addStudent(student);
//    }

//    @Test//改
//    public void demo2() {
//        Student student1 = new Student();
//        student1.setPhone("18868870988");
//        student1.setSex("nz");
//        student1.setName("东京");
//        IStudentDao dao = (IStudentDao) ctx.getBean("studentDao");
//        dao.addStudent(student1);
//    }

//    @Test//查（简单查询，返回字符串）
//    public void demo4() {
//        IStudentDao dao = (IStudentDao) ctx.getBean("studentDao");
//        String name = dao.findName("18868870989");
//        System.out.println("查询名称 = "+name);
//    }
//
//    @Test//查（简单查询，返回对象）
//    public void demo5() {
//        IStudentDao dao = (IStudentDao) ctx.getBean("studentDao");
//        Student student = dao.findStudent("18072850706");
//        System.out.println("查询对象对应的名称 = " + student.getName());
//    }
//
//    @Test//删
//    public void demo3() {
//        IStudentDao dao = (IStudentDao) ctx.getBean("studentDao");
//        dao.deleteStudent("18868870988");
//    }
//
    @Test//查（复杂查询，返回对象集合）
    public void demo6() {
        IStudentDao dao = (IStudentDao) ctx.getBean("studentDao");
        List<Student> students = dao.findAll();
        System.out.println("返回数据集合大小 = "+students.size());
    }
}

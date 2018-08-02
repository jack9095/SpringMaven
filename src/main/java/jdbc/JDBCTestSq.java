package jdbc;

import jdbc.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 参考模版（测试、有错误、将来改）
 */
public class JDBCTestSq {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("beans_jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    public void TestDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    /**
     *更新属性
     */
    @Test
    public void updateTest() {
        String sql = "UPDATE student SET name = ? WHERE sid = ?";
        jdbcTemplate.update(sql, "神乐", 2);
    }

    /**
     *插入数据
     */
    @Test
    public void insertTest() {
        String sql = "INSERT student(name,sex) values('Tonny','123456')";
        jdbcTemplate.execute(sql);
    }

    /**
     *删除记录
     */
    @Test
    public void deleteTest() {
        String sql = "DELETE FROM student where sid = ?";
        jdbcTemplate.update(sql, 3);
    }

    /**
     *批量插入
     */
    @Test
    public void batchUpdateTest() {
        String sql = "INSERT INTO student(name,sex) values(?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"Tina", "876543"});
        batchArgs.add(new Object[]{"Judy", "587641"});
        batchArgs.add(new Object[]{"Sam", "987632"});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     *查询
     */

    @Test
    public void queryForObject() {
        String sql = "SELECT sid AS id,name AS userName,sex AS passWord " +
                "FROM student WHERE sid = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        Student user = (Student) jdbcTemplate.queryForObject(sql, rowMapper, 2);
        System.out.println(user);
    }


    /**
     *批量查询
     */
    @Test
    public void queryForList() {
        String sql = "SELECT sid AS id,name AS userName,sex AS passWord FROM student WHERE sid > ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> users = jdbcTemplate.query(sql, rowMapper, 3);
        System.out.println(users);
    }


    /**
     *统计
     */
    @Test
    public void countTest() {
        String sql = "SELECT COUNT(*) FROM student";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

}

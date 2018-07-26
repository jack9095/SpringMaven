package jdbc;

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

public class JDBCTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("beans_jdbc.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

//    /**
//     *
//     * @throws SQLException
//     */
//    @Test
//    public void TestDataSource() throws SQLException {
//        DataSource dataSource = ctx.getBean(DataSource.class);
//        System.out.println(dataSource.getConnection());
//    }
//
//    /**
//     *更新属性
//     */
//    @Test
//    public void updateTest() {
//        String sql = "UPDATE user SET username = ? WHERE uid = ?";
//        jdbcTemplate.update(sql, "神乐", 2);
//    }
//
//    /**
//     *插入数据
//     */
//    @Test
//    public void insertTest() {
//        String sql = "INSERT user(username,password) values('Tonny','123456')";
//        jdbcTemplate.execute(sql);
//    }
//
//    /**
//     *删除记录
//     */
//    @Test
//    public void deleteTest() {
//        String sql = "DELETE FROM user where uid = ?";
//        jdbcTemplate.update(sql, 3);
//    }
//
//    /**
//     *批量插入
//     */
//    @Test
//    public void batchUpdateTest() {
//        String sql = "INSERT INTO user(username,password) values(?,?)";
//        List<Object[]> batchArgs = new ArrayList<Object[]>();
//        batchArgs.add(new Object[]{"Tina", "876543"});
//        batchArgs.add(new Object[]{"Judy", "587641"});
//        batchArgs.add(new Object[]{"Sam", "987632"});
//        jdbcTemplate.batchUpdate(sql, batchArgs);
//    }
//
//    /**
//     *查询
//     */
//
//    @Test
//    public void queryForObject() {
//        String sql = "SELECT uid AS id,username AS userName,password AS passWord " +
//                "FROM user WHERE uid = ?";
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
//        User user = (User) jdbcTemplate.queryForObject(sql, rowMapper, 2);
//        System.out.println(user);
//    }
//
//
//    /**
//     *批量查询
//     */
//    @Test
//    public void queryForList() {
//        String sql = "SELECT uid AS id,username AS userName,password AS passWord FROM user WHERE uid > ?";
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
//        List<User> users = jdbcTemplate.query(sql, rowMapper, 3);
//        System.out.println(users);
//    }
//
//
//    /**
//     *统计
//     */
//    @Test
//    public void countTest() {
//        String sql = "SELECT COUNT(*) FROM user";
//        long count = jdbcTemplate.queryForObject(sql, Long.class);
//        System.out.println(count);
//    }


    @Test//增
    public void demo1() {
        User user = new User();
        user.setUid(3);
        user.setUsername("admin");
        user.setPassword("123456");

        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");
        dao.addUser(user);
    }

    @Test//改
    public void demo2() {
        User user = new User();
        user.setUid(1);
        user.setUsername("admin");
        user.setPassword("admin");

        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");
        dao.updateUser(user);
    }

    @Test//删
    public void demo3() {
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");
        dao.deleteUser(3);
    }

    @Test//查（简单查询，返回字符串）
    public void demo4() {
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");
        String name = dao.searchUserName(1);
        System.out.println(name);
    }

    @Test//查（简单查询，返回对象）
    public void demo5() {
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");
        User user = dao.searchUser(1);
        System.out.println(user.getUsername());
    }

    @Test//查（复杂查询，返回对象集合）
    public void demo6() {
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");
        List<User> users = dao.findAll();
        System.out.println(users.size());
    }
}

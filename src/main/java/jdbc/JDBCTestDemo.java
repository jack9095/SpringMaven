package jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 最简单测试，不需要xml配置
 */
public class JDBCTestDemo {

    @Test
    public void test(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Fly");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("CREATE TABLE TEACHER(id INT PRIMARY KEY,name VARCHAR(32))");
    }
}

package jdbc.bean;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl extends JdbcDaoSupport implements IStudentDao{

    @Override
    public void addStudent(Student student) {
        String insert = "insert into student values(?,?,?)";
        this.getJdbcTemplate().update(insert, student.getName(), student.getSex(), student.getPhone());
    }

    @Override
    public void updateStudent(Student student) {
        String update = "update student set name=?,sex=? where phone=?";
        this.getJdbcTemplate().update(update,student.getName(),student.getSex(),student.getPhone());
    }

    @Override
    public void deleteStudent(String phone) {
        String delete = "delete from student where phone=?";
        this.getJdbcTemplate().update(delete,phone);
    }

    @Override
    public String findName(String phone) {
        String findName = "select name from student where phone=?";
        return this.getJdbcTemplate().queryForObject(findName, String.class ,phone);
    }

    @Override
    public Student findStudent(String phone) {
        String find = "select * from student where phone=?";
        return this.getJdbcTemplate().queryForObject(find,new StudentRowMapper(),phone);
    }

    @Override
    public List<Student> findAll() {
        String findAll = "select * from student";
        return this.getJdbcTemplate().query(findAll, new StudentRowMapper());
    }

    class StudentRowMapper implements RowMapper<Student> { //rs为返回结果集，以每行为单位封装着

        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

            Student student = new Student();
//            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSex(rs.getString("sex"));
            student.setPhone(rs.getString("phone"));
            return student;
        }

    }
}

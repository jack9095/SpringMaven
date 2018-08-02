package jdbc.bean;

import java.util.List;

public interface IStudentDao {

    /**
     * 添加一组数据
     * @param student
     */
    void addStudent(Student student);

    /**
     * 根据手机号更新数据
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 根据手机号删除一组数据
     * @param phone
     */
    void deleteStudent(String phone);

    /**
     * 根据手机号查询一行数据
     * @param phone
     * @return
     */
    Student findStudent(String phone);

    /**
     * 查询全部数据
     * @return
     */
    List<Student> findAll();

    /**
     * 根据手机号获取名称
     * @param phone
     * @return
     */
    String findName(String phone);
}

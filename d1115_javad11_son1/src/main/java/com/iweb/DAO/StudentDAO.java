package com.iweb.DAO;

import com.iweb.entity.Student;

import java.util.List;

/**提供学生类的基本的CRUD 以及模糊查询和分页查询
 * @author wmn
 * @date 2023/11/14 19:44
 */
public interface StudentDAO {
    /**向数据库插入学生数据
     * @param student 包含除id外所有学生表需要的字段值
     */
    void insert(Student student);

    /**根据id删除指定学生的数据
     * @param id 学生的主键id 如果id==null或值小于等于0 则无效
     */
    void delete(Integer id);

    /**根据学生id 进行所有字段值的修改 暂不支持动态字段
     * @param student id用于做修改条件 其他字段作为修改值
     */
    void update(Student student);

    /**默认查询所有学生的信息
     * @return 返回查询到的学生对象集合 如果集合为空 意味着表中没有数据
     */
    List<Student> listAll();

    /**根据提供的key 进行模糊查询
     * @param key 模糊查询的关键字
     * @return 根据模糊查询返回的查询结果 如果没有查询到 集合为null
     */
    List<Student> listByNameLike(String key);

    /**根据提供的参数 对学生信息进行limit分页查询
     * @param start limit的第一个参数 代表截取第几行的下一行
     * @param count limit的第二个参数 代表截取几行
     * @return 分页查询的返回结果 如果没有查询到 返回null
     */
    List<Student> listByPage(Integer start, Integer count);

    /** 根据提供关键字key 对学生信息进行分页模糊查询
     * @param key 模糊查询的关键字
     * @param start limit的第一个参数 代表截取第几行的下一行
     * @param count limit的第二个参数 代表截取几行
     * @return 分页模糊查询的返回结果 如果没有查询到 返回null
     */
    List<Student> listByPage(String key, Integer start, Integer count);

    /**
     *
     */
    void testInsert();

    /** 查询包括成绩的对应id的学生记录
     * @param id 查询的关键字
     * @return 查询的结果
     */
    Student listByIdWithGrade(Integer id);

    /** 查询所有学生包括成绩的记录
     * @return 查询到的所有学生记录集合 包括成绩
     */
    List<Student> listAllWithGrade();

    /** 所有学生包括成绩的分页查询
     * @param start limit的第一个参数 代表截取第几行的下一行
     * @param count limit的第二个参数 代表截取几行
     * @return 分页模糊查询的返回结果 如果没有查询到 返回null
     */
    List<Student> listAllWithGrade(int start,int count);
}

package com.iweb.test;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.StudentDAOImpl;
import com.iweb.entity.Student;

/**
 * @author wmn
 * @date 2023/11/14 18:32
 */
public class TestJDBC {
    public static void main(String[] args) {
        // try(Connection c = DBUtil.getConnection();
        //     Statement s =c.createStatement()){
        //     String sql = "INSERT INTO student(NAME,gender,birthday,address,qqnumber)\n"+
        //     "VALUES('朱燕男','男','2002-2-23','苏州',10001)";
        //     s.execute(sql);
        // }catch(SQLException e){
        //     e.printStackTrace();
        // }
        // StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.delete(7);
        Student s = new Student();
        // s.setName("李宇航");
        // s.setAddress("南京工业大学xxxx");
        // s.setGender("男");
        // s.setQqnumber(110);
        // s.setBirthday(new Date());
        // StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.insert(s);
        // s.setName("李小头");
        // s.setAddress("南京工业大学xxxx");
        // s.setGender("女");
        // s.setQqnumber(119);
        // s.setBirthday(new Date());
        // s.setId(1);
        StudentDAO studentDAO = new StudentDAOImpl();
        // studentDAO.update(s);
        // System.out.println(studentDAO.listByNameLike("李"));
        // studentDAO.testInsert();
        System.out.println(studentDAO.listAllWithGrade());
    }

}

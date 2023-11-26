package com.iweb.DAO.impl;

import com.iweb.DAO.GradeDAO;
import com.iweb.DAO.StudentDAO;
import com.iweb.DBUtil;
import com.iweb.entity.Grade;
import com.iweb.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/14 20:04
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void insert(Student student) {
        // String sql = "insert into student(NAME,gender,birthday,address,qqnumber) values('"
        //         +student.getName()+"','"+student.getGender()+"','"+new SimpleDateFormat("yyyy-MM-DD").format(student.getBirthday())+
        //         "','"+student.getAddress()+"',"+student.getQqnumber()+")";
        // try (Connection c = DBUtil.getConnection();
        //     Statement s = c.createStatement()){
        //     s.execute(sql);
        // }catch (SQLException e){
        //     e.printStackTrace();
        // }
        // statement存在几种弊端
        // 1. 参数较多时 拼接比较恶心
        // 2. statement先传参 再编译 性能较差
        // 3. statement 存在SQL注入攻击的问题
        // PrepareStatement
        // 1.参数传递简单 方法调用传递即可
        // 2. 先编译 再传参 性能更好
        // 3. 不存在SQL注入攻击的问题 再参数传入之前 语句就已经编译确定了
        // 传递的参数只会被当作参数处理
        String sql = "insert into student(NAME,gender,birthday,address,qqnumber)"+
                "values(?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)
             ){
            //使用方法进行传参 用序号代表参数问号的位置 这里是java为数不多基1的参数传递
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3, new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setLong(5,student.getQqnumber());
            ps.execute();
            //在执行完插入语句之后，mysql会为新增的数据分配一个自增长的id
            //jdbc可以通过getGeneratedKeys方法获取id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                student.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    //没写 c.setAutoCommit(false)
    //所有的dml语句都是默认自动commit 不需要进行事务管理
    //如果写了 c.setAutoCommit(false) 需要在方法的最后手动使用
    //c.commit进行提交 也可以在catch中 在发生异常
    //c.savepoint()和c.rollback进行存档或回滚
    @Override
    public void delete(Integer id) {
        String sql = "delete from student where id = "+id;
        try(Connection c = DBUtil.getConnection();
            Statement s = c.createStatement()
            ) {
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void testInsert() {
        String sql = "insert into student values(?,?,?,?,?,?)";
        Connection c = null;
        try {
            c = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try(
            PreparedStatement ps = c.prepareStatement(sql)){
            //关闭事务自动提交
            c.setAutoCommit(false);
            Random r = new Random();
            for (int i = 0; i < 10000; i++) {
                ps.setInt(1,r.nextInt(200)+10);
                ps.setString(2,"学生"+i);
                ps.setString(3,"男");
                ps.setDate(4,new Date(new java.util.Date().getTime()));
                ps.setString(5,"南京");
                ps.setLong(6,r.nextInt(1000000)+10000);
                ps.execute();
            }
            c.commit();
        }catch (SQLException e){
            try {
                System.out.println("插入发生错误，事务自动回滚");
                c.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Student listByIdWithGrade(Integer id) {
        String sql = "select * from student where id = ?";
        Student stu = new Student();
        GradeDAOImpl g = new GradeDAOImpl();
        try (Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setGender(rs.getString("gender"));
                stu.setBirthday(rs.getDate("birthday"));
                stu.setAddress(rs.getString("address"));
                stu.setQqnumber(rs.getLong("qqnumber"));
                stu.setGrades(g.listBySid(rs.getInt("id")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return stu;
    }

    @Override
    public List<Student> listAllWithGrade() {
        return listAllWithGrade(0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listAllWithGrade(int start, int count) {
        List<Student> stus = listByPage(null,start,count);
        GradeDAOImpl g = new GradeDAOImpl();
        for (Student s:stus
             ) {
            List<Grade> grades = g.listBySid(s.getId());
            s.setGrades(grades);
        }
        return stus.isEmpty()?null:stus;

    }

    @Override
    public void update(Student student) {
        String sql = "update student set name = ?,gender =?,birthday =?,address = ?,qqnumber = ? when id = ?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,student.getName());
            ps.setString(2,student.getGender());
            ps.setDate(3,new Date(student.getBirthday().getTime()));
            ps.setString(4,student.getAddress());
            ps.setLong(5,student.getQqnumber());
            ps.setInt(6,student.getId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> listAll() {

        return listByPage(null,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listByNameLike(String key) {
        // List<Student> stus = new ArrayList<>();
        // String sql;
        // if(key==null||key==""){
        //     sql = "select * from student limit ?,?";
        // }else{
        //     sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        // }
        // try (Connection c = DBUtil.getConnection();
        //     PreparedStatement ps = c.prepareStatement(sql)){
        //     if(key==null||key==""){
        //         ps.setInt(1,0);
        //         ps.setInt(2,Integer.MAX_VALUE);
        //     }else {
        //         ps.setString(1,key);
        //         ps.setInt(2,0);
        //         ps.setInt(3,Integer.MAX_VALUE);
        //     }
        //     ResultSet rs = ps.executeQuery();
        //     while (rs.next()){
        //         Student s = new Student();
        //         //从结果集遍历的当前行中 将每一个字段的值单独取出
        //         Integer id = rs.getInt("id");
        //         String name = rs.getString("name");
        //         String gender = rs.getString("gender");
        //         Date birthday = rs.getDate("birthday");
        //         String address = rs.getString("address");
        //         Long qqnumber = rs.getLong("qqnumber");
        //         s.setId(id);
        //         s.setName(name);
        //         s.setGender(gender);
        //         s.setBirthday(birthday);
        //         s.setAddress(address);
        //         s.setQqnumber(qqnumber);
        //         stus.add(s);
        //     }
        // }catch (SQLException e){
        //     e.printStackTrace();
        // }
        // return stus.isEmpty()?null:stus;
        return listByPage(key,0,Integer.MAX_VALUE);
    }

    @Override
    public List<Student> listByPage(Integer start, Integer count) {
        return listByPage(null,start,count);
    }

    @Override
    public List<Student> listByPage(String key, Integer start, Integer count) {
        List<Student> stus = new ArrayList<>();
        String sql;
        if(key==null||key==""){
            sql = "select * from student limit ?,?";
        }else{
            sql = "select * from student where name like concat('%',?,'%') limit ?,?";
        }
        try(Connection c =DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            if(key==null||key==""){
                ps.setInt(1,start);
                ps.setInt(2,count);
            }else {
                ps.setString(1,key);
                ps.setInt(2,start);
                ps.setInt(3,count);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student();
                //从结果集遍历的当前行中 将每一个字段的值单独取出
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setBirthday(rs.getDate("birthday"));
                s.setAddress(rs.getString("address"));
                s.setQqnumber(rs.getLong("qqnumber"));
                stus.add(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stus.isEmpty()?null:stus;
    }
}

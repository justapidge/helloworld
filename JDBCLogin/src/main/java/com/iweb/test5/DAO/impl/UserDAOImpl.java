package com.iweb.test5.DAO.impl;

import com.iweb.test5.DAO.UserDAO;
import com.iweb.test5.entity.User;
import com.iweb.test5.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/16 17:27
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void insert(User user) {
        String sql = "insert into user(name,pwd)"+
                "values(?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)
        ){
            //使用方法进行传参 用序号代表参数问号的位置 这里是java为数不多基1的参数传递
            ps.setString(1,user.getName());
            ps.setString(2, user.getPwd());
            ps.execute();
            //在执行完插入语句之后，mysql会为新增的数据分配一个自增长的id
            //jdbc可以通过getGeneratedKeys方法获取id
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,pwd =? when id = ?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,user.getName());
            ps.setString(2, user.getPwd());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                users.add(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return users.isEmpty()?null:users;
    }

    @Override
    public User listByName(String name) {
        User user = new User();
        String sql = "select * from user where name = ?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}

package com.iweb.test5.DAO;

import com.iweb.test5.entity.User;

import java.util.List;

/**
 * @author wmn
 * @date 2023/11/16 16:59
 */
public interface UserDAO {
    /** 向数据库插入用户数据
     * @param user 包含除id外所有用户表需要的字段值
     */
    void insert(User user);

    /** 根据用户id 进行所有字段值的修改
     * @param user id用于做修改条件 其他字段作为修改值
     */
    void update(User user);

    /** 默认查询所有用户的信息
     * @return 返回查询到的用户对象集合 如果集合为空 意味着表中没有数据
     */
    List<User> listAll();

    /** 根据用户名查询用户信息
     * @param name 查询的条件
     * @return 对应的用户信息 包括用户名和密码
     */
    User listByName(String name);
}

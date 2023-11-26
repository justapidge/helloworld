package com.iweb;

import com.iweb.DAO.StudentDAO;
import com.iweb.DAO.impl.StudentDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wmn
 * @date 2023/11/15 20:41
 */
public class JDBCTest1 {
    private StudentDAO studentDAO;

    //在其他测试方法运行之前 被该注解修饰的方法会自动执行
    @Before
    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    @Test
    public void testListAllWithGrade() {
        Assert.assertNull(
                studentDAO.listByNameLike("管"));
    }

    @Test
    public void testListAll() {
        System.out.println(studentDAO.listAll());
    }

    @After
    public void destroy() {
        System.out.println("在这个代码中进行资源销毁或对象处理");
    }
}
package com.iweb.test5.service;




import com.iweb.test5.DAO.UserDAO;
import com.iweb.test5.DAO.impl.UserDAOImpl;
import com.iweb.test5.entity.User;

import java.util.Iterator;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/10 15:04
 */
public class Service {

    public static boolean login(User inputUser) {
        boolean flag = false;
        //获取Data的数据
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.listAll();
        Iterator<User> it = users.iterator();
        loop:while (it.hasNext()){
            User user = it.next();
            if(user.equals(inputUser)){
                flag = true;
                break loop;
            }
        }
        return flag;
    }
    public static boolean register(User inputUser) {
        boolean flag = false;
        //获取Data的数据
        UserDAO userDAO = new UserDAOImpl();
        List<User> users = userDAO.listAll();
        Iterator<User> it = users.iterator();
        loop:while (it.hasNext()){
            User user = it.next();
            if(user.equals(inputUser)){
                flag = true;
                break loop;
            }
        }
        if(!flag){
            userDAO.insert(inputUser);
        }
        return flag;
    }
}

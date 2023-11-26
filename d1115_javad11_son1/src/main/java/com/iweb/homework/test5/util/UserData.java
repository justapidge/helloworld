package com.iweb.homework.test5.util;

import com.iweb.homework.test5.entity.User;

import java.util.HashMap;
import java.util.Map;

/**用于提供给登录 注册业务所需的数据 无jdbc 用于模拟数据库数据
 * @author wmn
 * @date 2023/11/10 14:18
 */
public class UserData {
    /**
     * 在用户登录成功之后 将用户的引用传递给该属性 后续如果需要访问当前登录的用户信息 直接访问该静态变量即可
     */
    public static User cruuentloginUser;
    public static Map<String,String> map = new HashMap<>();

    static {
        for (int i = 0;i<5;i++){
            map.put("user"+i,"123456");
        }
    }




}

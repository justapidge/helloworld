package com.iweb.homework.test5.service;


import com.iweb.homework.test5.entity.User;
import com.iweb.homework.test5.util.UserData;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author wmn
 * @date 2023/11/10 15:04
 */
public class Service {

    public static boolean login(User inputUser) {
        boolean flag = false;
        //获取Data的数据
        Set<Map.Entry<String,String>> entrySet =UserData.map.entrySet();
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        loop:while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            User user = new User();
            user.setName(entry.getKey());
            user.setPwd(entry.getValue());
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
        Set<Map.Entry<String,String>> entrySet =UserData.map.entrySet();
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        loop:while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            User user = new User();
            user.setName(entry.getKey());
            user.setPwd(entry.getValue());
            if(user.equals(inputUser)){
                flag = true;
                break loop;
            }
        }
        if(!flag){
            UserData.map.put(inputUser.getName(),inputUser.getPwd());
        }
        return flag;
    }
}

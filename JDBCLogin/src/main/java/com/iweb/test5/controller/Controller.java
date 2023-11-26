package com.iweb.test5.controller;


import com.iweb.test5.Test;
import com.iweb.test5.entity.User;
import com.iweb.test5.service.Service;
import com.iweb.test5.util.PrintUtil;

/**
 * @author wmn
 * @date 2023/11/10 14:54
 */
public class Controller {
    public static void mainController(String key){
        switch (key){
            case "1":
                User inputUser = Test.loginView();
                boolean login = Service.login(inputUser);
                if(login){
                    //跳转到下一步视图
                    Test.userInfoView();

                }else {
                    PrintUtil.log("用户名或密码有误，请重新输入");
                    Test.mainView();

                }
                break;
            case "2":
                User inputUser1 =Test.registerView();
                boolean register = Service.register(inputUser1);
                if(register){
                    PrintUtil.log("用户名或密码有误，请重新输入");
                    Test.registerView();
                }else {
                    PrintUtil.log("注册成功");
                    Test.mainView();
                }
                break;
        }
    }
}

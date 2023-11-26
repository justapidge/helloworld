package com.iweb.test5;



import com.iweb.test5.controller.Controller;
import com.iweb.test5.entity.User;
import com.iweb.test5.util.PrintUtil;

import java.util.Scanner;

/**基于之前的用户登录进行修改 实现登录和注册 我们之前的数据是存放在List集合的
 现在希望你将用户的用户名和密码存放在某一个指定文本中
 规定文本中一行存储一个用户名和密码
 当登录的时候 使用缓存流遍历文本 比对用户名和密码
 注册的时候 则通过缓存流在文本末尾添加新的用户名和密码 注意
 注册需要避免用户名重复的问题
 * @author wmn
 * @date 2023/11/14 9:34
 */
public class Test {

        static Scanner sc = new Scanner(System.in);
        public static void mainView(){
            PrintUtil.log("登录系统");
            PrintUtil.log("---------------------");
            PrintUtil.log("请输入要操作的业务");
            PrintUtil.log("1.登录");
            PrintUtil.log("2.注册");
            String inputKey = sc.nextLine();

            Controller.mainController(inputKey);
        }
        public static User loginView(){
            PrintUtil.log("请输入用户名：");
            String inputUsername = sc.nextLine();
            PrintUtil.log("请输入密码：");
            String inputUserPwd = sc.nextLine();
            //对输入的数据进行封装
            User inputUser = new User();
            inputUser.setName(inputUsername);
            inputUser.setPwd(inputUserPwd);
            return inputUser;
        }
    public static User registerView(){
        PrintUtil.log("请输入用户名：");
        String inputUsername = sc.nextLine();
        PrintUtil.log("请输入密码：");
        String inputUserPwd = sc.nextLine();
        //对输入的数据进行封装
        User inputUser = new User();
        inputUser.setName(inputUsername);
        inputUser.setPwd(inputUserPwd);
        return inputUser;
    }
        public static void userInfoView(){
            PrintUtil.log("输入操作功能序号");
            PrintUtil.log("1.查看用户信息");
            PrintUtil.log("2.修改用户信息");
            //后续调用
        }

        public static void main(String[] args) {
            mainView();

        }
    }


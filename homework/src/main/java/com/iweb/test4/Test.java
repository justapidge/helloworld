package com.iweb.test4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/21 19:48
 */
public class Test {
    public static String strPool = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    public static StringBuilder usedPwd = new StringBuilder();
    public static StringBuilder pwd = new StringBuilder();
    public static List<StringBuilder> pwdList = new ArrayList<>();
    public static boolean flag =false;

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            pwd = pwd.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        System.out.println(pwd);
        Thread crack = new Thread(){

            @Override
            public void run() {
                loop:while (true){
                StringBuilder testPwd = new StringBuilder();
                    for (int i = 0; i < 3; i++) {
                        testPwd = testPwd.append(strPool.charAt(r.nextInt(strPool.length())));
                    }
                    pwdList.add(testPwd);
                    if(testPwd.toString().equals( pwd.toString())){
                        System.out.println("成功");
                        flag = true;
                        break loop;
                    }
                }
            }
        };
        Thread log = new Thread(){
            @Override
            public void run() {
                if(pwdList.isEmpty()){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0;i<pwdList.size();i++){
                    System.out.print(pwdList.get(i)+"\t");
                }
            }
        };
        log.setDaemon(true);
        crack.start();
        log.start();
    }
}

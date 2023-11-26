package com.iweb.work;

import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/19 11:00
 */
public class MaBaoGuo {
    volatile public static String skill = "";
    public static void main(String[] args) {
        Thread maBaoGuo = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    skill = "接";
                    System.out.println(skill);
                    try {
                        Thread.sleep(1000);
                        System.out.println("技能CD");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    skill = "化";
                    System.out.println(skill);
                    try {
                        Thread.sleep(1000);
                        System.out.println("技能CD");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    skill = "发";
                    System.out.println(skill);
                    try {
                        Thread.sleep(1000);
                        System.out.println("技能CD");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    skill = "闪电五连鞭!";
                    System.out.println(skill);
                    try {
                        Thread.sleep(2000);
                        System.out.println("技能CD");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread marble = new Thread(){
            Random r = new Random();
            @Override
            public void run() {

                while(true) {
                    if (r.nextInt(100) < 90) {
                        skill = "大理石左刺拳";
                        System.out.println(skill);
                        break;
                    }
                }
            }
        };
        maBaoGuo.setDaemon(true);
        maBaoGuo.run();
        marble.run();
    }
}

package com.iweb.test;

import org.junit.Test;

/**
 * @author wmn
 * @date 2023/11/19 9:06
 */
public class ThreadTest {
    public static void main(String[] args) {
        // //通过Runnable接口完成线程对象实例化的时候 需要借助Thread类完成实例化
        // FuckRice fr1 = new FuckRice();
        // Thread t1 =new Thread(fr1);
        // FuckRice fr2 = new FuckRice();
        // Thread t2 = new Thread(fr2);
        // t1.setName("李宇航");
        // t2.setName("朱燕楠");
        // t1.start();
        // t2.start();
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("上课不启动了" + this.getName());
                }
            }
        };
        t1.setName("sxl");
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("上课就启动" + this.getName());
                }
            }
        };
        t2.setName("lyh");
        System.out.println(t1.getClass().getName());
        System.out.println(t2.getClass().getName());
        t1.start();
        t2.start();
    }
}

package com.iweb.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/19 14:31
 */
public class Test {
    public static void main(String[] args) {
        Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(10000);
        int n = 10000;
        List<Thread> addThread = new ArrayList<>();
        List<Thread> reduceThread = new ArrayList<>();
        //定义1w线程回血
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.heal();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread.add(t);
        }
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThread.add(t);
        }
        //最终在主线程中访问哥布林血量 必须保证 主线程等待两万个线程完成
        for (Thread t:
             addThread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t:
                reduceThread) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哥布林最终血量为"+goblin.getHp());
    }
}

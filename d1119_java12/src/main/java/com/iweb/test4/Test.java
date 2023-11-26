package com.iweb.test4;

import com.iweb.test4.Monster;

/**
 * @author wmn
 * @date 2023/11/19 15:35
 */
public class Test {
    public static void main(String[] args) {
        Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(500);
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    goblin.hurt();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    goblin.heal();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}

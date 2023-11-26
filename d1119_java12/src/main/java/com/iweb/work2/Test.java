package com.iweb.work2;

/**
 * @author wmn
 * @date 2023/11/19 15:58
 */
public class Test {
    public static void main(String[] args) {
        Print p = new Print();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    p.printA();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    p.printB();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

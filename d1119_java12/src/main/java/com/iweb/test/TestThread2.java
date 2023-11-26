package com.iweb.test;

/**
 * @author wmn
 * @date 2023/11/19 9:55
 */
public class TestThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1");

                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2");

                }
            }
        };

        t1.start();
        t2.start();
        try {
            // 代码执行到这一行的时候 都是主线程在运行
            // 在t1join了主线程之后 只有当t1线程的run方法完成之后 主线程才会继续运行
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t3");

                }
            }
        };
        t3.start();
    }
}

package com.iweb.test2;

/**
 * @author wmn
 * @date 2023/11/19 15:09
 */
public class Test1 {
    public static void main(String[] args) {
        //定义一个同步对象用来提供锁
        final Object o = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("t1线程运行");
                System.out.println("t1试图获取o对象锁");
                synchronized (o){
                    System.out.println("t1获取到o对象的锁");
                    try {
                        //线程在sleep的时候是不会释放锁的
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1准备释放o对象的锁");
                }
                System.out.println("线程t1运行结束");
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("t2线程运行");
                System.out.println("t2试图获取o对象锁");
                synchronized (o){
                    System.out.println("t2获取到o对象的锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2准备释放o对象的锁");
                }
                System.out.println("线程t2运行结束");
            }
        };
        t2.start();
        t1.start();
    }
}

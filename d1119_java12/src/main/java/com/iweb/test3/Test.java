package com.iweb.test3;

/**
 * @author wmn
 * @date 2023/11/19 15:21
 */
public class Test {
    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (o1){
                    System.out.println("t1获取o1的锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1试图获取o2锁");
                    System.out.println("t1被阻塞");
                    synchronized (o2){
                        System.out.println("t1获取o2锁");
                        System.out.println("t1释放o2锁");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (o2){
                    System.out.println("t2获取o2的锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2试图获取o1锁");
                    System.out.println("t2被阻塞");
                    synchronized (o1){
                        System.out.println("t2获取o1锁");
                        System.out.println("t2释放o1锁");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}

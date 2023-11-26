package com.iweb.homework.test29;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wmn
 * @date 2023/11/24 22:24
 */
public class Test {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 =new Thread(){
            @Override
            public void run() {
                System.out.println("t1获取锁");
                lock.lock();
                // try {
                //     Thread.sleep(5000);
                // } catch (InterruptedException e) {
                //     e.printStackTrace();
                // }finally {
                //     lock.unlock();
                //     System.out.println("t1释放锁");
                // }

            }
        };
        Thread t2 =new Thread(){
            @Override
            public void run() {
                while (true) {
                    System.out.println("t2尝试获取锁");
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2获取锁");
                    lock.unlock();
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

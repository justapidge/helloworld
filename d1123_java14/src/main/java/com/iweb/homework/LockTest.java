package com.iweb.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wmn
 * @date 2023/11/23 22:17
 */
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Method m = new Method();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    lock.lock();
                    m.add1();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            };
            thread.start();
            threadList.add(thread);
        }
        List<Thread> minusThreadList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    lock.lock();
                    m.minus1();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            };
            thread.start();
            minusThreadList.add(thread);
        }
        for (Thread t : threadList
        ) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t : minusThreadList
        ) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(m.getA());
    }
}

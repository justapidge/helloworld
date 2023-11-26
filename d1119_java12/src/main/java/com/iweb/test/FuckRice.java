package com.iweb.test;

/**
 * @author wmn
 * @date 2023/11/19 9:18
 */
public class FuckRice implements Runnable{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("别骂了，别骂了，来自"+Thread.currentThread().getName());
        }
    }
}

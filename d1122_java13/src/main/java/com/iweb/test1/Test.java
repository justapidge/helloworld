package com.iweb.test1;

/**
 * @author wmn
 * @date 2023/11/22 18:34
 */
public class Test {
    public static void main(String[] args) {
        //篮子 有一个线程负责向篮子里装馒头
        //其他线程负责向篮子里去馒头

        //创建篮子
        Basket bt = new Basket();
        Producer p = new Producer(bt);
        Consumer c = new Consumer(bt);
        //启动生产者
        new Thread(p).start();
        //给生产者事件装馒头
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动消费者
        new Thread(c).start();
    }
}

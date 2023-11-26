package com.iweb.test;

/**
 * @author wmn
 * @date 2023/11/19 9:42
 */
public class TestThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                double times = 0;
                while (true){
                    System.out.println("休眠10ms");
                    try {
                        Thread.sleep(10);
                        System.out.println("恢复");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    times += 0.01;
                    System.out.println("线程已经运行的时间"+times);
                }


            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    System.out.println("t2抢到了调度资源");
                }
            }
        };
        t1.start();
        t2.start();
    }


}

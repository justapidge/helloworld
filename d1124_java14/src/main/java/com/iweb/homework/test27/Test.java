package com.iweb.homework.test27;

/**
 * @author wmn
 * @date 2023/11/24 22:06
 */
public class Test {
    public static void main(String[] args) {
        Temp temp = new Temp();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    temp.plus1();
                }
            };
            t.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结果"+temp.num);
    }
}

package com.iweb.test1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/20 17:33
 */
public class Test {
    public static void main(String[] args) {
        Random r= new Random();
        Container container = new Container();
        for (int i = 0; i < 30; i++) {
            Thread t1 = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        int num = r.nextInt();
                        container.addNum(num);
                        System.out.println("插入" + num);
                    }
                }
            };
            t1.start();
        }
        for (int i = 0; i < 30; i++) {
            Thread t1 = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        int num = container.getNum();
                        System.out.println("取出" + num);
                    }
                }
            };
            t1.start();
        }
    }
}

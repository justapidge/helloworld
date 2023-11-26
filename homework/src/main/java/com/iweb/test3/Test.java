package com.iweb.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/21 18:54
 */
public class Test {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Thread kun = new Thread(){
            @Override
            public void run() {
                while (true){
                    basket.putAgg("蛋");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        kun.start();
        List<Thread> littleBlacks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread littleBlack = new Thread(){
                @Override
                public void run() {
                    while (true){
                        basket.deleteAgg();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            littleBlacks.add(littleBlack);
        }
        for (Thread littleBlack:littleBlacks
             ) {
            littleBlack.start();
        }
    }
}

package com.iweb.test;

/**
 * @author wmn
 * @date 2023/11/19 9:03
 */
public class FightRice extends Thread{
    public FightRice(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("饿了，吃，来自"+this.getName());
        }
    }
}

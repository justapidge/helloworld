package com.iweb.test3;

import lombok.Data;

import java.util.LinkedList;

/**
 * @author wmn
 * @date 2023/11/21 17:47
 */
@Data
public class Basket extends Thread{
    public static LinkedList<String> basketList;
    public Basket(){
        basketList = new LinkedList<>();
    }
    public synchronized void putAgg(String egg){
        if(basketList.size()==10){
            try {
                System.out.println("蛋满了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        basketList.add(egg);
        this.notifyAll();
        System.out.println("哥哥下蛋");
    }
    public synchronized void deleteAgg(){
        if(basketList.isEmpty()){
            try {
                System.out.println("哥哥没蛋了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        basketList.removeLast();
        this.notify();
        System.out.println("哥哥的蛋 get daze");

    }
}

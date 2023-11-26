package com.iweb.homework.test28;

/**
 * @author wmn
 * @date 2023/11/24 22:21
 */
public class Test {
    private String outPut;
    public synchronized void printA(){
        this.notify();
        outPut = "A";
        System.out.println(outPut);
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void printB(){
        this.notify();
        outPut = "B";
        System.out.println(outPut);
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

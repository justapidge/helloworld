package com.iweb.work2;

/**
 * @author wmn
 * @date 2023/11/19 16:01
 */
public class Print extends Thread{
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

package com.iweb.test1;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/20 18:57
 */
public class Container {
    LinkedList<Integer> list ;
    int length ;
    public Container(){
        list = new LinkedList<>();
        length = 20;
    }
    public synchronized void addNum(int num){
        this.notify();
        if(list.size()==20){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(num);
    }
    public synchronized int getNum(){
        this.notify();
        if(list.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list.removeLast();
    }
}

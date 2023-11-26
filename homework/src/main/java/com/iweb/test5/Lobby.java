package com.iweb.test5;

import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
@NoArgsConstructor
/**
 * @author wmn
 * @date 2023/11/21 20:50
 */
public class Lobby extends Thread{
    public LinkedList<String> list = new LinkedList<>();
    public synchronized void addQuest(){
        if(list.size()==20){
            try {
                System.out.println("任务列表满");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        String quest = "任务";
        list.add(quest);
        System.out.println("发布任务");
    }
    public synchronized void getQuest(){
        if(list.isEmpty()){
            try {
                System.out.println("任务列表空");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        list.removeLast();
        System.out.println("接取任务");
    }
}

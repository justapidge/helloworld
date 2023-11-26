package com.iweb.answer;

import lombok.Data;

/**
 * @author wmn
 * @date 2023/11/19 11:40
 */
@Data
public class TeacherMa extends Thread{
    private Marble marble;
    public void cd(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean check(){
        if (marble.getCount()<=10){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public void run() {
        loop:while (true) {
            System.out.println("接");
            cd(1000);
            if(check()){
                break loop;
            }
            System.out.println("化");
            cd(1000);
            if(check()){
                break loop;
            }
            System.out.println("发");
            cd(1000);
            if(check()){
                break loop;
            }
            System.out.println("闪电五连鞭");
            cd(2000);
            if(check()){
                break loop;
            }
        }
        System.out.println("耗子尾汁");
    }
}

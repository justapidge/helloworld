package com.iweb.answer;

import lombok.Data;

import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/19 11:40
 */
@Data
public class Marble extends Thread{
    private int count = 100;
    public void run(){
        Random r = new Random();
        while (true){
            count = r.nextInt(100)+1;
            if(count>10){
                System.out.println("偷袭");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

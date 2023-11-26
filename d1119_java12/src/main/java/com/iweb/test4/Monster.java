package com.iweb.test4;

import lombok.Data;

/**
 * @author wmn
 * @date 2023/11/19 14:27
 */
@Data
public class Monster {
    private String name;
    private float hp;
    public synchronized void heal(){
        //获取hp
        //hp+1
        //对hp赋值
        hp++;
        System.out.println("为："+name+"恢复了1点生命值，当前生命值为："+hp);
        this.notify();
    }
    public synchronized void hurt(){
        if(hp==1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp--;
        System.out.println("为："+name+"扣除了1点生命值，当前生命值为："+hp);
    }
}

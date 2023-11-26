package com.iweb.test2;

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
    }
    public void hurt(){
        synchronized (this) {
            hp--;
        }
    }
}

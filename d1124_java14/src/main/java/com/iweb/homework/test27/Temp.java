package com.iweb.homework.test27;

import lombok.Data;

/**
 * @author wmn
 * @date 2023/11/24 22:12
 */
@Data
public class Temp {
    public static int num;
    public Temp(){
        num = 0;
    }
    public void plus1(){
        synchronized (this) {

            num++;
            System.out.println(num);
        }
    }
}

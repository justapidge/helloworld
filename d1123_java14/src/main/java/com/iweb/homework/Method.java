package com.iweb.homework;

import lombok.Data;

/**
 * @author wmn
 * @date 2023/11/23 21:56
 */
@Data
public class Method {
    public int a;
    public Method(){
        a=0;
    }
    public  void add1(){
        System.out.println("a+1");
        a++;
    }
    public  void minus1(){
        System.out.println("a-1");
        a--;
    }
}

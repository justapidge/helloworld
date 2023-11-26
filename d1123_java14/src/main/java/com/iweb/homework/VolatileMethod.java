package com.iweb.homework;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wmn
 * @date 2023/11/23 22:42
 */
@Data
public class VolatileMethod {
    public volatile AtomicInteger a;
    public VolatileMethod(){
        a = new AtomicInteger(0);
    }
    public  void add1(){
        System.out.println("a+1");
        a.incrementAndGet();
    }
    public  void minus1(){
        System.out.println("a-1");
        a.decrementAndGet();
    }
}

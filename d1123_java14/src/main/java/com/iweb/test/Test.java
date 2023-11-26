package com.iweb.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wmn
 * @date 2023/11/23 16:05
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor
                        (10,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1");
            }
        });
        // showSeason(Season.SPRING);
    }
    // public static void showSeason(Season key){
    //     switch (key){
    //         case SPRING:
    //             System.out.println("复苏");
    //             break;
    //         case SUMMER:
    //             System.out.println("夏天");
    //             break;
    //         case AUTUMN:
    //             System.out.println("秋天");
    //             break;
    //         case WINTER:
    //             System.out.println("现在");
    //             break;
    //         default:
    //             System.out.println("error");
    //     }
    // }
}

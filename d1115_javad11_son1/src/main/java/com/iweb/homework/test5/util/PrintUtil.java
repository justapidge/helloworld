package com.iweb.homework.test5.util;

import java.util.Scanner;

/**
 * @author wmn
 * @date 2023/11/10 16:13
 */
public class PrintUtil {
    private static Scanner sc = new Scanner(System.in);
    public static void log(String message){
        if(message.isEmpty()){
            System.out.println();
        }else {
            for (int i = 0; i < message.length();i++) {
                System.out.print(message.charAt(i));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println();
    }
}

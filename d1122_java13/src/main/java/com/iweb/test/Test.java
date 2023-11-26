package com.iweb.test;

/**
 * @author wmn
 * @date 2023/11/22 18:30
 */
public class Test {
    public static synchronized void l(){

    }
    public static void l1() {
        synchronized (Test.class){

        }
    }
    public static void main(String[] args) {

    }
}

package com.iweb.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/23 22:41
 */
public class VolatileTest {
    public static void main(String[] args) {
        VolatileMethod vm = new VolatileMethod();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {

                        vm.add1();
                        // try {
                        //     Thread.sleep(100);
                        // } catch (InterruptedException e) {
                        //     e.printStackTrace();
                        // }

                }
            };
            thread.start();
            threadList.add(thread);
        }
        List<Thread> minusThreadList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                        vm.minus1();
                        // try {
                        //     Thread.sleep(100);
                        // } catch (InterruptedException e) {
                        //     e.printStackTrace();
                        // }
                }
            };
            thread.start();
            minusThreadList.add(thread);
        }
        for (Thread t:threadList
        ) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t:minusThreadList
        ) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(vm.getA());
    }
}

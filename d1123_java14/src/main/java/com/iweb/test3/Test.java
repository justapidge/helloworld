package com.iweb.test3;

/**
 * @author wmn
 * @date 2023/11/23 20:13
 */
public class Test {
    public static void main(String[] args) {
        Lyh ldt = new Lyh();
        ldt.start();
        while (true){
            synchronized (ldt) {
                if (ldt.isFlag()) {
                    System.out.println("发现flag值变化");
                    break;
                }
            }
        }
    }
}

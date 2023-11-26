package com.iweb.answer;

/**
 * @author wmn
 * @date 2023/11/19 11:51
 */
public class Test {
    public static void main(String[] args) {
        Marble marble = new Marble();
        TeacherMa mbg = new TeacherMa();
        mbg.setMarble(marble);
        marble.setDaemon(true);
        mbg.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        marble.start();
    }
}

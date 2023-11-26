package com.iweb.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/21 20:28
 */
public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        Lobby lobby = new Lobby();
        List<Thread> NPC = new ArrayList<>();
        List<Thread> players = new ArrayList<>();
        for (int i = 0; i < r.nextInt(); i++) {
            Thread npc = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        lobby.addQuest();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            NPC.add(npc);
        }
        for (int i = 0; i < r.nextInt(); i++) {
            Thread player = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        lobby.getQuest();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            players.add(player);
        }
        for (Thread npc:NPC
             ) {
            npc.start();
        }
        for (Thread player:players
             ) {
            player.start();
        }
    }
}

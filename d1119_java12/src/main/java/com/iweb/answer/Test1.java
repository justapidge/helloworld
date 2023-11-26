package com.iweb.answer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/19 13:50
 */
public class Test1 {
    public static void main(String[] args) {
        TicketShop ticketShop = new TicketShop();
        List<Ikun> littleBlack = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Ikun ikun = new Ikun("ikun"+(i+1),ticketShop);
            littleBlack.add(ikun);
        }
        for (Ikun ikun:littleBlack
             ) {
            ikun.start();
        }
    }
}

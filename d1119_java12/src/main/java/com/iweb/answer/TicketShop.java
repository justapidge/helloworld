package com.iweb.answer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wmn
 * @date 2023/11/19 13:41
 */
public class TicketShop {
    private LinkedList<Ticket> ticketList;
    public TicketShop(){
        ticketList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ticketList.add(new Ticket(i+1));
        }
    }
    public synchronized Ticket getTicket(){
        if(ticketList.isEmpty()){
            return null;
        }
        return ticketList.removeLast();
    }

}

package com.iweb.work;

import com.iweb.work.DAO.ReplyDAO;
import com.iweb.work.DAO.impl.ReplyDAOImpl;
import com.iweb.work.entity.Reply;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author wmn
 * @date 2023/11/24 16:04
 */
public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        Random r = new Random();
        ReplyDAO replyDAO = new ReplyDAOImpl();
        List<Reply> replies = new ArrayList<>();
        String response ;
        String receive;
        while (true){
            receive = dis.readUTF();
            System.out.println("收到客户端消息"+receive);
            replies = replyDAO.replyList(receive);
            response = replies.get(r.nextInt(replies.size())).getResponse();
            dos.writeUTF(response);
        }
    }
}

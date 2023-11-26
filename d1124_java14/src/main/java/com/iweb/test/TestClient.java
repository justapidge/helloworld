package com.iweb.test;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wmn
 * @date 2023/11/24 15:38
 */
public class TestClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        //封装输出流
        DataOutputStream dos = new DataOutputStream(os);
        //写入数据
        dos.writeUTF("朱燕楠是常州人");
    }
}

package com.iweb.test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wmn
 * @date 2023/11/23 16:25
 */
//实例化有三条链接的数据库连接池 创建100个线程
    //每个线程从连接池借用连接 在借用后归还
    //连接后 每个执行1s
public class Test {
    public static void main(String[] args) {
        ConnectionPool cp = new ConnectionPool(10);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("工作线程"+i,cp).start();
        }
    }

    static class WorkingThread extends Thread {
        private ConnectionPool cp;

        public WorkingThread(String name, ConnectionPool cp) {
            super(name);
            this.cp = cp;
        }

        @Override
        public void run() {
            Connection c = cp.getConnection();
            System.out.println(this.getName() + ":\t 获取到了连接 开始执行sql语句");
            try (PreparedStatement ps = c.prepareStatement("select * from student")) {
                Thread.sleep(1000);
                ps.executeQuery();
            } catch (Exception e) {
                e.printStackTrace();
            }
            cp.returnConnection(c);
        }
    }
}

package com.iweb.test1;

/** 负责生成馒头 如果生产者线程有多个 必须保证操作的篮子是同一个
 * @author wmn
 * @date 2023/11/22 18:55
 */
public class Producer implements Runnable{
    Basket bt;
    public Producer(Basket bt){
        this.bt = bt;
    }
    public void run() {
        //假设一个生产者放20馒头
        for (int i = 0; i < 20; i++) {
            ManTou mt = new ManTou(i);
            bt.push(mt);
            System.out.println("生产者生产了馒头"+mt);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

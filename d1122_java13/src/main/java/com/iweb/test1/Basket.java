package com.iweb.test1;

/** 定义一个篮子类装馒头
 * 篮子有容量 需要变量表示容量和篮子中馒头数量
 * 还要提供装馒头和取馒头
 * @author wmn
 * @date 2023/11/22 18:39
 */
public class Basket {
    int index = 0;
    //容器
    ManTou[] arrMT = new ManTou[6];
    //装馒头方法
    public synchronized void push(ManTou mt){
        //篮子满了
        while (index == arrMT.length){
            //通知装馒头线程等待
            System.out.println("篮子满了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果去馒头线程wait 通知取馒头线程醒来
        this.notifyAll();
        //将当前的馒头对象存放在篮子容器中
        arrMT[index++] = mt;
    }
    public synchronized ManTou pop(){
        while (index==0){
            System.out.println("篮子空了");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果装馒头线程wait 通知装馒头线程醒来
        this.notifyAll();
        return arrMT[--index];
    }
}

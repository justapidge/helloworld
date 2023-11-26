package com.iweb.test2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wmn
 * @date 2023/11/23 18:09
 */
public class Test {
    private static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    private static void log(String msg){
        System.out.printf("%s %s %s %n",now(),Thread.currentThread().getName(),msg);
    }
    public static void main(String[] args) {
        //
        Lock lock = new ReentrantLock();
        // Thread t1 = new Thread(){
        //     @Override
        //     public void run() {
        //         log("线程启动");
        //         log("试图获取锁");
        //         //线程获取锁
        //         lock.lock();
        //         log("获取到对象锁");
        //         log("模拟5s业务操作");
        //         try {
        //             Thread.sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程运行结束");
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // Thread t2 = new Thread(){
        //     @Override
        //     public void run() {
        //         log("线程启动");
        //         log("试图获取锁");
        //         //线程获取锁
        //         lock.lock();
        //         log("获取到对象锁");
        //         log("模拟5s业务操作");
        //         try {
        //             Thread.sleep(5000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程运行结束");
        //     }
        // };
        // t2.setName("t2");
        // t2.start();
        // Condition condition = lock.newCondition();
        // Thread t1 = new Thread(){
        //     @Override
        //     public void run() {
        //         try {
        //             log("线程启动");
        //             log("尝试获取锁");
        //             lock.lock();
        //             log("成功获取到锁");
        //             log("5秒模拟");
        //             Thread.sleep(5000);
        //             log("调用await方法临时释放锁 进入等待状态");
        //             condition.await();
        //             log("重新获取锁 并且再进行5s模拟事务操作");
        //             Thread.sleep(5000);
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程结束");
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // Thread t2 = new Thread(){
        //     @Override
        //     public void run() {
        //         try {
        //             log("线程启动");
        //             log("试图获取锁");
        //             lock.lock();
        //             log("获取到锁");
        //             log("模拟5s事务操作");
        //             Thread.sleep(5000);
        //             log("唤醒处于wait状态的线程");
        //             condition.signal();
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             log("释放锁");
        //             lock.unlock();
        //         }
        //         log("线程结束");
        //     }
        // };
        // t2.setName("t2");
        // t2.start();
        // Thread t1 = new Thread(){
        //   boolean locked = false;
        //
        //     @Override
        //     public void run() {
        //         try {
        //             log("线程启动");
        //             log("试图获取锁");
        //             //线程会尝试获取锁 但只尝试1s 如果获取到返回true 如果获取不到则返回false 并且直接执行后续代码
        //             locked = lock.tryLock(1, TimeUnit.SECONDS);
        //             if (locked){
        //                 log("成功获取锁");
        //                 log("sleep模拟5s业务");
        //                 Thread.sleep(5000);
        //             }else {
        //                 log("经过1s尝试，没有获取到锁");
        //
        //             }
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             if (locked){
        //                 log("释放锁");
        //                 lock.unlock();
        //             }
        //         }
        //     }
        // };
        // t1.setName("t1");
        // t1.start();
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // Thread t2 = new Thread(){
        //     boolean locked = false;
        //
        //     @Override
        //     public void run() {
        //         try {
        //             log("线程启动");
        //             log("试图获取锁");
        //             //线程会尝试获取锁 但只尝试1s 如果获取到返回true 如果获取不到则返回false 并且直接执行后续代码
        //             locked = lock.tryLock(1, TimeUnit.SECONDS);
        //             if (locked){
        //                 log("成功获取锁");
        //                 log("sleep模拟5s业务");
        //                 Thread.sleep(5000);
        //             }else {
        //                 log("经过1s尝试，没有获取到锁");
        //
        //             }
        //         }catch (Exception e){
        //             e.printStackTrace();
        //         }finally {
        //             if (locked){
        //                 log("释放锁");
        //                 lock.unlock();
        //             }
        //         }
        //     }
        // };
        // t2.setName("t2");
        // t2.start();
        AtomicInteger ai = new AtomicInteger();
        ConcurrentHashMap chm = new ConcurrentHashMap<>();

    }
}

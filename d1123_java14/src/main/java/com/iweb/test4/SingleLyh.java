package com.iweb.test4;

import java.util.Calendar;

/**双重检查锁的单例模式
 * @author wmn
 * @date 2023/11/24 14:28
 */
public class SingleLyh {
    private volatile static SingleLyh singleLyh;
    private SingleLyh(){

    }
    public static SingleLyh getInstance(){
        //为了提高性能 如果其他线程发现对象已经实例化
        //则通过return直接获取对象的引用 而不需要再获取锁了
        if (singleLyh == null){
            synchronized (SingleLyh.class){
                if (singleLyh == null){
                    singleLyh = new SingleLyh();
                }
            }
        }
        return singleLyh;
    }
}

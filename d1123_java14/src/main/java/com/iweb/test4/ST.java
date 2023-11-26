package com.iweb.test4;

/** 饿汉 在类加载的时候 就已经完成对象初始化
 * 由于静态属性的特点 对象在类加载的时候就已经完成实例化 所以不存在线程安全的问题
 * @author wmn
 * @date 2023/11/24 14:19
 */
public class ST {
    private static ST st = new ST();
    private ST(){

    }
    public static  ST getSt(){
        return st;
    }
}

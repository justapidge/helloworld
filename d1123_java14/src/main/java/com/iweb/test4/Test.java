package com.iweb.test4;

/**
 * @author wmn
 * @date 2023/11/24 14:11
 */
public class Test {
    //java中有一个现象叫做指令重排序
    //创建对象
    //1. new向堆申请空间
    //2. 通过构造方法完成初始化
    //3. 返回引用
    //不合时宜的指令重排序会导致初始化出现错误
    //被volatile修饰的变量禁止指令重排序
    public static void main(String[] args) {

    }
}

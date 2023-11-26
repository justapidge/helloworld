package com.iweb.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author wmn
 * @date 2023/11/25 10:42
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //借助反射获取相关set方法反射对象 并最终调用sell方法
        Class pClass = Class.forName("com.iweb.test2.Product");
        Constructor<Product> c = pClass.getConstructor();
        Product p = c.newInstance();
        Method setIdMethod = pClass.getMethod("setId", Integer.class);
        Method setNameMethod = pClass.getMethod("setName", String.class);
        Method setPriceMethod = pClass.getMethod("setPrice", Float.class);
        setIdMethod.invoke(p,1);
        setNameMethod.invoke(p,"眉笔");
        setPriceMethod.invoke(p,79.0f);
        Method sellMethod = pClass.getMethod("sell");
        sellMethod.invoke(p);
    }
}

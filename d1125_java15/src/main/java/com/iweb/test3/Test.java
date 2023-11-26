package com.iweb.test3;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author wmn
 * @date 2023/11/25 10:58
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //从配置文件中提取所需要的信息
        File springConfigFile = new File
                ("C:\\idea_workspace\\d1115_javad11\\d1125_java15\\src\\main\\java\\com\\iweb\\test3\\spring.properties");
        //不再使用IO流读取 使用java提供的Properties类读取
        Properties springConfig = new Properties();
        //工具类加载配置文件
        springConfig.load(new FileInputStream(springConfigFile));
        //工具类会自动提取所有的配置文件信息 并且封装为map
        //我们只需通过get方法获取配置文件信息即可
        String className = (String) springConfig.get("className");
        String methodName = (String) springConfig.get("methodName");
        Class uClass = Class.forName(className);
        Method m = uClass.getMethod(methodName);
        Constructor<UserService> c = uClass.getConstructor();
        //实例化对象完成方法调用
        m.invoke(c.newInstance());
    }
}

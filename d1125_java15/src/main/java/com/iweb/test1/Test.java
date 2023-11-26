package com.iweb.test1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;

/**
 * @author wmn
 * @date 2023/11/25 9:16
 */
public class Test {
    public static Person getInstance() throws Exception{
        File f = new File("C:\\idea_workspace\\d1115_javad11\\d1125_java15\\src\\main\\java\\com\\iweb\\test1\\person.config");
        String className = "";
        Person p = null;
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){
            String line = br.readLine();
            String className1 = line.substring(line.indexOf("=")+1);
            // char[] data  = new char[(int) f.length()];
            // fr.read(data);
            // boolean flag =false;
            // for (char c:data
            //      ) {
            //     if(c=='='){
            //         flag = true;
            //         continue;
            //     }
            //     if(flag){
            //         className = className+c;
            //     }
            // }
            Class c = Class.forName(className1);
            p =(Person) c.newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }
        // Class c1 = Class.forName(className);
        // Constructor<Person> c = c1.getConstructor();
        // Person p = c.newInstance();
        // return p;
        return p;
    }
    public static void main(String[] args) throws Exception{
        //Class c1 = Class.forName("com.iweb.test1.Student");
        // //根据类对象获取对应的构造器对象（获取的是无参构造方法的反射对象）
        // Constructor<Student> c = c1.getConstructor();
        // //利用无参构造方法完成对象的实例化
        // Student s = c.newInstance();
        // //查看对象属性
        // System.out.println(s);
        //
        // //获取有参构造函数的反射对象
        // Constructor<Student> cc = c1.getConstructor(String.class);
        // //利用有参构造函数完成对象创建
        // Student s1 = cc.newInstance("李宇航");
        // System.out.println(s1);
        Person p = getInstance();
        p.eat();
    }
}

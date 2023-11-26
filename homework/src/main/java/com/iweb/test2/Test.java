package com.iweb.test2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wmn
 * @date 2023/11/20 20:08
 */
public class Test {
    public static volatile TreeMap<Long, List<File>> tm = new TreeMap<>();
    public static void traverse(File f){
        if(f.isFile()&&f.length()!=0){
            Thread t1 = new ListFile(f,tm);
            t1.start();
        }else if (f.isDirectory()){
            File[] fs = f.listFiles();
            for (File file:fs) {
                Thread t1 = new ListFile(f,tm);
                t1.run();
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入查找的路径!");
        String filePath = sc.nextLine();
        File f = new File(filePath);
        if(!f.isDirectory()){
            System.out.println("输入有误!");
        }else {
            Thread thread = new ListFile(f,tm);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("最小文件长度为:"+tm.firstKey()+",对应文件列表为:"+tm.firstEntry().getValue());
        System.out.println("最大文件长度为:"+tm.lastKey()+",对应文件列表为:"+tm.lastEntry().getValue());
    }
}

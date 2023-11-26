package com.iweb.homework.test25;

import java.io.File;

/**
 * @author wmn
 * @date 2023/11/24 21:54
 */
public class Test {
    public static void showAllFiles(File f){
        File[] fs = f.listFiles();
        for (File f1:fs
        ) {
            if(f1.isDirectory()){
                showAllFiles(f1);
            }else {
                System.out.println(f1.getName());
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("C:\\Users\\night\\Desktop\\java");
        showAllFiles(f);
    }
}

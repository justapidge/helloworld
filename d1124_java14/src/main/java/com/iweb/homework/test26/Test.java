package com.iweb.homework.test26;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author wmn
 * @date 2023/11/24 22:00
 */
public class Test {
    public static void copyFile(File sourceFile, File pasteFile){
        if(!sourceFile.isFile()){
            System.out.println("复制文件有误，重新输入");
            return;
        }
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(pasteFile)
        ) {
            byte[] data = new byte[(int)sourceFile.length()];
            fis.read(data);
            fos.write(data);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要复制的文件路径");
        File fileToCopy = new File(sc.nextLine());
        System.out.println("输入要粘贴的文件路径");
        File fileToPaste = new File( sc.nextLine());
        copyFile(fileToCopy,fileToPaste);
    }
}

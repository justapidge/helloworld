package com.iweb.test2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author wmn
 * @date 2023/11/20 20:19
 */
public class ListFile extends Thread{
    public  static volatile TreeMap<Long, List<File>> tm ;
    public static File file;
    public ListFile(File file,TreeMap tm){
        this.file = file;
        this.tm = tm;
    }

    @Override
    public void run() {
        if (file.isFile() && file.length() != 0) {
            if (!tm.containsKey(file.length())) {
                tm.put(file.length(), new ArrayList<>());
            }
            tm.get(file.length()).add(file);
        } else if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File file : fs) {
                Thread t1 = new ListFile(file,tm);
                t1.start();
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

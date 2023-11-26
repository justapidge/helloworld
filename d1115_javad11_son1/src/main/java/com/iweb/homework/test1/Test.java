package com.iweb.homework.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**有n顶帽子，每顶帽子的售价是随机整数，现在编写一段代码，价格从低到高的第三顶帽子的价格是多少
 * @author wmn
 * @date 2023/11/14 22:43
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < r.nextInt(20)+3; i++) {
            l.add(r.nextInt(100));
        }
        Collections.sort(l);
        System.out.println(l);
        System.out.println(l.get(2));
    }
}

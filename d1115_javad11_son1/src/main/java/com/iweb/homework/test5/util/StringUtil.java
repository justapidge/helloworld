package com.iweb.homework.test5.util;

import java.util.Random;

/**
 * @author wmn
 * @date 2023/11/10 14:18
 */
public class StringUtil {
    private static final String strPool =
            "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZCVBNM1234567890";
    private static final Random r = new Random();
    private static final StringBuilder sb = new StringBuilder();
    public static String getCaptchaCode(){
        int count = r.nextInt(3)+4;
        for (int i = 0 ; i<count;i++){
            sb.append(strPool.charAt(r.nextInt(strPool.length())));
        }
        return sb.toString();
    }
}

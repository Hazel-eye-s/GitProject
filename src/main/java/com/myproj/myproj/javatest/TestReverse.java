package com.myproj.myproj.javatest;

import java.util.Collections;

/**
 * Created by wangjinyu on 2019/4/24 10:59.
 */
public class TestReverse {
    public static void main(String[] args) {

        String originStr = "123456";
        System.out.println(originStr.substring(1));
        StringBuffer sb=new StringBuffer("123");
        System.out.println(sb.reverse());

        System.out.println();
        System.out.println(reverse(originStr));
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        //System.out.println(reverse(originStr.substring(1)));
        //System.out.println(originStr.charAt(0));
        System.out.println(originStr.substring(1));
        System.out.println(originStr.charAt(0));
        System.out.println(originStr);
        String s = reverse(originStr.substring(1)) + originStr.charAt(0);
        System.out.println(s);
        return s;
    }
}

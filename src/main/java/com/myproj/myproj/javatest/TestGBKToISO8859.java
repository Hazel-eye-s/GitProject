package com.myproj.myproj.javatest;

import java.io.UnsupportedEncodingException;

/**
 * Created by wangjinyu on 2019/4/24 11:14.
 * 将GB2312编码的字符串转换为ISO-8859-1编码的字符串
 */
public class TestGBKToISO8859 {
    public static void main(String[] args) {
        String s="123";
        try {
            String gb2312 = new String(s.getBytes("GB2312"), "ISO-8859-1");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

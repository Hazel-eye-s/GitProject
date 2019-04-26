package com.myproj.myproj.testsort;

import java.util.Random;

/**
 * Created by wangjinyu on 2019/4/25 16:18.
 */
public class TestStackOverError {
    /*public static void main(String[] args) {
        stackOverError();
    }
new Random().nextInt(122121212)
    private static void stackOverError() {
        stackOverError();
    }*/
    public static void main(String[] args) {

       /* String s = "abcd";
        while (true) {
            s+=s+new Random().nextInt(122121212)+new Random().nextInt(122121212);
            s.intern();

        }*/
        byte[] bytes = new byte[10000 * 1024 * 1024];
    }
}

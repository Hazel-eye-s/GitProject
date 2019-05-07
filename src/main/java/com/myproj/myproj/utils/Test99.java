package com.myproj.myproj.utils;

/**
 * Created by wangjinyu on 2019/4/26 14:31.
 */
public class Test99 {
    public static void main(String[] args) {
        for (int i = 1, j = 1; j <= 9; i++) {
            System.out.print(i + "*" + j + "=" + i * j + " ");
            if (i == j) {
                i = 0;
                j++;
                System.out.println();
            }
        }
    }
}

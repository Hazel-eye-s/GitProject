package com.myproj.myproj.javatest;

/**
 * Created by wangjinyu on 2019/2/18 14:28.
 */
public class Test02 {
    public static void main(String[] args) {
        String a="s52d14ed1df4rd1s";
        //System.out.println(a.replaceAll("[a-z]", ""));
        System.out.println(a.replaceAll("[a-z]", ""));
        System.out.println("*******************");

        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                char c = a.charAt(i);
                System.out.print(c);
            }
        }
    }
}

package com.myproj.myproj.test;

/**
 * Created by wangjinyu on 2019/1/2 17:05.
 * <p>
 * <p>
 * Lambda表达式:
 * 1.接口里有且只有一个方法
 * 2.公式：如何使用：(方法形参)->{方法实现体}
 */

interface Men {

    public void dos();
}

public class TestLambda {
    public static void main(String[] args) {
        Men men = new Men() {
            @Override
            public void dos() {
                System.out.println("******");
            }
        };
        men.dos();
        System.out.println("=============================");
        men = () -> {
            System.out.println("++++++++++++++");
        };
        men.dos();
    }
}

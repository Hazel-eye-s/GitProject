package com.myproj.myproj.javatest;

import java.util.UUID;

/**
 * Created by wangjinyu on 2019/4/23 14:28.
 * 单例模式 双端检索机制
 */
public class SingleDemo {
    private static volatile SingleDemo singleDemo = null;

    private SingleDemo() {
        System.out.println("******************");
    }

    public static SingleDemo getSingleDemo() {
        if (singleDemo == null) {
            synchronized (SingleDemo.class) {
                if (singleDemo == null) {
                    singleDemo = new SingleDemo();
                }
            }
        }
        return singleDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            new Thread(() -> {
                SingleDemo.getSingleDemo();
            }, String.valueOf(i)).start();

        }
    }
}

package com.myproj.myproj.test;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

/**
 * Created by wangjinyu on 2019/1/2 15:42.
 * 问题：
 * 三个售票员 卖出30张票
 * 继承Thread类，实现Runnable接口
 * <p>
 * 1.线程 操作 资源类
 * 2.高内聚 低耦合
 */
class Ticket {

}

public class TestThreadDemo1 {
    public static void main(String[] args) {
        new Thread().start();
        new Thread().start();
        new Thread().start();

    }


}

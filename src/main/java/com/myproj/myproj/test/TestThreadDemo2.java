package com.myproj.myproj.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjinyu on 2019/1/2 16:49.
 * 问题：2.0Lambad表达式
 * * 三个售票员 卖出30张票
 * * 继承Thread类，实现Runnable接口
 * * <p>
 * * 1.线程 操作 资源类
 * * 2.高内聚 低耦合
 */


class Ticket01 {

    private int ticketNumber = 30;

    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (ticketNumber > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "====>卖出第" + ticketNumber-- + "还有" + ticketNumber + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

public class TestThreadDemo2 {
    public static void main(String[] args) {
        Ticket01 ticket01 = new Ticket01();
        new Thread(()->{for (int i=0;i<30;i++)  ticket01.sale();},"A").start();
        new Thread(()->{for (int i=0;i<30;i++)ticket01.sale();},"B").start();
        new Thread(()->{for (int i=0;i<30;i++) ticket01.sale();},"C").start();

    }
}

package com.myproj.myproj.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjinyu on 2019/1/2 15:42.
 * 问题：1.0
 * 三个售票员 卖出30张票
 * 继承Thread类，实现Runnable接口
 * <p>
 * 1.线程 操作 资源类
 * 2.高内聚 低耦合
 */
class Ticket {//资源类

    private int ticketnum = 30;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();  // block until condition holds
        try {
            // ... method body
            if (ticketnum > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "卖出" + "=======>第" + ticketnum-- + "张，还有" + ticketnum + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

public class TestThreadDemo1 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();//资源类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();

                }

            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();

    }


}

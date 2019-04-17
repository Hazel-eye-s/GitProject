package com.myproj.myproj.javatest;

/**
 * Created by wangjinyu on 2019/2/18 14:00.
 */
public class Test01 {
    int j = 1;
    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }
    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    class Tinc implements Runnable {
        public void run() {
            inc();
        }
    }

    class Tdec implements Runnable {
        public void run() {
            dec();
        }
    }
    public static void main(String args[]) {
        Test01 studyThread = new Test01();
        Tinc t1 = studyThread.new Tinc();
        Tdec t11=studyThread.new Tdec();
        for(int i=0;i<2;i++){
            Thread thread=new Thread(t1);
            thread.start();
            Thread thread1=new Thread(t11);
            thread1.start();
        }
    }
}

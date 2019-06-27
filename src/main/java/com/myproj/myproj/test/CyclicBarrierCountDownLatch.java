package com.myproj.myproj.test;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import java.sql.SQLOutput;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wangjinyu on 2019/6/27 16:04.
 */
public class CyclicBarrierCountDownLatch {
    public static void main(String[] args) {
      /*  CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("112");
        });
        for (int i = 0; i < 7; i++) {

            final  int a=i;
            new Thread(() -> {
                System.out.println(""+a);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }*/
        System.out.println("**********"+Thread.currentThread().getName());
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {

            final int a = i;
            new Thread(() -> {
                System.out.println("**********"+Thread.currentThread().getName());
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("**********"+Thread.currentThread().getName());
    }
}

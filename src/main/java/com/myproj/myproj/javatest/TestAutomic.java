package com.myproj.myproj.javatest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangjinyu on 2019/4/19 15:15.
 */
public class TestAutomic {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.compareAndSet(6,10);
        System.out.println(atomicInteger);
        System.out.println(atomicInteger.compareAndSet(5,5));
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("123","123");
        HashSet<Object> objects = new HashSet<>();
        objects.add("123");
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
       // Executors.newCachedThreadPool();
        //Thread thread = new Thread();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                5,
                3,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{
            System.out.println("*************");
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put("l","12");
        AtomicInteger atomicInteger1 = new AtomicInteger();
        int andAdd = atomicInteger1.getAndAdd(1);
        int andIncrement = atomicInteger1.getAndIncrement();
        System.out.println(atomicInteger1.incrementAndGet()+"***");
    }
}

package com.myproj.myproj.javatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wangjinyu on 2019/4/22 10:10.
 */
public class TestArray {
    public static void main(String[] args) {
       ArrayList<String> object1 = new ArrayList<>();
       // CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        Vector<Object> objects1 = new Vector<>();
        //List<String> strings = Collections.synchronizedList(object1);

        for (int i = 0; i <5 ; i++) {

            new Thread(()->{
                object1.add(UUID.randomUUID().toString().replaceAll("-","").substring(10));
                System.out.println(Thread.currentThread().getName()+"===="+object1);
                //System.out.println(Thread.currentThread().getName());
            },String.valueOf(i)).start();

        }
    }
}

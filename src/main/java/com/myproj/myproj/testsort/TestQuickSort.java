package com.myproj.myproj.testsort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wangjinyu on 2019/4/24 15:19.
 */
public class TestQuickSort {

    public static void main(String[] args) {
       /* HashMap<Object, Object> objectObjectHashMap = new HashMap<>(15);
        objectObjectHashMap.put()*/
     /*   HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap=new LinkedHashMap<>();
        objectObjectHashMap.put("123","001");
        objectObjectHashMap.put("12","002");
        objectObjectHashMap.put("13","01");
        String s="";
        System.out.println(objectObjectHashMap);*/
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        WeakHashMap<Object, Object> objectObjectWeakHashMap = new WeakHashMap<>();
        String s = new String("122");
        String s1 = new String("122");

        objectObjectWeakHashMap.put(s, s1);
        s = null;
        System.out.println(objectObjectWeakHashMap);
        System.gc();
        System.out.println(objectObjectWeakHashMap);
    }

    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
           /* int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle - 1);   //对低字段表进行递归排序
            quickSort(numbers, middle + 1, high); //对高字段表进行递归排序*/
        }

    }
}

package com.myproj.myproj.testsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangjinyu on 2019/4/25 16:54.
 * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class TestGCOverHead {
    public static void main(String[] args) {
        String str = "358769421";
        char[] charArray = str.toCharArray();

        List<String> list = new ArrayList<String>();
        for (int i = 0; i <charArray.length ; i++)
        {
            list.add(String.valueOf(charArray[i]));
        }

        list.stream().sorted((o1,o2) -> {return o2.compareTo(o1);}).forEach(System.out::print);
        System.out.println();
        list.stream().sorted().forEach(System.out::print);
        System.out.println();
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);
        //只能用一个for循环完成99乘法表
       /* for (int i = 1, j = 1; j <= 9; i++) {
            System.out.print(i + "*" + j + "=" + i * j + " ");
            if (i == j) {
                i = 0;
                j++;
                System.out.println();
            }
        }*/


      /*  for (int i = 0; ; i++){
            System.out.println(i);
        new Thread(() -> {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },String.valueOf(i)).start();
            }*/
       /* Thread thread = new Thread();
        thread.start();
        thread.start();
*/
       /* int i = 0;
       try {
           ArrayList<String> objects = new ArrayList<>();
           while (true) {
               objects.add(String.valueOf(++i).intern());
           }
        }catch (Throwable e){
           System.out.println("**************"+i);
           e.printStackTrace();
           throw  e;

        }*/

    }
}

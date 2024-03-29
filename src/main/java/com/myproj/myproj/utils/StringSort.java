package com.myproj.myproj.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangjinyu on 2019/4/26 14:29.
 * 有一个字符串，比如String str = "358769421"，将它按照从小到大排序/从大到小排序
 */
public class StringSort {
    public static void main(String[] args) {
        String str = "358769421";
        char[] charArray = str.toCharArray();

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < charArray.length; i++) {
            list.add(String.valueOf(charArray[i]));
        }

        list.stream().sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).forEach(System.out::print);
        System.out.println();
        list.stream().sorted().forEach(System.out::print);
        System.out.println();
        list.stream().sorted(Collections.reverseOrder()).forEach(System.out::print);


    }
}

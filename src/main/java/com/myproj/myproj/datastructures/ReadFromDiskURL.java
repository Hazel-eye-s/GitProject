package com.myproj.myproj.datastructures;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by wangjinyu on 2019/6/21 16:28.
 */
public class ReadFromDiskURL {
    public static void main(String[] args) {
        System.out.println("*******读取本地磁盘************");
        ArrayList<String> objects = new ArrayList<>();
        try {
            File file = new File("D:\\testUrl.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                objects.add(line);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(objects.size());
    }
}

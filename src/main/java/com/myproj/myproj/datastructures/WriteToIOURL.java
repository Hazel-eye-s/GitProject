package com.myproj.myproj.datastructures;

import org.apache.poi.ss.formula.functions.Now;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by wangjinyu on 2019/6/21 16:19.
 */
public class WriteToIOURL {
    public static void main(String[] args) {
        System.out.println("*******写入本地磁盘************");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        String substring = date.substring(0, date.length() - 5);
        long l1 = System.currentTimeMillis();
        try {
            FileWriter fileWriter = new FileWriter("D:\\testUrl.txt");

            for (int i = 0; i < 100000; i++) {
                fileWriter.write(substring + "_" + UUID.randomUUID().toString().replaceAll("-", "") + ";");
                fileWriter.write("\r\n");//换行
            }
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        long l2 = System.currentTimeMillis();
        System.out.println("写入磁盘成功");
        System.out.println((l2-l1));
    }
}

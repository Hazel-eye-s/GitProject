package com.myproj.myproj.datastructures;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wangjinyu on 2019/6/27 9:55.
 * BufferedInputStream—字节输入缓冲流
 * BufferedInputStream为别的输入流添加缓冲功能，
 * 在创建BufferedInputStream时会创建一个内部缓冲数组，用于缓冲数据，提高性能。
 */
public class ReadForInputStream {
    public static void main(String[] args) {
        try {
            //创建字节输入流实例
            InputStream in = new FileInputStream("D:\\testOutputStream.txt");
            //根据字节输入流构建字节缓冲流
            BufferedInputStream buf = new BufferedInputStream(in);

            byte[] bytes = new byte[1024];
            //数据读取
            int len = -1;
            StringBuffer sb = new StringBuffer();
            while ((len = buf.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
            System.out.println("内容为：" + sb);
            //关闭流
            buf.close();
            in.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

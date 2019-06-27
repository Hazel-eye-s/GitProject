package com.myproj.myproj.datastructures;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by wangjinyu on 2019/6/27 9:51.
 * BufferedOutputStream类实现缓冲的输出了，通过设置这种输出流，
 * 应用程序就可以将各个字节写入底层输出流中，而不必每一个字节写入都调用底层系统。
 */
public class WriteToDiskOutPutStream {
    public static void main(String[] args) {

        try {
            //创建字节输出流实例
            OutputStream out = new FileOutputStream("D:\\testOutputStream.txt");
            //根据字节输出流构建字节缓冲流
            BufferedOutputStream buf = new BufferedOutputStream(out);
            String data = "好好学习,天天向上";
            buf.write(data.getBytes());//写入缓冲区
            buf.flush();//刷新缓冲区，即把内容写入
            //关闭流
            buf.close();//关闭缓冲流时,也会刷新一次缓冲区
            out.close();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

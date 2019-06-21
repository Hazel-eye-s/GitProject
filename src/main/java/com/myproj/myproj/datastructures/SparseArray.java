package com.myproj.myproj.datastructures;

import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Created by wangjinyu on 2019/6/21 11:09.
 * 稀疏数组和二维数组
 */
public class SparseArray {
    public static void main(String[] args) {
        int arraySpare[][] = new int[11][11];
        arraySpare[1][2] = 1;
        arraySpare[2][3] = 2;
        arraySpare[4][5] = 20;
        for (int[] row : arraySpare) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("*************");
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arraySpare[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        System.out.println("转换为稀疏数：");
        int spareData[][] = new int[sum + 1][3];
        spareData[0][0] = 11;
        spareData[0][1] = 11;
        spareData[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (arraySpare[i][j] != 0) {
                    count++;
                    spareData[count][0] = i;
                    spareData[count][1] = j;
                    spareData[count][2] = arraySpare[i][j];
                }
            }
        }
        //稀疏数组的输出
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int i = 0; i < spareData.length; i++) {
            System.out.printf("%d\t%d\t%d\t", spareData[i][0], spareData[i][1], spareData[i][2]);
            System.out.println();
        }
        System.out.println("稀疏数组转二维数组");
        int newSpareArray[][] = new int[spareData[0][0]][spareData[0][1]];

        for (int i = 1; i < spareData.length; i++) {

            newSpareArray[spareData[i][0]][spareData[i][1]] = spareData[i][2];
        }
        for (int[] row : newSpareArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("*******写入本地磁盘************");
       /* try {
            FileWriter fileWriter = new FileWriter("D:\\testData.txt");

            for (int i = 0; i < spareData.length; i++) {
                for (int i1 = 0; i1 < 3; i1++) {
                    fileWriter.write(spareData[i][i1] + "\t");
                }
                fileWriter.write("\r\n");//换行
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println("*******读取本地磁盘数据************");
        try {
            File file = new File("D:\\testData.txt");

            BufferedReader in = new BufferedReader(new FileReader(file));
            BufferedReader inhang = new BufferedReader(new FileReader(file));
            BufferedReader inline = new BufferedReader(new FileReader(file));
            String line;
            int row = 0;
            int lie = 0;
            while ((line = inhang.readLine()) != null) {
                lie++;
            }
            int readIoArray[][] = new int[lie][inline.readLine().split("\t").length];

            while ((line = in.readLine()) != null) {
                String[] str = line.split("\t");
                for (int i = 0; i < str.length; i++) {
                    readIoArray[row][i] = Integer.parseInt(str[i]);
                }
                row++;
            }

            in.close();
            inhang.close();
            inline.close();
            for (int[] row1 : readIoArray) {
                for (int data : row1) {
                    System.out.printf("%d\t", data);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

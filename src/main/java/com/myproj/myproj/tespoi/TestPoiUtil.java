package com.myproj.myproj.tespoi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjinyu on 2019/1/23 19:05.
 */
public class TestPoiUtil {
    public static void main(String[] args) {
        getDataFromExcel2("D:" + File.separator + "001.xlsx");
    }
    /**
     * 读取出filePath中的所有数据信息
     * @param filePath excel文件的绝对路径
     *
     */
    /**
     * 读取出filePath中的所有数据信息
     * @param filePath excel文件的绝对路径
     *
     */
    /**
     * @param cell 一个单元格的对象
     * @return 返回该单元格相应的类型的值
     */
    public static Object getRightTypeCell(Cell cell) {

        Object object = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: {
                object = cell.getStringCellValue();
                break;
            }
            case Cell.CELL_TYPE_NUMERIC: {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object = cell.getNumericCellValue();
                break;
            }

            case Cell.CELL_TYPE_FORMULA: {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                object = cell.getNumericCellValue();
                break;
            }

            case Cell.CELL_TYPE_BLANK: {
                cell.setCellType(Cell.CELL_TYPE_BLANK);
                object = cell.getStringCellValue();
                break;
            }
        }
        return object;
    }

    /**
     * 读取出filePath中的所有数据信息
     *
     * @param filePath excel文件的绝对路径
     */

    public static void getDataFromExcel2(String filePath) {
        List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
        //判断是否为excel类型文件
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        }

        FileInputStream fis = null;
        Workbook wookbook = null;
        int flag = 0;

        try {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿

        } catch (Exception ex) {
            //ex.printStackTrace();
            try {
                //这里需要重新获取流对象，因为前面的异常导致了流的关闭————————————加了这一行
                fis = new FileInputStream(filePath);
                //2007版本的excel，用.xlsx结尾

                wookbook = new XSSFWorkbook(filePath);//得到工作簿
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //得到一个工作表
        Sheet sheet = wookbook.getSheetAt(0);

        //获得表头
        Row rowHead = sheet.getRow(0);

        //根据不同的data放置不同的表头
        Map<Object, Integer> headMap = new HashMap<Object, Integer>();


        //判断表头是否合格  ------------------------这里看你有多少列
        if (rowHead.getPhysicalNumberOfCells() != 4) {
            System.out.println("表头列数与要导入的数据库不对应");
        }

        try {
            //----------------这里根据你的表格有多少列
            while (flag < 3) {
                Cell cell = rowHead.getCell(flag);
                if (getRightTypeCell(cell).toString().equals("姓名")) {
                    headMap.put("name", flag);
                }
                if (getRightTypeCell(cell).toString().equals("年龄")) {
                    headMap.put("age", flag);
                }
                if (getRightTypeCell(cell).toString().equals("性别")) {
                    headMap.put("sex", flag);
                }
                flag++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("表头不合规范，请修改后重新导入");
        }


        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();


        //要获得属性
        String name = "";
        double age = 0;
        double sex = 0;

        if (0 == totalRowNum) {
            System.out.println("Excel内没有数据！");
        }
        Cell cell_1 = null, cell_2 = null,cell_3 = null;

        //获得所有数据
        for (int i = 1; i <= totalRowNum; i++) {
            //获得第i行对象
            Row row = sheet.getRow(i);

            try {
                cell_1 = row.getCell(headMap.get("name"));
                cell_2 = row.getCell(headMap.get("age"));
                cell_3 = row.getCell(headMap.get("sex"));


            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("获取单元格错误");
            }

            try {
                //基站
                name = (String) getRightTypeCell(cell_1);

                //经纬度
                age = (Double) getRightTypeCell(cell_2);
                //性别
                sex = (Double) getRightTypeCell(cell_3);
            } catch (ClassCastException e) {
                e.printStackTrace();
                System.out.println("数据不全是数字或全部是文字!");
            }
            System.out.println("名字：" + name + ",经纬度：" + age+"性别"+sex);

        }
    }


}

package com.myproj.myproj.tespoi;

import com.myproj.myproj.utils.ResponseEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjinyu on 2019/1/23 19:05.
 */
@Controller
public class TestPoiUtilStream {
    private static final Logger logger = LoggerFactory.getLogger(TestPoiUtilStream.class);
    /*public static void main(String[] args) {
        getDataFromExcel2("D:" + File.separator + "001.xlsx");(value = "/saveFile", method = RequestMethod.POST
    }*/

    @RequestMapping(value = "/testpoiStream", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity testPoi(@RequestParam("file") MultipartFile multipartFile) {
//@RequestParam String filePath
        FileInputStream fis = null;
        try {
            InputStream inputStream = multipartFile.getInputStream();
            fis = (FileInputStream) inputStream;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(multipartFile);
        //判断是否为excel类型文件
        String filePath = multipartFile.getOriginalFilename();
        System.out.println(filePath);
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        }
        ResponseEntity responseEntity = new ResponseEntity();
        logger.info("***********");
        // System.out.println(getDataFromExcel2("D:" + File.separator + "001.xlsx"));
        System.out.println("D:" + File.separator + "001.xlsx");
        System.out.println("******************");
        responseEntity.setCode("1");
        responseEntity.setResult(getDataFromExcel2(fis));

        return responseEntity;
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
     * @param excel文件的绝对路径
     */

    public static List<Map<String, Object>> getDataFromExcel2(FileInputStream fis) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();


        Workbook wookbook = null;
        int flag = 0;


        try {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿

        } catch (Exception ex) {
            //ex.printStackTrace();
            try {
                //这里需要重新获取流对象，因为前面的异常导致了流的关闭————————————加了这一行
                //fis = new FileInputStream(filePath);
                //2007版本的excel，用.xlsx结尾

                wookbook = new XSSFWorkbook(fis);//得到工作簿
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
            while (flag < 4) {
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
        Cell cell_1 = null, cell_2 = null, cell_3 = null;


        //获得所有数据
        for (int i = 1; i <= totalRowNum; i++) {
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
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
                Object rightTypeCell = getRightTypeCell(cell_3);
                if (StringUtils.isEmpty(rightTypeCell)) {
                    objectObjectHashMap.put("sex", "");
                } else {
                    objectObjectHashMap.put("sex", sex);
                }

                //sex = (Double) getRightTypeCell(cell_3);
                objectObjectHashMap.put("name", name);
                objectObjectHashMap.put("age", age);
                list.add(objectObjectHashMap);
                //objectObjectHashMap.put("sex", sex);
            } catch (ClassCastException e) {
                e.printStackTrace();
                System.out.println("数据不全是数字或全部是文字!");
            }
            // System.out.println("名字：" + name + ",经纬度：" + age + "性别" + sex);
            //System.out.println(objectObjectHashMap);

        }
        return list;

    }
}


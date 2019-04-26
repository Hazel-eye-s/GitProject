package com.myproj.myproj.tespoi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjinyu on 2019/1/28 8:54.
 */
public class ExcelReadUtil {
    private static String XLS_POSTFIX = "xls";
    private static String XLSX_POSTFIX = "xlsx";

    public ExcelReadUtil() {
    }

    public static List<List> readExcel(File file) throws IOException {
        String postfix = getExcelPostfix(file);
        List<List> dataList = null;
        if (XLS_POSTFIX.equals(postfix)) {
            dataList = readXls(file);
        } else if (XLSX_POSTFIX.equals(postfix)) {
            dataList = readXlsx(file);
        }

        return dataList;
    }

    private static List<List> readXlsx(File file) throws IOException {
        if (!isFileExist(file)) {
            return null;
        } else {
            List dataList = null;
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            dataList = new ArrayList();

            for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); ++numSheet) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet != null) {
                    List rowList = new ArrayList();

                    for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); ++rowNum) {
                        XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                        if (xssfRow != null) {
                            Map rowMap = new HashMap();

                            for(int cellNum = 0; cellNum < xssfRow.getLastCellNum(); ++cellNum) {
                                XSSFCell cell = xssfRow.getCell(cellNum);
                                rowMap.put(String.valueOf(cellNum), getValue(cell));
                            }

                            rowList.add(rowMap);
                        }
                    }

                    dataList.add(rowList);
                }
            }

            return dataList;
        }
    }

    private static List<List> readXls(File file) throws IOException {
        if (!isFileExist(file)) {
            return null;
        } else {
            List dataList = null;
            FileInputStream fis = new FileInputStream(file);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fis);
            dataList = new ArrayList();

            for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); ++numSheet) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet != null) {
                    List rowList = new ArrayList();

                    for(int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); ++rowNum) {
                        HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                        if (hssfRow != null) {
                            Map rowMap = new HashMap();

                            for(int cellNum = 0; cellNum < hssfRow.getLastCellNum(); ++cellNum) {
                                HSSFCell cell = hssfRow.getCell(cellNum);
                                rowMap.put(String.valueOf(cellNum), getValue(cell));
                            }

                            rowList.add(rowMap);
                        }
                    }

                    dataList.add(rowList);
                }
            }

            return dataList;
        }
    }

    private static String getValue(XSSFCell xssfCell) {
        if (xssfCell == null) {
            return "";
        } else if (xssfCell.getCellType() == 4) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == 0) {
            if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
                SimpleDateFormat sdf = null;
                if (xssfCell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                    sdf = new SimpleDateFormat("HH:mm");
                } else {
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                }

                Date date = xssfCell.getDateCellValue();
                return sdf.format(date);
            } else {
                return String.valueOf(xssfCell.getNumericCellValue());
            }
        } else {
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }

    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell == null) {
            return "";
        } else if (hssfCell.getCellType() == 4) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == 0) {
            if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
                SimpleDateFormat sdf = null;
                if (hssfCell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
                    sdf = new SimpleDateFormat("HH:mm");
                } else {
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                }

                Date date = hssfCell.getDateCellValue();
                return sdf.format(date);
            } else {
                return String.valueOf(hssfCell.getNumericCellValue());
            }
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    private static String getExcelPostfix(File file) {
        String fileName = null;
        String filePostfix = null;
        if (isFileExist(file)) {
            fileName = file.getName();
            filePostfix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        }

        return filePostfix;
    }

    private static boolean isFileExist(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static HSSFWorkbook exportExcel(List<Map<String, Object>> list, String[] fileds, String[] values) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("列表");
        sheet.setDefaultColumnWidth((short)18);
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment((short)2);
        HSSFCell cell = row.createCell((short)0);
        cell.setCellValue("序号");
        cell.setCellStyle(style);
        cell = row.createCell((short)1);
        int j = 1;
        String[] var12 = fileds;
        int k = fileds.length;

        for(int var10 = 0; var10 < k; ++var10) {
            String filed = var12[var10];
            cell.setCellValue(filed);
            cell.setCellStyle(style);
            ++j;
            cell = row.createCell((short)j);
        }

        for(int i = 0; i < list.size(); ++i) {
            row = sheet.createRow(i + 1);
            Map<String, Object> map = (Map)list.get(i);
            k = 0;
            row.createCell((short)k).setCellValue((double)(i + 1));
            String[] var15 = values;
            int var14 = values.length;

            for(int var13 = 0; var13 < var14; ++var13) {
                String value = var15[var13];
                ++k;
                row.createCell((short)k).setCellValue(map.get(value) == null ? "" : map.get(value).toString());
            }
        }

        return wb;
    }
}

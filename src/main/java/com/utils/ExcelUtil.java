package com.utils;
/**
 * excel工具类
 *
 * 导出excel文件
 */
import com.bean.User;
import org.apache.poi.hssf.usermodel.*;

import java.util.List;
/*
 * 导出excel文件
 */
public class ExcelUtil {
    public static HSSFWorkbook getHSSFWorkboot(String sheetName, List<User> list){
        //create HSSFWorkbook
        HSSFWorkbook wb = new HSSFWorkbook();
        //add sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        //add Header ----row 0
        HSSFRow row= sheet.createRow(0);
        //create cell]
        HSSFCellStyle style = wb.createCellStyle();
        //set center
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //declare object of row
        HSSFCell cell = null;
        //name Header
        //id
        cell = row.createCell(0);
        cell.setCellValue("id");
        cell.setCellStyle(style);
        //id name
        cell = row.createCell(1);
        cell.setCellValue("name");
        cell.setCellStyle(style);
        //id name age
        cell = row.createCell(2);
        cell.setCellValue("age");
        cell.setCellStyle(style);
        //add data
        int i = 1;
        for (User user:list
        ) {

        }
        return wb;
    }
}

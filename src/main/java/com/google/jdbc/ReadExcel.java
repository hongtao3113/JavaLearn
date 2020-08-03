package com.google.jdbc;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @author wk
 * @Description:读取excel
 * @date 2020/4/29 17:04
 **/
public class ReadExcel {
    /**
     * jxl.read.biff.BiffException: Unable to recognize OLE stream
     * 只能读取xls，将文件另存为xls
     *
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("C:\\Users\\wk\\Desktop\\readExcel.xls");
        List<Map<String, Object>> maps = xls2String(file);
        Arrays.asList(maps).stream().forEach(System.out::println);
    }

    public static List<Map<String, Object>> xls2String(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            Workbook rwb = Workbook.getWorkbook(fis);
            Sheet[] sheet = rwb.getSheets();
            List<Map<String, Object>> maps = new ArrayList<>();
            for (int i = 0; i < sheet.length; i++) {
                Sheet rs = rwb.getSheet(i);
                //去除第一行
                for (int j = 1; j < rs.getRows(); j++) {
                    Map<String, Object> map = new HashMap<>();

                    Cell[] cells = rs.getRow(j);
                    String cell1 = cells[0].getContents();
                    String cell2 = cells[2].getContents();
                    String cell3 = cells[3].getContents();
                    map.put("c1", cell1);
                    map.put("c2", cell2);
                    map.put("c3", cell3);
                    maps.add(map);

                }
            }
            fis.close();
            return maps;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class test {
    public static void main(String[] args) throws Exception {
        //1.读取Excel文档对象
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\mpc\\Desktop\\4.xlsx"));
        //2.获取要解析的表格（第一个表格）
        XSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        //获得最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {//遍历每一行
            //3.获得要解析的行
            XSSFRow row = sheet.getRow(i);
            //4.获得每个单元格中的内容（String）
            /*
            String stringCellValue0 = row.getCell(0).getStringCellValue();
            String stringCellValue1 = row.getCell(1).getStringCellValue();
            String stringCellValue2 = row.getCell(2).getStringCellValue();
            String stringCellValue3 = row.getCell(3).getStringCellValue();
            String stringCellValue4 = row.getCell(4).getStringCellValue();
            System.out.println(stringCellValue0+"--"+stringCellValue1+"--"+stringCellValue2+"--"+stringCellValue3+"--"+stringCellValue4);
        */
            double sum = 0;
            for(int j = 0;j < 12;j++) {
                sum = sum + Double.valueOf(row.getCell(j).getRawValue());
                if(i % 8 == 0) {
                    System.out.println(String.format("%.2f",sum/8));
                    sum = 0;
                }
            }
            System.out.println(row.getCell(2).getRawValue());
        }
    }
}
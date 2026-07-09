package practice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.File;
import java.io.FileOutputStream;


public class Test150CreateXLSFile 
{
    public static void main(String[] args) throws Exception
    {
        // Create a new Excel workbook
        HSSFWorkbook wb=new HSSFWorkbook();
        // Create a sheet in the workbook
        HSSFSheet sh=wb.createSheet("Sheet1");
        // Create a row in the sheet
        HSSFRow r=sh.createRow(0); //0 means 1st row
        // Create a cell in the row and add some data to it
        HSSFCell c=r.createCell(0); //0 means 1st cell
        c.setCellValue("Hello Students");
        // Save the workbook to a file and close permissions
        File f=new File("src\\test\\resources\\example1.xls");
        FileOutputStream fo=new FileOutputStream(f);
        wb.write(fo); //save workbook(excel file)
        wb.close();
        fo.close();
        System.out.println("Excel file created successfully.");
    }
}


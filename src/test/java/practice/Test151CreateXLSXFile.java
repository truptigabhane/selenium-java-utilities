package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test151CreateXLSXFile 
{
	public static void main(String[] args) throws Exception
	{
		    //Create a new Excel workbook
	        XSSFWorkbook wb=new XSSFWorkbook();
	        // Create a sheet in the workbook
	        XSSFSheet sh=wb.createSheet("Sheet1");
	        // Create a row in the sheet
	        XSSFRow row=sh.createRow(0);
	        // Create a cell in the row and add some data to it
	        XSSFCell c=row.createCell(0);
	        c.setCellValue("Hello SDETs");
	        // Save the workbook to a file and close permissions
	        File f=new File("src\\test\\resources\\example2.xlsx");
	        FileOutputStream fo=new FileOutputStream(f);
	        wb.write(fo);
	        fo.close();
	        wb.close();
	        System.out.println("Excel file created successfully.");
	}
}

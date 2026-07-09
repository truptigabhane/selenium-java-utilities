package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test153 
{
	public static void main(String[] args) throws Exception
	{
		//Connect to existing excel file in HDD
		File f=new File("src\\test\\resources\\exceldata.xlsx");
		//Take READ permission on that file
		FileInputStream fi=new FileInputStream(f);
		//Consider that file as Excel file(workbook) and shift it to RAM
		Workbook wb=WorkbookFactory.create(fi); 
		//Create a new sheet
		Sheet sh=wb.createSheet("Mysheet");
		//Create new rows in that sheet and set values 
		Row r1=sh.createRow(0);
		r1.createCell(0).setCellValue("Abdul Kalam");
		r1.createCell(1).setCellValue("India");
		Row r2=sh.createRow(1);
		r2.createCell(0).setCellValue("Thomas Kutty");
		r2.createCell(1).setCellValue("India");
		Row r3=sh.createRow(2);
		r3.createCell(0).setCellValue("virat kohli");
		r3.createCell(1).setCellValue("India");
		//Auto fit
		sh.autoSizeColumn(0);
		sh.autoSizeColumn(1);
		//Save changes
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo); //save changes
		//close permissions
		fo.close();
		fi.close();
		wb.close();
		System.out.println("Excel file updated successfully.");
	}
}

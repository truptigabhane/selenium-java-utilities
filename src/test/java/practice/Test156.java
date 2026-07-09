package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test156 
{
	public static void main(String[] args) throws Exception
	{
		//Connect to existing file in HDD
		File f=new File("src\\test\\resources\\numdata.xlsx");
		//Take READ permission on that file
		FileInputStream fi=new FileInputStream(f);
		//Consider that file as Excel file(workbook) and shift it to RAM
		Workbook wb=WorkbookFactory.create(fi); 
		//create object to Sheet1 ad get count of used rows
		Sheet sh1=wb.getSheet("Sheet1");
		int nur=sh1.getPhysicalNumberOfRows();
		//create object to Sheet2 and create headings
		Sheet sh2=wb.getSheet("Sheet2");
		Row r1=sh2.createRow(0); //1st row
		r1.createCell(0).setCellValue("Add");
		r1.createCell(1).setCellValue("Subtract");
		r1.createCell(2).setCellValue("Multiply");
		r1.createCell(3).setCellValue("Divide");
		//1st row(index=0) has headings
		//DDT form from 2nd row(index=1) to last row(index=nur-1) in Sheet1
		for(int i=1;i<nur;i++) 
		{
			DataFormatter df=new DataFormatter();
			String x=df.formatCellValue(sh1.getRow(i).getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(sh1.getRow(i).getCell(1));
			int b=Integer.parseInt(y);
			Row r2=sh2.createRow(i);
			r2.createCell(0).setCellValue(a+b);
			r2.createCell(1).setCellValue(a-b);
			r2.createCell(2).setCellValue(a*b);
			r2.createCell(3).setCellValue((float)a/b);
			sh2.autoSizeColumn(0);
			sh2.autoSizeColumn(1);
			sh2.autoSizeColumn(2);
			sh2.autoSizeColumn(3);
		}
		//Take WRITE permission and save changes
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		fo.close();
		fi.close();
		wb.close();
	}
}

package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test155 
{
	public static void main(String[] args) throws Exception
	{
		//Connect to existing file in HDD
		File f=new File("src\\test\\resources\\numdata.xlsx");
		//Take READ permission on that file
		FileInputStream fi=new FileInputStream(f);
		//Consider that file as Excel file(workbook) and shift it to RAM
		Workbook wb=WorkbookFactory.create(fi); 
		//Goto Sheet1
		Sheet sh=wb.getSheet("Sheet1");
		int nur=sh.getPhysicalNumberOfRows();
		//1st row(index=0) has names of columns
		for(int i=1;i<nur;i++) //DDT from 2nd row(index=1) to last row(index=nur-1)
		{
			DataFormatter df=new DataFormatter();
			Row r=sh.getRow(i);
			String x=df.formatCellValue(r.getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(r.getCell(1));
			int b=Integer.parseInt(y);
			r.createCell(2).setCellValue(a+b);
			r.createCell(3).setCellValue(a-b);
			r.createCell(4).setCellValue(a*b);
			r.createCell(5).setCellValue((float)a/b);
		}
		//take WRITE permission and save changes
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		fo.close();
		fi.close();
		wb.close();
	}
}

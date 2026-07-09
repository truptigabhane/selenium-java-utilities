package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test157
{
	public static void main(String[] args) throws Exception
	{
		//1. Connect to an existing excel file
		File f1=new File("src\\test\\resources\\numdata.xlsx");
		FileInputStream fi=new FileInputStream(f1); //READ mode
		Workbook ewb=WorkbookFactory.create(fi); 
		Sheet esh=ewb.getSheet("Sheet1");
		int nur=esh.getPhysicalNumberOfRows();
		//2. Create a new Excel file for results
		File f2=new File("src\\test\\resources\\numresult.xlsx");
		FileOutputStream fo=new FileOutputStream(f2); //WRITE mode
		XSSFWorkbook nwb=new XSSFWorkbook();
		Sheet nsh=nwb.createSheet("Result");
		Row r1=nsh.createRow(0);
		r1.createCell(0).setCellValue("Add");
		r1.createCell(1).setCellValue("Subtract");
		r1.createCell(2).setCellValue("Multiply");
		r1.createCell(3).setCellValue("Divide");
		//1st row(index=0) has names of columns
		//3. So, DDT from from 2nd row(index=1) to last row(index=nur-1) in file1
		for(int i=1;i<nur;i++) 
		{
			DataFormatter df=new DataFormatter();
			String x=df.formatCellValue(esh.getRow(i).getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(esh.getRow(i).getCell(1));
			int b=Integer.parseInt(y);
			Row r2=nsh.createRow(i);
			r2.createCell(0).setCellValue(a+b);
			r2.createCell(1).setCellValue(a-b);
			r2.createCell(2).setCellValue(a*b);
			r2.createCell(3).setCellValue((float)a/b);
		}
		//4. save that new file with results
		nwb.write(fo);
		fo.close();
		fi.close();
		ewb.close();
		nwb.close();
	}
}

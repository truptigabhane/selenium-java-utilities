package practice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test154 
{
	public static void main(String[] args) throws Exception
	{
		//Connect to existing file in HDD
		File f=new File("src\\test\\resources\\exceldata.xlsx");
		//Take READ permission on that file
		FileInputStream fi=new FileInputStream(f);
		//Consider that file as Excel file(workbook) and shift it to RAM
		Workbook wb=WorkbookFactory.create(fi); 
		//Goto existing sheet in that workbook
		Sheet sh=wb.getSheet("Mysheet");
		//get total data
		int nur=sh.getPhysicalNumberOfRows();
		for(int i=0;i<nur;i++) //row by row
		{
			DataFormatter df=new DataFormatter(); //to take any type of data as String by default
			Row r=sh.getRow(i);
			int nuc=r.getLastCellNum();
			for(int j=0; j<nuc; j++) //cell by cell
			{
				String x=df.formatCellValue(r.getCell(j));
				System.out.print(x+",");
			}
			System.out.println();
		}
		//close permissions
		fi.close();
		wb.close();
	}
}

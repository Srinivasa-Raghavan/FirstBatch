package utils;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public Object[][] readExcel(String filename) throws IOException
	{
		int i,j;
		//Open the existing excel workbook
	//	HSSFWorkbook obj = new HSSFWorkbook();
		XSSFWorkbook wBook = new XSSFWorkbook("./testData/"+filename+".xlsx");
		
		//open the sheet with sheet name as "Sheet1"
		XSSFSheet xlSheet = wBook.getSheet("Sheet1");
		
		//xlSheet.getRow(1).getCell(2).getStringCellValue();
		
		//Get the Row Count and column count
		
		int rowCount = xlSheet.getLastRowNum();
		
		int colCount = xlSheet.getRow(0).getLastCellNum();
		
		//Declare the array to read all the values
		Object[][] data = new Object[rowCount][colCount];
		
		//Get all the values
		for(i=1; i<=rowCount; i++)
		{
			for(j=0;j<colCount;j++)
			{
				data[i-1][j] = xlSheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		
		
		wBook.close();
		return data;
	}
}

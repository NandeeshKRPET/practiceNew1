package qspiders;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		
		System.out.println(getDataFromExcel("MySheet",1,0));
		System.out.println(getLastRowNumber("MySheet"));
	}
	
	
	public static String getDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		String data = null;
		
		FileInputStream fis = new FileInputStream("./src/test/resources/testData/Mydata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNo);
		data = row.getCell(cellNo).getStringCellValue();
		return data;
	}
	
	public static int getLastRowNumber(String sheetName) throws EncryptedDocumentException, IOException
	{
		int lastRowNumber = 0;
		FileInputStream fis = new FileInputStream("./src/test/resources/testData/Mydata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet(sheetName);
		
		lastRowNumber =  sheet.getPhysicalNumberOfRows();
		
		
		return lastRowNumber;
	}

}

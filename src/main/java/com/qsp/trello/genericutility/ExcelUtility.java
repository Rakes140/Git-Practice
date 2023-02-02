 package com.qsp.trello.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * It will be used to read the String cell value from the workbook
	 * @author Rakesh
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readStringData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestCaseSpecificData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook  .getSheet(sheetName);
		Row row = sheet.getRow(rowNo );
		Cell cell = row.getCell(cellNo);
		String data = cell.getStringCellValue();
		workbook.close();
		return data;
	}
	/**
	 * It will be used to read the Numeric cell value from the workbook
	 * @author Rakesh
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readNumericData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestCaseSpecificData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo );
		Cell cell = row.getCell(cellNo);
		double data = cell.getNumericCellValue();
		workbook.close();
		return data;
	}
	
	public int totalDataCell(String sheetName, int rowNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestCaseSpecificData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		int maxColIx = row.getLastCellNum();
		return maxColIx;
	}
}

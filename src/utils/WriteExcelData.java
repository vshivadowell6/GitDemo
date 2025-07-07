package utils;

import static Constants.Constants.TESTDATA_FILEPATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Constants.Constants;
public class WriteExcelData {

	public void writeExcel( String sheetName, String dataToWrite)
			throws IOException {

		// Create an object of File class to open xlsx file
		// File file = new File("C://Users//1000020344//Downloads//Parabank//src//testdata//testdata.xlsx");
		File tdf = new File(Constants.PROJECTP_PATH+TESTDATA_FILEPATH);
		//System.out.println("The Excel path = "+Constants.PROJECTP_PATH+TESTDATA_FILEPATH);
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(tdf);
		Workbook workbook = null;
		// Read excel sheet by sheet name
		workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		// Get the current count of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		//System.out.println("rowCount = "+rowCount);
		// Get the first row from the sheet
		Row row = sheet.getRow(0);
		// Create a new row and append it at last of sheet
		//System.out.println("row.getLastCellNum() = "+row.getLastCellNum());
		Row newRow = sheet.createRow(rowCount + 1);
		// Create a loop over the cell of newly created Row
		for (int j = 0; j < row.getLastCellNum(); j++) {
			// Fill data in row
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite);
		}
		// Close input stream
		inputStream.close();
		// Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(tdf);
		// write data in the excel file
		workbook.write(outputStream);
		// close output stream
		outputStream.close();
		}
}

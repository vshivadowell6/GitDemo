package utils;

import static Constants.Constants.TESTDATA_FILEPATH;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import Constants.Constants;
public class ReadExcelData {


	public String[][] getDataLogin(String excelsheetname) throws IOException, InvalidFormatException{

		//System.out.println("Welcome to Login getDataLogin");
		//String projectPath = System.getProperty("user.dir");
		//System.out.println("projectPath  = "+projectPath);
		//System.out.println("TESTDATA_FILEPATH  = "+TESTDATA_FILEPATH);
		//System.out.println("PATH  = "+projectPath+ TESTDATA_FILEPATH);


		File tdf = new File(System.getProperty("user.dir")+TESTDATA_FILEPATH);
		//System.out.println("Get Path = "+tdf.getPath());
		//System.out.println("excelsheetname = "+excelsheetname);
		//System.out.println("Full path =  "+tdf.getPath());
		FileInputStream fileInputStream = new FileInputStream(tdf);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		//Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheetName = workbook.getSheet(excelsheetname);
		int totalRows = sheetName.getLastRowNum();
		//System.out.println("totalRows = "+totalRows);
		Row rowCells =   sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		//System.out.println("totalCols = "+totalCols);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String [totalRows][totalCols];

		for(int i =1;i<=totalRows; i++) {
			for(int j =0;j<totalCols; j++) {
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				//System.out.println(testData[i-1][j]);
			}
		}
		return testData;

	}


	public String[][] getDataFillForm(String excelsheetname) throws IOException{
		//System.out.println("Test Data  sheet Path = "+"user.dir"+TESTDATA_FILEPATH);
		File tdf = new File(System.getProperty("user.dir")+TESTDATA_FILEPATH);
		//System.out.println("excelsheetname = "+excelsheetname);
		FileInputStream fileInputStream = new FileInputStream(tdf);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheetName = workbook.getSheet(excelsheetname);

		int totalRows = sheetName.getLastRowNum();
		//System.out.println("totalRows = "+totalRows);

		Row rowCells =  sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		//System.out.println("totalCols = "+totalCols);
		DataFormatter format = new DataFormatter();
		String testData1[][] = new String [totalRows][totalCols];

		for(int i =1;i<=totalRows; i++) {
			for(int j =0;j<totalCols; j++) {
				testData1[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				//System.out.println(testData1[i-1][j]);
			}
		}
		return testData1;

	}
}

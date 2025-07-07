package utils;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

	ReadExcelData excelUtil = new ReadExcelData();

	@DataProvider(name = "logincreds1")
	public String [][] getDataforlogin(Method m)  throws IOException, InvalidFormatException{

		//System.out.println("getDataforlogin  Methods m.getName = "+m.getName());
		//System.out.println(Constants.PROJECTP_PATH);
		return excelUtil.getDataLogin(m.getName());

	}
	@DataProvider(name = "RegisterForm1")
	public String [][] getDataFillForm(Method m)  throws IOException{
		return excelUtil.getDataFillForm(m.getName());

	}

}

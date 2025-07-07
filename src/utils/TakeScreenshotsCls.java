package utils;

import static Constants.Constants.SCREENSHOT_FILEPATH;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class TakeScreenshotsCls {

	public static String destination;
	public static String getScreenshot (WebDriver driver, String ScreenshotName ) throws IOException
	   {
		   String datenameimg = new SimpleDateFormat("yyyyMMddhhmmss").format (new Date ());
		   System.out.println("8888888888888");
		   TakesScreenshot ts = (TakesScreenshot) driver;
		   //System.out.println("Driver name "+ts.getClass());
		   System.out.println("ScreenshotName   =  "+ScreenshotName);
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   destination = System.getProperty("user.dir")+SCREENSHOT_FILEPATH+ScreenshotName+"_"+datenameimg+".png";
		   File filedestination = new File(destination);
		   //File filedestination = new File(System.getProperty("user.dir")+SCREENSHOT_FILEPATH+datenameimg+".png");
		  System.out.println("screenshotPath -10000  = "+System.getProperty("user.dir")+SCREENSHOT_FILEPATH+datenameimg+".png");
		   FileUtils.copyFile(source, filedestination);
		return destination;

	   }

}

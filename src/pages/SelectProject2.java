package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Constants.Constants;
import base.FindElementsCls;

public class SelectProject2 {
	public WebDriver driver;
	public String confirmationMessage;
	public static String iconcolor,ProjectName ;
	public int i;
	WebElement icon;
	public SelectProject2(WebDriver driver) {
		this.driver = driver;
	}

	public void SelectProject_Data() throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		UpdateStatus us = new UpdateStatus(driver);
		//FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/span[1]").click();// Recent Projects side menu
		for (i = 1;i<=2;i++)
		{
			System.out.println ("i Value = "+i);
			//Thread.sleep(5000);



			if (i != 2)
			{
			 FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/span[1]").click();// Recent Projects side menu
			 System.out.println ("Inside If condition 'i' Value = "+i);

			    List<WebElement> Listcount = driver.findElements(By.xpath("//*[@id=\"projectIcon\"]/ul/li"));
			    System.out.println("==========");
			    System.out.println("Recentprojects List size is: " +Listcount.size());
			    int j=0;
			    for ( WebElement we: Listcount) {
			    	j=j+1;
			    	Thread.sleep(100);
			    	System.out.println ("Element "+j+ " Value = "+ we.getText());
			    }

			}
			FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/ul/li["+i+"]/a").click();
			Thread.sleep(5000);
			FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/span[1]").click();
			ProjectName = FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/ul/li[1]/a").getText();
			System.out.println("Clicked "+i+" time and Project Name = "+ProjectName);
			FECls.SelectDromDropDownWithHover("Monitor", "//*[@id=\"LOCK_Monitor\"]", "xpath");
			FECls.Button_Type("xpath", "//*[@id=\"LOCK_Daily Reporting\"]").click();
			FECls.Button_Type("xpath", "//*[@id=\"SRPT_fGrid-normal-body\"]/div/div/div/table/tbody/tr/td[1]/div").click();
			List<WebElement> fram1 = driver.findElements(By.tagName("iframe"));
			int framecount1 = fram1.size();
			System.out.println("frame count 1 = "+framecount1);
			driver.switchTo().frame("content");
			System.out.println("Moved to Frame content");
			FECls.Button_Type("name", "Self Reporting").click();

			//System.out.println("Clicked Successfully 1");
			driver.switchTo().frame(1);
			Thread.sleep(5000);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[3]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[4]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[5]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[6]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[7]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[8]/td[2]/Select").selectByIndex(3);
 		if (ProjectName.contains("NBS"))
			{
				System.out.println ("Project Name is NBS");
				ProjectName = "NBS";
				FECls.TextField_Type("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[3]/td[4]/span/textarea").clear();
				FECls.TextField_Type("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[3]/td[4]/span/textarea").sendKeys(Constants.NBSProjStatus);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				System.out.println("Again Switch back to content Frame");
				FECls.Button_Type("xpath","//*[@class=\"ButtonBg  \"]/tbody/tr/td/Table/tbody/tr/td/input").click();
				System.out.println("Clicked Save Button");
				Thread.sleep(1000);
				driver.switchTo().frame(1);
				us.UpdateStatus_Data(); // To validate the status either Red, Amber or Green
				driver.switchTo().defaultContent();
				System.out.println("NBS END");
			}

 				else
 			{
				System.out.println ("Project Name is Testing");
				ProjectName = "Testing";
				FECls.TextField_Type("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[3]/td[4]/span/textarea").clear();
				FECls.TextField_Type("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[3]/td[4]/span/textarea").sendKeys(Constants.TestingProjStatus);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("content");
				System.out.println("Again Switch back to content Frame");
				FECls.Button_Type("xpath","//*[@class=\"ButtonBg  \"]/tbody/tr/td/Table/tbody/tr/td/input").click();
				System.out.println("Clicked Save Button");
				Thread.sleep(1000);
				driver.switchTo().frame(1);
				us.UpdateStatus_Data(); //// To validate the status either Red, Amber or Green
				driver.switchTo().defaultContent();
				System.out.println("TESTING END");
			}
 		ProjectName = "";
 		System.out.println("ProjectName Outside loop= "+ProjectName);
 		System.out.println("Loop = "+i);
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	//	System.out.println ("Project Name = "+FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/ul/li[1]/a").getText());




	/*
		FECls.Link_Type("linkText", "Open New Account").click();
		FECls.selecFromdown_OneValue("xpath", "//*[@id=\"type\"]").selectByIndex(1);
		FECls.selecFromdown_OneValue("xpath", "//*[@id=\"fromAccountId\"]").selectByIndex(0);
		//WebDriverWait wait = new WebDriverWait(driver,20 );
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input")));
		Thread.sleep(5000);
		FECls.Button_Type("xpath", "//*[@id=\"rightPanel\"]/div/div/form/div/input").click(); //Open New Account button
		*/

	//	confirmationMessage = FECls.GetWebElements("xpath", "//*[@id=\"SRPT_fGrid-normal-body\"]/div/div/div/table/tbody/tr/td[1]/div").getText();
	//	System.out.println("confirmationMessage= "+confirmationMessage);
		////Congratulations, your account is now open.
		//NewAcctNo = FECls.GetWebElements("id","newAccountId").getText();//Eg.Your new account number: 21003
		// This need to be written in excel
		//System.out.println("New Account Generated = "+NewAcctNo);

			}
}

package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.FindElementsCls;
import utils.FlashElement;

public class SelectProjectThoughFavMenu {
	public WebDriver driver;
	public String confirmationMessage;
	public static String iconcolor,ProjectName ;
	public int i;
	WebElement icon;
	public SelectProjectThoughFavMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void UpdateProjectStatus_Data() throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		UpdateStatus us = new UpdateStatus(driver);
		System.out.println ("Favourites Menu NOT Clicked");

		FECls.Button_Type("xpath", "//*[@id=\"favouritesIcon\"]/span[1]").click();// Recent Projects side menu
		//FECls.Button_Type("xpath", "//*[@id=\"favouritesIcon\"]/span[1]").click();// Recent Projects side menu

		//System.out.println ("Favourites Menu Clicked");

	    List<WebElement> Listcount = driver.findElements(By.xpath("//*[@id=\"favouritesIcon\"]/ul/li"));
	   // System.out.println("==========");
	   System.out.println("favouritesIcon List size is: " +Listcount.size());
	    int j=0;
	    for ( WebElement we: Listcount) {
	    	j=j+1;
	    	Thread.sleep(500);
	    	//System.out.println ("Element "+j+ " Value = "+ we.getText());
	    }
	    for (i = 1;i<=Listcount.size();i++)
		{
			//System.out.println ("i Value = "+i);
			Thread.sleep(2000);
			if (i != 1) // This verification is to click favorite menu because to expand it (Because once we click any project it will hide the project)
			{
			 FECls.Button_Type("xpath", "//*[@id=\"favouritesIcon\"]/span[1]").click();// Recent Projects side menu
			// System.out.println ("Inside If condition 'i' Value = "+i);
			 Thread.sleep(1000);
			}

			ProjectName = FECls.Button_Type("xpath", "//*[@id=\"favouritesIcon\"]/ul/li["+i+"]").getText();
			//Thread.sleep(2000);
			//System.out.println("Clicked "+i+" time and Project Name = "+ProjectName);
			System.out.println("ProjectName   =  --------- "+ProjectName);
			FECls.Button_Type("xpath", "//*[@id=\"favouritesIcon\"]/ul/li["+i+"]").click();
			Thread.sleep(2000);
			//FECls.SelectDromDropDownWithHover("Monitor", "//*[@id=\"LOCK_Monitor\"]", "xpath");
			//FECls.Button_Type("xpath", "//*[@id=\"LOCK_Daily Reporting\"]").click();
			//FECls.Button_Type("xpath", "//*[@id=\"SRPT_fGrid-normal-body\"]/div/div/div/table/tbody/tr/td[1]/div").click();
			driver.switchTo().frame("content");
			FECls.Button_Type("xpath", "//*[@id=\"SRPT_fGrid-normal-body\"]/div/div/div/table/tbody/tr/td[1]/div").click();
			/*
			List<WebElement> fram1 = driver.findElements(By.tagName("iframe"));
			int framecount1 = fram1.size();
			System.out.println("frame count 1 = "+framecount1);
			System.out.println("Moved to Frame content");
			*/
		//	Thread.sleep(2500);
			//WebDriverWait wt = new WebDriverWait();
			 // To change to the frame so that below status
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            // Wait until the element is visible
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(FECls.Button_Type("name", "Self Reporting")));
            System.out.println("Web Driver wait success");
            FlashElement.highLighterWebElementMethod(element,driver);
            element.click();
            // Interact with the element			
			//FECls.Button_Type("name", "Self Reporting").click();
            driver.switchTo().frame(1);
			Thread.sleep(1500);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[3]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[4]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[5]/td[2]/Select").selectByIndex(3);
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[6]/td[2]/Select").selectByIndex(3);
			//System.out.println("Crossed 6");
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[8]/td[2]/Select").selectByIndex(3);
			//System.out.println("Crossed 7");
			FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[7]/td[2]/Select").selectByIndex(3);
			//System.out.println("Crossed 8");
			//FECls.selecFromdown_OneValue("xpath", "//*[@id=\"TableData_1_0\"]/tbody/tr[9]/td[2]/Select").selectByIndex(3);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("content");
			//System.out.println("Again Switch back to content Frame");
			FECls.Button_Type("xpath","//*[@class=\"ButtonBg  \"]/tbody/tr/td/Table/tbody/tr/td/input").click(); // Save Button
			Thread.sleep(5000);
			driver.switchTo().frame(1);
			us.UpdateStatus_Data(); //To validate the status either Red, Amber or Green
			System.out.println(ProjectName +"Project Status Update END");
			driver.switchTo().defaultContent();
			System.out.println("switchTo().defaultContent()");
			Thread.sleep(2000);
	 		ProjectName = "";
	 		System.out.println("Loop = "+i);
			}
		//	System.out.println ("Project Name = "+FECls.Button_Type("xpath", "//*[@id=\"projectIcon\"]/ul/li[1]/a").getText());

		}
}

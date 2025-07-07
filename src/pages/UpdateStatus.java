package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Constants.Constants;
import base.DateTime;
import base.FindElementsCls;
import utils.WriteExcelData;

public class UpdateStatus {
	public WebDriver driver;
	public static String iconcolor,Overall_Proj_status ;
	WebElement icon;

	public UpdateStatus(WebDriver driver) {
		this.driver = driver;
	}

	public void UpdateStatus_Data()throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		icon = null;
		iconcolor="";
		icon = FECls.TextField_Type("xpath", "//*[@id=\"TableData_1_1\"]/tbody/tr/td[2]/Strong/span");
		iconcolor= icon.getAttribute("class");
		Overall_Proj_status = "";
		Assert.assertEquals(iconcolor, Constants.Greencolor);
		//Additional verification.
		  String[] projName = SelectProjectThoughFavMenu.ProjectName.split(">", 2); //To Get only project name from this variable

		 	// for (String a : projName)
	       	// {
	       	// System.out.println("projName = " +projName);
	       	// }

	        if(iconcolor.equals(Constants.Redcolor))
			{
				//System.out.println("'"+projName[0]+"' "+"Project Overall Health is RED");
				Overall_Proj_status = "RED";
			}
			else if(iconcolor.equals(Constants.Ambercolor))
				{
				//System.out.println("'"+projName[0]+"' "+"Project Overall Health is AMBER");
				Overall_Proj_status = "AMBER";
				}
			else if(iconcolor.equals(Constants.Greencolor))
				{
				//System.out.println("'"+projName[0]+"' "+"Project Overall Health is GREEN");
				Overall_Proj_status = "GREEN";
				}

			else if(iconcolor.equals(Constants.Greycolor))
			{
				//System.out.println("'"+projName[0]+"' "+"Project Overall Health is NOT UPDATED");
				Overall_Proj_status = "NOT UPDATED";
			}

			WriteExcelData wed = new WriteExcelData();
			DateTime dt = new DateTime();
			// This need to be written in excel
			wed.writeExcel("ProjectStatus_Update", projName[0] +" Project Status is " +UpdateStatus.Overall_Proj_status+" at "+dt.getDateandTime());
			/*
			 * System.out.println(projName[0] +" Project Status is "
			 * +UpdateStatus.Overall_Proj_status+" at "+dt.getDateandTime());
			 * */
			 System.out.println("Result stored in Excel");


			}
}

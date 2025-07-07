package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.FindElementsCls;
import utils.FlashElement;
public class LoginToSmartBase {
public WebDriver driver;
	public LoginToSmartBase(WebDriver driver) {
			this.driver = driver;
	}

	public void Login_Microsoft_Screen(String username1) throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);

		FECls.TextField_Type("name", "loginfmt").clear();
		System.out.println("Color = "+FECls.TextField_Type("name", "loginfmt").getCssValue("color"));
		FECls.TextField_Type("name", "loginfmt").sendKeys(username1);
		FlashElement.highLighterWebElementMethod1(FECls.TextField_Type("name", "loginfmt"),driver,"yellow");
		//FlashElement.highLighterWebElementMethod(FECls.TextField_Type("name", "loginfmt"),driver);
		//Thread.sleep(5000);
		FECls.Button_Type("xpath", "//*[@id=\"idSIButton9\"]").click();
		}
	
	public void Login_Microsoft_Screen_Continuebutton() throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		FECls.Button_Type("xpath", "//*[@id=\"idSIButton9\"]").click();
		}

	public void Login_Microsoft_Screen_Yesbutton() throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		FECls.Button_Type("id", "KmsiCheckboxField").click();
		FECls.Button_Type("xpath", "//*[@id=\"idSIButton9\"]").click();
		}

	public void Login(String username, String password) throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		FECls.TextField_Type("name", "UserName").clear();
		FECls.TextField_Type("name", "UserName").sendKeys(username);
		FECls.TextField_Type("name", "Password").clear();
		FECls.TextField_Type("name", "Password").sendKeys(password);
		FECls.Button_Type("xpath", "//*[@id=\"submitButton\"]").click();
		}
	public void passwordScreen(String password) throws Exception{
		FindElementsCls FECls = new FindElementsCls(driver);
		FECls.TextField_Type("name", "passwd").clear();
		FECls.TextField_Type("name", "passwd").sendKeys(password);
		Thread.sleep(3000);
		FECls.Button_Type("id", "idSIButton9").click();
		}


}

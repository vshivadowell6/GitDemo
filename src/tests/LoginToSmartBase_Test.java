package tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginToSmartBase;
import utils.TestDataProvider;
//@Test(priority = 1)
public class LoginToSmartBase_Test {
	public static Properties prop1 = new  Properties();

	@Test(priority = 1, groups = "Login", dataProviderClass = TestDataProvider.class, dataProvider = "logincreds1")
	public static void LoginCreds(String username, String password, String sample) throws Exception
	{


		/*
		 * System.out.println("User name = "+username+" and Password = "+password);
		 * System.out.println("sample = "+sample);G
		 */
    	BaseClass bc = new BaseClass();
    	bc.setup();
		LoginToSmartBase lg = new LoginToSmartBase(BaseClass.driver);
		if (BaseClass.prop.getProperty("browserName").equalsIgnoreCase("Edge"))
		{
			System.out.println("Login Skipped because Of INFO EDGE browser");
		}
		else
		{
		lg.Login_Microsoft_Screen(username);
		lg.passwordScreen(password);
		//lg.Login(username, password);
		lg.Login_Microsoft_Screen_Continuebutton();
		lg.Login_Microsoft_Screen_Yesbutton();
		System.out.println("Login successful");
		Assert.assertEquals(true, true);
		System.out.println("^^^^^^^^^^");
	}
	}
}

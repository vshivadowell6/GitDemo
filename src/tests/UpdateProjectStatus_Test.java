package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.SelectProjectThoughFavMenu;

public class UpdateProjectStatus_Test {

	@Test(groups = "Login", dependsOnMethods = "tests.LoginToSmartBase_Test.LoginCreds")
	// @Test(groups = "Login")
	public void UpdateProjectStatus() throws Exception {
		SelectProjectThoughFavMenu sp = new SelectProjectThoughFavMenu(BaseClass.driver);
		// LoginToBank_Test lt = new LoginToBank_Test();
		sp.UpdateProjectStatus_Data();
		System.out.println("*************Finished Status Update for all the Projects*************");
	}
}

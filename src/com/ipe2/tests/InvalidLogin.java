package com.ipe2.tests;

import org.testng.annotations.Test;
import com.ipe2.pages.LoginPage;
import generics.BaseTest;
import generics.UtilityLib;

public class InvalidLogin extends BaseTest{
	
	@Test(priority = 2)
	public void testInvalidLogin()
	{
		int rc = UtilityLib.getRowCount(INPUT_PATH, "InvalidLogin");
		System.out.println("Row count ==>"+rc);
		
		for(int i=1; i<=rc; i++)
		{
			String un = UtilityLib.getCellValue(INPUT_PATH, "InvalidLogin", i, 0);
			String pw = UtilityLib.getCellValue(INPUT_PATH, "InvalidLogin", i, 1);
			System.out.println("Value of username ==>"+un);
			System.out.println("Value of pass ==>"+pw);
			LoginPage l = new LoginPage(driver);
			l.setUserName(un);
			l.setPassword(pw);           
			l.clickLogin();
			l.verifyErrMsgIsDisplayed();
		}
		
	}

}

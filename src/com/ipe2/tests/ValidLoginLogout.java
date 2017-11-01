package com.ipe2.tests;

import org.testng.annotations.Test;

import com.ipe2.pages.EnterTimeTrackPage;
import com.ipe2.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class ValidLoginLogout extends BaseTest {
	
	@Test(priority = 1)
	public void testValidLoginLogout() throws InterruptedException
	{
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
		String hp = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 2);
		String lp = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 3);
		System.out.println("Value of username ==>"+un);
		System.out.println("Value of pass ==>"+pw);
		System.out.println(pw);
		LoginPage l = new LoginPage(driver);
		Thread.sleep(1000);
		l.setUserName(un);
		Thread.sleep(1000);
		l.setPassword(pw);
		Thread.sleep(1000);
		l.clickLogin();
		
		EnterTimeTrackPage e =  new EnterTimeTrackPage(driver);
		e.verifyTitle(hp);
		Thread.sleep(1000);
		e.clickLogout();
		l.verifyTitle(lp);
	}

}

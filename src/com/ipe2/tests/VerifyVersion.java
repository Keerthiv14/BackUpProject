package com.ipe2.tests;

import org.testng.annotations.Test;
import com.ipe2.pages.EnterTimeTrackPage;
import com.ipe2.pages.LicensePage;
import com.ipe2.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class VerifyVersion extends BaseTest {
	
	@Test(priority = 3)
	public void testVerifyVersion() throws InterruptedException
	{
		String un = UtilityLib.getCellValue(INPUT_PATH, "VerifyVersion", 1, 0);
		String pw = UtilityLib.getCellValue(INPUT_PATH, "VerifyVersion", 1, 1);
		LoginPage l = new LoginPage(driver);
		String version = l.getVersion();
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLogin();
		
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		e.clickSettings();
		e.clickLicenses();
		
		LicensePage lc = new LicensePage(driver);
		lc.verifyProductEdition(version);
		e.clickLogout();
	}

}

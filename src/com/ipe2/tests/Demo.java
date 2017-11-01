package com.ipe2.tests;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generics.BaseTest;

public class Demo extends BaseTest{
	
	@Test
	public static void SampleTest()
	{
		Reporter.log("HI", true);
		Assert.fail();
	}	

}

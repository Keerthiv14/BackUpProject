package com.ipe2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import generics.BasePage;


public class LicensePage extends BasePage {
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement productEdition;	
	
	
	public LicensePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyProductEdition(String eValue)
	{
		String aValue = productEdition.getText();
		Assert.assertEquals(aValue, eValue);
	}

}

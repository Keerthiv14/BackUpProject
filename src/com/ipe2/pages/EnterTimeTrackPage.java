package com.ipe2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generics.BasePage;

public class EnterTimeTrackPage extends BasePage{
	
	@FindBy(id="logoutLink")
	private WebElement logoutLNK;
	
	@FindBy(xpath = "//div[contains(text(),'Settings') and @class = 'popup_menu_label']")
	private WebElement settings;
	
	@FindBy(linkText = "Licenses")
	private WebElement licenses;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);		
	}
	
	public void clickLogout()
	{
		logoutLNK.click();
	}
	
	public void clickSettings()
	{
		settings.click();
	}
	
	public void clickLicenses()
	{
		licenses.click();
	}
	

}

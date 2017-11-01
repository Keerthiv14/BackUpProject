package generics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import generics.FWListener;
import generics.IAuoConst;

@Listeners(FWListener.class)
public abstract class BaseTest implements IAuoConst {
	public WebDriver driver;
	
	@BeforeSuite
	public void setDriverPath()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		Reporter.log("Before SUite Executed", true);
	}
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException	
	{
		driver = new ChromeDriver();
		String ITOValue = UtilityLib.getPropertyValue(CONFIG_PATH,"ITO");
		long intITO = Long.parseLong(ITOValue);
		System.out.print(intITO);
		driver.manage().timeouts().implicitlyWait(intITO, TimeUnit.SECONDS);
		String URL = UtilityLib.getPropertyValue(CONFIG_PATH, "URL");
		driver.get(URL);
		
	}
	  
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}
}

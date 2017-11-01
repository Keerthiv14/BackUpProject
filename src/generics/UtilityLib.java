package generics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityLib 
{
	/**
	 * Takes the screenshot of page
	 * @param  driver specify the browser
	 * @param path specify the path to be stored
	 * @author Keerthi
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public static String getPropertyValue(String path, String key) throws FileNotFoundException, IOException
	{
		String v = "";
		try
		{
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v = p.getProperty(key);
		}
		catch(Exception e)
		{
			
		}
		return v;
		
	}	
	
	public static void getScreenShot(WebDriver driver, String path)
	{
		try
		{
			TakesScreenshot t = (TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile , new File(path));
		}
		catch(Exception e)
		{
			
		}
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static String getCellValue(String path, String sheet, int r, int c)
	{
		String v = "";
		try
		{		
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();			
		}
		catch(Exception e)
		{
			
		}
		return v;
		
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public static String now()
	{
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yy-hh-mm-ss");		
		return s.format(new Date());	
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	public static int getRowCount(String path, String sheet)
	{
		int r = 0;
		try
		{
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			r= wb.getSheet(sheet).getLastRowNum();		
		}
		catch(Exception e)
		{
			
		}
		return r;
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	public static void getScreenShot(String path)
	{
		try
		{
			Robot r = new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage img = r.createScreenCapture(new Rectangle(d));
			ImageIO.write(img, "png", new File(path));
		}
		catch(Exception e)
		{
			
		}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
	}	
	
}

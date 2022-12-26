package AmazonLogin_Page;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPage 
{
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver", "G:\\Selenium&  web driver\\22nov new version\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void loginWithRightCredentials() throws InterruptedException, IOException
	{
		boolean contbtn=driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).isEnabled();
		Thread.sleep(2000);
	//driver.findElement(By.xpath("//input[@id='continue']")).isEnabled();
	if(contbtn=false)
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		File dest= new File("C:\\Users\\LENOVO\\eclipse-workspace\\Amazon TestNg\\AmazonScreenshot");
		FileHandler.copy(source, dest);
		
	}
	
		
	}
	
	@Test
	public void checkHello() throws IOException
	{
		
	boolean Hello=	driver.findElement(By.xpath("//a[@id='nav-global-location-popover-link']")).isDisplayed();
		if(Hello=true)
		{
			System.out.println("case if pass==" + Hello);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		System.out.println(src);
		File dest=new File("C:\\Users\\LENOVO\\git\\AmazonTest\\Amazon TestNg\\AmazonScreenshot");
		FileHandler.copy(src, dest);
		
		
		
		
		}
	
	
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
		

}

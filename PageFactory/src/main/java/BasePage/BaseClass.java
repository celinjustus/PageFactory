package BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import Testutil.Testutil;

public class BaseClass {
	public static WebDriver driver;
	FileInputStream fis;
	public static Properties pro;
public BaseClass(){
	File Src=new File("C:\\Software\\Automation\\PageFactory\\src\\main\\java\\Config\\Config.properties");
	try {
		fis=new FileInputStream(Src);
		pro=new Properties();
		pro.load(fis);
			 
		 
	} catch (Exception e)
	{
		System.out.println("Exception"+e.getMessage());
		} 
	
	}
public static void initialization(){
	String browsers=pro.getProperty("browser");
	if(browsers.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","C:\\Software\\Automation\\PageFactory\\src\\resources\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
			}else if(browsers.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver","C:\\Software\\Automation\\PageFactory\\src\\resources\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Testutil.wait,TimeUnit.SECONDS);
	driver.get(pro.getProperty("url"));
}
@AfterMethod
public void closebrowser(){
	driver.quit();
	
}
}

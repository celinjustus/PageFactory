package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BaseClass;
import pages.Homepage;
import pages.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage L;
	Homepage H;
	public LoginTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		L=new LoginPage();
		
	}
@Test(priority=1)
public void Loginuser()
{
	H=L.login(pro.getProperty("username"), pro.getProperty("password"));
	Assert.assertTrue(true);
	}
@Test(priority=2)
public void verifypagetitle(){
	String title=L.validatepagetitle();
	Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
}
@Test(priority=3)
public void displaylogo(){
Boolean logo=L.displaycrmlogo();
Assert.assertTrue(logo);
}


}

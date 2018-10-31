package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BaseClass;
import Testutil.Testutil;
import pages.Contacts;
import pages.Homepage;
import pages.LoginPage;

public class HomepageTest extends BaseClass{
	LoginPage L;
	Homepage H;
	Contacts C;
	Testutil T;
	public HomepageTest(){
		super();
	}
@BeforeMethod
public void setup(){
initialization();
T=new Testutil();
L=new LoginPage();
H=L.login(pro.getProperty("username"), pro.getProperty("password"));
}
@Test(priority=1)
public void verifypagetitle(){
	String title=H.verifypagetitle();
	Assert.assertEquals(title, "abc");
}
@Test(priority=2)
public void navigatecontactpage(){
	T.frame();
	C=H.clickcontacts();
}
@Test(priority=3)
public void verifyusername(){
	boolean name=H.verifyusername();
	Assert.assertTrue(name);
}

}

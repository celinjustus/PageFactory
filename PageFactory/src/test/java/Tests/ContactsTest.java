package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePage.BaseClass;
import Testutil.Testutil;
import pages.Contacts;
import pages.Homepage;
import pages.LoginPage;

public class ContactsTest extends BaseClass{
	LoginPage login;
	Homepage home;
	Testutil testut;
	Contacts contact;
	String sheetname="createcontacts";
	public ContactsTest(){
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		testut=new Testutil();
		contact=new Contacts();
		login=new LoginPage();
		home=login.login(pro.getProperty("username"),pro.getProperty("password"));
        testut.frame();	
		contact=home.clickcontacts();
	}
	@DataProvider
	public Object[][] getdatafromexcel(){
		Object data[][]=testut.getTestData(sheetname);
				return data;
	}
	@Test(dataProvider="getdatafromexcel")
	public void createcontacts(String title,String firsttname,String lastname,String company){
		home.mouseactions();
	contact.form(title, firsttname, lastname, company);
	}

}

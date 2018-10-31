package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasePage.BaseClass;

public class Contacts extends BaseClass {
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(id="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	public Contacts(){
		PageFactory.initElements(driver, this);
	}
	public String verifypagetitle(){
		return driver.getTitle();
	}
	public void form(String title,String firsname,String lasname,String Copany){

Select S=new Select(driver.findElement(By.name("title")));
S.selectByVisibleText(title);
firstname.sendKeys(firsname);
lastname.sendKeys(lasname);
company.sendKeys(Copany);
	}
}
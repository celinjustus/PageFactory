package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePage.BaseClass;

public class Homepage extends BaseClass{
	@FindBy(xpath="//td[contains(text(),'user:Naveen k')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contacts;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Deals;
	@FindBy(xpath="//a[contains(text(),'Task')]")
	WebElement Task;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
	}
	public String verifypagetitle(){
		return driver.getTitle();
	}
	public Contacts clickcontacts(){
		Contacts.click();
		return new Contacts();
	}
	public Deals clickdeals(){
		Deals.click();
		return new Deals();
	}
	public Task click(){
		Task.click();
		return new Task();
	}
	public boolean verifyusername(){
		return usernamelabel.isDisplayed();
	}
	public void mouseactions(){
		Actions A= new Actions(driver);
		A.moveToElement(Contacts).build().perform();
		Contacts.click();
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BasePage.BaseClass;

public class LoginPage extends BaseClass {

public LoginPage(){
	PageFactory.initElements(driver, this);
	
}
@FindBy(name="username")
WebElement username;
@FindBy(name="password")
WebElement password;
@FindBy(xpath="//input[@type='submit']")
WebElement loginBtn;
@FindBy(xpath="//button[contains(text(),'signup')]")
WebElement signup;
@FindBy(xpath="//img[contains(@class,'img-responsive')]")
WebElement crmlogo;

public Homepage login(String name,String pass){
	username.sendKeys(name);
	password.sendKeys(pass);
	loginBtn.click();
	return new Homepage();
}
public String validatepagetitle(){
	return driver.getTitle();
}
public boolean displaycrmlogo(){
	return crmlogo.isDisplayed();
}
}

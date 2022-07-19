package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Login or register']")
	WebElement link_LoginRegister;
	
	@FindBy(xpath="//button[@title='Continue']")
    WebElement btn_continue; 
	
	
	@FindBy(xpath="//button[@title='Login']")
	WebElement btn_login;
	
	public void clickLoginReg()
	{
		link_LoginRegister.click();
	}
	
	public void clickContinue()
	{
		btn_continue.click();
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
  
	//@FindBy(xpath="//a[normalize-space()='Login or register']")
	//WebElement link_LoginRegister;  
	
	
	@FindBy(xpath="//input[@id='loginFrm_loginname']")
	WebElement  txt_LoginName;   
	
	@FindBy(xpath="//input[@id='loginFrm_password']")
	WebElement  txt_Password;   
	
	@FindBy(xpath="//button[@title='Login']")
	WebElement   btn_Login;
	
	@FindBy(xpath="//span[@class='maintext']")
	WebElement  msgHeading;
	
	public void setLoginName(String name)
	{
		txt_LoginName.sendKeys(name);
	}
	
	public void setPassword(String pwd)
	{
		txt_Password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
}

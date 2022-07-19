package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
    @FindBy(xpath="//input[@id='AccountFrm_firstname']")
    WebElement txtFirstName;
    
    
    @FindBy(xpath="//input[@id='AccountFrm_lastname']")
    WebElement txtLastName;
    
    @FindBy(id="AccountFrm_email")
    WebElement txtEmail;
    
    @FindBy(name="telephone")
	WebElement txtTelephone;
    
    @FindBy(name="fax")
	WebElement txtFax;
    
    @FindBy(id="AccountFrm_company")
    WebElement txtCompany;
    
    @FindBy(id="AccountFrm_address_1")
    WebElement txtAddress;
    
    @FindBy(id="AccountFrm_city")
    WebElement txtCity;
    
    @FindBy(xpath="//select[@id='AccountFrm_zone_id']")
    WebElement drpdn_Region;
    
    @FindBy(id="AccountFrm_postcode")
    WebElement txtZipcode;
    
    @FindBy(xpath="//select[@id='AccountFrm_country_id']")
    WebElement drpdn_Country;
    
    @FindBy(id="AccountFrm_loginname")
    WebElement txtLoginName;
    
    @FindBy(id="AccountFrm_password")
    WebElement txtPassword;
    
    @FindBy(id="AccountFrm_confirm")
    WebElement txtConfirmPassword;
    
   // @FindBy(xpath="//input[@id='AccountFrm_newsletter0']")
   // WebElement rdbtn_Subscribe;
    
    @FindBy(xpath="//input[@id='AccountFrm_agree']")
    WebElement chkdPolicy;
    
    @FindBy(xpath="//button[@title='Continue']")
	WebElement btnContinue;
    
    @FindBy(xpath="//span[@class='maintext']")
	WebElement msgConfirmation;
	
    
    public void setFirstName(String fname)
    {
    	txtFirstName.sendKeys(fname);
    }
    public void setLastName(String lname)
    {
    	txtLastName.sendKeys(lname);
    }
    
    public void setEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    
    public void setTelephone(String tel)
	{
    	txtTelephone.sendKeys(tel);
	}
    
    public void setFax(String fax)
    {
    	txtFax.sendKeys(fax);
    }
    
    public void setCompany(String company)
    {
    	txtCompany.sendKeys(company);
    }
    public void setAddress(String address)
    {
    	txtAddress.sendKeys(address);
    }
    
    public void setCity(String city)
    {
    	txtCity.sendKeys(city);
    }
    public void setRegion(String region)
    {
    	Select dropdown_region=new Select(drpdn_Region);
    	dropdown_region.selectByVisibleText(region);
    	
    }
    public void setZipCode(String zipcode)
    {
    	txtZipcode.sendKeys(zipcode);
    }
    
    public void setCountry(String country)
    {
    	Select dropdown_country=new Select(drpdn_Country);
    	dropdown_country.selectByVisibleText(country);
    }
    
    
    public void setLoginName(String loginname)
    {
    	txtLoginName.sendKeys(loginname);
    }
   
    
    public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfpwd)
	{
		txtConfirmPassword.sendKeys(cnfpwd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		
	try
	{
		return(msgConfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
}
}
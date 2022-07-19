package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	@Test(groups={"regression","master"})
	public void test_account_Registration() throws InterruptedException 
	{
		logger.info(" Starting TC_001_AccountRegistration ");
		try
		{
	  	driver.get(rb.getString("appURL"));
	  	logger.info("Home page displayed");
	  	driver.manage().window().maximize();
	  	
	  	
	  	HomePage hp=new HomePage(driver);
	  	hp.clickLoginReg();
	  	logger.info("clicked on loginregister");
	  	hp.clickContinue();
		logger.info("clicked on continue");
	  	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	  	regpage.setFirstName("Arun");
		logger.info("provided first name");
	  	regpage.setLastName("Joshi");
		logger.info("provided last name");
	  	//Thread.sleep(2000);
	  	regpage.setEmail(randomestring()+"@gmail.com");
	  	logger.info("provided Email");
	  	regpage.setTelephone("12321414");
	  	logger.info("provided Telephone number");
	  	regpage.setFax("123123");
	  	logger.info("provided Fax number");
	  	regpage.setCompany("Sofy Techm");
	  	logger.info("provided Company name");
	  	regpage.setAddress("Hyderabad");
	  	logger.info("provided Address");
	  	regpage.setCity("Hyderabad");
	  	logger.info("provided City");
		regpage.setCountry("India");
		logger.info("provided Country");
	  	regpage.setRegion("Andhra Pradesh");
	  	logger.info("provided region");
	  	regpage.setZipCode("506024");
	  	logger.info("provided zipcode");
	  	//regpage.setLoginName(randomestring());
	  	regpage.setLoginName("rajuk123");
	  	logger.info("provided Login name");
	  	Thread.sleep(2000);
	  	regpage.setPassword("raju123");
	  	logger.info("provided password");
	  	regpage.setConfirmPassword("raju123");
	  	logger.info("provided confirm password");
	  	regpage.setPrivacyPolicy();
	  	logger.info("Set Privacy Policy ");
	  	regpage.clickContinue();
	  	logger.info("Clicked on Continue ");
	  	Thread.sleep(2000);
	  	String expectedmsg=driver.findElement(By.xpath("//span[@class='maintext']")).getText();
	  	String confmsg=regpage.getConfirmationMsg();
	  	
	  	if(confmsg.equals(expectedmsg))
	  	{
	  		logger.info("Account Registration Success ");
	  		Assert.assertTrue(true);
	  	}
	  	else
	  	{
	  		logger.error("Account Registration Failed");
	  		captureScreen(driver,"test_account_Registration");
	  		Assert.assertTrue(false);
	  	}
		}
		catch(Exception e)
		{
			logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
	  	logger.info(" Finished TC_001_AccountRegistration ");
	  	}

}

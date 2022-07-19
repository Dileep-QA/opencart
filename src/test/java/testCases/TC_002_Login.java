package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info("Starting TC_002_Login");
		try
		{
			driver.get(rb.getString("appURL"));
             logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			HomePage hp=new HomePage(driver);
			hp.clickLoginReg();
			logger.info("clicked on loginregister");
			
			Loginpage lp=new Loginpage(driver);
			lp.setLoginName(rb.getString("login"));
			logger.info("Provided Login ");
			
			lp.setPassword(rb.getString("password"));
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			boolean targetpage = lp.isMyAccountPageExists();
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver,"test_Login");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login ");
	}

}

package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData")
	public void test_loginDDT(String name,String pwd,String exp)
	{
		logger.info(" Starting TC_003_LoginDDT ");
		try
		{
			driver.get(rb.getString("appURL"));
            logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickLoginReg();
			logger.info("clicked on loginregister");
			
			Loginpage lp=new Loginpage(driver);
			lp.setLoginName(name);
			logger.info("Provided Login ");
			
			lp.setPassword(pwd);
			logger.info("Provided Password ");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
			
			boolean targetpage = lp.isMyAccountPageExists();
			
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
				{
					logger.info("Login Success");
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login Failed ");
					Assert.assertTrue(false);
				}
			}
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{		
					logger.error("Login Failed ");
					Assert.assertTrue(true);
				}
			}
		}catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info("Finished TC_003_LoginDDT ");
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 
	{
		
		String path=".\\testData\\abantecart_LoginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
				
	}
	
		
		
}



package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginTest;
import pageObject.MyAccountPage;
import testBase.TestBase;
import utilities.XLUtility;

public class TC_003_LoginDDT extends TestBase

{
	@Test (dataProvider= "LoginData")
	
	public void test_LoginDDT(String email, String pwd, String exp)
	

	{
		logger.info("Starting TC_003_LoginDDT");
	
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home page displayed");
		
			driver.manage().window().maximize();
		
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount");
			hp.clickLogin();
			logger.info("clicked on Login");
			
			LoginTest lt=new LoginTest(driver);
			
			lt.setEmail(email);
			logger.info("provided email");
			
			lt.setPassword(pwd);
			logger.info("provided pwd");
			
			lt.clickLogin();
			logger.info("clicked on Login");
			
			boolean targetpage=lt.MyAccountPageExist();
			if (exp.equals("valid"))
			{
				if (targetpage==true)
				{
					logger.info("Login Success");
					
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login Failed");
					Assert.assertTrue(false);
				}
			}
			if (exp.equals("invalid"))
			{
				if (targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					logger.error("Login Failed");	
					Assert.assertTrue(true);
				}
			}
		}
		catch (Exception e)
		{
			logger.fatal("Login failed");
			Assert.fail();
		}
		logger.info(" Finished TC_003_LoginDDT ");
	}
			
		
		
		
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path=".\\testData\\Opencart_LoginData.xlsx";
			
			XLUtility xlutil=new XLUtility(path);
			
			int totalrows=xlutil.getRowCount("Sheet1");
			int totalcols=xlutil.getCellCount("Sheet1", 1);
			
			String logindata[][]=new String[totalrows][totalcols];
			
			for (int i=1; i<=totalrows; i++)
			{
				for (int r=0; r<totalcols; r++)
				{
					 logindata[i-1][r]=xlutil.getCellData("Sheet1", i, r);
				}
			}
			return logindata;
			
		
	}
			
}
		

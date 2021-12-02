package testCases;
// This is created by Sridhar
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginTest;
import testBase.TestBase;

public class TC_002_Login extends TestBase
{
	@Test (groups = {"sanity", "master"})
	public void test_Login() throws IOException
	{
		try
		{
		logger.info("Starting TC_002_Login");
		
		driver.get(rb.getString("appURL"));
		logger.info("Home page displayed");
		
		driver.manage().window().maximize();
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		
		hp.clickLogin();
		logger.info("clicked on Login");
		
		LoginTest lt=new LoginTest(driver);
		
		lt.setEmail(rb.getString("email"));
		logger.info("provided email");
		
		lt.setPassword(rb.getString("password"));
		logger.info("provided pwd");
		
		lt.clickLogin();
		logger.info("clicked on Login");
		
		/*boolean targetpage=lt.MyAccountPageExist();
		if (targetpage==true)
		{
			logger.info("Login is successful");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Login is failed");
			captureScreen(driver, "test_Login");
			Assert.assertTrue(false);
		}*/
	}
		catch (Exception e)
		{
			logger.fatal("login failed");
			Assert.fail();
		}
		logger.info("finished TC_002_Login");
		
		
	}

}

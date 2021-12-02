package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.TestBase;

public class TC_001_AccoiuntRegistration extends TestBase
{
	@Test (groups = {"regression", "master"})
	public void test_account_registration() 
	{
		logger.info("started TC_001_AccoiuntRegistration");
		
		try
		{			
		driver.get(rb.getString("appURL"));
		logger.info("launched website");
		
		driver.manage().window().maximize();
		
		HomePage HP=new HomePage(driver);
		HP.clickMyAccount();
		logger.info("clicked on MyAccount");
		
		HP.clickRegister();
		logger.info("clicked on Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("John");
		logger.info("clicked on FirstName");
		
		regpage.setLastName("Bell");
		logger.info("clicked on LastName");
		
		regpage.setEmail(randomestring()+ "@gmail.com");
		logger.info("clicked on Email");
		
		regpage.setTel("9920158471");
		logger.info("clicked on Telephone");
		
		regpage.setPassword("abc123");
		logger.info("clicked on Passowrd");
		
		regpage.setConfirmPassword("abc123");
		logger.info("clicked ConfirmPassowrd");
		
		regpage.setPrivacyPolicy();
		logger.info("clicked on setPolicy");
		
		regpage.clickContinue();
		logger.info("clicked on Continue");
		
		String conmsg=regpage.getConfirmation();
		if (conmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "test_account_registration");
			logger.error("Account Registration failed");
			Assert.assertTrue(false);
			
		}
		
		}
		catch (Exception e)
		{
			logger.fatal("Account Registration failed");
			Assert.fail();
		}
		logger.info("Finished TC_001_AccoiuntRegistration");
		
	}

}

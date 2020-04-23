package com.inetBanking.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws IOException
	{
		
		logger.info("Url is opened");
		
		LoginPage Lp = new LoginPage(driver);
		Lp.SetUsername(username);
		logger.info("Entered Username");

		Lp.SetPassword(password);
		logger.info("Entered Password");

		Lp.LoginButton();	
		logger.info("Login Button Clicked");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);	
		logger.info("Login test Successful");

		}
		else
		{
			captureScreen(driver, "TC_LoginTest_001");
			Assert.assertTrue(false);
			logger.info("Login test failed");

		}
	}
}

package com.inetBanking.Testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerpage;
import com.inetBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("User name is provided");

		lp.SetPassword(password);
		logger.info("Password is provided");

		lp.LoginButton();
		Thread.sleep(3000);
		
		AddCustomerpage addcustmr = new AddCustomerpage(driver);
		addcustmr.clickAddNewCustomer(); // click add Customer button
		logger.info("providing customer details....");

		addcustmr.custName("Pikaa");
		addcustmr.custgender("female");
		addcustmr.custdob("07", "13", "1995");
		addcustmr.custaddress("hydssasd");
		addcustmr.custcity("HYd");
		addcustmr.custstate("Telangana");
		addcustmr.custpinno("123456");
		addcustmr.custtelephoneno("1234567891");
		
		String email = RandomString()+"@gmail.com";// randomly generated string 
		addcustmr.custemailid(email);
		addcustmr.custpassword("gyqhgwks");
		
		addcustmr.custsubmit();
		Thread.sleep(3000);
		

		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	
	}
	
	
}

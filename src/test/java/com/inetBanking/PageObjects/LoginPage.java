package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Demo guru ID: mngr256598

	//PW: dybYjUv


	public class LoginPage {
		WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver)
		
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
			//Login Username
			@FindBy(name ="uid")
			@CacheLookup

			public WebElement LoginUname;
			
			//Login Password
			@FindBy(name="password")
			@CacheLookup
			public WebElement LoginPw;
			
			//Login button
			@FindBy(name="btnLogin")
			@CacheLookup
			public WebElement LoginBtn;
			
			//Logout button
			@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
			@CacheLookup
			public WebElement LogoutBtn;
			
			
		public void SetUsername(String Uname) 
		{
			LoginUname.sendKeys(Uname);
		}
		
		public void SetPassword(String UPW) 
		{
			LoginPw.sendKeys(UPW);
		}
		public void LoginButton() 
		{
			LoginBtn.click();
		}
		public void LogoutButton() 
		{
			LogoutBtn.click();
		}
}
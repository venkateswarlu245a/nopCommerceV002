package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	//@Test(threadPoolSize = 2)
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		System.out.println("Thread ID---------->"+Thread.currentThread().getId());
		
		logger.info("*************** TC_LoginTest_001 ************************");
		logger.info("*************** Starting test case execution  ************************");
		
		driver.get(baseURL);
		
		logger.debug("Opening URL");
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Providing login details");
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		logger.info("***************Verifying login ************************");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			logger.info("Login Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.debug("Login Failed");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}
		
		logger.info("*************** Ending test case  ************************");
		
	}
		
	
}

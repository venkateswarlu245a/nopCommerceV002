package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginTestDDT(String user,String pwd) throws InterruptedException, IOException
	{
		logger.info("*************** TC_LoginDDT_002 ************************");
		logger.info("*************** Starting test case execution  ************************");
		
		driver.get(baseURL);
		
		logger.debug("Opening URL");
		
		LoginPage lp=new LoginPage(driver);
		
		logger.info("Providing login details");
		
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		logger.info("***************Verifying login ************************");
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			lp.clickLogout();
			logger.info("Login Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.debug("Login Failed");
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}
		
		logger.info("*************** Ending test case  ************************");
		
	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j);
			}
		}
		
		return logindata;
	}
	
	
}












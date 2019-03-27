package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddcustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		logger.info("********* TC_AddCustomerTest_003 ********* ");
		logger.info("*********    Add new customer test case started   *****************");
		
		logger.info("*********    Login to application  *****************");
		driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		logger.info("*********    Login is completed  *****************");
		
		logger.info("*********  proving customer details  *****************");
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
				
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		
		String email = randomestring() + "@gmail.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");
		
		//Registered - default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		addcust.setCustomerRoles("Guest");
				
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setGender("Male");
		
		addcust.setFirstName("Pavan");
		addcust.setLastName("Kumar");
		
		addcust.setDob("7/05/1985"); // Format: D/MM/YYY
		
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
	
		addcust.clickOnSave();
		
		logger.info("********* Add customer validation started *****************");
		
		String msg=driver.findElement(By.tagName("body")).getText();
	
		if(msg.contains("The new customer has been added successfully"))
				{
				Assert.assertTrue(true);
				logger.info("Add new customer test passed...");
				}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.error("Add new customer test failed...");
		}
	
	}
		
}

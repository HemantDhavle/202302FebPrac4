package com.leaftaps.qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.leaftaps.qa.pages.welcomePage;
import com.leaftaps.qa.utlity.CONSTANTS;
import com.leaftaps.qa.utlity.excelUtility;

public class welcomePageTest extends baseTest
{
	public welcomePage wPage;
	@BeforeTest
	public void doLogin()
	{
		wPage=lPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
	}
	
	@Test(priority = 1)
	public void validateCRMLinkTest()
	{
		String welcomePageText  = wPage.doValidateCRMLink();
		AssertJUnit.assertEquals(welcomePageText, CONSTANTS.expected_welcomeText);
	}
	
	@Test(priority = 2)
	public void validatedoCRMLinkClickable()
	{
		if(wPage.doCRMLinkClickable())
		{
			System.out.println("Link is clickable");
		}
		else
		{
			System.out.println("Link is not clickable");
		}
	}
	@Test(priority = 3)
	public void clickCRMLink()
	{
		wPage.doClickCRMLink();
	}

}

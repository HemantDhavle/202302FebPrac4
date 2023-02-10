package com.leaftaps.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.leaftaps.qa.pages.homePage;
import com.leaftaps.qa.pages.welcomePage;

public class homePageTest extends baseTest
{
	public homePage hPage;
	public welcomePage wPage;
	
	@BeforeClass
	public void doLogin()
	{
		wPage = lPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		hPage = wPage.doClickCRMLink();
		
	}
	@Test
	public void validateHomePageHeader()
	{
		hPage.validateHomePageTitle();
	}
	
	
	@Test
	public void validateMenuItem()
	{
		hPage.validateHomePageMenuItem();
		
	}

}

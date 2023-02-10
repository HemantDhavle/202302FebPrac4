package com.leaftaps.qa.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.leaftaps.qa.pages.loginPage;

public class loginTest extends baseTest 
{
	//Logger LOGGER = LogManager.getLogger(loginTest.class);

	@Test
	public void doLogin()
	{
		lPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		//LOGGER.info("asdasdasdasdasd");
	}
	
//	@DataProvider
//	public Object[][] loadData()
//	{
//		return excelUtility.getData(CONSTANTS.sheet_Name);
//	}
}

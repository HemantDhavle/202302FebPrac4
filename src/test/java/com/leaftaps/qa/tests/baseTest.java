package com.leaftaps.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.leaftaps.qa.factory.browserFactory;
import com.leaftaps.qa.pages.casePage;
import com.leaftaps.qa.pages.homePage;
import com.leaftaps.qa.pages.loginPage;
import com.leaftaps.qa.pages.welcomePage;

public class baseTest 
{
	public WebDriver driver;
	public Properties prop;
	public browserFactory factory;
	public loginPage lPage;
	public welcomePage wPage;
	public homePage hPage;
	public casePage cPage;
	
	@BeforeClass
	public void setUp()
	{
		factory = new browserFactory();
		prop = factory.init_prop();
		driver = factory.init_browser(prop);
		lPage = new loginPage(driver);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}

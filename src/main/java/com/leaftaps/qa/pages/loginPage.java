package com.leaftaps.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.leaftaps.qa.factory.browserFactory;
import com.leaftaps.qa.utlity.CONSTANTS;
import com.leaftaps.qa.utlity.elementUtils;

public class loginPage 
{
	Logger LOGGER = LogManager.getLogger(loginPage.class);

	public WebDriver driver;
	public elementUtils eU;
	private By username_Xpath = By.xpath("//*[@id='username']");
	private By password_Xpath = By.xpath("//*[@id='password']");
	private By loginBtn_Xpath = By.xpath("//*[@id='login']/p[3]/input");
	
	//Logger log = LogManager.getLogger(browserFactory.class);

	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
		eU = new elementUtils(driver);
	}
	
	public welcomePage doLogin(String username, String password)
	{
		eU.doSendKey(username_Xpath, username);
		LOGGER.info(username+ " as user name entered successfully");
		eU.doSendKey(password_Xpath, password);
		LOGGER.info(password+ " as password entered successfully");
		eU.doClick(loginBtn_Xpath);
		LOGGER.info("Login successfully");
		return new welcomePage(driver);
		
	}
	

}

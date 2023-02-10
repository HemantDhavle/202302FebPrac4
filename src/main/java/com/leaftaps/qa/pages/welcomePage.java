package com.leaftaps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.leaftaps.qa.utlity.elementUtils;

public class welcomePage 
{
	public WebDriver driver;
	public elementUtils eU;
	private By welComeText_Xpath = By.xpath("//*[@id='label']/a");
	public welcomePage(WebDriver driver)
	{
		this.driver = driver;
		eU = new elementUtils(driver);
	}
	public String doValidateCRMLink()
	{
		eU.waitForElementToPresent(welComeText_Xpath);
		return eU.getText(welComeText_Xpath);
	}
	
	public Boolean doCRMLinkClickable()
	{
		return eU.isClickable(welComeText_Xpath);
	}
	
	public homePage doClickCRMLink()
	{
		eU.doClick(welComeText_Xpath);
		return new homePage(driver);
	}
}

package com.leaftaps.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.leaftaps.qa.utlity.CONSTANTS;
import com.leaftaps.qa.utlity.elementUtils;

public class homePage 
{
	public WebDriver driver;
	public loginPage lPage;
	public  elementUtils eU;
	private By homePageTextXpath = By.xpath("//*[@id='sectionHeaderTitle_myHome']");
	private String menuBeforeXpath = "//*[@id='ext-gen41']/ul/li[";
	private String menuAfterXpath = "]/div/div/div/div/div/a";
	private By menuOptions = By.xpath("//*[@id='ext-gen41']/ul/li");
	
	public homePage(WebDriver driver)
	{
		this.driver = driver;
		//lPage = new loginPage(driver);
		eU = new elementUtils(driver);
	}
	
	public void validateHomePageTitle()
	{
		String homePageActualText= eU.getText(homePageTextXpath);
		System.out.println("home Page header is "+homePageActualText);
		Assert.assertEquals(homePageActualText, CONSTANTS.homePage_ExpecteText);
	}
	
	public casePage validateHomePageMenuItem()
	{
		List<WebElement> options = eU.getElements(menuOptions);
		int menuCount = options.size();
		String temp = null;
		int counter = 1;
		for(int i =1;i<=menuCount;i++)
		{
			String menu = menuBeforeXpath+i+menuAfterXpath;
			String menuOption  = eU.getElement(By.xpath(menu)).getText();
			temp = menuOption;
			System.out.println(temp);
			if(temp.equalsIgnoreCase(CONSTANTS.caseOption))
			{
				System.out.println("Item found "+temp);
				counter = i;
				break;
			}
			//counter = i;
			System.out.println("Temp value out side the loop" +temp +" and counter "+counter);
		}
		
		System.out.println(counter);
		eU.doClick(By.xpath(menuBeforeXpath+counter+menuAfterXpath));
		return new casePage(driver);
		
	}
	


}

package com.leaftaps.qa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.leaftaps.qa.pages.casePage;
import com.leaftaps.qa.pages.homePage;
import com.leaftaps.qa.pages.welcomePage;
import com.leaftaps.qa.utlity.CONSTANTS;
import com.leaftaps.qa.utlity.excelUtility;

public class casePageTest extends baseTest
{
	public welcomePage wPage;
	public homePage hPage;
	public casePage cPage;
	@BeforeClass
	public void doNavigateToTheCasePage()
	{
		wPage = lPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		hPage = wPage.doClickCRMLink();
		cPage = hPage.validateHomePageMenuItem();
	}
	
	@Test(priority=1)
	public void doValidateCasePageHeader()
	{
		String text = cPage.doValidateCasePageHeader();
		System.out.println("CasePage header is "+text);
		AssertJUnit.assertEquals(text, CONSTANTS.casePageHeaderText);
	}
	
	@Test(priority=2)
	public void doLoadTableData()
	{
		cPage.loadCaseTableData();
	}
	
	@Test(dataProvider="loadData", priority=3)
	public void creteCaseTest(String account, String contact, String priority, String type, String reason, 
			String subject, String description, String note) throws InterruptedException
	{
		cPage.createCase(account, contact, priority, type, reason, subject, description, note);
		
	}
	
	@DataProvider
	public Object[][] loadData()
	{
		return excelUtility.getData(CONSTANTS.createCase_Sheet);
	}

}

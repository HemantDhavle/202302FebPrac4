package com.leaftaps.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.leaftaps.qa.utlity.CONSTANTS;
import com.leaftaps.qa.utlity.elementUtils;
import com.leaftaps.qa.utlity.excelReader;

public class casePage 
{
	public WebDriver driver;
	public elementUtils eU;
	public excelReader reader;
	private By casePageHeaderXpath = By.xpath("//*[@id='sectionHeaderTitle_cases']");
	private  String beforeXpathCaseTable = "/html/body/div[6]/div/div[2]/div[2]/div[2]/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[";
	private String priority_after_Xpath = "]/table/tbody/tr[1]/td[1]/div/b";
	private String caseID_after_Xpath  = "]/table/tbody/tr[1]/td[2]/div/b/a";
	private String subject_after_Xpath = "]/table/tbody/tr[1]/td[3]/div/b/a";
	private String status_after_Xpath = "]/table/tbody/tr[1]/td[4]/div/b";
	private String type_after_Xpath = "]/table/tbody/tr[1]/td[5]/div/b";
	private String reason_after_Xpath = "]/table/tbody/tr[1]/td[6]/div/b";
	private String totalRowsCurrentPage = "/html/body/div[6]/div/div[2]/div[2]/div[2]/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div";
	private By createCaseLinkXpath  = By.xpath("//*[@class='shortcuts']/li[2]/a");
	private By initialAccountTxtXpath = By.xpath("//*[@id='createCaseForm_accountPartyId']");
	private By initialContactTxtXpath = By.xpath("//*[@id='createCaseForm_contactPartyId']");
	private By priorityDropdownXpath = By.xpath("//*[@id='createCaseForm_priority']");
	private By typeDropdownXpath = By.xpath("//*[@id='createCaseForm_custRequestTypeId']");
	private By reasonDropdownXpath = By.xpath("//*[@id='createCaseForm_custRequestCategoryId']");
	private By subjectTxtXpath =  By.xpath("//*[@id='createCaseForm_custRequestName']");
	private By descriptionTxtXpath =  By.xpath("//*[@id='createCaseForm_description']");
	private By noteTxtXpath =  By.xpath("//*[@id='createCaseForm_note']");
	private By createCaseButtonXpath  =  By.xpath("//input[@value='Create Case']");
	
	public casePage(WebDriver driver)
	{
		this.driver = driver;
		eU = new elementUtils(driver);
	}
	
	public String doValidateCasePageHeader()
	{
		eU.waitForElementToPresent(casePageHeaderXpath);
		return eU.getText(casePageHeaderXpath);
	}
	
	public void loadCaseTableData()
	{
		reader = new excelReader(CONSTANTS.data_file_path);
		reader.addSheet("Case Data");
		reader.addColumn("Case Data", "Priority");
		reader.addColumn("Case Data", "Case Id");
		reader.addColumn("Case Data", "Subject");
		reader.addColumn("Case Data", "Status");
		reader.addColumn("Case Data", "Type");
		reader.addColumn("Case Data", "Reason");
		
		List<WebElement> totalRows = eU.getElements(By.xpath(totalRowsCurrentPage));
		int rowCount = totalRows.size();
		for(int i = 2;i<=rowCount;i++)
		{
			String priorityXpath = beforeXpathCaseTable+i+priority_after_Xpath;
			String caseIDXpath = beforeXpathCaseTable+i+caseID_after_Xpath;
			String subjectXpath = beforeXpathCaseTable+i+subject_after_Xpath;
			String statusXpath = beforeXpathCaseTable+i+status_after_Xpath;
			String typeXpath = beforeXpathCaseTable+i+type_after_Xpath;
			String reasonXpath = beforeXpathCaseTable+i+reason_after_Xpath;
			String priority = eU.getText(By.xpath(priorityXpath));
			String caseID = eU.getText(By.xpath(caseIDXpath));
			String subject = eU.getText(By.xpath(subjectXpath));
			String status = eU.getText(By.xpath(statusXpath));
			String type = eU.getText(By.xpath(typeXpath));
			String reason = eU.getText(By.xpath(reasonXpath));
			System.out.println(priority);
			System.out.println(caseID);
			System.out.println(subject);
			System.out.println(status);
			System.out.println(type);
			System.out.println(reason);
			reader.setCellData("Case Data", "Priority", i, priority);
			reader.setCellData("Case Data", "Case Id", i, caseID);
			reader.setCellData("Case Data", "Subject", i, subject);
			reader.setCellData("Case Data", "Status", i, status);
			reader.setCellData("Case Data", "Type", i, type);
			reader.setCellData("Case Data", "Reason", i, reason);	
		}
	}
	
	public void createCase(String account, String contact, String priority, String type, String reason, 
			String subject, String description, String note) throws InterruptedException
	{
		eU.waitForElementToPresent(createCaseLinkXpath);
		eU.doClick(createCaseLinkXpath);
		Thread.sleep(2000);
		eU.doSendKey(initialAccountTxtXpath, account);
		Thread.sleep(2000);
		eU.doSendKey(initialContactTxtXpath, contact);

		Thread.sleep(2000);
		eU.doClick(priorityDropdownXpath);
		Thread.sleep(2000);
		eU.selectDropdownByVisibleText(priorityDropdownXpath, priority);
		
		Thread.sleep(2000);
		eU.doClick(typeDropdownXpath);
		Thread.sleep(2000);
		eU.selectDropdownByVisibleText(typeDropdownXpath, type);
		
		Thread.sleep(2000);
		eU.doClick(reasonDropdownXpath);
		Thread.sleep(2000);
		eU.selectDropdownByVisibleText(reasonDropdownXpath, reason);
		Thread.sleep(2000);
		eU.doSendKey(subjectTxtXpath, subject);
		Thread.sleep(2000);
		eU.doSendKey(descriptionTxtXpath, description);
		Thread.sleep(2000);
		eU.doSendKey(noteTxtXpath, note);
		Thread.sleep(2000);
		eU.doClick(createCaseButtonXpath);
		
	}

}

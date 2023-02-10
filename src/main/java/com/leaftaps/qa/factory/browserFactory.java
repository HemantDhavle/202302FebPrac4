package com.leaftaps.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.leaftaps.qa.utlity.CONSTANTS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserFactory 
{
	public Properties prop;
	public WebDriver driver;
	public optionManager om;
	private static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();	
	Logger log = LogManager.getLogger(browserFactory.class);
	
	  private static final Logger logger = LogManager.getLogger(browserFactory.class);  

	public WebDriver init_browser(Properties prop)
	{
		om = new optionManager(prop);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\chromedriver.exe");
			tl.set(new ChromeDriver(om.chromeOption()));
			log.info(browserName+" successfully opened");
			logger.info(browserName+" successfully opened");

		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\chromedriver.exe");
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver(om.firefoxOption()));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tl.set(new EdgeDriver(om.edgeOption()));
		}
		else
		{
			System.out.println("Please pass the correct browserName "+browserName);
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tl.get();
	}
	
	public Properties init_prop()
	{
		FileInputStream fs = null;
		prop = new Properties();
		try {
			fs = new FileInputStream(CONSTANTS.config_file_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}

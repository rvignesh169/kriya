package com.self.fb.org.functionalLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public static Properties loadProperties() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("..\\fb\\src\\resources\\java\\com\\self\\fb\\org\\properties\\config.properties"));
		prop = new Properties();
		prop.load(reader);
		return prop;
	}
	
	public static WebDriver getDriver(String browser, String url){
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "..\\fb\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "..\\fb\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "..\\fb\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt((prop.getProperty("implicitWaitTime"))), TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void type(WebElement element, String value ) throws Exception {
		try {
			if(element.isDisplayed()==true && element.isEnabled() == true) {
			element.sendKeys(value);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void click(WebElement element) {
		try {
			if(element.isDisplayed()==true && element.isEnabled()==true) {
			element.click();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getPageTitle() {
		return driver.getTitle();
	}

	
	public static void closeBrowser() {
		driver.quit();
	}
	
}

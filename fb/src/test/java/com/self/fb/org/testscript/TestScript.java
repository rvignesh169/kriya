package com.self.fb.org.testscript;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.self.fb.org.functionalLibrary.BaseClass;
import com.self.fb.org.pom.HomePage;
import com.self.fb.org.pom.NewsFeedPage;
import com.self.fb.org.pom.Weather;

import junit.framework.Assert;

public class TestScript extends BaseClass {
	public WebDriver driver;
	public Properties prop;
	
	@BeforeTest
	public void launchBrowser() throws Exception {
		prop=loadProperties();
		driver =getDriver(prop.getProperty("browser"),prop.getProperty("url"));	
	}
	
	
	@Test
	public void hompageNavigation() throws Exception {
		HomePage lp = new HomePage();
		driver.get("https://www.channelnewsasia.com/");
		String newItemTitle = (lp.getNewItemTitle()).getText();
		lp.getNewItemTitle().click();
		NewsFeedPage np = new NewsFeedPage();
		String articleTiltle = np.getArticleTitle().getText();
		Assert.assertEquals(newItemTitle, articleTiltle);
		np.scrollTo(np.getSecondExpand());
		String secArTitle = np.getArticleTitle().getText();
		np.getSecondExpand().click();
		String arcTitle = np.getArticleTitle().getText();
		Assert.assertEquals(secArTitle, arcTitle);
	}
	
	@Test
	public void allSectionNavigation() throws Exception {
		HomePage lp = new HomePage();
		driver.get("https://www.channelnewsasia.com/news/international");
		lp.getAllSection().click();
		lp.getsingapore().click();
		String newItemTitle = (lp.getNewItemTitle()).getText();
		lp.getNewItemTitle().click();
		NewsFeedPage np = new NewsFeedPage();
		String articleTiltle = np.getArticleTitle().getText();
		Assert.assertEquals(newItemTitle, articleTiltle);
		np.scrollTo(np.getSecondExpand());
		String secArTitle = np.getArticleTitle().getText();
		np.getSecondExpand().click();
		String arcTitle = np.getArticleTitle().getText();
		Assert.assertEquals(secArTitle, arcTitle);
	}
	
	@Test
	public void weatherNavigation() throws Exception {
		HomePage lp = new HomePage();
		driver.get("https://www.channelnewsasia.com/news/international");
		lp.getAllSection().click();
		lp.getWeather().click();
		Weather w = new Weather();
		String kweather = w.getKualalumpurWeather().getText();
		Assert.assertEquals(kweather, "thunderstorm");
		String maTemp = w.getMaxTemp().getText();
		Assert.assertEquals(maTemp, "33°");
		String mitemp = w.getMinTemp().getText();
		Assert.assertEquals(mitemp, "24°");
	}
	
	@AfterTest
	public void QuitBrowser() {
		closeBrowser();	
	}
}

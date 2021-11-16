package com.self.fb.org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.self.fb.org.functionalLibrary.BaseClass;

public class HomePage extends BaseClass {
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='feature-card__heading-link feature-card__heading-link--']")
	private   WebElement newItemTitle;
	
	@FindBy(xpath = "//span[@class='all-section-menu main-menu__link']")
	private  WebElement allSection;
	
	@FindBy(xpath = "//a[@href='/singapore']")
	private  WebElement singapore;
	
	@FindBy(xpath = "//a[@href='https://www.channelnewsasia.com/weather']")
	private  WebElement weather;
	
	public WebElement getNewItemTitle() {
		return newItemTitle;
	}

	public WebElement getAllSection() {
		return allSection;
	}

	public WebElement getsingapore() {
		return singapore;
	}

	public WebElement getWeather() {
		return weather;
	}
	
	public void setNewItemTitled(WebElement newItemTitle) {
		this.newItemTitle = newItemTitle;
	}
	
	public void setAllSectionn(WebElement allSection) {
		this.allSection = allSection;
	}
	
	public void setsingapore(WebElement singapore) {
		this.singapore = singapore;
	}
	
	public void setWeather(WebElement weather) {
		this.weather = weather;
	}
	
}

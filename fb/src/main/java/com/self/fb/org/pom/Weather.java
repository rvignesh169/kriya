package com.self.fb.org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.self.fb.org.functionalLibrary.BaseClass;

public class Weather extends BaseClass {
	public Weather() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='kuala lumpur']//following-sibling::div")
	WebElement kualalumpurWeather;
	
	@FindBy(xpath="//div[text()='kuala lumpur']//parent::div/following-sibling::div//span[1]")
	WebElement maxTemp;
	
	@FindBy(xpath="//div[text()='kuala lumpur']//parent::div/following-sibling::div//span[2]")
	WebElement minTemp;

	public WebElement getKualalumpurWeather() {
		return kualalumpurWeather;
	}

	public void setKualalumpurWeather(WebElement kualalumpurWeather) {
		this.kualalumpurWeather = kualalumpurWeather;
	}
	
	public WebElement getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTempd(WebElement maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	public WebElement getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(WebElement minTemp) {
		this.minTemp = minTemp;
	}
}

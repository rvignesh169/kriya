package com.self.fb.org.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.self.fb.org.functionalLibrary.BaseClass;

public class NewsFeedPage extends BaseClass {

	public NewsFeedPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//article//h1")
	WebElement articleTitle;
	
	@FindBy(xpath="//article[3]//a[@class='article__read-full-story-button article__read-full-story-button--']")
	WebElement secondExpand;
	
	@FindBy(xpath="//article[3]//h1")
	WebElement secondArticleTitle;

	public WebElement getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(WebElement articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	public WebElement getSecondExpand() {
		return secondExpand;
	}

	public void setSecondExpand(WebElement secondExpand) {
		this.secondExpand = secondExpand;
	}
	
	public WebElement getSecondArticleTitle() {
		return secondArticleTitle;
	}

	public void setSecondArticleTitle(WebElement secondArticleTitle) {
		this.secondArticleTitle = secondArticleTitle;
	}
	
	public void scrollTo(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
}
}
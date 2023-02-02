package com.qsp.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
	WebDriver driver;
	
	public TrelloHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/home' and not(contains(@data-uuid,'mobile_logo'))]")
	private WebElement trelloLogo;
	
	@FindBy(xpath="//a[text()='Log in' and contains(@class,'Buttonsstyles')]")
	private WebElement loginLinkText;
	
	@FindBy(xpath="//a[text()='Get Trello for free'  and not(@tabindex='-1')]")
	private WebElement getTrelloForFree;

	public WebElement getTrelloLogo() {
		return trelloLogo;
	}

	public WebElement getLoginLinkText() {
		return loginLinkText;
	}

	public WebElement getGetTrelloForFree() {
		return getTrelloForFree;
	}
	
	

}

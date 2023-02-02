package com.qsp.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToTrelloPage {
	WebDriver driver;
	public LoginToTrelloPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user")
	private WebElement emailTextfield;
	
	@FindBy(id="login")
	private WebElement continueButton;
	
	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
}

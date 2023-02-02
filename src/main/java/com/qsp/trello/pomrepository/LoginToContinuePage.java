package com.qsp.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToContinuePage {
	WebDriver driver;
	public LoginToContinuePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="password")
	private WebElement passwordTextfield;
	
	@FindBy(id="login-submit")
	private WebElement loginButton;
	
	@FindBy(className = "css-g42x0s")
	private WebElement passwordFlutterButton;
	
	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getPasswordFlutterButton() {
		return passwordFlutterButton;
	}
	
}

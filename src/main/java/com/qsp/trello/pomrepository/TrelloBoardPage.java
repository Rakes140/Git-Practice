package com.qsp.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardPage {
	WebDriver driver;
	public TrelloBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(@title,'binodprusty95')]")
	private WebElement profileIcon;

	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logoutOption;

	@FindBy(xpath="//button[.='Create']")
	private WebElement createOption;

	@FindBy(xpath="//button[@class='R2Zt2qKgQJtkYY']//span[text()='Create board']")
	private WebElement createBoardButton;

	@FindBy(xpath="//input[contains(@class,'nch-textfield__input')]")
	private WebElement boardTitleTextfield;

	@FindBy(xpath="//form//button[.='Create']")
	private WebElement CreateButton;
	
	@FindBy(xpath="//span[text()='Board deleted.']")
	private WebElement boardDeletedMessage;
	
	@FindBy(xpath="//h3[text()='YOUR WORKSPACES']/..//div[@class='board-tile-details is-badged']")
	private WebElement workspaceCraetedBoard;
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getLogoutOption() {
		return logoutOption;
	}

	public WebElement getCreateOption() {
		return createOption;
	}

	public WebElement getCreateBoardButton() {
		return createBoardButton;
	}

	public WebElement getBoardTitleTextfield() {
		return boardTitleTextfield;
	}

	public WebElement getCreateButton() {
		return CreateButton;
	}

	public WebElement getBoardDeletedMessage() {
		return boardDeletedMessage;
	}

	public WebElement getWorkspaceCraetedBoard() {
		return workspaceCraetedBoard;
	}
}

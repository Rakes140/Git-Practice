package com.qsp.trello.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreatedBoardPage {
	WebDriver driver;
	public CreatedBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(@class,'hCk0lP6IjMWs52 SyQNhGiXQPXGMA')]")
	private WebElement showMenuButton;
	
	@FindBy(xpath="//h3[text()='Menu']")
	private WebElement menuOption;
	
	@FindBy(xpath="//a[contains(text(),'More')]")
	private WebElement moreLinkText;
	
	@FindBy(xpath="//a[contains(text(),'Close board…')]")
	private WebElement closeBoardLinkText;

	@FindBy(xpath="//input[@type='submit' and @value='Close']")
	private WebElement closeOption;
	
	@FindBy(xpath="//button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteBoardButton;
	
	@FindBy(xpath="//h2[@title='Delete board?']/../..//button[text()='Delete']")
	private WebElement deleteButton;
	
	@FindBys(@FindBy(xpath="//div[@class='list-header-extras']/a"))
	private List<WebElement> listMenus;
	
	@FindBy(xpath="(//a[contains(@class,'list-header-extras-menu')])[1]")
	private WebElement listMenu;
	
	@FindBy(linkText = "Archive this list")
	private WebElement archiveAllCardsLinkText;
	
	@FindBy(xpath="//span[text()='Add a list']")
	private WebElement addAListOption;
	
	@FindBy(className = "list-name-input")
	private WebElement listNameInput;
	
	@FindBy(css ="input[value='Add list']")
	private WebElement addListButton;

	@FindBy(xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel-edit']")
	private WebElement cancelListCreation;
	
	@FindBy(xpath ="(//div[contains(@class,'list-header-target')])[1]")
	private WebElement listNo1;
	
	@FindBy(xpath = "(//div[@class='list js-list-content'])[2]")
	private WebElement listNo2;
	
	@FindBy(xpath ="(//a[contains(@class,'open-card-composer')])[1]")
	private WebElement openCardComposerlink;
	
	@FindBy(xpath = "//textarea[@class='list-card-composer-textarea js-card-title']")
	private WebElement cardTitleTextfield;
	
	@FindBy(css  = "input[value='Add card']")
	private WebElement addCardButton;
	
	@FindBy(xpath = "//a[@class='icon-lg icon-close dark-hover js-cancel']")
	private WebElement cancelCardCreationLink;
	
	@FindBy(linkText = "Sort by…")
	private WebElement cardSortLink;
	
	@FindBy(linkText = "Card name (alphabetically)")
	private WebElement alphabeticallyCardSortLink;
	
	@FindBy(xpath = "//span[text()='Successfully sorted list']")
	private WebElement successfullysortedMessage;
	
	@FindBy(css  = "span[class='list-card-title js-card-name']")
	private List<WebElement> cardsCount;
	
	@FindBy(xpath="//button[.='Create']")
	private WebElement createOption;

	@FindBy(xpath="//button[@class='R2Zt2qKgQJtkYY']//span[text()='Create board']")
	private WebElement createBoardButton;

	@FindBy(xpath="//input[contains(@class,'nch-textfield__input')]")
	private WebElement boardTitleTextfield;

	@FindBy(xpath="//form//button[.='Create']")
	private WebElement createButton;
	
	@FindBy(linkText = "Move list…")
	private WebElement moveListLinkText;
	
	@FindBy(className = "js-select-board")
	private WebElement boardDropdown;
	
	@FindBy(xpath = "//span[text()='Move list']/../..//input[@type='submit']")
	private WebElement moveButton;
	
	public WebElement getShowMenuButton() {
		return showMenuButton;
	}

	public WebElement getMenuOption() {
		return menuOption;
	}

	public WebElement getMoreLinkText() {
		return moreLinkText;
	}

	public WebElement getCloseBoardLinkText() {
		return closeBoardLinkText;
	}

	public WebElement getCloseOption() {
		return closeOption;
	}

	public WebElement getPermanentlyDeleteBoardButton() {
		return permanentlyDeleteBoardButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public List<WebElement> getListMenus() {
		return listMenus;
	}

	public WebElement getListMenu() {
		return listMenu;
	}

	public WebElement getArchiveAllCardsLinkText() {
		return archiveAllCardsLinkText;
	}

	public WebElement getAddAListOption() {
		return addAListOption;
	}

	public WebElement getListNameInput() {
		return listNameInput;
	}

	public WebElement getAddListButton() {
		return addListButton;
	}

	public WebElement getCancelListCreation() {
		return cancelListCreation;
	}

	public WebElement getListNo1() {
		return listNo1;
	}

	public WebElement getListNo2() {
		return listNo2;
	}

	public WebElement getOpenCardComposerlink() {
		return openCardComposerlink;
	}

	public WebElement getCardTitleTextfield() {
		return cardTitleTextfield;
	}

	public WebElement getAddCardButton() {
		return addCardButton;
	}

	public WebElement getCancelCardCreationLink() {
		return cancelCardCreationLink;
	}

	public WebElement getCardSortLink() {
		return cardSortLink;
	}

	public WebElement getAlphabeticallyCardSortLink() {
		return alphabeticallyCardSortLink;
	}

	public WebElement getSuccessfullysortedMessage() {
		return successfullysortedMessage;
	}

	public List<WebElement> getCardsCount() {
		return cardsCount;
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
		return createButton;
	}

	public WebElement getMoveListLinkText() {
		return moveListLinkText;
	}

	public WebElement getBoardDropdown() {
		return boardDropdown;
	}

	public WebElement getMoveButton() {
		return moveButton;
	}
	
	

}

package com.qsp.trello.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;
import com.qsp.trello.pomrepository.CreatedBoardPage;
import com.qsp.trello.pomrepository.LoginToContinuePage;
import com.qsp.trello.pomrepository.LoginToTrelloPage;
import com.qsp.trello.pomrepository.LogoutOfYourAtlassianAccountPage;
import com.qsp.trello.pomrepository.TrelloBoardPage;
import com.qsp.trello.pomrepository.TrelloHomePage;

public class TrelloEndToEnd extends BaseClass {

	@Test
	public void launchTrello() throws IOException
	{
		driver.get(fileUtils.readKeyValue("mainurl"));
	}
	@Test
	public void verifyTrelloHomepage() throws IOException
	{
		String expectedHomepageTitle=fileUtils.readKeyValue("trellohomepagetitle");
		String actualHomepageTitle=driver.getTitle();
		assertEquals(actualHomepageTitle, expectedHomepageTitle,"Trello HomePage Title Mismatch");
	}
	@Test
	public void homeLoginOptionClick()
	{
		TrelloHomePage trelloHome=new TrelloHomePage(driver);
		trelloHome.getLoginLinkText().click();
	}
	@Test
	public void verifyLoginpage() throws IOException
	{
		String expectedLoginpageTitle=fileUtils.readKeyValue("loginpagetitle");
		String actualLoginpageTitle=driver.getTitle();
		String expectedLoginpageUrl=fileUtils.readKeyValue("loginpageurl");
		String actualLoginpageUrl=driver.getCurrentUrl();
		assertEquals(actualLoginpageTitle, expectedLoginpageTitle,"Loginpage Title Mismatch");
		assertEquals(actualLoginpageUrl, expectedLoginpageUrl,"Loginpage Url Mismatch");
	}
	@Test
	public void login() throws IOException
	{
		LoginToTrelloPage loginToTrello=new LoginToTrelloPage(driver);
		LoginToContinuePage loginToContinue=new LoginToContinuePage(driver);
		loginToTrello.getEmailTextfield().sendKeys(fileUtils.readKeyValue("emailid"));
		loginToTrello.getContinueButton().submit();
		webDriverUtils.WaitForCompleteTitle(driver, fileUtils.readKeyValue("logintocontinuepagetitle"));
		String expectedLoginToContinuepageTitle=fileUtils.readKeyValue("logintocontinuepagetitle");
		String actuaLoginToContinuepageTitle=driver.getTitle();
		assertEquals(actuaLoginToContinuepageTitle, expectedLoginToContinuepageTitle,"Login to continue page title mismatch.");
		loginToContinue.getPasswordTextfield().sendKeys(fileUtils.readKeyValue("password"));
		loginToContinue.getPasswordFlutterButton().click();
		loginToContinue.getLoginButton().submit();
		webDriverUtils.WaitForCompleteTitle(driver, fileUtils.readKeyValue("trelloboardpagetitle"));
	}
	@Test
	public void verifyTrelloBoardpage() throws IOException
	{
		webDriverUtils.WaitForCompleteTitle(driver, fileUtils.readKeyValue("trelloboardpagetitle"));
		String expectedTrelloBoardpageTitle=fileUtils.readKeyValue("trelloboardpagetitle");
		String actualTrelloBoardpageTitle=driver.getTitle(); 
		String actualTrelloBoardpageUrl=driver.getCurrentUrl();
		assertTrue(actualTrelloBoardpageUrl.contains(fileUtils.readKeyValue("username")));
		assertEquals(actualTrelloBoardpageTitle, expectedTrelloBoardpageTitle, "TrelloBoardPage title mismatch");
	}
	@Test
	public void logout() throws IOException
	{
		TrelloBoardPage trelloBoard=new TrelloBoardPage(driver);
		LogoutOfYourAtlassianAccountPage logoutOfYourAtlassianAccount=new LogoutOfYourAtlassianAccountPage(driver);
		trelloBoard.getProfileIcon().click();
		trelloBoard.getLogoutOption().click();
		webDriverUtils.waitForElementVisibility(driver, logoutOfYourAtlassianAccount.getLogoutButton());
		String expectedLogoutpageTitle=fileUtils.readKeyValue("logoutpagetitle");
		String actualLogoutpageTitle=driver.getTitle();
		assertEquals(actualLogoutpageTitle, expectedLogoutpageTitle,"Logout page title mismatch.");
		logoutOfYourAtlassianAccount.getLogoutButton().click();
	}
	@Test
	public void boardCreation() throws EncryptedDocumentException, IOException
	{
		TrelloBoardPage trelloBoard=new TrelloBoardPage(driver);
		trelloBoard.getCreateOption().click();

		assertTrue(trelloBoard.getCreateBoardButton().isDisplayed(), "Create board button not displayed");
		trelloBoard.getCreateBoardButton().click();

		assertTrue(trelloBoard.getBoardTitleTextfield().isDisplayed(), "Boardtitle text field not displayed");
		assertTrue(trelloBoard.getBoardTitleTextfield().isEnabled(), "Boardtitle text field not enabled");
		trelloBoard.getBoardTitleTextfield().sendKeys(excelUtils.readStringData("testcasedata", 0, 1));

		trelloBoard.getCreateButton().click();

		webDriverUtils.WaitForPartialTitle(driver, excelUtils.readStringData("testcasedata", 0, 1));
		String actualCreatedBoardPageTitle=driver.getTitle();
		String actualCreatedBoardPageUrl=driver.getCurrentUrl();
		assertTrue(actualCreatedBoardPageTitle.contains(excelUtils.readStringData("testcasedata", 0, 1)), "CreatedBoard page title mismatch");
		assertTrue(actualCreatedBoardPageUrl.contains(excelUtils.readStringData("testcasedata", 0, 1).toLowerCase()), "CreatedBoard page url mismatch");
		Reporter.log("Board Created upon verification");
	}
	@Test
	public void deleteCreatedBoard() throws IOException
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		createdBoard.getShowMenuButton().click();
		assertTrue(createdBoard.getMenuOption().isDisplayed(), "Menu option not displayed");

		createdBoard.getMoreLinkText().click();
		createdBoard.getCloseBoardLinkText().click();
		createdBoard.getCloseOption().click();
		createdBoard.getPermanentlyDeleteBoardButton().click();
		createdBoard.getDeleteButton().click();

		webDriverUtils.WaitForCompleteTitle(driver, fileUtils.readKeyValue("trelloboardpagetitle"));

		TrelloBoardPage trelloBoard=new TrelloBoardPage(driver);
		assertTrue(trelloBoard.getBoardDeletedMessage().isDisplayed(), "Board deleted Message not displayed");
	}
	@Test
	public void deleteList()
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		List<WebElement> listMenus = createdBoard.getListMenus();
		for (WebElement listMenu : listMenus) {
			listMenu.click();
			createdBoard.getArchiveAllCardsLinkText().click();
		} 
	}

	@Test
	public void createList() throws EncryptedDocumentException, IOException, InterruptedException
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		createdBoard.getAddAListOption().click();
		createdBoard.getListNameInput().sendKeys(excelUtils.readStringData("testcasedata", 1, 1));
		createdBoard.getAddListButton().click();
		createdBoard.getListNameInput().sendKeys(excelUtils.readStringData("testcasedata", 2, 1));
		createdBoard.getAddListButton().click();
		Thread.sleep(2000);
		createdBoard.getCancelListCreation().click();
	}
	@Test
	public void swapList()
	{
		Actions act = new Actions(driver);
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		act.clickAndHold(createdBoard.getListNo1()).moveToElement(createdBoard.getListNo2()).release(createdBoard.getListNo1()).build().perform();
	}

	@Test
	public void cardCreation() throws EncryptedDocumentException, IOException
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		createdBoard.getOpenCardComposerlink().click();
		for (int i = 0; i < excelUtils.totalDataCell("cardtitle", 0); i++) {
			createdBoard.getCardTitleTextfield().sendKeys(excelUtils.readStringData("cardtitle", 0, i));
			createdBoard.getAddCardButton().click();
		}
		createdBoard.getCancelCardCreationLink().click();
	}
	@Test
	public void alphabeticallyCardSort()
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		createdBoard.getListMenu().click();
		createdBoard.getCardSortLink().click();
		createdBoard.getAlphabeticallyCardSortLink().click();
		webDriverUtils.waitForElementVisibility(driver, createdBoard.getSuccessfullysortedMessage());
		assertTrue(createdBoard.getSuccessfullysortedMessage().isDisplayed(), "Successfully sorted list message not displayed");
	}
	@Test
	public void cardCount() throws EncryptedDocumentException, IOException
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		List<WebElement> cardsCount =createdBoard.getCardsCount();
		assertEquals(cardsCount.size(),excelUtils.totalDataCell("cardtitle", 0),"Card count mismatch.");
		Reporter.log("Total card count is correct upon verification");
	}
	@Test
	public void createBoardFromBoardPage() throws EncryptedDocumentException, IOException
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		createdBoard.getCreateOption().click();
		createdBoard.getCreateBoardButton().click();
		createdBoard.getBoardTitleTextfield().sendKeys(excelUtils.readStringData("testcasedata", 0, 1).concat("two"));
		createdBoard.getCreateButton().click();
		List<WebElement> listMenus = createdBoard.getListMenus();
		for (WebElement listMenu : listMenus) {
			listMenu.click();
			createdBoard.getArchiveAllCardsLinkText().click();
		}
	} 
	@Test
	public void moveFullyLoadedList() throws EncryptedDocumentException, IOException, InterruptedException
	{
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		createdBoard.getListMenu().click();
		createdBoard.getMoveListLinkText().click();
		select=new Select(createdBoard.getBoardDropdown());
		select.selectByVisibleText(excelUtils.readStringData("testcasedata", 0, 1));
		createdBoard.getMoveButton().click();
		Thread.sleep(1000);
	}
	@Test
	public void deleteBoardOnTrelloBoardPage() throws IOException
	{
		TrelloBoardPage trelloBoard=new TrelloBoardPage(driver);
		CreatedBoardPage createdBoard=new CreatedBoardPage(driver);
		trelloBoard.getWorkspaceCraetedBoard().click();		
		createdBoard.getShowMenuButton().click();
		assertTrue(createdBoard.getMenuOption().isDisplayed(), "Menu option not displayed");
		createdBoard.getMoreLinkText().click();
		createdBoard.getCloseBoardLinkText().click();
		createdBoard.getCloseOption().click();
		createdBoard.getPermanentlyDeleteBoardButton().click();
		createdBoard.getDeleteButton().click();
		webDriverUtils.WaitForCompleteTitle(driver, fileUtils.readKeyValue("trelloboardpagetitle"));
		assertTrue(trelloBoard.getBoardDeletedMessage().isDisplayed(), "Board deleted Message not displayed");
	}
}


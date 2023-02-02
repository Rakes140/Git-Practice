package com.qsp.trello.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * It Is a utility for the WebDriver of Selenium Library
 * @author Rakesh
 *
 */
public class WebDriverUtility {
	/**
	 * It can Provide implicitly wait for all invocation of findElement() and findElements() and their respective annotation.
	 * @param driver
	 */
	public void implicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * It will provide Explicitly wait for Title to load in the particular webPage
	 * @param driver
	 * @param titles
	 * @return
	 */
	
	public void WaitForCompleteTitle(WebDriver driver,String completeTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(completeTitle));
	}
	public void WaitForPartialTitle(WebDriver driver,String partialTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	public boolean waitForDOMToLoad(WebDriver driver, WebElement elementForWait, String attName, String attValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean ref = wait.until(ExpectedConditions.domAttributeToBe(elementForWait, attName, attValue));
		return ref;
	}
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * Switch the driver control to the frame by using it's index
	 * @param driver
	 * @param index
	 */
	public void frameAsIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * Switch the driver control to the frame by using it's id or name attribute value
	 * @param driver
	 * @param idOrName
	 */
	public void frameAsIdOrName(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	/**
	 * Switch the driver control to the frame by considering it as webElement after finding it using driver reference.
	 * @param driver
	 * @param frameElement
	 */
	public void frameAsWebElement(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * Switch the driver control to the parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * Switch the driver control to the default content
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
}
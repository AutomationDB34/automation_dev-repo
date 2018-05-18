package com.page.module.ll.level1activities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.ListenAndIdentifyKeywordLocators;
import com.selenium.Dynamic;
import com.testng.Assert;

public class ListenAndIdentifyKeyword extends CommonFunctionalities implements ListenAndIdentifyKeywordLocators {
	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public ListenAndIdentifyKeyword(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyListenAndIdentifyActivity() {

		// Verify the presence of the Activity container
		Assert.assertTrue(isElementPresent(LISTEN_AND_IDENTIFY_CONTAINER, LONGWAIT),
				"Listen And Identify Keyword Activity is not Loaded for the student");

	}

	/**
	 * Purpose of the method is to complete only one bundle in the Listen and
	 * Identify activity
	 */
	public void listenAndIdentifyActivity() {
		closeInstIcon();

		if(executionMode.equalsIgnoreCase("RC"))
		{
			for(int i=0;i<3;i++)
			{
				WebElement str = driver.findElement(LISTEN_AND_IDENTIFY_CONTAINER);
				String text = str.getText();
				log.info(text);
				// Click the any one of the answer tile
				safeClick(Dynamic.getNewLocator(ANSWER_TILE, text));
				// Verify the verification marks are displayed on the screen
				isElementDisplayed(Dynamic.getNewLocator(CORRECT_MARK, text));
				// Waits until the verification marks are disappear on teh screen
				waitUntilElementDisappears(Dynamic.getNewLocator(CORRECT_MARK, text));
			}
		}
		else
		{
			WebElement str = driver.findElement(LISTEN_AND_IDENTIFY_CONTAINER);
			String text = str.getText();
			log.info(text);
			// Click the any one of the answer tile
			safeClick(Dynamic.getNewLocator(ANSWER_TILE, text));
			// Verify the verification marks are displayed on the screen
			isElementDisplayed(Dynamic.getNewLocator(CORRECT_MARK, text));
			// Waits until the verification marks are disappear on teh screen
			waitUntilElementDisappears(Dynamic.getNewLocator(CORRECT_MARK, text));
		}
	}
}
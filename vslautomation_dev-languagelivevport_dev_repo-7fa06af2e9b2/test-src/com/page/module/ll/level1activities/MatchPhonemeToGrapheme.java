package com.page.module.ll.level1activities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.MatchPhonemeToGraphemeLocators;
import com.testng.Assert;

public class MatchPhonemeToGrapheme extends CommonFunctionalities implements MatchPhonemeToGraphemeLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public MatchPhonemeToGrapheme(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyActivity() {

		Assert.assertTrue(isElementPresent(ACTIVITY_CONTAINER, LONGWAIT),
				"Activity is not being displayed in Activity page");

	}

	/**
	 * Purpose of the method is to perform Qc on one bundle of the activity
	 */
	public void MatchPtoGActivity() {

		// Close the instruction icon
		closeInstIcon();
		if(executionMode.equalsIgnoreCase("RC"))
		{
			for(int i=0;i<5;i++)
			{
				// Click the any one of the answer tile
				safeClick(ANSWER_TILE);
				// Verify the verification marks are displayed on the screen
				isElementDisplayed(MARK_CONTAINER);
				// Waits until the verification marks are disappear on teh screen
				waitUntilElementDisappears(MARK_CONTAINER);
			}
		}
		else
		{
			// Click the any one of the answer tile
			safeClick(ANSWER_TILE);
			// Verify the verification marks are displayed on the screen
			isElementDisplayed(MARK_CONTAINER);
			// Waits until the verification marks are disappear on teh screen
			waitUntilElementDisappears(MARK_CONTAINER);
		}
	}
}

package com.page.module.ll.level1activities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.IdentifyWordEndingSoundLocators;
import com.testng.Assert;

public class IdentifyWordEndingSound extends CommonFunctionalities implements IdentifyWordEndingSoundLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public IdentifyWordEndingSound(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyIdentifyWordEndingSoundActivity() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR), "Identify Word Ending Sound Activity is not being displayed");
		safeClick(AUDIO_BAR);
	}


	/**
	 * Purpose of the method is to test only one bundle of the activity
	 */
	public void identifyWordEnd() {

		if(executionMode.equalsIgnoreCase("rc"))
		{
			log.info("Runnig the ListenIdentifyKeyword Activity at RC mode");
			for(int i=0;i<10;i++)
			{
				Assert.assertTrue(isElementPresent(AUDIO_ENABLED),
						"Identify Word Ending Sound Activity audio is not being played");
				safeClick(RADIO_BTN_1);
				Assert.assertTrue(isElementPresent(TICK_MARK), "Check mark after answering the bundle is not being displayed");
				// Assert.assertTrue(isElementPresent(CORRECT_WORD), "Check mark after
				// answering the bundle is not being displayed");
				String radiobtn = safeGetAttribute(RADIO_BTN_2, "disabled", LONGWAIT);
				if (radiobtn.equals("true")) {
					log.info("The other opiton is disabled");
				}
				waitUntilElementDisappears(CORRECT_WORD);
			}
		}
		else
		{
			Assert.assertTrue(isElementPresent(AUDIO_ENABLED),
					"Identify Word Ending Sound Activity audio is not being played");
			safeClick(RADIO_BTN_1);
			Assert.assertTrue(isElementPresent(TICK_MARK), "Check mark after answering the bundle is not being displayed");
			// Assert.assertTrue(isElementPresent(CORRECT_WORD), "Check mark after
			// answering the bundle is not being displayed");
			String radiobtn = safeGetAttribute(RADIO_BTN_2, "disabled", LONGWAIT);
			if (radiobtn.equals("true")) {
				log.info("The other opiton is disabled");
			}
			waitUntilElementDisappears(CORRECT_WORD);
		}
	}
}

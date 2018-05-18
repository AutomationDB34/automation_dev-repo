package com.page.module.ll.level2activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level2activities.ClosedSyllableLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class ClosedSyllable extends CommonFunctionalities implements ClosedSyllableLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	public ClosedSyllable(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to test all bundles of Closed Syllable activity
	 */
	public void closedSyllable() {
		// Conditional run for closed syllable Activity
		if (app.getProperty("App.ExecutionMode").equalsIgnoreCase("qc")) 
		{
			log.info("Runnig the closed syllable at QC mode");
			
			closeInstIcon();

			safeClick(TILE);

			if (isElementPresent(CORRECT_ANSWER)) {
				System.out.println("Correct answer selected");
				waitUntilElementDisappears(CORRECT_ANSWER);
			} else {
				System.out.println("incorrect answer selected");
				waitUntilElementDisappears(INCORRECT_ANSWER);
			}

		} else {
			log.info("Runnig the closed syllable at RC mode");

			closeInstIcon();

			// get the bundle count of the activity
			List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
			System.out.println("Bundle count:" + bundlecount.size());

			for (int bundles = 1; bundles <=bundlecount.size(); bundles++) 
			{

				safeClick(TILE,MEDIUMWAIT);

				if (isElementPresent(CORRECT_ANSWER)) {
					System.out.println("Correct answer selected");
					waitUntilElementDisappears(CORRECT_ANSWER);
				} else {
					System.out.println("incorrect answer selected");
					waitUntilElementDisappears(INCORRECT_ANSWER);
				}
				//click
			}
		}
	}

	/**
	 * Purpose of the method is to navigate to home page on completing the
	 * activity
	 */
	public void navigateToHomePagefromActivity() {
		closeInstIcon();
		safeClick(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		// mouseHover(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		safeClick(HOME_LINK, LONGWAIT);
	}

}

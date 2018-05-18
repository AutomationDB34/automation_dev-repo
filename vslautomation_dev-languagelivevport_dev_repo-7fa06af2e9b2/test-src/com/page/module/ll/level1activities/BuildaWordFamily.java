package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.BuildaWordFamilyLocators;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class BuildaWordFamily extends CommonFunctionalities implements BuildaWordFamilyLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	public BuildaWordFamily(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify whether the activity is loaded or not
	 */
	public void verifyBuildaWordFamily() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR, LONGWAIT), "Activity is not being displayed");
	}

	public void buildAWordFamilyFunction(boolean isIE) {

		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT), "Audio is not being played in the activity");

		if (isIE) {
			Point coordinates = driver.findElement(ASNWER_CONTAINER).getLocation();
			int x = coordinates.getX();
			int y = coordinates.getY();
			Dimension dimentions = driver.findElement(ASNWER_CONTAINER).getSize();
			int height = dimentions.getHeight();
			int width = dimentions.getWidth();
			try {
				Robot robotclass = new Robot();
				robotclass.mouseMove(x + height / 2, y + width / 2);
			} catch (AWTException e) {
				log.info("unable to perform key board actions" + UtilityMethods.getStackTrace());
			}
		}

		dragAndDrop(ANSWER_CHOICES_1, ASNWER_CONTAINER, LONGWAIT);

		// verify if dragged tile is wrong
		if (isElementPresent(CROSS_MARK)) {

			waitUntilElementDisappears(CROSS_MARK);
			dragAndDrop(ANSWER_CHOICES_2, ASNWER_CONTAINER, LONGWAIT);
		}
		waitForSecs(8,"Wait for wrong and correct answers to disappear and next  bundle audio to complete");
	}

	/**
	 * purpose of the method is to test one bundle of the activity in QC mode and all bundles in RC mode
	 */
	public void buildaWordFamily(boolean isIE) {
		// Conditional run for Build a word Family activity
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the Build a word Family Activity at QC mode");
			buildAWordFamilyFunction(isIE);
		}

		else {
			log.info("Runnig the Blend Activity at RC mode");
			// Count the Steps need to be completed by student
			List<WebElement> progressBars = LocatorWebElements(BUNDLE_COUNT);
			for (int progressCount = 1; progressCount <= progressBars.size(); progressCount++)
			{
				buildAWordFamilyFunction(isIE);
			}

		}
	}

}

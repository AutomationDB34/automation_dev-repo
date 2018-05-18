package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.StretchingLocators;
import com.selenium.Dynamic;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class Stretching extends CommonFunctionalities implements StretchingLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	public Stretching(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyStretchingActivity() {
		Assert.assertTrue(isElementPresent(STEP1_HEADER, LONGWAIT),
				"Stretching activity is not being displayed on page");
	}

	/**
	 * Purpose of this method is to verify the first step of the Activity
	 */
	public void step1Stretching(boolean isIE) {
		closeInstIcon();

		if (isIE) {
			Point coordinates = driver.findElement(STRETCHING_CONTAINER).getLocation();
			int x = coordinates.getX();
			int y = coordinates.getY();
			Dimension dimentions = driver.findElement(STRETCHING_CONTAINER).getSize();
			int height = dimentions.getHeight();
			int width = dimentions.getWidth();
			Robot robotclass;
			try {
				robotclass = new Robot();
				robotclass.mouseMove(2 * x + height, 2 * y + width);
			} catch (AWTException e) {
				log.info("Unable to perform the key board actions" + UtilityMethods.getStackTrace());
				e.printStackTrace();
			}

		}

		// Verify whether Step 1 is displayed or not
		Assert.assertTrue(isElementDisplayed(STEP1_HEADER),
				"Stretching activity - Step 1 is not being displayed on page");

		safeClick(AUDIO_BAR);

		// drag and drop the syllable tile into the container
		dragAndDrop(SYLLABLE_TILES, STRETCHING_CONTAINER, LONGWAIT);

		safeClick(CHECK_IT_BTN);

		if (isElementPresent(INCORRECT_CONTAINER_COLOR, LONGWAIT)) {

			waitUntilElementDisappears(INCORRECT_CONTAINER_COLOR);
			dragAndDrop(SYLLABLE_TILES, STRETCHING_CONTAINER, LONGWAIT);
			safeClick(CHECK_IT_BTN);
		}
	}

	/**
	 * Purpose of this method is to verify the second step of the Activity
	 */
	public void step2Stretching(boolean isIE) {
		closeInstIcon();
		// Verify whether Step 2 is displayed or not
		Assert.assertTrue(isElementPresent(STEP2_HEADER, LONGWAIT),
				"Stretching Activity Step 2 header is not being displayed");
		// get the syllable count in the Step 2 and drag and drop the
		// Consonant/vowel tile into the syllable container
		List<WebElement> syllablecount_1 = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count in Step 2 count:" + syllablecount_1.size());

		for (int i = 1; i <= syllablecount_1.size(); i++) {

			String str1 = "[" + Integer.toString(i) + "]";

			By ele1 = Dynamic.getNewLocator(SYLLABLE_CONTAINER, str1);
			System.out.println(ele1);

			dragAndDrop(VOWEL_TILE, ele1, LONGWAIT);
			Assert.assertTrue(isElementPresent(LETTER_BOX_PHONEME), "Phoneme color is not being displayed");
			waitForSecs(3);
		}
	}

	/**
	 * Purpose of this method is to verify the third step of the Activity
	 */
	public void step3Stretching() {

		closeInstIcon();

		// Verify whether Step 3 is displayed or not
		Assert.assertTrue(isElementPresent(STEP3_HEADER, LONGWAIT),
				"Stretching Activity - Step 3 is not being displayed in the activity");

		// Verify the audio functionality in step 3
		safeClick(AUDIO_BAR, LONGWAIT);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT), "Audio is not being played in the audio bar");

		// get the syllable count and drag and drop the tiles into the
		// syllable container
		List<WebElement> syllablecount_2 = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count in Step 3 count:" + syllablecount_2.size());

		for (int j = 1; j <= syllablecount_2.size(); j++) {

			String str2 = "[" + Integer.toString(j) + "]";

			By ele2 = Dynamic.getNewLocator(SYLLABLE_CONTAINER, str2);
			System.out.println(ele2);

			if (j / 2 == 0) {

				dragAndDrop(LETTER_TILES_F, ele2, LONGWAIT);

				waitForSecs(1);
			} else {
				dragAndDrop(LETTER_TILES_I, ele2, LONGWAIT);

				waitForSecs(1);
			}
			if (isElementPresent(CROSS_MARK)) {

				waitUntilElementDisappears(CROSS_MARK);
				dragAndDrop(LETTER_TILES_F, ele2, LONGWAIT);
				waitForSecs(1);
			}
		}

	}

	/**
	 * Purpose of this method is to verify the three steps of the Activity
	 */
	public void stretching(boolean isIE) {
		// Conditional run for Stretching Activity
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the Stretching Activity at QC mode");
			step1Stretching(isIE);
			step2Stretching(isIE);
			step3Stretching();
		} else {
			log.info("Runnig the Stretching Activity at RC mode");
			// Count the Steps need to be completed by student
			List<WebElement> progressBars = LocatorWebElements(BUNDLE_COUNT);
			for (int progressCount = 1; progressCount <= progressBars.size(); progressCount++) {
				step1Stretching(isIE);
				step2Stretching(isIE);
				step3Stretching();
			}
		}
	}

	/**
	 * Purpose of this method is to verify the Summary page of the Activity
	 */

	public void stretchingSummary() {
		waitUntilElementDisappears(STRETCHING_CONTAINER, VERYLONGWAIT);
		waitForSecs(5, "Waiting to Disappear the loading image and waitnig for page to load");
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Summary page not being displayed in the Stretching activity");
		safeClick(CONTINUE_SUMMARY);

	}
}

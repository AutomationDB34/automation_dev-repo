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
import com.page.locators.ll.level1activites.StretchingPreviewLocators;
import com.selenium.Dynamic;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class StretchingPreview extends CommonFunctionalities implements StretchingPreviewLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	ConfigManager app = new ConfigManager("App");

	public StretchingPreview(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify whether activity is loaded or not
	 */
	public void verifyStretchingPreviewActivity() {

		Assert.assertTrue(isElementPresent(STEP1_HEADER, LONGWAIT),
				"Stretching activity is not being displayed on page");
	}

	/**
	 * Purpose of this method is to verify Step 1 of the Stretching Preview
	 * activity
	 */
	public void step1StretchingPreviewActivity(boolean isIE) {
		closeInstIcon();

		// Verify whether Step 1 is displayed or not
		Assert.assertTrue(isElementPresent(STEP1_HEADER, LONGWAIT), "Step 1 header is not being displayed");

		// get the syllable count in the Step 1 and drag and drop the
		// Consonant/vowel tile into the syllable container
		List<WebElement> syllablecount_1 = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count in Step 1 count:" + syllablecount_1.size());

		for (int i = 1; i <= syllablecount_1.size(); i++) {

			String str1 = "[" + Integer.toString(i) + "]";

			By ele1 = Dynamic.getNewLocator(SYLLABLE_CONTAINER, str1);
			System.out.println(ele1);

			if (isIE) {
				Point coordinates = driver.findElement(ele1).getLocation();
				int x = coordinates.getX();
				int y = coordinates.getY();
				Dimension dimentions = driver.findElement(ele1).getSize();
				int height = dimentions.getHeight();
				int width = dimentions.getWidth();
				try {
					Robot robotclass = new Robot();
					robotclass.mouseMove(x + height / 2, y + width / 2);
				} catch (AWTException e) {
					log.info("unable to perform the keyboard actions" + UtilityMethods.getStackTrace());
				}
			}

			dragAndDrop(VOWEL_TILE, ele1, LONGWAIT);
			Assert.assertTrue(isElementPresent(LETTER_BOX_PHONEME), "Phoneme color is not being displayed");
			waitForSecs(3);
		}
	}

	/**
	 * Purpose of this method is to verify Step 2 of the Stretching Preview
	 * activity
	 */
	public void step2StretchingPreviewActivity(boolean isIE) {

		closeInstIcon();

		// Verify whether Step 2 is displayed or not
		Assert.assertTrue(isElementPresent(STEP2_HEADER, LONGWAIT),
				"Step 2 is not being displayed in the Stretching activity");

		// Verify the audio functionality in step 2
		safeClick(AUDIO_BTN, LONGWAIT);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT), "Audio is not being played in the audio bar");

		// get the syllable count and drag and drop the tiles into the
		// syllable container
		List<WebElement> syllablecount_2 = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count in Step 1 count:" + syllablecount_2.size());

		for (int j = 1; j <= syllablecount_2.size(); j++) {

			String str2 = "[" + Integer.toString(j) + "]";

			By ele2 = Dynamic.getNewLocator(SYLLABLE_CONTAINER, str2);
			System.out.println(ele2);

			if (isIE) {
				Point coordinates = driver.findElement(ele2).getLocation();
				int x = coordinates.getX();
				int y = coordinates.getY();
				Dimension dimentions = driver.findElement(ele2).getSize();
				int height = dimentions.getHeight();
				int width = dimentions.getWidth();
				try {
					Robot robotclass = new Robot();
					robotclass.mouseMove(x + height / 2, y + width / 2);
				} catch (AWTException e) {
					log.info("Unable to perform key board actions" + UtilityMethods.getStackTrace());
				}
			}

			if (j / 2 == 0) {

				dragAndDrop(LETTER_TILES_A, ele2, LONGWAIT);
				waitForSecs(1);

			} else {
				dragAndDrop(LETTER_TILES_M, ele2, LONGWAIT);
				waitForSecs(1);
			}
			if (isElementPresent(STEP2_WORNG_MARK_CONTAINER)) {

				waitUntilElementDisappears(STEP2_RIGHT_MARK_CONTAINER);
				dragAndDrop(LETTER_TILES_M, ele2, LONGWAIT);
				waitForSecs(5);
			}

		}

	}

	/**
	 * Purpose of this method is to verify the Stretching Preview activity
	 */
	public void stretchingPreview(boolean isIE) {
		// Conditional run for Stretching Preview Activity
		if (app.getProperty("App.ExecutionMode").equalsIgnoreCase("qc")) {
			log.info("Runnig the Stretching Preview at QC mode");
			step1StretchingPreviewActivity(isIE);
			step2StretchingPreviewActivity(isIE);
		} else {
			log.info("Runnig the Stretching Preview at RC mode");
			// Count the bundles need to be completed by student
			List<WebElement> progressBars = LocatorWebElements(BUNDLE_COUNT);
			for (int progressCount = 1; progressCount <= progressBars.size(); progressCount++) {
				step1StretchingPreviewActivity(isIE);
				step2StretchingPreviewActivity(isIE);
			}
		}
	}

	/**
	 * Purpose of this method is to perform quick check on one bundle of
	 * stretching activity
	 */
	public void strectchingPreviewSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Summary page not being displayed in the Stretching activity");
		safeClick(CONTINUE_SUMMARY,LONGWAIT);
	}
}

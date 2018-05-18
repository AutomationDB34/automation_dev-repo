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
import com.page.locators.ll.level1activites.StretchingWithNoErrorCorrectionLocators;
import com.selenium.Dynamic;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class StretchingWithNoErrorCorrection extends CommonFunctionalities implements StretchingWithNoErrorCorrectionLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");

	public StretchingWithNoErrorCorrection(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * purpose of this method is to verify whether activity is loaded or not
	 */
	public void verifyStretchingActivity() {

		Assert.assertTrue(isElementDisplayed(STEP1_HEADER), "Strectching activity step 1 is not being displayed");

	}

	/**
	 * purpose of this method is to verify the step 1 stretching functionality
	 * 
	 * @param isIE
	 * @throws AWTException
	 */
	public void step1Stretching(boolean isIE) {

		closeInstIcon();
		Assert.assertTrue(isElementDisplayed(STEP1_HEADER), "Strectching activity step 1 is not being displayed");

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
				log.info("unable to perform keyboar actions"+ UtilityMethods.getStackTrace());
				e.printStackTrace();
			}


		}

		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "Strectching activity step 1 audio is not being played");

		// drag and drop the syllable tile into the container
		dragAndDrop(SYLLABLE_TILES, STRETCHING_CONTAINER, LONGWAIT);

		safeClick(CHECK_IT_BTN);

	}

	/**
	 * Purpose of this method is to verify the second step of the Activity
	 */
	public void step2Stretching(boolean isIE){
		closeInstIcon();
		Assert.assertTrue(isElementDisplayed(STEP2_HEADER), "Strectching activity step 2 is not being displayed");

		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "Strectching activity step 1 audio is not being played");

		// get the syllable count in the Step 2 and drag and drop the
		// Consonant/vowel tile into the syllable container
		List<WebElement> syllablecount_1 = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count in Step 2 count:" + syllablecount_1.size());

		for (int i = 1; i <= syllablecount_1.size(); i++) {

			String str1 = "[" + Integer.toString(i) + "]";

			By ele1 = Dynamic.getNewLocator(SYLLABLE_CONTAINER, str1);
			System.out.println(ele1);

			dragAndDropwithRobots(VOWEL_TILE, ele1, LONGWAIT, isIE);
			Assert.assertTrue(isElementPresent(LETTER_BOX_PHONEME), "Phoneme color is not being displayed");
			waitForSecs(3);
		}
	}

	/**
	 * Purpose of this method is to verify the third step of the Activity
	 */
	public void step3Stretching(boolean isIE)  {

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

			dragAndDropwithRobots(LETTER_TILES_1, ele2, LONGWAIT, isIE);
			waitForSecs(3);
		}
	}

	/**
	 * Purpose of this method is to verify the three steps of the Activity
	 */
	public void stretching(boolean isIE) {
		if(executionMode.equalsIgnoreCase("RC"))
		{
			List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
			log.info("Runnig the Stretching Activity at RC mode");
			System.out.println(progressBars.size());
			for (int i = 1; i <= progressBars.size(); i++) 
			{
				step1Stretching(isIE);
				step2Stretching(isIE);
				step3Stretching(isIE);
			}
		}
		else
		{
			log.info("Runnig the Stretching Activity at QC mode");
			step1Stretching(isIE);
			step2Stretching(isIE);
			step3Stretching(isIE);
		}
	}
}

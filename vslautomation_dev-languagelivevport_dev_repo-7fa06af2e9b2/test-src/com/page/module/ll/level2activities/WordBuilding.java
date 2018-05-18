package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.WordBuildingLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class WordBuilding extends CommonFunctionalities implements WordBuildingLocators {

	private WebDriver driver;
	// private LLData llData = new LLData();
	private int incorrectanswercount;
	Logger log = Logger.getLogger(getClass());

	public WordBuilding(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify the audio functionalilty of the activity
	 */
	public void verifyAudioBarFunctionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "Word Building activity audio is not being played");
	}

	/**
	 * Purpose is to verify the Step 1 of the WordBuilding activity
	 * 
	 * @param isIE
	 * @throws AWTException
	 */
	public void step1_WordBuilding(boolean isIE) {

		closeInstIcon();

		Assert.assertTrue(isElementPresent(STEP_1_HEADER),
				"Step1 of the Word Building activity is not being displayed");

		if (isIE) {
			Point coordinates = driver.findElement(WORD_BUILDING_CONTAINER).getLocation();
			int x = coordinates.getX();
			int y = coordinates.getY();
			Dimension dimentions = driver.findElement(WORD_BUILDING_CONTAINER).getSize();
			int height = dimentions.getHeight();
			int width = dimentions.getWidth();
			try
			{
			Robot robotclass = new Robot();
			robotclass.mouseMove(2 * x + height, 2 * y + width);
			}
			catch(AWTException e)
			{
				log.info("unable to perform Robot actions at word building functionolities" + UtilityMethods.getStackTrace());

			}
		}

		dragAndDrop(SYLLABLE_TILE, WORD_BUILDING_CONTAINER, LONGWAIT);
		safeClick(CHECK_IT_BTN);

		if (isElementPresent(INCORRECT_COLOR, LONGWAIT)) {

			waitUntilElementDisappears(INCORRECT_COLOR);
			dragAndDrop(SYLLABLE_TILE, WORD_BUILDING_CONTAINER, LONGWAIT);
			safeClick(CHECK_IT_BTN);
		}
	}

	/**
	 * Purpose is to verify the Step 2 of the WordBuilding activity
	 * 
	 * @throws InterruptedException
	 */
	public void step2_WordBuilding(){

		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP_2_HEADER),
				"Step2 of the Word Building activity is not being displayed");

		List<WebElement> syllablecount = LocatorWebElements(SYLLABLE_COUNT);
		System.out.println("Syllable count in Step 2 count:" + syllablecount.size());

		for (int i = 1; i <= syllablecount.size(); i++) {

			String str1 = Integer.toString(i);

			By ele1 = Dynamic.getNewLocator(WORD_CONTAINER, str1);
			System.out.println(ele1);

			dragAndDrop(WORD_TILE_1, ele1, LONGWAIT);

			if (isElementPresent(CROSS_MARK)) {
				incorrectanswercount++;

				waitUntilElementDisappears(CROSS_MARK,40);
				waitForSecs(5);
				dragAndDrop(WORD_TILE_2, ele1, LONGWAIT);
				waitForSecs(5);
			}
		}
	}

	/**
	 * Purpose is to complete all bundles of the WordBuilding activity
	 * 
	 * @param isIE
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void rcWordBuilding(boolean isIE) {
		List<WebElement> bunlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bunlecount.size());

		for (int i = 1; i <= bunlecount.size(); i++) {

			step1_WordBuilding(isIE);
			step2_WordBuilding();
		}
	}

	/**
	 * Purpose is to complete one bundle of the WordBuilding activity
	 * 
	 * @param isIE
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void qcWordBuilding(boolean isIE){
		step1_WordBuilding(isIE);
		step2_WordBuilding();
	}
	
	/**
	 * Purpose is devide the execution based on given mode of execution
	 */
	public void wordBuilding(String executionMode, boolean isIE)
	{
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("Selected mode is RC");
			rcWordBuilding(isIE);
		}
		else
		{
			log.info("Selected mode is QC");
			qcWordBuilding(isIE);
		}
	}

	/**
	 * Purpose is to verify summary page of the WordBuilding activity
	 */
	public void wordBuildingSummary() {

		waitUntilElementDisappears(WORD_BUILDING_CONTAINER);
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Summary page not being displayed in the Stretching activity");

		safeClick(CONTINUE_SUMMARY);

	}
}

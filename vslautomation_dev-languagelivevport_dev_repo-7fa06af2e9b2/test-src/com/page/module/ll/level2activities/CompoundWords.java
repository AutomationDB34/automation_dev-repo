package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.CompoundWordsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class CompoundWords extends CommonFunctionalities implements CompoundWordsLocators {

	private LLData llData = new LLData();
	private WebDriver driver;
	Logger log =  Logger.getLogger(getClass());

	public CompoundWords(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to complete all bundles of the Compound Words activity
	 * 
	 * @param isIE
	 * @throws InterruptedException
	 */
	public void rcCompundWords(boolean isIE){

		closeInstIcon();

		List<WebElement> bunlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bunlecount.size());

		for (int i = 1; i <= bunlecount.size(); i++) {

			Assert.assertTrue(isElementPresent(COMPOUNDWORDS_CONTAINER),
					"CompoundWord activity page is not being dispalyed");
			waitForSecs(5);
			safeClickUsingSikuli(llData.compoundWordsMousePointerImage, "Sikuli image for compound words asnwer area",
					LONGWAIT);
			waitForSecs(5);
			
			dragAndDrop(ANSWER_TILE, ANSWER_AREA, LONGWAIT);
			waitUntilElementDisappears(MERGED_WORD, LONGWAIT);
			moveMouseUsingRobotToOutOfWebPage();
			/*waitForSecs(5);
			dragAndDrop(ANSWER_TILE, ANSWER_AREA, LONGWAIT);
			moveMouseUsingRobotToOutOfWebPage();*/
			waitForSecs(5);
		}
	}

	/**
	 * Purpose is to do one bundle of the Compound words activity
	 * 
	 * @param isIE
	 * @throws InterruptedException
	 */
	public void qcCompundWords(boolean isIE){

		closeInstIcon();
		Assert.assertTrue(isElementPresent(COMPOUNDWORDS_CONTAINER),
				"CompoundWord activity page is not being dispalyed");
		if(isIE){
			safeClickUsingSikuli(llData.compoundWordsMousePointerImage, "Sikuli image for compound words asnwer area",
					LONGWAIT);
		}
		dragAndDrop(ANSWER_TILE, ANSWER_AREA, LONGWAIT);
		waitUntilElementDisappears(MERGED_WORD, LONGWAIT);
	}
	
	public void CompundWords(boolean isIE,String executionMode)
	{
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("RC mode selected");
			rcCompundWords(isIE);
		}
		else 
		{
			log.info("QC mode selected");
			qcCompundWords(isIE);
		}
	}

	/**
	 * Purpose of the method is to navigate to home page on completing the
	 * activity
	 */
	public void navigateToHomePagefromActivity() {
		closeInstIcon();
		mouseHover(ACTIVITY_USER_DROP_DOWN, LONGWAIT);
		safeClick(HOME_LINK, LONGWAIT);
	}

}

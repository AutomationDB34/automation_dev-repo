package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.BlendAndReadAlternateLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;

public class BlendAndReadAlternate extends CommonFunctionalities implements BlendAndReadAlternateLocators {

	private WebDriver driver;
	private int correct_Count;
	private LLData llData = new LLData();
	Logger log = Logger.getLogger(getClass());

	public BlendAndReadAlternate(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify the step 1 functionality of Blend and Read Alternate
	 * activity
	 * 
	 * @throws AWTException
	 */
	public void setp1_BlendandReadAlternate(){
		closeInstIcon();
		Assert.assertTrue(isElementPresent(STEP_1_HEADER),
				"Step1 of Blend and read alternate activity is not being dispalyed");
		// Get the syllable count of the step 1
		List<WebElement> syllablecount = LocatorWebElements(STEP1_SLLABLE_COUNT);
		System.out.println("syllable count of step 1:" + syllablecount.size());

		for (int i = 1; i <= syllablecount.size(); i++) {
			if (isElementDisplayed(TARGET_SYLLABLE_TILE)) {
				safeClick(Dynamic.getNewLocator(SYLLABLE_TILE, Integer.toString(i)));
			}
		}
	}

	/**
	 * Purpose is to verify the step2 functionality of Blend and Read Alternate
	 * activity
	 */
	public void step2_BlendAndReadAlternate() {
		Assert.assertTrue(isElementPresent(STEP_2_HEADER),
				"Step2 of Blend and read alternate activity is not being dispalyed");
		safeClick(RECORD_IT_BTN, LONGWAIT);
	}

	/**
	 * Purpose is to verify the step3 functionality of Blend and Read Alternate
	 * activity
	 */
	public void step3_BlendAndReadAlternate() {
		Assert.assertTrue(isElementPresent(STEP_3_HEADER),
				"Step3 of Blend and read alternate activity is not being dispalyed");
		safeClick(THUMPS_UP_BTN, LONGWAIT);
		correct_Count++;
	}

	/**
	 * Purpose is to complete all the bundles of Blend and Read Alternate
	 * activity
	 * 
	 * @throws AWTException
	 */
	public void rcBlendAndReadAlternate(){
		microPhoneSetUp(llData);

		// Get the bundle count of the step 1
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count of step 1:" + bundlecount.size());
		for (int i = 1; i <= bundlecount.size(); i++) {
			setp1_BlendandReadAlternate();
			step2_BlendAndReadAlternate();
			step3_BlendAndReadAlternate();
		}
		System.out.println("thumsup count:" + correct_Count);
	}

	/**
	 * Purpose is to complete one bundle of Blend and Read Alternate activity
	 * 
	 * @throws AWTException
	 */
	public void qcBlendAndReadAlternate() {
		microPhoneSetUp(llData);

		setp1_BlendandReadAlternate();
		step2_BlendAndReadAlternate();
		step3_BlendAndReadAlternate();
		System.out.println("thumsup count:" + correct_Count);
	}

	
	/**
	 * Purpose is devide the execution based on given mode of execution
	 */
	public void blendAndReadAlternate(String executionMode)
	{
		if(executionMode.equalsIgnoreCase("RC"))
		{
			log.info("Selected mode is RC");
			rcBlendAndReadAlternate();
		}
		else
		{
			log.info("Selected mode is RC");
			qcBlendAndReadAlternate();
		}
	}
	
	/**
	 * Purpose is to verify the summary page of Blend and Read Alternate
	 * activity
	 */
	public void blendAndReadAlternateSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER),
				"Blend and read alternate activity summary header is not being dispalyed");

		List<WebElement> thumpsupCount = LocatorWebElements(THUMPS_UP_COUNT);
		List<WebElement> thumpsdownCount = LocatorWebElements(THUMPS_DOWN_COUNT);

		String thumpsUp_Count = Integer.toString(thumpsupCount.size());

		int correct = thumpsupCount.size();
		int incorrect = thumpsdownCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		String correctCount = driver.findElement(CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctCount);

		String questionscount = driver.findElement(NUMBER_OF_QUESTIONS).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscount);

		// compare the Thumpsup count with the correct count displayed in the
		// summary header
		if ((correctCount.equals(thumpsUp_Count)) && (questionscount.contains(Integer.toString(total_question)))) {
			System.out.println("ThumpsUP coulumn count is matched with the Correct count dispalyed in the header");
			safeClick(CONTINUE_SUMMARY_BTN);
		} else {
			System.out.println("count not matching");
		}
	}
}

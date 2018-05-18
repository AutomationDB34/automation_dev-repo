package com.page.module.ll.level2activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level2activities.IndependentReadingLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

public class IndependentReading extends CommonFunctionalities implements IndependentReadingLocators{

	private WebDriver driver;
	
	public IndependentReading(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose of the method is to verify the investigate passage pop up
	 */
	public void verifyInvestigatePasagePopUp(){
		Assert.assertTrue(isElementPresent(INVESTIGATE_THE_PASSAGE_POPUP), "Investigate Pasage PopUp is not being displayed");
		safeClick(START_BTN);
	}
	
	/**
	 * purpose of the method is to verify passage title and click continue button
	 */
	public void untimedIRReading(){
		Assert.assertTrue(isElementPresent(PASSAGE_TITLE), "Passage title is not being displayed");
		safeClick(CONTINUE_BTN);
	}
	
	/**
	 *  Purpose of the method is to verify the Read the timed passage pop up
	 */
	public void verifyReadTimedPasagePopUp(){
		Assert.assertTrue(isElementPresent(READ_THE_TIMED_PASSAGE_POPUP), "Read Timed Pasage PopUp  is not being displayed");
		safeClick(START_BTN);
	}
	
	/**
	 * purpose of the method is to complete the timed reading of the Independent reading activity 
	 * @throws InterruptedException
	 */
	public void timedReading(){
		safeClick(STOP_TIMER_BTN, VERYLONGWAIT);
		Assert.assertTrue(isElementPresent(LAST_WORD_POPUP), "Click on the last word PopUp  is not being displayed");
		safeClick(START_BTN);
		Assert.assertTrue(isElementPresent(LAST_WORD_SCREEN), "Click on the last word screen  is not being displayed");
		safeClick(LAST_WORD);
		safeClick(CONTINUE_BTN);
	}
	/**
	 * Purpose of the activity is to verify the summary screen of Independent Reading activity
	 */
	public void irReadingSummary(){
		Assert.assertTrue(isElementPresent(TIMED_READING_RESULTS_PAGE), "Timed reading results page is not being displayed");
		Assert.assertTrue(isElementPresent(SCORE_BAR), "Score bar is not being displayed");
		safeClick(CONTINUE_BTN);
	}
}

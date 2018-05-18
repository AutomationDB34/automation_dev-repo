package com.page.module.ll.goals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.data.testdata.LLData;
import com.page.locators.ll.goals.StressedSyllablesGoalLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class StressedSyllablesGoalPage extends CommonFunctionalities implements StressedSyllablesGoalLocators
{
	private WebDriver driver;
	LLData llData = new LLData();
	public boolean isIE;
	Logger log = Logger.getLogger(getClass());

	public StressedSyllablesGoalPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}

	/**
	 * To click on GATEWAY GOALS FIRST VIDEO window continue button
	 * @throws InterruptedException 
	 */
	public void clickContinueButtonOnStressSyllablesVideoWindow()
	{
		safeClick(SAYSOUNDSVIDEOWINDOW_CONTINUE_BTN, LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * To click on GATEWAY GOALS FIRST VIDEO window continue button
	 * @throws InterruptedException 
	 */
	public void clickContinueButtonOnGateWayGoalsVideoWindow()
	{
		safeClick(GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN, LONGWAIT);
		waitForPageToLoad();
	}


	/**
	 * Click On Start Button on Ready Start
	 */
	public void verifyReadyToWindow(String expectedReadyToPreviewHeaderText) 
	{	
		String actualReadyToPreviewHeaderText =safeGetText(READYTO_TEXT, LONGWAIT);
		Assert.assertEquals(actualReadyToPreviewHeaderText, expectedReadyToPreviewHeaderText, "The expected Ready to preview header text("+expectedReadyToPreviewHeaderText+") is not matched with the actual header text("+actualReadyToPreviewHeaderText+")");
	}

	/**
	 * To verify Ready To preview window header text
	 * @param expectedReadyToPreviewHeaderText
	 */

	public void clickOnStartButton()
	{

		safeClick(READYTOPREVIEWWINDOWSTART_START_BTN, LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * Click On audio play 
	 */
	public void clickPlayAudioOption1() 
	{
		safeClick(OPTION1_AUDIO, MEDIUMWAIT);
		waitForSecs(1,"wait For audio to play");
	}


	/**
	 * Click On audio play 
	 */
	public void clickPlayAudioOption2() 
	{
		safeClick(OPTION2_AUDIO, MEDIUMWAIT);
		waitForSecs(1,"wait For audio to play");
	}

	/**
	 * Click on the radio button answer
	 */
	public void clickOnAnswerRadioButton() 
	{
		//waitForSecs(4);
		safeClick(ANSEWR_RADIO_BUTTON, LONGWAIT);
		//waitForSecs(4);
		waitForPageToLoad();
	}

	/**
	 * Repeat the steps for all other Questions
	 */
	public void repeatStepsToCompleteTest() 
	{
		List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
		for(int progressCount = 1;progressCount < (progressBars.size());progressCount++)
		{
			//waitForSecs(5);
			clickPlayAudioOption1();
			//waitForSecs(5);
			clickPlayAudioOption2() ;
			clickOnAnswerRadioButton();
			waitForPageToLoad();
			log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Step:"+progressCount);
		}
		waitForPageToLoad();	
	}


	/**
	 * Click onCONTINUE_BUTTON  review your questions
	 */
	public void clickContinueButtonOnReviewErrors() 
	{
		safeClick(REVIEW_CONTINUE, MEDIUMWAIT);
		waitForPageToLoad();
	}


	/**
	 * Click on CONTINUE_BUTTON  clickContinueOnListenBelow
	 */
	public void clickContinueOnListenBelow() 
	{
		safeClick(REVIEW_CONTINUE, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Separate the words displyed in box to the Noun/Verb areas
	 */
	public void dragAndDropTheWordToNoun(boolean isIE) 
	{
		this.isIE = isIE;
		waitForSecs(1);
		dragAndDropwithRobots(WORD_DISPLAYED_IN_BOX, NOUN_SPACE, LONGWAIT,isIE);
		//waitForPageToLoad();
	}

	/**
	 * click On Next button on Review
	 */
	public void clickNextButtonOnReview() 
	{
		//waitForPageToLoad();
		waitForSecs(1,"Waiting for Next Button To attach to DOM");
		safeJavaScriptClick(REVIEW_NEXT_BTN, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Repeat the Review Steps
	 */
	public void repeatReviewSteps() 
	{
		waitForSecs(3);
		List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
		for(int progressCount = 1;progressCount < progressBars.size();progressCount++)
		{
			dragAndDropTheWordToNoun(this.isIE);
			waitForSecs(1);
			clickNextButtonOnReview();
			waitForPageToLoad();
		}
		waitForSecs(5,"waiting to Disappear next button");
		if(isElementDisplayed(REVIEW_NEXT_BTN))
			clickNextButtonOnReview();
		waitForSecs(5);
	}

	/**
	 * Click On Continue onRetake test page
	 */
	public void clickContinueOnRetakeTest() 
	{
		waitForSecs(3);
		if(isElementDisplayed(RETAKETEST_BUTTON))
		{
			safeJavaScriptClick(RETAKETEST_BUTTON, MEDIUMWAIT);
			waitForPageToLoad();
		}
		else
		{
			isElementPresent(REVIEW_CONTINUE, MEDIUMWAIT);
			safeJavaScriptClick(REVIEW_CONTINUE, MEDIUMWAIT);
			waitForPageToLoad();

		}
	}

	//Repeat all the steps to Complete the Goal
	public void repeatStepsToCompleteGoal() 
	{
		for(int i =1;i<=7;i++)
		{
			//Step9:Verify the Ready To start Test headder
			verifyReadyToWindow(llData.Goal_ReadyToStartTest);
			//Step10:Click on Start Button
			clickOnStartButton();
			//Stress11: Play the audio of Option1 and Option2
			clickPlayAudioOption1();
			clickPlayAudioOption2();
			//Stress12: Based on the audio press on rights answer
			clickOnAnswerRadioButton();
			//Step13: Repeat the Steps 11 and 12 until u reach the last page
			repeatStepsToCompleteTest();
			//Step14: Click On continue button on Review your questions
			clickContinueButtonOnReviewErrors();
			//Step15:Verify the Ready To start Test headder
			verifyReadyToWindow(llData.Goal_ReadyToReviewText);
			//Step16:Click on Start Button
			clickOnStartButton();
			//Step17: Click On continue button on Listen to the words below. 
			clickContinueOnListenBelow();
			//Step18: Drag the word in box and drop it in Noun/Verb
			dragAndDropTheWordToNoun(this.isIE);
			//Step19: Click Next Button on Review
			clickNextButtonOnReview();
			//Step20: repeat the steps Step18 and 19 until you complete the Review
			repeatReviewSteps();
			//Step21: Click Continue button On "Please retake the test to earn a trophy." Page
			clickContinueOnRetakeTest();
		}
	}






}

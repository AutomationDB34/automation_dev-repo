package com.page.module.ll.goals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.goals.SaySoundsGoalLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class SaySoundsGoalPage extends CommonFunctionalities implements SaySoundsGoalLocators {

	WebDriver driver;
	LLData llData = new LLData();
	public SaySoundsGoalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}


	/**
	 * To click on GATEWAY GOALS FIRST VIDEO window continue button
	 * @throws InterruptedException 
	 */
	public void clickContinueButtonOnSaySoundsVideoWindow()
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
	 * Click on the Practice Answers
	 */
	public void clickOnPracticeAnswers() 
	{
		List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
		for(int progressCount = 1;progressCount <= progressBars.size();progressCount++)
		{
			safeClick(ANSWER_LETTER,MEDIUMWAIT);
			waitForSecs(3);
			waitForPageToLoad();
		}
		waitForPageToLoad();
	}

	/**
	 * Click Continue on Review your Errors
	 */
	public void clickOnContinueOnReviewYourErrorsPage() 
	{
		safeClick(CONTINUE_BUTTON,MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Start the review of wrong answers
	 */
	public void clickReviewStartButton() 
	{
		safeClick(START_BTN_ONREVEW_READY, LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * click Next On Wrong Answers Audio Page
	 */
	public void clickNextOnWrongAnswersAudioPage() 
	{
		List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
		for(int progressCount = 1;progressCount <= progressBars.size();progressCount++)
		{
			safeClick(NEXT_BTN,LONGWAIT);
			waitForSecs(3);
			waitForPageToLoad();
		}
		waitForPageToLoad();	
	}

	/**
	 * Click Continue On Listen Phonemes
	 */
	public void clicContinueOnListenPhonemes() 
	{
		safeClick(CONTINUE_BUTTON,MEDIUMWAIT);
		waitForPageToLoad();
	}


	/**
	 * Click Continue on un timed practice
	 */
	public void clcikContinueButoon() 
	{
		waitForSecs(4);
		safeClick(CONTINUE_BUTTON,MEDIUMWAIT);
		waitForPageToLoad();
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
			isElementPresent(CONTINUE_BUTTON, MEDIUMWAIT);
			safeJavaScriptClick(CONTINUE_BUTTON, MEDIUMWAIT);
			waitForPageToLoad();

		}
	}


	/**
	 * repeat the steps
	 * @param Goal_ReadyToStartText 
	 * @param Goal_ReadyToReviewText 
	 */
	public void repeatThePractiseSteps(String Goal_ReadyToStartText, String Goal_ReadyToReviewText)
	{
		for(int i=0;i<5;i++)
		{
			//Step9: verify Ready To preview window header text
			verifyReadyToWindow(Goal_ReadyToStartText);
			//Step10: click on start button on Ready To  window
			clickOnStartButton();
			//Step11: Follow the Audio and click on the right answer.Displayed in grid View
			clickOnPracticeAnswers();
			//Step12: Click On Continue on Review Errors Page
			clickOnContinueOnReviewYourErrorsPage();
			//Step13: Verify the Ready to Review Headder
			verifyReadyToWindow(Goal_ReadyToReviewText);
			//Step14: Click on Start Button On Review
			clickReviewStartButton();
			//Step15:Click Continue button on Listen to the Phonemes below
			clicContinueOnListenPhonemes();
			//Step16: Click next button and complete the review 
			clickNextOnWrongAnswersAudioPage();
			if(i==4)
				//Step17: Click ON cONTINUE on Start Untimed Practice
				clcikContinueButoon();
		}
	}

	/**
	 * click start button on Ready To record
	 */
	public void clickStartReadyToRecord() 
	{
		safeClick(START_BTN,MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 *  Wait For record completion
	 */
	public void recordTheDsplayedLetter() 
	{
		waitForSecs(40,"Wait For record completion");
	}

	/**
	 * Grade your self for the answer u given
	 */
	public void clickOnGradeThumbsUpAndDown() 
	{
		int wrongAnswerCont = 5;
		List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
		for(int progressCount = 1;progressCount <= progressBars.size();progressCount++)
		{
			waitForSecs(2);
			if(progressCount<=wrongAnswerCont)
			{
				safeClick(THUMBS_UP_BTN,MEDIUMWAIT);
			}
			else
			{
				safeClick(THUMBS_DOWN_BTN,MEDIUMWAIT);
			}
			waitForPageToLoad();
		}
	}

	/**
	 * Write  the Goal test in slow pace.(This will run the all the remaining 7 times of test attempts)
	 */
	public void recordSoundsInSlowPace(String Goal_ReadyToReviewText,String Goal_ReadyToRecordText,String Goal_Reviewyourrecordings)
	{
		clcikContinueButoon();
		for(int i=0;i<7;i++)
		{
			verifyReadyToWindow(Goal_ReadyToReviewText);
			waitForSecs(5);
			clickReviewStartButton();
			 clcikContinueButoon();
			 clickNextOnWrongAnswersAudioPage();
			 clickContinueOnRetakeTest();
			//microPhoneSetUp(llData);
			verifyReadyToWindow(Goal_ReadyToRecordText);
			waitForSecs(5);
			
			clickReviewStartButton();
			recordTheDsplayedLetter();
			verifyReadyToWindow(Goal_Reviewyourrecordings);
			waitForSecs(5);
			//Recording Staret
			clickReviewStartButton();
			clickOnGradeThumbsUpAndDown();
			clcikContinueButoon();
			clcikContinueButoon();
		}
		waitForPageToLoad();
	}
}

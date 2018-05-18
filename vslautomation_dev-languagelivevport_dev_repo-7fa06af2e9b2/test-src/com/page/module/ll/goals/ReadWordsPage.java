package com.page.module.ll.goals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.goals.ReadWordsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.sun.mail.imap.Utility;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class ReadWordsPage extends CommonFunctionalities implements ReadWordsLocators {



	WebDriver driver;
	LLData llData = new LLData();
	Logger log = Logger.getLogger(getClass());
	ConfigManager config = new ConfigManager();

	public ReadWordsPage(WebDriver driver) {
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
			safeClick(ANSWER_LETTER,LONGWAIT);
			waitForSecs(3);
			waitForPageToLoad();
		}
		waitForPageToLoad();
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
				safeClick(THUMBS_UP_BTN,LONGWAIT);
			}
			else
			{
				safeClick(THUMBS_DOWN_BTN,LONGWAIT);
			}
			waitForPageToLoad();
		}
	}

	/**
	 * Click Continue on Review your Errors
	 */
	public void clickOnContinueOnReviewYourErrorsPage() 
	{
		safeClick(CONTINUE_BUTTON,LONGWAIT);
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
		log.info("{}{}}{{{}{}{}{}{progressBars.size()"+progressBars.size());
		for(int progressCount = 1;progressCount <= progressBars.size();progressCount++)
		{
			List<WebElement> lattersInWord = LocatorWebElements(LETTERS_INWORD);
			log.info("{}{}}{{{}{}{}{}{lattersInWord.size()"+lattersInWord.size());
			for(int latterCount=1;latterCount<=lattersInWord.size();latterCount++)
			{
				safeClick(Dynamic.getNewLocator(LATTERGRID, String.valueOf(latterCount)),LONGWAIT);
				waitForSecs(3,"Waiting to play the letter audio");
			}
			lattersInWord =null;
			waitForSecs(4);
			safeClick(NEXT_BTN,LONGWAIT);
			waitForSecs(5);
			waitForPageToLoad();
		}
		waitForPageToLoad();	
	}

	/**
	 * Click Continue On Listen Phonemes
	 */
	public void clickContinueOnListenWords() 
	{
		safeClick(CONTINUE_BUTTON,LONGWAIT);
		waitForPageToLoad();
	}


	/**
	 * click start button on Ready To record
	 */
	public void clickStartReadyToRecord() 
	{
		safeClick(START_BTN,LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 *  Wait For record completion
	 */
	public void recordTheDsplayedWords() 
	{
		for(int i=0;i<20;i++)
		{
			//waitForSecs(8,"Waiting to record to happen");
			isElementClickable(THUMBS_DOWN_BTN, LONGWAIT);
			safeJavaScriptClick(THUMBS_DOWN_BTN, LONGWAIT);
		}
	}

	/**
	 * Click Continue on un timed practice
	 */
	public void clcikContinueButoon() 
	{
		waitForSecs(4);
		safeClick(CONTINUE_BUTTON,LONGWAIT);
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
			safeJavaScriptClick(RETAKETEST_BUTTON, LONGWAIT);
			waitForPageToLoad();
		}
		else
		{
			isElementPresent(CONTINUE_BUTTON, LONGWAIT);
			safeJavaScriptClick(CONTINUE_BUTTON, LONGWAIT);
			waitForPageToLoad();

		}
	}
	/**
	 * Repeat all th Pracice steps
	 * @param Goal_ReadyToStartText
	 * @param Goal_ReadyToReviewText
	 */
	public void repeatPracticeSteps(String Goal_ReadyToStartText,String Goal_ReadyToReviewText) 
	{
		for(int i=0;i<5;i++)
		{
			verifyReadyToWindow(Goal_ReadyToStartText);
			clickOnStartButton();
			clickOnPracticeAnswers();
			clickOnContinueOnReviewYourErrorsPage();
			verifyReadyToWindow(Goal_ReadyToReviewText);
			clickReviewStartButton();
			clickContinueOnListenWords();
			clickOnContinueOnReviewYourErrorsPageOnUntimed();
		}
	}

	public void clickOnContinueOnReviewYourErrorsPageOnUntimed() 
	{
		boolean isIE = config.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer");
		List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);

		for(int progressCount = 1;progressCount <= progressBars.size();progressCount++)
		{
			dragAndDropwithRobots1(DRAGGABLE_LETTER_GRID,DROP_AREA,LONGWAIT, isIE);
			waitForSecs(10,"Waiting for Drop should be done");
			safeClick(CHECK_IT, LONGWAIT);
			waitForSecs(15,"Waiting for Drop should be done");

			dragAndDropwithRobots1(DRAGGABLE_LETTER_GRID,DROP_AREA,LONGWAIT, isIE);
			waitForSecs(10,"Waiting for Drop should be done");
			safeClick(CHECK_IT, LONGWAIT);
			waitForSecs(15,"Waiting for Drop should be done");
			List<WebElement> consonentLetterDropables = LocatorWebElements(LETTERS_INWORD);
			for(int i=1;i<=consonentLetterDropables.size();i++)	
			{
				if(i%2==0)
				{
					dragAndDropwithRobots(CONSONANT_TILE, 
							Dynamic.getNewLocator(LATTER_DROP, String.valueOf(i)), LONGWAIT, isIE);
					waitForSecs(3,"Waiting for Drop should be done");
					
				}
				else
				{
					dragAndDropwithRobots(VOWEL_TILE, 
							Dynamic.getNewLocator(LATTER_DROP, String.valueOf(i)), LONGWAIT, isIE);
					waitForSecs(3,"Waiting for Drop should be done");
				}
			}

			waitForSecs(20,"Waiting for Drop should be done");
			//Step3 selecte the letter
			List<WebElement> choiceLetters = LocatorWebElements(LETTERS_IN_STEP3);

			for(int i=1;i<=consonentLetterDropables.size();i++)	
			{
				int randomNumer = UtilityMethods.randInt(1, choiceLetters.size());
				dragAndDropwithRobots(Dynamic.getNewLocator(RANDOM_LETTER_IN_STEP3, String.valueOf(randomNumer)), 
						Dynamic.getNewLocator(LATTER_DROP, String.valueOf(i)), LONGWAIT, isIE);
				waitForSecs(8,"Waiting for Drop should be done");
				String letter = safeGetText(Dynamic.getNewLocator(LATTER_DROPPED_TEXT, String.valueOf(i)), MEDIUMWAIT);
				if(letter.equalsIgnoreCase("   "))
				{
					randomNumer = UtilityMethods.randInt(1, choiceLetters.size());
					dragAndDropwithRobots(Dynamic.getNewLocator(RANDOM_LETTER_IN_STEP3, String.valueOf(randomNumer)), 
							Dynamic.getNewLocator(LATTER_DROP, String.valueOf(i)), LONGWAIT, isIE);
				}
				waitForSecs(5,"Waiting for Drop should be done");
			}
			waitForSecs(5,"Waiting for Drop should be done");
			isElementPresent(NEXT_BTN);
			safeJavaScriptClick(NEXT_BTN, LONGWAIT);
		}

	}
	/**
	 * Write  the Goal test in slow pace.(This will run the all the remaining 7 times of test attempts)
	 */
	public void recordSoundsInSlowPace(String Goal_ReadyToReviewText,String Goal_ReadyToSpeak,String Goal_Reviewyourrecordings)
	{
		for(int i=0;i<7;i++)
		{
			verifyReadyToWindow(Goal_ReadyToSpeak);
			clickStartReadyToRecord();
			clickOnGradeThumbsUpAndDown();
			clickOnContinueOnReviewYourErrorsPage();
			clickOnContinueOnReviewYourErrorsPage();
			verifyReadyToWindow(Goal_ReadyToReviewText);
			clickOnStartButton();
			clickContinueOnListenWords();
			clickNextOnWrongAnswersAudioPage();
			clickContinueOnRetakeTest();
		}
		waitForPageToLoad();
	}



}

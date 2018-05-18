package com.page.module.ll.goals;

import javax.media.rtp.rtcp.Feedback;

import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.tika.sax.xpath.SubtreeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.page.locators.ll.goals.ReadSentencesGoalRecordingLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class ReadSentencesGoalRecordingPage extends CommonFunctionalities implements ReadSentencesGoalRecordingLocators {

	private WebDriver driver;
	int testResultScoreValue;
	
	public ReadSentencesGoalRecordingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;		
	}
	
	/**
	 * To click on GATEWAY GOALS FIRST VIDEO window continue button
	 * @throws InterruptedException 
	 */
	public void clickContinueButtonOnGateWayGoalsVideoWindow()
	{
		waitForPageToLoad();
		waitForSecs(4,"Waiting to load ContinueButton");
		safeClick(GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * To click on PASSAGE FLUENCY VIDEO window continue button  
	 */
	public void clickContinueButtonOnPassageFluencyVideoWindow()
	{
		waitForPageToLoad();
		waitForSecs(10,"Waiting to Fade in the Fluence video");
		Assert.assertTrue(isElementPresent(PASSGEFLUENCYVIDEOWINDOW_FADEOUT, LONGWAIT), "Passage fluency video is not played");
		safeClick(PASSGEFLUENCYVIDEOWINDOW_CONTINUE_BTN, LONGWAIT);
	}
	
	
	/**
	 * To verify Ready To start window header text
	 */
	
	public void verifyReadyToStartWindowHeaderText()
	{		
		Assert.assertTrue(isElementPresent(READYTOSTARTHEADING_TEXT, LONGWAIT), "Ready to start heading pop-up is not displayed");
	}
	
	/**
	 * To click on start button on Ready To Start window 
	 */
	public void clickStartButtonOnReadyToStartWindow()
	{
		safeClick(START_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify navigation to Read sentences pop-up
	 */
	
	public void verifyNavigationToReadSentencesSection()
	{
		Assert.assertTrue(isElementPresent(READSENTENCES_TABLE, LONGWAIT), "Read sentences pop-up section is not being displayed");
	}
	
	/**
	 * Purpose- To verify the sentences count and click next button
	 */
	
	public void verifySentencesAndClickNextForAllSentences()
	{
		int totalBubblesCount = getLocatorCount(READSENTENCES_BUBBLES_LIST);
		for(int i=1;i<=totalBubblesCount;i++)
		{
			int totalSentencesInSection = getLocatorCount(READSENTENCES_LIST);
			if(totalSentencesInSection==5)
			{
				if(i<totalBubblesCount)
				{
				safeClick(READSENTENCES_NEXT_BTN, LONGWAIT);
				}
				else
				{
					safeClick(READSENTENCES_CONTINUE_BTN, LONGWAIT);
				}
			}
			else
			{
				Assert.assertEquals(totalSentencesInSection, 5, "Actual sentences displayed count("+totalSentencesInSection+") doesn't match with expected sentences count 5");
			}			
		}		
	}
	
	/**
	 * Purpose- To verify that user is taken to 'Select the correct word to complete the sentences' section
	 */
	
	public void verifyTheNavigationToSelectTheCorrectWordSection()
	{
		Assert.assertTrue(isElementPresent(SELECTTHECORRECTWORD_SENTENCE, LONGWAIT), "The pop-up or section with the message stating 'Select the correct word to complete the sentence' is not being displayed ");
	}
	
	/**
	 * Purpose- To click on continue button Select the correct word to complete the sentences section
	 */
	
	public void clickOnContinueButtonOnSelectTheCorrectWordSection()
	{
		safeClick(CONTINUE_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify the navigation to fill in the blanks section
	 */
	
	public void verifyNavigationToFillInTheBlanksSection()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(FILLINTHEBLANKS_DOTS_SECTION, LONGWAIT), "User is not taken to fill in the blank section while reading sentences as student user ");
	}
	
	/**
	 * Purpose- To fill in the blanks for sentences
	 * @throws InterruptedException 
	 */
	
	public void fillInTheBlanksForAllSentences()
	{
		int totalDotsDisplayed = getLocatorCount(FILLINTHEBLANKS_BUBBLES_LIST);
		
		for(int i=1;i<=totalDotsDisplayed;i++)
		{			
			if(i<totalDotsDisplayed)
			{
			Assert.assertTrue(isElementPresent(FILLINTHEBLANKS_SENTENCE, LONGWAIT), "One of the sentences is not displayed while filling the reading sentences blanks");
			Assert.assertTrue(isElementPresent(FILLINTHEBLANKS_CHOICES_SECTION, LONGWAIT), "One of the Sentences choice options are not displayed");
			waitForSecs(3);
			int currentPageCount = Integer.parseInt(safeGetText(CURRENT_SENTENCE_NUMBER,LONGWAIT));
			while(currentPageCount==i)
			{
				safeClick(FILLINTHEBLANKS_DRAGGABLE_OPTION, LONGWAIT);
				Assert.assertTrue(isElementPresent(FILLINTHEBLANKS_SENTENCE, LONGWAIT), "One of the Sentences is not displayed while filling the reading sentences blanks");
				Assert.assertTrue(isElementPresent(FILLINTHEBLANKS_CHOICES_SECTION, LONGWAIT), "One of the Sentences choice options are not displayed");
				waitForSecs(3);
				currentPageCount = Integer.parseInt(safeGetText(CURRENT_SENTENCE_NUMBER,LONGWAIT));
			}
			}
			else
			{
				safeClick(FILLINTHEBLANKS_DRAGGABLE_OPTION, LONGWAIT);
				waitForSecs(5);
				nullifyImplicitWait();
				if(isElementPresent(CURRENT_SENTENCE_NUMBER)){
					setImplicitWait(IMPLICITWAIT);
					safeClick(FILLINTHEBLANKS_DRAGGABLE_OPTION, LONGWAIT);
				}
				else
				{
					break;
				}
			}
			
		}
	}
	
	/**
	 * Purpose- To verify that user is taken to the section with message 'Read along and listen to the model until you are ready to make a recording.'
	 */

	public void verifyNavigationReadAlongAndListenSection()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(READALONGANDLISTEN_TEXT, LONGWAIT), "User is not taken to 'Read along and listen to the model until you are ready to make a recording.' section while reading sentences as student user ");
	}
	
	/**
	 * Purpose- To click continue button on 'Read along and listen to the model until you are ready to make a recording.' section
	 */
	public void clickContinueButtonUnderReadAlongAndListenSection()
	{
		safeClick(CONTINUE_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify that user is taken to the section 'You are ready to take the test'
	 */

	public void verifyNavigationToYouAreReadyToTakeTheTestSection()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(YOUAREREADYTOTAKETHETEST_TEXT, LONGWAIT), "User is not taken to 'You are ready to take the test' section while reading sentences as student user ");
	}
	
	/**
	 * Purpose- To click continue button on 'Read along and listen to the model until you are ready to make a recording.' section
	 */
	public void clickContinueButtonUnderYouAreReadyToTakeTheTestSection()
	{
		safeClick(CONTINUE_BTN, LONGWAIT);
	}
	
	
	/**
	 * To verify Ready To record window header text
	 */
	
	public void verifyReadyToRecordWindowHeaderText()
	{		
		Assert.assertTrue(isElementPresent(READYTORECORD_HEADER, LONGWAIT), "Ready to record heading pop-up is not displayed");
	}
	
	/**
	 * To click on start button on Ready To record window 
	 */
	public void clickStartButtonOnReadyToRecordWindow()
	{
		safeClick(START_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify navigation to 'Microphone' recording section
	 */
	
	public void verifyNavigationToMicroPhoneRecordingPopUp()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(MICROMETER_ICON, LONGWAIT), "Microphone recording section is not displayed");
		Assert.assertTrue(isElementPresent(MICROMETER_BUBBLES_SECTION, LONGWAIT), "Microphone recording section is not displayed");
	}
	
	/**
	 * Purpose- To verify microphone recording of the sentences
	 * @throws InterruptedException 
	 */
	
	public void verifyRecordingOfTheSentences()
	{
		int totalBubblesCount = getLocatorCount(BUBBLES_COUNT);
		
		int totalRecordingCompletedBubblesCount = getLocatorCount(BUBBLE_SELECTED);
		
		while(totalRecordingCompletedBubblesCount<=(totalBubblesCount-2))
		{
			waitForSecs(5);
			totalRecordingCompletedBubblesCount=getLocatorCount(BUBBLE_SELECTED);
		}
	}
	
	
	/**
	 * To verify Review your recordings window header text
	 */
	
	public void verifyReviewYourRecordingsWindowHeaderText()
	{		
		Assert.assertTrue(isElementPresent(REVIEW_YOUR_RECORDINGS_HEADER, LONGWAIT), "Review your recording heading pop-up is not displayed");
	}
	
	/**
	 * To click on start button on Review your recording window 
	 */
	public void clickStartButtonOnReviewYourRecordingsWindow()
	{
		safeClick(START_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify that user is taken to grading sentences(i.e.your voice and compare) page
	 */
	
	public void verifyNavigationToGradingSentencesSection()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(GRADING_SENTENCES_SECTION, LONGWAIT), "Grading sentences section is not being displayed");
		Assert.assertTrue(isElementPresent(BUBLLES_SECTION, LONGWAIT), "Grading sentences section is not being displayed");		
	}	
	
	/**
	 * Purpose- To grade the sentences
	 */
	
	public void gradeTheSentences(int thumbs_down_count)
	{
		int totalBubblesCount = getLocatorCount(BUBBLES_COUNT);
		
		for(int i=1;i<=totalBubblesCount;i++)
		{
			if(i>thumbs_down_count){
			Assert.assertTrue(isElementPresent(YOUR_VOICE_BTN_ENABLED, LONGWAIT), "Your voice button is not enabled while grading the sentence("+i+")");
			Assert.assertTrue(isElementPresent(COMPARE_BTN_ENABLED, LONGWAIT), "Compare button is not enabled while grading the sentence("+i+")");
			Assert.assertTrue(isElementPresent(THUMS_UP_BTN_ENABLED, LONGWAIT), "Thumsup button is not enabled while grading the sentence("+i+")");
			safeClick(THUMS_UP_BTN_ENABLED, LONGWAIT);	
			Assert.assertTrue(isElementPresent(SENTENCE_HIGHLIGHTED, LONGWAIT), "Sentences is not highlighted after clicking thumsup button for the sentence("+i+")");
		}
			else{
				safeClick(THUMS_DOWN_BTN_ENABLED, MEDIUMWAIT);
			}
		}
	}
	
	/**
	 * Purpose- To verify the navigation to 'Test Results' section
	 */
	
	public void verifyNavigationToTestResultsSection()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(TEST_RESULTS_SUMMARY_SECTION, LONGWAIT), "Test Results section is not being displayed");
	}
	
	/**
	 * Purpose - To get the score value from 'Test Results' section
	 */
	
	public int retrieveTheTestResultsScoreValue()
	{
		int testResultScoreValue = Integer.parseInt(safeGetText(TEST_RESULTS_SCORE_VALUE, LONGWAIT));
		
		return testResultScoreValue;	
	}
	
	/**
	 * Purpose- To click on Continue button under 'Test Results' section
	 */
	
	public void clickContinueButtonUnderTestResultsSection()
	{
		safeClick(TEST_RESULTS_CONTINUE_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify the navigation to 'Read Sentences' attempt summary section
	 */
	
	public void verifyNavigationToAttemptSummarySection()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(ATTEMPT_SUMMARY_CONTENT, LONGWAIT), "Read sentences attempt summary section is not being displayed");
	}
	
	
	/**
	 * Purpose- To compare test results score and attempt summary score
	 */
	
	public void verifyTestResultAndAttemptSummaryScores(int testResultScore)
	{
		int attemptSummaryScore = Integer.parseInt(safeGetText(ATTEMPT_SUMMARY_RECORD_COUNT, LONGWAIT));
		
		Assert.assertEquals(attemptSummaryScore, testResultScore, "The test result section score("+testResultScore+") doesn't match with attempt summary section score("+attemptSummaryScore+")");
	}
	
	/**
	 * Purpose- To click  'Continue' button under attempt summary section
	 */
	
	public void clickContinueButtonOfAttemptSummarySection()
	{
		safeClick(ATTEMPT_SUMMARY_CONTINUE_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify navigation to 'Submit for feedback' section
	 */
	
	public void verifyNavigationToSubmitForFeedBackSection()
	{
		Assert.assertTrue(isElementPresent(SUBMIT_FOR_FEEDBACK_BTN, LONGWAIT), "Submit for feedback section is not being displayed while reading sentences as student user");
	}
	
	
	/**
	 * Purpose- To click  'Submit for feedback' button 
	 */
	
	public void clickSubmitForFeedbackButton()
	{
		safeClick(SUBMIT_FOR_FEEDBACK_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose - To verify navigation to 'your recording has been submitted for feedback' section
	 */
	
	public void verifyNavigationToFeedbackSubmittedSection()
	{
		Assert.assertTrue(isElementPresent(YOURRECORDING_SUBMITTED_MESSAGE, LONGWAIT), "Your recording has been submitted for feedback message section is not being displayed while reading sentences as student user");
	}
	
	/**
	 * Purpose- To click  'Continue' button  under 'your recording has been submitted for feedback' section
	 */
	
	public void clickContinueUnderFeedbackSubmittedSection()
	{
		safeClick(YOURRECORDING_SUBMITTED_CONTINUE_BTN, LONGWAIT);
	}
	
	public void retakeAttempt(int attempt){
		if(attempt==1|| attempt==2){
				safeClick(TEST_CONTINUE_BTN, MEDIUMWAIT);
		}
		if(attempt>=3 && attempt<6){
			safeClick(RETAKE_TEST_BTN, MEDIUMWAIT);
		}
	
			if(attempt==6){
				safeClick(CONTINUEBTN_LAST_ATTEMPT, MEDIUMWAIT);
			}
		
		
	}
	
	public void readsentencesTest(int attemptcount){
		for(int i=1 ;i<=attemptcount ;i++){
		
		//To verify navigation to 'Ready to record' window or pop-up
		verifyReadyToRecordWindowHeaderText();
		//To click start button on 'Ready to record' window or pop-up
		clickStartButtonOnReadyToRecordWindow();
		//To verify navigation to microphone recording section
		verifyNavigationToMicroPhoneRecordingPopUp();
		//Wait until microphone recording is complete for all sentences
		verifyRecordingOfTheSentences();
		//To verify navigation to 'Review your recording' window or pop-up
		verifyReviewYourRecordingsWindowHeaderText();		
		//To click start button on 'Review your recording' window or pop-up
		clickStartButtonOnReviewYourRecordingsWindow();
		//To verify navigation to Grading Sentences page
		verifyNavigationToGradingSentencesSection();
		//To grade the sentences
		gradeTheSentences(6);
		//To verify navigation to Test Results section
		verifyNavigationToTestResultsSection();
		//To retrieve score value from 'Test Results' section
		testResultScoreValue=retrieveTheTestResultsScoreValue();
		//To click continue button under 'Test Results' section
		clickContinueButtonUnderTestResultsSection();	
		//To verify the navigation to attempt summary section
		verifyNavigationToAttemptSummarySection();
		//To compare test results score with attempt summary score
		verifyTestResultAndAttemptSummaryScores(testResultScoreValue);
		//To click continue button under attempt summary section
		clickContinueButtonOfAttemptSummarySection();
		retakeAttempt(i);
		
		}
		
	}
}

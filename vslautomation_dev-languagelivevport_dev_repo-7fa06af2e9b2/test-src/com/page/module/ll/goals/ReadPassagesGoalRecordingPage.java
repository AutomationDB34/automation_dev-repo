package com.page.module.ll.goals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.goals.ReadPassagesGoalLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class ReadPassagesGoalRecordingPage extends CommonFunctionalities
		implements ReadPassagesGoalLocators {

	private WebDriver driver;
	List<WebElement> passageWordCount;
	int wordCount;
	int myScoreValue;	

	public ReadPassagesGoalRecordingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	/**
	 * To click on GATEWAY GOALS FIRST VIDEO window continue button
	 * 
	 * @throws InterruptedException
	 */
	public void clickContinueButtonOnGateWayGoalsVideoWindow() {
		safeClick(GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN, LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * To click on PASSAGE FLUENCY VIDEO window continue button
	 * 
	 * @throws InterruptedException
	 */
	public void clickContinueButtonOnPassageFluencyVideoWindow() {
		waitForSecs(10);
		Assert.assertTrue(isElementPresent(PASSGEFLUENCYVIDEOWINDOW_FADEOUT, LONGWAIT),
				"Passage fluency video is not played");
		safeClick(PASSGEFLUENCYVIDEOWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify Ready To preview window header text
	 * 
	 * @param expectedReadyToPreviewHeaderText
	 */

	public void verifyReadyToPreviewWindowHeaderText(String expectedReadyToPreviewHeaderText) {
		String actualReadyToPreviewHeaderText = safeGetText(READYTOPREVIEWHEADING_TEXT, LONGWAIT);

		Assert.assertEquals(actualReadyToPreviewHeaderText, expectedReadyToPreviewHeaderText,
				"The expected Ready to preview header text(" + expectedReadyToPreviewHeaderText
						+ ") is not matched with the actual header text(" + actualReadyToPreviewHeaderText + ")");
	}

	/**
	 * To click on start button on Ready To Preview window
	 */
	public void clickStartButtonOnReadyToPreviewWindow() {
		safeClick(READYTOPREVIEWWINDOWSTART_START_BTN, LONGWAIT);
	}

	/**
	 * To verify that some reading passage text is displayed on the window
	 */

	public void verifySomeReadingPassageTextIsDisplayed() {
		Assert.assertTrue(isElementPresent(READINGPASSGE_TEXT_SECTION, LONGWAIT),
				"Reading Passage Text Window is not displayed after clicking start button on Ready to Preview Window");

		List<WebElement> totalReadingPassageWords = LocatorWebElements(READINGPASSGE_TEXTWORDS_LIST);

		Assert.assertTrue(totalReadingPassageWords.size() >= 1,
				"No Reading Passage text is displayed on the window displayed after clicking start button on Ready to Preview Window ");
	}

	/**
	 * To click on start button on Reading Passage Text Window
	 */
	public void clickContinueButtonOnReadingPassageTextWindow() {
		safeClick(READPASSGEWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify the text,'complete the sentences in the passage' on the
	 * displayed window
	 * 
	 * @param expectedCompleteTheSentencesText
	 */

	public void verifyCompleteTheSentenceInPassageTextWindow(String expectedCompleteTheSentencesText) {
		String actualCompleteTheSentencesText = safeGetText(COMPLETETHESENTENCESINTHEPASSAGE_TEXT, LONGWAIT)
				.replaceAll("\\r\\n|\\r|\\n", " ");

		Assert.assertEquals(actualCompleteTheSentencesText, expectedCompleteTheSentencesText,
				"The expected header text(" + expectedCompleteTheSentencesText
						+ ") is not matched with the actual header text(" + actualCompleteTheSentencesText + ")");
	}

	/**
	 * To click on continue button on 'Complete The sentences in the passage'
	 * text window
	 */
	public void clickContinueButtonOnCompleteTheSentenceInPassageTextWindow() {
		safeClick(COMPLETETHESENTENCESINTHEPASSAGE_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify Ready To start window header text
	 * 
	 * @param expectedReadyToStartHeaderText
	 */

	public void verifyReadyToStartWindowHeaderText_First(String expectedReadyToStartHeaderText) {
		String actualdReadyToStartHeaderText = safeGetText(READYTOSTARTHEADINGFIRSTTIME_TEXT, LONGWAIT);

		Assert.assertEquals(actualdReadyToStartHeaderText, expectedReadyToStartHeaderText,
				"The expected Ready to preview header text(" + expectedReadyToStartHeaderText
						+ ") is not matched with the actual header text(" + actualdReadyToStartHeaderText + ")");
	}

	/**
	 * To click on start button on Ready To Start window
	 */
	public void clickStartButtonOnReadyToStartWindow_First() {
		safeClick(READYTOSTARTWINDOWFIRSTTIME_START_BTN, LONGWAIT);
	}

	/**
	 * To verify that fill in the blanks passage window is displayed
	 */
	public void verifyNavigationToFillInTheBlanksPassageWindow() {
		Assert.assertTrue(isElementPresent(FILLINTHEBLANK_SECTION, LONGWAIT),
				"Fill in the blanks passage window is not displayed");
	}

	/**
	 * To fill the blanks in the passage
	 */

	public void fillInTheBlanksInThePassage() {
		int totalBlankFielsCount = getLocatorCount(FILLINTHEBLANKS_LIST);

		for (int i = 0; i < totalBlankFielsCount; i++) {
			String iValue = Integer.toString(i + 1);

			safeClick(Dynamic.getNewLocator(FILLINTHEBLANKSFIRST_ANSWEROPTION, iValue), LONGWAIT);

			nullifyImplicitWait();

			if (getLocatorCount(
					Dynamic.getNewLocatorWithColon(FILLINTHEBLANKSFIRST_ANSWEROPTIONWITHSTYLE, iValue)) == 1)// this
																												// is
																												// when
																												// first
																												// item
																												// is
																												// wrong
			{
				safeClick(Dynamic.getNewLocator(FILLINTHEBLANKSSECOND_ANSWEROPTION, iValue), LONGWAIT);
			}
		}

		setImplicitWait(IMPLICITWAIT);
	}

	/**
	 * To click on continue button on fill in the blanks passage window
	 */
	public void clickContinueButtonOnFillInTheBlanksPassageWindow() {
		safeClick(FILLINTHEBLANKSWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify the text,'Read along and listen to the model until you are
	 * ready to make a recording.' on the displayed window
	 * 
	 * @param expectedReadAlongAndListenToModelText
	 */

	public void verifyReadAlongAndListenToModelTextWindow(String expectedReadAlongAndListenToModelText) {
		String actualReadAlongAndListenToModelText = safeGetText(READALONGANDLISTEN_TEXT, LONGWAIT)
				.replaceAll("\\r\\n|\\r|\\n", " ");

		Assert.assertEquals(actualReadAlongAndListenToModelText, expectedReadAlongAndListenToModelText,
				"The expected header text(" + expectedReadAlongAndListenToModelText
						+ ") is not matched with the actual header text(" + actualReadAlongAndListenToModelText + ")");
	}

	/**
	 * To click on continue button on 'Read along and listen to the model until
	 * you are ready to make a recording' text window
	 */
	public void clickContinueButtonOnReadAlongAndListenToModelTextWindow() {
		safeClick(READALONGANDLISTENWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify Ready To start Reading window header text
	 * 
	 * @param expectedReadyToStartReadingHeaderText
	 */

	public void verifyReadyToStartReadingWindowHeaderText(String expectedReadyToStartReadingHeaderText) {
		String actualdReadyToStartReadingHeaderText = safeGetText(READYTOSTARTHEADINGSECONDTIME_TEXT, LONGWAIT);

		Assert.assertEquals(actualdReadyToStartReadingHeaderText, expectedReadyToStartReadingHeaderText,
				"The expected header text(" + expectedReadyToStartReadingHeaderText
						+ ") is not matched with the actual header text(" + actualdReadyToStartReadingHeaderText + ")");
	}

	/**
	 * To click on start button on Ready To Start Reading window
	 */
	public void clickStartButtonOnReadyToStartReadingWindow() {
		safeClick(READYTOSTARTWINDOWSTARTSECONDTIME_START_BTN, LONGWAIT);
	}

	/**
	 * To verify that audio progress passage window is displayed
	 */
	public void verifyNavigationToAudioProgressPassageWindow() {
		Assert.assertTrue(isElementPresent(AUDIOPROGRESS_BAR, LONGWAIT),
				"Audio reading progress passage window is not displayed");
	}

	/**
	 * To click on continue button on Ready To Start Reading Progress window
	 */
	public void clickContinueButtonOnAudioReadingProgressWindow() {
		safeClick(AUDIOPROGRESSBARWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify the header text, 'you are ready to take the test'
	 * 
	 * @param expectedReadyToTakeTheTestText
	 */

	public void verifyYouAreReadyToTakeTheTestWindowHeaderText(String expectedReadyToTakeTheTestText) {
		String actualdReadyToTakeTheTestHeaderText = safeGetText(YOUAREREADYTOTAKETEST_TEXT, LONGWAIT);

		Assert.assertEquals(actualdReadyToTakeTheTestHeaderText, expectedReadyToTakeTheTestText,
				"The expected header text(" + expectedReadyToTakeTheTestText
						+ ") is not matched with the actual header text(" + actualdReadyToTakeTheTestHeaderText + ")");
	}

	/**
	 * To click on continue button on Ready To take the test window
	 */
	public void clickContinueButtonOnYouAreReadyToTakeTheTestWindow() 
	{
		waitForSecs(15);
		safeClick(YOUAREREADYTOTAKETESTWINDOW_CONTINUE_BTN, LONGWAIT);
		waitForSecs(15);
	}

	/**
	 * To verify Ready To Speak window header text
	 * 
	 * @param expectedReadyToSpeakHeaderText
	 */

	public void verifyReadyToSpeakWindowHeaderText(String expectedReadyToSpeakHeaderText) {
		String actualdReadyToSpeakHeaderText = safeGetText(READYTOSPEAK_TEXT, LONGWAIT);

		Assert.assertEquals(actualdReadyToSpeakHeaderText, expectedReadyToSpeakHeaderText,
				"The expected header text(" + expectedReadyToSpeakHeaderText
						+ ") is not matched with the actual header text(" + actualdReadyToSpeakHeaderText + ")");
	}

	/**
	 * To click on start button on Ready To Speak window
	 */
	public void clickStartButtonOnReadyToSpeakWindow() {
		safeClick(READYTOSPEAKWINDOW_START_BTN, LONGWAIT);
	}

	/**
	 * To click stop timer button on the Recording Passage window
	 * 
	 * @throws InterruptedException
	 */
	public void clickStopTimerButtonOnTheWindow() {
		waitForSecs(3);
		safeClick(RECORDINGPASSAGEWINDOW_STOPTIMER_BTN, LONGWAIT);
	}

	/**
	 * To verify ReviewYourReading window header text
	 * 
	 * @param expectedReviewYourReadingkHeaderText
	 */

	public void verifyReviewYourReadingWindowHeaderText(String expectedReviewYourReadingkHeaderText) {
		String actualdReviewYourReadingHeaderText = safeGetText(REVIEWYOURREADING_TEXT, LONGWAIT);

		Assert.assertEquals(actualdReviewYourReadingHeaderText, expectedReviewYourReadingkHeaderText,
				"The expected header text(" + expectedReviewYourReadingkHeaderText
						+ ") is not matched with the actual header text(" + actualdReviewYourReadingHeaderText + ")");
	}

	/**
	 * To click on start button on Review Your Reading window
	 */
	public void clickStartButtonOnReviewYourReadingWindow() {
		safeClick(REVIEWYOURREADINGWINDOW_START_BTN, LONGWAIT);
	}

	/**
	 * To verify that, the window with header text 'click on any words you said
	 * wrong' is displayed
	 */
	public void verifyNavigationToClickOnAnyWordsYouSaidWrongWIndow() {
		Assert.assertTrue(isElementPresent(CLICKONANYWORDSYOUSAIDWRONGWINDOW_HEADERTITLE, LONGWAIT),
				"'Click on Any Words You Said Wrong' window is not displayed");
	}

	/**
	 * To click a word on 'click on any words you said wrong' window
	 */

	public void clickAWrongWordOnWindow() {
		nullifyImplicitWait();

		List<WebElement> totalDisplayedWrongWords = LocatorWebElements(CLICKONANYWORDSYOUSAIDWRONGWORDS_LIST);

		Assert.assertTrue(totalDisplayedWrongWords.size() >= 1,
				"No words to select are being displayed on 'Click on Any Wrong words you said wrong' window");

		safeClick(CLICKONANYWORDSYOUSAIDWRONGWORDS_FIRSTWORD, LONGWAIT);

		setImplicitWait(IMPLICITWAIT);
	}

	/**
	 * To click on continue button on 'click on any words you said wrong' window
	 */
	public void clickContinueButtonOnnyWordsYouSaidWrongWindow() {
		safeClick(CLICKONANYWORDSYOUSAIDWRONGWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify that, 'click on the last word you read' window is displayed
	 */
	public void verifyNavigationToClickOnTheLastWordYouReadWindow() {
		Assert.assertTrue(isElementPresent(CLICKONTHELASTWORDYOUREAD_HEADERTITLE, LONGWAIT),
				"'Click on the last word you read' window is not displayed");
	}

	/**
	 * To click on some words on 'Click on the last word you read' window
	 */

	public void clikOnSomeLastWrodsYouRead() {
		nullifyImplicitWait();

		int totalDisplayedWordsLastRead = LocatorWebElements(CLICKONTHELASTWORDYOUREADWORDS_LIST).size();

		if (totalDisplayedWordsLastRead >= 10) {
			safeClick(CLICKONTHELASTWORDYOUREADWORDS_TENTHWORD, LONGWAIT);
		}
		if (totalDisplayedWordsLastRead != 0 && totalDisplayedWordsLastRead < 10) {
			safeClick(Dynamic.getNewLocator(CLICKONTHELASTWORDYOUREADWORDS_LASTWORD,
					Integer.toString(totalDisplayedWordsLastRead)), LONGWAIT);
		}
		if (totalDisplayedWordsLastRead == 0) {
			Assert.assertEquals(totalDisplayedWordsLastRead, 10,
					"No words to select are being displayed on 'click on last word you read window'");
		}

		setImplicitWait(IMPLICITWAIT);
	}

	/**
	 * To click on continue button on 'click on last words you read' window
	 */
	public void clickContinueButtonOnLastWordYouReadWindow() {
		safeClick(CLICKONTHELASTWORDYOUREADWORDS_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify that, 'Test Results' window is displayed
	 */
	public void verifyNavigationToTestResultsWindow() {
		Assert.assertTrue(isElementPresent(TESTRESULTSSUMMARYWINDOW_HEADERTITLE, LONGWAIT),
				"User is not taken to 'Test Results' window");
	}

	/**
	 * To retrieve the my score value from 'Test Results' window
	 */
	public int retriveMyScoreValueFromTestResultsWindow() {
		int myScoreValue = Integer.parseInt(safeGetText(TESTRESULTSSUMMARYWINDOW_SCORE_FIELD, LONGWAIT));

		return myScoreValue;
	}

	/**
	 * To click on 'submit for feedback' button on 'Test Results' window
	 */
	public void clickSubmitFeedBackButtonOnTestResultsWindow() {
		Assert.assertTrue(isElementPresent(TESTRESULTSSUMMARYWINDOW_SUBMITFEEDBACK_BTN, LONGWAIT),
				"The button 'Submit for feedbak' is not displayed under 'Test Results' section.");

		safeClick(TESTRESULTSSUMMARYWINDOW_SUBMITFEEDBACK_BTN, LONGWAIT);
	}

	/**
	 * To verify 'Your Recording has been submitted for feedback' window header
	 * text
	 * 
	 * @param expectedRecordingHasBeenSubmittedHeaderText
	 */

	public void verifyYourRecordingHasBeenSubmittedHeaderText(String expectedRecordingHasBeenSubmittedHeaderText) {
		String actualdRecordingHasBeenSubmittedHeaderText = safeGetText(YOURRECORDINGSUBMITTED_TEXT, LONGWAIT);

		Assert.assertEquals(actualdRecordingHasBeenSubmittedHeaderText, expectedRecordingHasBeenSubmittedHeaderText,
				"The expected header text(" + expectedRecordingHasBeenSubmittedHeaderText
						+ ") is not matched with the actual header text(" + actualdRecordingHasBeenSubmittedHeaderText
						+ ")");
	}

	/**
	 * To click continue button on 'Your Recording has been submitted for
	 * feedback' window
	 */
	public void clickContinueButtonOnYourRecordingHasBeenSubmittedWindow() {
		safeClick(YOURRECORDINGSUBMITTEDWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	/**
	 * To verify that, 'Word Per Minute Progress' window is displayed
	 */
	public void verifyNavigationToWordPerMinuteProgressWindow() {
		Assert.assertTrue(isElementPresent(WORDSPERMINUTEPROGRESSCHARTWINDOW_HEADERTITLE, LONGWAIT),
				"Words per minute progress chart window is not displayed");
	}

	/**
	 * To verify that my score value displayed under 'Words Per Minute Progress'
	 * chart is same as the score value displayed on 'Test Results' section
	 * 
	 * @param testResultsScoreValue
	 */
	public void verifyMyScoreValueInTheProgressChartWindow(int testResultsScoreValue) {
		int progressChartScoreValue = Integer
				.parseInt(safeGetAttribute(WORDSPERMINUTEPROGRESSCHARTWINDOW_SCORESPOT, "blacktooltip", LONGWAIT)
						.replace("wpm", ""));

		Assert.assertEquals(testResultsScoreValue, progressChartScoreValue,
				"The score value (" + progressChartScoreValue
						+ ") displayed in words per minute progress chart window doesn't match with the noted value("
						+ testResultsScoreValue + ")under 'Test Results' section");
	}

	/**
	 * To click continue button on 'Words Per Minute Progress' window
	 */
	public void clickContinueButtonOnWordPerMinuteProgressWindow() {
		safeClick(WORDSPERMINUTEPROGRESSCHARTWINDOW_CONTINUE_BTN, LONGWAIT);
	}

	public void verifyReadyToRecordPopUp() {
		Assert.assertTrue(isElementDisplayed(READY_TO_RECORD), "ready to record? pop up is not being dispalyed");
		safeClick(START_BTN, MEDIUMWAIT);
	}

	public void verifyPassageRecordingPage() {
		Assert.assertTrue(isElementDisplayed(RECORDING_TIMER), "Passage recording timer is not being dispalyed");
		Assert.assertTrue(isElementDisplayed(RECORDING_PASSAGE), "Recording Passage  is not being dispalyed");

	}

	public void clickStopTimerBtn(int recordingtime) {
		waitForSecs(recordingtime, "waiting for the passage to record");
		safeClick(STOP_TIMER_BTN, MEDIUMWAIT);
	}

	public void verifyUploadPopup() {
		waitForSecs(10,"Waiting for pop up should load");
		Assert.assertTrue(isElementDisplayed(READY_TO_UPLOAD_RECORDING_POPUP),
				"Passage upload pop up is not being dispalyed");
		safeClick(START_BTN, LONGWAIT);
		//Assert.assertTrue(isElementDisplayed(ENCODE_RECORDING_POPUP), "Encode recording pop up is not being dispalyed");
		Assert.assertTrue(isElementDisplayed(UPLOAD_YOUR_RECORDING_POPUP),
				"Uploading your recording pop up  is not being dispalyed");
		Assert.assertTrue(isElementDisplayed(UPLOAD_COMPLETE_POPUP),
				"Passage recording upload complete pop up is not being dispalyed");

	}

	public void verifyReviewPopup() {
		Assert.assertTrue(isElementDisplayed(REVIEW_POPUP), "Review your recording pop up is not being dispalyed");
		safeClick(START_BTN, LONGWAIT);
	}

	public void verifyPassageReviewPage() {
		Assert.assertTrue(isElementDisplayed(PASSAGE_REVIEW_PAGE), "Passage review page is not being dispalyed");
	}

	public void clickWordsRecordedWrong() {
		passageWordCount = LocatorWebElements(PASSAGE_WORD);
		wordCount = passageWordCount.size();

		safeClick(Dynamic.getNewLocator(WRONG_WORD, Integer.toString(wordCount)), LONGWAIT);
		safeClick(Dynamic.getNewLocator(WRONG_WORD, Integer.toString(wordCount - 1)), LONGWAIT);
		safeClick(CONTINUE_BTN, MEDIUMWAIT);
	}

	public void clickLastWordRecorded() {
		Assert.assertTrue(isElementDisplayed(LAST_WORD), "Click on the last word you read page is not being dispalyed");
		safeClick(Dynamic.getNewLocator(WRONG_WORD, Integer.toString(wordCount - 2)), LONGWAIT);
		safeClick(CONTINUE_BTN, MEDIUMWAIT);
	}

	public void retakeAttempt(int attempt){
		
		if(attempt==6){
			safeClick(CONTINUE_BTN, MEDIUMWAIT);
			  waitForPageToLoad();
		}
		else{
			if(attempt==1 || attempt==2){
			safeClick(RETAKE_TEST_BTN, MEDIUMWAIT);
			  waitForPageToLoad();
			}
			else{
				safeClick(RETAKE_BTN, MEDIUMWAIT);
			}
		}
	}
	
	public void readPassageTest(LLData llData, int attempcount) {

		for (int i = 1; i <= attempcount; i++) {
			
		//	retakeAttempt();
			// Step20: Verify 'Ready to Record?' pop up and click 'Start' button
			verifyReadyToRecordPopUp();
			// Step21: Verify the passage recording page
			verifyPassageRecordingPage();
			// Step22: Click 'Stop Timer' button
			clickStopTimerBtn(15);
			// Step23: Verify the uploading pop ups
			verifyUploadPopup();
			// Step24: Verify Review your Recording. pop up and click 'Start'
			// button
			verifyReviewPopup();
			// Step25: Verify Review passage page
			verifyPassageReviewPage();
			// Step26: Click on the words that recored wrong and click continue
			// button
			clickWordsRecordedWrong();
			// Step26: Click on the last word read in the passage and click
			// 'Continue' button
			clickLastWordRecorded();
			// Step27: Verify the results screen
			verifyNavigationToTestResultsWindow();
			// To retrieve the my score value from 'Test Results' window
			myScoreValue = retriveMyScoreValueFromTestResultsWindow();
			retakeAttempt(i);

			
			
			
			
		}

	}

}

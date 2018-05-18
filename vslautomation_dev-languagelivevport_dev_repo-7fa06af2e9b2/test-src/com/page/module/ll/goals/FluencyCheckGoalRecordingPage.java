package com.page.module.ll.goals;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;

import com.page.locators.ll.goals.FluencyCheckGoalRecordingLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;

public class FluencyCheckGoalRecordingPage extends CommonFunctionalities implements FluencyCheckGoalRecordingLocators{

	private WebDriver driver;
	
	public FluencyCheckGoalRecordingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * To verify navigation to ready to start recording pop-up
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	
	public void verifyNavigationToReadyToStartRecordingPopup()
	{
		Assert.assertTrue(isElementPresent(READY_TO_START_RECORDING_POPUP_HEADER, LONGWAIT), "Ready to start recording popup is not displayed when reading fluency check activity as student user");	
	}
	
	/**
	 * Purpose-To click on start button on Ready To Start Recording pop-up 
	 */
	public void clickStartButtonOnReadyToStartRecordingPopup()
	{
		safeClick(START_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose-To verify navigation to fluency check passage reading pop-up
	 */
	
	public void verifyNavigationToFluencyPassageReadingPopup()
	{
		Assert.assertTrue(isElementPresent(FLUENCY_READING_PASSAGE_BODY, LONGWAIT), "Fluency check reading passage popup is not displayed when clicked on start button on Ready to start recording popup");
	}
	
	/**
	 * Purpose-To click on 'Stop Recording' button on Fluency check passage reading pop-up
	 */
	public void clickStopRecordingButtonOnFluencyPassageReading()
	{
		safeClick(FLUENCY_READING_PASSGE_STOPRECORDING_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose-To verify navigation to Ready to Upload your recording pop-up
	 */
	
	public void verifyNavigationToReadyToUploadYourRecordingPopup()
	{
		Assert.assertTrue(isElementPresent(READY_TO_UPLOAD_RECORDING_HEADER, LONGWAIT), "Ready to upload your recording pop-up is not being displayed when clicked on stop time button on fluency check passage section");
	}
	
	/**
	 * Purpose-To click on 'start' button on 'Ready to upload your recording' pop-up
	 */
	public void clickStartButtonOnReadyToUploadRecordingPopup()
	{
		safeClick(START_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose-To verify that upload is complete successfully
	 */
	
	public void verifyThatRecordingUploadIsComplete()
	{
		Assert.assertTrue(isElementPresent(ENCODING_YOUR_RECORDING_HEADER, LONGWAIT), "Encoding your recording message is not being displayed while uploading the fluency check recording");
		Assert.assertTrue(isElementPresent(UPLOADING_YOUR_RECORDING_HEADER, LONGWAIT), "Uploading your recording message is not being displayed while uploading the fluency check recording");
		Assert.assertTrue(isElementPresent(UPLOAD_COMPLETE_HEADER, LONGWAIT), "Upload complete message is not being displayed while uploading the fluency check recording");
	}
	
	/**
	 * Purpose- To verify that click on the last word you read pop-up header is displayed
	 */
	
	public void verifyNavigationToClickOnTheLastWordYouReadPopup()
	{
		Assert.assertTrue(isElementPresent(CLICKONTHELASTWORDYOUREAD_HEADER, LONGWAIT), "Click on the last word you read pop-up is not being displayed");
	}
	
	/**
	 * Purpose-To click on 'start' button on 'Last word you read' pop-up
	 */
	public void clickStartButtonOnLastWordYouReadPopup()
	{
		safeClick(START_BTN, LONGWAIT);
	}
	
	/**
	 * Purpose- To verify navigation to click on the last word you read passage section
	 */
	public void verifyTheNavigationToLastWordYouReadPassageContent()
	{
		Assert.assertTrue(isElementPresent(LASTWORD_YOU_READ_CONTENT, LONGWAIT), "Click on the last word you read passage content is not being displayed for fluency check reading");
		waitForPageToLoad();
	}
	/**
	 * Purpose- To click on a word under last word you read passage
	 */
	public void clikOnSomeLastWrodsYouRead()
	{
		nullifyImplicitWait();
		
		int totalDisplayedWordsLastRead = LocatorWebElements(LASTWORD_YOU_READ_CONTENT_WORDS).size();	
		
		if(totalDisplayedWordsLastRead>=10)
		{			
			safeClick(CLICKONTHELASTWORDYOUREADWORDS_TENTHWORD, LONGWAIT);
		}
		if(totalDisplayedWordsLastRead!=0 && totalDisplayedWordsLastRead<10)
		{
			safeClick(Dynamic.getNewLocator(LASTWORD_YOU_READ_WORD_TOBECLICKED, Integer.toString(totalDisplayedWordsLastRead)), LONGWAIT);
		}
		if(totalDisplayedWordsLastRead==0)
		{
			Assert.assertEquals(totalDisplayedWordsLastRead, 10, "No words to select are being displayed on 'click on last word you read window' for fluency check reading");
		}
		
		setImplicitWait(IMPLICITWAIT);
	}
	
	
	/**
	 * Purpose-To click on 'continue' button on 'Last word you read' passge section
	 */
	public void clickContinueButtonOnLastWordYouReadPopup()
	{
		safeClick(CONTINUE_BTN, LONGWAIT);
	}
	
	
	/**
	 * To verify that, 'Fluencyt check Test Results' window is displayed
	 */
	public void verifyNavigationToTestResultsWindow()
	{
		Assert.assertTrue(isElementPresent(FLUENCY_CHECK_SUMMARY_SECTION, LONGWAIT),"User is not taken to Fluency check reading 'Test Results' window");
	}
	
	/**
	 * To retrieve the my score value from 'Test Results' window
	 */
	public int retriveMyScoreValueFromTestResultsWindow()
	{
		int myScoreValue = Integer.parseInt(safeGetText(FLUENCY_CHECK_SUMMARY_SCORE, LONGWAIT));
		
		return myScoreValue;
	}
	
	/**
	 * To click on  'submit recording' button on 'Test Results' window
	 */
	public void clickSubmitRecordingButtonOnTestResultsWindow()
	{
		Assert.assertTrue(isElementPresent(SUBMIT_YOUR_RECORDING_BTN, LONGWAIT),"The button 'Submit Recording' is not being displayed under fluency check 'Test Results' section.");
		
		safeClick(SUBMIT_YOUR_RECORDING_BTN, LONGWAIT);
	}
	
	/**
	 * To verify that, 'Your recording has been received' window is displayed
	 */
	public void verifyThatYourRecordingHasBeenReceivedMessageDisplayed()
	{
		Assert.assertTrue(isElementPresent(YOURRECORDINGHASBEENRECEIVED_MESSAGE, LONGWAIT),"Your recording has been received message is not being displayed for fluency check reading");
	}
	
	/**
	 * To click on  'Continue' button on 'Your recording has been received' window
	 */
	public void clickContinueButtonOnRecordingHasBeenSubmittedWindow()
	{
		Assert.assertTrue(isElementPresent(CONTINUE_BTN, LONGWAIT),"The button 'Continue' is not being displayed under fluency check 'Your recording has been received message' section.");
		
		safeClick(CONTINUE_BTN, LONGWAIT);
	}
	
	/**
	 * To verify that, 'Word Per Minute Progress' window is displayed
	 */
	public void verifyNavigationToWordPerMinuteProgressWindow()
	{
		Assert.assertTrue(isElementPresent(WORDSPERMINUTEPROGRESSCHARTWINDOW_HEADERTITLE, LONGWAIT),"Words per minute progress chart window is not displayed for fluency check reading");
	}
	
	/**
	 * To verify that my score value displayed under 'Words Per Minute Progress' chart is same as the score value displayed on 'Test Results' section
	 * @param testResultsScoreValue  
	 */
	public void verifyMyScoreValueInTheProgressChartWindow(int testResultsScoreValue)
	{
		int progressChartScoreValue=Integer.parseInt(safeGetAttribute(WORDSPERMINUTEPROGRESSCHARTWINDOW_SCORESPOT, "blacktooltip", LONGWAIT).replace("wpm",""));
		
		Assert.assertEquals(testResultsScoreValue, progressChartScoreValue, "The score value ("+progressChartScoreValue+") displayed in words per minute progress chart window doesn't match with the noted value("+testResultsScoreValue+")under 'Test Results' section for fluency reading");
	}
	
	/**
	 * To click continue button on 'Words Per Minute Progress' window 
	 */
	public void clickContinueButtonOnWordPerMinuteProgressWindow()
	{
		safeClick(WORDSPERMINUTEPROGRESSCHARTWINDOW_CONTINUE_BTN, LONGWAIT);
	}	
	
	
	
}

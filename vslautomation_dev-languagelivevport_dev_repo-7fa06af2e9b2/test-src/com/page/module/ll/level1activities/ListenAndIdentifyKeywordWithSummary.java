package com.page.module.ll.level1activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.datamanager.ConfigManager;
import com.testng.Assert;

public class ListenAndIdentifyKeywordWithSummary extends CommonFunctionalities implements com.page.locators.ll.level1activites.ListenIdentifyKeywordWithSummaryLocators{

	WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public ListenAndIdentifyKeywordWithSummary(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose of this method is to verify whether activity is loaded or not
	 * */
	public void verifyListenIdentifyActivity(){
		closeInstIcon();	
		Assert.assertTrue(isElementPresent(AUDIO_BAR, LONGWAIT), "Activity name is not being displayed");
	}


	/**
	 * Purpose of this method is to perform QC on one bundle of the activity
	 * */
	public void ListenIdentifyKeyword()
	{
		if(executionMode.equalsIgnoreCase("rc"))
		{
			log.info("Runnig the ListenIdentifyKeyword Activity at RC mode");
			for(int i=0;i<8;i++)
			{
				safeClick(AUDIO_BAR);
				Assert.assertTrue(isElementDisplayed(AUDIO_ENABLED), "Activity name is not being displayed");
				safeClick(ANSWER_TILE);
				if(isElementPresent(CROSS_MARK))
				{
					waitUntilElementDisappears(CROSS_MARK);
					safeClick(ANSWER_TILE);	
										
				}
				waitForSecs(10,"wait for right mark or wrong mark to disappear and wait for next bundle automatic audio to complete");
				
			}
		}
		else
		{
			log.info("Runnig the ListenIdentifyKeyword Activity at QC mode");
			safeClick(AUDIO_BAR);
			Assert.assertTrue(isElementDisplayed(AUDIO_ENABLED), "Activity name is not being displayed");
			safeClick(ANSWER_TILE);
			if(isElementPresent(CROSS_MARK)){

				waitUntilElementDisappears(CROSS_MARK);
				safeClick(ANSWER_TILE);	
			}
		}
		waitForSecs(10,"Waiting for Summery Header to load");
	}

	/**
	 * Purpose of this method is to verify the sumamry page of the activtiy
	 * */
	public void listenAndIdentifySummary()
	{
		
		isElementPresent(SUMMARY_HEADER, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(SUMMARY_HEADER), "Activity name is not being displayed");


		// get the Correct  and Incorrect answers  count displayed in respective columns

		List<WebElement> correctCount = LocatorWebElements(CORRECT_COUNT);
		List<WebElement> incorrectCount = LocatorWebElements(INCORRECT_COUNT);

		String correctAnswersCount = Integer.toString(correctCount.size());
		String incorrectAnswersCount = Integer.toString(incorrectCount.size());

		int correct = correctCount.size();
		int incorrect = incorrectCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);


		String summaryCorrectCount = driver.findElement(SUMMARY_HEADER_CORRECT_VOUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + summaryCorrectCount);

		String summaryQuestionscount = driver.findElement(SUMMARY_HEADER_QUES_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + summaryQuestionscount);

		// compare the Correct answers count with the correct count displayed in the Summary Header

		if ((summaryCorrectCount.equals(correctAnswersCount)) && (summaryQuestionscount.contains(Integer.toString(total_question)))) {
			System.out.println("Correct answers count is matched with the Correct count dispalyed in the Summary header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}		
	}

}

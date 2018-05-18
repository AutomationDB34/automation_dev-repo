package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.PhrasesAndSentencesLocators;
import com.selenium.Dynamic;
import com.testng.Assert;

public class PhrasesAndSentences extends CommonFunctionalities implements PhrasesAndSentencesLocators {

	private WebDriver driver;
	private LLData llData = new LLData();
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public PhrasesAndSentences(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify loading of Phrases and sentences
	 * activity
	 */
	public void verifyStepOfTheActivity() {

		Assert.assertTrue(isElementPresent(STEP_HEADER, LONGWAIT),
				"Phrases and Sentences activity step is not being displayed on activity page");
	}


	/**
	 * Purpose of this method is to perfrom QC on one bundle of the Phrases and
	 * sentences activity
	 */

	public void PhrasesAndSentences(){

		microPhoneSetUp(llData);
		// Close the instruction pop in order to enable the Activity container
		closeInstIcon();
		verifyStepOfTheActivity();
		if(executionMode.equalsIgnoreCase("rc"))
		{

			log.info("Runnig the Phrases And Sentences Activity at RC mode");
			for(int j=0;j<10;j++)
			{	
				// get the count of words in the bundle
				List<WebElement> wordcount = LocatorWebElements(Dynamic.getNewLocator(WORDS, ""));
				System.out.println(wordcount.size());
				for (int i = 1; i <= wordcount.size(); i++) 
				{
					// Clicks the individual word in the bundle
					String str = "[" + i + "]";
					By ele1 = Dynamic.getNewLocator(WORDS, str);
					System.out.println(ele1);
					safeActionsClick(ele1, MEDIUMWAIT);
					waitForSecs(3);
				}
				verifyStepOfTheActivity();
				waitUntilClickable(RECORD_BTN, LONGWAIT);
				safeClick(RECORD_BTN, LONGWAIT);
				verifyStepOfTheActivity();
				waitUntilClickable(THUMPS_UP, LONGWAIT);
				safeClick(THUMPS_UP, LONGWAIT);
				waitForSecs(5, "wait untill next phrase appears");
			}
		}
		else
		{
			log.info("Runnig the Phrases And Sentences Activity at QC mode");
			// get the count of words in the bundle
			List<WebElement> wordcount = LocatorWebElements(Dynamic.getNewLocator(WORDS, ""));
			System.out.println(wordcount.size());
			for (int i = 1; i <= wordcount.size(); i++) 
			{
				// Clicks the individual word in the bundle
				String str = "[" + i + "]";
				By ele1 = Dynamic.getNewLocator(WORDS, str);
				System.out.println(ele1);
				safeActionsClick(ele1, MEDIUMWAIT);
				waitForSecs(3);
			}
			verifyStepOfTheActivity();
			waitUntilClickable(RECORD_BTN, LONGWAIT);
			safeClick(RECORD_BTN, LONGWAIT);
			verifyStepOfTheActivity();
			waitUntilClickable(THUMPS_UP, LONGWAIT);
			safeClick(THUMPS_UP, LONGWAIT);
		}
	}

	/**
	 * Purpose of this method is to perfrom to verify Phrases and sentences
	 * activity summary
	 */
	public void activitySummary() {

		// get the thumpsUP and Thumps down words count displayed in respective
		// column
		List<WebElement> thumpsupCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> thumpsdownCount = LocatorWebElements(INCORRECT_ANSWERS);

		String correctCount = driver.findElement(SUMMARY_CORRET_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctCount);

		String questionscount = driver.findElement(SUMMARY_TOTAL_QUESTIONS).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscount);

		String thumpsUpCount = Integer.toString(thumpsupCount.size());
		String thumpsDownCount = Integer.toString(thumpsdownCount.size());

		int correct = thumpsupCount.size();
		int incorrect = thumpsdownCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		// compare the Thumpsup count with the correct count displayed in the
		// summary header
		if ((correctCount.equals(thumpsUpCount)) && (questionscount.contains(Integer.toString(total_question)))) {
			System.out.println("ThumpsUP coulumn count is matched with the Correct count dispalyed in the header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}

	}
}

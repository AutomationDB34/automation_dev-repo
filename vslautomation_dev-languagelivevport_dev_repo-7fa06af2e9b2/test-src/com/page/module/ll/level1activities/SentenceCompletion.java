package com.page.module.ll.level1activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.SentenceCompletionLocators;
import com.testng.Assert;

public class SentenceCompletion extends CommonFunctionalities implements SentenceCompletionLocators {

	private WebDriver driver;
	private LLData llData = new LLData();
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public SentenceCompletion(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify whether the activity is loaded or not
	 */
	public void verifySentenceCompletion() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR, LONGWAIT),
				"Sentence Completion activity is not being dispalyed ");
	}

	/**
	 * Purpose of this method is to perform drag and drop function in sentence
	 * completion activity
	 */
	public void fill_the_Sentence(boolean isIE)
	{
		// verify the audio functionality
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED, LONGWAIT),
				"Sentence Completion activity audio is not being palyed ");

		/*if (isIE) {
			waitForSecs(7,"Waiting for the answer container");
			try
			{
			safeClickUsingSikuli(llData.SentenceCompletionMousePointerImage,
					"answer container section of the Sentence Completion activity using sikuli", LONGWAIT);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}*/
		// drag and drop the answer tile into answer area
		//
	}

	/**
	 * Purpose of this method is to verify the summary of the sentence
	 * completion activity
	 */
	public void sentenceCompletionSummary() {


		waitForSecs(20, "Waiting for thePage to load");
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER, LONGWAIT),
				"Sentence Completion activity summary page is not being dispalyed ");

		List<WebElement> correctAnswersCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectAnswersCount = LocatorWebElements(INCORRECT_ANSWERS);

		System.out.println("Correct answers:" + correctAnswersCount.size());
		System.out.println("InCorrect answers:" + incorrectAnswersCount.size());
		safeClick(SUMMARY_CONTINUE);
		waitForPageToLoad();
		//waitForSecs(8, "wait untill audio cross mark is completed");
		//closeInstIcon();
		
		//waitUntilElementDisappears(SPELLING_AUTOAUDIO);
		
	}

	/*	*//**
	 * Purpose of this method is to verify all bundles of the Sentence
	 * completion activity
	 *//*
	public void rcSentencecompletion(boolean isIE){

		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

					fill_the_Sentence(isIE);
			if (isElementPresent(CROSS_MARK)) {
				safeClick(AUDIO_BAR);
				waitUntilElementDisappears(CROSS_MARK);
				fill_the_Sentence(isIE);
			}
		sentenceCompletionSummary();
	}
}*/
	/**
	 * Purpose of this method is to verify one bundle of the Sentence
	 * completion activity
	 * User has two chances for each bundle . If failed at the second attempt , sentence is automatically collaborated
	 */

	public void sentenceCompletion(boolean isIE)
	{
		String modefExecution=executionMode.toLowerCase().toString().trim();
		
		if(modefExecution.equalsIgnoreCase("rc"))
		{
			log.info("Runnig the SentenceCompletion Activity at RC mode");
			
			List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
			
			System.out.println("Bundle count:" + bundlecount.size());
			
			//fill_the_Sentence(isIE);
			
			log.info("total bundle size is"+bundlecount.size());
			
			for (int bundles = 0; bundles <bundlecount.size(); bundles++) 
			{
				log.info("Completed bundle "+bundles);
				
				waitForPageToLoad();
				
				waitForSecs(5, "waiting for sentance boxes to appear");
				
				dragAndDropwithRobots(ANSWER_TILE, DRAGGABLE_AREA, LONGWAIT,isIE);
				
				waitForPageToLoad();
				
				waitForSecs(4, "waiting for sentance to load after drag");
				
				if (isElementPresent(CROSS_MARK)) 
				{
					waitForSecs(5, "waiting for cross mark to disppear");
					
					waitUntilElementDisappears(CROSS_MARK);
					
					safeClick(AUDIO_BAR);
					
					//Audio is about to play for 6 seconds
					
					waitForSecs(6, "waiting for audio to complete");  
					
					//Dragging the answer for second time as user has two chances of attempt for the selected bundle
					
					dragAndDropwithRobots(ANSWER_TILE, DRAGGABLE_AREA, LONGWAIT,isIE); 
					
					waitForSecs(10, "waiting for sentance to load after drag");
					
					//fill_the_Sentence(isIE);
				}
//				else if(isElementPresent(RIGHT_MARK)) 
//				{
//					// if Dragged option is correct for the first time then the sentence will be automatically collaborated
//					
//					waitForSecs(10, "waiting for summary of correct answer to collabrate");
//					continue;
//					
//				}
			}
			waitForSecs(10);
			sentenceCompletionSummary();
		}
		else
		{
			log.info("Runnig the SentenceCompletion Activity at QC mode");
			
			waitForPageToLoad();
			
			waitForSecs(4, "waiting for sentance boxes to appear");
			
			//fill_the_Sentence(isIE);
			dragAndDropwithRobots(ANSWER_TILE, DRAGGABLE_AREA, LONGWAIT,isIE);
			
			waitForPageToLoad();
			
			if (isElementPresent(CROSS_MARK)) 
			{
				waitForSecs(4, "waiting for cross mark to disppear");
				
				waitUntilElementDisappears(CROSS_MARK);
				
				safeClick(AUDIO_BAR);
				
				//Audio is about to play for 6 seconds
				
				waitForSecs(6, "waiting for audio to complete");  
				
				//Dragging the answer for second time as user has two chances of attempt for the selected bundle
				
				dragAndDropwithRobots(ANSWER_TILE, DRAGGABLE_AREA, LONGWAIT,isIE); 
				
				waitForSecs(10, "waiting for sentance to load after drag");
				
				//fill_the_Sentence(isIE);
			}
//			else if(isElementPresent(RIGHT_MARK)) 
//			{
//				// if Dragged option is correct for the first time then the sentence will be automatically collaborated
//				
//				waitForSecs(5, "waiting for summary of correct answer to collabrate");
//								
//			}
			waitForSecs(6);
			sentenceCompletionSummary();
		}

	}
}

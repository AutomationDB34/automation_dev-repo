package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.BlendAndReadLocators;
import com.selenium.Dynamic;
import com.testng.Assert;

public class BlendAndRead extends CommonFunctionalities implements BlendAndReadLocators {

	private WebDriver driver;
	private LLData llData = new LLData();
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());
	public BlendAndRead(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * purpose of the method is to test the blend and read activity one bundle
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void blendandReadActivity(){
		// verifyMicroPhonePopup();
		microPhoneSetUp(llData);
		//Close the instruction pop in order to enable the Activity container
		closeInstIcon();
		//Verify the presence of the Activity container
		boolean activityNameExists = isElementPresent(ACTIVITY_NAME, LONGWAIT);
		Assert.assertTrue(activityNameExists, "Activity name is not being displayed");
		waitForSecs(6);
		//Conditional run for blend and Read Activity
		if(executionMode.equalsIgnoreCase("qc"))
		{
			log.info("Runnig the Blend Activity at QC mode");
			waitForPageToLoad();
			waitForSecs(10, "explicit wait time to load the page");
			// get the count of syllables in the bundle
			List<WebElement> letrcount = LocatorWebElements(Dynamic.getNewLocator(LIST_ELEMENTS, ""));
			System.out.println(letrcount.size());
			for (int i = 1; i <= letrcount.size(); i++) 
			{
				// Clicks the individual syllable in the bundle
				String str = "[" + i + "]";
				By ele1 = Dynamic.getNewLocator(LIST_ELEMENTS, str);
				System.out.println(ele1);
				verifyinstructionIcon();
				safeActionsClick(ele1, MEDIUMWAIT);
				waitForSecs(6);			
			}
			waitForPageToLoad();
			// Record the word after blending
			verifyinstructionIcon();
			safeClick(RECORD_BUTTON, MEDIUMWAIT);
			// Grade the word after reviewing
			verifyinstructionIcon();
			safeClick(GRADING_BTN, MEDIUMWAIT);
		}

		else
		{
			log.info("Runnig the Blend Activity at RC mode");
			//Count the Steps need to be completed by student
			List<WebElement> progressBars = LocatorWebElements(PROGRESS_STEP_COUNT);
			for(int progressCount = 1;progressCount <= progressBars.size();progressCount++)
			{
				waitForPageToLoad();
				waitForSecs(10, "explicit wait time to load the page");
				// get the count of syllables in the bundle
				List<WebElement> letrcount = LocatorWebElements(Dynamic.getNewLocator(LIST_ELEMENTS, ""));
				System.out.println(letrcount.size());
				for (int i = 1; i <= letrcount.size(); i++) 
				{
					// Clicks the individual syllable in the bundle
					String str = "[" + i + "]";
					By ele1 = Dynamic.getNewLocator(LIST_ELEMENTS, str);
					System.out.println(ele1);
					verifyinstructionIcon();
					safeActionsClick(ele1, MEDIUMWAIT);
					waitForSecs(5,"Waiting the clicked letter to highlighted");			
				}
				waitForPageToLoad();
				// Record the word after blending
				verifyinstructionIcon();
				safeClick(RECORD_BUTTON, MEDIUMWAIT);
				// Grade the word after reviewing
				verifyinstructionIcon();
				safeClick(GRADING_BTN, MEDIUMWAIT);
			}
		}
	}


	/**
	 * purpose of the method is to verify the summary page of the activity 
	 */
	public void blendandReadSummary() {
		// get the thumpsUP and Thumps down words count displayed in respective
		// column
		List<WebElement> thumpsupCount = LocatorWebElements(THUMPS_UP_COUNT);
		List<WebElement> thumpsdownCount = LocatorWebElements(THUMPS_DOWN_COUNT);

		String correctCount = driver.findElement(CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctCount);

		String questionscount = driver.findElement(NUMBER_OF_QUESTIONS).getText();
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
			safeClick(CONTINUE_SUMMARY);
		} else {

			System.out.println("count not matching");
		}

	}

}

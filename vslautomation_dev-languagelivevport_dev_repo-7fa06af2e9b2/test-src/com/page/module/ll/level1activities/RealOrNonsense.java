package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level1activites.RealOrNonsenseLocators;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class RealOrNonsense extends CommonFunctionalities implements RealOrNonsenseLocators {
	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public RealOrNonsense(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose of this method is to verify the activity is displayed or not
	 * */
	public void verifyRealNonsenseActivity(){

		Assert.assertTrue(isElementPresent(TILE, LONGWAIT), "Activity is not being displayed");
	}

	/**
	 * Purpose of this method is to complete the Real OR Nonsense activity and navigate to summary page
	 * */
	public void rcrealOrNonsense(boolean isIE) {
		//close the instructions  
		closeInstIcon();

		if(isIE)
		{
			Point coordinates=driver.findElement(REAL_COLUMN).getLocation();
			int x = coordinates.getX();             
			int y = coordinates.getY(); 
			Dimension dimentions = driver.findElement(REAL_COLUMN).getSize();
			int height = dimentions.getHeight();                      
			int width = dimentions.getWidth();
			try
			{
				Robot robotclass = new Robot();
				robotclass.mouseMove(x+height/2,y+width/2);
			}
			catch(AWTException e)
			{
				log.info("unable to perform keyboard actions"+ UtilityMethods.getStackTrace());
			}

		}

		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		//for each bundle verify whether the new word is displayed or not and drag into one of the column
		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

			isElementClickable(AUDIO_BTN);
			dragAndDrop(TILE, REAL_COLUMN , LONGWAIT);			
		}
	}

	/**
	 * Purpose of this method is to verify the summary page of the  activity and to click the continue button 
	 * */
	public void realOrNonsenseSummary(){

		//get the correct (green color) tiles count
		List<WebElement> correctcount = LocatorWebElements(CORRECT_ANSWERS);
		System.out.println("correct count:" + correctcount.size());

		//get the incorrect (red color) tiles count
		List<WebElement> incorrectcount = LocatorWebElements(INCORRECT_ANSWERS);
		System.out.println("incorrect count:" + incorrectcount.size());

		int totalQuestions = correctcount.size()+incorrectcount.size();

		//get the correct answer count displayed in the summary page
		String summaryCorrectCount = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + summaryCorrectCount);

		//get the total questions count displayed in the summary page
		String summaryQuestionscount = driver.findElement(SUMMARY_NO_OF_QUES).getText();
		System.out.println("Number of questions displayed in the summary header:" + summaryQuestionscount);

		//Verify the correct answers count displayed in summary header and correct count matching or not
		//Verify the total question count displayed in the summary header is matching with the total question count(ie., correct+incorrect)
		if(summaryCorrectCount.equals(Integer.toString(correctcount.size())) && (summaryQuestionscount.contains(Integer.toString(totalQuestions)))){

			System.out.println("Correct count is matched with the Correct count dispalyed in the summary header");
			safeClick(SUMMARY_CONTINUE_BTN);			
		}
	}
}

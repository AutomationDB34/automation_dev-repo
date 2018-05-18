package com.page.module.ll.level1activities;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level1activites.WordSortMultiColumnLocators;
import com.testng.Assert;

public class WordSortMultiColumn extends CommonFunctionalities implements WordSortMultiColumnLocators{

	private WebDriver driver;
	String substr=null;
	
	
	public WordSortMultiColumn(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose of the method is to verify the loading of the activity 
	 * */
	public void verifyWordSortMultiColumnActivity(){
		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BTN), "Wordsort multi column Activity is not being displayed");
	}

	/**
	 * Purpose of the method is to verify sorting functionality for all the bundles
	 * */
	public void wordSortMultiColumnActivity(boolean isIE) {
		
		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {
		
		Assert.assertTrue(isElementClickable(AUDIO_BTN), "Audio icon of the activity is not functional");
		
		String str1 = safeGetText(DRAGGABLE_TILE , LONGWAIT);
		System.out.println(str1);
		
		int lengthofString = str1.length();
		System.out.println(lengthofString);
		
		if(lengthofString==5){
		substr = str1.substring(3);
		System.out.println(substr);
		}
		else{
			substr = str1.substring(2);
			System.out.println(substr);
		}
		
		switch(substr){
		case "ff": dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_COLUMN_FF, LONGWAIT, isIE);
					break;
		case "ll": dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_COLUMN_LL, LONGWAIT, isIE);
					break;
		case "ss":dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_COLUMN_SS, LONGWAIT, isIE);
					break;
		case "zz": dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_COLUMN_ZZ, LONGWAIT, isIE);
					break;
		}
		
	}
	}
	
	/**
	 * Purpose of the method is to verify summary page of the activity
	 * */
	public void wordSortMultiColumnSummary(){
		// get the correct and incorrect words count displayed in respective
		// column
		List<WebElement> correctAnswersCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectAnswersCount = LocatorWebElements(INCORRECT_ANSWERS);

		String correctanswersCount = Integer.toString(correctAnswersCount.size());
		String incorrectanswersCount = Integer.toString(incorrectAnswersCount.size());

		int correct = correctAnswersCount.size();
		int incorrect = incorrectAnswersCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);
		
		String correctCount = driver.findElement(SUMMARY_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctCount);

		String questionscount = driver.findElement(SUMMARY_QUESTIONS_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscount);

		// compare the correct answers count with the correct count displayed in the
		// summary header
		if ((correctCount.equals(correctanswersCount)) && (questionscount.contains(Integer.toString(total_question)))) {
			System.out.println("Correct answers count is matched with the Correct count dispalyed in the Summary header");
			safeClick(SUMMARY_CONTINUE_BTN);
		} else {

			System.out.println("count not matching");
		}
	}
	}

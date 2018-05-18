package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.WordConstructionLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;

public class WordConstruction extends CommonFunctionalities implements WordConstructionLocators {

	private WebDriver driver;
	private LLData llData = new LLData();

	public WordConstruction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to complete word construction activity
	 */
	public void wordConstruction() {
		closeInstIcon();

		String leftcontainer[] = { llData.WordConstructionTile1, llData.WordConstructionTile3,
				llData.WordConstructionTile5, llData.WordConstructionTile7, llData.WordConstructionTile9,
				llData.WordConstructionTile11, llData.WordConstructionTile13 };
		String rightcontainer[] = { llData.WordConstructionTile2, llData.WordConstructionTile4,
				llData.WordConstructionTile6, llData.WordConstructionTile8, llData.WordConstructionTile10,
				llData.WordConstructionTile12, llData.WordConstructionTile14 };

		for (int i = 0; i < 7; i++) {
			By str1 = Dynamic.getNewLocator(WORDS_IN_LEFT_COLUMN, leftcontainer[i]);
			System.out.println(str1);

			By str2 = Dynamic.getNewLocator(WORDS_IN_RIGHT_COLUMN, rightcontainer[i]);
			System.out.println(str2);

			safeClickUsingSikuli(llData.wordConstructionLeftMousePointerImage, "Word Construction left container",
					LONGWAIT);
			dragAndDrop(str1, LEFT_DRAGGABLE_AREA, LONGWAIT);

			safeClickUsingSikuli(llData.wordConstructionRighttMousePointerImage, "Word Construction right container",
					LONGWAIT);
			dragAndDrop(str2, RIGHT_DRAGGABLE_AREA, LONGWAIT);

			safeClick(CHECK_IT_BTN);

			if (isElementPresent(TICK_MARK)) {
				System.out.println("correct match is made");
				waitUntilElementDisappears(TICK_MARK, LONGWAIT);
			}
		}
	}

	/**
	 * Purpose is to verify the summary page of the Word construction activity
	 */
	public void wordConstructionSummary() {

		// get the correct and incorrect words count displayed in summary page

		List<WebElement> correctAnswersCount = LocatorWebElements(CORRECT_ANSWERS);
		List<WebElement> incorrectAnswersCount = LocatorWebElements(INCORRECT_ANSWERS);

		String correctAnswers = Integer.toString(correctAnswersCount.size());
		System.out.println(correctAnswers);

		String incorrectAnswers = Integer.toString(incorrectAnswersCount.size());
		System.out.println(incorrectAnswers);

		// get the correct words count and questions count displayed in summary
		// page Header
		String correctAnswersInSummaryHEader = driver.findElement(HEADER_CORRECT_COUNT).getText();
		System.out.println("Correct count dispalyed in summary Page:" + correctAnswersInSummaryHEader);

		String questionscountInSumamryHeader = driver.findElement(HEADER_QUES_COUNT).getText();
		System.out.println("Number of questions displayed in the summary header:" + questionscountInSumamryHeader);

		int correct = correctAnswersCount.size();
		int incorrect = incorrectAnswersCount.size();
		int total_question = correct + incorrect;
		System.out.println(total_question);

		// compare the correct words count with the correct count displayed in
		// the summary header
		if ((correctAnswersInSummaryHEader.equals(correctAnswers))
				&& (questionscountInSumamryHeader.contains(Integer.toString(total_question)))) {
			System.out.println("correct words count is matched with the Correct count dispalyed in the Summary header");
			safeClick(CONTINUE_BTN);
		} else {
			System.out.println("count not matching");
		}
	}

}

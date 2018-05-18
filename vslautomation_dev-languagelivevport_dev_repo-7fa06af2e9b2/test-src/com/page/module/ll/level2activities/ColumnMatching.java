package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.ColumnMatchingLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;

public class ColumnMatching extends CommonFunctionalities implements ColumnMatchingLocators {

	private WebDriver driver;
	private int correctcount;
	private int incorrectcount;
	private LLData llData = new LLData();

	public ColumnMatching(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifycolumnMatchingActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(COLUMN_MATCHING_CONTAINER),
				"ColumnMatching activity is not being dispalyed");
	}

	/**
	 * Purpose is complete the column matching activity
	 */
	public void rcColumnMatching() {

		List<WebElement> left_Column_Count = LocatorWebElements(LEFT_COLUMN_COUNT);
		System.out.println("Left coulumn count:" + left_Column_Count.size());

		List<WebElement> right_Column_Count = LocatorWebElements(RIGHT_COLUMN_COUNT);
		System.out.println("Right coulumn count:" + right_Column_Count.size());

		String str1[] = { llData.columnMatchingleftTile1, llData.columnMatchingleftTile2,
				llData.columnMatchingleftTile3, llData.columnMatchingleftTile4, llData.columnMatchingleftTile5,
				llData.columnMatchingleftTile6 };

		String str2[] = { llData.columnMatchingrightTile1, llData.columnMatchingrightTile2,
				llData.columnMatchingrightTile3, llData.columnMatchingrightTile4, llData.columnMatchingrightTile5,
				llData.columnMatchingrightTile6 };

		for (int i = 0; i < left_Column_Count.size(); i++) {

			safeClick(Dynamic.getNewLocator(LEFT_COLUMN_TILES, str1[i]), LONGWAIT);
			safeClick(Dynamic.getNewLocator(RIGHT_COLUMN_TILES, str2[i]), LONGWAIT);

			if (isElementPresent(CORRECT_MATCH)) {
				correctcount++;
				waitUntilElementDisappears(CORRECT_MATCH);
			} else {
				incorrectcount++;
				waitUntilElementDisappears(INCORRECT_MATCH);
			}

			Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(RESULTS_COLUMN, str1[i])),
					"ColumnMatching activity results is not being dispalyed");
		}
		System.out.println("incorrect answers count" + incorrectcount);
		System.out.println("correct answers count" + correctcount);

	}

	/**
	 * Purpose is to verify the summary page of the column matching activity
	 */
	public void columnMatchingSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER),
				"ColumnMatching activity summary page is not being dispalyed");
		List<WebElement> summarycorrect_Count = LocatorWebElements(SUMMARY_CORRECT_COUNT);
		System.out.println("summary correct Count:" + summarycorrect_Count.size());

		List<WebElement> summaryincorrect_Count = LocatorWebElements(SUMMARY_INCORRECT_COUNT);
		System.out.println("summary incorrect Count:" + summaryincorrect_Count.size());

		if (correctcount == summarycorrect_Count.size() && incorrectcount == summaryincorrect_Count.size()) {
			safeClick(SUMMARY_CONTINUE_BTN);
		}
	}
}

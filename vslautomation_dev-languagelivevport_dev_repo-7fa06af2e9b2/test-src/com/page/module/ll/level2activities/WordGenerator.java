package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.page.locators.ll.level2activities.WordGeneratorLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;

public class WordGenerator extends CommonFunctionalities implements WordGeneratorLocators {

	private WebDriver driver;
	private LLData llData = new LLData();

	public WordGenerator(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifyWordGeneratorActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(WORD_GENERATOR_QUES_CONTAINER),
				"Word Generator activity is not being displayed");
	}

	/**
	 * Purpose is t complete the Word Generator activity
	 */
	public void rcWordGenerator() {
		String str1[] = { llData.wordGeneratorTile1, llData.wordGeneratorTile3, llData.wordGeneratorTile5,
				llData.wordGeneratorTile7, llData.wordGeneratorTile9 };

		String str2[] = { llData.wordGeneratorTile2, llData.wordGeneratorTile4, llData.wordGeneratorTile6,
				llData.wordGeneratorTile8, llData.wordGeneratorTile10 };

		String str3 = llData.wordGeneratorTile11;

		for (int i = 0; i < 5; i++) {
			safeClick(Dynamic.getNewLocator(WORD_TILE, str1[i]));
			safeClick(Dynamic.getNewLocator(WORD_TILE, str2[i]));
			if (i == 4) {
				safeClick(Dynamic.getNewLocator(WORD_TILE, str3));
			}
			safeClick(CHECK_IT_BTN);
			Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(WORD_TILE, str1[i])),
					"Word pair are not being displayed under Word Bank in Word Generator activity");
			waitUntilElementDisappears(MERGED_ANSWER_CONTAINER, LONGWAIT);
		}
	}

	/**
	 * Purpose is to verify the summary page of the Word Generator activity
	 */
	public void wordGeneratorSummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_HEADER),
				"Word Generator activity summary page is not being displayed");
		Assert.assertTrue(isElementPresent(SUMMARY_CONTENT),
				"Word Generator activity summary page CONTENT is not being displayed");
		safeClick(SUMMARY_CONTINUE_BTN);
	}
}

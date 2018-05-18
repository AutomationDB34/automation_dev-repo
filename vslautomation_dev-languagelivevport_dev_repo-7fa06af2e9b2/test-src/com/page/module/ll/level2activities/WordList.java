package com.page.module.ll.level2activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level2activities.WordListLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class WordList extends CommonFunctionalities implements WordListLocators {

	private WebDriver driver;

	public WordList(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * purpose is to verify whether the word lidt is loaded or not
	 */
	public void verifyWordList() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(WORD_LIST_HEADER), "Word list header is not being displayed");
		Assert.assertTrue(isElementPresent(WORD_LIST_CONTAINER), "Word list content is not being displayed");
	}

	/**
	 * Purpose is to click the continue button in the word list page
	 */
	public void clickContinuebtn() {
		safeClick(CONTINE_BTN);
	}
}

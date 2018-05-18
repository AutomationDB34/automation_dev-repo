package com.page.module.ll.level2activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level2activities.WordRadiatorLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.testng.Assert;

public class WordRadiator extends CommonFunctionalities implements WordRadiatorLocators {

	private WebDriver driver;

	public WordRadiator(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether activity is loaded or not
	 */
	public void verifyWordRadiatorActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(WORD_RADIATOR_HUB), "Word Radiator activity is not being displayed");
	}

	/**
	 * Purpose is to complete the word radiator activity 
	 
	 */
	public void rcWordRadiator()  {
		for (int i = 1; i <= 10; i++) {
			String str = Integer.toString(i);
			if (isElementPresent(Dynamic.getNewLocator(WORDRADIATOR_WORDS, str))) {
				safeClick(Dynamic.getNewLocator(WORDRADIATOR_WORDS, str));
				Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(CORRECT_ANSWER_DISPALYED, str)),
						"Word Radiator activity correct answer is not being displayed");
			}
			waitForSecs(3);
		}
	}
}

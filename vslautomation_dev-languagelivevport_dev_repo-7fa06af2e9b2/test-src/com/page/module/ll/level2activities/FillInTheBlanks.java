package com.page.module.ll.level2activities;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level2activities.FillInTheBlanksLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;

public class FillInTheBlanks extends CommonFunctionalities implements FillInTheBlanksLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public FillInTheBlanks(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to complete the fill in the blanks activity
	 * 
	 * @throws InterruptedException
	 */
	public void fillinTheBlanks(){

		closeInstIcon();

		List<WebElement> fillInTheBlanksCount = LocatorWebElements(ANSWER_BLANKS);
		log.info("fill In The Blanks Count:" + fillInTheBlanksCount.size());

		for (int bundles = 1; bundles <= fillInTheBlanksCount.size(); bundles++) {
			safeClick(ANSWER_TILE);
			if (isElementPresent(Dynamic.getNewLocator(COMPLETE_TILE, Integer.toString(bundles)))) {
				log.info("incorrect answer is selected");
				waitUntilElementDisappears(Dynamic.getNewLocator(COMPLETE_TILE, Integer.toString(bundles)));
			} else {
				log.info("correct answer is selected");
			}
		}
	}
}

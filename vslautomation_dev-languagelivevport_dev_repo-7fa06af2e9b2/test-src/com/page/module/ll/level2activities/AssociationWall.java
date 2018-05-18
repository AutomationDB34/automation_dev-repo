package com.page.module.ll.level2activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.page.locators.ll.level2activities.AssociationWallLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;

public class AssociationWall extends CommonFunctionalities implements AssociationWallLocators {

	private WebDriver driver;
	private int correctcount;
	private int incorrectcount;

	public AssociationWall(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether the activity is loaded or not
	 */
	public void verifyassociationWallActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementPresent(QUES_CONTAINER), "Association wall activity is not being dispalyed");
	}

	/**
	 * Purpose is to complete all the bundles of association wall activity
	 * 
	 
	 */

	public void rcAssociationWall(){

		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("bundle count:" + bundlecount.size());
		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

			safeClick(ANSWER_TILE_1);
			if (isElementPresent(INCORRECT_ANSWER)) {
				incorrectcount++;
				waitUntilElementDisappears(INCORRECT_ANSWER);
				safeClick(ANSWER_TILE_2);
				waitForSecs(2);
			} else {
				correctcount++;
				waitUntilElementDisappears(CORRECT_ANSWER);
			}
		}
		System.out.println("incorrect answers count" + incorrectcount);
		System.out.println("correct answers count" + correctcount);
	}

	/**
	 * Purpose is to verify the summary page of the association wall activity
	 */
	public void associationWallSummary() {

		Assert.assertTrue(isElementPresent(SUMMARY_HEADER),
				"Association wall activity summary page is not being dispalyed");
		Assert.assertTrue(isElementPresent(SUMMARY_CONTENT),
				"Association wall activity summary page comtent is not being dispalyed");
		safeClick(SUMMARY_CONTINUE_BTN);
	}
}

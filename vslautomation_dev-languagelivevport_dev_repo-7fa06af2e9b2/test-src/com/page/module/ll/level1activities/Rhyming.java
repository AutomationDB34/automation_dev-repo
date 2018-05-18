package com.page.module.ll.level1activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.page.locators.ll.level1activites.RhymingLocators;
import com.selenium.Dynamic;
import com.testng.Assert;

public class Rhyming extends CommonFunctionalities implements RhymingLocators {

	private WebDriver driver;
	private LLData llData = new LLData();

	public Rhyming(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of this method is to verify whether rhyming activity is loaded or
	 * not
	 */
	public void verifyRhymingActivity() {

		Assert.assertTrue(isElementPresent(LEFT_CONTAINER, LONGWAIT),
				"Rhyming activity is not being displayed on page");
	}

	/**
	 * Purpose of this method is to verify rhyming activity functionality
	 */
	public void rhyming(boolean isIE){
		closeInstIcon();

		String leftcontainer[] = { llData.RhyminTile1, llData.RhyminTile3, llData.RhyminTile5, llData.RhyminTile7,
				llData.RhyminTile9 };
		String rightcontainer[] = { llData.RhyminTile2, llData.RhyminTile4, llData.RhyminTile6, llData.RhyminTile8,
				llData.RhyminTile10 };

		for (int i = 0; i < 5; i++) {

			By str1 = Dynamic.getNewLocator(ANSWER, "'" + leftcontainer[i] + "'");
			System.out.println(str1);

			By str2 = Dynamic.getNewLocator(ANSWER, "'" + rightcontainer[i] + "'");
			System.out.println(str2);

			if (isIE) {
				safeClickUsingSikuli(llData.rhymingLeftContainerImage,
						"Left container section of the Rhyming activity using sikuli", LONGWAIT);
			}
			dragAndDrop(str1, LEFT_DISABLED_CONTAINER, LONGWAIT);
			Assert.assertTrue(isElementDisplayed(LEFT_CONTAINER),
					"Rhyming activity Left container is not in disabled state");
			waitForSecs(2);
			if (isIE) {
				safeClickUsingSikuli(llData.rhymingRightContainerImage,
						"Right container section of the rhyming activity using sikuli", LONGWAIT);
			}
			dragAndDrop(str2, RIGHT_CONTAINER, LONGWAIT);

			Assert.assertTrue(isElementPresent(CORRECT_MATCH),
					"Rhyming activity correct match music note is not being displayed on page");
			waitUntilElementDisappears(CORRECT_MATCH);
			// Thread.sleep(5000);

		}
	}

	/**
	 * Purpose of this method is to click next button and navigate to the
	 * summary page
	 */
	public void clickNextBtn() {

		safeClick(NEXT_BTN, LONGWAIT);
	}

	/**
	 * Purpose of this method is to verify summary page of the activity
	 */
	public void activitySummary() {
		Assert.assertTrue(isElementPresent(SUMMARY_PAGE, LONGWAIT),
				"Rhyming activity Summary page is not being displayed on Home page");

		isElementClickable(SUMMARY_CONTINUE_BTN);
		safeClick(SUMMARY_CONTINUE_BTN);

	}
}

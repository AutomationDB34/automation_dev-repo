package com.page.module.ll.level2activities;

import java.awt.AWTException;
import java.util.List;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level2activities.VowelCorrespondenceLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.testng.Assert;

public class VowelCorrespondence extends CommonFunctionalities implements VowelCorrespondenceLocators {

	private WebDriver driver;

	public VowelCorrespondence(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose is to verify whether Vowel Correspondence the activity is loaded
	 * or not
	 */
	public void verifyVowelCorrespondenceActivity() {

		closeInstIcon();
		Assert.assertTrue(isElementPresent(AUDIO_BAR), "VowelCorrespondence activity not being displayed");

	}

	/**
	 * Purpose is to verify the audio bar functionality
	 */
	public void verifyAudioFunctionality() {
		safeClick(AUDIO_BAR);
		Assert.assertTrue(isElementPresent(AUDIO_ENABLED), "VowelCorrespondence activity audio is not being played");

	}

	/**
	 * purpose is to complete the Vowel Correspondence activity for all bundles
	 * 
	 * @param isIE
	 * @throws AWTException
	 */
	public void vowelCorrespondence(boolean isIE) {

		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {

			waitUntilClickable(AUDIO_BAR);
			String tile_text = safeGetText(DRAGGABLE_TILE, LONGWAIT);
			System.out.println(tile_text);

			String substr = tile_text.substring(1, 2);
			System.out.println(substr);

			switch (substr) 
			{
			case "a":
				dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_AREA_A, LONGWAIT, isIE);
				break;
			case "e":
				dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_AREA_E, LONGWAIT, isIE);
				break;
			case "i":
				dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_AREA_I, LONGWAIT, isIE);
				break;
			case "o":
				dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_AREA_O, LONGWAIT, isIE);
				break;
			case "u":
				dragAndDropwithRobots(DRAGGABLE_TILE, DRAGGABLE_AREA_U, LONGWAIT, isIE);
				break;

			}
		}
	}
}

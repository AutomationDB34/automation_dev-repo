package com.page.module.ll.level1activities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.level1activites.IdentifyWordEndingsLocators;
import com.testng.Assert;

public class IdentifyWordEndings extends CommonFunctionalities implements IdentifyWordEndingsLocators {

	private WebDriver driver;

	public IdentifyWordEndings(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose of the method is to verify whether the activity is loaded or not
	 */
	public void verifyIdentifyWordEndingsActivity() {
		closeInstIcon();
		Assert.assertTrue(isElementDisplayed(WORDENDING_CONTAINER),
				"Identify Word Endings Activity is not being displayed");
	}

	/**
	 * Purpose of the method is to test all the bundles of the activity
	 * */
	public void identifyWordEndings(){
		
		// get the bundle count of the activity
		List<WebElement> bundlecount = LocatorWebElements(BUNDLE_COUNT);
		
		System.out.println("Bundle count:" + bundlecount.size());

		for (int bundles = 1; bundles <= bundlecount.size(); bundles++) {
		
		safeClick(RADIO_BTN_1);	
		
		Assert.assertTrue(isElementPresent(SOUND_LABEL), "Sound label after answering the bundle is not being displayed");

		String radiobtn = safeGetAttribute(RADIO_BTN_2, "disabled", LONGWAIT);
		
		System.out.println(radiobtn);
		
		if(radiobtn.equals("true")){
			
			System.out.println("The other opiton is disabled");
		}
		
		waitUntilElementDisappears(TICK_MARK);
		
	}
	
}

	/**
	 * Purpose of the method is to test one bundle of the activity
	 */
	public void qcidentifyWordEndings() {

		safeClick(RADIO_BTN_1);

		Assert.assertTrue(isElementPresent(SOUND_LABEL),
				"Sound label after answering the bundle is not being displayed");

		String radiobtn = safeGetAttribute(RADIO_BTN_2, "disabled", LONGWAIT);

		System.out.println(radiobtn);

		if (radiobtn.equals("true")) {

			System.out.println("The other opiton is disabled");
		}

		waitUntilElementDisappears(TICK_MARK);
	}
}

package com.page.module.vport;


import org.openqa.selenium.WebDriver;

import com.page.locators.vport.MyDistrictLocators;
import com.selenium.SafeActions;
import com.testng.Assert;


public class MyDistrictPage extends CommonFunctionalitiesVPort implements MyDistrictLocators {

	private WebDriver driver;

	public MyDistrictPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*  
	 * Purpose of this method is to check whether the My District page is loaded or not
	 * */
	public void verifyMyDistrictPage() {

		boolean myDistrictExists = isElementPresent(MY_DISTRICT_PAGE, MEDIUMWAIT);
		Assert.assertTrue(myDistrictExists,
				"My district page is not displayed after completing orientation setup page ");

	}

	/*  
	 * Purpose of this method is to check whether the school is activated or not
	 *  and activate school of not activated
	 * */
	public void activateSchool() {

		safeClick(SCHOOL_TAB, LONGWAIT);

		boolean schooltabExists = isElementPresent(SCHOOL_PAGE, LONGWAIT);
		Assert.assertTrue(schooltabExists, "school tab is not displayed after completing orientation setup page ");

		safeCheck(SCHOOL_CHECKBOX, MEDIUMWAIT);

	}

}

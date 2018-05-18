package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.DistrictAdminPrivacyLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictAdminPrivacyPage extends SafeActions implements DistrictAdminPrivacyLocators {
	
	
	private WebDriver driver;

	public DistrictAdminPrivacyPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/*  
	 * Purpose of this method is to check whether the District Admin privacy page are loaded or not
	 * */
	public void verifyPrivacyPage(){
		
		boolean privacyPageExists = isElementPresent(NAME_FIELD,MEDIUMWAIT);
		Assert.assertTrue(privacyPageExists,"Privacy page is not displayed in the orientation setup page ");	
		
	}
	

	/*  
	 * Purpose of this method is to enter the required details in the privacy agreement page
	 * */
	public void acceptPrivacy(String name , String title){
		
		safeType(NAME_FIELD, name, MEDIUMWAIT);
		safeType(TITLE_FIELD, title, MEDIUMWAIT);
	}

	
	/*  
	 * Purpose of this method is to accept in the privacy agreement 
	 * */
	public DistrictAdminWelcomePage clickAcceptBtn(){
	safeClick(ACCEPT_BTN , LONGWAIT);
	return new DistrictAdminWelcomePage(driver);
		
	}

}

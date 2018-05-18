package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.DistrictAdminWelcome;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictAdminWelcomePage extends SafeActions implements DistrictAdminWelcome{

	private WebDriver driver;
	
	public DistrictAdminWelcomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/*  
	 * Purpose of this method is to check whether the District Admin Welcome page are loaded or not
	 * */
	public void verifAdminWelcomePage(){
		boolean eMailIDExists = isElementPresent(EMAIL_ADDRESS,MEDIUMWAIT);
		Assert.assertTrue(eMailIDExists,"Email Address fields not dispalyed in the Admin welcome page");	
		
	}
	
	/*  
	 * Purpose of this method is to check whether the District Admin profile page are loaded or not
	 * and provide the required detials
	 * */
	public DistrictAdminOrientationPage profileInformation(String email , String training_option){
		
		safeType(EMAIL_ADDRESS, email, LONGWAIT);
		safeSelectOptionInDropDownByVisibleText(TRAINING_OPTIONS, training_option, LONGWAIT);
		safeCheck(TOU_CHECKBOX, LONGWAIT);
		safeClick(OK_BTN);
		return new DistrictAdminOrientationPage(driver);
	}

}

package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.TeacherLoginScenariosLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherLoginScenarios extends SafeActions implements TeacherLoginScenariosLocators{
	WebDriver driver;
	
	
	public TeacherLoginScenarios(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void loginIntoAppication(String loginid){
		safeType(USERNAME, loginid, MEDIUMWAIT);
		safeType(PASSWORD, loginid, MEDIUMWAIT);
		safeClick(LOGIN_BTN, MEDIUMWAIT);		
	}

	public void verifyLogin(String verificationURL) {
		if(isElementDisplayed(LOGIN_ERROR_POPUP)){
		System.out.println("Teacher user is unable to Login into the application");
		}
		else{
			String URL = getCurrentURL();
			Assert.assertEquals(URL, verificationURL,"URL is not as expected");		
		}		
	}
}

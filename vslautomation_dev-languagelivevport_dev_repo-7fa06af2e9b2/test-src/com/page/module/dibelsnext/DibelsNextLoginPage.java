package com.page.module.dibelsnext;

import org.openqa.selenium.WebDriver;

import com.datamanager.ConfigManager;
import com.page.locators.dibelsnext.DibelsNextLoginLocators;
import com.page.module.vport.VportLoginPage.ReturnPage;
import com.selenium.SafeActions;
import com.selenium.Sync;
import com.testng.Assert;

public class DibelsNextLoginPage extends SafeActions implements DibelsNextLoginLocators{
private WebDriver driver;
	
	ConfigManager app;
	
	Sync sync;
	
	//constructor to define or call methods
	public DibelsNextLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;			
	}
	
	
	/**
	 * Purpose- To verify whether DIBELS NEXT login page is being displayed or not
	 * @throws Exception
	 */	
	public void verifyLoginPage()
	{
		boolean uNameSignInButtonExists = isElementPresent(USERNAME_FIELD,MEDIUMWAIT);
		Assert.assertTrue(uNameSignInButtonExists,"User Name button is not being displayed on Login page");	
	}
	
	/**
	 * Purpose- To enter login credentilas i.e., username and password 
	 * @param vportUsername- we pass username of DIBELS NEXT application
	 * @param vportPassword- we pass passowrd of DIBELS NEXT application
	 * @throws Exception
	 */
	public void enterLoginCredentials(String vportUsername, String vportPassword)
	{
	safeClearAndType(USERNAME_FIELD ,vportUsername, SHORTWAIT);
	safeClearAndType(PASSWORD_FIELD ,vportPassword, SHORTWAIT);	
	}
	
	/**
	 * Purpose- To click on Login In button
	 *
	 */
	public StudentCenterPage clickSignInButton()
	{
	safeClick(LOGIN_BTN);
	waitForPageToLoad(LONGWAIT);
	return new StudentCenterPage(driver);
}


}

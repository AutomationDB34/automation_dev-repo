package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.VportLogoutLocators;
import com.selenium.SafeActions;

public class VportLogoutPage extends SafeActions implements VportLogoutLocators {

	private WebDriver driver;
	
	public VportLogoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
	}

	public void clickLogOut()
	{
		safeClick(LOGOUT_LINK, MEDIUMWAIT);
	}
	
	
}

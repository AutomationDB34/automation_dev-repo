package com.page.module.ll.level1activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level1activites.LLLogoutLocators;
import com.selenium.SafeActions;

public class LLLogout extends CommonFunctionalities implements LLLogoutLocators {

	private WebDriver driver;
	public LLLogout(WebDriver driver) {
		super(driver);
		this.driver = driver;	
	}
	
	
}
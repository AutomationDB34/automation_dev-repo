
package com.page.locators.vport;

import org.openqa.selenium.By;

public interface CommonVPortLocators {

	//LogOut locators
	By LOGOUT_LINK = By.linkText("Log Out");
	
	//Login Locators
	By USERNAME_FIELD = By.id("j_username");
	By PASSWORD_FIELD = By.id("j_password");
	By LOGIN_BTN = By.className("loginBtn");
	
	//District Page
	By MY_DISTRICT = By.xpath(".//a/div[contains(.,'My District')]");
	
	
}

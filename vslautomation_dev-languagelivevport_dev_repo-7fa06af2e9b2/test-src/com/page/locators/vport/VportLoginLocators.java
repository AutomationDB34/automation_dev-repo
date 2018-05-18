package com.page.locators.vport;

import org.openqa.selenium.By;

public interface VportLoginLocators {
	
	/*By USERNAME_FIELD = By.id("j_username");
	By PASSWORD_FIELD = By.id("j_password");
	By LOGIN_BTN = By.className("loginBtn");	*/
	//login page all links 
		By REQUIREMENTS_WRAPPER = By.xpath(".//div[@id='requirementsWrapper']");
		By SUPPORT_WRAPPER = By.xpath(".//div[@id='supportWrapper']");
		By FB_WRAPPER = By.xpath(".//div[@id='fbWrapper']");
		By FOOTER_TITLES = By.xpath(".//span[@class='footerTitle']");
		By LOGIN_LOGO = By.id("loginLogo");
		By VSL_LOGO = By.className("camVoyLogo");
		
		//Forget Password Link and page
		By FORGET_PASSWORD_LINK = By.linkText("Forgot User ID or Password?");
		By FORGET_PASSWORD_USERNAME=By.name("username");
		By FORGET_PASSWORD_RETRIEVEPASSWORD_BTN=By.name("retrieve_password");
		By FORGET_PASSWORD_EMAILE=By.name("email");
		By FORGET_PASSWORD_RETRIEVEUSER_ID_BTN=By.name("retrieve_id");
		By FORGET_PASSWORD_BACKTO_HOMEPAGE_LINK = By.linkText("Back to Home Page");
		
		//System Check
		By SYSTEM_CHECK_LINK = By.id("bc");
		By SYSTEM_CHECK_LIST_PASS = By.id(".//img[contains(.,'bc-pass.gif')]");
		
		By LEARN_MORE = By.linkText("Learn more");
}

package com.page.locators.vport;

import org.openqa.selenium.By;

public interface TeacherLoginScenariosLocators {
	
	public static By USERNAME = By.xpath("//input[@id = 'j_username']");
	public static By PASSWORD = By.xpath("//input[@id = 'j_password']");
	public static By LOGIN_BTN = By.xpath("//a[@class='loginBtn']");
	public static By LOGIN_ERROR_POPUP = By.xpath("//div[@id='loginErrorPopup']");
	//public static By PAGEAFTER_SUCCESSFUL_LOGIN = By.id("choose");
			public static By PAGEAFTER_SUCCESSFUL_LOGIN = By.xpath("//*[@id='choose']");

			

}

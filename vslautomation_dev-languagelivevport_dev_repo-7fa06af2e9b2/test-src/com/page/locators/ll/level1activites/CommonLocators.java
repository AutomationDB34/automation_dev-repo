package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface CommonLocators {

	By INSTRUCTION_ICON = By.xpath("//button[contains(@class,'Cambium.LanguageLive.UI.InstructionsMenu.IButton')]");
	By INST_CLOSE = By.xpath("//img[@class='Cambium.LanguageLive.UI.InstructionsMenu.closerX']");
	By MICRO_PHONE_POP = By.className("Cambium.LanguageLive.UI.EstablishMicrophoneModal.instructions");
	By TRY_AGAIN_BUTTON_POPUP = By.xpath("//div[contains(text(), 'We could not detect your microphone.')]");
	By TRY_AGAIN_BUTTON = By.xpath("//button[contains(text(),'Try Again')]");
	By TRY_AGAIN_LINK_POPUP = By.xpath("//div[contains(text(), 'Please ask your teacher for help.')]");
	By TRY_AGAIN_LINK = By.xpath("//button[contains(@class,'Cambium.LanguageLive.UI.EstablishMicrophoneModal.tryAgain')]");
	By ACTIVITY_USER_DROP_DOWN = By.xpath("//span[@class='Cambium.Image.LL']");
	By HOME_LINK= By.xpath("//td[@value='home']/span");
	
	//Login Locators
	By USERNAME_FIELD = By.id("Cambium.App.Login.Entry.3.j_username");
	By PASSWORD_FIELD = By.id("Cambium.App.Login.Entry.3.j_password");
	By LOGIN_BTN = By.xpath("//input[@value='Log In!']");
	By WELCOME_CONTINUE_BTN = By.className("Cambium.App.Welcome.Summary.continue");
	
	//LogOut 
	By USER_DROPDOWN = By.xpath("//td[@class='Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrowCol']/span");
	By LOGOUT_LINK = By.xpath("//td[contains(@value,'logout')]");
	//Locators for the Logout from the Activity or word training page
	By COURSE_DROPDOWN = By.xpath("//td[contains(@class , 'Cambium.LanguageLive.UI.CourseMenu.item')]");
	
}

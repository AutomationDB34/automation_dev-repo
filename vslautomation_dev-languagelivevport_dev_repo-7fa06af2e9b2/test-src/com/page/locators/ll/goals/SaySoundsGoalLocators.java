package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface SaySoundsGoalLocators {
	
	By SAYSOUNDSVIDEOWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");
	By GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");
	
	//Locators for READY TO PREVIEW HEADING TEXT WINDOW
	By READYTO_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
	By READYTOPREVIEWWINDOWSTART_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

	
	//Practice answers
	By ANSWER_LETTER = By.xpath("//div[@class='Cambium.UI.LetterBox.dragger']");
	By PROGRESS_STEP_COUNT= By.xpath("//div[contains(@class,'progressDotRed')]");
	
	By CONTINUE_BUTTON = By.xpath(".//button[contains(text(),'Continue')]");
	By START_BTN_ONREVEW_READY =  By.xpath(".//button[contains(text(),'Start')]");
	By NEXT_BTN =  By.xpath(".//button[contains(text(),'Next')]");
	By START_BTN =  By.xpath(".//button[contains(text(),'Start')]");
	By RECORD_LETTER_COUNT = By.xpath(".//font[contains(text(),'20']");
	By THUMBS_UP_BTN = By.xpath(".//button[contains(@class,'GatewayThumbsButton.up')]");
	By THUMBS_DOWN_BTN = By.xpath(".//button[contains(@class,'GatewayThumbsButton.down')]");
	By RETAKETEST_BUTTON = By.xpath(".//button[contains(text(),'Retake Test')]");
}

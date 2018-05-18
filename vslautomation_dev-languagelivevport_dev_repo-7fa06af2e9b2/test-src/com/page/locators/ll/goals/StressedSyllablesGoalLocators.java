package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface StressedSyllablesGoalLocators {
	
	
	By SAYSOUNDSVIDEOWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");
	By GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");
	
	//Locators for READY TO PREVIEW HEADING TEXT WINDOW
	By READYTO_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
	By READYTOPREVIEWWINDOWSTART_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

	
	//Practice answers
	By ANSWER_LETTER = By.xpath("//div[@class='Cambium.UI.LetterBox.dragger']");
	By PROGRESS_STEP_COUNT= By.xpath("//div[contains(@class,'progressDotRed')]");
	
	By REVIEW_CONTINUE = By.xpath(".//button[contains(text(),'Continue')]");
	By CONTINUE_BUTTON = By.xpath(".//button[contains(@class,'cambium_ui_action_button')]");
	By RETAKETEST_BUTTON = By.xpath(".//button[contains(text(),'Retake Test')]");
	By START_BTN_ONREVEW_READY =  By.xpath(".//button[contains(text(),'Start')]");
	By REVIEW_NEXT_BTN =  By.xpath(".//button[contains(@class,'Cambium.UI.ActionButton.navigation cambium_ui_action_button')]");
	By START_BTN =  By.xpath(".//button[contains(text(),'Start')]");
	By RECORD_LETTER_COUNT = By.xpath(".//font[contains(text(),'20']");
	By THUMBS_UP_BTN = By.xpath(".//button[contains(@class,'GatewayThumbsButton.up')]");
	By THUMBS_DOWN_BTN = By.xpath(".//button[contains(@class,'GatewayThumbsButton.down')]");
	
	
	//Audio of the Options
	By OPTION1_AUDIO = By.xpath(".//button[contains(@class,'distracter0')]");
	By OPTION2_AUDIO = By.xpath(".//button[contains(@class,'distracter1')]");
	
	//Answer Radio button
	By ANSEWR_RADIO_BUTTON = By.xpath(".//button[contains(@class,'RadioButton')]");
	
	//Words and Space to drop at revew
	By WORD_DISPLAYED_IN_BOX = By.xpath("//span[contains(@class,'Cambium.Bundles.Sorting.SortByFunction.word')]/span[@class='Cambium.UI.Draggable2.dragger']");//By.xpath(".//span[contains(@class,'dragger')]");
	By NOUN_SPACE = By.xpath("//td[@class='Cambium.Bundles.Sorting.SortByFunction.details'][1]//td[1]");
			

}

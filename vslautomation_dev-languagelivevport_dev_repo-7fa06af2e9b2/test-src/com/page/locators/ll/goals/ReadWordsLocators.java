package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface ReadWordsLocators {

	
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
	By NEXT_BTN =  By.xpath(".//button[contains(@class,'Cambium.UI.ActionButton.navigation cambium_ui_action_button')]");
	By START_BTN =  By.xpath(".//button[contains(text(),'Start')]");
	By RECORD_LETTER_COUNT = By.xpath(".//font[contains(text(),'20']");
	By THUMBS_UP_BTN = By.xpath(".//button[contains(@class,'GatewayThumbsButton.up')]");
	By THUMBS_DOWN_BTN = By.xpath(".//button[contains(@class,'GatewayThumbsButton.down')]");
	By RETAKETEST_BUTTON = By.xpath(".//button[contains(text(),'Retake Test')]");
	
	By LETTERS_INWORD = By.xpath(".//li");
	By LATTERGRID = By.xpath(".//li[%s]/div/div[1]");
	
	//Remediation Draggable Grid
	By DRAGGABLE_LETTER_GRID = By.xpath(".//div[contains(@class,'Cambium.Bundles.Stretching.boxesContainer')]/div/div");
	By DROP_AREA = By.xpath(".//div[contains(@class,'Cambium.Bundles.Stretching.contentContainer')]");
	By CHECK_IT = By.xpath(".//button[contains(text(),'Check It')]");
	//By DROPPABLE_LETTER_COUNT = By.xpath(".//li");
	By CONSONANT_TILE = By.xpath("//div[@class='Cambium.UI.Draggable.dragger'][contains(.,'c')]");
	By VOWEL_TILE = By.xpath("//div[@class='Cambium.UI.Draggable.dragger'][contains(.,'v')]");
	By LATTER_DROP = By.xpath(".//li[%s]/div/div[2]");
	By LATTER_DROPPED_TEXT = By.xpath("//li[%s]/div/div[2][contains(@class,'LetterBox')]");
	
	//In Step3
	By LETTERS_IN_STEP3 = By.xpath(".//div[@class='Cambium.Bundles.Stretching.choicesContainer']/div");
	By RANDOM_LETTER_IN_STEP3 = By.xpath(".//div[@class='Cambium.Bundles.Stretching.choicesContainer']/div[%s]/div/span[1]");
	
}

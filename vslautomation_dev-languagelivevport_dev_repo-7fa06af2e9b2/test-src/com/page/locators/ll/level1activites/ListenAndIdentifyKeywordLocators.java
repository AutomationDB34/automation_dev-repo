package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface ListenAndIdentifyKeywordLocators {
	
	By LISTEN_AND_IDENTIFY_CONTAINER = By.xpath("//div[@class='Cambium.Bundles.ListenAndIdentifyKeyword.letterContainer']/span");
	By KEYWORD_TILES = By.xpath("//img[@class='Cambium.UI.LetterBox.img']");
	
	By ANSWER_TILE = By.xpath("//img[contains(@class,'Cambium.UI.LetterBox.img')][contains(@src,'KW.%s')]");
	
	By BUNDLE_COUNT = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.progressDot Cambium.UI.StepBubbleBar.smallDot']");	
	By CORRECT_MARK = By.xpath("//img[contains(@class,'Cambium.UI.LetterBox.img')][contains(@src,'KW.%s')]/div/div[contains(@class,'cambium_ui_state_box Cambium.UI.StateBox.right')]");
	
}

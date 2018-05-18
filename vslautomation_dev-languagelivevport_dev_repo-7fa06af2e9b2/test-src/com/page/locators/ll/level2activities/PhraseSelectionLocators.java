package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface PhraseSelectionLocators {
	By PHRASE_SELECTION_CONTAINER = By.xpath("//div[@class='Cambium.Bundles.PhraseSelection.sentenceContainer']/div");

	By PHRASE_SELECTION_OPTION = By
			.xpath("//div[@class='Cambium.Bundles.PhraseSelection.buttonsContainer']/div/div[@data-index='1']");

	By INCORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.UI.Draggable2.incorrect')]");
	By CORRECT_ANSWER = By.xpath("//div[contains(@class,'Cambium.UI.Draggable2.correct')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");

	// summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Phrase Selection')]");
	By SUMMARY_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}

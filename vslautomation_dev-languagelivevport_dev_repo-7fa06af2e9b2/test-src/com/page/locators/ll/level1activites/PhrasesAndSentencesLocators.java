package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface PhrasesAndSentencesLocators {
	
	By STEP_HEADER = By.xpath("//div[contains(@class,'cambium_ui_step_bar')]");
	
	By WORDS = By.xpath("//div[contains(@class,'Cambium.Bundles.PhrasesAndSentences.contentContainer')]/ul/li%s/div/div");
	By RECORD_BTN = By.xpath(" //div[contains(text(),'RECORD IT')]");
	By REVIEW_BTN = By.xpath(" //div[contains(text(),'REVIEW')]");	
	
	By THUMPS_UP = By.xpath("//button[contains(@class, 'Cambium.UI.Buttons.ThumbsButton.up')]");
	
	By BUNDLE_COUNT= By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Read Phrases and Sentences')]");
	By SUMMARY_CORRET_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By SUMMARY_TOTAL_QUESTIONS = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.PhrasesAndSentences.Summary.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.PhrasesAndSentences.Summary.wrong')]");
	
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.PhrasesAndSentences.Summary.continue')]");

}

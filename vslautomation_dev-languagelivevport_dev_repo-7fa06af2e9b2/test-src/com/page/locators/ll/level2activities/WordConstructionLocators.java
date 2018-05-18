package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface WordConstructionLocators {
	
	By RIGHT_DRAGGABLE_AREA = By.xpath("//div[@class='Cambium.Bundles.WordConstruction.answerContainer']//span[contains(@class,'Cambium.UI.Draggable2.right')]");
	By LEFT_DRAGGABLE_AREA = By.xpath("//div[@class='Cambium.Bundles.WordConstruction.answerContainer']//span[contains(@class,'Cambium.UI.Draggable2.left')]");

	By WORDS_IN_LEFT_COLUMN = By.xpath("//span[contains(@class,' Cambium.UI.Draggable2.left')]//span[contains(text(),'%s')]");
	By WORDS_IN_RIGHT_COLUMN = By.xpath("//span[contains(@class,' Cambium.UI.Draggable2.right')]//span[contains(text(),'%s')]");
	
	By WORD_BANK_COUNT = By.xpath("//div[@class='Cambium.Bundles.WordConstruction.shell']");
	
	By TICK_MARK = By.xpath("//span[contains(@class,'Cambium.UI.StateBox.right')]");
	
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	//Summary Locators
	By SUMMARY_HEADER = By.xpath("//td[contains(text(),'Word Construction')]");
	
	By CORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.WordConstruction.Summary.right')]");
	By INCORRECT_ANSWERS = By.xpath("//div[contains(@class,'Cambium.Bundles.WordConstruction.Summary.white')]");
	
	By HEADER_CORRECT_COUNT = By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By HEADER_QUES_COUNT = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
	
}

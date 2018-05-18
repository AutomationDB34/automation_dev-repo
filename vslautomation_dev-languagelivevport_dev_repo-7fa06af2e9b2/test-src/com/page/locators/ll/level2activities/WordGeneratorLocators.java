package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface WordGeneratorLocators {

	By WORD_GENERATOR_QUES_CONTAINER = By.className("Cambium.Bundles.WordGenerator.questionContainer");

	By WORD_TILE = By.xpath("//span[@class='Cambium.UI.Draggable2.txt'][contains(text(),'%s')]");
	By MERGED_ANSWER_CONTAINER = By.xpath("//div[@class='Cambium.Bundles.WordGenerator.answerContainer']/span/span");

	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");

	By WORD_BANK_TILE = By.xpath("//div[@class='Cambium.Bundles.WordGenerator.wordBank']//div[contains(text(),'%s')]");

	By SUMMARY_HEADER = By.xpath("//div[contains(text(),'Word Generator: Results')]");
	By SUMMARY_CONTENT = By
			.xpath("//td[contains(@class,'Cambium.Bundles.WordGenerator.Summary.columnDataContents')]/div/table");

	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

}

package com.page.locators.ll.level2activities;

import org.openqa.selenium.By;

public interface AssociationWallLocators {

	By QUES_CONTAINER = By.className("Cambium.Bundles.AssociationWall.questionContainer");
	By ANSWER_TILE_1 = By.xpath("//table[@class='Cambium.Bundles.AssociationWall.wallContainer']//tr[1]//span[1]/span/span[@class='Cambium.UI.Draggable2.txt']");
	By ANSWER_TILE_2 = By.xpath("//table[@class='Cambium.Bundles.AssociationWall.wallContainer']//tr[1]//span[2]/span/span[@class='Cambium.UI.Draggable2.txt']");
	
	By INCORRECT_ANSWER = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.incorrect')]");
	By CORRECT_ANSWER = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.correct')]");
	
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By SUMMARY_HEADER = By.xpath("//div[contains(text(),'Word Association Wall: Results')]");
	By SUMMARY_CONTENT = By.xpath("//table[@class='Cambium.Bundles.AssociationWall.Summary.dataTable']/tbody/tr");
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
}

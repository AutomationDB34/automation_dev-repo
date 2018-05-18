package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface BlendAndReadLocators {
	
	By BUNDLE_COUNT = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.progressDot Cambium.UI.StepBubbleBar.smallDot']");
	By ACTIVITY_NAME= By.xpath("//div[@class='Cambium.UI.LetterBox.group Cambium.Bundles.BlendAndRead.contentContainer']");
	By LIST_ELEMENTS =By.xpath("//div[@class='Cambium.UI.LetterBox.group Cambium.Bundles.BlendAndRead.contentContainer']/ul/li%s/div");
	By RECORD_BUTTON = By.xpath("//button[@timelimit='3000']");
	By GRADING_BTN = By.xpath("//div[@class='Cambium.Bundles.BlendAndRead.buttonContainer Cambium.Bundles.BlendAndRead.step4 Cambium.Bundles.BlendAndRead.fadeIn']/button[1]");
	By PROGRESS_STEP_COUNT= By.xpath("//div[contains(@class,'progressDotRed')]");
		
	By THUMPS_UP_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndRead.Summary.right')]");
	By THUMPS_DOWN_COUNT = By.xpath("//div[contains(@class,'Cambium.Bundles.BlendAndRead.Summary.wrong')]");
	By CORRECT_COUNT= By.className("Cambium.UI.SummaryHeading.numberCorrect");
	By NUMBER_OF_QUESTIONS = By.className("Cambium.UI.SummaryHeading.numberOfQuestions");
	
	By CONTINUE_SUMMARY = By.xpath("//button[contains(@class,'Cambium.Bundles.BlendAndRead.Summary.continue cambium_ui_action_button')]");

}

package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface SpellWordsGoalLocators {

	By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	By REPLAY_VIDEO_LINK= By.xpath("//div[@class='Cambium.UI.ReplayVideoLink.buttonIcon']");
	By VIDEO_1_CONTINUE_BTN = By
			.xpath("//button[contains(@class,'Cambium.UI.Windows.ModalMovie.closer')][contains(text(),'Continue')]");

	//Spell words test locators
	By READY_TO_START_POPUP = By.xpath("//span[contains(text(),'Ready to start?')]");
	By START_BTN = By.xpath("//button[contains(text(),'Start')]");
	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	By SPELLWORDS_AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.SpellingTest.audio')]");
	By TEXT_AREA = By.xpath("//input[@class='Cambium.UI.LetterBox.input']");
	By CHECK_IT_BTN = By.xpath("//button[contains(text(),'Check It')]");
	
	//Results screen locators
	By RESULTS_SCREEN = By.xpath("//div[contains(text(),'Test Results')]");
	By EFFORT_COUNT = By.xpath("//td[@class='Cambium.CSS.GatewayScoreboardCol']");
	By SCORE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Summary.accuracyContainer']//tbody/tr/td[contains(@class,'Cambium.CSS.GatewayScoreboardCol')][1]");
	
	//Attempt summary screen locators
	By ATTEMPT_SUMMARY = By.xpath("//div[@class='Cambium.Bundles.Gateway.AttemptSummary.Content.Spelling.title'][contains(text(),'Spell Words')]");
	By INCORRECT_COUNT = By.xpath("//td[@class='Cambium.Bundles.Gateway.AttemptSummary.Content.Spelling.grp3']");
	
	//Remediation locators
	By READY_TO_REVIEW_POPUP = By.xpath("//span[contains(text(),'Ready to review?')]");
	By REVIEW_ERRORS_PAGE = By.xpath("//div[@class='Cambium.Bundles.Gateway.ReviewErrors.summaryHead'][contains(text(),'Listen to the words below.')]");
	By INCORRECT_WORDS_COUNT = By.xpath("//div[@class='Cambium.Bundles.Gateway.ReviewErrors.word']");
	By REMEDIATION_AUDIO_BAR = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.SpellingRemediation.audio')]");
	By REMEDIATION_INCORRECT_ATTEMPT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.incorrect')]");
	By REMEDIATION_HINT = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox Cambium.Bundles.Gateway.SpellingRemediation.lb Cambium.Bundles.Gateway.SpellingRemediation.hint')]");
	
	By TRASITION_PAGE = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionTest.content']/div[2]");
	
	By SEND_A_NOTE_LINK = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.sendANote')][contains(text(),'Send A Note')]");
	By RETAKE_TEST_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.retakeTest')][contains(text(),'Retake Test')]");
	
	By AUTOPASS_NOTE = By.xpath("//div[contains(text(),'A note has been sent to your teacher for help. Please move ahead to the next goal.')]");
	
}

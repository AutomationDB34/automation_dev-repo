package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface SentenceCompletionGoalLocators {
	By REPLAY_VIDEO_LINK= By.xpath("//div[@class='Cambium.UI.ReplayVideoLink.buttonIcon']");
	By VIDEO_1_CONTINUE_BTN = By
			.xpath("//button[contains(@class,'Cambium.UI.Windows.ModalMovie.closer')][contains(text(),'Continue')]");

	By READYTO_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");

	By START_BTN = By.xpath("//button[contains(text(),'Start')]");
	By TIME_BAR = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.Test.SentenceCompletion.timerBar')]");
	
	
	By DROPPABLE_AREA = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.Test.SentenceCompletion.answer')]/div[2]");
	By DRAGGABLE_TILE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Test.SentenceCompletion.choicesContainer']/div[1]/div");
	
	By CORRECT_ANSWER_TICK_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.right')]");
	By INCORRECT_ANSWER_CROSS_MARK = By.xpath("//div[contains(@class,'Cambium.UI.StateBox.wrong')]");

	By BUNDLE_COUNT = By.xpath("//div[contains(@class,'Cambium.UI.StepBubbleBar.smallDot')]");
	
	By TEST_RESULTS_SCREEN = By.xpath("//div[@class='Cambium.Bundles.Gateway.Summary.summaryHeadTitle']");
	By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
	By REVIEW_ERROR_PAGE = By.xpath("//div[contains(text(),'Listen to the words below.')]");
	By ERROR_COUNT = By.xpath("//div[@class='Cambium.Bundles.Gateway.ReviewErrors.word']");
	
	By PHRASES_AND_SENTENCES = By.xpath("//div[contains(@class,'Cambium.UI.LetterBox.group')]");
	By RECORD_IT_BTN = By.xpath("//div[contains(text(),'RECORD IT')]");
	By THUMPS_UP_BTN = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.ThumbsButton.up')]");
	By NEXT_BTN = By.xpath("//button[contains(@class,'Cambium.UI.ActionButton.navigation cambium_ui_action_button')]");
	
	By TRASITION_PAGE = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionTest.content']/div[2]");
	
	By SEND_A_NOTE_LINK = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.sendANote')][contains(text(),'Send A Note')]");
	By RETAKE_TEST_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.retakeTest')][contains(text(),'Retake Test')]");
	
	By AUTOPASS_NOTE = By.xpath("//div[contains(text(),'A note has been sent to your teacher for help. Please move ahead to the next goal.')]");
	
	By SENTENCE_CONTAINER = By.xpath("//div[@class='Cambium.UI.LetterBox.group']");
	
	
}

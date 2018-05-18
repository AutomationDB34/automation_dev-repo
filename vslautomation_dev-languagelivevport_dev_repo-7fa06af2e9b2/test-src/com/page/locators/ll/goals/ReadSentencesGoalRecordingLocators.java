package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface ReadSentencesGoalRecordingLocators {

	//Locators for GATE WAY GOALS VIDEO WINDOW 
	By GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");

	//Locators for FLUENCY VIDEO WINDOW
	By PASSGEFLUENCYVIDEOWINDOW_FADEOUT = By.xpath("//div[@class='Cambium.UI.Windows.ModalMovie.replayContainer Cambium.UI.Windows.ModalMovie.fadeOut']");
	By PASSGEFLUENCYVIDEOWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");
	
	//Locators for READY TO START HEADING TEXT WINDOW
	By READYTOSTARTHEADING_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading'][text()='Ready to start?']");
	By START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

	
	//Read sentences locators
	By READSENTENCES_TABLE = By.className("Cambium.Bundles.Gateway.ReadSentence.sentencesTable");
	By READSENTENCES_BUBBLES_LIST = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.dotContainer']//div[@class='Cambium.UI.StepBubbleBar.progressDotRed']");
	By READSENTENCES_LIST = By.xpath("//table[@class='Cambium.Bundles.Gateway.ReadSentence.sentencesTable']//td[contains(@class,'Cambium.Bundles.Gateway.ReadSentence.sentence')]");
	By READSENTENCES_NEXT_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.ReadSentence.next') and contains(@class,'Cambium.UI.ActionButton.navigation')]");
	By READSENTENCES_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.ReadSentence.continue')]");
	
	//Select the correct word to complete the sentences section
	By SELECTTHECORRECTWORD_SENTENCE = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionPractice.caption'][contains(text(),'Select the correct word to')]");
	By CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionPractice.continue')]");
	
	//Fill in the blanks locators
	By FILLINTHEBLANKS_SENTENCE = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.ReadSentencePractice.sentence')]");
	By FILLINTHEBLANKS_CHOICES_SECTION = By.className("Cambium.Bundles.Gateway.ReadSentencePractice.choicesContainer");
	By FILLINTHEBLANKS_OPTIONS_LIST = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.ReadSentencePractice.draggable') and not(@style)]");
	By FILLINTHEBLANKS_DOTS_SECTION = By.className("Cambium.UI.StepBubbleBar.dotsHolder");
	By FILLINTHEBLANKS_BUBBLES_LIST = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.dotsInnerHolder']//div[@class='Cambium.UI.StepBubbleBar.progressDotRed']");
	By FILLINTHEBLANKS_DRAGGABLE_OPTION = By.xpath("(//div[contains(@class,'Cambium.Bundles.Gateway.ReadSentencePractice.draggable') and not(@style)])[1]");
	By CURRENT_SENTENCE_NUMBER = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.numeric']/font");
	
	//Read along and listen to the model unit section locators
	By READALONGANDLISTEN_TEXT = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionPractice.caption'][contains(text(),'Read along and listen to the model until')]");
	
	//YOu are ready to take the test section locators
	By YOUAREREADYTOTAKETHETEST_TEXT = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionPractice.caption'][contains(text(),'ready to take the test')]");
	
	//Ready to Record section locators
	By READYTORECORD_HEADER = By.xpath("//span[@class='Cambium.UI.Windows.Gateway.heading'][text()='Ready to record?']");
	
	//Recording section locators
	By MICROMETER_ICON = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.Recording.Sentence.recordingMicMeter')]");
	By MICROMETER_BUBBLES_SECTION = By.className("Cambium.UI.StepBubbleBar.dotsHolder");
	By BUBBLE_SELECTED = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.progressDotRed' and @style='opacity: 1;']");
	By BUBBLES_COUNT = By.className("Cambium.UI.StepBubbleBar.progressDotRed");
	
	//Review your recordings section
	By REVIEW_YOUR_RECORDINGS_HEADER = By.xpath("//span[@class='Cambium.UI.Windows.Gateway.heading'][text()='Review your recordings.']");
	
	
	// Voice compare section locators
	By GRADING_SENTENCES_SECTION = By.className("Cambium.Bundles.Gateway.Grading.Sentence.grades");
	By SENTENCE_HIGHLIGHTED = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.Grading.Sentence.correct')]");
	By BUBLLES_SECTION = By.className("Cambium.UI.StepBubbleBar.dotsHolder");
	By YOUR_VOICE_BTN_ENABLED = By.xpath("//span[@class='Cambium.UI.Buttons.AudioProgressTextButton.text' and @style='visibility: visible;'][text()='YOUR VOICE']");
	By COMPARE_BTN_ENABLED = By.xpath("//span[@class='Cambium.UI.Buttons.AudioProgressTextButton.text' and @style='visibility: visible;'][text()='COMPARE']");
	By THUMS_UP_BTN_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.GatewayThumbsButton.up')]");
	By THUMS_UP_BTN_DISABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.GatewayThumbsButton.up') and @disabled]");
	By THUMS_DOWN_BTN_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.GatewayThumbsButton.down')]");
	
	//Test results section locators
	By TEST_RESULTS_SUMMARY_SECTION = By.className("Cambium.Bundles.Gateway.Summary.resultsContainer");
	By TEST_RESULTS_SCORE_VALUE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Summary.accuracyContainer']//div[@class='Cambium.Bundles.Gateway.Summary.resultContent']//tr[1]/td[1]");
	By TEST_RESULTS_CONTINUE_BTN = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.Summary.buttonSet') and @style='display: block;']//button[text()='Continue']");
	
	//READ sentences summary table locators
	By ATTEMPT_SUMMARY_CONTENT = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.AttemptSummary.Content.Recording.component')]");
	By ATTEMPT_SUMMARY_RECORD_COUNT = By.className("Cambium.Bundles.Gateway.AttemptSummary.Content.Recording.count");
	By ATTEMPT_SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.AttemptSummary.continue')][text()='Continue']");
	
	//You have earned trophy section locators
	By SUBMIT_FOR_FEEDBACK_BTN = By.xpath("//button[text()='Submit For Feedback']");
	
	//Your recording has been submitted for feedback section
	By YOURRECORDING_SUBMITTED_MESSAGE = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionTest.caption'][text()='Your recording has been submitted for feedback.']");
	By YOURRECORDING_SUBMITTED_CONTINUE_BTN = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.buttonSet') and @style='display: block;']//button[text()='Continue']");	

	By RETAKE_TEST_BTN = By.xpath("//button[contains(@class, 'Cambium.Bundles.Gateway.TransitionTest.retakeTest')]");
	By TEST_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.continue')]");
	//By CONTINUEBTN_LAST_ATTEMPT = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.Summary.continue')]");

	By CONTINUEBTN_LAST_ATTEMPT = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.TransitionTest.continueToDashboard')]");

}

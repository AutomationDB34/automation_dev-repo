package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleStudentPowerPassTTActivityLocators {
	
	
	
	By QUESTION_FEEDBACK_SECTION = By.className("Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Student.reviewFeedbackGiven");
	By QUESTION_ONE_FEEDBACK = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Student.feedbackNumber'][text()='1']");
	By QUESTION_TWO_FEEDBACK = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Student.feedbackNumber'][text()='2']");
	By QUESTION_FEEDBACK_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Student.continue')]");	
	By QUESTION_FEEDBACK_BACKTOHOME_BTN = By.xpath("//button[contains(text(),'Back to Homepage')]");	
	
	
	By READY_TO_START_SECTION_HEADER = By.xpath("//span[@class='Cambium.UI.Windows.Gateway.heading'][text()='Ready to start Part B?']");
	By READY_TO_START_POWERB_START_BTN = By.xpath("//button[contains(@class,'Cambium.UI.ActionButton Cambium.UI.Windows.Gateway.button')][text()='Start']");
	
	
	
	By RUBRIC_MODAL_CONTENT = By.className("Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.RubricModal.content");	
	By RUBRIC_MODAL_QUESTIONONE_ID = By.xpath("//span[@class='Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.RubricModal.questionId'][text()='1:']");
	By RUBRIC_MODAL_CONTINUE = By.xpath("//button[contains(text(),'Continue')]");
	
	By RUBRIC_MODAL_QUESTIONONE_NUMBER = By.xpath("//span[@class='Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.questionNumber'][text()='1: ']");	
	By RUBRIC_MODAL_QUESTION_ANSWER = By.xpath("//textarea[contains(@class,'Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.answer')]");	
	By RUBRIC_MODAL_QUESTION_CONTINUE = By.xpath("//button[contains(@class,'Cambium.UI.ActionButton Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.submit')][text()='Continue']");
	
	By RUBRIC_MODAL_QUESTIONTWO_ID = By.xpath("//span[@class='Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.RubricModal.questionId'][text()='2:']");
	
	By RUBRIC_MODAL_QUESTIONTWO_NUMBER = By.xpath("//span[@class='Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.questionNumber'][text()='2: ']");
	
	By RUBRIC_MODAL_ANSWERS_SUBMIT_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.TextTraining.PowerPass.ShortAnswer.submit')][text()='Submit']");
	
	By RUBRIC_MODAL_TEST_RESULTS_SECTION = By.className("Cambium.Bundles.TextTraining.Results.tbl");
	
	By RUBRIC_MODAL_TEST_RESULTS_GOHOME = By.xpath("//button[contains(@class,'Cambium.UI.ActionButton Cambium.Bundles.TextTraining.Results.goHome')]");
}

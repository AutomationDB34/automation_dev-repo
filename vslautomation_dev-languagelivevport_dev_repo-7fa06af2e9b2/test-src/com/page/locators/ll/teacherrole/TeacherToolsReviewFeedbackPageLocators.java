package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherToolsReviewFeedbackPageLocators {

	By FEEDBACK_SELECTSCORE_TABLE=By.className("Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.studentRubric");
	
	By QUESTIONONE_NUMBER = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.currentQuestion'][text()='1']");
	By QEUSTION_SELECTSCORE_THIRDRADIO_BTN = By.xpath("//table[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.studentRubric']//button[@value='3']");
	By QUESTION_SELECTSCORE_THIRDOPTION_TEXT = By.xpath("//table[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.studentRubric']//button[@value='3']/parent::td/following-sibling::td");
	By SELECTED_STUDENTSCORE = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.score']");
	By SAVEANDCONTINUE_BTN = By.xpath("//button[contains(text(),'Save & Continue')]");
	
	By GOBACKTOQUESTIONONE_LINK = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.goBackQuestionNumber'][text()='1']");
	By ADDITIONALFEEDBACK_TABLE = By.xpath("//table[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.studentFeedback']");
	By FEEDBACK_FIRSTOPTION = By.xpath("//table[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.studentFeedback']//tr[1]/td[1]/button");
	By FEEDBACK_FIRSTOPTION_TEXT = By.xpath("//table[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.studentFeedback']//tr[1]/td[2]");
	
	By QUESTIONTWO_NUMBER = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.currentQuestion'][text()='2']");
	By GOBACKTOQUESTIONTWO_LINK = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.goBackQuestionNumber'][text()='2']");
	
	By FIRSTQUESTIONFEEDBACK_SECTION = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.feedbackNumber'][.='1']");
	By RUBRICSCORE_GIVEN = By.className("Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.rubricScoreGiven");
	By FEEDBACK_GIVEN = By.className("Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.additionalFeedbackGiven");
	By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");
	
	By SECONDQUESTIONFEEDBACK_SECTION = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.feedbackNumber'][.='2']");
	
	By SUBMITFEEDBACKGIVEN_SECTION = By.className("Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.submitFeedbackGiven");
	
	By SENDTOSTUDENT_BTN = By.xpath("//button[contains(text(),'Send To Student')]");
	
	By FEEDBACKSUBMITTED_HEADER_TEXT = By.xpath("//span[@class='Cambium.Bundles.Feedback.TextTraining.PowerPass.ShortAnswer.Teacher.SubmittedModal.heading'][text()='Feedback Submitted']");
	
	By ALLREVIEWS_BTN = By.xpath("//button[@name='allReviews']");
	
	
	//Read passages goal Feedback Locators
	By READPASSAGES_FEEDBACKPAGE = By.xpath("//span[contains(text(),'%s')]");
	By SAVE_AND_CONTINUE_BTN = By.xpath("//button[contains(text(),'Save & Continue')]");
	By COMPLETE__FEEDBACK_BTN = By.xpath("//button[contains(text(),'Complete Feedback')]");
	By RETURN_TO_REVIEW_LIST_LINK = By.xpath("//button[contains(@class,'Cambium.Bundles.Feedback.TeacherSummary.reviewList')]");
	By VIEWFEEDBACK_BTN = By.xpath("//button[contains(text(),'View Feedback')]");
	
	
	
	
	
	
	
	
	
	
}


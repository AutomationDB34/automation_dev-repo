package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherToolsReviewFeedbackPageLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherToolsReviewFeedbackPage extends SafeActions implements TeacherToolsReviewFeedbackPageLocators {

	public WebDriver driver;
	
	public TeacherToolsReviewFeedbackPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify navigation to review feedback page
	 */
	
	public void verifyNavigationToReviewFeedBackPage()
	{
		Assert.assertTrue(isElementPresent(FEEDBACK_SELECTSCORE_TABLE, LONGWAIT), "Feedback page is not displayed for the student user");
	}
	

	/**
	 * Purpose- To select feedback score for question 1
	 */
	
	public void giveFeedbackForStudent()
	{
		
		Assert.assertTrue(isElementPresent(QUESTIONONE_NUMBER, LONGWAIT), "Feedback select score page is not displayed for Question 1 for the student user");
		
		String initialFeedbackScoreForQuestion1 = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(initialFeedbackScoreForQuestion1, "-", "Initial selected feedback score for question 1 is set to ("+initialFeedbackScoreForQuestion1+"),instead of '-'");
		
		safeClick(QEUSTION_SELECTSCORE_THIRDRADIO_BTN, LONGWAIT);
		
		String selectedScoreTextOfQuestion1 = safeGetText(QUESTION_SELECTSCORE_THIRDOPTION_TEXT, LONGWAIT);
		
		String updatedFeedbackScoreForQuestion1 = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(updatedFeedbackScoreForQuestion1, "3", "Student feedback score for question is not updated properly. It is updated with ("+updatedFeedbackScoreForQuestion1+") instead of 3");
		
		safeClick(SAVEANDCONTINUE_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(GOBACKTOQUESTIONONE_LINK, LONGWAIT), "User is not taken to additional feed back section of question 1");
		
		safeClick(FEEDBACK_FIRSTOPTION, LONGWAIT);
		
		String selectedFeedBackTextOfQuestion1 = safeGetText(FEEDBACK_FIRSTOPTION_TEXT, LONGWAIT);
		
		String FeedbackScoreForQuestion1OnAdditionalFeedBackPage = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(FeedbackScoreForQuestion1OnAdditionalFeedBackPage, "3", "Student feedback score for question 1 is not updated properly on Additional feedback section of same section. It is updated with ("+FeedbackScoreForQuestion1OnAdditionalFeedBackPage+") instead of 3");
		
		safeClick(SAVEANDCONTINUE_BTN, LONGWAIT);		
		
		Assert.assertTrue(isElementPresent(QUESTIONTWO_NUMBER, LONGWAIT), "Feedback select score page is not displayed for Question 2 for the student user");
		
		String initialFeedbackScoreForQuestion2 = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(initialFeedbackScoreForQuestion2, "-", "Initial selected feedback score for question 2 is set to ("+initialFeedbackScoreForQuestion2+"),instead of '-'");
		
		safeClick(QEUSTION_SELECTSCORE_THIRDRADIO_BTN, LONGWAIT);
		
		String selectedScoreTextOfQuestion2 = safeGetText(QUESTION_SELECTSCORE_THIRDOPTION_TEXT, LONGWAIT);
		
		String updatedFeedbackScoreForQuestion2 = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(updatedFeedbackScoreForQuestion2, "3", "Student feedback score for question 2 is not updated properly. It is updated with ("+updatedFeedbackScoreForQuestion2+") instead of 3");
		
		safeClick(SAVEANDCONTINUE_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(GOBACKTOQUESTIONTWO_LINK, LONGWAIT), "User is not taken to additional feed back section of question 2");
		
		safeClick(FEEDBACK_FIRSTOPTION, LONGWAIT);
		
		String selectedFeedBackTextOfQuestion2 = safeGetText(FEEDBACK_FIRSTOPTION_TEXT, LONGWAIT);
		
		String FeedbackScoreForQuestion2OnAdditionalFeedBackPage = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(FeedbackScoreForQuestion2OnAdditionalFeedBackPage, "3", "Student feedback score for question 2 is not updated properly on Additional feedback section of same section. It is updated with ("+FeedbackScoreForQuestion2OnAdditionalFeedBackPage+") instead of 3");
		
		safeClick(SAVEANDCONTINUE_BTN, LONGWAIT);
		
		
		Assert.assertTrue(isElementPresent(FIRSTQUESTIONFEEDBACK_SECTION, LONGWAIT), "Feedback Summary section for question 1 is not displayed");
		
		String selectedScoreTextOfQuestion1InSummary = safeGetText(RUBRICSCORE_GIVEN, LONGWAIT);
		
		String selectedFeedBackTextOfQuestion1InSummary = safeGetText(FEEDBACK_GIVEN, LONGWAIT).replace("*", "");
		
		Assert.assertEquals("You scored 3 out of 3 points. "+selectedScoreTextOfQuestion1, selectedScoreTextOfQuestion1InSummary, "selected score text for question 1("+selectedScoreTextOfQuestion1+") doesn't match with displayed score text displayed under summary section("+selectedScoreTextOfQuestion1InSummary+")");
		
		Assert.assertEquals(selectedFeedBackTextOfQuestion1, selectedFeedBackTextOfQuestion1InSummary, "selected feedback text for question 1("+selectedFeedBackTextOfQuestion1+") doesn't match with displayed score text displayed under summary section("+selectedFeedBackTextOfQuestion1InSummary+")");
		
		safeClick(CONTINUE_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(SECONDQUESTIONFEEDBACK_SECTION, LONGWAIT), "Feedback Summary section for question 2 is not displayed");
		
		String selectedScoreTextOfQuestion2InSummary = safeGetText(RUBRICSCORE_GIVEN, LONGWAIT);
		
		String selectedFeedBackTextOfQuestion2InSummary = safeGetText(FEEDBACK_GIVEN, LONGWAIT).replace("*", "");
		
		Assert.assertEquals("You scored 3 out of 3 points. "+selectedScoreTextOfQuestion2, selectedScoreTextOfQuestion2InSummary, "selected score text for question 2("+selectedScoreTextOfQuestion2+") doesn't match with displayed score text displayed under summary section("+selectedScoreTextOfQuestion2InSummary+")");
		
		Assert.assertEquals(selectedFeedBackTextOfQuestion2, selectedFeedBackTextOfQuestion2InSummary, "selected feedback text for question 2("+selectedFeedBackTextOfQuestion2+") doesn't match with displayed feedback text displayed under summary section("+selectedFeedBackTextOfQuestion2InSummary+")");
	
		safeClick(CONTINUE_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(SUBMITFEEDBACKGIVEN_SECTION, LONGWAIT), "Submit given feedback section is not displayed for the student user");
		
		String sumOfFeedbackScoreForQ1AndQ2 = safeGetText(SELECTED_STUDENTSCORE,LONGWAIT);
		
		Assert.assertEquals(sumOfFeedbackScoreForQ1AndQ2, "6", "Sum of user selected feedback score("+sumOfFeedbackScoreForQ1AndQ2+") doesn't match with expected score value 6");
		
		safeClick(SENDTOSTUDENT_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(FEEDBACKSUBMITTED_HEADER_TEXT, LONGWAIT), "The popup with feedback submitted text is not displayed at the end of feedback sumbmission for the student user");
		
		safeClick(ALLREVIEWS_BTN, LONGWAIT);
		
		waitForPageToLoad();
		
	}
	
	
	public void giveFeedbackforWTGoal(){
		waitForPageToLoad();
		safeClick(SAVE_AND_CONTINUE_BTN, MEDIUMWAIT);
		safeClick(COMPLETE__FEEDBACK_BTN, MEDIUMWAIT);
		waitForSecs(3);
		safeClick(RETURN_TO_REVIEW_LIST_LINK, MEDIUMWAIT);
	}

	public void verifyGoalFeedbackPage(String student) {
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(READPASSAGES_FEEDBACKPAGE, student)), "Feedback page is not displayed for the student user");
	}
	
}

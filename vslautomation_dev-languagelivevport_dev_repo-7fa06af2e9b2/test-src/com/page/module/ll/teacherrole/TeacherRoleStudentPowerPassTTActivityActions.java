package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherRoleStudentPowerPassTTActivityLocators;
import com.page.module.ll.level1activities.LLActivity;
import com.selenium.SafeActions;

public class TeacherRoleStudentPowerPassTTActivityActions extends SafeActions implements TeacherRoleStudentPowerPassTTActivityLocators{

	private WebDriver driver;
	public TeacherRoleStudentPowerPassTTActivityActions(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	/**
	 * Purpose- Verify navigation to question 1 feedback section and click continue
	 */
	
	public void navigateToQuestionOneFeedbackAndClickContinue(boolean isStudentDisplayedWithViewPowerPassFeedBack)
	{
		if(isStudentDisplayedWithViewPowerPassFeedBack)
		{
		Assert.assertTrue(isElementPresent(QUESTION_ONE_FEEDBACK, LONGWAIT), "User is not taken to question 1 feedback section after clicking 'View power pass feedback' button as student user");
		safeClick(QUESTION_FEEDBACK_CONTINUE_BTN, LONGWAIT);
		waitForPageToLoad();
		}
	}
	
	/**
	 * Purpose- Verify navigation to question 2 feedback section and click continue
	 */
	
	public void navigateToQuestionTwoFeedbackAndClickContinue(boolean isStudentDisplayedWithViewPowerPassFeedBack)
	{
		if(isStudentDisplayedWithViewPowerPassFeedBack)
		{
		Assert.assertTrue(isElementPresent(QUESTION_TWO_FEEDBACK, LONGWAIT), "User is not taken to question 2 feedback section after clicking continue button on question 1 feedback section which is being displayed when clicked on 'View power pass feedback' button as student user");
		safeClick(QUESTION_FEEDBACK_CONTINUE_BTN, LONGWAIT);
		waitForPageToLoad();
		}
	}
	
	/**
	 * Purpose- To click 'Back to Home page' button under final part B power pass score section
	 */
	
	public LLActivity clickGoToHomePageButton(boolean isStudentDisplayedWithViewPowerPassFeedBack)
	{
		if(isStudentDisplayedWithViewPowerPassFeedBack)
		{
		safeClick(QUESTION_FEEDBACK_BACKTOHOME_BTN, LONGWAIT);
		waitForPageToLoad();
		}
		
		return new LLActivity(driver);
	}
	
	/**
	 * Purpose- Verify navigation to Ready To Start part B section  and click on 'Start' button
	 */
	
	public void navigateToReadyToStartPartBSectionAndClickStart()
	{
		Assert.assertTrue(isElementPresent(READY_TO_START_SECTION_HEADER, LONGWAIT), "Ready to start part? section is not being displayed");
		safeClick(READY_TO_START_POWERB_START_BTN, LONGWAIT);
		waitForPageToLoad();

	}
	
	/**
	 * Purpose- To verify the navigation to question 1 rubric model content section and click continue button
	 */
	
	public void navigateToQuestionOneRubricConentAndClickContinue()
	{
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_CONTENT, LONGWAIT), "Question 1 rubric content is not displayed");
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_QUESTIONONE_ID, LONGWAIT), "Question 1 rubric content is not displayed");
		safeClick(RUBRIC_MODAL_CONTINUE, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify the navigation to question 1 answer section, fill answer and click continue 
	 */
	
	public void verifyNavigationToQuestionOneRubricAnswerAndClickContinue()
	{
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_QUESTIONONE_NUMBER, LONGWAIT), "Question 1 rubric content answer section is not displayed");
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_QUESTION_ANSWER, LONGWAIT), "Question 1 rubric content answer section is not displayed");
		safeType(RUBRIC_MODAL_QUESTION_ANSWER, "Question 1 answer", LONGWAIT);
		safeClick(RUBRIC_MODAL_QUESTION_CONTINUE, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify the navigation to question 2 rubric model content section and click continue button
	 */
	
	public void navigateToQuestionTwoRubricConentAndClickContinue()
	{
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_CONTENT, LONGWAIT), "Question 2 rubric content is not displayed");
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_QUESTIONTWO_ID, LONGWAIT), "Question 2 rubric content is not displayed");
		safeClick(RUBRIC_MODAL_CONTINUE, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify the navigation to question 2 answer section, fill answer and click continue 
	 */
	
	public void verifyNavigationToQuestionTwoRubricAnswerAndClickContinue()
	{
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_QUESTIONTWO_NUMBER, LONGWAIT), "Question 2 rubric content answer section is not displayed");
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_QUESTION_ANSWER, LONGWAIT), "Question 2 rubric content answer section is not displayed");
		safeType(RUBRIC_MODAL_QUESTION_ANSWER, "question 2 answer", LONGWAIT);
		safeClick(RUBRIC_MODAL_ANSWERS_SUBMIT_BTN, LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify the navigation to power pass part B results section and click back to home page button 
	 */
	
	public void verifyNavigationToPowerPassBResultsSectionAndClickContinue()
	{
		Assert.assertTrue(isElementPresent(RUBRIC_MODAL_TEST_RESULTS_SECTION, LONGWAIT), "Power pass part b results section is not diplayed after submitting the answers as student user");

		safeClick(RUBRIC_MODAL_TEST_RESULTS_GOHOME, LONGWAIT);
		waitForPageToLoad();
	}

}

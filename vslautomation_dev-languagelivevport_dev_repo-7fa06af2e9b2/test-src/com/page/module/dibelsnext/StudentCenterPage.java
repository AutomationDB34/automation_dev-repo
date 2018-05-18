package com.page.module.dibelsnext;

import org.openqa.selenium.WebDriver;

import com.data.testdata.VportData;
import com.page.locators.dibelsnext.StudentCenterLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class StudentCenterPage extends SafeActions implements StudentCenterLocators {

	WebDriver driver;
	
	public StudentCenterPage(WebDriver driver) {
		super(driver);

		this.driver=driver;
	}

	/**
	 * Verifies DIBELS NEXT home page is loaded
	 */
	public void verifyStudentCenterPage() {
		waitForSecs(3);
		boolean bStudentCenterHeadingExists = isElementDisplayed(STUDENTCENTER_HEADING);
		Assert.assertTrue(bStudentCenterHeadingExists,
				"Student Center heading doesn't exists in the DIBELS NEXT Home page");
	}

	/**
	 * verifies Assessment which is enabled to the student is exists or not in
	 * student center page
	 * 
	 * @param assessmentPassageName
	 */
	public void verifyenabledAssessmentExists(String assessmentPassageName) {
		waitForPageToLoad();
		waitForSecs(4);
		boolean bAssessmentExists = isElementDisplayed(Dynamic.getNewLocator(ASSIGNMENTSNAME, assessmentPassageName));
		Assert.assertTrue(bAssessmentExists,"Assigned Assessment is not displayed for a student in Student Center page");
	}

	/**
	 * Click on Start taking test button to start the assessment
	 * 
	 * @param assessmentPassageName
	 */
	public void startAssessment(String assessmentPassageName) {
		safeSelectRadioButton(Dynamic.getNewLocator(RADIO_BUTTON, assessmentPassageName));
		safeClick(STARTTAKINGTHISTEST_BTN);
	}

	/**
	 * Verifies assessment is opened or not
	 */
	public void verifyAssessmentisOpened() {
		waitForSecs(30,"Waiting for assessment modal to load");
		boolean bAssessmentAdobevideo = isElementDisplayed(ASSESSMENTFLASHVIDEO);
		Assert.assertTrue(bAssessmentAdobevideo, "Assessment is not loaded on opening assessment ");
	}

	public void completeAssessment(VportData vportData){
		waitForSecs(40);
		safeClickUsingSikuli(vportData.DNIntroductionSkip, "Dibels Next introduction video skip link" , LONGWAIT);
		waitForSecs(20);
		safeClickUsingSikuli(vportData.DNContinueBtn, "Dibels Next continue button" , LONGWAIT);
		waitForSecs(5, "waiting for test modal to load");
		safeClickUsingSikuli(vportData.DNAnswer1, "Dibels Next answer 1" , LONGWAIT);
		safeClickUsingSikuli(vportData.DNAnswer2, "Dibels Next answer 2" , LONGWAIT);
		waitForSecs(180, "waiting for test to complete");
		safeClickUsingSikuli(vportData.DNReturnToStudnetCenter, "Dibels Next return to student center button" , LONGWAIT);
		waitForSecs(10);
		
	}
}

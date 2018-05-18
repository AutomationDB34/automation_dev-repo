package com.page.module.vport;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.page.locators.vport.DistrictAdminMyClassLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictAdminMyClassPage extends CommonFunctionalitiesVPort implements DistrictAdminMyClassLocators {
	private WebDriver driver;
	ConfigManager config = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	public DistrictAdminMyClassPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Verifies My Class page is loaded or not
	 */
	public void verifyMyClassPageIsLoaded() {
		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(MYCLASS_SUBTABS, "Summary")),
				"Summary Sub tab is not laoded on clicking 'My Class' sub tab");
		Assert.assertTrue(isElementDisplayed(IMPLEMENTATION_TABLEEXISTS),
				"Implementation Summary table is not loaded in My Class->Summary page");
	}

	/**
	 * Clicks on Summary tab available in My Class page
	 */
	public void clickSummaryTab() {
		safeClick(Dynamic.getNewLocator(MYCLASS_SUBTABS, "Summary"));
	}

	/**
	 * Verifies summary tab is loaded or not
	 */
	public void verifySummaryTabLoaded() {
		Assert.assertEquals(safeGetText(SUMMARYTAB_TITLE, LONGWAIT), "Setup Summary",
				"Title in My District->Summary tab is not displayed ");

	}

	/**
	 * Gets the data in implementation summary table and stores in Map
	 * 
	 * @return
	 */

	public Map<String, String> getImplementationSummaryTableRowAndValues() {
		Map<String, String> map = new HashMap<String, String>();
		List<WebElement> implementationSummaryRowHeadings = LocatorWebElements(IMPLEMENTATIONSUMMARY_TABLEROWS);
		List<WebElement> teachersRowValues = LocatorWebElements(IMPLEMENTATIONSUMMARY_VALUES);
		for (int i = 0; i < implementationSummaryRowHeadings.size(); i++) {

			String rowNames = implementationSummaryRowHeadings.get(i).getText();
			String rowValues = teachersRowValues.get(i).getText();
			map.put(rowNames, rowValues);
		}
		return map;
	}

	/**
	 * To verify, whether the My class tab roster page is displayed for the
	 * selected class or not
	 * 
	 * @param classname
	 */
	public void verifyNavigationToMyClassTabRoster(String classname) {
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(CLASSNAME_TEXT, classname), LONGWAIT),
				"User couldn't taken to class roster section of the class(" + classname + ")");
	}

	/**
	 * To click on ADD STUDENTS button on My CLASS->Roster Page
	 */
	public void clickAddStudentsButtonOnMYClassRostersMainPage() {
		safeClick(ADDSTUDENTSTOP_IMG, LONGWAIT);
	}

	/**
	 * To verify whether the page is navigated to create or add new students
	 * main page
	 */
	public void verifyNavigationToCreateStudentsPage() {
		Assert.assertTrue(isElementPresent(ADDSTUDENTSTOROSTER_IMG, LONGWAIT));
	}

	/**
	 * To click on Add button on create new students to roster page
	 */
	public void clickAddButtonOnCreateNewStudentsToRosterPage() {
		safeClick(ADDSTUDENTSTOROSTER_IMG, LONGWAIT);
	}

	/**
	 * To verify whether the Add New Students popup is displayed or not
	 */
	public void verifyNavigationToAddNewStudentsPopUp() {
		Assert.assertTrue(isElementPresent(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT));
	}

	/**
	 * To fill new student details on Add New students popup
	 * 
	 * @param stdLastName,stdFirstName,stdID,stdGrade,stdDOB
	 */
	public String fillNewStudentDetailsOnAddNewStudentsPopUp(String stdLastName, String stdFirstName, String stdID,
			String stdGrade, String stdDOB) {
		String studentID = stdID + System.currentTimeMillis();
		safeType(STDLASTNAMETEXT_FIELD, stdLastName + System.currentTimeMillis(), LONGWAIT);
		safeType(STDFIRSTNAMETEXT_FIELD, stdFirstName + System.currentTimeMillis(), LONGWAIT);
		safeType(STDIDNUMBERTEXT_FIELD, studentID, LONGWAIT);
		safeSelectOptionInDropDownByVisibleText(STDGRADELEVELTEXT_DRP, stdGrade, LONGWAIT);
		safeType(STDDOB_FIELD, stdDOB, LONGWAIT);
		return studentID;
	}

	/**
	 * To click on Save Changes button on Add New Students Popup
	 */
	public void clickSaveChangesButtonOnAddNewStudentsPopUp() {
		safeClick(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT);
	}

	/**
	 * To verify that add new students popup is disappeared from the page
	 */
	public void verifyAddNewStudentsPopUpDisappeared() {
		waitUntilElementDisappears(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT);
		waitForPageToLoad(LONGWAIT);
	}

	/**
	 * To click on Return To Class Roster Page on create new students section of
	 * class roster page
	 */

	public void clickReturnToClassRosterButton() {
		safeJavaScriptClick(RETURNTOCLASSROSTER_IMG, LONGWAIT);
	}

	/**
	 * To verify the added student in the class on My Class->Roster main page
	 * 
	 * @param studentId
	 */
	public void verifyAddedStudentInTheClass(String studentId) {
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ADDEDSTUDENTID_FIELD, studentId), LONGWAIT),
				"The student user with id(" + studentId + ") is not added to the class on My Class->Roster page");
	}

	/**
	 * To search for an existing student(i.e. added student through the script)
	 * under 'Add Existing Students' section on My Class->Roster page
	 * 
	 * @param studentId
	 * @throws InterruptedException
	 */
	public void searchForAnExistingStudentRecordByID(String studentId) {
		safeType(AVAILABLESTUDENTSSEARCH_FIELD, studentId, LONGWAIT);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupated exception has occured" + e.getMessage() + e.getStackTrace());
			Assert.fail("Interrupated exception has occured");
		}
		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(STUDENTINAVAILABLESTUDENTSTABLE_FIELD, studentId), LONGWAIT),
				"Student user with id(" + studentId
				+ ") is not found under 'Available Students' search table on My Class->Roster page");
	}

	/**
	 * To click on Add student arrow mark button under 'Available Students'
	 * table on 'My Class->Roster' page
	 * 
	 * @param studentId
	 */
	public void clickAddStudentArrowButton(String studentId) {
		safeClick(Dynamic.getNewLocator(ADDSTUDENTTOCLASSARROWBTN_IMG, studentId), LONGWAIT);
	}

	/**
	 * To verify added student in the target class section on 'My Class->Roster'
	 * page
	 * 
	 * @param studentId
	 */
	public void verifyAddedStudentUnderTargetClassSection(String studentId) {
		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(ADDEDSTUDENTSINTHETARGETCLASS_FIELD, studentId), LONGWAIT),
				"Student user with id(" + studentId
				+ ") is not found under 'target class' section on My Class->Roster page");
	}

	/**
	 * To click on save changes button after moving the student to new class 'My
	 * Class->Roster' page
	 */
	public void clickSaveChangesButtonAfterMovingTheStudentsToNewClass() {

		Assert.assertTrue(isElementPresent(SAVECHANGESBUTTONAFTERMOVINGSTUDENTS_IMG, LONGWAIT),
				"adding existing student to new class changes are not saved. Save changes button didn't complete it's operation on My class->Roster page");
		safeJavaScriptClick(SAVECHANGESBUTTONAFTERMOVINGSTUDENTS_IMG, LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * Verifies all licenses added to track are displayed to the student
	 * 
	 * @param pP_T2RStudent
	 * @param onlineAssessments
	 * @param T2R
	 * @param pP_T2R_EdplicityStudent
	 */

	public void verifyLicensesAvailableToStudent(String pP_T2RStudent, String onlineAssessments, String T2R,
			String pP_T2R_EdplicityStudent) {
		String pP_T2RStudentLicense = safeGetAttribute(Dynamic.getNewLocator(LICENSES_HEADINGSROW, "5"), "title",
				LONGWAIT);
		System.out.println(pP_T2RStudentLicense);
		Assert.assertEquals(pP_T2RStudentLicense, pP_T2RStudent,
				"PP/T2RStudent License type is not displayed for student  ");

		String onlieAssessmentsLicense = safeGetAttribute(Dynamic.getNewLocator(LICENSES_HEADINGSROW, "6"), "title",
				LONGWAIT);
		Assert.assertEquals(onlieAssessmentsLicense, onlineAssessments,
				"OnlineAssessments License type is not displayed for student  ");

		String T2RLicense = safeGetAttribute(Dynamic.getNewLocator(LICENSES_HEADINGSROW, "7"), "title", LONGWAIT);
		Assert.assertEquals(T2RLicense, T2R, "T2R License type is not displayed for student  ");

		String pP_T2R_EdplicityStudentLicense = safeGetAttribute(Dynamic.getNewLocator(LICENSES_HEADINGSROW, "8"),
				"title", LONGWAIT);
		Assert.assertEquals(pP_T2R_EdplicityStudentLicense, pP_T2R_EdplicityStudent,
				"pP_T2R_EdplicityStudent License type is not displayed for student  ");

	}

	/**
	 * To check 'PP/T2R/Edplicity Student ' checkbox of student license type
	 */
	public void checkPPT2REdplicityLicensetoStudent(String studentId) {
		waitForSecs(4);
		safeJavaScriptClick(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES, new String[] { studentId, Integer.toString(5)}),MEDIUMWAIT);
		waitForSecs(10);
	}

	/**
	 * To verify PP/T2R Student ,Online Assessments ,T2R check boxes are
	 * disabled after checking 'PP/T2R/Edplicity Student ' check box of student
	 * license type
	 */
	public void verifyOtherLicensesaDisabled(String studentId) {
		/*	for (int i = 2; i < 5; i++) {
			boolean bvalue = isElementEnabled(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES,
					new String[] { studentId, Integer.toString(i) }));
			Assert.assertFalse(bvalue, "Inherit radio button" + (i-1) + " are not in disabed state");
			setHighlight(driver.findElement(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES,
					new String[] { studentId, Integer.toString(i) })));
		}*/
		/*		boolean bvalue = isElementEnabled(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES,
				new String[] { studentId, Integer.toString(2) }));
		setHighlight(driver.findElement(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES,
				new String[] { studentId, Integer.toString(2) })));
		log.info("888888888888888882"+bvalue);
		//Assert.assertFalse(bvalue, "Inherit radio button" + (1) + " are not in disabed state");
		String ss = safeGetAttribute(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES,
				new String[] { studentId, Integer.toString(2) }), "disabled", MEDIUMWAIT);
		log.info("88888888888888888"+ss);*/
		boolean bvalue = driver.findElement(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES_DISABLED,
				new String[] { studentId, Integer.toString(2)})).isEnabled();
		Assert.assertFalse(bvalue, "Inherit radio button" + (1) + " are not in disabed state");

		bvalue = driver.findElement(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES_DISABLED,
				new String[] { studentId, Integer.toString(3)})).isEnabled();
		Assert.assertFalse(bvalue, "Inherit radio button" + (2) + " are not in disabed state");

		bvalue = driver.findElement(Dynamic.getNewLocator(ADDEDSTUDENTLICENSES_CHECKBOXES_DISABLED,
				new String[] { studentId, Integer.toString(4)})).isEnabled();
		Assert.assertFalse(bvalue, "Inherit radio button" + (2) + " are not in disabed state");
	}

	/**
	 * To click on Save changes button
	 */
	public void clicksaveChanges() {
		waitForSecs(2);
		safeClick(SAVECHANGESINROSTER_BTN);
		waitForSecs(10);
		waitForPageToLoad();
	}

	/**
	 * To change student auto generated userID and password with studentId and
	 * returs userID
	 */
	public String changeUserIDAndPasswordOfStudentAndSave(String studentId) {
		String StuUserIDPassword = studentId;
		safeClearAndType(Dynamic.getNewLocator(ADDEDSTUDENTUSERID, studentId), StuUserIDPassword);
		safeClearAndType(Dynamic.getNewLocator(ADDEDSTUDENTPASSWORD, studentId), StuUserIDPassword);
		clicksaveChanges();

		return StuUserIDPassword.toLowerCase();
	}

	/**
	 * 
	 * Navigates to Home page of class
	 */
	public DistrictAdminHomepage navigateToHomePageofClass() {
		safeClick(HOME_TAB);
		return new DistrictAdminHomepage(driver);
	}

	/**
	 * Navigates to Enter scores tav
	 */
	public void clickOnEnterScoresTab() {
		safeClick(ENTERSCORES_TAB);
	}

	/**
	 * verifies Enter Score tab
	 */
	public void verifyEnterScoresTab() {
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCREENTITLE, "1"), LONGWAIT), "Enter Scores",
				"Enter Scores text is not displayed in the screen title of 'Enter Scres' tab");
	}

	/**
	 * click on Test period in Enter scores tab
	 * 
	 * @param value
	 */
	public void chooseTestPeriod(String value) {
		safeClick(Dynamic.getNewLocator(CHOOSETESTPERIODS_BTNS, value));
	}

	/**
	 * Verifies Test period in Enter scores tab
	 * 
	 * @param value
	 */
	public void verifyTestperiod(String value) {
		isElementDisplayed(Dynamic.getNewLocator(BENCHMARKSCORESTABLEHEADING, value));
	}

	/**
	 * Clciks on pencil icon besides to assessment for a particular student
	 * 
	 * @param studentID
	 * @param value
	 */
	public void openAssessmentForStudent(String studentID, String value) {
		safeClick(Dynamic.getNewLocator(PENCILICONSFOROPENASSESSMENT, new String[] { studentID, "4" }));

	}

	/**
	 * Verifies Assessment flash video is opened or not
	 */

	public void verifyAssessmentisOpened() {
		boolean bAssessmentAdobevideo = isElementDisplayed(ASSESSMENTFLASHVIDEO);
		Assert.assertTrue(bAssessmentAdobevideo, "Assessment is not loaded on opening assessment ");
	}

	/**
	 * Clicks on Browser back button
	 */

	public void navigateBrowserBack() {
		driver.navigate().back();
	}

	/**
	 * Enter Scores into score fields of all assessments in all three test
	 * periods pages based on assessment types
	 * 
	 * @param vPortData
	 */
	public void enterScoreintoAssessmentBasedonAssessmentType(VportData vPortData) {
		for (int i = 1; i <= 3; i++) {

			chooseTestPeriod(Integer.toString(i));
			waitForPageToLoad();
			List<WebElement> assessmentTypes = LocatorWebElements(ASSESSMENTSTYPES);

			for (WebElement assessment : assessmentTypes) {
				String className = assessment.getAttribute("Class");

				safeType(Dynamic.getNewLocator(SCOREFIELDSOFASSESSMENTS, className),
						vPortData.assessmentScore(assessment.getText().split("\n")[0]), MEDIUMWAIT);
			}

			safeClick(SAVECHANGESINROSTER_BTN);

		}
	}

	/**
	 * Verifies ScheduleOnlineAssessmentsTab is displayed
	 */
	public void verifyScheduleOnlineAssessmentsTabexists() {
		boolean bScheduleOnlineAssessmentTabClickable = isElementClickable(SCHEDULEONLINEASSESSMENT_TAB);
		Assert.assertTrue(bScheduleOnlineAssessmentTabClickable,
				"Schedule Online Assessments tab doesn't exists and it is not clickable");
	}

	/**
	 * clicks on ScheduleOnlineAssessmentsTab
	 */
	public void navigateToScheduleOnlineAssessmentsTab() {
		safeClick(SCHEDULEONLINEASSESSMENT_TAB);
	}

	/**
	 * Verifies ScheduleOnlineAssessmentsTab tab
	 */
	public void verifyScheduleOnlineAssessmentsTab() {
		boolean bBenchmarkAssessmentsTableExists = isElementDisplayed(BENCHMARKASSESSMENTSTABLEHEADING);
		Assert.assertTrue(bBenchmarkAssessmentsTableExists, "Benchmark Assessments Table doesn't exists");
	}

	/**
	 * Clicks on check boxes under Enable Test row to enable assessments to
	 * students based on time period
	 * 
	 * @param timePeriod
	 * @return
	 */
	public String enableTestForStudent(String timePeriod) {
		safeCheck(Dynamic.getNewLocator(ENABLETESTCHECKBOX, new String[] { timePeriod, "2" }), MEDIUMWAIT);

		String passageName = safeGetText(
				Dynamic.getNewLocator(ASSESSMENTROWINBENCHMARKASSESSMENTSTABLE, new String[] { timePeriod, "1" }),
				MEDIUMWAIT);
		return passageName.trim();
	}

	/**
	 * Purpose is to click on the Roster link  
	 */
	public void clickOnRoster() {
		safeClick(ROSTER, MEDIUMWAIT);
		waitForPageToLoad();
		waitForSecs(5);
	}

	/**
	 * Purpose is to verify the navigation to the Enter scores tab 
	 * @param classname
	 */
	public void verifyNavigationToMyClassTabEnterScores(String classname) {
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(CLASSNAME_TEXT, classname), LONGWAIT),
				"User couldn't taken to class enter scoressection of the class(" + classname + ")");
	}

	/**
	 * Purpose is to verify the score submitted by the student 
	 * @param stdname
	 */
	public String verifyAssessmentSubmittedByStudentDAZE(String stdname) {

		waitForPageToLoad();
		safeClick(DIBELSNEXT_LINK, MEDIUMWAIT);
		safeClick(TEST_PERIOD_LINK, MEDIUMWAIT);

		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(STUDENT_SUBMITTED_SCORE_LINK, stdname)),
				"Student has not submitted the score for the Dibels Next assigned assessment");
		System.out.println("Student submitted score is"
				+ safeGetText(Dynamic.getNewLocator(STUDENT_SUBMITTED_SCORE_LINK, stdname), MEDIUMWAIT));

		return safeGetText(Dynamic.getNewLocator(STUDENT_SUBMITTED_SCORE_LINK, stdname), MEDIUMWAIT);
	}
	
	public String verifyAssessmentSubmittedByStudentDORF(String stdname) {

		waitForPageToLoad();
		safeClick(DIBELSNEXT_LINK, MEDIUMWAIT);
		safeClick(TEST_PERIOD_LINK, MEDIUMWAIT);

		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(STUDENT_SUBMITTED_SCORE_LINK1, stdname)),
				"Student has not submitted the score for the Dibels Next assigned assessment");
		System.out.println("Student submitted score is"
				+ safeGetText(Dynamic.getNewLocator(STUDENT_SUBMITTED_SCORE_LINK1, stdname), MEDIUMWAIT));

		return safeGetText(Dynamic.getNewLocator(STUDENT_SUBMITTED_SCORE_LINK1, stdname), MEDIUMWAIT);
	}

	/**
	 * Purpose is to navigate to th eEntr scores tab
	 */
	public void navigateToEnterScoresSubTab() {
		safeClick(ENTERSCORES_TAB, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Purpose is to verify the pencil icon displayed
	 * @param studentID
	 */
	public void verifyPencilIcon(String studentID) {
		Assert.assertTrue(isElementClickable(Dynamic.getNewLocator(DORF_PENCIL_ICON, studentID), LONGWAIT),
				"Pencil icon for assessment is not clickable");
	}

	/**
	 * Purpose is to complete the assessment enabled on clicking the pencil icon  
	 * @param studentID
	 * @param vportData
	 */
	public void clickOnPencilIconForAssessment(String studentID , VportData vportData)  {

		safeClick(Dynamic.getNewLocator(DORF_PENCIL_ICON, studentID), LONGWAIT);
		waitForSecs(40 ,  "Waiting for assessment window to load");
		safeClickUsingSikuli(vportData.DORF_Assessment_Btn, "DORF assessment Yes continue button", LONGWAIT);
		waitForSecs(10 ,  "Waiting for assessment window to load");
		safeClickUsingSikuli(vportData.DNContinueBtn, "DORF assessment Continue button", LONGWAIT);
		safeClickUsingSikuli(vportData.DNContinueBtn, "DORF assessment Continue button", LONGWAIT);
		waitForSecs(5);
		safeClickUsingSikuli(vportData.DORF_Assessment_start_Btn, "DORF Start Assessment button", LONGWAIT);

		waitForSecs(65 , "Waiting for assessment to complete");

		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
		} catch (AWTException e) {

			e.printStackTrace();
		}

		safeClickUsingSikuli(vportData.DORF_LastWord_Btn, "DORF Assessment Last Wordbutton", LONGWAIT);
		safeClickUsingSikuli(vportData.DORF_Conitnue_Btn, "DORF Assessment continue button", LONGWAIT);
		safeClickUsingSikuli(vportData.DORF_FinishAssessment_Btn, "DORF Finish Assessment button", LONGWAIT);

	}

	public void deleteExtraStudents() 
	{
			do
			{
				int studentsFound = LocatorWebElements(STUDENT_WITH_ID_TEXT).size();
				log.info("In this page Found "+studentsFound+" Students to delete");
				while(studentsFound>0)
				{
					/*String s = safeGetText(
							Dynamic.getNewLocator(By.xpath("(.//td[contains(@class,'nameRowNoBg borderLlt')][1])[%s]"),String.valueOf(i)),MEDIUMWAIT);
					System.out.println(s+"****");
					setHighlight(driver.findElement(Dynamic.getNewLocator(By.xpath("(.//td[contains(@class,'nameRowNoBg borderLlt')][1])[%s]"),String.valueOf(i))));
					if(s.contains("ID"))
					{
						isElementPresent(Dynamic.getNewLocator(By.xpath("(.//img[contains(@src,'deleteIcon')])[%s]"),String.valueOf(i)), MEDIUMWAIT);
						setHighlight(driver.findElement(Dynamic.getNewLocator(By.xpath("(.//img[contains(@src,'deleteIcon')])[%s]"),String.valueOf(i))));
						driver.findElement(Dynamic.getNewLocator(By.xpath("(.//img[contains(@src,'deleteIcon')])[%s]"),String.valueOf(i))).click();
						acceptAlert();
						i=i-1;
					}*/
					setHighlight(driver.findElement(STUDENT_WITH_ID_TEXT ));
					setHighlight(driver.findElement(STUDENT_WITH_ID_TEXT_DELETE));
					safeClick(STUDENT_WITH_ID_TEXT_DELETE, VERYSHORTWAIT);
					waitForSecs(3);
					acceptAlert();
					waitForSecs(3);
					waitForPageToLoad();
					studentsFound--;
				}
				if(isElementPresent(NEXT_LINK, VERYSHORTWAIT))
				{
					safeClick(NEXT_LINK, VERYSHORTWAIT);
					waitForSecs(4);
					waitForPageToLoad();
				}
				else
				{
					break;
				}
			}
			while(isElementPresent(NEXT_LINK, VERYSHORTWAIT));
	}

}

package com.page.module.ll.teacherrole;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherReportsCourseReportsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherReportsCourseReportsPage extends CommonFunctionalities
		implements TeacherReportsCourseReportsLocators {

	private WebDriver driver;
	private LLData llData;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());

	public TeacherReportsCourseReportsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose- To verify that Course Reports->Summary Section is highlighted
	 */
	public void verifyThatCourseReportsSummaryTabIsHighlighted() {
		Assert.assertTrue(isElementPresent(SUMMARYTAB_HIGHLIGHTED, LONGWAIT),
				"Summary Tab is not higlighted when clicked on Reports->Course Reports link");
	}

	/**
	 * Purpose- To verify students progress in respective units and sight words
	 * and also in respective bar graphs
	 * 
	 * @param studentLastName,studentWtLevelAndUnit,studentSightWordsLevel
	 */

	public int[] verifyStudentProgressInWTAndSightWordsGraphs(String studentLastName, String studentWtLevelAndUnit,
			String studentSightWordsLevel) {
		int[] studentFloorAndUnitNumbers = new int[2];

		Assert.assertTrue(isElementPresent(SUMMARYTAB_STUDENTS_TABLE, LONGWAIT),
				"Course Reports->Summary tab students section is not loaded");

		String actualStudentWTLevelAndUnit = safeGetText(
				Dynamic.getNewLocator(SUMMARYTAB_WTSTUDENT_PROGRESS, studentLastName), LONGWAIT);

		Assert.assertEquals(actualStudentWTLevelAndUnit.toLowerCase(), studentWtLevelAndUnit.toLowerCase(),
				"The expected student level and unit progress value(" + studentWtLevelAndUnit
						+ ") doesn't match with actual level and unit value(" + actualStudentWTLevelAndUnit
						+ ") on Course Reports->Summary Tab section");

		String[] unitAndWT = studentWtLevelAndUnit.split("\\.");

		int unitValueInNumber = Integer.parseInt(unitAndWT[1].replace("U", "")) + 1;

		safeJavaScriptClick(
				Dynamic.getNewLocator(SUMMARYTAB_WTPROGRESSBAR, unitAndWT[1], Integer.toString(unitValueInNumber)),
				LONGWAIT);

		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(SUMMARYTAB_WTBARPOPUP_STUDENT, studentLastName), LONGWAIT),
				"The student user(" + studentLastName + ")is not displayed on summary tab wt bar progress popup");

		refresh();

		Assert.assertTrue(isElementPresent(SUMMARYTAB_STUDENTS_TABLE, LONGWAIT),
				"Course Reports->Summary tab students section is not loaded afre closing WT progress bar popup");

		String actualStudentSightWordsLevel = safeGetText(
				Dynamic.getNewLocator(SUMMARYTAB_SIGHTWORDS_PROGRESS, studentLastName), LONGWAIT);

		Assert.assertEquals(actualStudentSightWordsLevel.toLowerCase(), studentSightWordsLevel.toLowerCase(),
				"The expected student sight words progress value(" + studentSightWordsLevel
						+ ") doesn't match with actual value(" + actualStudentSightWordsLevel
						+ ") on Course Reports->Summary Tab section");

		String floorValue = studentSightWordsLevel.replace("loor", "").replaceAll(" ", "");

		int floorinNumber = Integer.parseInt(floorValue.replace("F", "")) + 1;

		/*
		 * safeClick(Dynamic.getNewLocator(SUMMARYTAB_SIGHTWORDSBAR,
		 * floorValue,Integer.toString(floorinNumber)), LONGWAIT);
		 * 
		 * Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(
		 * SUMMARYTAB_SIGHTWORDSBARPOPUP_STUDENT, studentLastName), LONGWAIT),
		 * "The student user("+studentLastName+
		 * ")is not displayed on summary tab Sight Words bar progress popup");
		 * 
		 * refresh();
		 * 
		 * Assert.assertTrue(isElementPresent(SUMMARYTAB_STUDENTS_TABLE,
		 * LONGWAIT),
		 * "Course Reports->Summary tab students section is not loaded afre closing WT progress bar popup"
		 * );
		 */
		studentFloorAndUnitNumbers[0] = unitValueInNumber - 1;
		studentFloorAndUnitNumbers[1] = floorinNumber - 1;

		return studentFloorAndUnitNumbers;
	}

	/**
	 * Purpose- To click on Word Training tab under Reports->Course Reports
	 * section
	 */

	public void clickOnWordTrainingTabUnderCourseReports() {
		safeClick(WORDTRAINING_TAB, LONGWAIT);
	}

	/**
	 * Purpose- To verify that word training tab is displayed the results for
	 * all units
	 */
	public void verifyWordTrainingTabDisplaysTotalUnitScores() {
		Assert.assertTrue(isElementPresent(WORDTRAININGTAB_ALLUNITSTABLE, LONGWAIT),
				"Word Training tab under Course reports section is not displayed with all unit scores by default");
	}

	/**
	 * Purpose- To verify the student scores under word training tab
	 * 
	 * @param studentLastName,studentWTUnitNumber,studentWTUnitPercentageScore
	 */

	public void verifyStudentScoresUnderWordTrainingTabAllUnitsSection(String studentLastName,
			String studentWTUnitNumber, String studentWTUnitPercentageScore) {
		scrollIntoElementView(Dynamic.getNewLocator(WORDTRAININGALLUNITS_STUDENT, studentLastName));
		String studentActualUnitPercentage = safeGetText(
				Dynamic.getNewLocator(WORDTRAININGALLUNITS_STUDENTSCORE, studentLastName, studentWTUnitNumber),
				LONGWAIT);
		Assert.assertEquals(studentActualUnitPercentage.toLowerCase(), studentWTUnitPercentageScore.toLowerCase(),
				"The expected student WT unit score percentage value (" + studentWTUnitPercentageScore
						+ ") doesn't match with actual value(" + studentActualUnitPercentage
						+ ") on Course Reports->Word Training section");
	}

	/**
	 * Purpose- To click on Sight Words tab under Reports->Course Reports
	 * section
	 */

	public void clickOnSightWordsTabUnderCourseReports() {
		safeClick(SIGHTWORDS_TAB, LONGWAIT);
	}

	/**
	 * Purpose- To verify that sight words tab is displayed the results floor
	 * wise
	 */
	public void verifySightWordsTabDisplaysFloorWiseScores() {
		Assert.assertTrue(isElementPresent(SIGHTWORDS_ALLFLOORSTABLE, LONGWAIT),
				"Sight Words tab under Course reports section is not displayed with floor wise results");
	}

	/**
	 * Purpose- To verify the student scores(BOT and number of games played)
	 * under Sight Words tab
	 * 
	 * @param studentLastName,studentFloorNumber,studentBotsScore,
	 *            studentGamesPlayedCount
	 */

	public void verifyStudentScoresUnderSightWordsTabAllFloorsSection(String studentLastName, int studentFloorNumber,
			String studentBotsScore, String studentGamesPlayedCount) {
		waitForSecs(10);
		// scrollIntoElementView(Dynamic.getNewLocator(SIGHTWORDS_STUDENTS,
		// studentLastName));
		String studentActualBotsScore = safeGetText(Dynamic.getNewLocator(SIGHTWORDS_STUDENTSCORE, studentLastName,
				Integer.toString(studentFloorNumber + studentFloorNumber)), LONGWAIT);
		Assert.assertEquals(studentActualBotsScore.toLowerCase(), studentBotsScore.toLowerCase(),
				"The expected student Sight Words Bots score value (" + studentBotsScore
						+ ") doesn't match with actual value(" + studentActualBotsScore
						+ ") on Course Reports->Sight Words section");
		String studentActualGamesPlayedScore = safeGetText(Dynamic.getNewLocator(SIGHTWORDS_STUDENTSCORE,
				studentLastName, Integer.toString((studentFloorNumber * 2) + 1)), LONGWAIT);
		Assert.assertEquals(studentActualGamesPlayedScore.toLowerCase(), studentGamesPlayedCount.toLowerCase(),
				"The expected student Sight Words Games Played count (" + studentGamesPlayedCount
						+ ") doesn't match with actual value(" + studentActualGamesPlayedScore
						+ ") on Course Reports->Sight Words section");
	}

	/**
	 * Purpose- To click on Text Training Tab
	 */
	public void clickOnTextTrainingTabUnderCourseReports() {
		safeClick(TEXTTRAINING_TAB, LONGWAIT);
	}

	/**
	 * Purpose- To verify that Text Training tab is loaded
	 */

	public void verifyTheNavigationToTextTrainingTab() {
		Assert.assertTrue(isElementPresent(TEXTTRAININGTAB_TABLE, LONGWAIT),
				"Text Training Tab under 'Reports->Course Reports' section is not loaded");
	}

	/**
	 * Purpose- To click on Text Training Unit Number Button
	 * 
	 * @param studentUnitNumber
	 */

	public void clickOnTextTrainingUnitNumberButton(String studentUnitNumber) {
		safeClick(Dynamic.getNewLocator(TEXTTRAINING_UNITNUMBER_BTN, studentUnitNumber), LONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * Purpose- To verify that text training section is loaded for the selected
	 * student unit
	 * 
	 * @param studentUnitNumber
	 */

	public void verifyTheNavigationToSelectedTextTrainingUnitSection(String studentUnitNumber) {
		waitForSecs(10);
		waitForPageToLoad();
		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(TEXTTRAINING_RETEACHUNIT_LINK, studentUnitNumber), LONGWAIT),
				"Text Training Tab under 'Reports->Course Reports' section is not loaded with selected student unit("
						+ studentUnitNumber + ") button data");
	}

	/**
	 * Purpose - To verify student score values(such as RACTICE ACTIVITIES,
	 * CONTENT MASTERY,POWER PASS) under Text Training tab
	 * 
	 * @param studentLastname,
	 *            expectedPracticeActivity,
	 *            expectedStudentPracticeActivityScore, expectedContentMastery,
	 *            expectedContentMasteryScore,
	 *            expectedPowerPass,expectedPowerPassScore
	 */

	public void verifyStudentScoresUnderTheSelectedUnitTextTraining(String studentLastname,
			String expectedPracticeActivity, String expectedStudentPracticeActivityScore, String expectedContentMastery,
			String expectedContentMasteryScore, String expectedPowerPass, String expectedPowerPassScore) {
		Assert.assertTrue(isElementPresent(TEXTTRAININGTAB_TABLE, LONGWAIT),
				"Text Training Tab under 'Reports->Course Reports' section is not loaded after clicking student unit number");

		// Assert.haultonfailure=false;

		int practiceActivityColumnsDisplayedCount = getLocatorCount(TEXTTRAINING_PRACTICEACTIVITY_COULUMNS_COUNT);

		for (int i = 1; i <= practiceActivityColumnsDisplayedCount; i++) {
			String actualpracticeActivityColumnName = safeGetText(
					Dynamic.getNewLocator(TEXTTRAINING_PRACTICEACTIVITY_COLUMN, Integer.toString(i)), LONGWAIT);

			if (actualpracticeActivityColumnName.equalsIgnoreCase(expectedPracticeActivity)) {
				String actualStudentPracticeActivityScore = safeGetText(
						Dynamic.getNewLocator(TEXTTRAINING_STUDENTSCORE, studentLastname, Integer.toString(i + 1)),
						LONGWAIT);

				Assert.assertEquals(actualStudentPracticeActivityScore, expectedStudentPracticeActivityScore,
						"Actual practice activity score(" + actualStudentPracticeActivityScore + ") of the student("
								+ studentLastname + ") doesn't match with expected score("
								+ expectedStudentPracticeActivityScore + ")");

				break;
			}
		}

		int contentMasteryColumnsDisplayedCount = getLocatorCount(TEXTTRAINING_CONTENTMASTERY_COULUMNS_COUNT);

		for (int i = 1; i <= contentMasteryColumnsDisplayedCount; i++) {
			String actualcontentMasteryColumnName = safeGetText(
					Dynamic.getNewLocator(TEXTTRAINING_CONTENTMASTERY_COLUMN, Integer.toString(i)), LONGWAIT);

			if (actualcontentMasteryColumnName.equalsIgnoreCase(expectedContentMastery)) {
				String actualStudentContentMasteryScore = safeGetText(Dynamic.getNewLocator(TEXTTRAINING_STUDENTSCORE,
						studentLastname, Integer.toString((practiceActivityColumnsDisplayedCount + i) + 1)), LONGWAIT);

				Assert.assertEquals(actualStudentContentMasteryScore, expectedContentMasteryScore,
						"Actual Content Mastery score(" + actualStudentContentMasteryScore + ") of the student("
								+ studentLastname + ") doesn't match with expected score(" + expectedContentMasteryScore
								+ ")");

				break;
			}
		}

		int powerPassColumnsDisplayedCount = getLocatorCount(TEXTTRAINING_POWERPASS_COULUMNS_COUNT);

		for (int i = 1; i <= powerPassColumnsDisplayedCount; i++) {
			String actualPowerPassColumnName = safeGetText(
					Dynamic.getNewLocator(TEXTTRAINING_POWERPASS_COLUMN, Integer.toString(i)), LONGWAIT);

			if (actualPowerPassColumnName.equalsIgnoreCase(expectedPowerPass)) {
				String actualPowerPassScore = safeGetText(
						Dynamic.getNewLocator(TEXTTRAINING_STUDENTSCORE, studentLastname, Integer.toString(
								(practiceActivityColumnsDisplayedCount + i + contentMasteryColumnsDisplayedCount) + 1)),
						LONGWAIT);

				Assert.assertEquals(actualPowerPassScore, expectedPowerPassScore,
						"Actual Power Pass score(" + actualPowerPassScore + ") of the student(" + studentLastname
								+ ") doesn't match with expected score(" + expectedPowerPass + ")");

				break;
			}
		}
	}

	/**
	 * Purpose is to click on the bar graph of WT and check students dispalyed
	 */
	public void clickBarGraphAndVerifyStudentDetails() {
		safeJavaScriptClick(WT_GRAPH_BAR, LONGWAIT);
		Assert.assertTrue(isElementDisplayed(BARGRAPH_POPUP));
		List<WebElement> students_count = LocatorWebElements(STUDENTS_LIST_IN_POPUP);
		String student_count_displayed_in_popup = safeGetText(STUDENT_COUNT_IN_POPUP, LONGWAIT);
		if (student_count_displayed_in_popup.substring(1, 3).equals(Integer.toString(students_count.size()))) {
			System.out
					.println("students count in the pop up is matching with the count dispalyed in the pop up header");
		}

	}

	/**
	 * Purpose is to click on the student in the bar graph and verify summary
	 */
	public void clickStudentInPopupAndVerifySummary(LLData llData) {
		safeJavaScriptClick(WT_GRAPH_BAR, LONGWAIT);
		Assert.assertTrue(isElementDisplayed(BARGRAPH_POPUP));
		scrollIntoElementView(
				Dynamic.getNewLocator(STUDENT_NAME_TO_VERIFY_SUMMARY, llData.teacherRoleLLStudentLastName));
		safeClick(Dynamic.getNewLocator(STUDENT_NAME_TO_VERIFY_SUMMARY, llData.teacherRoleLLStudentLastName), LONGWAIT);
		waitForSecs(10, "waiting for the summary page to laod");
		Assert.assertTrue(isElementDisplayed(SUMMARY_PAGE));
		Assert.assertTrue(
				isElementDisplayed(Dynamic.getNewLocator(SUMMARY_PAGE_STUDENT_VERIFICATION,
						llData.teacherRoleLLStudentLastName, llData.teacherRoleLLStudentLastName)),
				"Selected student's summary page is not being dispalyed");

	}

	/**
	 * Purpose is to verify the data displayed in "All Student" filter
	 */
	public void verifyAllStudentsDisplayed() {
		waitForPageToLoad(5);
		Assert.assertTrue(isElementDisplayed(SUMMARYTAB_STUDENTS_TABLE),
				"Summary tab - studnets table is not being displayed");
	}

	/**
	 * Purpose is to verify the data displayed in "Individual Student" filter
	 */
	public void verifyIndividualStudentData(LLData llData) {
		waitForPageToLoad(5);
		safeClick(STUDENT_SELECTION_DROPDOWN, LONGWAIT);
		safeClick(Dynamic.getNewLocator(STUDENT_NAME, llData.teacherRoleLLStudentFirstName,
				llData.teacherRoleLLStudentFirstName), LONGWAIT);

		Assert.assertTrue(
				isElementDisplayed(Dynamic.getNewLocator(SUMMARY_PAGE_STUDENT_VERIFICATION,
						llData.teacherRoleLLStudentLastName, llData.teacherRoleLLStudentLastName)),
				"Selected student's summary page is not being dispalyed");

	}

	/**
	 * Purpose is to verify unit wise score detail
	 */
	public void verifyPerUnitScoresDetails(String studentLastName, String studentWTL1PercentageScore,
			String studentWTL2PercentageScore, String studentWTL3PercentageScore, String studentWTL4PercentageScore) {

		safeClick(UNIT_1_BTN, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(UNIT_DETAILS_PAGE), "Unit details page is not being displayed");

		scrollIntoElementView(Dynamic.getNewLocator(STUDENT_WT_DETAILS, studentLastName));
		String studentLesson1ActualUnitPercentage = safeGetText(Dynamic.getNewLocator(LESSON_1_SCORE, studentLastName),
				LONGWAIT);

		Assert.assertEquals(studentLesson1ActualUnitPercentage.toLowerCase(), studentWTL1PercentageScore.toLowerCase(),
				"The expected student WT Lesson1 score percentage value (" + studentWTL1PercentageScore
						+ ") doesn't match with actual value(" + studentLesson1ActualUnitPercentage
						+ ") on Course Reports->Word Training Unit1 Lesson1 section");

		String studentLesson2ActualUnitPercentage = safeGetText(Dynamic.getNewLocator(LESSON_2_SCORE, studentLastName),
				LONGWAIT);

		Assert.assertEquals(studentLesson2ActualUnitPercentage.toLowerCase(), studentWTL2PercentageScore.toLowerCase(),
				"The expected student WT Lesson2 score percentage value (" + studentWTL2PercentageScore
						+ ") doesn't match with actual value(" + studentLesson2ActualUnitPercentage
						+ ") on Course Reports->Word Training Unit1 Lesson2 section");
		String studentLesson3ActualUnitPercentage = safeGetText(Dynamic.getNewLocator(LESSON_3_SCORE, studentLastName),
				LONGWAIT);

		Assert.assertEquals(studentLesson3ActualUnitPercentage.toLowerCase(), studentWTL3PercentageScore.toLowerCase(),
				"The expected student WT Lesson3 score percentage value (" + studentWTL3PercentageScore
						+ ") doesn't match with actual value(" + studentLesson3ActualUnitPercentage
						+ ") on Course Reports->Word Training Unit1 Lesson3 section");

		String studentLesson4ActualUnitPercentage = safeGetText(Dynamic.getNewLocator(LESSON_4_SCORE, studentLastName),
				LONGWAIT);

		Assert.assertEquals(studentLesson4ActualUnitPercentage.toLowerCase(), studentWTL4PercentageScore.toLowerCase(),
				"The expected student WT Lesson4 score percentage value (" + studentWTL4PercentageScore
						+ ") doesn't match with actual value(" + studentLesson4ActualUnitPercentage
						+ ") on Course Reports->Word Training Unit1 Lesson4 section");
	}

	/**
	 * Purpose is to verify the Display drop down
	 */
	public void verifydisplayDropDown(String studentLastName, String studentgoalScore) {

		safeClick(DISPLAY_DROPDOWN, MEDIUMWAIT);
		safeClick(GOAL_NAME, MEDIUMWAIT);
		waitForSecs(5, "Waiting for page to load");

		scrollIntoElementView(Dynamic.getNewLocator(STUDENT_GOAL_DETAILS, studentLastName));
		String studentReadPassageScore = safeGetText(Dynamic.getNewLocator(STUDENT_GOAL_DETAILS, studentLastName),
				LONGWAIT);
		Assert.assertEquals(studentReadPassageScore.toLowerCase(), studentgoalScore.toLowerCase(),
				"The expected student WT Read Passage score percentage value (" + studentgoalScore
						+ ") doesn't match with actual value(" + studentReadPassageScore
						+ ") on Course Reports->Word Training Unit 1Read Passagesection");

	}

	public void veifyFloorwiseScoreDetails(LLData llData) {

		safeClick(FLOOR_NUMBER, MEDIUMWAIT);
		waitForSecs(3);
		String studentSightWordsScore = safeGetText(
				Dynamic.getNewLocator(FLOOR_WISE_SCORE, llData.teacherRoleLLStudentLastName), LONGWAIT);
		Assert.assertEquals(studentSightWordsScore.toLowerCase(), llData.teacherRoleLLStudentSWBOTSScore.toLowerCase(),
				"The expected student Sight Words Bots score value (" + llData.teacherRoleLLStudentSWBOTSScore
						+ ") doesn't match with actual value(" + studentSightWordsScore
						+ ") on Course Reports->Sight Words section");

	}

	public void reportsCourseReportsWTSection(LLData llData, int[] studentUnitAndFloorValues) {

		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			verifyStudentScoresUnderWordTrainingTabAllUnitsSection(llData.teacherRoleLLStudentLastName,
					Integer.toString(studentUnitAndFloorValues[0] + 1),
					llData.teacherRoleLLStudentWTUnitPercentageScore);

		} else {
			log.info("Runnig the test case at RC mode");
			verifyStudentScoresUnderWordTrainingTabAllUnitsSection(llData.teacherRoleLLStudentLastName,
					Integer.toString(studentUnitAndFloorValues[0] + 1),
					llData.teacherRoleLLStudentWTUnitPercentageScore);
			verifydisplayDropDown(llData.teacherRoleLLAlertsAutoPassStudentLastName, llData.StudentReadPassageScore);
			verifyPerUnitScoresDetails(llData.teacherRoleLLStudentLastName, llData.StudentLesson1Score,
					llData.StudentLesson2Score, llData.StudentLesson3Score, llData.StudentLesson4Score);
		}

	}
	
	public void reportsCourseReportsSightWordsSection(LLData llData, int[] studentUnitAndFloorValues){
		
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			verifyStudentScoresUnderSightWordsTabAllFloorsSection(
					llData.teacherRoleLLStudentLastName, studentUnitAndFloorValues[0],
					llData.teacherRoleLLStudentSWBOTSScore, llData.teacherRoleLLStudentSWGamesPlayedCount);

		} else {
			log.info("Runnig the test case at RC mode");
			verifyStudentScoresUnderSightWordsTabAllFloorsSection(
					llData.teacherRoleLLStudentLastName, studentUnitAndFloorValues[0],
					llData.teacherRoleLLStudentSWBOTSScore, llData.teacherRoleLLStudentSWGamesPlayedCount);

			veifyFloorwiseScoreDetails(llData);
		}

		
		
		
		
	}

}

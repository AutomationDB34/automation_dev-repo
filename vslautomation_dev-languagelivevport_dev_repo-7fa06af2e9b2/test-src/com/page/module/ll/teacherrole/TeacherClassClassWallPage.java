package com.page.module.ll.teacherrole;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.locators.ll.teacherrole.TeacherClassClassWallLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.sun.xml.fastinfoset.algorithm.LongEncodingAlgorithm;

public class TeacherClassClassWallPage extends CommonFunctionalities implements TeacherClassClassWallLocators {

	private WebDriver driver;

	public TeacherClassClassWallPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose - To click on the Assignment tab(share) under Class wall page
	 */
	public void clickOnAssignmentTab() 
	{
		waitForPageToLoad();
		refresh();
		waitForPageToLoad();
		waitForSecs(10, "Waiting to Assignment Filter to load");
		isElementPresent(ASSIGNMENT_FILTER, LONGWAIT);
		safeClick(ASSIGNMENT_FILTER, LONGWAIT);
	}

	/**
	 * Purpose - To verify the navigation to Share Assignment tab section
	 */

	public void verifyThatAssignmentSectionIsLoaded() {
		Assert.assertTrue(isElementPresent(ASSIGNMENT_TITLE_TEXTFIELD, LONGWAIT),
				"Share Assignment tab section is not loaded even after clicking on Assginment tab");
	}

	/**
	 * Purpose- To add new assignment and verify the added one
	 * 
	 * @param assignmentTitle,
	 *            assignmentDesc, assignmentCredit, assignmentTimeInHours,
	 *            assignmentTimeInMinutes, assignmentAMPM
	 */

	public void addNewAssignmentAndVerify(String assignmentTitle, String assignmentDesc, String assignmentCredit,
			String assignmentTimeInHours, String assignmentTimeInMinutes, String assignmentAMPM) {
		safeClearAndType(ASSIGNMENT_TITLE_TEXTFIELD, assignmentTitle, LONGWAIT);
		safeClearAndType(ASSIGNMENT_DESC_TEXTFIELD, assignmentDesc, LONGWAIT);
		safeClick(CREDIT_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(CREDITDRP_OPTION, assignmentCredit), LONGWAIT);
		safeClick(ENDDATE_CALENDAR_ICON, LONGWAIT);
		Assert.assertTrue(isElementPresent(ENDDATE_PICKER_TABLE, LONGWAIT),
				"Assignment End Date date picker is not displayed under Class->Class Wall->Share Assignment section");
		nullifyImplicitWait();
		int precedingDaysCountFromCurrentDayInTheWeek = getLocatorCount(CURRENT_DATE_PREVIOUS_COLUMNS_COUNT);
		setImplicitWait(IMPLICITWAIT);
		String selectedDateDayName = safeGetText(Dynamic.getNewLocator(CURRENT_WEEK_DAY_NAME,
				Integer.toString((precedingDaysCountFromCurrentDayInTheWeek + 1))), LONGWAIT);

		switch (selectedDateDayName) {
		case "Su":

			selectedDateDayName = "Sunday";
			break;

		case "Mo":

			selectedDateDayName = "Monday";
			break;

		case "Tu":

			selectedDateDayName = "Tuesday";
			break;

		case "We":

			selectedDateDayName = "Wednesday";
			break;

		case "Th":

			selectedDateDayName = "Thursday";
			break;
		case "Fr":

			selectedDateDayName = "Friday";
			break;
		case "Sa":

			selectedDateDayName = "Saturday";
			break;
		}

		String currentMonthNameAndYear = safeGetText(CURRENT_MONTH_NAME, LONGWAIT);
		String currentMonthName = currentMonthNameAndYear.substring(0, currentMonthNameAndYear.length() - 4).trim();
		String selectedMonthDate = safeGetText(ENDDATE_PICKER_FIRST_VALID_DATE, LONGWAIT);
		safeClick(ENDDATE_PICKER_FIRST_VALID_DATE, LONGWAIT);
		safeClick(TIME_HOUR_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(TIME_HOURDRP_OPTION, assignmentTimeInHours), LONGWAIT);
		safeClick(TIME_MINUTE_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(TIME_MINUTEDRP_OPTION, assignmentTimeInMinutes), LONGWAIT);
		safeClick(TIME_AMPM_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(TIME_AMPMDRP_OPTION, assignmentAMPM), LONGWAIT);
		safeClick(ASSIGNMENT_SHARE_BTN, LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(ASSIGNMENT_POST_SECTION, LONGWAIT),
				"Assignments posted section is not displayed after clicking share button for the assignment with the title("
						+ assignmentTitle + ") under Class->Class Wall page");
		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(ASSIGNMENT_TITLE_POSTED_SECTION, assignmentTitle), LONGWAIT),
				"The added assignment with the title(" + assignmentTitle
						+ ") is not displayed under assignments posted section of Class Wall page");
		String actualCreditPointsDisplayedUnderPostedSection = safeGetText(
				Dynamic.getNewLocator(ASSIGNMENT_CREDITPOINTS_POSTED_SECTION, assignmentTitle), LONGWAIT);
		Assert.assertEquals(actualCreditPointsDisplayedUnderPostedSection.toLowerCase(), assignmentCredit.toLowerCase(),
				"Actual shared credit points (" + assignmentCredit + ") of the assignment(" + assignmentTitle
						+ ") doesn't match with the credit points(" + actualCreditPointsDisplayedUnderPostedSection
						+ ") displayed under posted section for the same assignment");
		String actualEndDateUnderPostedSection = safeGetText(
				Dynamic.getNewLocator(ASSIGNMENT_ENDDATE_POSTED_SECTION, assignmentTitle), LONGWAIT).trim();
		String expectedEndDateUnderPostedSection = assignmentTimeInHours + ":" + assignmentTimeInMinutes + " "
				+ assignmentAMPM + " on " + selectedDateDayName + ", " + currentMonthName + " " + selectedMonthDate;
		Assert.assertEquals(actualEndDateUnderPostedSection.toLowerCase(),
				expectedEndDateUnderPostedSection.toLowerCase(),
				"The actual shared end date(" + expectedEndDateUnderPostedSection + ") of the assignment("
						+ assignmentTitle + ") doesn't match with the end date(" + actualEndDateUnderPostedSection
						+ ") being displayed under assignments posted section for the same assignment");
	}

	public void verifyWallPostPaneisNotDisplayed() {
		if (isElementDisplayed(ALL_FILTER)) {
			safeClick(ALL_FILTER, LONGWAIT);
			Assert.assertTrue(!isElementDisplayed(WALLPOST_PANE),
					"Teacher is able to post in class wall as Wall post pane is displayed in 'Class'->'Class Wall' tab ");
		}
	}
}

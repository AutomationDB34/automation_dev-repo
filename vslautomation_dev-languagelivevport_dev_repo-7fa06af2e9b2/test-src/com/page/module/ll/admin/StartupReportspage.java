package com.page.module.ll.admin;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.admin.StartupReportsLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class StartupReportspage extends SafeActions implements StartupReportsLocators {

	WebDriver driver;

	public StartupReportspage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*
	 * Verifies start up reports page is loaded or not
	 */
	public void verifyStartupReportsHeading() 
	{
		
		isElementDisplayed(STARTUPREPORTS_HEADING);
		Assert.assertEquals(safeGetText(STARTUPREPORTS_HEADING, LONGWAIT), "Start Up Reports","Start Up Reports main heading is not displayed in Startup reports tab");

	}

	/*
	 * clicks in student sub tab
	 */
	public void clickStudentTab() {
		safeClick(STUDENT_SUBTAB, LONGWAIT);
	}

	/*
	 * Verifies student sub tab is loaded or not
	 */
	public void verifyStudentSubtab() {
		waitForSecs(5);
		isElementPresent(SUBTABS_HEADING,VERYLONGWAIT);
		Assert.assertEquals(safeGetText(SUBTABS_HEADING, LONGWAIT), "Student Participation","Student Participation  heading is not displayed in Startup reports->Student tab");
		boolean bStudentTabSelected = isElementPresent(STUDENTTAB_ISSELECTED);
		Assert.assertTrue(bStudentTabSelected, "Student sub tab is not highlighted in Startup reports tab");

	}
	/*
	 * Verifies Teacher sub tab is loaded or not
	 */

	public void verifyTeacherSubtab() {
		
		isElementPresent(SUBTABS_HEADING, VERYLONGWAIT);
		String txt = safeGetText(SUBTABS_HEADING, LONGWAIT);
		Assert.assertEquals(txt, "Teacher Participation","Teacher Participation  heading is not displayed in Startup reports->Student tab");
		boolean bTeacherTabSelected = isElementPresent(TEACHERTAB_ISSELECTED);
		Assert.assertTrue(bTeacherTabSelected, "Teacher sub tab is not highlighted in Startup reports tab");

	}
	/*
	 * verifies District total data in Start up reports->Teacher participation
	 * table by taking data from Dash board->teachers section for District user
	 */

	public void verifyTeacherParticipationforallSchoolsForDistUser(Map<String, String> teacherData) {
		List<WebElement> teacherParticiaptiontableRowHeadings = LocatorWebElements(TEACHERPARTICIAPTIONTABLECOLUMN_HEADINGS);
		List<WebElement> teacherParticiaptiontableRowValues = LocatorWebElements(TEACHERPARTICIPATIONTABLEROW_VALUESFORDISTUSER);
		for (int i = 1; i < teacherParticiaptiontableRowHeadings.size(); i++) {
			String str;
			String txt;
			String rowHeadingName = teacherParticiaptiontableRowHeadings.get(i).getText().toUpperCase().replaceAll("\n"," ");
			if (rowHeadingName.equalsIgnoreCase("LOGGED IN LAST WEEK")) {
				str = rowHeadingName.replace("LOGGED IN LAST WEEK", "LOGGED IN LAST 7 DAYS");
				txt = teacherData.get(str);
			}

			else if (rowHeadingName.equalsIgnoreCase("REVIEWED A WT GOAL")) {
				str = rowHeadingName.replace("REVIEWED A WT GOAL", "REVIEWED 1+ WORD TRAINING GOALS");
				txt = teacherData.get(str);

			} else if (rowHeadingName.equalsIgnoreCase("ASSIGNED A POWER PASS")) {
				str = rowHeadingName.replace("ASSIGNED A POWER PASS", "ASSIGNED 1+ POWER PASS QUIZZES");
				txt = teacherData.get(str);

			} else {
				txt = teacherData.get(rowHeadingName);
			}

			Assert.assertEquals(teacherParticiaptiontableRowValues.get(i).getText(), txt, "Not matched");

		}
	}
	/*
	 * verifies Campus total data in Start up reports->Teacher participation
	 * table by taking data from Dash board->teachers section for campus user
	 */

	public void verifyTeacherParticipationforallSchoolsForCampUser(Map<String, String> teacherData) {
		List<WebElement> teacherParticiaptiontableRowHeadings = LocatorWebElements(TEACHERPARTICIAPTIONTABLECOLUMN_HEADINGS);
		List<WebElement> teacherParticiaptiontableRowValues = LocatorWebElements(TEACHERPARTICIPATIONTABLEROW_VALUESFORCAMPUSER);
		for (int i = 1; i < teacherParticiaptiontableRowHeadings.size(); i++) {
			String str;
			String txt;
			String rowHeadingName = teacherParticiaptiontableRowHeadings.get(i).getText().toUpperCase().replaceAll("\n"," ");
			if (rowHeadingName.equalsIgnoreCase("LOGGED IN LAST WEEK")) {
				str = rowHeadingName.replace("LOGGED IN LAST WEEK", "LOGGED IN LAST 7 DAYS");
				txt = teacherData.get(str);
			}

			else if (rowHeadingName.equalsIgnoreCase("REVIEWED A WT GOAL")) {
				str = rowHeadingName.replace("REVIEWED A WT GOAL", "REVIEWED 1+ WORD TRAINING GOALS");
				txt = teacherData.get(str);

			} else if (rowHeadingName.equalsIgnoreCase("ASSIGNED A POWER PASS")) {
				str = rowHeadingName.replace("ASSIGNED A POWER PASS", "ASSIGNED 1+ POWER PASS QUIZZES");
				
				txt = teacherData.get(str);

			} else {
				txt = teacherData.get(rowHeadingName);
			}

			Assert.assertEquals(teacherParticiaptiontableRowValues.get(i).getText(), txt, "Not matched");

		}
	}
	/*
	 * verifies District total data in Start up reports->Student participation
	 * table by taking data from Dash board->teachers section for District user
	 */

	public void verifyStudentParticipationforallSchoolsforDistUser(String[] values) {
		List<WebElement> teacherParticiaptiontableRowHeadings = LocatorWebElements(TEACHERPARTICIAPTIONTABLECOLUMN_HEADINGS);
		List<WebElement> teacherParticiaptiontableRowValues = LocatorWebElements(TEACHERPARTICIPATIONTABLEROW_VALUESFORDISTUSER);
		for (int i = 1; i < teacherParticiaptiontableRowHeadings.size(); i++)

		{
			Assert.assertEquals(teacherParticiaptiontableRowValues.get(i).getText(), values[i], "Not matched");

		}
	}

	/*
	 * verifies Campus total data in Start up reports->Student participation
	 * table by taking data from Dash board->teachers section for campus user
	 */
	public void verifyStudentParticipationforallSchoolsforCampUser(String[] values) {
		List<WebElement> studentParticiaptiontableRowHeadings = LocatorWebElements(TEACHERPARTICIAPTIONTABLECOLUMN_HEADINGS);
		List<WebElement> studentParticiaptiontableRowValues = LocatorWebElements(STUDENTPARTICIPATIONTABLEROW_VALUESFORCAMPUSER);
		for (int i = 1; i < studentParticiaptiontableRowValues.size(); i++)

		{
			
			Assert.assertEquals(studentParticiaptiontableRowValues.get(i).getText(), values[i - 1], "Not matched");

		}
	}
}

package com.page.module.ll.admin;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.ClassMatesLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class ClassMatesPage extends CommonFunctionalities implements ClassMatesLocators {

	WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public ClassMatesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyClassMatesPageLoaded() {
		isElementPresent(CLASSMATESPAGE_HEADING, LONGWAIT);
		Assert.assertTrue(isElementPresent(CLASSMATESPAGE_HEADING, LONGWAIT),
				"Class Mates page heading is not displayed on clicking 'Classess'->'Class Mates'");

	}

	/**
	 * Selects Class from Classes sub tab
	 * 
	 * @param className
	 */
	public void selectClassFromClassDropdown(String className) {
		waitForSecs(4);
		safeJavaScriptClick(CLASSSELECTOR_DRPDWN, LONGWAIT);
		waitForSecs(6);
		safeJavaScriptClick(Dynamic.getNewLocator(CLASSSNAMEIN_CLASSSELECTOR_DRPDWN, className), LONGWAIT);
	}

	/**
	 * verifies Teacher name in Teacher pane of classmates page
	 * 
	 * @param teacherName
	 */

	public void verifyTeacherinClassMates(String teacherName) {
		isElementDisplayed(Dynamic.getNewLocator(TEACHER_NAME, teacherName));
	}

	/**
	 * Verifies student count in Student pane by comparing the count read from  Roster page

	 * @param studentCountFromRoster
	 */
	public void verifyStudentsCountinClassMatesTab(int studentCountFromRoster) {
		isElementPresent(STUDENTS_COUNT,LONGWAIT);
		int studentCountInClassmates = LocatorWebElements(STUDENTS_COUNT).size();
		Assert.assertEquals(studentCountInClassmates, studentCountFromRoster,
				"Students Count in 'Classes'->'Classmates' tab is not matched with the Student count read from Tools->Roster tab  ");
	}
	/**
	 *  Verifies student names  in Student pane by comparing the names read from  Roster page
	 * @param studentLastNamesFromtRoster
	 */
	public void verifyStudentNamesinClassMatesTab(String[] studentLastNamesFromtRoster) {
		setImplicitWait(LONGWAIT);
		int size = studentLastNamesFromtRoster.length;
		int sucessSize = 0;
		for (int i =0;i < size;i++)
		{
			if(isElementPresent(Dynamic.getNewLocator(STUDENT_NAME_IN_CLASSMATE_PAGE,studentLastNamesFromtRoster[i]), MEDIUMWAIT))
			{
				log.info("Veriffication Completed for "+ studentLastNamesFromtRoster[i]);
				scrollIntoElementView(Dynamic.getNewLocator(STUDENT_NAME_IN_CLASSMATE_PAGE,studentLastNamesFromtRoster[i]));
				setHighlight(driver.findElement(Dynamic.getNewLocator(STUDENT_NAME_IN_CLASSMATE_PAGE,studentLastNamesFromtRoster[i])));
				sucessSize = i;
			}
			else
			{
				log.info("The Verification is Failed in Classmates");
				break;
			}
		}
		Assert.assertEquals((sucessSize+1), size,"Classmates and Roster details not as expected");
	}
	/**
	 * Clicks on student name and verifies the profile of student 
	 * @param studentLastName
	 */
	public void verifyProfileOfStudent(String studentLastName) {
		setImplicitWait(LONGWAIT);
		waitForSecs(7);
		safeClick(Dynamic.getNewLocator(STUDENT_NAME, studentLastName), LONGWAIT);
		waitForSecs(7);
		isElementDisplayed(USERPROFILEABOUT_TAB);
		Assert.assertEquals(safeGetText(USERPROFILEABOUT_TAB, LONGWAIT), studentLastName, "On clicking student name"
				+ studentLastName + "in ClassMates tab ,Student name is displayed wrong in Profile Page ");
		Assert.assertEquals(safeGetText(USERPROFILE_NAME, LONGWAIT), studentLastName, "On clicking student name"
				+ studentLastName + "in ClassMates tab ,Student name is displayed wrong in Profile Page ");

	}
}

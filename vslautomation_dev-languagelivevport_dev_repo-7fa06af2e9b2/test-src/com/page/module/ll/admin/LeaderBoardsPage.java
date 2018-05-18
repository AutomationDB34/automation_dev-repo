package com.page.module.ll.admin;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.admin.ClassWallLocators;
import com.page.locators.ll.admin.LeaderBoardsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class LeaderBoardsPage extends CommonFunctionalities implements LeaderBoardsLocators {

	WebDriver driver;

	public LeaderBoardsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Purpose- To verify that leader boards page is loaded successfully
	 */

	public void verifyThatLeaderBoardsPageIsLoaded() {
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(LEADERBOARDSTAB_SELECTED, LONGWAIT),
				"Class->LeaderBoards  tab is not displayed as selected even after clicking on it");
		Assert.assertTrue(isElementPresent(LEADERBOARDS_FOOTER_SECTION, LONGWAIT),
				"Class->LeaderBoards page is not loaded");
	}

	/**
	 * Selects Class from Classes drop down 
	 * 
	 * @param className
	 */
	public void selectClassFromClassDropdown(String className) {
		waitForPageToLoad();
		waitForSecs(20);
	/*	if(!isElementPresent(CLASSSELECTOR_DRPDWN, MEDIUMWAIT));
		{
			refresh();
			waitForPageToLoad();
			waitForSecs(10);
			safeClick(Dynamic.getNewLocator(ClassWallLocators.CLASSES_SUBHEADINGS, "Leaderboards"),LONGWAIT);
			waitForSecs(10);
		}*/
		safeClick(CLASSSELECTOR_DRPDWN, LONGWAIT);
		safeClick(Dynamic.getNewLocator(CLASSSNAMEIN_CLASSSELECTOR_DRPDWN, className), LONGWAIT);
	}
	/**
	 * Clicks on Course Points tab and verifies whether it is loaded or not 
	 */
	public void clickCoursePointsTabAndVerify() {
		waitForSecs(20, "Explicit Waiting for page to load");
		waitForPageToLoad(VERYLONGWAIT);
		safeClick(COURSEPOINTS_TAB);
		Assert.assertEquals(safeGetText(COURSEPOINTS_HEADING, LONGWAIT), "Course Points",
				"Course Points heading is displayed wrong on clciking 'Leader Boards'->'Course Points' tabs ");
	}
	/**
	 * Clicks on Year Sub tab and verifies whether it is loaded or not 
	 */
	public void clickYearSubtabAndVerify() {
		waitForSecs(3);
		safeClick(Dynamic.getNewLocator(COURSEPOINTS_SUBTABS, "Year"));
		Assert.assertEquals(safeGetText(COURSEPOINTS_HEADING, LONGWAIT), "Course Points",
				"Course Points heading is displayed wrong on clciking 'Leader Boards'->'Course Points'->Year sub tab ");
		Assert.assertEquals(safeGetText(YEARSUBTAB_HEADING, LONGWAIT), "for the school year",
				"Year sub tab heading is not matched in Leader Boards->Course points->year page ");
		waitForPageToLoad();
	}

	/**
	 * Verifies Course points displayed for a student in Year sub tab by comparing the course points read from Student profile
	 * @param studentName
	 * @param coursePointsfromStudentProfile
	 */
	public void verifyCoursePointsForStudentInYearTab(String studentName, String coursePointsfromStudentProfile) {
		String coursePointsInLeaderBaords = safeGetText(
				Dynamic.getNewLocator(STUDENT_COURSEPOINTSCOUNT_RANKTABLE, studentName), LONGWAIT);
		Assert.assertEquals(coursePointsInLeaderBaords, coursePointsfromStudentProfile, "Course Points for a student"
				+ studentName
				+ " displayed in Leader Board page  is not matched with the course points read from Student profile page ");
	}
	
	/**
	 * clicks on Achievements and verifies whether it is loaded or not 
	 */
	public void clickAchievementsTabAndVerify() {
		safeClick(ACHIEVEMENTS_TAB);
		Assert.assertEquals(safeGetText(ACHIEVEMENTS_HEADING, LONGWAIT), "Achievements",
				"Achievements heading is displayed wrong on clciking 'Leader Boards'->Achievements tab ");
	}
	
	/**
	 * Verifies Achievements displayed for a student in Year sub tab by comparing the Achievements read from Student profile
	 * @param studentName
	 * @param coursePointsfromStudentProfile
	 */


	public void VerifyAchievementsForStudentInYear(String studentName, String acheivementsCountFromStudentProfile) {
		safeClick(Dynamic.getNewLocator(ACHEIVEMENTS_SUBTABS, "Year"));
		Assert.assertEquals(safeGetText(ACHIEVEMENTS_HEADING, LONGWAIT), "Achievements",
				"Achievements heading is displayed wrong on clciking 'Leader Boards'->'Course Points'->Year sub tab ");
		Assert.assertEquals(safeGetText(YEARSUBTAB_HEADING, LONGWAIT), "for the school year",
				"Year sub tab heading is not matched in Leader Boards->Acheivements->year page ");
		String acheivementsCountInLeaderBaords = safeGetText(
				Dynamic.getNewLocator(STUDENT_ACHEIVEMENTSCOUNT_RANKTABLE, studentName), LONGWAIT);
		Assert.assertEquals(acheivementsCountInLeaderBaords, acheivementsCountFromStudentProfile,
				"Acheivements Points for a student" + studentName
						+ " displayed in Leader Board page  is not matched with the acheivements points read from Student profile page ");
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

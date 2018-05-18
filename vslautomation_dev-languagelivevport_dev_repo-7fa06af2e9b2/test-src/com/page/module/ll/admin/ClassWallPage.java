package com.page.module.ll.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.admin.ClassWallLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class ClassWallPage extends CommonFunctionalities implements ClassWallLocators{

	WebDriver driver;
	public ClassWallPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/**
	 * Verifies Class wall page is loaded 
	 */
	public void verifyClassWallPageLoaded()
	{
		isElementPresent(CLASSWALL_HEADING,LONGWAIT);
		Assert.assertTrue(isElementPresent(CLASSWALL_HEADING,LONGWAIT), "Class Wall page heading is not displayed on clicking 'Classess'->'Class Wall'");
	}
	/**
	 * To clicks on Class Mates tab 
	 */
	public ClassMatesPage clickClassMatesTab()
	{
		waitForSecs(10, "Explicit Wait for Page To load");
		//waitForPageToLoad(VERYLONGWAIT);
		safeClick(Dynamic.getNewLocator(CLASSES_SUBHEADINGS, "Classmates"),LONGWAIT);
		return new ClassMatesPage(driver);
	} 
	/**
	 * To clicks on Leader Boards tab 
	 */
	public LeaderBoardsPage clickLeaderBoardsTab()
	{
		waitForSecs(20, "Explicit Wait for Page To load");
		//waitForPageToLoad(VERYLONGWAIT);
	
		safeClick(Dynamic.getNewLocator(CLASSES_SUBHEADINGS, "Leaderboards"),LONGWAIT);
		waitForPageToLoad();
		return new LeaderBoardsPage(driver);
	} 


	/**
	 * clicks on All sub tab in Classses tab
	 */
	public void clickAllSubTab()
	{
		safeClick(ALL_TAB,LONGWAIT);
	}
	/**
	 * Clicks on Assignments sub tab in Classses tab
	 */
	public void clickAssignmentSubTab()
	{
		safeClick(ASSIGNMENTS_TAB,LONGWAIT);
	}

	/**
	 * Selects Class from Classes sub tab 
	 * @param className
	 */
	public void selectClassFromClassDropdown(String className)
	{
		waitForSecs(6);
		safeActionsClick(CLASSSELECTOR_DRPDWN,LONGWAIT);
		safeClick(Dynamic.getNewLocator(CLASSSNAMEIN_CLASSSELECTOR_DRPDWN, className),LONGWAIT);
		waitForSecs(3, "Waiting to page to load");
	}
	/**
	 * Enter Description into wall field and post into Classwall 
	 * @param text
	 */

	public void enterTextIntoClassWallFieldAndShare(String text)
	{
		waitForSecs(4, "Waiting to Load the Description box");
		safeType(DESCRIPTION_TEXTAREA,text);
		safeClick(SHAREINALLTAB_BTN);
	}
	/**
	 * verifies the description posted in classwall 
	 * @param postedDescription
	 */
	public void verifyWallPostDataSubmitted(String postedDescription)
	{
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(CLASSWALL_DESCRIPTION_POSTED,postedDescription), LONGWAIT), "The added post in class wall with the text("+postedDescription+") is not displayed under All posted section of Class Wall page");
	}
	/**
	 * Verifies Class wall posts are not displaying in Assignment Sub tab
	 */
	public void verifyClassWallPostsNotDisplayedInAssigmentTab()
	{
		Assert.assertTrue(!isElementDisplayed(CLASSWALLPOSTS_PANES),"Class Wall posts are displayed in Assessment tab of ClassWall page");
	}
	/**
	 * Verifies the Posted Assessments are displayed in Assignments tab 
	 * @param teacherName
	 * @param assignmentTitle
	 */

	public void verifyAssignmentsDisplayed(String teacherName,String assignmentTitle)
	{
		Assert.haultonfailure=false;
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_POSTED_PANES,LONGWAIT), "Assignments Posts are not displayed in Assignments tab in ClassWall page ");
		Assert.assertTrue(isElementPresent(ASSIGNMENT_HEADER,LONGWAIT),"Assignment Header with the name 'Assignment' is not displayed in ClassWall page->Assignment tab" );
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ASSIGNMENT_POSTED_USERNAME, teacherName),LONGWAIT), "The Added Assignment  user name "+teacherName+"is not displayed under  Assignemnt posted section in ClassWall page->Assignment tab ");
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ASSIGNMENT_TITLE_POSTED_SECTION, assignmentTitle), LONGWAIT), "The added assignment with the title("+assignmentTitle+") is not displayed under assignments  of Class Wall page");
		Assert.assertAll();
	}

}

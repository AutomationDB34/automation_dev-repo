package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherClassClassResourcesLocators;
import com.page.locators.ll.teacherrole.TeacherRoleClassPageLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleClassPage extends SafeActions implements TeacherRoleClassPageLocators {

	private WebDriver driver;
	
	public TeacherRoleClassPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose - To verify that Class page is loaded
	 */
	
	public void verifyThatClassPageIsLoaded()
	{
		Assert.assertTrue(isElementPresent(CLASSWALLTAB_SELECTED, LONGWAIT), "Class page is not loaded after clicking Class tab");
		Assert.assertTrue(isElementPresent(CLASSWALLTAB_SECTION, LONGWAIT), "CLass->ClassWall tab page is not loaded after clicking Class tab");		
		waitForPageToLoad();
	}
	
	/**
	 * Purpose- To verify that Class page is displayed with all tabs and their icons
	 */
	
	public TeacherClassClassWallPage verifyThatClassTabIsLoadedWithAllTabsAndIcons()
	{
		
		Assert.assertTrue(isElementPresent(CLASSWALL_TAB, LONGWAIT), "ClassWall tab is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(CLASSMATESTAB_ICON, LONGWAIT), "ClassWall tab icon is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(CLASSMATES_TAB, LONGWAIT), "Classmates tab is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(CLASSMATESTAB_ICON, LONGWAIT), "Classmates tab icon is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(CLASSRESOURCES_TAB, LONGWAIT), "ClassResources tab is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(CLASSRESOURCES_ICON, LONGWAIT), "ClassResources tab icon is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(READINGSCAPE_TAB, LONGWAIT), "ReadingScape tab is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(READINGSCAPETAB_ICON, LONGWAIT), "ReadingScape tab icon is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(EBOOKS_TAB, LONGWAIT), "eBooks tab is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(EBOOKSTAB_ICON, LONGWAIT), "eBooks tab icon is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(LEADERBOARDS_TAB, LONGWAIT), "LeaderBoards tab is not displayed under Class tab");
		Assert.assertTrue(isElementPresent(LEADERBOARDSTAB_ICON, LONGWAIT), "LeaderBoards tab icon is not displayed under Class tab");
		
		return new TeacherClassClassWallPage(driver);
	}
	
	/**
	 * Purpose - To click on Classmates tab
	 */
	
	public TeacherClassClassmatesPage clickOnClassmatesTab()
	{
		safeClick(CLASSMATES_TAB, LONGWAIT);
		
		return new TeacherClassClassmatesPage(driver);
	}
	
	
	/**
	 * Purpose - To click on ReadingScape tab
	 */
	
	public TeacherClassReadingScapePage clickOnReadingScapeTab()
	{
		safeJavaScriptClick(READINGSCAPE_TAB, LONGWAIT);
		//waitForPageToLoad(VERYLONGWAIT);
		return new TeacherClassReadingScapePage(driver);
	}
	
	/**
	 * Purpose - To click on eBooks tab
	 */
	
	public TeacherClassEbooksPage clickOnEBooksTab()
	{
		safeClick(EBOOKS_TAB, LONGWAIT);
		
		return new TeacherClassEbooksPage(driver);
	}
	
	/**
	 * Purpose - To click on Class Resources tab
	 */
	
	public TeacherClassClassResourcesPage clickOnClassResourcesTab()
	{
		safeClick(CLASSRESOURCES_TAB, LONGWAIT);
		
		return new TeacherClassClassResourcesPage(driver);
	}
	
	/**
	 * Purpose - To click on Leaderboards tab
	 */
	
	public TeacherClassLeaderboardsPage clickOnLeaderboardsTab()
	{
		safeClick(LEADERBOARDS_TAB, LONGWAIT);
		
		return new TeacherClassLeaderboardsPage(driver);
	}
	
	/**
	 * Purpose - To click on assignments tab in calss wall
	 */
	
	public TeacherClassClassWallPage clickOnAssignmentTabInClsasWall()
	{
		waitForSecs(10, "Waiting for page to load");
		//waitForPageToLoad();
		isElementPresent(ASSIGNMENT_FILTER, LONGWAIT);
		safeClick(ASSIGNMENT_FILTER, LONGWAIT);
		return new TeacherClassClassWallPage(driver);
	}
}

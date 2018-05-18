package com.page.module.ll.level1activities;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level1activites.TeacherHomePageLocators;
import com.page.module.ll.level1activities.LLLoginPage.LLLoginReturnPage;
import com.page.module.ll.teacherrole.TeacherRoleClassPage;
import com.page.module.ll.teacherrole.TeacherRoleCoursePage;
import com.page.module.ll.teacherrole.TeacherRoleDictionaryPage;
import com.page.module.ll.teacherrole.TeacherRoleMicrophoneTestPage;
import com.page.module.ll.teacherrole.TeacherRoleNotificationsPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherRoleViewProfilePage;
import com.page.module.ll.teacherrole.TeacherToolsReviewPage;
import com.page.module.ll.teacherrole.TeacherWelComePage;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherHomePage extends SafeActions implements TeacherHomePageLocators{

	private WebDriver driver;
	
	public TeacherHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	/**
	 * Purpose- To verify teacher login
	 */
	public void verifyTeacherLogin()
	 {
		waitForSecs(10,"Waiting to Teacher Home Page");
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(REPORTSTAB_SELECTED, LONGWAIT), "Reports page is not loaded after teacher is logged in");
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT), "Reports->Dashboard page is not loaded after teacher is logged in");		
		waitForPageToLoad();
	 }
	
	/**
	 * Purpose- To click on tools tab
	 * @return 
	 */	
		public Object clickOnToolsTab(LLToolsTabReturnPage llToolsTabReturnPage )
		{
		safeClick(TOOLS_TAB, LONGWAIT);		
		
		switch (llToolsTabReturnPage) {
		case STUDENT_CREATION_PAGE:
			return new StudentCreation(driver);
		case TEACHER_ROLE_TOOLS_PAGE:
			return new TeacherRoleToolsPage(driver);
		default:
			return null;
		}
		
		}
		
		public enum LLToolsTabReturnPage{STUDENT_CREATION_PAGE,TEACHER_ROLE_TOOLS_PAGE};
	 
	 
	 /**
	  * Purpose- To verify navigation to tools tab page
	  */
	 
	 public void verifyToolsTab()
	 {
	  Assert.assertTrue(isElementPresent(TOOLSPAGEREVIEWSLEGEND_TABLE, LONGWAIT), "Tools tab page is not displayed");
	 }
	 
	 /**
	  * Purpose- To verify new teacher login
	  */
	 
	 public void verifyNewTeacherLogin()
	 {
		 Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_NOSTUDENTS_SECTION, LONGWAIT),"New Teacher user is not logged in successfully");
	 }
	 
	 /**
	  * Purpose- To verify that teacher welcome page is not displayed second time
	  */
	 
	 public void verifyWelComePageNotDisplayedSecondTime()
	 {
		 Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_NOSTUDENTS_SECTION, LONGWAIT),"Teacher user is not taken to home page when second time logged in. Welcome page might have been displayed again second time");
	 }
	 
	 /**
	  * Purpose - To click on Course tab link
	  */
	 
	 public TeacherRoleCoursePage clickOnCourseTab()
	 {
		 safeClick(COURSE_TAB, LONGWAIT);
		 
		 return new TeacherRoleCoursePage(driver);
	 }
	 
	 /**
	  * Purpose - To click on Class tab link
	  */
	 
	 public TeacherRoleClassPage clickOnClassTab()
	 {
		 safeClick(CLASS_TAB, LONGWAIT);
		 
		 return new TeacherRoleClassPage(driver);
	 }
	 
	 /**
	  * Purpose - To click on Notifications tab or link
	  */
	 
	 public TeacherRoleNotificationsPage clickOnNotificationsTab()
	 {
		 safeClick(NOTIFICATIONS_TAB, LONGWAIT);
		 
		 return new TeacherRoleNotificationsPage(driver);
	 }
	 
	 /**
	  * Purpose - Click View Profile link under User Menu
	  */
	 
	 public TeacherRoleViewProfilePage clickUsermenuViewProfileLink()
	 {
		 waitForSecs(10);
		// safeClick(USER_DROPDOWN, LONGWAIT);
		 mouseHover(USER_DROPDOWN, LONGWAIT);
		 safeClick(USER_DROPDOWN, LONGWAIT);
		 waitForPageToLoad();
		 waitForSecs(10);
		 safeClick(VIEW_PROFILE_LINK, LONGWAIT);
		 waitForPageToLoad();
		 waitForSecs(10);
		 return new TeacherRoleViewProfilePage(driver);
	 }
	 /**
	  * Purpose - To click Dictionary link under User Menu
	  */
	 public TeacherRoleDictionaryPage clickUsermenuDictionaryLink()
	 {
		 safeClick(USER_DROPDOWN, LONGWAIT);
		 safeClick(DICTIONARY_LINK, LONGWAIT);		 
		 return new TeacherRoleDictionaryPage(driver);
	 }
	 
		/**
		 * Purpose- To verify teacher home page
		 */
		public void verifyTeacherHomePage()
		 {
			Assert.assertTrue(isElementPresent(REPORTSTAB_SELECTED, LONGWAIT), "Reports page is not loaded after teacher is logged in");
			Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT), "Reports->Dashboard page is not loaded after teacher is logged in");		
			waitForPageToLoad();
		 }
		
		 /**
		  * Purpose - To click Check Mic link under User Menu
		  */
		 public TeacherRoleMicrophoneTestPage clickUsermenuCheckMicLink()
		 {
			 safeClick(USER_DROPDOWN, LONGWAIT);
			 safeClick(CHECKMIC_LINK, LONGWAIT);		 
			 return new TeacherRoleMicrophoneTestPage(driver);
		 }
		 public TeacherRoleToolsPage navigateToToolPage() {

				safeClick(TOOLS_TAB);
				return new TeacherRoleToolsPage(driver);
			}
}

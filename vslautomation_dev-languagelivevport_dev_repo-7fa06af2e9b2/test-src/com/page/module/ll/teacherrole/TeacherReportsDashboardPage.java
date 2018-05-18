package com.page.module.ll.teacherrole;
import org.openqa.selenium.WebDriver;

import com.page.locators.ll.teacherrole.TeacherReportsDashboardPageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherReportsDashboardPage extends CommonFunctionalities implements TeacherReportsDashboardPageLocators{

	private WebDriver driver;
	
	public TeacherReportsDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
		
	/**
	 * Purpose- To Select class from class drop down under Reports->Dash board section
	 * @param className
	 */
	public void selectClassFromClassDropdown(String className)
	{
		safeClick(LEVELS_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(LEVELSDRP_OPTION, className), LONGWAIT);		
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT), "Reports->Dashboard student table is not loaded after selecting the class");
	}
	
	/**
	 * Purpose- To verify a student progress under the selected class
	 * @param studentLastName,wordTrainingLevelAndUnitProgress,wordTrainingLessonProgress
	 */
	public void verifyStudentProgressUnderTheSelectedClass(String studentLastName,String wordTrainingLevelAndUnitProgress, String wordTrainingLessonProgress)
	{
		String actualWTLevelAndUnitValueOfTheStudent = safeGetText(Dynamic.getNewLocator(WORDTRAININGSTATUSFIRST_TEXT, studentLastName), LONGWAIT);
		
		Assert.assertEquals(actualWTLevelAndUnitValueOfTheStudent.toLowerCase(),wordTrainingLevelAndUnitProgress.toLowerCase(),"The expected student level and unit progress value("+wordTrainingLevelAndUnitProgress+") doesn't match with actual level and unit value("+actualWTLevelAndUnitValueOfTheStudent+")");
		
		String actualWTLessonProgressValueOfTheStudent = safeGetText(Dynamic.getNewLocator(WORDTRAININGSTATUSSECOND_TEXT, studentLastName), LONGWAIT);
				
		Assert.assertEquals(actualWTLessonProgressValueOfTheStudent.toLowerCase(),wordTrainingLessonProgress.toLowerCase(),"The expected student lesson progress value("+wordTrainingLessonProgress+") doesn't match with actual lesson value("+actualWTLessonProgressValueOfTheStudent+")");
	}
	
	/**
	 * Purpose- To click on Reviews tab under Dash board
	 */
	
	public void clickOnReviewsTabUnderDashboard()
	{
		safeClick(DASHBOARD_REVIEW_TAB,LONGWAIT);
	}
	
	/**
	 * Purpose- To verify that by default Reviews tab is highlighted under 'Review' page
	 */
	
	public void verifyReviewsTabIsHighlighted()
	{
		Assert.assertTrue(isElementPresent(REVIEW_REVIEWS_TABLE, LONGWAIT), "Review->Reviews page is not loaded after clicking Review tab under Dashboard section");
		Assert.assertTrue(isElementPresent(REVIEW_REVIEWSSELECTED_TAB, LONGWAIT), "Reviews tab is not highlighted on the navigated 'Review'page when clicked Review Tab under Dashboard section");
		safeClick(REPORTS_TAB, LONGWAIT);
	}
	
	/**
	 * Purpose- To click on Reviews tab under Dash board
	 */
	
	public void clickOnCourseAlertsUnderDashboard()
	{
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT), "Reports->Dashboard student table is not loaded after clicking Reports tab from Review->Reviews page");
		safeClick(DASHBOARD_COURSEALERTS_TAB,LONGWAIT);
	}
	
	/**
	 * Purpose- To verify that by default Alerts tab is highlighted under 'Review' page
	 */
	
	public void verifyAlertsTabIsHighlighted()
	{
		Assert.assertTrue(isElementPresent(REVIEW_ALERTS_TABLE, LONGWAIT), "Review->Alerts page is not loaded after clicking Course Alerts tab under Dashboard section");
		Assert.assertTrue(isElementPresent(REVIEW_ALERTSSELECTED_TAB, LONGWAIT), "Alerts tab is not highlighted on the navigated 'Review'page when clicked Course Alerts Tab under Dashboard section");
		safeClick(REPORTS_TAB, LONGWAIT);
	}
	
	/**Purpose- To verify Time On Task tab  
	 */
	
	public void verifyTimeOnTaskTabUnderDashboard()
	{
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT), "Reports->Dashboard student table is not loaded after clicking Reports tab from Review->Alerts page");
		int timeOnTaskTabStudentCount = Integer.parseInt(safeGetText(DASHBOARD_TIMEONTASKTAB_COUNT, LONGWAIT));
		if(timeOnTaskTabStudentCount!=0)
		{
		safeClick(DASHBOARD_TIMEONTASK_TAB,LONGWAIT);
		Assert.assertTrue(isElementPresent(DASHBOARD_TIMEONTASKPOPUP_HEADER, LONGWAIT), "Time on Task popup is not displayed");
		int timeOnTaskPopUpStudentCount = getLocatorCount(DASHBOARD_TIMEONTASKPOPUPSTUDENT_COUNT);
		Assert.assertEquals(timeOnTaskTabStudentCount, timeOnTaskPopUpStudentCount, "The time on task tab student count("+timeOnTaskTabStudentCount+") doesn't match with the student count("+timeOnTaskPopUpStudentCount+") displayed on it's popup");		
		refresh();
		waitForPageToLoad();
		}
	}
	
	
	/**Purpose- To verify Items Completed tab  
	 */
	
	public void verifyItemsCompletedTabUnderDashboard()
	{
		Assert.assertTrue(isElementPresent(REPORTS_DASHBOARD_STUDENT_TABLE, LONGWAIT), "Reports->Dashboard student table is not loaded after closing time on task popup");
		int itemsCompletedTabStudentCount = Integer.parseInt(safeGetText(DASHBOARD_ITEMSCOMPLETEDTAB_COUNT, LONGWAIT));
		if(itemsCompletedTabStudentCount!=0)
		{
		safeClick(DASHBOARD_ITEMSCOMPLETED_TAB,LONGWAIT);
		Assert.assertTrue(isElementPresent(DASHBOARD_ITEMSCOMPLETEDPOPUP_HEADER, LONGWAIT), "Time on Task popup is not displayed");
		int itemsCompletedPopUpStudentCount = getLocatorCount(DASHBOARD_ITEMSCOMPLETEDPOPUPSTUDENT_COUNT);
		Assert.assertEquals(itemsCompletedTabStudentCount, itemsCompletedPopUpStudentCount, "The items completed ask tab student count("+itemsCompletedTabStudentCount+") doesn't match with the student count("+itemsCompletedPopUpStudentCount+") displayed on it's popup");
		refresh();
		waitForPageToLoad();			
		}
	}
}

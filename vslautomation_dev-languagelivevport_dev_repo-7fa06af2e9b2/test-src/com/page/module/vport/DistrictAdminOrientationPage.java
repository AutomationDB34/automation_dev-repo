package com.page.module.vport;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.DistrictAdminOrientationLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictAdminOrientationPage extends SafeActions implements DistrictAdminOrientationLocators {

	private WebDriver driver;
	
	public DistrictAdminOrientationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;;
		
	}
	
	/*  
	 * Purpose of this method is to check whether the District Admin orientation page are loaded or not
	 * */
	public void verifyOrientationPage(){
		
		boolean continuebtnExists = isElementPresent(CONTINUE_BTN,MEDIUMWAIT);
		Assert.assertTrue(continuebtnExists,"Continue button is not displayed in the orientation setup page ");	
		
	}

	/*  
	 * Purpose of this method is to verify the orientation pages and continue through the pages
	 * */
	public MyDistrictPage orientatonpages(){
		
		safeClick(CONTINUE_BTN, MEDIUMWAIT);
		boolean pacingCalendarexists = isElementPresent(PACING_CALENDER,MEDIUMWAIT);
		Assert.assertTrue(pacingCalendarexists,"Pacing calendar page is not displayed in the orientation setup page ");	
		safeClick(PACING_PAGE_CONTINUE, MEDIUMWAIT);
		safeClick(PACING_PAGE_CONFIRM, MEDIUMWAIT);
		
		boolean benchmarkdatesexists = isElementPresent(BENCHMARK_DATES,MEDIUMWAIT);
		Assert.assertTrue(benchmarkdatesexists,"Benchmark dates page is not displayed in the orientation setup page ");	
		safeClick(BENCHMARK_CONTINUE, MEDIUMWAIT);
		
		boolean rtiPlansexists = isElementPresent(RTI_PLAN,MEDIUMWAIT);
		Assert.assertTrue(rtiPlansexists,"RTI Plans page is not displayed in the orientation setup page ");	
		safeClick(RTI_PLAN_CONTINUE, MEDIUMWAIT);
		
		boolean activeSchoolsexists = isElementPresent(ACTIVATE_SCHOOLS,MEDIUMWAIT);
		Assert.assertTrue(activeSchoolsexists,"ACtivate schools page is not displayed in the orientation setup page ");	
		safeClick(ACTIVATE_SCHOOLS_CONTINUE, MEDIUMWAIT);
		
		boolean addSchoolusersexists = isElementPresent(ADD_SCHOOL_USERS,MEDIUMWAIT);
		Assert.assertTrue(addSchoolusersexists,"Add school users page is not displayed in the orientation setup page ");	
		safeClick(ADD_SCHOOL_USERS_CONTINUE, MEDIUMWAIT);
		
		boolean addStudentsexists = isElementPresent(ADD_STUDENTS,MEDIUMWAIT);
		Assert.assertTrue(addStudentsexists,"Add students page is not displayed in the orientation setup page ");	
		safeClick(ADD_STUDENTS_CONTINUE, MEDIUMWAIT);
		
		boolean assignLicensesexists = isElementPresent(ASSIGN_LICENSES,MEDIUMWAIT);
		Assert.assertTrue(assignLicensesexists,"Assign Licenses page is not displayed in the orientation setup page ");	
		safeClick(ASSIGN_LICENSES_FINISHED, MEDIUMWAIT);
		
		return new MyDistrictPage(driver);
		
	}
	
}

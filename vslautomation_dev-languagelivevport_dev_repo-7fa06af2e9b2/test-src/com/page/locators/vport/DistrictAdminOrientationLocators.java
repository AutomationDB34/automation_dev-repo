package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictAdminOrientationLocators {
	
	public static By CONTINUE_BTN = By.id("save_changes1");
	
	public static By PACING_CALENDER = By.xpath("//img[@src='/vip/assets/images/vportSetup/pacingCalendarSideImage.png']");
	public static By PACING_PAGE_CONTINUE = By.xpath("//input[@src='/vip/assets/images/buttons/blue_continue_button.gif']");
	public static By PACING_PAGE_CONFIRM = By.id("confirmButton");
	
	public static By BENCHMARK_DATES = By.xpath("//img[@src='/vip/assets/images/vportSetup/benchmarkDatesSideImage.png']");
	public static By BENCHMARK_CONTINUE = By.xpath("//input[@src='/vip/assets/images/buttons/blue_continue_button.gif']");
	
	public static By RTI_PLAN = By.xpath("//img[@src='/vip/assets/images/vportSetup/rtiSideImage.png']");
	public static By RTI_PLAN_CONTINUE = By.xpath("//input[@src='/vip/assets/images/buttons/blue_continue_button.gif']");
	
	public static By ACTIVATE_SCHOOLS = By.xpath("//img[@src='/vip/assets/images/vportSetup/activateSideImage.png']");
	public static By ACTIVATE_SCHOOLS_CONTINUE = By.xpath("//input[@src='/vip/assets/images/buttons/blue_continue_button.gif']");
	
	public static By ADD_SCHOOL_USERS = By.xpath("//img[@src='/vip/assets/images/vportSetup/addSchoolSideImage.png']");
	public static By ADD_SCHOOL_USERS_CONTINUE = By.xpath("//input[@src='/vip/assets/images/buttons/blue_continue_button.gif']");
	
	public static By ADD_STUDENTS = By.xpath("//img[@src='/vip/assets/images/vportSetup/addStudentsSideImage.png']");
	public static By ADD_STUDENTS_CONTINUE = By.xpath("//input[@src='/vip/assets/images/buttons/blue_continue_button.gif']");
	
	public static By ASSIGN_LICENSES = By.xpath("//img[@src='/vip/assets/images/vportSetup/assignLicensesSideImagev2.png']");
	public static By ASSIGN_LICENSES_FINISHED = By.xpath("//input[@src='/vip/assets/images/buttons/summary/btn_finished_green.png']");
	
}


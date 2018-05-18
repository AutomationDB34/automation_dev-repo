package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictTrackContactsLocators {

	public static By CONTACTS_TAB=By.id("subtabs02_view_by_contacts");
	public static By TRACKNAME_HEADING=By.xpath(".//div[@id='printSection']//td[contains(text(),'%s')]");
	public static By SCHOOLTRACKS_TAB=By.xpath(".//td[@id='subtabs02_view_by_school_tracks']/a/nobr");
	public static By MATERIALS_TAB = By.name("view_by_materials");
	public static By IPT_LINK = By.xpath(".//span[contains(.,'IPT')]");
	By TECHNOLOGY_TAB = By.xpath(".//a[contains(@name,'technology')]");
	By ASSESSMENT_PLANS_TAB = By.name("view_by_assessment_plan");   
	By CUSTOMER_INTERFACE = By.xpath(".//nobr[contains(.,'Customer Interface Options')]");
	By SELECT_BOXES = By.xpath("(.//*[contains(@id,'changeToSelect')])[1]");
	By SAVECHANGES_BUTTON = By.id("save_changes1");
	By BENCHMARK_SCORE_RADIO = By.xpath("((.//div[contains(@id,'benchMarkValue')])[1]/input[@type='radio'])[%s]");
	By MANAGE_ROASTER_RADIO = By.xpath("((.//div[contains(@id,'roster')])[1]/input[@type='radio'])[%s]");
	By PROGRESS_MONITORING_RADIO = By.xpath("((.//div[contains(@id,'progress')])[1]/input[@type='radio'])[%s]");
	By ADMINISTRATION_LINK = By.xpath(".//a/div[contains(.,'Administration')]");
	By DISTRICTS_TRACKS_LINK = By.xpath(".//a/div[contains(.,'Districts/Tracks')]");
	
	By ADD_ASSESSMENT_PLAN_BUTTON = By.xpath(".//img[contains(@src,'add_assessment_plan')]");
	By ASSESSMENT_PLAN_NAME_TEXT = By.name("assessmentPlanName");
	By SELECT_GRADE = By.name("gradeID");
	By ACTIVE_CHECK_BOX = By.name("active");
	By SELECT_EDITION = By.name("editionID");
	By ADD_PROFILE_BUTTON = By.xpath(".//img[contains(@src,'add_profile_sm')]");
	By PROFILE_SEQUENCE_NUMBER_TEXT = By.xpath(".//input[contains(@name,'sequenceNum')]");
	By PM_COUNT_TEXT = By.xpath(".//input[contains(@name,'interimCount')]");
	By MINIMUM_SCORE_TEXT = By.xpath(".//input[contains(@name,'minScore')]");
	By MAXIMUM_SCORE_TEXT = By.xpath(".//input[contains(@name,'maxScore')]");
	By SAVE_CONTINUE_BUTTON = By.xpath(".//input[contains(@src,'save_continue')]");
	By UPDATE_BUTTON = By.xpath(".//input[contains(@src,'update')]");
	By SAVED_ASSESSMENT_PLAN_NAME = By.xpath(".//td[contains(.,'%s') and @class='nameRow']");
	
	By ADD_ROW = By.xpath(".//img[contains(@src,'add_row_sm')]");
	By SELECTED_ASSESSMENT_PLAN = By.xpath(".//select[contains(@id,'selectedAssessmentPlan')]");
	By SAVED_ASSESSMENT_PLAN_IN_TECHNOLOGY_TAB = By.xpath(".//a[contains(.,'%s')]");
}

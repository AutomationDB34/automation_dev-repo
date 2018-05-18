package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictAdminMyResultsLocators {
	By SCHOOL_DRPDWN=By.xpath("//td[@id='topNav_background']//td[3]//span[@class='ddlabel' and text()='%s']");
	By CLASS_DRPDOWN=By.xpath("//td[@id='topNav_background']//td[4]//span[@class='ddlabel' and text()='%s']");
	

	By MYRESULTS_TAB=By.xpath(".//div[@class='main_menu_nav_c_on'][normalize-space()='My Results']");
	By MYRESULTS_SUBTABS=By.xpath("//tr[@class='subTabs']//nobr[contains(text(),'Scores')]");
	By MYDISTRICT_TAB=By.xpath(".//a[@class='main_menu_nav_link']/div[normalize-space()='My District']");
	By MYSCHOOL_TAB=By.xpath(".//a[@class='main_menu_nav_link']/div[normalize-space()='My School']");
	By MYCLASS_TAB=By.xpath(".//a[@class='main_menu_nav_link']/div[normalize-space()='My Class']");
	By SCALE_DRPDOWN=By.xpath("//div[@id='advancedFiltersContainer']//span[@id='ddcl-scaleID']");
	By OPTIONSINSCALE_DRPDOWN=By.xpath("//*[@id='ddcl-scaleID-ddw']//label[text()='%s']");
	By MATCHED_RADIOBUTTON=By.id("matchedRadio");
	By UNMATCHED_RADIOBUTTON=By.id("unmatchedRadio");
	By REFRESH_CHART=By.id("refreshAction");
	By SCORESINRESULTSBYSCHOOL_TABLE=By.xpath("//a[text()='%s']/following::td[%s]");
	By CHARTOPTIONS_FRMAE=By.id("chartOptions");
	By BARCHART_IMAGE=By.id("bar_chart");
	
	By LEVEL_DROPDOWN = By.xpath("//span[@id='ddcl-gradeLevelIDs']");
	By LEVEL_SELECTION = By.xpath("//label[contains(text(),'Level D')]");
	By CATEGORY_DROPDOWN = By.xpath("//span[@id='ddcl-assessmentCategoryIDs']");
	By CATEGORY_SELECTION = By.xpath("//label[contains(text(),'DIBELS Next')]");
	By MEASURE_DROPDOWN = By.xpath("//span[@id='ddcl-assessmentIDs']");
	//By MEASURE_SELECTION = By.xpath("//label[contains(text(),'Daze')]");
	By MEASURE_SELECTION = By.xpath("//label[contains(text(),'DORF')]");
	By MEASURE_DROPDOWN_OPTIONS = By.xpath("//span[@id='ddcl-assessmentIDs']/following-sibling::div/div/div[%s]/input[@type='checkbox']");
	By MEASURE_CHECKBOX_LIST = By.xpath("//div[@id='ddcl-assessmentIDs-ddw']/div/div/input[@type='checkbox']");
	By OK_BTN = By.xpath("//input[@value='Ok']");
	
	By DRILLDOWN_LINK_IN_RESULT_TABLE = By.xpath("//a[contains(text(),'%s')]");
	By SCALE_OPTION = By.xpath("(.//label[contains(.,'Score')])[1]");
	By SCALE_OPTION1 = By.xpath("(.//label[contains(.,'DORF Words Correct')])[1]");
	By STUDENT_IN_RESULTS_TABLE = By.xpath("//td[contains(text(),'%s')]/following-sibling::td[1]");
	
	//Student /Parent Report Locators
	By STUDENT_PARENT_LINK = By.xpath("//nobr[contains(text(),'Student/Parent')]");
	By STUDENT_PARENT_PAGE = By.xpath("//div[@class='screenTitle']/b[contains(text(),'Student/Parent Report')]");
	By STUDENT_SELECTION_FOR_REPORT_GENERATION = By.xpath("//td[contains(text(),'%s')]/preceding-sibling::td[2]/input[@type='checkbox']");
	By STEP1_CONTINUE_BTN = By.xpath("//span[@title='Continue']");
	By STEP2_CONTINUE_BTN = By.xpath("//input[@class='continueButton']");
	By STUDENT_PARENT_REPORT = By.xpath("//td[contains(text(),'%s')]");
	
	
	
	
	

}

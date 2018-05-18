package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictAdminMyDistrictLocators {
	By MYDISTRICT_SUBTABS=By.xpath("//tr[@class='subTabs']//nobr[contains(text(),'%s')]");
	By IMPLEMENTATION_TABLEEXISTS=By.id("standard");
	By IMPLEMENTATIONTABLE_HEADING=By.xpath("//table[@id='standard']//th[text()='Implementation Summary']");
	By IMPLEMENTATIONSUMMARY_TABLEROWS=By.xpath("//div[@class='paddedRow']//table[@class='summaryHeaderTable']//tr[@class='subTitle']//th");
	By IMPLEMENTATIONSUMMARY_VALUES=By.xpath("//table[@class='summaryHeaderTable']//tr[2]/td");

	//Locators in Summary tab

	By SUBTABS_TITLE=By.xpath("//div[@class='screenTitle']/b[1]");
	By IMPORT_STUDENTS_TAB = By.xpath(".//a[@name='Import Students']");
	By OPTION1_IMPORT = By.xpath(".//div[@id='import_roster']/h3");
	By OPTION2_IMPORT = By.xpath(".//div[@id='import_batch']/h3");
	By OPTION1_DOWNLOAD_TEMPLATE_BTN = By.xpath("(.//input[@value='Download Template'])[1]");
	By OPTION2_DOWNLOAD_TEMPLATE_BTN = By.xpath("(.//input[@value='Download Template'])[2]");



	By DOWNLOADTEMPLATE_BTNINROSTERSTUDENTINTOCLASS=By.xpath("//form[@id='studentReportForm']//input[@src='/vip/assets/images/common/spacer.gif']");
	By BROWSE_BTNINROSTERSTUDENTINTOCLASS_OPTION1=By.xpath(".//form[@id='import_roster_form']/input[1]");
	By BROWSE_BTNINROSTERSTUDENTINTOCLASS_OPTION2=By.xpath(".//form[@id='import_batch_form']/input[1]");
	By SUBMIT_BTNINROSTERSTUDENTINTOCLASS_OPTION1=By.xpath("//div[@id='import_roster']//input[@class='submitBtn floatLeft']");
	By SUBMIT_BTNINROSTERSTUDENTINTOCLASS_OPTION2=By.xpath("(//input[@class='submitBtn floatLeft'])[2]");
	By UPLOADEDFILECHECKING_STATUS=By.xpath("//ul[@id='import_status']/li[%s]");
	By PROCEEDWITHIMPORT_BTN=By.id("import_button");
	By IMPORTINGPOPUP=By.id("import_popup_importing");
	By IMPORTCOMPLETE_STATUS=By.xpath("//div[@id='import_complete']/h3");

	
	By ALL_DRPDOWN=By.xpath(".//font[contains(.,'%s')]/parent::td/parent::tr/following-sibling::tr//span[contains(@class,'ddlabel')]");
	By SELECT_OPTION_FROM_DROP_DOWN = By.xpath("//li/span[contains(.,'%s')]");
	


	By DISTRICTSETTINGS_HEADINGS=By.xpath("//span[@class='Cambium.App.VPort.bold'][text()='District Settings']");
	By DISTRICTSETTINGS_SUBTABS_ROSTER=By.xpath("//a[contains(.,'%s')]");
	By DISTRICTSETTINGSSUBTABS_HEADING=By.xpath("//div[@class='screenTitle']/b[1]");
	By SUMMARYTAB_ISSELECTED=By.xpath("//span[@class='Cambium.LanguageLive.UI.Tabs.tab Cambium.App.VPort.tabItem Cambium.LanguageLive.UI.Tabs.selected']");
	By DISTRICTSETTINGS_FRAME=By.xpath("//iframe[@class='Cambium.App.VPort.vportFrame']");
	
	
    By ADDEDSTUDENTID_FIELD = By.xpath(".//td[contains(.,'%s')][contains(@class,'nameRowNoBg')]");
    
    By NEXT_LINK=By.xpath("//b[text()='Next >']");
    
    By ADD_STUDENT_BUTTON_ROSTER = By.xpath("(.//img[contains(@src,'addStudents')])[1]");
    By AVAILABLE_STUDENTS_HEADER = By.xpath(".//td[contains(.,'Available Students') and contains(@class,'bluetablehdr')]");
    By SEARCH_AVAILABLE_STUDENT_TEXT = By.xpath(".//input[@id='nameIdSuggest']");
    By SEARCHED_STUDENT_ADD_ARROW_BUTTON = By.xpath(".//img[contains(@src,'ico_arrow_gray_6r_button.gif')]");
    By ADDED_STUDENT_IN_CLASS_IMG = By.xpath(".//img[contains(@src,'in_class.gif')]");
    By ADDED_STUDENT_IN_CLASS_ROASTER=By.xpath(".//tbody[@id='studentRowTarget']//td[contains(.,'%s') and contains(@class,'dg-td')]");
    By SAVE_CHANGES = By.xpath(".//img[contains(@src,'save_changes.gif')]");
    By RETURN_TO_CLASS_ROSTER_BUTTON = By.xpath(".//img[contains(@src,'return_to_class_roster.gif')]");
    
	By MYSCHOOL_TAB=By.xpath(".//div[contains(text(),'My School')]");

}

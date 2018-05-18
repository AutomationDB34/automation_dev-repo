package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictAdminMySchoolLocators {
	By MYCLASS_TAB=By.xpath(".//div[contains(text(),'My Class')]");
	By SCREENTITLE = By.xpath(".//div[@class='screenTitle']/b[%s]");
	//Summary Page locators
	By MYSCHOOL_SUBTABS=By.xpath("//tr[@class='subTabs']//nobr[contains(text(),'%s')]");
	By SUBTABS_TITLE=By.xpath("//div[@class='screenTitle']/b[1]");
	By IMPLEMENTATION_TABLEEXISTS=By.id("standard");
	By IMPLEMENTATIONTABLE_HEADING=By.xpath("//table[@id='standard']//th[text()='Implementation Summary']");
	By IMPLEMENTATIONSUMMARY_TABLEROWS=By.xpath("//div[@class='paddedRow']//table[@class='summaryHeaderTable']//tr[@class='subTitle']//th");
	By IMPLEMENTATIONSUMMARY_VALUES=By.xpath("//table[@class='summaryHeaderTable']//tr[2]/td");
	
	By INSTRUCTIONALPLAN = By.xpath(".//td[text()='Instructional Plan']");
	By TEACHERSANDCLASSES_SUBTAB = By.xpath(".//nobr[contains(text(),'Teachers & Classes')]");
	By ADDNEWSTAFF_BTN=By.className("addNewStaffBtn");
	By ADDNEWSAFF_DIALOG=By.xpath(".//span[text()='Add New Staff']");
	By LASTNAME_FIELD=By.xpath(".//div[@id='divNewTeacherGrid']//input[@name='teachers[0].userLastName']");
	By FIRSTNAME_FIELD=By.xpath(".//div[@id='divNewTeacherGrid']//input[@name='teachers[0].userFirstName']");
	By EMAIL_FIELD=By.xpath(".//div[@id='divNewTeacherGrid']//input[@name='teachers[0].emailAddress']");
	By SAVECHANGES_BTN=By.id("divNewTeacherSaveChanges");
	
	By EDITUSER_BTN=By.xpath("//input[@value='%s']/ancestor::table[@id='blank']//a[@class='editUserBtn']");
	
	By USERIDANDPASSWORD_FIELDS=By.xpath("(//input[@value='%s']/ancestor::tr/following-sibling::tr/td/input)[%s]");
	
	By CLASSESS_BTNS=By.xpath("//input[@value='%s']/ancestor::table[@id='blank']//td[4]//div[@class='gradeBtnCtr']/nobr[text()='C']");
	By SAVECHANGESBTN_TEACHER=By.className("saveChangesBtn"); //xpath("//input[@value='%s']/ancestor::table[@id='blank']//a[@class='saveChangesBtn']");
	By ADDCLASSES_BTNS=By.xpath("//input[@value='%s']/ancestor::table[@id='blank']//td[4]//div[@class='gradeBtnCtr']/nobr[text()='%s']");
	By ADDEDCLASSES=By.xpath("//input[@value='%s']/ancestor::table[@id='blank']//td[3]//span[text()='%s']");
	By SAVETEACHERSANDCLASSES=By.id("save_changes2");
	By CLASSNAME_DRP = By.id("msdrpdd22_msdd");
    By CLASSNAME_OPTION =  By.xpath("	.//div[@id='msdrpdd22_msdd']//li//span[text()='%s']");


    By ADDCLASS_BTN = By.xpath("//div[@class='gradeBtnContainer' and contains(@title,'%s')]");
    By CHECKLICENCE_BTN = By.xpath("//div[@class='gradeBtnContainer' and contains(@title,'%s')]/ancestor::td[1]/preceding-sibling::td[1]//input[@type='checkbox']");
	
	 //Licenses tab locators
   By LICENSES_SUBTABS=By.xpath("//td[contains(@id,'subMenuItem')]/nobr[text()='%s']");
   By LICENSESPURCHASEDTABLE_HEADING=By.xpath("//table[@id='standard']//td[text()='Licenses Purchased']");
   By LICENESESPURCHASEDTABLE_ROWVALUES=By.xpath("(//td[text()='Licenses Purchased']/parent::tr/following-sibling::tr)/td[text()='%s']/following-sibling::td[%s]");
   
   By ENTER_SCORES_LINK = By.xpath("//nobr[contains(text(),'Enter Scores')]");
   
	By LOGO_ICON = By.xpath("//img[@id='headerIcon']");
	By ADDCLASSES_BTNS_LL=By.xpath("//input[@value='%s']/ancestor::table[@id='blank']//td[4]//div[@class='gradeBtnCtr']");
	By TEACHER_LICENSE = By.xpath("//input[@class='handCursor']");
	By SAVE_CHANGES_BTN = By.id("save_changes2");
   
}

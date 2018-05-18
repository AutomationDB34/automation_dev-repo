package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface SchoolSettingsLocators {
	
	By ALLCLASSES_DRPDOWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.ClassSelector.menuTable']//td[text()='%s']");

	By SCHOOLSETTINGS_HEADINGS=By.xpath("//span[@class='Cambium.App.VPort.bold'][text()='School Settings']");
	By SCHOOLSETTINGS_SUBTABS=By.xpath("//table[@class='Cambium.LanguageLive.UI.Tabs.organizer']//span[text()='%s']");
	By SCHOOLSETTINGSSUBTABS_HEADING=By.xpath("//div[@class='screenTitle']/b[1]");
	By SUMMARYTAB_ISSELECTED=By.xpath("//span[@class='Cambium.LanguageLive.UI.Tabs.tab Cambium.App.VPort.tabItem Cambium.LanguageLive.UI.Tabs.selected']");
	By SCHOOLSETTINGS_FRAME=By.xpath("//iframe[@class='Cambium.App.VPort.vportFrame']");
	//Summary Tab locators
	By SUMMARYTAB_HEADING=By.xpath("(//div[@class='screenTitle']/b)[1]");
	By IMPLEMENTATIONSUMMARY_TABLE=By.id("standard");
	By IMPLEMENTATIONSUMMARY_TABLEROWS=By.xpath("//div[@class='paddedRow']//table[@class='summaryHeaderTable']//tr[@class='subTitle']//th");
	By IMPLEMENTATIONSUMMARY_VALUES=By.xpath("//table[@class='summaryHeaderTable']//tr[2]/td");
	//Roster tab scenarios
	By ROSTERTABLE_HEADING=By.xpath("//tr[@class='title']//div[1]");
	By ADDSTUDENTSTOP_IMG = By.id("addStudents_top");
	By ADDSTUDENTSTOROSTER_IMG = By.xpath("//img[@src='/vip/assets/images/buttons/add_student_roster.gif']");
    By RETURNTOCLASSROSTER_IMG = By.xpath("//img[@src='/vip/assets/images/buttons/return_to_class_roster.gif']");
    By ADDEDSTUDENTID_FIELD = By.xpath(".//table[@id='standard']//td[@class='nameRowNoBg borderLlt'][contains(text(),'%s')]");

    By NEXT_LINK=By.xpath("//b[text()='Next >']");
    By RESULTPAGES_LINKS=By.xpath("//a[contains(@href,'/vip/class/student_roster.do?')]");
    By RESULTPAGE_1=By.xpath("//a[contains(@href,'/vip/class/student_roster.do?') and text()='1']");
    By NOOFSTUDENTSINROSTER_TABLE=By.xpath("(//table[@id='standard'])[2]//tr[@class='enrolledNameRow']");
    By STUDENTNAMESINROSTER_TABLE=By.xpath("((//table[@id='standard'])[2]//tr[@class='enrolledNameRow']//a[@class='row'])[%s]");
    
    //Add New Students POPUP locators 
    By STDLASTNAMETEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].lastName']");
    By STDFIRSTNAMETEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].firstName']");
    By STDIDNUMBERTEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].idNumber']");
    By STDGRADELEVELTEXT_DRP = By.xpath(".//div[@id='newStudentInputDiv']//select[@name='students[0].gradeLevel']");
    By STDDOB_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].dateOfBirth']");
    By SAVEADDEDSTUDENTCHANGES_IMG = By.xpath(".//div[@id='newStudentDiv']//img[@id='saveNewButton']");
	
			

}

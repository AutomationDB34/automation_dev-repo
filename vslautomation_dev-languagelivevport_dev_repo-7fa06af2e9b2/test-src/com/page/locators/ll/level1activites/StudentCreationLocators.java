package com.page.locators.ll.level1activites;

import org.openqa.selenium.By;

public interface StudentCreationLocators {
	
		
	By CLASSSETTINGS_LINK = By.xpath("//table[@class='Cambium.UI.Tabs.Tabs.organizer']//span[@name='Settings']");	
	By ROSTER_TAB = By.xpath("//table[@class='Cambium.LanguageLive.UI.Tabs.organizer']//span[@name='roster']");	
	By ADDSTUDENTSMAINPAGE_BTN = By.id("addStudents_top");	
	By ROSTERFMAINPAGE_IFRAME = By.className("Cambium.App.VPort.vportFrame");
	By ADD_BTN = By.xpath("//img[@src='/vip/assets/images/buttons/add_student_roster.gif']");	
    By STDLASTNAMETEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[%s].lastName']");    
    By STDFIRSTNAMETEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[%s].firstName']");    
    By STDIDNUMBERTEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[%s].idNumber']");    
    By STDGRADELEVELTEXT_DRP = By.xpath(".//div[@id='newStudentInputDiv']//select[@name='students[%s].gradeLevel']");    
    By STDDOB_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[%s].dateOfBirth']");
    By SAVEADDEDSTUDENTCHANGES_IMG = By.xpath(".//div[@id='newStudentDiv']//img[@id='saveNewButton']");
    By RETURNTOCLASSROSTER_IMG = By.xpath("//img[@src='/vip/assets/images/buttons/return_to_class_roster.gif']");	
    By LIVESTUDENT_CHECKBOX = By.xpath(".//table[@id='standard']//td[@class='nameRowNoBg borderLlt'][contains(text(),'%s')]/../td[5]/input[@type='checkbox' and @value='on']");
    By STUDENTUSERID_FIELD = By.xpath("//table[@id='standard']//td[@class='nameRowNoBg borderLlt'][contains(text(),'%s')]/../td[6]//input");
    By STUDENTPWD_FIELD = By.xpath("//table[@id='standard']//td[@class='nameRowNoBg borderLlt'][contains(text(),'%s')]/../td[7]//input");
    By SAVECHANGES_BTN = By.id("save_changes1");
    
    By STUDENTS_TAB = By.xpath("//table[@class='Cambium.LanguageLive.UI.Tabs.organizer']//span[@name='students']");
    By RECORDINGNOTREQUIRED_TEXT = By.xpath("//div[@class='Cambium.App.ClassSettings.Student.recordingNotRequiredArea']");
    By STUDENTSETTINGS_TABLE = By.xpath("//table[@class='Cambium.App.ClassSettings.Student.settingsTable']");
    By EDITBUTTONFORSTUDENT_BTN = By.xpath("//div[@class='Cambium.App.ClassSettings.Student.lastName'][contains(text(),'%s')]/ancestor::tr[1]//div[@class='Cambium.App.ClassSettings.Student.currentPlacement']");
    By RECORDINGOFFFORSTUDENT_BTN = By.xpath("//div[@class='Cambium.App.ClassSettings.Student.lastName'][contains(text(),'%s')]/ancestor::tr[1]//td[4]//div[@class='Cambium.UI.Switch.label'][contains(text(),'on')]");
    By MOVESTUDENTCOURSEPOSITION_SECTION = By.xpath("//div[@class='Cambium.App.ClassSettings.Student.Placement.placementSelections']");
    By LEVELMENU_DRP = By.xpath("//span[contains(@class,'Cambium.App.ClassSettings.Student.Placement.levelMenu')]//td");
    By LEVELSELECTION_OPTION = By.xpath("//span[contains(@class,'Cambium.App.ClassSettings.Student.Placement.levelMenu')]//table[@class='Cambium.UI.Menu.menuTable']//td[contains(text(),'%s')]");
    By UNITMENU_DRP = By.xpath("//span[contains(@class,'Cambium.App.ClassSettings.Student.Placement.unitMenu')]//td");
    By UNITSELECTION_OPTION = By.xpath("//span[contains(@class,'Cambium.App.ClassSettings.Student.Placement.unitMenu')]//table[@class='Cambium.UI.Menu.menuTable']//td[contains(text(),'%s')]");
    By LESSONMENU_DRP = By.xpath("//span[contains(@class,'Cambium.App.ClassSettings.Student.Placement.lessonMenu')]//td");
    By LESSIONSELECTION_OPTION = By.xpath("//span[contains(@class,'Cambium.App.ClassSettings.Student.Placement.lessonMenu')]//table[@class='Cambium.UI.Menu.menuTable']//td[contains(text(),'%s')]");    
    By MOVESTUDENT_BTN = By.name("moveStudent");
    By SAVEANDUPDATE_BTN = By.xpath("//button[contains(@class,'ClassSettings.Student.saveAndUpdateButton')]");
    By NEXT_LINK=By.xpath("//b[text()='Next >']");
}

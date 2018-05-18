package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherToolsAssignmentsLocators {

	By ASSIGNMENTS_CLASS_DRP = By.xpath("//span[contains(@class,'Cambium.LanguageLive.UI.SelectMenu.LevelSelector Cambium.App.Assignments.levelSelector')]//td");
	By ASSIGNMENTS_CLASS_OPTION = By.xpath("//span[contains(@class,'Cambium.LanguageLive.UI.SelectMenu.LevelSelector Cambium.App.Assignments.levelSelector')]//table[@class='Cambium.UI.Menu.menuTable']//td[text()='%s']");
	
	By ASSIGNMENTS_UNITNUMBER_BTN = By.xpath("//div[contains(@class,'Cambium.UI.ResourceUnitNav.unitNumber')][text()='%s']");
	By ASSIGNMENTS_STUDENTS_TABLE = By.className("Cambium.App.Assignments.resultsTable");
	By ASSIGNMENTS_STUDENTS_TABLE_FOOTER = By.className("Cambium.App.Assignments.legendFooter");
	By ASSIGNMENTS_STUDENTS_TABLE_LEGEND = By.className("Cambium.App.Assignments.legendSections");
	
	By ASSIGN_BY_ACTIVITY = By.xpath("//td[@data-index='0'][1]/div[@class='Cambium.App.Assignments.me Cambium.App.Assignments.assign']/img");
	By UNASSIGN_BY_ACTIVITY = By.xpath("//td[@data-index='0'][1]/div[@class='Cambium.App.Assignments.me Cambium.App.Assignments.unassign']/img");
	By UNASSIGN_BY_SECTION= By.xpath("//tbody/tr[3]/td[2]/div[contains(@class,'Cambium.App.Assignments.unassign')]/span[contains(text(),'Assign')]");	
	By ASSIGN_BY_SECTION = By.xpath("//tbody/tr[3]/td[2]/div[contains(@class,'Cambium.App.Assignments.assign')]/span[contains(text(),'Assign')]");
	
	
	
	By ASSIGNMENTS_PRACTICEACTIVITY_COULUMNS_COUNT = By.xpath("//tr[@class='Cambium.App.Assignments.headingRow2']//td[@class='Cambium.App.Assignments.grp2']");
	By ASSIGNMENTS_PRACTICEACTIVITY_COLUMN = By.xpath("//tr[@class='Cambium.App.Assignments.headingRow2']//td[@class='Cambium.App.Assignments.grp2'][%s]");
	By ASSIGNMENTS_STUDENTSCORE = By.xpath("//div[@class='Cambium.App.Assignments.lastName'][text()='%s']/ancestor::tr[1]/td[%s]");
	By ASSIGNMENTS_STUDENT_UNASSIGNTEXT_CELL = By.xpath("//div[@class='Cambium.App.Assignments.lastName'][text()='%s']/ancestor::tr[1]/td[%s][contains(@class,'Cambium.App.Assignments.unassignedBG')]");
	By ASSIGNMENTS_STUDENT_ASSIGNEDTEXT_CELL = By.xpath("//div[@class='Cambium.App.Assignments.lastName'][text()='%s']/ancestor::tr[1]/td[%s][contains(@class,'Cambium.App.Assignments.assignedBG')]");
	
	By ASSIGN_BTN = By.name("assign");
	By UNASSIGN_BTN = By.name("unassign");
	
	By POWERPASS_PARTB_ASSIGNMENT_COMPLETED = By.xpath("//div[@class='Cambium.App.Assignments.lastName'][text()='%s']/ancestor::tr[1]/td[8][contains(@class,'Cambium.App.Assignments.completedBG')]");
	By POWERPASS_PARTB_ASSIGNMENT_UNASSIGNED = By.xpath("//div[@class='Cambium.App.Assignments.lastName'][text()='%s']/ancestor::tr[1]/td[8][contains(@class,'Cambium.App.Assignments.unassignedBG')]");
	By POWERPASS_PARTB_ASSIGNMENT_ASSIGNED = By.xpath("//div[@class='Cambium.App.Assignments.lastName'][text()='%s']/ancestor::tr[1]/td[8][contains(@class,'Cambium.App.Assignments.assignedBG')]");
	

	By ASSIGN_ALL_BTN = By.xpath("//span[contains(text(),'Assign All')]");
	By UNASSIGN_ALL_BTN = By.xpath("//span[contains(text(),'Unassign All')]");
	


}

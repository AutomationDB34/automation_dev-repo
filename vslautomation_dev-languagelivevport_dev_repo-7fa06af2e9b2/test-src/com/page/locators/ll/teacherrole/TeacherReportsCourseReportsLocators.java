package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherReportsCourseReportsLocators {

	By SUMMARYTAB_HIGHLIGHTED = By.xpath("//span[@name='summary' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By SUMMARYTAB_STUDENTS_TABLE = By.className("Cambium.App.Scorecard.Teacher.Summary.trackerTable");
	By SUMMARYTAB_WTSTUDENT_PROGRESS = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.Summary.lastName'][text()='%s']/ancestor::tr[1]/td[2]//span");
	By SUMMARYTAB_WTPROGRESSBAR = By.xpath("//table[contains(@class,'Cambium.App.Scorecard.BarGraphSummary.wordTraining')]//table//span[.='%s']/ancestor::table[1]//tr[1]/td[%s]/span");
	By SUMMARYTAB_WTBARPOPUP_STUDENT = By.xpath("//div[@class='Cambium.App.Scorecard.BarGraphSummary.BarDetails.lastName'][text()='%s']");	
	By SUMMARYTAB_SIGHTWORDS_PROGRESS = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.Summary.lastName'][.='%s']/ancestor::tr[1]/td[8]/div");	
	By SUMMARYTAB_SIGHTWORDSBAR = By.xpath("//table[contains(@class,'Cambium.App.Scorecard.BarGraphSummary.sightWords')]//table//span[.='%s']/ancestor::table[1]//tr[1]/td[%s]/span");	
	By SUMMARYTAB_SIGHTWORDSBARPOPUP_STUDENT = By.xpath("//div[@class='Cambium.App.Scorecard.BarGraphSummary.BarDetails.lastName'][text()='%s']");
	
	By WORDTRAINING_TAB = By.name("wordtraining");
	By WORDTRAININGTAB_ALLUNITSTABLE = By.className("Cambium.App.Scorecard.Teacher.WordTraining.AllUnits.resultsTable");
	By WORDTRAININGALLUNITS_STUDENT = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.WordTraining.AllUnits.lastName'][text()='%s']");
	By WORDTRAININGALLUNITS_STUDENTSCORE = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.WordTraining.AllUnits.lastName'][text()='%s']/ancestor::tr[1]/td[%s]");
	
	By SIGHTWORDS_TAB = By.name("sightwords");
	By SIGHTWORDS_ALLFLOORSTABLE = By.className("Cambium.App.Scorecard.Teacher.SightWords.AllUnits.resultsTable");
	By SIGHTWORDS_STUDENTS = By.xpath(".//div[@class='Cambium.App.Scorecard.Teacher.SightWords.AllUnits.lastName'][text()='%s']");
	By SIGHTWORDS_STUDENTSCORE = By.xpath(".//div[@class='Cambium.App.Scorecard.Teacher.SightWords.AllUnits.lastName'][text()='%s']/ancestor::tr[1]/td[%s]");
	
	By TEXTTRAINING_TAB = By.name("texttraining");
	By TEXTTRAININGTAB_TABLE = By.className("Cambium.App.Scorecard.Teacher.TextTraining.resultsTable");
	By TEXTTRAINING_UNITNUMBER_BTN = By.xpath("//div[contains(@class,'Cambium.UI.ResourceUnitNav.unitNumber')][text()='%s']");
	By TEXTTRAINING_RETEACHUNIT_LINK = By.xpath("//span[@class='Cambium.App.Scorecard.Teacher.TextTraining.theUnitNumber'][text()='%s']");
	
	By TEXTTRAINING_PRACTICEACTIVITY_COULUMNS_COUNT = By.xpath("//tr[@class='Cambium.App.Scorecard.Teacher.TextTraining.headingRow2']//td[@class='Cambium.App.Scorecard.Teacher.TextTraining.grp2']");
	By TEXTTRAINING_PRACTICEACTIVITY_COLUMN = By.xpath("//tr[@class='Cambium.App.Scorecard.Teacher.TextTraining.headingRow2']//td[@class='Cambium.App.Scorecard.Teacher.TextTraining.grp2'][%s]");
	By TEXTTRAINING_STUDENTSCORE = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.TextTraining.lastName'][text()='%s']/ancestor::tr[1]/td[%s]");
	
	By TEXTTRAINING_CONTENTMASTERY_COULUMNS_COUNT = By.xpath("//tr[@class='Cambium.App.Scorecard.Teacher.TextTraining.headingRow2']//td[@class='Cambium.App.Scorecard.Teacher.TextTraining.grp3']");
	By TEXTTRAINING_CONTENTMASTERY_COLUMN = By.xpath("//tr[@class='Cambium.App.Scorecard.Teacher.TextTraining.headingRow2']//td[@class='Cambium.App.Scorecard.Teacher.TextTraining.grp3'][%s]");
	
	By TEXTTRAINING_POWERPASS_COULUMNS_COUNT = By.xpath("//tr[@class='Cambium.App.Scorecard.Teacher.TextTraining.headingRow2']//td[@class='Cambium.App.Scorecard.Teacher.TextTraining.grp4']");
	By TEXTTRAINING_POWERPASS_COLUMN = By.xpath("//tr[@class='Cambium.App.Scorecard.Teacher.TextTraining.headingRow2']//td[@class='Cambium.App.Scorecard.Teacher.TextTraining.grp4'][%s]");

	
	By WT_GRAPH_BAR = By.xpath("//table[contains(@class,'Cambium.App.Scorecard.BarGraphSummary.wordTraining')]//table[@class='Cambium.App.Scorecard.BarGraphSummary.barGraph']/tbody/tr/td[2]/span[contains(@class,'Cambium.App.Scorecard.BarGraphSummary.greenBar')]");
	By STUDENTS_LIST_IN_POPUP = By.xpath("//table[@class='Cambium.App.Scorecard.BarGraphSummary.BarDetails.inner']/tbody/tr");
	By STUDENT_COUNT_IN_POPUP = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.Well.for')][2]");
	By BARGRAPH_POPUP = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.BarGraphSummary.BarDetails.closerX ')]");
	By STUDENT_NAME_TO_VERIFY_SUMMARY = By.xpath("//div[@class='Cambium.App.Scorecard.BarGraphSummary.BarDetails.lastName'][text()='%s'][1]");
	By SUMMARY_PAGE_STUDENT_VERIFICATION = By.xpath("//span[text()='%s %s']");
	By SUMMARY_PAGE = By.xpath("//div[@class='Cambium.App.Scorecard.Student.Summary.title']");
	

	By STUDENT_SELECTION_DROPDOWN = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.SelectMenu.StudentSelector.selection')]");
	By STUDENT_NAME = By.xpath("//td[contains(text(),'%s %s')]");
	
	
	By UNIT_1_BTN = By.xpath("//div[contains(text(),'All Units')]/following-sibling::div[1]");
	By UNIT_DETAILS_PAGE = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.WordTraining.UnitDetails.subTitle']");
	By STUDENT_WT_DETAILS = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.Teacher.WordTraining.UnitDetails')][text()='%s'][1]");
	By LESSON_1_SCORE = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.Teacher.WordTraining.UnitDetails')][text()='%s']/ancestor::tr[1]/td[2]");
	By LESSON_2_SCORE = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.Teacher.WordTraining.UnitDetails')][text()='%s']/ancestor::tr[1]/td[3]");
	By LESSON_3_SCORE = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.Teacher.WordTraining.UnitDetails')][text()='%s']/ancestor::tr[1]/td[4]");
	By LESSON_4_SCORE = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.Teacher.WordTraining.UnitDetails')][text()='%s']/ancestor::tr[1]/td[5]");

	By DISPLAY_DROPDOWN = By.xpath("//td[contains(@class,'Cambium.LanguageLive.UI.SelectMenu.selection')]");
	By GOAL_NAME = By.xpath("//td[contains(text(),'Read Passages')]");
	By STUDENT_GOAL_DETAILS = By.xpath("//div[@class='Cambium.App.Scorecard.Teacher.WordTraining.AllUnits.lastName'][text()='%s']/ancestor::tr[1]/td[8]");
	
	By FLOOR_NUMBER = By.xpath("//div[contains(@class,'Cambium.UI.ResourceUnitNav.unitNumber')][contains(text(),'1')]");
	By FLOOR_WISE_SCORE = By.xpath("//div[contains(@class,'Cambium.App.Scorecard.Teacher.SightWords.UnitDetails.lastName')][text()='%s']/ancestor::tr[1]/td[2]");
	
	
}

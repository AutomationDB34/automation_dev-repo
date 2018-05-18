package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherToolsClassSettingsLocators {

	By ROSTERTAB_SECTION_FORM = By.id("classStudentRosterForm']");
	
	By SUMMARY_TAB = By.name("summary");
	By SUMMARYTAB_SELECTED = By.xpath("//span[@name='summary' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By SUMMARY_SECTION_IFRAME = By.className("Cambium.App.VPort.vportFrame");
	By SUMMARYSECTION_TABLE = By.className("summaryTable");
	By SUMMARYSECTION_STUDENTS_COUNT = By.xpath("//table[@class='summaryHeaderTable']//tr[@class='subTitle']/following-sibling::tr[1]/td[1]");
	By CLASSROSTER_STUDENTS_COUNT = By.xpath("//img[@src='/vip/assets/images/buttons/summary/btn_add.gif']/ancestor::td[1]/div[@class='summaryEntryHeader']");
	
	By ROSTER_TAB = By.xpath("//table[@class='Cambium.LanguageLive.UI.Tabs.organizer']//span[@name='roster']");	
    By STUDENTS_TAB = By.xpath("//table[@class='Cambium.LanguageLive.UI.Tabs.organizer']//span[@name='students']");

	By TARGETS_TAB = By.name("targets");
	By TARGETSTAB_SELECTED = By.xpath("//*[@name='targets' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By TARGETS_SECTION_TABLE = By.className("Cambium.App.ClassSettings.Targets.targetsTable");
	By STUDENTS_TIMETOSPENDWT_INPUT = By.xpath("//div[@class='Cambium.App.ClassSettings.Targets.lastName'][text()='%s']/ancestor::tr[1]/td[2]//input");
	By STUDENTS_TIMETOSPENDWT_AFTERUPDATE = By.xpath("//div[@class='Cambium.App.ClassSettings.Targets.lastName'][text()='%s']/ancestor::tr[1]/td[2][contains(@class,'Cambium.App.ClassSettings.Targets.customTarget')]");	
	By TARGETS_SAVEANDUPDATE_BTN = By.xpath("//button[contains(text(),'Save & Update')]");
	By TARGETS_SAVEANDUPDATE_BTN_DISABLED = By.xpath("//button[contains(text(),'Save & Update') and @disabled]");
	
	By BENCHMARKS_TAB = By.name("benchmarks");
	By BENCHMARKSTAB_SELECTED = By.xpath("//*[@name='benchmarks' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By BENCHMARKSSECTION_IFRAME = By.className("Cambium.App.VPort.vportFrame");
	By BENCHMARKSSECTION_FORM = By.id("classScheduleAssessmentsForm");
	By BENCHMARKS_COUNT = By.xpath(".//form[@id='classScheduleAssessmentsForm']/table[2]//td[@class='nameRow']");
	By BENCHMARKS_NAMES = By.xpath(".//form[@id='classScheduleAssessmentsForm']/table[2]//td[@class='nameRow']//b");
	By BENCHMARKONE_FIRST_TEST_SELECT = By.xpath(".//form[@id='classScheduleAssessmentsForm']/table[2]//td[@class='nameRow']/b[text()='Benchmark 1']/ancestor::tr[1]/td[3]//tr[1]/td[3]/input[@class='handCursor']");
	By BENCHMARKONE_FIRST_TEST_ENABLED = By.xpath(".//form[@id='classScheduleAssessmentsForm']/table[2]//td[@class='nameRow']/b[text()='Benchmark 1']/ancestor::tr[1]/td[3]//tr[1]/td[3]/input[@class='handCursor' and @checked='checked']");
	By BENCHMARKONE_FIRST_TEST_NAME =  By.xpath(".//form[@id='classScheduleAssessmentsForm']/table[2]//td[@class='nameRow']/b[text()='Benchmark 1']/ancestor::tr[1]/td[3]//tr[1]/td[1]");
	By BENCHMARKS_SAVECHANGES_BTN = By.id("save_changes1");
	
	By ROSTER_REMOVE_STUDENT_BTN = By.xpath(".//table[@id='standard']//td[@class='nameRowNoBg' and @nowrap]//a[contains(text(),'%s')]/ancestor::tr[1]//img");
	By ROSTERFMAINPAGE_IFRAME = By.className("Cambium.App.VPort.vportFrame");
	
}

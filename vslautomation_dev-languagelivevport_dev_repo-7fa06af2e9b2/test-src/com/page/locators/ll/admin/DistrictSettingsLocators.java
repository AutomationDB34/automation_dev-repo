package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface DistrictSettingsLocators {
	
	By ALLCLASSES_DRPDOWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.ClassSelector.menuTable']//td[text()='%s']");
	By ALLSCHOOLS_DRPDOWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.CampusSelector.menuTable']//td[text()='%s']");
	
	
	By DISTRICTSETTINGS_HEADINGS=By.xpath("//span[@class='Cambium.App.VPort.bold'][text()='District Settings']");
	By DISTRICTSETTINGS_SUBTABS=By.xpath("//table[@class='Cambium.LanguageLive.UI.Tabs.organizer']//span[text()='%s']");
	By DISTRICTSETTINGSSUBTABS_HEADING=By.xpath("//div[@class='screenTitle']/b[1]");
	By SUMMARYTAB_ISSELECTED=By.xpath("//span[@class='Cambium.LanguageLive.UI.Tabs.tab Cambium.App.VPort.tabItem Cambium.LanguageLive.UI.Tabs.selected']");
	By DISTRICTSETTINGS_FRAME=By.xpath("//iframe[@class='Cambium.App.VPort.vportFrame']");
	//Summary Tab locators
	By SUMMARYTAB_HEADING=By.xpath("(//div[@class='screenTitle']/b)[1]");
	By IMPLEMENTATIONSUMMARY_TABLE=By.id("standard");
	By IMPLEMENTATIONSUMMARY_TABLEROWS=By.xpath("//div[@class='paddedRow']//table[@class='summaryHeaderTable']//tr[@class='subTitle']//th");
	By IMPLEMENTATIONSUMMARY_VALUES=By.xpath("//table[@class='summaryHeaderTable']//tr[2]/td");
	By ADD_BTN=By.xpath("//img[@src='/vip/assets/images/buttons/summary/btn_add.gif']");
	By IMPORT_BTN=By.xpath("//img[@src='/vip/assets/images/buttons/summary/btn_import.gif']");
	
	//Roster tab locators
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
    
    //Students Tab Locators
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
    
    //Targets tab Locators
    By TARGETS_TAB = By.name("targets");
	By TARGETSTAB_SELECTED = By.xpath("//*[@name='targets' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By TARGETS_SECTION_TABLE = By.className("Cambium.App.ClassSettings.Targets.targetsTable");
	By STUDENTS_TIMETOSPENDWT_INPUT = By.xpath("//div[@class='Cambium.App.ClassSettings.Targets.lastName'][text()='%s']/ancestor::tr[1]/td[2]//input");
	By STUDENTS_TIMETOSPENDWT_AFTERUPDATE = By.xpath("//div[@class='Cambium.App.ClassSettings.Targets.lastName'][text()='%s']/ancestor::tr[1]/td[2][contains(@class,'Cambium.App.ClassSettings.Targets.customTarget')]");	
	By TARGETS_SAVEANDUPDATE_BTN = By.xpath("//button[contains(text(),'Save & Update')]");
	By TARGETS_SAVEANDUPDATE_BTN_DISABLED = By.xpath("//button[contains(text(),'Save & Update') and @disabled]");
	
   	//Locators in Benchmark
	
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
	
	//Locators in Licenses tab
	
	//Licenses tab locators
	   By LICENSES_SUBTABS=By.xpath("//td[contains(@id,'subMenuItem')]/nobr[text()='%s']");
	   By LICENSESPURCHASEDTABLE_HEADING=By.xpath("//table[@id='standard']//td[text()='Licenses Purchased']");
	   By LICENESESPURCHASEDTABLE_ROWVALUES=By.xpath("(//td[text()='Licenses Purchased']/parent::tr/following-sibling::tr)/td[text()='%s']/following-sibling::td[%s]");
		
	 //Import students Tab locators
	   
	   By DOWNLOADTEMPLATE_BTNINROSTERSTUDENTINTOCLASS=By.xpath("//form[@id='studentReportForm']//input[@src='/vip/assets/images/common/spacer.gif']");
	   By BROWSE_BTNINROSTERSTUDENTINTOCLASS=By.xpath(".//form[@id='import_roster_form']/input[1]");
	   By SUBMIT_BTNINROSTERSTUDENTINTOCLASS=By.xpath("//div[@id='import_roster']//input[@class='submitBtn floatLeft']");
	   By UPLOADEDFILECHECKING_STATUS=By.xpath("//ul[@id='import_status']/li[%s]");
	   By PROCEEDWITHIMPORT_BTN=By.id("import_button");
	   By IMPORTINGPOPUP=By.id("import_popup_importing");
	   By IMPORTCOMPLETE_STATUS=By.xpath("//div[@id='import_complete']/h3");
	   
	   //Locators in Schools tab
	   
	   By IDENTIFYPARTICIPATINGSCHOOL_TABLE=By.xpath("//table[@id='standard']//td[contains(text(),'Identify Participating Schools')]");
	   By SELECT_CHKBOXOFSCHOOL=By.xpath("//table[@id='standard']//input[@id='%s' and @type='checkbox']");
	   By SAVECHANGES_BTN=By.id("save_changes1");
	   
}

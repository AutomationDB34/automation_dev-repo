package com.page.locators.vport;
 
import org.openqa.selenium.By;

import com.page.locators.dibelsnext.StudentCenterLocators;
 
public interface DistrictAdminMyClassLocators {
 
 	//Summary Tab locators
	By MYCLASS_SUBTABS=By.xpath("//tr[@class='subTabs']//nobr[contains(text(),'%s')]");
	By IMPLEMENTATION_TABLEEXISTS=By.id("standard");
	By IMPLEMENTATIONTABLE_HEADING=By.xpath("//table[@id='standard']//th[text()='Implementation Summary']");
	By IMPLEMENTATIONSUMMARY_TABLEROWS=By.xpath("//div[@class='paddedRow']//table[@class='summaryHeaderTable']//tr[@class='subTitle']//th");
	By IMPLEMENTATIONSUMMARY_VALUES=By.xpath("//table[@class='summaryHeaderTable']//tr[2]/td");
	
	//Locators in Summary tab
	
	By SUMMARYTAB_TITLE=By.xpath("//div[@class='screenTitle']/b[1]");
	
       //Sub tabs in My Class locators
	  public static By ENTERSCORES_TAB=By.xpath("//nobr[contains(text(),'Enter Scores')]");
	  public static By SCHEDULEONLINEASSESSMENT_TAB=By.xpath("//nobr[contains(text(),'Schedule Online Assessments')]");
	
	   public static By SCREENTITLE = By.xpath(".//div[@class='screenTitle']/b[%s]");
       public static By CLASSNAME_DRP = By.id("msdrpdd22_msdd");
      // public static By CLASSNAME_OPTION =  By.xpath(".//div[@id='msdrpdd22_msdd']//li//span[contains(text(),'%s')]");
       public static By CLASSNAME_OPTION =  By.id("msdrpdd22_child");
       public static By MYCLASS_TAB = By.xpath(".//table[@id='mainNav']//div[contains(text(),'My Class')]");
       public static By HOME_TAB=By.xpath(".//div[@class='main_menu_nav_c_off' and normalize-space(.)='Home']");
       public static By CLASSNAME_TEXT = By.xpath(".//input[@id='rosterName' and @value='%s']");
       public static By ADDSTUDENTSTOP_IMG = By.id("addStudents_top");
       public static By ADDSTUDENTSTOROSTER_IMG = By.xpath("//img[@src='/vip/assets/images/buttons/add_student_roster.gif']");
       public static By RETURNTOCLASSROSTER_IMG = By.xpath("//img[@src='/vip/assets/images/buttons/return_to_class_roster.gif']");
       public static By ADDEDSTUDENTID_FIELD = By.xpath(".//table[@id='standard']//td[@class='nameRowNoBg borderLlt'][contains(text(),'%s')]");
      
       
       //Add New Students POPUP locators 
       public static By STDLASTNAMETEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].lastName']");
       public static By STDFIRSTNAMETEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].firstName']");
       public static By STDIDNUMBERTEXT_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].idNumber']");
       public static By STDGRADELEVELTEXT_DRP = By.xpath(".//div[@id='newStudentInputDiv']//select[@name='students[0].gradeLevel']");
       public static By STDDOB_FIELD = By.xpath(".//div[@id='newStudentInputDiv']//input[@name='students[0].dateOfBirth']");
       public static By SAVEADDEDSTUDENTCHANGES_IMG = By.xpath(".//div[@id='newStudentDiv']//img[@id='saveNewButton']");
       
       //Add Existing Students section locators
       public static By AVAILABLESTUDENTSSEARCH_FIELD = By.id("nameIdSuggest");
       public static By STUDENTINAVAILABLESTUDENTSTABLE_FIELD = By.xpath(".//table[@id='availableStudentsTable']//td[contains(text(),'%s')]");
       public static By ADDSTUDENTTOCLASSARROWBTN_IMG = By.xpath(".//table[@id='availableStudentsTable']//td[contains(text(),'%s')]/..//img[@src='/vip/assets/images/icons/ico_arrow_gray_6r_button.gif']");
       public static By ADDEDSTUDENTSINTHETARGETCLASS_FIELD = By.xpath("//tbody[@id='studentRowTarget']//td[contains(text(),'%s')]");
       public static By SAVECHANGESBUTTONAFTERMOVINGSTUDENTS_IMG = By.xpath(".//td[@id='saveChangesTd']/img[@src='/vip/assets/images/buttons/save_changes.gif']");
       public static By LICENSES_HEADINGSROW=By.xpath(".//tr[@class='subTitle']/td[%s]");
       public static By ADDEDSTUDENTLICENSES_CHECKBOXES=By.xpath("//td[text()='%s']/following-sibling::td[%s]/input[@type='checkbox']");
       public static By ADDEDSTUDENTLICENSES_CHECKBOXES_DISABLED=By.xpath("//td[text()='%s']/following-sibling::td[%s]/input[@type='checkbox'][@disabled='disabled']");
       public static By ADDEDSTUDENTUSERID=By.xpath("//td[text()='%s']/following-sibling::td/nobr/input[contains(@id,'userLogin')]");
       public static By ADDEDSTUDENTPASSWORD=By.xpath("//td[text()='%s']/following-sibling::td/nobr/input[contains(@id,'password')]");
 
       public static By SAVECHANGESINROSTER_BTN=By.id("save_changes2");
       
       //Locators in 'Enter Scores' tab
       public static By CHOOSETESTPERIODS_BTNS=By.id("subMenuItem_2_%s");
       public static By BENCHMARKSCORESTABLEHEADING=By.xpath(".//nobr[text()='Benchmark %s Scores']");
       public static By SCOREFIELDSFORASSESSMENTS=By.xpath(".//td[normalize-space(.)='%s']/../td[%s]//input[@type='text']");
       public static By PENCILICONSFOROPENASSESSMENT=By.xpath(".//td[normalize-space(.)='%s']/../td[%s]//a");
       
       public static By ASSESSMENTSTYPES=By.xpath(".//*[@id='standard']//tr[2]/td[contains(@class,'columnIndexShowByDefault')]");
       public static By SCOREFIELDSOFASSESSMENTS=By.xpath(".//*[@id='standard']//tr[4]/td[contains(@class,'%s')]//input");
       
       public static By ASSESSMENTFLASHVIDEO=By.xpath("//object[@id='DIBELS Next']");
       
              
       //Locators in "Schedule Online Assessment' tab
       
       public static By BENCHMARKASSESSMENTSTABLEHEADING=By.xpath(".//td[@class='schedAssessmentTableHeader']");
       public static By ASSESSMENTROWINBENCHMARKASSESSMENTSTABLE=By.xpath(".//td[text()='%s']/../td[2]//td[%s]");
       public static By ENABLETESTCHECKBOX=By.xpath(".//td[text()='%s']/../td[2]//td[%s]/input[@type='checkbox']");
       
       //Class Roster
       public static By ROSTER = By.name("manage_roster");
       
       
       public static By DIBELSNEXT_LINK = By.xpath("//nobr[contains(text(),'DIBELS Next')]");
       public static By TEST_PERIOD_LINK = By.xpath("//nobr[contains(text(),'1')]");
       
       public static By STUDENT_SUBMITTED_SCORE_LINK  = By.xpath("//td[contains(text(),'%s')]/following-sibling::td[9]/div/nobr/a");
       public static By STUDENT_SUBMITTED_SCORE_LINK1  = By.xpath("//td[contains(text(),'%s')]/following-sibling::td[2]/div/nobr/a");
       public static By DORF_PENCIL_ICON = By.xpath("//td[contains(text(),'%s')]/following-sibling::td[2]/div/nobr/span/a");
       
       //Delete Students paths
       public static By NEXT_LINK = By.xpath("//b[text()='Next >']");
       public static By STUDENT_WITH_ID_TEXT =  By.xpath("(.//td[contains(@class,'nameRowNoBg borderLlt')][1])[contains(.,'ID')]");
       public static By STUDENT_WITH_ID_TEXT_DELETE = By.xpath("(.//td[contains(@class,'nameRowNoBg borderLlt')][1])[contains(.,'ID')]/preceding-sibling::td/preceding-sibling::td");
    		   

}

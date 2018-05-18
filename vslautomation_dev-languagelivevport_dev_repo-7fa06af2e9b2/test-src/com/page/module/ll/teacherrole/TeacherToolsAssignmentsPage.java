package com.page.module.ll.teacherrole;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.page.locators.ll.teacherrole.TeacherToolsAssignmentsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherToolsAssignmentsPage extends CommonFunctionalities implements TeacherToolsAssignmentsLocators {

	private WebDriver driver;
	ConfigManager app = new ConfigManager("App");
	String executionMode = app.getProperty("App.ExecutionMode");
	Logger log = Logger.getLogger(getClass());
	
	public TeacherToolsAssignmentsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify that assignments tab is loaded successfully
	 */
	
	public void verifyThatAssignmentsTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_STUDENTS_TABLE, LONGWAIT), "Assignments tab section under Tools tab is not loaded");
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_STUDENTS_TABLE_FOOTER, LONGWAIT), "Assignments tab section under Tools tab is not loaded");
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_STUDENTS_TABLE_LEGEND, LONGWAIT), "Assignments tab section under Tools tab is not loaded");
	}
	
	
	/**
	 * Purpose- To select class from class drop down under 'Assignments' tab
	 * @param className
	 */
	
	public void selectClassFromClassDropDown(String className)
	{
		safeClick(ASSIGNMENTS_CLASS_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(ASSIGNMENTS_CLASS_OPTION, className), LONGWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Purpose-To click on student unit number under under Assignments section
	 * @param studentUnitNumber
	 */
	
	public void clickOnStudentUnitNumberUnderAssignmentsSection(String studentUnitNumber)
	{
		safeClick(Dynamic.getNewLocator(ASSIGNMENTS_UNITNUMBER_BTN, studentUnitNumber), LONGWAIT);
		waitForPageToLoad();
	}
	

	/**
	 * Purpose- To Assign text and verify assignment score for students
	 * @param studentLastnameToVerifyScore,expectedPracticeActivity,expectedStudentPracticeActivityScore,studentLastNameToAssignText
	 */
	
	public void assignTextAndVerifyAssignTextScoreForStudents(String studentLastnameToVerifyScore,String expectedPracticeActivity, String expectedStudentPracticeActivityScore,String studentLastNameToAssignText)
	{
		Assert.haultonfailure=false;
		
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_STUDENTS_TABLE, LONGWAIT), "Students table under Assignments section is not loaded after clicking student unit number");
				
		int practiceActivityColumnsDisplayedCount=getLocatorCount(ASSIGNMENTS_PRACTICEACTIVITY_COULUMNS_COUNT);
		
		for(int i=1;i<=practiceActivityColumnsDisplayedCount;i++)
		{
			String actualpracticeActivityColumnName = safeGetText(Dynamic.getNewLocator(ASSIGNMENTS_PRACTICEACTIVITY_COLUMN, Integer.toString(i)), LONGWAIT);
						
			if(actualpracticeActivityColumnName.equalsIgnoreCase(expectedPracticeActivity))
			{
				String actualStudentPracticeActivityScore = safeGetText(Dynamic.getNewLocator(ASSIGNMENTS_STUDENTSCORE, studentLastnameToVerifyScore,Integer.toString(i+1)), LONGWAIT);
				
				Assert.assertEquals(actualStudentPracticeActivityScore, expectedStudentPracticeActivityScore, "Actual practice activity score("+actualStudentPracticeActivityScore+") of the student("+studentLastnameToVerifyScore+") doesn't match with expected score("+expectedStudentPracticeActivityScore+") on Tools->Assignments page");
				
				break;
			}
		}
				
		for(int i=1;i<=practiceActivityColumnsDisplayedCount;i++)
		{
			String actualpracticeActivityColumnName = safeGetText(Dynamic.getNewLocator(ASSIGNMENTS_PRACTICEACTIVITY_COLUMN, Integer.toString(i)), LONGWAIT);
						
			if(actualpracticeActivityColumnName.equalsIgnoreCase(expectedPracticeActivity))
			{
				
				Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ASSIGNMENTS_STUDENT_UNASSIGNTEXT_CELL, studentLastNameToAssignText,Integer.toString(i+1)), LONGWAIT), "The student user("+studentLastNameToAssignText+") is already having assignment under practice activity column("+actualpracticeActivityColumnName+")");
				
				safeClick(Dynamic.getNewLocator(ASSIGNMENTS_STUDENT_UNASSIGNTEXT_CELL, studentLastNameToAssignText,Integer.toString(i+1)), LONGWAIT);
				
				Assert.assertTrue(isElementPresent(ASSIGN_BTN, LONGWAIT),"Assign practice popup is not displayed when clicked on Assignment table cell for student("+studentLastNameToAssignText+")");
				
				safeClick(ASSIGN_BTN, LONGWAIT);
				
				Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ASSIGNMENTS_STUDENT_ASSIGNEDTEXT_CELL, studentLastNameToAssignText,Integer.toString(i+1)), LONGWAIT), "The student user("+studentLastNameToAssignText+") is not updated with assignment under practice activity column("+actualpracticeActivityColumnName+")");
								
				safeClick(Dynamic.getNewLocator(ASSIGNMENTS_STUDENT_ASSIGNEDTEXT_CELL, studentLastNameToAssignText,Integer.toString(i+1)), LONGWAIT);
				
				Assert.assertTrue(isElementPresent(UNASSIGN_BTN, LONGWAIT),"Unassign practice popup is not displayed when clicked on Assignment table cell for student("+studentLastNameToAssignText+")");
				
				safeClick(UNASSIGN_BTN, LONGWAIT);
				
				Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ASSIGNMENTS_STUDENT_UNASSIGNTEXT_CELL, studentLastNameToAssignText,Integer.toString(i+1)), LONGWAIT), "The student user("+studentLastNameToAssignText+") is having the assignment under practice activity column("+actualpracticeActivityColumnName+") even after unassigned");
					
				break;
			}
		}
	}
	
	/**
	 * Purpose- To assign power pass B activity for student user
	 */
	
	public void assignPowerPassBTTActivityForStudent(String studentLastName)
	{
		Assert.assertTrue(isElementPresent(ASSIGNMENTS_STUDENTS_TABLE, LONGWAIT), "Students table under Assignments section is not loaded");
		
		nullifyImplicitWait();
		
		int assignedLocatorCount = getLocatorCount(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_COMPLETED, studentLastName));
		
		int unAssignedLocatorCount = getLocatorCount(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_UNASSIGNED, studentLastName));
		
		if(unAssignedLocatorCount==1)
		{		
		setImplicitWait(IMPLICITWAIT);
		
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_UNASSIGNED, studentLastName), LONGWAIT), "Unable to assign power pass B activity for the student user("+studentLastName+")");
		
		safeClick(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_UNASSIGNED, studentLastName), LONGWAIT);
		
		Assert.assertTrue(isElementPresent(ASSIGN_BTN, LONGWAIT),"Assign practice popup is not displayed when clicked on Assignment table cell under Power Pass B column for student("+studentLastName+")");
		
		safeClick(ASSIGN_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_ASSIGNED, studentLastName), LONGWAIT), "The student user("+studentLastName+") is not updated with assignment under power pass B column");
		}
		nullifyImplicitWait();
		if(assignedLocatorCount==1)
		{	
		setImplicitWait(IMPLICITWAIT);
		
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_COMPLETED, studentLastName), LONGWAIT), "Unable to assign power pass B activity for the student user("+studentLastName+")");
		
		safeClick(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_COMPLETED, studentLastName), LONGWAIT);
		
		Assert.assertTrue(isElementPresent(ASSIGN_BTN, LONGWAIT),"Assign practice popup is not displayed when clicked on Assignment table cell under Power Pass B column for student("+studentLastName+")");
		
		safeClick(ASSIGN_BTN, LONGWAIT);
		
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(POWERPASS_PARTB_ASSIGNMENT_ASSIGNED, studentLastName), LONGWAIT), "The student user("+studentLastName+") is not updated with assignment under power pass B column");
		}
		
	}
	
	
	public void assignActivitiestoAllStudents(){
		
		safeClick(ASSIGN_BY_ACTIVITY, MEDIUMWAIT);
		safeClick(ASSIGN_ALL_BTN, MEDIUMWAIT);
		waitForSecs(3);
		safeClick(UNASSIGN_BY_ACTIVITY, MEDIUMWAIT);
		safeClick(UNASSIGN_ALL_BTN, MEDIUMWAIT);
		waitForSecs(3);
		safeClick(ASSIGN_BY_SECTION, MEDIUMWAIT);
		safeClick(ASSIGN_ALL_BTN, MEDIUMWAIT);
		waitForSecs(3);
		safeClick(UNASSIGN_BY_SECTION, MEDIUMWAIT);
		safeClick(UNASSIGN_ALL_BTN, MEDIUMWAIT);
	}
	
public void toolsAssignmentsVerification(LLData llData){
		
		if (executionMode.equalsIgnoreCase("qc")) {
			log.info("Runnig the test case at QC mode");
			assignTextAndVerifyAssignTextScoreForStudents(llData.teacherRoleLLStudentLastName,
					llData.teacherRoleLLStudentTTPracticeActivity, llData.teacherRoleLLStudentTTPracticeActivityScore,
					llData.teacherRoleLLAssignmentsAssignTextStudentLastName);
			
		} else {
			log.info("Runnig the test case at RC mode");
			assignTextAndVerifyAssignTextScoreForStudents(llData.teacherRoleLLStudentLastName,
					llData.teacherRoleLLStudentTTPracticeActivity, llData.teacherRoleLLStudentTTPracticeActivityScore,
					llData.teacherRoleLLAssignmentsAssignTextStudentLastName);
			assignActivitiestoAllStudents();
			
		}

		waitForSecs(6, "Waiting logout link to prasent");
		
		
		
	}
	
}

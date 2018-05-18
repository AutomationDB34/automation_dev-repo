package com.page.module.ll.teacherrole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import com.page.locators.ll.teacherrole.TeacherRoleReportsParentReportLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleReportsParentReportPage extends SafeActions implements TeacherRoleReportsParentReportLocators {

	private WebDriver driver;
	public TeacherRoleReportsParentReportPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify the navigation to Parent Report page
	 */
	
	public void verifyNavigationToParentReportTab()
	{
		Assert.assertTrue(isElementPresent(MESSAGEBODY_TEXT, LONGWAIT), "Parent Report Tab content is not loaded with the message text 'Choose a class and a student. Then select Create Report.'");
	}
	
	/**
	 * Purpose - To Run the Parent report for single student user
	 * @param studentLastName, StudentFirstName
	 */
	
	public void runAndVerifyParentReportForSingleStudentUser(String studentLastName,String StudentFirstName)
	{
		safeClick(STUDENTSELECTION_DRP, LONGWAIT);
		safeClick(Dynamic.getNewLocator(STUDENTDRP_OPTION, StudentFirstName,studentLastName), LONGWAIT);
		safeClick(CREATEREPORT_BTN, LONGWAIT);
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(STUDENTNAMEINTHEPARENTREPORT, StudentFirstName+" "+studentLastName), LONGWAIT),"Parent report is not displayed for the selected single student user("+StudentFirstName+" "+studentLastName+")");
	}
	
	/**
	 * Purpose - To Run the Parent report for all student users
	 */
	
	public void runAndVerifyParentReportForAllStudentUsers()
	{
		safeClick(STUDENTSELECTION_DRP, LONGWAIT);
		List<WebElement> totalStudentsInTheStudentDRP = LocatorWebElements(STUDENTDRP_ALLSTUDENT_NAMES);
		List<WebElement> studentNamesWithLevelsInStudentDRP = LocatorWebElements(STUDENTDRP_ALLSTUDENTS_LEVELS);
		String[] studentNames = new String[totalStudentsInTheStudentDRP.size()];
		
		for(int i=1;i<totalStudentsInTheStudentDRP.size();i++)
		{
			String studentLevelInTheName = studentNamesWithLevelsInStudentDRP.get(i-1).getText().trim();
			
			studentNames[i]=totalStudentsInTheStudentDRP.get(i).getText().replace(studentLevelInTheName,"");
		}
		
		safeClick(STUDENTDRPOPTION_ALLSTUDENTS_OPTION, LONGWAIT);
		safeClick(CREATEREPORT_BTN, LONGWAIT);
		waitForPageToLoad();
		//Assert.haultonfailure=false;
		for(int i=1;i<studentNames.length;i++)
		{			
			Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(STUDENTNAMEINTHEPARENTREPORT, studentNames[i]), LONGWAIT), "Parent report is not generated for the student user("+studentNames[i]+") OR there are duplicate student records displayed in the report");
		}
		
	}
}


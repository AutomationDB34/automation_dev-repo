package com.page.module.ll.teacherrole;

import java.util.List;

import org.apache.bcel.generic.IALOAD;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;






import com.testng.Assert;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;
import com.page.locators.ll.teacherrole.TeacherToolsClassSettingsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.page.module.ll.level1activities.StudentCreation;
import com.selenium.Dynamic;
import com.selenium.SafeActions;

public class TeacherToolsClassSettingsPage extends CommonFunctionalities implements TeacherToolsClassSettingsLocators {

	private WebDriver driver;
	public TeacherToolsClassSettingsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify the data under Summary tab under Tools->Class Settings section
	 */
	
	public void verifyTheDataUnderSummaryTab()
	{
		Assert.assertTrue(isElementPresent(SUMMARYTAB_SELECTED, LONGWAIT), "By default summary tab is not loaded when navigated to Tools->Class Settings page");
		selectFrame(SUMMARY_SECTION_IFRAME, LONGWAIT);
		Assert.assertTrue(isElementPresent(SUMMARYSECTION_TABLE, LONGWAIT), "By default summary tab is not loaded when navigated to Tools->Class Settings page");
		int summaryTableStudentCount = Integer.parseInt(safeGetText(SUMMARYSECTION_STUDENTS_COUNT, LONGWAIT));
		int classRosterStudentCount = Integer.parseInt(safeGetText(CLASSROSTER_STUDENTS_COUNT, LONGWAIT).trim().replaceAll("Students","").replaceAll(" ", ""));
		System.out.println("summary table count("+summaryTableStudentCount+")class roster count("+classRosterStudentCount);		
		Assert.assertEquals(summaryTableStudentCount, classRosterStudentCount, "class roster student(which is being displayed on top of add button) count("+classRosterStudentCount+") doesn't match with total student count("+summaryTableStudentCount+")displayed under summary table");
		defaultFrame();
		
		
	}
	/**
	 * Purpose - To click on Class Roster tab
	 * @return 
	 */
	public StudentCreation clickOnRosterTab()
	{
		safeClick(ROSTER_TAB, LONGWAIT);
		return new StudentCreation(driver);
	}
	
    /**
     * Purpose-To click on students tab
     * @return 
     */
    
    public StudentCreation clickOnStudentsTab()
    {
  	  safeClick(STUDENTS_TAB, LONGWAIT);
  	return new StudentCreation(driver);
    }
	/**
	 * Purpose - To click on Targets tab under Class Settings section
	 */
	
	public void clickOnTargetsTab()
	{
		safeClick(TARGETS_TAB, LONGWAIT);
	}
	
	
	/**
	 * Purpose- To verify that targets tab is selected and content is loaded
	 */
	public void verifyThatTargetsTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(TARGETSTAB_SELECTED, LONGWAIT), "Targets tab is not selected after clicking on it under Class Settings page");
		Assert.assertTrue(isElementPresent(TARGETS_SECTION_TABLE, LONGWAIT), "Targets tab content is not loaded after clicking on it under Class Settings page");
	}
	
	/**
	 * Purpose - To update time to spend in word training text field for the created student user
	 * @param studentLastNameToUpdateTime
	 */
	
	public void updateTimeToSpendWordTrainingValueForStudent(String[] studentLastNameToUpdateTime)
	{	
		refresh();
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(TARGETS_SAVEANDUPDATE_BTN_DISABLED,LONGWAIT), "Save And Continue button is enabled even before making the changes under Targets tab of Class Settings page");
		int initialTimeToSpendWtValue=Integer.parseInt(safeGetAttribute(Dynamic.getNewLocator(STUDENTS_TIMETOSPENDWT_INPUT, studentLastNameToUpdateTime[0]), "value", LONGWAIT).trim());
		int newTimeToSpendWtValueToEnter = initialTimeToSpendWtValue+1;
		safeClearAndType(Dynamic.getNewLocator(STUDENTS_TIMETOSPENDWT_INPUT, studentLastNameToUpdateTime[0]),Integer.toString(newTimeToSpendWtValueToEnter), LONGWAIT);
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(STUDENTS_TIMETOSPENDWT_AFTERUPDATE, studentLastNameToUpdateTime[0]), LONGWAIT), "The field time to spend in word training is not changed to customizable mode after entering new value for the student("+studentLastNameToUpdateTime[0]+")");
		Assert.assertTrue(isElementPresent(TARGETS_SAVEANDUPDATE_BTN,LONGWAIT), "Save And Continue button is not enabled even after making the changes for the student("+studentLastNameToUpdateTime[0]+")under Targets tab of Class Settings page");
		safeClick(TARGETS_SAVEANDUPDATE_BTN, LONGWAIT);
		Assert.assertTrue(isElementPresent(TARGETS_SAVEANDUPDATE_BTN_DISABLED,LONGWAIT), "Save And Continue button is not disabled even before making and saving the changes under Targets tab of Class Settings page");
		int updatedTimeToSpendWtValue=Integer.parseInt(safeGetAttribute(Dynamic.getNewLocator(STUDENTS_TIMETOSPENDWT_INPUT, studentLastNameToUpdateTime[0]), "value", LONGWAIT).trim());		
		Assert.assertEquals(newTimeToSpendWtValueToEnter, updatedTimeToSpendWtValue, "The student users("+studentLastNameToUpdateTime[0]+") time to spend in word training text field value is not udpated to("+newTimeToSpendWtValueToEnter+") from the initial value("+initialTimeToSpendWtValue+")");
	}
	
	
	/**
	 * Purpose - To click on Benchmarks tab under Class Settings section
	 */
	
	public void clickOnBenchMarksTab()
	{
		safeClick(BENCHMARKS_TAB, LONGWAIT);
	}
	
	
	/**
	 * Purpose- To verify that Benchmarks tab is selected and content is loaded
	 */
	public void verifyThatBenchMarksTabIsLoaded()
	{
		Assert.assertTrue(isElementPresent(BENCHMARKSTAB_SELECTED, LONGWAIT), "Benchmarks tab is not selected after clicking on it under Class Settings page");
		selectFrame(BENCHMARKSSECTION_IFRAME, LONGWAIT);
		Assert.assertTrue(isElementPresent(BENCHMARKSSECTION_FORM, LONGWAIT), "Benchmarks tab content is not loaded after clicking on it under Class Settings page");
	}
	
	/**
	 * Purpose- To verify that list of Benchmarks are displayed
	 */
	public void verifyThatListOfBenchMarksAreLoaded()
	{
		List<WebElement> listOfAvailableBenchmarks= LocatorWebElements(BENCHMARKS_NAMES);
		
		for(int i=0;i<listOfAvailableBenchmarks.size();i++)
		{
			String actualBenchmarkName = listOfAvailableBenchmarks.get(i).getText().trim().toLowerCase();
			
			String expectedBenchmarkName = ("Benchmark "+(i+1)).toLowerCase();
			
			Assert.assertEquals(actualBenchmarkName,expectedBenchmarkName,"The actual benchmark name("+actualBenchmarkName+") doesn't match with expected benchmark name("+expectedBenchmarkName+") under Class Settings->Benchmarks tab");
		}
	}
	
	/**
	 * Purpose- To enable first test for first benchmark and save the changes
	 */
	
	public void enableFirstTestOfFirstBenchmarkAndSave()
	{
		String nameOfTheFirstTestInBenchmark1 = safeGetText(BENCHMARKONE_FIRST_TEST_NAME, LONGWAIT);
		
		nullifyImplicitWait();
		
		if(getLocatorCount(BENCHMARKONE_FIRST_TEST_ENABLED)==0)
		{
		setImplicitWait(IMPLICITWAIT);		
		
		safeClick(BENCHMARKONE_FIRST_TEST_SELECT, LONGWAIT);
		
		safeClick(BENCHMARKS_SAVECHANGES_BTN, LONGWAIT);
		
		waitForPageToLoad();
		
		Assert.assertTrue(isElementPresent(BENCHMARKSSECTION_FORM, LONGWAIT), "Benchmarks tab content is not loaded after saving the test changes under Class Settings page");
		
		Assert.assertTrue(isElementPresent(BENCHMARKONE_FIRST_TEST_ENABLED, LONGWAIT), "The test enabling checkbox is not found checked for the first test("+nameOfTheFirstTestInBenchmark1+")of the first benchmark1 after saving the changes");		
		
		defaultFrame();
		}
		
		defaultFrame();
	}
	
	/**
	 * Purpose- To delete created student from Roster
	 * @param studentID ,isChromeBrowser
	 */
	
	public void deleteAddedStudentFromRoster(String[] studentID,boolean isChromeBrowser)
	{
		selectFrame(ROSTERFMAINPAGE_IFRAME, LONGWAIT);
		
		if(isChromeBrowser)
		{			
		//safeActionsClick(Dynamic.getNewLocator(ROSTER_REMOVE_STUDENT_BTN, "StdLastNamN29ID"), LONGWAIT);		
		}
		else
		{
		safeClick(Dynamic.getNewLocator(ROSTER_REMOVE_STUDENT_BTN, studentID[0]), LONGWAIT);		
		Assert.assertTrue(isAlertPresent(LONGWAIT), "Alert message didn't appear after clicking 'remove' button for student("+studentID[0]+") under Class Settings->Rosters tab");
		acceptAlert();
		waitForPageToLoad();
		}
		defaultFrame();

	}
}

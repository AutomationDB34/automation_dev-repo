package com.page.module.vport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.data.testdata.VportData;
import com.datamanager.ConfigManager;
import com.datamanager.ExcelManager;
import com.page.locators.vport.DistrictAdminMyDistrictLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class DistrictAdminMyDistrictPage extends SafeActions implements DistrictAdminMyDistrictLocators {

	WebDriver driver;
	ExcelManager excelFile;
	VportData vportData =  new VportData();
	LLData llData = new LLData();
	ConfigManager sys = new ConfigManager();
	public DistrictAdminMyDistrictPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Verifies My district page is loaded or not 
	 */
	public void verifyMyDistrictPageIsLoaded()
	{
		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(MYDISTRICT_SUBTABS, "Summary")),"Summary Sub tab is not laoded on clicking 'My District' sub tab");
		Assert.assertTrue(isElementDisplayed(IMPLEMENTATION_TABLEEXISTS), "Implementation Summary table is not loaded in My District->Summary page");
	}
	/**
	 * Clicks on Summary tab available in My District page
	 */
	public void clickSummaryTab()
	{
		safeClick(Dynamic.getNewLocator(MYDISTRICT_SUBTABS, "Summary"));
	}
	/**
	 * Verifies summary tab is loaded or not
	 */
	public void verifySummaryTabLoaded()
	{
		Assert.assertEquals(safeGetText(SUBTABS_TITLE, LONGWAIT),"Setup Summary", "Title in My District->Summary tab is not displayed ");

	}

	/**
	 * Gets the data in implementation summary table and stores in Map  
	 * @return
	 */

	public Map<String, String> getImplementationSummaryTableRowAndValues()
	{
		Map<String, String> map = new HashMap<String, String>();
		List<WebElement> implementationSummaryRowHeadings = LocatorWebElements(IMPLEMENTATIONSUMMARY_TABLEROWS);
		List<WebElement> teachersRowValues = LocatorWebElements(IMPLEMENTATIONSUMMARY_VALUES);
		for (int i = 0; i < implementationSummaryRowHeadings.size(); i++) {

			String rowNames=implementationSummaryRowHeadings.get(i).getText();
			String rowValues=teachersRowValues.get(i).getText();
			map.put(rowNames,rowValues);
		}
		return map;
	}

	/**
	 * Clicks on Licenses tab available in My District page
	 */
	public void clickOnLicenseTab()
	{
		safeClick(Dynamic.getNewLocator(MYDISTRICT_SUBTABS, "Licenses"));
	}
	/**
	 * Verifies Licenses tab is loaded or not
	 */
	public void verifyLicensesTabLoaded()
	{
		Assert.assertEquals(safeGetText(SUBTABS_TITLE, LONGWAIT),"Licenses", "Title in My District->Licenses tab is not displayed ");

	}
	
	/**
	 * Purpose is to Navigate to Import Student page
	 */
	public void clickOnImportStudents()
	{
		safeClick(IMPORT_STUDENTS_TAB, MEDIUMWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Verify the Options Loaded
	 */
	public void verifyImportOptions()
	{
		String option1 = safeGetText(OPTION1_IMPORT, MEDIUMWAIT);
		String option2 = safeGetText(OPTION2_IMPORT, MEDIUMWAIT);
		Assert.assertEquals(option1, vportData.vportImportStudents_Option1,"Option1 is not as expected");
		Assert.assertEquals(option2, vportData.vportImportStudents_Option2,"Option2 is not as expected");
	}
	/**
	 * Click on Optio1 Download Button
	 */
	public void clickOnOption1DownloadTemplateButton()
	{
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeActionsClick(OPTION1_DOWNLOAD_TEMPLATE_BTN, MEDIUMWAIT);
			waitForSecs(10);
			safeClickUsingSikuli(vportData.internetExplorerSave, "internetExplorerSave", VERYLONGWAIT);
			waitForSecs(15,"Waiting to click on Explorer Save");
		}
		else
		{
			safeActionsClick(OPTION1_DOWNLOAD_TEMPLATE_BTN, MEDIUMWAIT);
		}
		waitForSecs(20);
	}
	
	/**
	 * Click on Optio1 Download Button
	 */
	public void clickOnOption2DownloadTemplateButton()
	{
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeActionsClick(OPTION2_DOWNLOAD_TEMPLATE_BTN, MEDIUMWAIT);
			waitForSecs(10);
			safeClickUsingSikuli(vportData.internetExplorerSave, "internetExplorerSave", VERYLONGWAIT);
			waitForSecs(15,"Waiting to click on Explorer Save");
		}
		else
		{
			safeActionsClick(OPTION2_DOWNLOAD_TEMPLATE_BTN, MEDIUMWAIT);
		}
		waitForSecs(20);
	}
	
	/**
	 * Verifies Excel  template is downloaded or not  
	 * @param RosterStudentDownloadedTemplateFilePath
	 */
	public String verifyTemplateIsDownloaded(String RosterStudentDownloadedTemplateFilePath)
	{
		waitForSecs(10);
		String latestDownloadedFile=getTheNewestFile(System.getProperty("user.dir")+RosterStudentDownloadedTemplateFilePath).toString();
		excelFile=new ExcelManager(latestDownloadedFile);	
		return latestDownloadedFile;
	}
	
	
	 /** To Enter Stundent Details into Downloaded Excel Sheet
	 * @param RosterStudentDownloadedTemplateFilePath
	 * @param sheetName
	 * @param cellData
	 * @param rowNum
	 * @param colNames
	 */

	public void enterStudentDetailsIntoDownloadedExcel(String RosterStudentDownloadedTemplateFilePath,String sheetName,String[] cellData,String rowNum,String [] colNames)

	{
		excelFile.setCellDataXLS(RosterStudentDownloadedTemplateFilePath,sheetName,cellData[0],Integer.parseInt(rowNum),colNames[0]);
		excelFile.setCellDataXLS(RosterStudentDownloadedTemplateFilePath,sheetName,cellData[1],Integer.parseInt(rowNum),colNames[1]);
		excelFile.setCellDataXLS(RosterStudentDownloadedTemplateFilePath,sheetName,cellData[2],Integer.parseInt(rowNum),colNames[2]);
		excelFile.setCellDataXLS(RosterStudentDownloadedTemplateFilePath,sheetName,cellData[3],Integer.parseInt(rowNum),colNames[3]);
		excelFile.setCellDataXLS(RosterStudentDownloadedTemplateFilePath,sheetName,Character.toString(cellData[4].charAt(0)),Integer.parseInt(rowNum),colNames[4]);

	}
	
	
	/**
	 * Upload the modified excel sheet with student details into application 
	 * @param excelPath
	 */
	public void uploadExcelSheetWithStudentDetialsOption1(String excelPath)
	{
		waitForSecs(5);
		//isElementClickable(BROWSE_BTNINROSTERSTUDENTINTOCLASS, MEDIUMWAIT);
/*		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			//safeJavaScriptClick(BROWSE_BTNINROSTERSTUDENTINTOCLASS, LONGWAIT);
			safeClickUsingSikuli(llData.IEBrowseFilePath, "IE download path" , VERYLONGWAIT);
			waitForSecs(5);
			safeClickUsingSikuli(llData.IEEnterFilePath, "IE enter file path" , VERYLONGWAIT);
			//	safeType(BROWSE_BTNINROSTERSTUDENTINTOCLASS,excelPath, LONGWAIT);
			safeTypeUsingSikuli(excelPath, VERYLONGWAIT);
			waitForSecs(5);
			safeClickUsingSikuli(llData.IEUploadOpenButton, "IEUploadOpenButton" , VERYLONGWAIT);
			waitForSecs(5);
			safeClickUsingSikuli(llData.IESubmitButton, "IE enter file path" , VERYLONGWAIT);
			waitForSecs(20,"Waiting to click on Explorer Save");
		}
		else
		{*/
			safeType(BROWSE_BTNINROSTERSTUDENTINTOCLASS_OPTION1,excelPath, LONGWAIT);
			safeJavaScriptClick(SUBMIT_BTNINROSTERSTUDENTINTOCLASS_OPTION1,MEDIUMWAIT);

/*		}*/

	}
	
	/**
	 * Upload the modified excel sheet with student details into application 
	 * @param excelPath
	 */
	public void uploadExcelSheetWithStudentDetialsOption2(String excelPath)
	{
		waitForSecs(5);
		//isElementClickable(BROWSE_BTNINROSTERSTUDENTINTOCLASS, MEDIUMWAIT);
/*		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			//safeJavaScriptClick(BROWSE_BTNINROSTERSTUDENTINTOCLASS, LONGWAIT);
			safeClickUsingSikuli(llData.IEBrowseFilePath, "IE download path" , VERYLONGWAIT);
			waitForSecs(5);
			safeClickUsingSikuli(llData.IEEnterFilePath, "IE enter file path" , VERYLONGWAIT);
			//	safeType(BROWSE_BTNINROSTERSTUDENTINTOCLASS,excelPath, LONGWAIT);
			safeTypeUsingSikuli(excelPath, VERYLONGWAIT);
			waitForSecs(5);
			safeClickUsingSikuli(llData.IEUploadOpenButton, "IEUploadOpenButton" , VERYLONGWAIT);
			waitForSecs(5);
			safeClickUsingSikuli(llData.IESubmitButton, "IE enter file path" , VERYLONGWAIT);
			waitForSecs(20,"Waiting to click on Explorer Save");
		}
		else
		{*/
			safeType(BROWSE_BTNINROSTERSTUDENTINTOCLASS_OPTION2,excelPath, LONGWAIT);
			safeJavaScriptClick(SUBMIT_BTNINROSTERSTUDENTINTOCLASS_OPTION2,MEDIUMWAIT);

/*		}*/

	}
	/**
	 * verify Excel sheet is uploaded correctly or not 
	 */
	public void verifyExcelSheetUploadedCorrectly()
	{
/*		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.FileUploadSuccessfulInIE, "IE enter file path" , VERYLONGWAIT);
			waitForSecs(10);
		}
		else
		{*/
			isElementPresent(Dynamic.getNewLocator(UPLOADEDFILECHECKING_STATUS,"1"),VERYLONGWAIT);
			Assert.assertEquals(safeGetText(Dynamic.getNewLocator(UPLOADEDFILECHECKING_STATUS,"1"),VERYLONGWAIT),"File Received","File received text is not displayed on uploading a Excel sheet with student details in 'District Settings'->'Import Students' tab ");
			Assert.assertEquals(safeGetText(Dynamic.getNewLocator(UPLOADEDFILECHECKING_STATUS,"2"),VERYLONGWAIT),"Checking File","Checking File text is not displayed on uploading a Excel sheet with student details in 'District Settings'->'Import Students' tab ");
/*		}*/
	}
	/**
	 * Clicks on Proceed with Import button after uploading a excel sheet 
	 */
	public void clickProceddwithImportButton()
	{
/*		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.ProceedWithImportInIE, "ProceedWithImportInIE" , VERYLONGWAIT);
		}
		else
		{*/
			safeClick(PROCEEDWITHIMPORT_BTN);
			Assert.assertTrue(isElementPresent(IMPORTINGPOPUP,LONGWAIT),"Importing pop up is not displayed on clciking Proceed with Import button in  'District Settings'->'Import Students' tab");
	/*	}*/
		waitForSecs(25);
	}
	/**
	 * Verify Excel sheet details are imported into application or not  
	 */
	public void verifyExcelSheetImportedCorrectly() 
	{

		//waitForSecs(6);
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.SuccessfulUploadInIE, "SuccessfulUploadInIE" , VERYLONGWAIT);
		}
		else
		{
		isElementPresent(IMPORTCOMPLETE_STATUS,VERYLONGWAIT);
		Assert.assertEquals(safeGetText(IMPORTCOMPLETE_STATUS,VERYLONGWAIT),"Your file has been successfully imported and the process is now complete.","'Your file has been successfully imported and the process is now complete' text is not displayed on uploading a Excel sheet with student details in 'District Settings'->'Import Students' tab ");
		}
		
	}

	/**
	 * To Selects class from 'All classes' drop down
	 */
	public void selectClassFromAllClasses(String className) {
		isElementPresent(Dynamic.getNewLocator(ALL_DRPDOWN,"CLASS"), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(ALL_DRPDOWN,"CLASS"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(SELECT_OPTION_FROM_DROP_DOWN,className + " LL"), LONGWAIT);

	}
	
	
	/**
	 * To Selects class from 'All classes' drop down
	 */
	public void selectClassFromAllClassesDefault(String defeaultClassName) {
		isElementPresent(Dynamic.getNewLocator(ALL_DRPDOWN,"CLASS"), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(ALL_DRPDOWN,"CLASS"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(SELECT_OPTION_FROM_DROP_DOWN,defeaultClassName), LONGWAIT);

	}

	
	/**
	 * To Select school from 'All Schools' drop down
	 */
	public void selectSchoolFromAllSchools(String schoolName) {
		isElementPresent(Dynamic.getNewLocator(ALL_DRPDOWN, "SCHOOL"),LONGWAIT);
		safeActionsClick(Dynamic.getNewLocator(ALL_DRPDOWN,"SCHOOL"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(SELECT_OPTION_FROM_DROP_DOWN,schoolName), LONGWAIT);

	}

	/**
	 * To verify 'All Classes' dropdown enabled after selecting a school
	 */
	public void verifyAllClassesDropdownDisplayed() {
		waitForPageToLoad();
		boolean bAllClassesDrpdwnDisplayed = isElementPresent(Dynamic.getNewLocator(ALL_DRPDOWN,"CLASS"),LONGWAIT);
		Assert.assertTrue(bAllClassesDrpdwnDisplayed,"All Classes Dropdown is not enabled after selecting school from schools dropdown");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * To Clicks on Roster sub tab in District Settings
	 */
	public void clickOnRosterTab()

	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS_ROSTER, "Roster"),LONGWAIT);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Verifies Roster Tab is loaded or not by 
	 */
	public void verifyRosterTabLoaded() {
		waitForSecs(4);
		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"Manage Roster","Manage Roster heading is not displayed on loading  'District Settings'->'Roster' tab ");
	}
	
	
	/**
	 * To verify the added student in the class on My Class->Roster main page
	 * @param studentId
	 */
	public void verifyAddedStudentInTheClass(String studentId)
	{
		do
		{
			waitForSecs(10);
			if(isElementPresent(Dynamic.getNewLocator(ADDEDSTUDENTID_FIELD, studentId), LONGWAIT))
			{
				break;
			}
			safeClick(NEXT_LINK, MEDIUMWAIT);
			waitForPageToLoad();
		}while(isElementPresent(NEXT_LINK, MEDIUMWAIT));
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ADDEDSTUDENTID_FIELD, studentId), MEDIUMWAIT), "The student user with id("+studentId+") is not added to the class on My Class->Roster page");
	}

	
	/**
	 * Click on Add Students in Roaster Tab
	 */
	public void clickOnAddStudentsRoster()
	{
		safeClick(ADD_STUDENT_BUTTON_ROSTER, MEDIUMWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Verify Available Students block is loaded
	 */
	public void verifyAvailableStudentsSearchHeadder()
	{
		Assert.assertTrue(isElementPresent(AVAILABLE_STUDENTS_HEADER, MEDIUMWAIT), "Available students search are is not lodaded");
	}
	
	/**
	 * Enter Student Id to Search
	 */
	public void enterStudentIDToSearch(String studenNew)
	{
		safeClick(SEARCH_AVAILABLE_STUDENT_TEXT, MEDIUMWAIT);
		safeClearAndType(SEARCH_AVAILABLE_STUDENT_TEXT, studenNew, MEDIUMWAIT);
		waitForSecs(4);
	}
	
	/**
	 * Verify the searched student is loaded or not 
	 */
	public void verifyThesearchedStudentLoaded()
	{
		Assert.assertTrue(isElementPresent(SEARCHED_STUDENT_ADD_ARROW_BUTTON, MEDIUMWAIT), "The Student is not Loaded / Not Available in Data base");
		Assert.assertTrue(isElementClickable(SEARCHED_STUDENT_ADD_ARROW_BUTTON, MEDIUMWAIT), "The Add Arrow Button is not clickable");
	}
	
	/**
	 * click on Add arrow button
	 */
	public void clickOnAddArrowButtonOnSearchedStudent()
	{
		safeClick(SEARCHED_STUDENT_ADD_ARROW_BUTTON, MEDIUMWAIT);
		waitForPageToLoad();
	}
	
	/**
	 * Verify the student is added to Class
	 */
	public void verifyTheStudentAddedClassRosterOnSamePage(String StudentNew)
	{
		Assert.assertTrue(isElementPresent(ADDED_STUDENT_IN_CLASS_IMG, MEDIUMWAIT), "For Added Student in class image is not being displayed");
		Assert.assertTrue(
				isElementPresent(Dynamic.getNewLocator(ADDED_STUDENT_IN_CLASS_ROASTER,StudentNew), MEDIUMWAIT), "Added Student is not displayed in Class Roaster");
		waitForSecs(4);
	}
	
	/**
	 * Click on Save Changes Button
	 */
	public void clickOnSaveChangesButton() 
	{
		safeClick(SAVE_CHANGES, MEDIUMWAIT);
		waitForSecs(8);
		waitForPageToLoad();
	}

	/**
	 * To Clicks on Roster sub tab in District Settings
	 */
	public void ClickOnReturnToClassRoasterButton()

	{
		safeJavaScriptClick(RETURN_TO_CLASS_ROSTER_BUTTON,LONGWAIT);
		waitForSecs(5);
	}
	public DistrictAdminMySchoolPage clickOnMySchoolTab() {
		safeClick(MYSCHOOL_TAB);
		return new DistrictAdminMySchoolPage(driver);
	}
}


package com.page.module.ll.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.metal.MetalDesktopIconUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.LLData;
import com.datamanager.ConfigManager;
import com.datamanager.ExcelManager;
import com.page.locators.ll.admin.DistrictSettingsLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class DistrictSettingsPage extends CommonFunctionalities implements DistrictSettingsLocators {

	WebDriver driver;
	ConfigManager appData= new ConfigManager("App");
	ConfigManager sys = new ConfigManager();
	ExcelManager excelFile;
	LLData llData;
	public DistrictSettingsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		llData = new LLData();
	}

	/**
	 * To Select school from 'All Schools' drop down
	 */
	public void selectSchoolFromAllSchools(String schoolName) {
		isElementPresent(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN, "All Schools"),LONGWAIT);
		safeActionsClick(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN,"All Schools"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(ALLSCHOOLS_DRPDOWN,schoolName), LONGWAIT);

	}

	/**
	 * To verify 'All Classes' dropdown enabled after selecting a school
	 */
	public void verifyAllClassesDropdownDisplayed() {
		waitForPageToLoad();
		boolean bAllClassesDrpdwnDisplayed = isElementPresent(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN, "All Classes"),LONGWAIT);
		Assert.assertTrue(bAllClassesDrpdwnDisplayed,"All Classes Dropdown is not enabled after selecting school from schools dropdown");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * To Selects class from 'All classes' drop down
	 */
	public void selectClassFromAllClasses(String className) {
		isElementPresent(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN, "All Classes"), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN, "All Classes"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN,className + " LL"), LONGWAIT);

	}

	/**
	 * Verifies Summary tab is highlighted on opening Tools->District settings
	 */
	public void verifySummaryTabHighlighted() {
		Assert.assertTrue(isElementPresent(SUMMARYTAB_ISSELECTED),"Summary Tab is not highlighted by default on Clicking Tools->District settings");
	}

	/**
	 * This Method navigates to the summary frame
	 */
	public void moveToFrame() {
		selectFrame(DISTRICTSETTINGS_FRAME, LONGWAIT);

	}

	public void moveToDefaultFrame() {
		defaultFrame();
	}

	/**
	 * Verifies Summary Tab is loaded or not by checking Implementation summary
	 * table is loaded
	 */
	public void verifySummaryTabLoaded() {

		Assert.assertTrue(isElementPresent(IMPLEMENTATIONSUMMARY_TABLE, LONGWAIT),"Implementation summary table is not loaded on opening 'District Settings'->'Summary' tab ");
	}

	/**
	 * verifies Implementation Summary table data by comparing with the
	 * Implementation summary table available in Vport->My District->Summary
	 * page
	 * 
	 * @param vportSummarytable
	 */

	public void verifyImplementationSummaryTablewithVportSummaryTable(Map<String, String> vportSummarytable) {
		// Map<String, String> map = new HashMap<String, String>();
		List<WebElement> implementationSummaryRowHeadings = LocatorWebElements(IMPLEMENTATIONSUMMARY_TABLEROWS);
		List<WebElement> teachersRowValues = LocatorWebElements(IMPLEMENTATIONSUMMARY_VALUES);
		for (int i = 0; i < implementationSummaryRowHeadings.size(); i++) {

			String rowName = implementationSummaryRowHeadings.get(i).getText();
			String rowValue = teachersRowValues.get(i).getText();
			Assert.assertEquals(vportSummarytable.get(rowName), rowValue, "Implemenation Summary table :" + rowName+ " row value  in Summary tab of Language live is not matched with the Implemenation Summary table in Vport ");
		}
		waitForSecs(3);
	}

	public void verifyAddAndImportButtonsareDisplayedinSummaryPageaAtSchoolLevel()
	{
		Assert.assertTrue(isElementClickable(ADD_BTN, LONGWAIT),"Add button is not displayed and not clickable in 'District Settiings->'Summary' tab at School level");
		Assert.assertTrue(isElementClickable(IMPORT_BTN, LONGWAIT),"Import button is not displayed and not clickable in 'District Settiings->'Summary' tab at School level");
	}
	/**
	 * To Clicks on Roster sub tab in District Settings
	 */
	public void clickOnRosterTab()

	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "ROSTER"),LONGWAIT);
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

		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"Manage Roster","Manage Roster heading is not displayed on loading  'District Settings'->'Roster' tab ");
	}



	/**
	 * To click on ADD STUDENTS button on My CLASS->Roster Page
	 */
	public void clickAddStudentsButtonOnMYClassRostersMainPage()
	{
		safeClick(ADDSTUDENTSTOP_IMG, LONGWAIT);
	}

	/**
	 * To verify whether the page is navigated to create or add new students main page 
	 */
	public void verifyNavigationToCreateStudentsPage()
	{
		Assert.assertTrue(isElementPresent(ADDSTUDENTSTOROSTER_IMG, LONGWAIT));
	}

	/**
	 * To click on Add button on create new students to roster page
	 */
	public void clickAddButtonOnCreateNewStudentsToRosterPage()
	{
		safeClick(ADDSTUDENTSTOROSTER_IMG, LONGWAIT);
	}

	/**
	 * To verify whether the Add New Students popup is displayed or not 
	 */
	public void verifyNavigationToAddNewStudentsPopUp()
	{
		Assert.assertTrue(isElementPresent(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT));
	}

	/**
	 * To fill new student details on Add New students popup
	 * @param stdLastName,stdFirstName,stdID,stdGrade,stdDOB
	 */
	public String fillNewStudentDetailsOnAddNewStudentsPopUp(String stdLastName, String stdFirstName, String stdID, String stdGrade, String stdDOB)
	{
		String studentID=stdID+System.currentTimeMillis();                         
		safeType(STDLASTNAMETEXT_FIELD, stdLastName+System.currentTimeMillis(), LONGWAIT);
		safeType(STDFIRSTNAMETEXT_FIELD, stdFirstName+System.currentTimeMillis(), LONGWAIT);
		safeType(STDIDNUMBERTEXT_FIELD, studentID, LONGWAIT);
		safeSelectOptionInDropDownByVisibleText(STDGRADELEVELTEXT_DRP, stdGrade, LONGWAIT);
		safeType(STDDOB_FIELD, stdDOB, LONGWAIT);

		return studentID;
	}

	/**
	 * To click on Save Changes button on Add New Students Popup
	 */
	public void clickSaveChangesButtonOnAddNewStudentsPopUp()
	{
		safeClick(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT);
	}

	/**
	 * To verify that add new students popup is disappeared from the page
	 */
	public void verifyAddNewStudentsPopUpDisappeared()
	{
		waitUntilElementDisappears(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT);
		waitForPageToLoad(LONGWAIT);
	}

	/**
	 * To click on Return To Class Roster Page on create new students section of class roster page
	 */

	public void clickReturnToClassRosterButton()
	{
		safeJavaScriptClick(RETURNTOCLASSROSTER_IMG, LONGWAIT);
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
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ADDEDSTUDENTID_FIELD, studentId), LONGWAIT), "The student user with id("+studentId+") is not added to the class on My Class->Roster page");
	}
	//
	//	/**
	//	 * To find the number of students are displayed in the Roster table
	//	 * @return
	//	 */
	//	public int GetNumberOfStudentsCountInRosterTable()
	//	{
	//		int noOfStudentsCount;
	//		int currentpageStudents;
	//		//currentpageStudents= LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//		String studentLastName[]=new  String[50];
	//		System.out.println("---------------------"+isElementDisplayed(NEXT_LINK));
	//		if(isElementDisplayed(NEXT_LINK))
	//		{
	//			currentpageStudents= LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//			for(int i=1;i<=LocatorWebElements(RESULTPAGES_LINKS).size();i++){    		
	//				//safeClick(NEXT_LINK, LONGWAIT);
	//				noOfStudentsCount=currentpageStudents+LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//				currentpageStudents = LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//				for(int j=0;j<currentpageStudents;j++)
	//				{
	//					String x=safeGetText(Dynamic.getNewLocator(STUDENTNAMESINROSTER_TABLE, Integer.toString(j+1)),LONGWAIT);
	//					studentLastName[j]=x.split(",")[0];
	//				}
	//				safeClick(NEXT_LINK, LONGWAIT);
	//			}
	//			safeClick(RESULTPAGE_1, LONGWAIT);	
	//		}
	//
	//
	//
	//		return noOfStudentsCount;
	//
	//
	//	}
	/**
	 * This Method reads  Student count and Student Names From Roster tab 
	 * @return
	 */
	//	 
	public Object[] getStudentsCountAndNamesInRosterTable()
	{
		int noOfStudentsCount=0;
		int currentpageStudents;

		ArrayList<String> studentLastName=new ArrayList();
		System.out.println("---------------------"+isElementDisplayed(NEXT_LINK));
		if(isElementDisplayed(NEXT_LINK))

		{

			for(int i=1;i<=LocatorWebElements(RESULTPAGES_LINKS).size();i++){    		
				currentpageStudents = LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
				noOfStudentsCount=noOfStudentsCount+currentpageStudents;
				for(int j=0;j<currentpageStudents;j++)
				{
					String x=safeGetText(Dynamic.getNewLocator(STUDENTNAMESINROSTER_TABLE, Integer.toString(j+1)),LONGWAIT);
					studentLastName.add(x.split(",")[0]);						

				}

				if(!isElementPresent(NEXT_LINK,SHORTWAIT)){
					break;
				}
				safeClick(NEXT_LINK, LONGWAIT);
				//noOfStudentsCount=currentpageStudents+LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
			}

			safeClick(RESULTPAGE_1, LONGWAIT);	
		}
		else
		{
			noOfStudentsCount = LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
			for(int j=0;j<noOfStudentsCount;j++)
			{
				String x=safeGetText(Dynamic.getNewLocator(STUDENTNAMESINROSTER_TABLE, Integer.toString(j+1)),LONGWAIT);
				studentLastName.add(x.split(",")[0]);

			}
		}


		Object[] studentDetails={noOfStudentsCount,studentLastName};
		return studentDetails;


	}

	//	/**
	//	 * To get all student last names from the Roster table and returns them
	//	 * 	
	//	 * @return
	//	 */
	//	public String[] getAllStudentsNamesFromRosterTable(int studentInRoster)
	//	{
	//		/* int noOfStudents=GetNumberOfStudentsCountInRosterTable();
	//    	 String studentLastName[]=new  String[noOfStudents];
	//    	 for(int i=0;i<noOfStudents;i++)
	//    	  {
	//    		  String x=safeGetText(Dynamic.getNewLocator(STUDENTNAMESINROSTER_TABLE, Integer.toString(i+1)),LONGWAIT);
	//    		  studentLastName[i]=x.split(",")[0];
	//    	  }*/
	//
	//		int noOfStudentsCount =studentInRoster;
	//		int currentpageStudents;// = LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//		String studentLastName[]=new  String[noOfStudentsCount];
	//		//     	System.out.println("---------------------"+isElementDisplayed(NEXT_LINK));
	//		while(isElementDisplayed(NEXT_LINK))
	//		{
	//			//for(int i=1;i<LocatorWebElements(RESULTPAGES_LINKS).size();i++){   
	//				currentpageStudents = LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//				for(int j=0;j<currentpageStudents;j++)
	//				{
	//					String x=safeGetText(Dynamic.getNewLocator(STUDENTNAMESINROSTER_TABLE, Integer.toString(j+1)),LONGWAIT);
	//					studentLastName[j]=x.split(",")[0];
	//				}
	//				safeClick(NEXT_LINK, LONGWAIT);
	//				//noOfStudentsCount=noOfStudentsCount+LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
	//			//}
	//			//safeClick(RESULTPAGE_1, LONGWAIT);	
	//		}
	//		return studentLastName;
	//	}


	/**
	 * To Clicks on Students sub tab in District Settings
	 */
	public void clickOnStudentsTab()

	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "STUDENTS"),LONGWAIT);
	}

	public void verifyNavigationToStudentsTab()
	{
		Assert.assertTrue(isElementPresent(RECORDINGNOTREQUIRED_TEXT, LONGWAIT), "Could not navigate to Students Tab");
	}

	/**
	 * Purpose-To configure settings for the student users
	 * @param studentIds
	 */

	public void configureSettingsForStudents(String[] studentIds)
	{


		Assert.assertTrue(isElementPresent(RECORDINGNOTREQUIRED_TEXT, LONGWAIT), "Students tab is not loaded after refreshing");

		waitForSecs(30, "Waiting page to load");
		for(int i=0;i<studentIds.length;i++)
		{

			waitForSecs(10);
			safeClick(Dynamic.getNewLocator(EDITBUTTONFORSTUDENT_BTN, studentIds[i]), LONGWAIT);
			Assert.assertTrue(isElementPresent(MOVESTUDENTCOURSEPOSITION_SECTION, LONGWAIT), "Progress And Placement Window is not displayed when clicked on edit button for the student with id"+studentIds[i]);
			safeClick(LEVELMENU_DRP, LONGWAIT);
			safeClick(Dynamic.getNewLocator(LEVELSELECTION_OPTION,appData.getProperty("Student"+(i+1)+".LevelOption")), LONGWAIT);
			safeClick(UNITMENU_DRP, LONGWAIT); 
			safeClick(Dynamic.getNewLocator(UNITSELECTION_OPTION,appData.getProperty("Student"+(i+1)+".UnitOption")), LONGWAIT);    		   
			safeClick(LESSONMENU_DRP, LONGWAIT);
			safeClick(Dynamic.getNewLocator(LESSIONSELECTION_OPTION,appData.getProperty("Student"+(i+1)+".LessonOption")), LONGWAIT);    		  
			safeClick(MOVESTUDENT_BTN, LONGWAIT);
			waitUntilElementDisappears(MOVESTUDENTCOURSEPOSITION_SECTION, LONGWAIT); 

			if((appData.getProperty("Student"+(i+1)+".RecordingRequired")).equalsIgnoreCase("NO"))
			{
				safeClick(Dynamic.getNewLocator(RECORDINGOFFFORSTUDENT_BTN, studentIds[i]), LONGWAIT);
				safeClick(SAVEANDUPDATE_BTN, LONGWAIT);
			}	  
		}

		waitForPageToLoad();
	}

	/**
	 * To Clicks on Targets sub tab in District Settings
	 */
	public void clickOnTargetsTab()

	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS,"TARGETS"),LONGWAIT);
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
		Assert.haultonfailure=false;
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
		Assert.assertAll();
	}

	/**
	 * To Clicks on Teachers and Classes sub tab in District Settings
	 */
	public void clickOnTeachersAndClassesTab()

	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "TEACHERS & CLASSES"),LONGWAIT);
	}

	/**
	 * Verifies Teachers and Classes  Tab is loaded or not by 
	 */
	public void verifyTeachersAndClassesTabLoaded() {

		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"Teachers and Classes","Teachers and Classes heading is not displayed on loading  'District Settings'->'Teachers&Classes' tab ");
	}

	/**
	 * To Clicks on Licenses sub tab in District Settings
	 */
	public void clickOnLicensesTab()
	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "LICENSES"),LONGWAIT);
	}

	/**
	 * Verifies Licenses Tab is loaded or not by 
	 */
	public void verifyLicensesTabLoaded() {

		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"Licenses","Licenses heading is not displayed on loading  'District Settings'->'Licenses' tab ");
	}
	/**
	 * Clicks on Student sub tab in Licenses tab
	 */
	public void clickOnStudentLicenseTab()
	{
		safeClick(Dynamic.getNewLocator(LICENSES_SUBTABS,"Student"), LONGWAIT);

	}
	/**
	 * Public void verify Licenses Purchased table is loaded or not
	 *  
	 */
	public void verifyLicensesPurchasedTableisLoaded()
	{
		Assert.assertTrue(isElementPresent(LICENSESPURCHASEDTABLE_HEADING, LONGWAIT),"Licenses Purchased tab is not loaded in Licenses Sub tabs");
	}
	/**
	 * Verify track name values in Licenses purchased table data by comparing with the data read from Licenses purchased table in My Schools tab 
	 * @param trackName
	 * @return
	 */
	public void compareLicensesPurchasedTrackDetailsinLLwithVportLicensesPurchasedTableData(String trackName,String[] trackLicensesDatafromvport ){

		String readlicensesDetails[]=new String[2];

		for(int i=0;i<=1;i++){	
			readlicensesDetails[i]=safeGetText(Dynamic.getNewLocator(LICENESESPURCHASEDTABLE_ROWVALUES,new String[]{trackName,Integer.toString(i+1)}),LONGWAIT).trim();
			System.out.println(readlicensesDetails[i]);

			Assert.assertEquals(readlicensesDetails[i], trackLicensesDatafromvport[i],"The Licenses table data in language live product at "+readlicensesDetails[i]+" is not matched with the licenses table data from Vport at "+trackLicensesDatafromvport[i]);
		}
	}

	/**
	 * Verify School name Licenses purchased table data by comparing with the data read from Licenses purchased table in My Schools tab 
	 * @param trackName
	 * @return
	 */
	public void compareLicensesPurchasedSchoolDetailsinLLwithVportLicensesPurchasedTableData(String schoolName,String[] schoolLicensesDatafromvport ){

		String readlicensesDetails[]=new String[2];

		for(int i=0;i<=1;i++){

			readlicensesDetails[i]=safeGetText(Dynamic.getNewLocator(LICENESESPURCHASEDTABLE_ROWVALUES,new String[]{schoolName,Integer.toString(i+1)}),LONGWAIT).trim();
			System.out.println(readlicensesDetails[i]);
			Assert.assertEquals(readlicensesDetails[i], schoolLicensesDatafromvport[i],"The Licenses table data in language live product at "+readlicensesDetails[i]+" is not matched with the licenses table data from Vport at "+schoolLicensesDatafromvport[i]);
		}
	}
	//clicks on Teachers sub tab 
	public void clickOnTeacherLicenseTab()
	{
		safeClick(LICENSES_SUBTABS, LONGWAIT);

	}
	/**
	 * To Clicks on IMport Students  sub tab in District Settings
	 */
	public void clickOnImportStudentsTab()
	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "IMPORT STUDENTS"),LONGWAIT);
	}

	/**
	 * Verifies Licenses Tab is loaded or not by 
	 */
	public void verifyImportStudentsTabLoaded() {

		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"Import Students","Import Students heading is not displayed on loading  'District Settings'->'Import Students' tab ");

	}
	/**
	 * Clicks Download Template button in the 'Option 1: Roster students into classes' pane in 'Import Students' tab  
	 */

	public void clickOnDownloadTemplateButtoninRosterStudentsintoClassesPane()
	{

		safeActionsClick(DOWNLOADTEMPLATE_BTNINROSTERSTUDENTINTOCLASS, LONGWAIT);
		waitForPageToLoad();
		waitForSecs(30);
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.internetExplorerSave, "internetExplorerSave", VERYLONGWAIT);
			waitForSecs(15,"Waiting to click on Explorer Save");
		}
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
	/**
	 * To Enter Stundent Details into Downloaded Excel Sheet
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
	public void uploadExcelSheetWithStudentDetials(String excelPath)
	{
		waitForSecs(5);
		//isElementClickable(BROWSE_BTNINROSTERSTUDENTINTOCLASS, MEDIUMWAIT);
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
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
		{
			safeType(BROWSE_BTNINROSTERSTUDENTINTOCLASS,excelPath, LONGWAIT);
			safeJavaScriptClick(SUBMIT_BTNINROSTERSTUDENTINTOCLASS,MEDIUMWAIT);

		}

	}
	/**
	 * verify Excel sheet is uploaded correctly or not 
	 */
	public void verifyExcelSheetUploadedCorrectly()
	{
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.FileUploadSuccessfulInIE, "IE enter file path" , VERYLONGWAIT);
			waitForSecs(10);
		}
		else
		{
			isElementPresent(Dynamic.getNewLocator(UPLOADEDFILECHECKING_STATUS,"1"),VERYLONGWAIT);
			Assert.assertEquals(safeGetText(Dynamic.getNewLocator(UPLOADEDFILECHECKING_STATUS,"1"),VERYLONGWAIT),"File Received","File received text is not displayed on uploading a Excel sheet with student details in 'District Settings'->'Import Students' tab ");
			Assert.assertEquals(safeGetText(Dynamic.getNewLocator(UPLOADEDFILECHECKING_STATUS,"2"),VERYLONGWAIT),"Checking File","Checking File text is not displayed on uploading a Excel sheet with student details in 'District Settings'->'Import Students' tab ");
		}
	}
	/**
	 * Clicks on Proceed with Import button after uploading a excel sheet 
	 */
	public void clickProceddwithImportButton()
	{
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.ProceedWithImportInIE, "ProceedWithImportInIE" , VERYLONGWAIT);
			waitForSecs(10);
		}
		else
		{
			safeClick(PROCEEDWITHIMPORT_BTN);
			Assert.assertTrue(isElementPresent(IMPORTINGPOPUP,LONGWAIT),"Importing pop up is not displayed on clciking Proceed with Import button in  'District Settings'->'Import Students' tab");
		}
	}
	/**
	 * Verify Excel sheet details are imported into application or not  
	 */
	public void verifyExcelSheetImportedCorrectly() 
	{

		waitForSecs(6);
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("internet explorer"))
		{
			safeClickUsingSikuli(llData.SuccessfulUploadInIE, "SuccessfulUploadInIE" , VERYLONGWAIT);
			waitForSecs(10);
		}
		else
		{
		isElementPresent(IMPORTCOMPLETE_STATUS,VERYLONGWAIT);
		Assert.assertEquals(safeGetText(IMPORTCOMPLETE_STATUS,VERYLONGWAIT),"Your file has been successfully imported and the process is now complete.","'Your file has been successfully imported and the process is now complete' text is not displayed on uploading a Excel sheet with student details in 'District Settings'->'Import Students' tab ");
		}
		waitForSecs(6);
	}


	/**
	 * To Clicks on Schools  sub tab in District Settings
	 */
	public void clickOnSchoolsTab()
	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "SCHOOLS"),LONGWAIT);
	}

	/**
	 * Verifies Schools Tab is loaded or not by 
	 */
	public void verifySchoolsTabLoaded() {

		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"Schools","Schools heading is not displayed on loading  'District Settings'->'Schools' tab ");

	}
	/**
	 * To Verify User can activates/Deactivates the select check box of school
	 * @param schoolName
	 */

	public void verifyUserCanActivatesDeactivatesSchoolInSchoolsTab(String schoolName)
	{

		if(isElementSelected(Dynamic.getNewLocator(SELECT_CHKBOXOFSCHOOL,schoolName)));
		{
			safeUnCheck(Dynamic.getNewLocator(SELECT_CHKBOXOFSCHOOL,schoolName),LONGWAIT);
		}

		safeCheck(Dynamic.getNewLocator(SELECT_CHKBOXOFSCHOOL,schoolName),LONGWAIT);
		safeClick(SAVECHANGES_BTN, LONGWAIT);
	}

	/**
	 * To Clicks on School Users  sub tab in District Settings
	 */
	public void clickOnSchoolUsersTab()
	{
		safeClick(Dynamic.getNewLocator(DISTRICTSETTINGS_SUBTABS, "SCHOOL USERS"),LONGWAIT);
	}

	/**
	 * Verifies School Users Tab is loaded or not by 
	 */
	public void verifySchoolUsersTabLoaded() {

		Assert.assertEquals(safeGetText(DISTRICTSETTINGSSUBTABS_HEADING, LONGWAIT),"School Users","School Users heading is not displayed on loading  'District Settings'->'Schools Users' tab ");

	}
}

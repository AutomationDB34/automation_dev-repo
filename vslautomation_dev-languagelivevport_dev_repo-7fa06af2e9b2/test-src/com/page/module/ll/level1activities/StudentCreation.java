package com.page.module.ll.level1activities;

import org.openqa.selenium.WebDriver;

import com.datamanager.ConfigManager;
import com.page.locators.ll.level1activites.StudentCreationLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;


public class StudentCreation extends CommonFunctionalities implements StudentCreationLocators  {

	private WebDriver driver;

	ConfigManager appData = new ConfigManager("App");

	public StudentCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;	
	}
	/**
	 * Purpose - To click on Class Settings tab
	 */

	public void clickOnClassSettingsTab()
	{
		safeClick(CLASSSETTINGS_LINK, LONGWAIT);
	}

	/**
	 * Purpose - To click on Class Roster tab
	 */
	public void clickOnRosterTab()
	{
		safeClick(ROSTER_TAB, LONGWAIT);
	}
	/**
	 * Purpose - To switch to Roster tab frame and to click on Add Students tab
	 */
	public void clickOnaddStudentsButton()
	{
		selectFrame(ROSTERFMAINPAGE_IFRAME, LONGWAIT);
		safeClick(ADDSTUDENTSMAINPAGE_BTN, LONGWAIT);
	}

	/**
	 * Purpose - To click on Add Button
	 */

	public void clickAddButton()
	{
		safeClick(ADD_BTN, LONGWAIT);
	}

	/**
	 * Purpose-To fill new student details on Add New students popup
	 * @param stdID,stdGrade,stdDOB,numberOfStudentsToCreate
	 */
	public String[] fillNewStudentDetailsOnAddNewStudentsPopUp(String stdID, String stdGrade, String stdDOB,int numberOfStudentsToCreate)
	{
		String[] students = new String[numberOfStudentsToCreate];

		for(int i=0;i<numberOfStudentsToCreate;i++)
		{
			String studentID=stdID+System.currentTimeMillis();

			students[i]=studentID;

			safeType(Dynamic.getNewLocator(STDLASTNAMETEXT_FIELD,Integer.toString(i)),studentID, LONGWAIT);
			safeType(Dynamic.getNewLocator(STDFIRSTNAMETEXT_FIELD,Integer.toString(i)), studentID, LONGWAIT);
			safeType(Dynamic.getNewLocator(STDIDNUMBERTEXT_FIELD,Integer.toString(i)), studentID, LONGWAIT);
			safeSelectOptionInDropDownByVisibleText(Dynamic.getNewLocator(STDGRADELEVELTEXT_DRP,Integer.toString(i)), stdGrade, LONGWAIT);
			safeType(Dynamic.getNewLocator(STDDOB_FIELD,Integer.toString(i)), stdDOB, LONGWAIT);            
		}

		return students;
	}

	/**
	 * To click on Save Changes button on Add New Students Popup
	 */
	public void clickSaveChangesButtonOnAddNewStudentsPopUp()
	{
		safeClick(SAVEADDEDSTUDENTCHANGES_IMG, LONGWAIT);
	}

	/**
	 * To verify that add new students pop-up is disappeared from the page
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

	public void selectLiveStudentCheckboxAndEnterUNAndPwdForStudent(String[] studentIds)
	{
		waitForSecs(8,"Waiting for Page to load");
		for(int i=0;i<studentIds.length;i++)
		{
			waitForPageToLoad();
			while(!isElementPresent(Dynamic.getNewLocator(LIVESTUDENT_CHECKBOX,studentIds[i]), MEDIUMWAIT) & isElementPresent(NEXT_LINK, MEDIUMWAIT))
			{
				safeClick(NEXT_LINK, MEDIUMWAIT);
				waitForPageToLoad();
			}
			safeClick(Dynamic.getNewLocator(LIVESTUDENT_CHECKBOX,studentIds[i]), LONGWAIT);
			safeClearAndType(Dynamic.getNewLocator(STUDENTUSERID_FIELD,studentIds[i]), studentIds[i], LONGWAIT);
			safeClearAndType(Dynamic.getNewLocator(STUDENTPWD_FIELD,studentIds[i]), studentIds[i], LONGWAIT);
		}
	}
	/**
	 * Purpose-To save credentials for the student users and also to switch to default content
	 */
	public void saveCredentialsForStudents()
	{
		safeClick(SAVECHANGES_BTN, LONGWAIT);
		defaultFrame();
	}

	/**
	 * Purpose-To click on students tab
	 */

	public void clickOnStudentsTab()
	{
		safeClick(STUDENTS_TAB, LONGWAIT);
	}

	/**
	 * Purpose-To verify navigation to students tab
	 */

	public void verifyNavigationToStudentsTab()
	{
		Assert.assertTrue(isElementPresent(RECORDINGNOTREQUIRED_TEXT, LONGWAIT), "Could not navigate to Students Tab");
	}

	/**
	 * Purpose-To configure settings for the student users
	 * @param studentIds,StudentLevelOption,StudentUnitOption,StudentLessonOption,StudentRecordingOption
	 */

	public void configureSettingsForStudents(String[] studentIds,String StudentLevelOption,String StudentUnitOption,String StudentLessonOption,String StudentRecordingOption)
	{

		refresh();
		Assert.assertTrue(isElementPresent(RECORDINGNOTREQUIRED_TEXT, LONGWAIT), "Students tab is not loaded after refreshing");

		for(int i=0;i<studentIds.length;i++)
		{
			waitForSecs(50);
			waitForPageToLoad(VERYLONGWAIT);
			safeJavaScriptClick(Dynamic.getNewLocator(EDITBUTTONFORSTUDENT_BTN, studentIds[i]), LONGWAIT);
			Assert.assertTrue(isElementPresent(MOVESTUDENTCOURSEPOSITION_SECTION, LONGWAIT), "Progress And Placement Window is not displayed when clicked on edit button for the student with id"+studentIds[i]);
			safeClick(LEVELMENU_DRP, LONGWAIT);
			safeClick(Dynamic.getNewLocator(LEVELSELECTION_OPTION,StudentLevelOption), LONGWAIT);
			safeClick(UNITMENU_DRP, LONGWAIT); 
			safeClick(Dynamic.getNewLocator(UNITSELECTION_OPTION,StudentUnitOption), LONGWAIT);         
			safeClick(LESSONMENU_DRP, LONGWAIT);
			safeClick(Dynamic.getNewLocator(LESSIONSELECTION_OPTION,StudentLessonOption), LONGWAIT);        
			safeClick(MOVESTUDENT_BTN, LONGWAIT);
			waitUntilElementDisappears(MOVESTUDENTCOURSEPOSITION_SECTION, LONGWAIT); 

			if(StudentRecordingOption.equalsIgnoreCase("NO"))
			{
				safeClick(Dynamic.getNewLocator(RECORDINGOFFFORSTUDENT_BTN, studentIds[i]), LONGWAIT);
				safeClick(SAVEANDUPDATE_BTN, LONGWAIT);
			}   
		}

		waitForPageToLoad();
	}

}

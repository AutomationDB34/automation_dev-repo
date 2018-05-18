package com.page.module.vport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.datamanager.ConfigManager;
import com.page.locators.vport.DistrictAdminMySchoolLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class DistrictAdminMySchoolPage extends CommonFunctionalitiesVPort implements DistrictAdminMySchoolLocators {

	WebDriver driver;
	ConfigManager config = new ConfigManager("DependentData");
	Logger log = Logger.getLogger(getClass());

	public DistrictAdminMySchoolPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	/**
	 * To Verifies My School page is loaded or not 
	 */
	public void verifyMySchoolPageIsLoaded()
	{
		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(MYSCHOOL_SUBTABS, "Summary")),"Summary Sub tab is not laoded on clicking 'My District' sub tab");
		Assert.assertTrue(isElementDisplayed(IMPLEMENTATION_TABLEEXISTS), "Implementation Summary table is not loaded in My District->Summary page");
	}
	
	
	/**
	* click on Summary tab
	*/

	 public void clickSummaryTab()
	 {
		 safeClick(Dynamic.getNewLocator(MYSCHOOL_SUBTABS, "Summary"));
	 }
	 
	 /**
	  * To verifies Summary tab is loaded or not 
	  */
	  public void verifySummaryTabLoaded()
	  {
		  Assert.assertEquals(safeGetText(SUBTABS_TITLE, LONGWAIT),"Setup Summary", "Title in My District->Summary tab is not displayed ");
		  
	  }
	  /**
	   * To reads the Implementation Summary table rows and values and stores in Map 
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
	 * To verify My school tab is loaded
	 **/
	public void verifyMySchoolPage(String schoolName) {
		waitForPageToLoad();
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCREENTITLE, "2"), LONGWAIT), schoolName,"School Name doesn't matched in title of page");
		boolean bInstructionalPlanExists = isElementDisplayed(INSTRUCTIONALPLAN);
		Assert.assertTrue(bInstructionalPlanExists, "Instrctional plan heading doesn't exists in My Schools page ");
	}


	
	/**
	 * To navigate to Teachers and Classes sub tab
	 **/
	public void navigateToTeachersAndClassesSubtab() {
		waitForPageToLoad();	
		safeClick(TEACHERSANDCLASSES_SUBTAB);
	}

	/**
	 * To verify Teacher and Classes sub tab is loaded
	 **/
	public void verifyTeachersAndClassesSubtab() {

		boolean bAddNewStaffExists = isElementPresent(ADDNEWSTAFF_BTN, LONGWAIT);
		Assert.assertTrue(bAddNewStaffExists, "ADD New Staff button doesn't exists");
	}

	/**
	 * To create teacher with first name, last name and email details
	 	 * @param lastName,UserId,Password
	 */
	public String addTeacher(String lastName, String firstName, String email) {

		//lastName = lastName+UtilityMethods.get4DRandomNumber();
		safeClick(ADDNEWSTAFF_BTN);
		waitForPageToLoad();
		safeType(LASTNAME_FIELD, lastName, LONGWAIT);
		safeType(FIRSTNAME_FIELD, firstName);
		safeType(EMAIL_FIELD, email);
		safeClick(SAVECHANGES_BTN);
		waitForPageToLoad();
		return lastName;

	}

	/**
	 * To edit UserID and Password of teacher and returns userID
	 * 
	 * @param lastName,UserId, Password
	 */

	public String editTeacherandSave(String lastName, String userID, String password) {
		String randomNumber = UtilityMethods.get4DRandomNumber();
		//Teacher userName and Last name both are same given
		safeClick(Dynamic.getNewLocator(EDITUSER_BTN, lastName));
		waitForPageToLoad();
		userID = userID+randomNumber;
		safeClearAndType(Dynamic.getNewLocator(USERIDANDPASSWORD_FIELDS, new String[] {lastName,"1"}), userID);
		safeClearAndType(Dynamic.getNewLocator(USERIDANDPASSWORD_FIELDS, new String[] { lastName, "2"}), userID);
		safeClick(Dynamic.getNewLocator(SAVECHANGESBTN_TEACHER, lastName));
		waitForSecs(4);
		config.writeProperty("VPORT_006_TeacherUserID", userID);
		log.info("Writing the data is successful."+ userID);
		return userID;

	}

	/**
	 * To add two classes A and B to school
	 * 
	 * @param lastName
	 */
	public String[] addClassesandSave(String lastName,String class1,String class2,String class3) {
		String[] classNames = new String[3];
		//Teacher userName and Last name both are same given
		//String lastName = config.getProperty("VPORT_006_TeacherUserID");
		waitForPageToLoad();
		safeClick(Dynamic.getNewLocator(ADDCLASSES_BTNS, new String[] { lastName, class1 }));
		classNames[0] = lastName + " Level "+class1;
		waitForPageToLoad();
		safeClick(Dynamic.getNewLocator(ADDCLASSES_BTNS, new String[] { lastName, class2 }));
		classNames[1] = lastName + " Level "+class2;
		waitForPageToLoad();
		safeClick(Dynamic.getNewLocator(ADDCLASSES_BTNS, new String[] { lastName, class3 }));
		classNames[2] = lastName + " Level "+class3;
		safeClick(SAVETEACHERSANDCLASSES);
		config.writeProperty("VPORT_006_CLASS1", classNames[0]);
		config.writeProperty("VPORT_006_CLASS2", classNames[1]);
		config.writeProperty("VPORT_006_CLASS3", classNames[2]);
		log.info("Writing the data is successful."+ classNames);
		return classNames;

	}

	/**
	 * To verify classes are added to school
	 * 
	 * @param lastName
	 */

	public void verifyAddedClasses(String lastName,String class1, String class2 , String class3) {
		String userId = config.getProperty("VPORT_006_TeacherUserID");
		boolean bLevelAClassAdded = isElementDisplayed(Dynamic.getNewLocator(ADDEDCLASSES, new String[] { userId, lastName + " Level "+class1 }));
		Assert.assertTrue(bLevelAClassAdded, userId + "Level " +class1+" class is not added ");

		boolean bLevelBClassAdded = isElementDisplayed(
				Dynamic.getNewLocator(ADDEDCLASSES, new String[] { userId, lastName + " Level "+class2 }));
		Assert.assertTrue(bLevelBClassAdded, userId + "Level "+class2+"class is not added ");
		
		boolean bLevelDClassAdded = isElementDisplayed(
				Dynamic.getNewLocator(ADDEDCLASSES, new String[] { userId, lastName + " Level "+class3 }));
		Assert.assertTrue(bLevelDClassAdded, userId + "Level "+class3+"class is not added ");

	}

	/**
	 * To verify classes from class drop down
	 * 
	 * @param lastName
	 */
	public void verifyClassesinClassesDropdown(String lastName,String class1, String class2 , String class3) {
		//String userID = config.getProperty("VPORT_006_TeacherUserID");
		safeClick(CLASSNAME_DRP);

		boolean bClassNameexistsA = isElementVisible(Dynamic.getNewLocator(CLASSNAME_OPTION, lastName + " Level "+class1));
		Assert.assertTrue(bClassNameexistsA, lastName + " Level "+class1+" class is not found in classes dropdown ");

		boolean bClassNameexistsB = isElementVisible(Dynamic.getNewLocator(CLASSNAME_OPTION, lastName + " Level "+class2));
		Assert.assertTrue(bClassNameexistsB, lastName + "Level "+class2+" class is not found in classes dropdown ");
		
		boolean bClassNameexistsD = isElementVisible(Dynamic.getNewLocator(CLASSNAME_OPTION, lastName + " Level "+class3));
		Assert.assertTrue(bClassNameexistsD, lastName + "Level "+class3+" class is not found in classes dropdown ");
		
		safeClick(CLASSNAME_DRP);
	

	}

	/**
	 * To select class option from class drop down
	 * 
	 * @param classname
	 */
	public DistrictAdminMyClassPage selectClassFromClassDropDown(String classname) {
		safeClick(CLASSNAME_DRP, LONGWAIT);
		waitForSecs(3);
		safeClick(Dynamic.getNewLocator(CLASSNAME_OPTION, classname), LONGWAIT);
		waitForPageToLoad();
		waitForSecs(3);
		return new DistrictAdminMyClassPage(driver);	
	}
	
	/**
	 * Purpose-- To add class and licenses to teacher user to be used in language live welcome page verification
	 */
	
	public void addClassAndLicencesToTeacher(String teacherLastName)
	{
		waitForSecs(15, "Waiting for Page to Load");
		waitForPageToLoad(VERYLONGWAIT);
		safeClick(Dynamic.getNewLocator(ADDCLASS_BTN, teacherLastName), LONGWAIT);
		safeClick(Dynamic.getNewLocator(CHECKLICENCE_BTN, teacherLastName), LONGWAIT);
		safeClick(SAVETEACHERSANDCLASSES);
	}
	/**
	 * To navigate to Licenses tab
	 */
	
	
	public void clickOnLicensesSubtab() {
		waitForPageToLoad();
		safeClick(Dynamic.getNewLocator(MYSCHOOL_SUBTABS, "Licenses"));
	}

	/**
	 * To verify Licenses sub tab is loaded
	 **/
	public void verifyLicensesSubtab() {

		Assert.assertEquals(safeGetText(SUBTABS_TITLE,LONGWAIT),"Licenses","Licenses sub tab heading is not matched");
	}
	/**
	 * To click on Student sub tab in License Tab
	 */
	public void clickOnStudentLicenseTab()
	{
		safeClick(Dynamic.getNewLocator(LICENSES_SUBTABS,"Student"), LONGWAIT);
		
	}

	/**
	 * Public void verify Licenses Purchased table is loaded or not
	 * 
	 */
	public void verifyLicensesPurchasedTableisLoaded() {
		Assert.assertTrue(isElementPresent(LICENSESPURCHASEDTABLE_HEADING, LONGWAIT),"Licenses Purchased tab is not loaded in Licenses Sub tabs");
	}

	/**
	 * To get the Track licenses details(purchased and Used) from Licenses Purchased Table
	 
	 * @param trackName
	 * @return
	 */
	public String[] getTrackLicensesPurchasedDetailsFromLicensesPurchasedtable(String trackName) {

		String licensesDetails[] = new String[2];

		for (int i = 1; i <= 2; i++) {

			licensesDetails[i - 1] = safeGetText(Dynamic.getNewLocator(LICENESESPURCHASEDTABLE_ROWVALUES,new String[] { trackName, Integer.toString(i) }), LONGWAIT).trim();
		}
		return licensesDetails;

	}

	/**
	 * To get the school licenses details(purchased and Used) from LicensesPurchased Table
	 * @param schoolName
	 * @return
	 */
	public String[] getSchoolLicensesPurchasedDetailsFromLicensesPurchasedtable(String schoolName) {

		String licensesDetails[] = new String[2];

		for (int i = 1; i <= 2; i++) {

			licensesDetails[i - 1] = safeGetText(Dynamic.getNewLocator(LICENESESPURCHASEDTABLE_ROWVALUES,new String[] { schoolName, Integer.toString(i) }), LONGWAIT).trim();
		}
		return licensesDetails;

	}

	/**
	 * clicks on Teacher Licenses tab
	 */
	public void clickOnTeacherLicenseTab() {
		safeClick(LICENSES_SUBTABS, LONGWAIT);

	}
	public DistrictAdminMyClassPage clickOnMyClassTab() {
		safeClick(MYCLASS_TAB , MEDIUMWAIT);
		return new DistrictAdminMyClassPage(driver);
	}
	
	public VportTrackFilterPage navigateToFiltersPage() {
		safeClick(LOGO_ICON, MEDIUMWAIT);
		return new VportTrackFilterPage(driver);
	}
	
	public String[] addClassesandSaveofLL(String lastName) {
		String[] classNames = new String[3];
		//Teacher userName and Last name both are same given
		//String lastName = config.getProperty("VPORT_006_TeacherUserID");
		waitForPageToLoad();
		safeClick(Dynamic.getNewLocator(ADDCLASSES_BTNS_LL,  lastName));
		
		safeClick(SAVETEACHERSANDCLASSES);
		
		return classNames;

	}
	public void assignLicenseToTeacher() {
		waitForSecs(5);
		safeClick(TEACHER_LICENSE, MEDIUMWAIT);
		safeClick(SAVE_CHANGES_BTN, MEDIUMWAIT);
		waitForSecs(3);
		
	}

}

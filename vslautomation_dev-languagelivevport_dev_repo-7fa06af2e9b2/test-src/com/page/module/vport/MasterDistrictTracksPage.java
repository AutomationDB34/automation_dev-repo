package com.page.module.vport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.data.testdata.VportData.UserRole;
import com.datamanager.ConfigManager;
import com.googlecode.javacv.FrameGrabber.Array;
import com.page.locators.vport.MasterDistrictTracksLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class MasterDistrictTracksPage extends SafeActions implements MasterDistrictTracksLocators{


	private WebDriver driver;
	ConfigManager config = new ConfigManager("App");
	Logger log = Logger.getLogger(getClass());

	//Constructor to define/call methods	 
	public MasterDistrictTracksPage(WebDriver driver)
	{		
		super(driver);
		this.driver = driver;
	} 

	/**
	 * 
	 * Purpose- To verify whether Master page of Districts/Tracks is displayed
	 **/
	public void verifyMasterDistrictTracksPage() {
		boolean bIsDistrictSubtabExists = isElementPresent(DISTRICT_SUBTAB, MEDIUMWAIT);
		Assert.assertTrue(bIsDistrictSubtabExists, "District Subtab doesn't  exist");
	}


	/**
	 * Purpose- Navigating to Schools sub tab in master page in 'District/Tracks' tab
	 */
	public void navigateToSchoolsSubtab() {
		safeClick(SCHOOLS_SUBTAB, SHORTWAIT);
	}

	/**
	 * Purpose- Verifying Schools sub tab is loaded or not
	 */
	public void verifySchoolsSubtab() {
		boolean bAddSchoolButtonExists = isElementPresent(ADDSCHOOL_BTN, MEDIUMWAIT);
		Assert.assertTrue(bAddSchoolButtonExists, "Add School button doesn't exists");
	}



	/**
	 * Purpose- To create a school
	 * 
	 */
	public String[] CreateSchool(String schoolName, String code, String address1, String city, String zipCode) {

		long randomNumber =  UtilityMethods.getRandomNumberMillis();
		schoolName = schoolName+randomNumber;
		code = code+randomNumber;
		safeClick(ADDSCHOOL_BTN, MEDIUMWAIT);
		safeType(SCHOOLNAME_FIELD, schoolName, SHORTWAIT);
		safeType(CODE_FIELD, code, SHORTWAIT);
		safeType(ADDRESS1_FIELD, address1, SHORTWAIT);
		safeType(CITY_FIELD, city, SHORTWAIT);
		safeType(ZIP_FIELD, zipCode, SHORTWAIT);
		safeClick(SAVECHANGES_BTN, SHORTWAIT);
		//Storing the data to Properties file
		/*config.writeProperty("VPORT_002_SchoolName", schoolName);
		config.writeProperty("VPORT_002_SchoolCode", schoolName);*/
		String schoolDetails[] = {schoolName,code};
		return schoolDetails;
	}

	/**
	 * Purpose- To verify school details
	 * 
	 */
	public void verifySchoolDetails(String schoolName, String code,String city) {

		// verify created school name is existed or not
		boolean bSchoolNameExists = isElementPresent(Dynamic.getNewLocator(SCHOOLNAME, schoolName));
		Assert.assertTrue(bSchoolNameExists, "Unable to create school");

		// Verify school code
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(CODEANDCITY, new String[] {schoolName, "4" }), MEDIUMWAIT), code, "Code doesn't match");

		// Verify City
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(CODEANDCITY, new String[] {schoolName, "5" }), MEDIUMWAIT), city, "City doesn't match");

	}

	/**
	 * Purpose- To navigate to Users tab under 'District/tracks' 
	 * 
	 */
	public void navigateToUsersSubtab() {
		safeClick(USERS_SUBTAB, SHORTWAIT);
	}

	/**
	 * Purpose- To verify  Users  tab under 'District/tracks'
	 * 
	 */
	public void verifyUsersSubtab() {

		Assert.assertTrue(isElementPresent(DISTRICTUSERTYPE_SUBTAB, MEDIUMWAIT), "District User type subtab  doesn't exists");
		Assert.assertTrue(isElementPresent(SCHOOLUSERTYPE_SUBTAB, MEDIUMWAIT), "District User type subtab  doesn't exists");
	}

	/**
	 * Purpose- To click 'Add User' button under 'District' sub tab of 'Users' tab 
	 * 
	 */
	public void clickAddUser() {
		safeClick(ADDUSER_BTN, MEDIUMWAIT);
	}

	/**
	 * Purpose- Verify 'Add District User' page is loaded or not 
	 * 
	 */

	public void verifyAddDistrictUserPage() {

		Boolean bAddDistrictUserHeadingExists = isElementPresent(ADDDISTRICTUSER_HEADING, MEDIUMWAIT);
		Assert.assertTrue(bAddDistrictUserHeadingExists, "District User type sub tab  doesn't exists");
	}

	/**
	 * Purpose- To create District user 
	 * 
	 */

	public String addDistrictUser(String login, String firstName, String lastName, String password) {

		login = login+UtilityMethods.getRandomNumberMillis();
		safeType(DISTUSERFIRSTNAME_FIELD, firstName);
		safeType(DISTUSERLASTNAME_FIELD, lastName);
		safeType(DISTUSERLOGIN_FIELD, login);
		safeClearAndType(DISTUSERPASSWORD_FIELD, password);
		safeClearAndType(DISTUSERRETYPEPASSWORD_FIELD, password);
		safeClick(ADDNEWROLE_BTN, SHORTWAIT);
		safeClick(SAVECHANGES_BTN, SHORTWAIT);
		return login.toLowerCase();

	}
	/**
	 * Purpose- To Veriiy District user is created or not 
	 * 
	 */

	public void verifyDistrictUserDetails(String userName, String firstName, String lastName, String password)
	{
		// Verify user name is existed in users table
		String userName1=userName.toLowerCase();
		boolean bUseraNameExsts = isElementPresent(Dynamic.getNewLocator(DISTUSERNAME, userName1));
		Assert.assertTrue(bUseraNameExsts, "District user is not created");
		// verify user last name
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(DISTUSERROW, new String[] {userName1, "2" }), MEDIUMWAIT), lastName, "User last name doesn't match");
		// Verify user firstname
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(DISTUSERROW, new String[] {userName1, "3" }), MEDIUMWAIT), firstName, "User first name doesn't match");
		// verify user password
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(DISTUSERROW, new String[] {userName1, "5" }), MEDIUMWAIT), password.toLowerCase(), "User's password doesn't match");
	}

	/**
	 * Purpose- To navigate to school user sub tab under 'Users' tab 
	 * 
	 */
	public void navigateToSchoolUserTypeSubtab()
	{
		safeClick(SCHOOLUSERTYPE_SUBTAB);

	}
	/**
	 * Purpose- Verify School users page is loaded or not 
	 * 
	 */

	public void verifySchoolUsersPage() {
		boolean bSchoolUsersHeading = isElementPresent(SCHOOLUSERS_HEADING);
		Assert.assertTrue(bSchoolUsersHeading, "Administer School Users heading doesn't exists");
	}



	/**
	 * Purpose- To clicks on AddNewStaff button to create a School user 
	 * 
	 */
	public void clickAddNewStaff() {
		safeClick(ADDNEWSTAFF_BTN,LONGWAIT);
	}
	/**
	 * Purpose- To verify AddNewStaffDialog is opened 
	 * 
	 */

	public void verifyAddNewStaffDialog()
	{
		Assert.assertTrue(isElementPresent(ADDNEWSTAFF_DIALOG,LONGWAIT), "Add new staff dialog is not opened");
	}

	/**
	 * Purpose- To create School user  with teacher role
	 * 
	 */
	public void createSchoolUserWithCampusUserRole(String firstName,String lastName, String email,String schoolName, UserRole userRole)
	{  
		safeType(SCHOOLUSERLASTNAME_FIELD, lastName, SHORTWAIT);
		safeType(SCHOOLUSERFIRSTNAME_FIELD, firstName, SHORTWAIT);
		safeType(SCHOOLUSEREMAIL_FIELD, email, SHORTWAIT);
		safeSelectOptionInDropDownByVisibleText(SCHOOLUSERSCHOOL_DRPDWN, schoolName);
		safeSelectOptionInDropDownByVisibleText(SCHOOLUSERROLE_DRPDWN, userRole.getName());
		safeClick(SCHOOLUSERSAVE_BTN);

	}


	/**
	 * Purpose- To create School user  with teacher role
	 * 
	 */
	public void createSchoolUserWithCampusAndTeacherRole(String firstName,String lastName, String email,String schoolName, UserRole userRole)
	{  
		safeType(SCHOOLUSERLASTNAME_FIELD, lastName, SHORTWAIT);
		safeType(SCHOOLUSERFIRSTNAME_FIELD, firstName, SHORTWAIT);
		safeType(SCHOOLUSEREMAIL_FIELD, email, SHORTWAIT);
		safeSelectOptionInDropDownByVisibleText(SCHOOLUSERSCHOOL_DRPDWN, schoolName);
		safeSelectOptionInDropDownByVisibleText(SCHOOLUSERROLE_DRPDWN, userRole.getName());
		safeClick(SCHOOLUSERSAVE_BTN);


	}



	public void clickShowTeachers()
	{
		waitForPageToLoad(LONGWAIT);
		safeClick(SHOWTEACHER_BTN,LONGWAIT);
	}


	/**
	 * Purpose- To verify School user with teacher role is created or not 
	 * 
	 */

	public void verifyScholUserDetails(String firstName,String lastName,String schoolName,String userName, String password, UserRole... userRoles)
	{
		//  boolean bSchoolNameExists=isElementPresent(Dynamic.getNewLocator(SCHOOLUSERSCHOOL_NAME, schoolName), MEDIUMWAIT);
		//Assert.assertTrue(bSchoolNameExists, "School name for user doesn't exists ");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCHOOLUSERROW, new String[]{lastName,"3"}), MEDIUMWAIT), lastName,"User Last name doesn't match");
		//Verifies last name of user
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCHOOLUSERROW, new String[]{lastName,"4"}), MEDIUMWAIT), firstName,"User First name doesn't match");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCHOOLUSERROW, new String[]{lastName,"5"}), MEDIUMWAIT), userName.toLowerCase(),"User  name doesn't match");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SCHOOLUSERROW, new String[]{lastName,"6"}), MEDIUMWAIT), password.toLowerCase(),"password of user  doesn't match");
		List<WebElement> roles = LocatorWebElements(Dynamic.getNewLocator(SCHOOLUSERROW, new String[]{lastName,"7"}));
		String actualRoles[] = new  String[roles.size()];
		int i =0;
		for(WebElement element : roles)
		{
			actualRoles[i] = element.getText().toString();
			i++;
		}
		log.info("000000000000000000000000000000000000000000"+actualRoles);
		for(UserRole expected : userRoles)
		{
			/*if(ArrayUtils.contains(actualRoles, expected.getName()))
			{*/
				Assert.assertTrue(ArrayUtils.contains(actualRoles, expected.getName()), "Expected role not found on the page "+expected.getName());
				log.info("000000000000000000000000000000000000000000"+expected.getName());
			/*}*/
		}
		/*	//int i=0;
		log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+Arrays.asList(userRoles));
		//ArrayList<String> roleNames = new ArrayList<>();
		String roleNames[] = new String[userRoles.length];
		int i = 0 ;
		for(UserRole roleName : userRoles)
		{
			roleNames[i] = roleName.getName();
			log.info("roleNames["+i+"] = "+roleNames[i]);
			i=i++;
		}
		for(WebElement element : roles)
		{
			Assert.assertTrue(roleNames.toString().contains(element.getText()),"Role not added as expected");
			log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+element.getText());
			if(userRoles.length==roles.size())
			{
				for(UserRole roleName : userRoles)
				{
					Assert.assertTrue(element.getText().equalsIgnoreCase(roleName.getName()),roleName.getName() +" role doesn't match after Add");
					setHighlight(element);
				}
			}
			else
			{
				Assert.fail("Added more Roles and Expected less");
			}
		}*/


	}
	/**
	 * Purpose- To click on edit icon of school user 
	 * 
	 */

	/**
	 * Purpose- To edit the school user and  change the login, password credentials  
	 * 
	 */ 
	public String  EditSchoolUser(String lastName,String login, String password) {
		//schoolName = schoolName+UtilityMethods.getRandomNumberMillis();
		//login = (String)(login+UtilityMethods.get4DRandomNumber());
		waitForSecs(5, "Waiting for Page to Available");
		//System.out.println(Dynamic.getNewLocator(EDITSCHOOLUSER_ICON, lastName));
		safeClick(Dynamic.getNewLocator(EDITSCHOOLUSER_ICON, lastName),MEDIUMWAIT);
		//login = (String)(login+UtilityMethods.get4DRandomNumber());
		//login = login+UtilityMethods.getRandomNumberMillis();
		safeClearAndType(SCHOOLUSERLOGIN_FIELD, login);
		safeClearAndType(SCHOOLUSERPASSWORD_FIELD, password);
		safeClearAndType(SCHOOLUSERRETYPEPASSWORD_FIELD, password);
		safeClick(SCHOOLUSERUPDATE_BTN);
		//config.writeProperty("VPORT_002_SchoolUser", login);
		return login;
	}

	/**
	 * Purpose- To edit the school user and  change the login, password credentials  
	 * 
	 */ 
	public String  EditSchoolUserAndAssignteacherRole(String lastName,String login, String password,String schoolName) {
		//schoolName = schoolName+UtilityMethods.getRandomNumberMillis();
		//login = (String)(login+UtilityMethods.get4DRandomNumber());
		waitForSecs(5, "Waiting for Page to Available");
		//System.out.println(Dynamic.getNewLocator(EDITSCHOOLUSER_ICON, lastName));
		safeClick(Dynamic.getNewLocator(EDITSCHOOLUSER_ICON, lastName),MEDIUMWAIT);
		//login = (String)(login+UtilityMethods.get4DRandomNumber());
		//login = login+UtilityMethods.getRandomNumberMillis();
		safeClearAndType(SCHOOLUSERLOGIN_FIELD, login);
		safeClearAndType(SCHOOLUSERPASSWORD_FIELD, password);
		safeClearAndType(SCHOOLUSERRETYPEPASSWORD_FIELD, password);

		//config.writeProperty("VPORT_002_SchoolUser", login);

		//Assigning the Techer Role to the same Campus user
		UserRole userRole  = UserRole.TEACHER;
		waitForPageToLoad();
		waitForSecs(1);
		isElementPresent(ADD_NEWROLE_BTN, MEDIUMWAIT);
		safeClick(ADD_NEWROLE_BTN, MEDIUMWAIT);
		waitForSecs(1	);
		safeSelectOptionInDropDownByVisibleText(SCHOOLUSERSCHOOL_DRPDWN_1, schoolName);
		safeSelectOptionInDropDownByVisibleText(SCHOOLUSERROLE_DRPDWN_1, userRole.getName());
		safeClick(SCHOOLUSERUPDATE_BTN, MEDIUMWAIT);
		return login;
	}
	/**
	 * Purpose- To click on District tracks Main heading and returns  TracksFilter page 
	 * 
	 */ 
	public VportTrackFilterPage clickDistrictTracksMainHeading() {
		safeClick(DISTRICTTRACKS_MAINHEADING);
		return new VportTrackFilterPage(driver);
	}

	public VportTrackFilterPage navigateToFiltersPage() {
		waitForPageToLoad();
		waitForSecs(10, "Waiting to Logo to display");
		safeClick(LOGO_ICON, MEDIUMWAIT);
		waitForSecs(10, "Waiting Page to Load");
		waitForPageToLoad();
		return new VportTrackFilterPage(driver);
	}

	public void clickOnParentCheckBox() {
		safeCheck(PARENT_CHEKCBOX, MEDIUMWAIT);
		
	}

	public VportTrackFilterPage clickUpdateBtn() {
		safeClick(UPDATE_BTN, MEDIUMWAIT);
		return new VportTrackFilterPage(driver);	
	}

	public void verifySubDistrict() {
		Assert.assertTrue(isElementDisplayed(SUB_DISTRICT_HEADER), "Sub district heading doesn't exists");

		
	}

	public void navigatetoSubDistrictPage() {
	safeClick(Dynamic.getNewLocator(SUB_DISTRICT_LINK), MEDIUMWAIT);
	
	
		
	}

	public DistrictAdminHomepage navigateToDistrictAdmin() {
		// TODO Auto-generated method stub
		return new DistrictAdminHomepage(driver);
	}
}

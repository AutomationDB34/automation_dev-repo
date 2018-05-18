package com.page.locators.vport;

import org.openqa.selenium.By;

public interface MasterDistrictTracksLocators {
	
	public static By DISTRICT_SUBTAB=By.id("subtabs02_view_by_district");
	public static By SCHOOLS_SUBTAB=By.xpath(".//nobr[contains(text(),'Schools')]"); 
	public static By USERS_SUBTAB=By.xpath(".//nobr[contains(text(),'Users')]");
	
	//Locators For creating school in Schools Sub tab
	public static By EDITSCHOOL_TITLE=By.className("subhdrmain");
	public static By ADDSCHOOL_BTN=By.xpath(".//a[@id='Add School']/img");
	public static By SCHOOLNAME_FIELD=By.name("campusName");
	public static By CODE_FIELD=By.name("campusMasterCode");
	public static By ADDRESS1_FIELD=By.name("address1");
	public static By ADDRESS2_FIELD=By.name("address2");
	public static By CITY_FIELD=By.name("city");
	
	
	public static By STATE_DRPDWN=By.name("stateProvinceId");
	public static By ZIP_FIELD=By.name("postalCode");	
	public static By CONTACTNAME_FIELD=By.name("contactName");
	public static By CONTACTPHONE_FIELD=By.name("contactNumber");
	public static By STATUS_DRPDWN=By.name("status");
	public static By ALLOWDATAEXCHANGE_CHKBOX=By.name("allowDataExchange");
	public static By SAVECHANGES_BTN=By.className("submit");
	
	// Locator for verifying school
	 public static By SCHOOLNAME = By.xpath(".//td[text()='%s']");
	 public static By CODEANDCITY=By.xpath(".//td[text()='%s']/../td[%s]");
	
	//Locators for Users Creation
	 public static By DISTRICTUSERTYPE_SUBTAB=By.xpath(".//td[@id='subMenuItem_2_District']/nobr");
	 public static By SCHOOLUSERTYPE_SUBTAB=By.xpath(".//td[@id='subMenuItem_2_School']/nobr");
	 
	 public static By ADDUSER_BTN=By.id("Add User");
	 public static By DISTUSERFIRSTNAME_FIELD=By.xpath(".//table[@class='daddio']//input[@name='firstName']");
	 public static By DISTUSERLASTNAME_FIELD=By.xpath(".//table[@class='daddio']//input[@name='lastName']");
	 public static By DISTUSERLOGIN_FIELD=By.xpath(".//table[@class='daddio']//input[@name='loginName']");
	 public static By DISTUSERPASSWORD_FIELD=By.xpath(".//table[@class='daddio']//input[@name='password']");
	 public static By DISTUSERRETYPEPASSWORD_FIELD=By.xpath(".//table[@class='daddio']//input[@name='retypePassword']");
	 public static By ADDNEWROLE_BTN=By.name("Add New Role");
	 public static By ROLES_DRPDWN=By.name("userRoles[0].roleId");
			 
	 
	 public static By ADDDISTRICTUSER_HEADING=By.xpath(" .//nobr[contains(text(),'Add District User')]");
	 
	
	//Locators for verifying user
	 public static By DISTUSERNAME = By.xpath(".//td[text()='%s']");
	 public static By DISTUSERROW=By.xpath(".//td[text()='%s']/../td[%s]");
	 
	 
	 	//Locators for Creating a School User
	 
	 public static By SCHOOLUSERS_HEADING=By.xpath("//td[contains(text(),'Administer School Users')]");
	 
	 public static By ADDNEWSTAFF_BTN=By.id("Add New Staff");
	 public static By ADDNEWSTAFF_DIALOG=By.xpath("//span[contains(text(),'Add New Staff')]");
	 public static By SCHOOLUSERFIRSTNAME_FIELD=By.name("users[0].firstName");
	 public static By SCHOOLUSERLASTNAME_FIELD=By.name("users[0].lastName");
	 public static By SCHOOLUSEREMAIL_FIELD=By.name("users[0].email");
	 public static By SCHOOLUSERSCHOOL_DRPDWN=By.name("users[0].entityId");
	 public static By SCHOOLUSERROLE_DRPDWN=By.name("users[0].roleId");
	 public static By SCHOOLUSERSCHOOL_DRPDWN_1=By.xpath("(.//select[contains(@name,'entity')])[2]");
	 public static By SCHOOLUSERROLE_DRPDWN_1=By.xpath("(.//select[contains(@name,'role')])[2]");
	 
	 public static By SCHOOLUSERSAVE_BTN=By.id("divNewStaffSaveChanges");
	 
	 public static By SHOWTEACHER_BTN=By.id("sTeachers");

	 public static By SCHOOLUSERLOGIN_FIELD=By.name("loginName");
	 public static By SCHOOLUSERPASSWORD_FIELD=By.name("password");
	 public static By SCHOOLUSERRETYPEPASSWORD_FIELD=By.name("retypePassword");
	 public static By SCHOOLUSERUPDATE_BTN=By.id("updateBtn");
	 
	 
	 //Verify school user details
	 
	 public static By SCHOOLUSERSCHOOL_NAME=By.xpath("(.//span[@title='%s'])[1]");
	 public static By EDITSCHOOLUSER_ICON=By.xpath(".//img[contains(@src,'editIcon.png')]");//By.xpath("//nobr[contains(text(),'%s')]/../../td[2]/a/img");
	 public static By SCHOOLUSERROW=By.xpath("//nobr[contains(text(),'%s')]/../../td[%s]//nobr");
	 
	 
	 
	 //Edit School User details 
	 
	 By DISTRICTTRACKS_MAINHEADING=By.xpath(".//td[@title='Districts/Tracks']/a/div[2]");
	
	By LOGO_ICON = By.xpath("//img[@id='headerIcon']");
	By ADD_NEWROLE_BTN = By.xpath(".//img[contains(@src,'add_new_role_sm.gif')]");
	By PARENT_CHEKCBOX = By.xpath("//input[@name='parent']");
	By UPDATE_BTN = By.xpath("//input[@class='submit'][1]");
	
	By SUB_DISTRICT_HEADER = By.xpath("//nobr[contains(text(),'Sub-Districts')]");
	By SUB_DISTRICT_LINK = By.xpath("//a[contains(text(),'ZenAuto')]");
	

	
	

}

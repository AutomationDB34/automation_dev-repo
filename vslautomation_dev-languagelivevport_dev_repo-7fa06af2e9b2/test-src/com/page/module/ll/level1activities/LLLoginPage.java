package com.page.module.ll.level1activities;

import com.testng.Assert;
import com.utilities.UtilityMethods;

import org.openqa.selenium.WebDriver;

import com.page.locators.ll.level1activites.LLLoginLocators;
import com.page.module.ll.admin.ImplementationCardsPage;
import com.page.module.ll.admin.LLHomePage;
import com.page.module.ll.admin.MultiRoleScenariosPage;
import com.page.module.ll.teacherrole.TeacherRoleReportsPage;
import com.page.module.ll.teacherrole.TeacherWelComePage;
import com.selenium.SafeActions;
import com.sun.jna.platform.win32.OaIdl.SAFEARRAYBOUND;
import com.testng.Assert;
import org.apache.log4j.Logger;

public class LLLoginPage extends CommonFunctionalities implements LLLoginLocators{
	
	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());
	public LLLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
	}
		
	/**
	 * Purpose- To verify whether LL Login page is being displayed or not
	 */	
	public void verifyLoginPage()
	{
		boolean uNamenExists = isElementPresent(USERNAME_FIELD,LONGWAIT);
		Assert.assertTrue(uNamenExists,"User Name button is not being displayed on Login page");	
	}

	
	/**
	 * Purpose- To verify whether LL Welcomme  page is being displayed or not
	 */	
	public void verifywelcomePage()
	{
		boolean cotinueButtonExists = isElementPresent(WELCOME_CONTINUE_BTN,LONGWAIT);
		Assert.assertTrue(cotinueButtonExists,"Comtinue button is not being displayed on Welcome page");	
	}
	
	/**
	 * Purpose- To enter user credentials and submit
	 * @return 
	 */	
	public Object loginCredentials(String url,String vportUsername, String vportPassword , LLLoginReturnPage llloginreturnpage )
	{
	try {
		navigateToURLandRetrivePageLoadTime(url, VERYLONGWAIT);
	} catch (Exception e) {
		log.info("Page navigation is failed due to"+ UtilityMethods.getStackTrace());
		e.printStackTrace();
	}
	verifyLoginPage();
	safeType(USERNAME_FIELD ,vportUsername, SHORTWAIT);
	safeType(PASSWORD_FIELD ,vportPassword, SHORTWAIT);	
	safeClick(LOGIN_BTN, SHORTWAIT);
	
	
	switch (llloginreturnpage) {
	case STUD_WELCOME_PAGE:
		log.info("Student welcome page is called");
		return new StudentWelcomePage(driver);
	case TEACHER_HOME_PAGE:
		log.info("Teacher welcome page is called");
		return new TeacherHomePage(driver);
	case IMPLEMENTATIONCARDS_PAGE:
		log.info("Implementation cards page is called");
		return new ImplementationCardsPage(driver);
	case ADMIN_HOME_PAGE:
		log.info("Admin Home page is called");
		return new LLHomePage(driver);
	case NEW_TEACHER_WELCOME_PAGE:
		log.info("Teacher Welcome page is called");
		return new TeacherWelComePage(driver);
	case TEACHERROLE_REPORTS_PAGE:
		log.info("Teacher Role Reports page is called");
		return new TeacherRoleReportsPage(driver);
	case MULTIROLE_SELECTION_PAGE:
		log.info("Mutli role selection page is called");
		return new MultiRoleScenariosPage(driver);
	default:
		log.info("No POM is passed as argument");
		return null;
	}
	
	}
	
	public enum LLLoginReturnPage{STUD_WELCOME_PAGE , MULTIROLE_SELECTION_PAGE,TEACHER_HOME_PAGE,IMPLEMENTATIONCARDS_PAGE,ADMIN_HOME_PAGE,NEW_TEACHER_WELCOME_PAGE,TEACHERROLE_REPORTS_PAGE}

	
	
	
}

package com.page.module.ll.level1activities;

import org.openqa.selenium.WebDriver;

import com.data.testdata.LLData;
import com.page.locators.ll.level1activites.StudentWelcomePageLocators;
import com.selenium.SafeActions;
import com.testng.Assert;

public class StudentWelcomePage extends SafeActions implements StudentWelcomePageLocators {
	
	private WebDriver driver;
	LLStudentHomePage llstudentHomePage;
	StudentWelcomePage studentWelcomePage;
	String studentScoreDetails[] = new String[4];
	
	public StudentWelcomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
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
	 * Purpose- To click the continue button in welcome page
	 */	
	public LLActivity welcomeButton()
	{
	safeClick(WELCOME_CONTINUE_BTN, SHORTWAIT);
	return new LLActivity(driver);
	
	}
	
	/**
	 * Purpose-To click on Continue button and navigate to LLstudent Home page
	 */
	
	 public LLStudentHomePage ClickContinueButton()
	 {
		 safeClick(WELCOME_CONTINUE_BTN, SHORTWAIT);
		 return new LLStudentHomePage(driver);
	 }
	
	 /**
	  * Purpose of this method is to get data in the My Scorecard of the student login
	  * @param llloginPage
	  * @param llData
	  * @return
	  */
	 public String[] getStudentProgressData(LLLoginPage llloginPage,LLData llData){
		 llstudentHomePage=new LLStudentHomePage(driver);
			
			llstudentHomePage.verifyLLStudentHomePage();
			llstudentHomePage.clickOnClassLink();
			llstudentHomePage.verifyClassPage();
			studentScoreDetails=llstudentHomePage.clickOnMyScoreCardandGetProgress();	
			return studentScoreDetails;
		}
}

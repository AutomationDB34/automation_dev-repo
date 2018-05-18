package com.page.module.ll.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.admin.ImplementationCardsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.sun.mail.handlers.image_gif;
import com.testng.Assert;
import com.utilities.UtilityMethods;

import net.sf.saxon.exslt.Date;

public class ImplementationCardsPage extends SafeActions implements ImplementationCardsLocators {

	WebDriver driver;

	public ImplementationCardsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Moves to Welcome frame
	 */
	public void moveToWelcomeFrame()

	{
		waitForPageToLoad();
		selectFrame(WELCOME_FRAME, LONGWAIT);
	}
	
	public LLHomePage selectTrackineWelcomePage()
	{
		safeSelectRadioButton(DISTRICTNAME_RADIOBUTTON, VERYLONGWAIT);
		safeClick(CONTINUE_BTN, LONGWAIT);
		
		 return new LLHomePage(driver);
	}
	
	 public void moveToImplemetationCardsFramefromDashboard()
	 { 
		 if(isElementDisplayed(IMPLEMENTATIONCARDS_FRAME)){
		 selectFrame(IMPLEMENTATIONCARDS_FRAME, VERYLONGWAIT);
		 }
		 else
		 {
			 refresh();
			 safeClick(REVIEW_LINKS);
			 selectFrame(IMPLEMENTATIONCARDS_FRAME, VERYLONGWAIT);
		 }
	 }

	/**
	 * This method verifies Welcome screen of User first login
	 */
	public void verifyWelcomePage() {
		waitForSecs(3, "waiting for welcome page to load");
		scrollIntoElementView(YOURPROFILE_HEADING);
		boolean bProfile = isElementDisplayed(YOURPROFILE_HEADING);
		Assert.assertTrue(bProfile, "Your Profile heading is not displayed in the welcome page");

	}

	// This method fills all details in welcome page
	public void completeProfileinWelcomePage(String email) {
		safeClearAndType(EMAILINWELCOMEPAGE_TEXT, email);
		scrollIntoElementView(EMAILINWELCOMEPAGE_TEXT);
		safeSelectOptionInDropDownByVisibleText(TRAININGOPTION_DRPDOWN, "No Formal Training");
		safeCheck(ACCEPTTERMS_CHKBOX);
		safeClick(SAVEANDCONTINUE);
	}

	/**
	 * Verifies all seven implementation cards are displayed for User first
	 * login
	 */
	public void verifyAllImplementationTabsExistsforDistrictUser() {
		
		 
		String[] tabs = { "1. About", "2. Goals", "3. Participation", "4. Create Plan", "5. Training", "6. Technology",
				"7. Import Data" };
		isElementClickable(IMPLEMENTATION_LIST);
		List<WebElement> implementationTabs = LocatorWebElements(IMPLEMENTATION_LIST);
		Assert.assertEquals(implementationTabs.size(), 7, "Implementation cards count is not eqaul to 7");

		for (int i = 0; i < implementationTabs.size(); i++)

			Assert.assertEquals(implementationTabs.get(i).getText(), tabs[i],
					" The tab " + tabs[i] + "is not present in the welcome page of user ");
		 
		 
		
	}

	public void verifyAllImplementationTabsExistsforCampusUser(){

		 
			 String[] tabs = { "1. About", "2. Goals", "3. Participation", "4. Review Plan", "5. Training", "6. Technology",
				"7. Import Data" };
		isElementClickable(IMPLEMENTATION_LIST);
		List<WebElement> implementationTabs = LocatorWebElements(IMPLEMENTATION_LIST);
		Assert.assertEquals(implementationTabs.size(), 7, "Implementation cards count is not eqaul to 7");

		for (int i = 0; i < implementationTabs.size(); i++)

			Assert.assertEquals(implementationTabs.get(i).getText(), tabs[i],
					" The tab " + tabs[i] + "is not present in the welcome page of user ");
		 
	}
	/**
	 * Fill details in ABOUT tab and saves it
	 */
	public void completeAboutTab() {

		waitForPageToLoad();
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "0"));
		safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Fill details in Goals tab and saves it
	 */

	public void completeGoalsTab() {
		waitForPageToLoad();
		waitForSecs(5);
		isElementPresent(USESTANDARDISEDMEASURES_CHKBOX,VERYLONGWAIT);
		safeCheck(USESTANDARDISEDMEASURES_CHKBOX,VERYLONGWAIT);
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "1"));
		safeCheck(USESTATEASSESSMENTS_CHKBOX,VERYLONGWAIT);
		safeCheck(USEINDEPENDENTMEASURES_CHKBOX,VERYLONGWAIT);

		safeActionsClick(SAVEANDCONTINUE, VERYLONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * Fill details in Participation tab and saves it
	 */
	public void completeParticipationTab() {
		
		waitForPageToLoad();
		isElementPresent(DESCRIBEYOURPLACEMENT_TEXTAREA,VERYLONGWAIT);
		waitForSecs(4);
		safeClearAndType(DESCRIBEYOURPLACEMENT_TEXTAREA, "Sample text", VERYLONGWAIT);
		waitForSecs(4);
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "2"));
		waitForSecs(4);
		safeActionsClick(SAVEANDCONTINUE, VERYLONGWAIT);
		waitForPageToLoad();
	}

	/**
	 * Fill details in Create Plan tab and saves it
	 * @throws InterruptedException 
	 */

	public void completeCreatePlanTab(){
		
		waitForSecs(5);	
		isElementPresent(INSTRUCTIONSTARTDATE, VERYLONGWAIT);
		safeClearAndType(INSTRUCTIONSTARTDATE, UtilityMethods.getCurrentDateTime(0));
		waitForSecs(4);
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "3"));
		safeClearAndType(INSTRUCTIONENDDATE, UtilityMethods.getCurrentDateTime(0));
		waitForSecs(4);
		safeSelectOptionInDropDownByVisibleText(DAYS_DROPDOWN, "1");
		waitForSecs(4);
		safeSelectOptionInDropDownByVisibleText(MINUTES_DRPDOWN, "45");
		waitForSecs(4);
		safeSelectOptionInDropDownByVisibleText(TECHNOLOGY_OPTIONS, "Individual Laptops/iPads/Computer Stations");
		waitForSecs(4);
		safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
		waitForSecs(4);
		waitForPageToLoad();
		scrollIntoElementView(INSTRUCTIONSTARTDATE);
		waitForSecs(4);
		isElementPresent(BENCHMARK1_STARTDATE, LONGWAIT);
		waitForSecs(4);
		safeClearAndType(BENCHMARK1_STARTDATE, UtilityMethods.getCurrentDateTime(0),MEDIUMWAIT);
		waitForSecs(4);
		safeClearAndType(BENCHMARK1_ENDDATE, UtilityMethods.getCurrentDateTime(0),MEDIUMWAIT);
		waitForSecs(4);
		safeClearAndType(BENCHMARK2_STARTDATE, UtilityMethods.getCurrentDateTime(0),MEDIUMWAIT);
		waitForSecs(4);
		safeClearAndType(BENCHMARK2_STARTDATE, UtilityMethods.getCurrentDateTime(0), MEDIUMWAIT);
		//safeType(BENCHMARK2_STARTDATE,"02/11/2016", MEDIUMWAIT);
		safeClearAndType(BENCHMARK2_ENDDATE, UtilityMethods.getCurrentDateTime(0),MEDIUMWAIT);
		waitForSecs(4);
		safeClearAndType(BENCHMARK3_STARTDATE, UtilityMethods.getCurrentDateTime(0),MEDIUMWAIT);
		waitForSecs(4);
		safeClearAndType(BENCHMARK3_ENDDATE, UtilityMethods.getCurrentDateTime(0),MEDIUMWAIT);
		waitForSecs(4);
		safeClearAndType(COMMENTS_TEXTAREA, "Sample Text",MEDIUMWAIT);
		waitForSecs(4);
		safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
		waitForSecs(4);
		waitForPageToLoad();
	}
	
	public void completeReviewPlanTab(){
	
		 //verify District Calendar pane
		 boolean bDistrictCalenderExists=isElementPresent(Dynamic.getNewLocator(DISTRICTCALENDAR_PANE,"1"), LONGWAIT);
		 Assert.assertTrue(bDistrictCalenderExists, "District Calendar pane doesn't exists in Review plan tab");
		 isElementPresent(Dynamic.getNewLocator(DISTRICTCALENDAR_PANE,"2"), LONGWAIT);
		 waitForSecs(5);	
		 String date=safeGetText(Dynamic.getNewLocator(DISTRICTCALENDAR_PANE,"2"), LONGWAIT).split(":")[1].trim();
		 System.out.println(date);
		 Assert.assertEquals(date, UtilityMethods.getCurrentDateTime(0), "Instructional Start Date in Review plan pane doesn't matches with the Instruction Start date in Create Plan tab");
		 
		 date=safeGetText(Dynamic.getNewLocator(DISTRICTCALENDAR_PANE,"3"), LONGWAIT).split(":")[1].trim();
		 Assert.assertEquals(date, UtilityMethods.getCurrentDateTime(0), "Instructional End Date in Review plan pane doesn't matches with the Instruction End date in Create Plan tab");
		  //verify BenchMark Windows pane
		 boolean bBenchMarkWindowsPaneExists=isElementPresent(Dynamic.getNewLocator(BENCHMARKWINDOWS_PANE,"1"), LONGWAIT);
		 Assert.assertTrue(bBenchMarkWindowsPaneExists, "Bench mark windows pane doesn't exists in Review plan tab");
		 
		 //Get Benchmark1 dates and verifies them
		 String value=safeGetText(Dynamic.getNewLocator(BENCHMARKWINDOWS_PANE,"2"), LONGWAIT).split(":")[1].trim();
		 System.out.println(value);
		 Assert.assertEquals(value.split("-")[0].trim(), UtilityMethods.getCurrentDateTime(0), "Start Date of Bench Mark 1 in Review  pane doesn't matches with the given Benchmark 1  Start date in Create Plan tab ");
		 Assert.assertEquals(value.split("-")[1].trim(), UtilityMethods.getCurrentDateTime(0), "End Date of Bench Mark 1 in Review  pane doesn't matches with the given Benchmark 1  End date in Create Plan tab ");
		
		 //Get Benchmark2 dates and verifies them
		 value=safeGetText(Dynamic.getNewLocator(BENCHMARKWINDOWS_PANE,"3"), LONGWAIT).split(":")[1].trim();
		 Assert.assertEquals(value.split("-")[0].trim(), UtilityMethods.getCurrentDateTime(0), "Start Date of Bench Mark 2 in Review  pane doesn't matches with the given Benchmark 2  Start date in Create Plan tab ");
		 Assert.assertEquals(value.split("-")[1].trim(), UtilityMethods.getCurrentDateTime(0), "End Date of Bench Mark 2 in Review  pane doesn't matches with the given Benchmark 2  End date in Create Plan tab ");
		
		 //Get Benchmark3 dates and verifies them
		 value=safeGetText(Dynamic.getNewLocator(BENCHMARKWINDOWS_PANE,"4"), LONGWAIT).split(":")[1].trim();
		 Assert.assertEquals(value.split("-")[0].trim(), UtilityMethods.getCurrentDateTime(0), "Start Date of Bench Mark 3 in Review  pane doesn't matches with the given Benchmark 3  Start date in Create Plan tab ");
		 Assert.assertEquals(value.split("-")[1].trim(), UtilityMethods.getCurrentDateTime(0), "End Date of Bench Mark 3 in Review  pane doesn't matches with the given Benchmark 3  End date in Create Plan tab ");
		
		 //Verify Instructional Targets
		 boolean bInstructionalTargetssPaneExists=isElementPresent(Dynamic.getNewLocator(INSTRUCTIONALTARGETS_PANE,"1"), LONGWAIT);
		 Assert.assertTrue(bInstructionalTargetssPaneExists, "Instructional Targetss Pane  doesn't exists in Review plan tab");
		 Assert.assertEquals(safeGetText(Dynamic.getNewLocator(INSTRUCTIONALTARGETSDAYSMINUTES,"2"), LONGWAIT), "1 days", "Instructional target days in review plan doesn't matches in Create plan tab");
		 Assert.assertEquals(safeGetText(Dynamic.getNewLocator(INSTRUCTIONALTARGETSDAYSMINUTES,"3"), LONGWAIT), "45 minutes", "Instructional target Minutes in review plan doesn't matches in Create plan tab");
		 
		 //Verify Technology access
		 boolean bTechnologyAccessPaneExists=isElementPresent(Dynamic.getNewLocator(TECHNOLOGYACCESS_PANE,"1"), LONGWAIT);
		 Assert.assertTrue(bTechnologyAccessPaneExists, "TECHNOLOGY Acess Pane  doesn't exists in Review plan tab");
		 Assert.assertEquals(safeGetText(Dynamic.getNewLocator(TECHNOLOGYACCESS_PANE,"2"), LONGWAIT), "• Individual Laptops/iPads/Computer Stations", "Technology access value  in review doesn't matches with create plan value");
		 safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
	 }	
	
	

	/**
	 * Fill details in Training tab and saves it
	 */
	public void completeTrainingTab() {
		waitForPageToLoad();
		isElementPresent(SAVEANDCONTINUE, LONGWAIT);
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "4"));
		safeClick(SAVEANDCONTINUE, VERYLONGWAIT);
	}

	/**
	 * Fill details in technology tab and saves it
	 */

	public void completeTechnologyTab() {
		
		isElementPresent(REVIEWMODELOPTIONS_TEXTAREA, LONGWAIT);
		waitForSecs(6, "Waiting to review options to enabled");
		safeClearAndType(REVIEWMODELOPTIONS_TEXTAREA, "Sample Text", LONGWAIT);
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "5"));
		isElementPresent(MINIMUMSYSMREQUIREMENTS_TEXTAREA, LONGWAIT);
		safeClearAndType(MINIMUMSYSMREQUIREMENTS_TEXTAREA, "Sample Text");
		safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
		waitForPageToLoad();
		waitForSecs(7, "Waiting to review options to enabled");
		isElementPresent(BANDWIDTH_TEXTAREA, LONGWAIT);
		waitForSecs(4);
		safeClick(BANDWIDTH_TEXTAREA, MEDIUMWAIT);
		safeClearAndType(BANDWIDTH_TEXTAREA, "Sample Text",MEDIUMWAIT);
		safeClearAndType(FULLNAME_TXT, "Admin User",MEDIUMWAIT);
		safeClearAndType(EMAIL_TXT, "AdminUser@gmail.com",MEDIUMWAIT);
		safeClearAndType(PHONENUMBER_TXT, "12345",MEDIUMWAIT);
		safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
	}

	/**
	 * Fill details in Import Data tab and saves it
	 */
	public LLHomePage completeImportDataTab() {
	
		waitForPageToLoad();
		safeActionsClick(SAVEANDCONTINUE, MEDIUMWAIT);
		scrollIntoElementView(Dynamic.getNewLocator(TAB, "6"));
		safeActionsClick(GOTODASHBOARD_BTN, MEDIUMWAIT);
		return new LLHomePage(driver);
	}
	
	/*
	 * Verifies Review Link is opened or not 
	 */
	 public void verifyReviewLinkinImplementationPlan(){
	   
	    boolean bTitle=isElementPresent(TITLEOFTECHONOLOGYPAGE,VERYLONGWAIT);
	    Assert.assertTrue(bTitle, "Technology Page Heading is not displayed");
	    }
	 
	 
	  public void clickSaveandGotoDashBoard()
	  {
		  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  isElementPresent(SAVEANDGOTOMYDASHBOARD, LONGWAIT);
		  safeClick(SAVEANDGOTOMYDASHBOARD, VERYLONGWAIT);
	  }
	  
	  public void verifySubDistrictUserLogin(){
		  Assert.assertTrue(isElementDisplayed(SUBDISTRICT_LOGIN),"Subdistrict login is not been successful");
	  }

}

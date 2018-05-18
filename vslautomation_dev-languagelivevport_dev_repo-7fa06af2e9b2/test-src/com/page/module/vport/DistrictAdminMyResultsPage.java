package com.page.module.vport;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.data.testdata.VportData;
import com.page.locators.vport.DistrictAdminMyResultsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;

public class DistrictAdminMyResultsPage extends SafeActions implements DistrictAdminMyResultsLocators {

	WebDriver driver;
	
	public DistrictAdminMyResultsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMyResultspage(){
		
		boolean bChartOptionsframeExists=isElementPresent(CHARTOPTIONS_FRMAE, LONGWAIT);
		Assert.assertTrue(bChartOptionsframeExists, "Chart Options Frame is not displayed in My Results->Key Measures Page");
	}
	
	public DistrictAdminMyDistrictPage clickMyDistrictTab()
	{
		safeClick(MYDISTRICT_TAB, LONGWAIT);
		return new DistrictAdminMyDistrictPage(driver);
	}
	
	 public void selectSchoolFromSchoolDrpdown(String schoolName)
	 {
		 safeClick(Dynamic.getNewLocator(SCHOOL_DRPDWN,"All"),LONGWAIT);
		 safeClick(Dynamic.getNewLocator(SCHOOL_DRPDWN,schoolName),LONGWAIT);
	 }
	 
	 public void selectClassFromClassDrpdown(String className)
	 {
		 safeClick(Dynamic.getNewLocator(CLASS_DRPDOWN,"All"),LONGWAIT);
		 safeClick(Dynamic.getNewLocator(CLASS_DRPDOWN,className),LONGWAIT);
	 }
	 
	 
	public DistrictAdminMySchoolPage clickMySchoolTab()
	{
		safeClick(MYSCHOOL_TAB, LONGWAIT);
		return new DistrictAdminMySchoolPage(driver);
	}
	
	
	public DistrictAdminMyClassPage clickOnMyClassTab()
	{ 
		safeClick(MYCLASS_TAB,LONGWAIT);
		return new DistrictAdminMyClassPage(driver);
	
	}
	
	public void clickMatchedradioButton()
	{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		safeClick(MATCHED_RADIOBUTTON, LONGWAIT);
		isElementPresent(REFRESH_CHART,LONGWAIT);
		safeClick(REFRESH_CHART,VERYLONGWAIT);
	
		 
		 
	}
	public void clickUnMatchedradioButton()
	{
		safeClick(UNMATCHED_RADIOBUTTON, LONGWAIT);
		isElementPresent(REFRESH_CHART,LONGWAIT);
		safeClick(REFRESH_CHART,VERYLONGWAIT);
	}
	
	 public String getPARLexileScore(String schoolName){
		
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 safeJavaScriptClick(SCALE_DRPDOWN, VERYLONGWAIT);
		 safeClick(Dynamic.getNewLocator(OPTIONSINSCALE_DRPDOWN,"Lexile"),LONGWAIT);
		 isElementClickable(BARCHART_IMAGE, VERYLONGWAIT);
		 isElementClickable(REFRESH_CHART, LONGWAIT);
		 safeClick(REFRESH_CHART,VERYLONGWAIT);
		try{
		 Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 String lexileScoreofB1=safeGetText(Dynamic.getNewLocator(SCORESINRESULTSBYSCHOOL_TABLE, new String[]{schoolName,"1"}), LONGWAIT).split("\\.")[0];
		 
		 return lexileScoreofB1;
	 }
	 
	 public String getTOSCARFScore(String schoolName)
	 
	 {
		 
		 try{
			 Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		 isElementDisplayed(SCALE_DRPDOWN);
		 safeJavaScriptClick(SCALE_DRPDOWN, VERYLONGWAIT);
		 safeClick(Dynamic.getNewLocator(OPTIONSINSCALE_DRPDOWN, "Percentile Rank"),LONGWAIT);
		 isElementClickable(BARCHART_IMAGE, VERYLONGWAIT);
		 isElementClickable(REFRESH_CHART, LONGWAIT);
		 safeClick(REFRESH_CHART,VERYLONGWAIT);
		 try{
			 Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		 String TOSCRFGLScoreofB1=safeGetText(Dynamic.getNewLocator(SCORESINRESULTSBYSCHOOL_TABLE, new String[]{schoolName,"7"}), LONGWAIT).split("\\.")[0];
		 return TOSCRFGLScoreofB1;
		 
	 }
	 
	 public String getTWS4Score(String schoolName)
	 {
		 
		 String TWS4ScoreofB1=safeGetText(Dynamic.getNewLocator(SCORESINRESULTSBYSCHOOL_TABLE, new String[]{schoolName,"13"}), LONGWAIT).split("\\.")[0];
		 return TWS4ScoreofB1;
		 
	 }

	 
	 /**
	  * Purpose is to set filters and verify the results
	  */
	public void selectFiltersAndVerifyREsults() {
		waitForSecs(25);
		//Select Level in the Level Drop down 
		safeClick(LEVEL_DROPDOWN, MEDIUMWAIT);	
		waitForSecs(3,"waiting for resuts table to load");
		safeClick(LEVEL_SELECTION, MEDIUMWAIT);
		//Select category in the category Drop down 
		waitForSecs(5, "waiting for page to load");
		safeClick(CATEGORY_DROPDOWN, MEDIUMWAIT);	
		waitForSecs(3,"waiting for resuts table to load");
		safeClick(CATEGORY_SELECTION, MEDIUMWAIT);
		//Select measure in the Measure Drop down 
		waitForSecs(5, "waiting for page to load");
		safeClick(MEASURE_DROPDOWN, MEDIUMWAIT);	
		waitForSecs(3,"waiting for resuts table to load");
		List <WebElement> listitem = LocatorWebElements(MEASURE_CHECKBOX_LIST);
		for(int i=1 ; i<=listitem.size() ; i++){
			waitForSecs(1,"waiting for resuts table to load");
			safeUnCheck(Dynamic.getNewLocator(MEASURE_DROPDOWN_OPTIONS, Integer.toString(i)), MEDIUMWAIT);
			}
		waitForSecs(3,"waiting for resuts table to load");
		safeClick(MEASURE_SELECTION, MEDIUMWAIT);
		waitForSecs(3,"waiting for resuts table to load");
		safeClick(OK_BTN, MEDIUMWAIT);
		waitForSecs(3,"waiting for resuts table to load");
		//Click refresh button to update the score in the chart section 	
		safeClick(REFRESH_CHART, MEDIUMWAIT);
		waitForSecs(3,"waiting for resuts table to load");
		}

	/**
	 * Purpose is to set scale  to "Score" and verify displayed results with the results stored in Enter scores tab
	 */
	public void verifyScoresScaleResults(String schoolname ,String classname, String stdName, String stdScore) {
		
		safeClick(Dynamic.getNewLocator(DRILLDOWN_LINK_IN_RESULT_TABLE,schoolname ), MEDIUMWAIT);
		waitForSecs(23,"waiting for resuts table to load");
		safeClick(Dynamic.getNewLocator(DRILLDOWN_LINK_IN_RESULT_TABLE,classname ), MEDIUMWAIT);
		waitForSecs(5,"waiting for resuts table to load");
		waitForPageToLoad();
		//Set scale to "Score" option 
		safeJavaScriptClick(SCALE_DRPDOWN, MEDIUMWAIT);
		waitForSecs(5,"waiting for resuts table to load");
		safeJavaScriptClick(SCALE_OPTION1, MEDIUMWAIT);
		waitForSecs(15,"waiting for resuts table to load");
		safeClick(REFRESH_CHART, MEDIUMWAIT);
		waitForSecs(5,"waiting for resuts table to load");
		//Compare scores displayed in Key measures tab with the scores stored in Enter scores tab
		String studID = stdName.substring(10, 14);
		String score_in_Results_Table = safeGetText(Dynamic.getNewLocator(STUDENT_IN_RESULTS_TABLE, studID), MEDIUMWAIT);
		Assert.assertEquals(score_in_Results_Table, stdScore);
		
	}

	/**
	 * Purpose is to verify the Student Parent reports
	 */
	public void verifyStudentParentReports(String stdname) {
		//Navigate to Student Parent report page 
		safeClick(STUDENT_PARENT_LINK, MEDIUMWAIT);
		Assert.assertTrue(isElementDisplayed(STUDENT_PARENT_PAGE), "Student Parent page is not being displayed");
		//Select the student to generate the Student Parent report
		safeClick(Dynamic.getNewLocator(STUDENT_SELECTION_FOR_REPORT_GENERATION, stdname), MEDIUMWAIT);
		safeClick(STEP1_CONTINUE_BTN, MEDIUMWAIT);
		safeClick(STEP2_CONTINUE_BTN, MEDIUMWAIT);
		//Verify generated student parent report
		Assert.assertTrue(isElementDisplayed(Dynamic.getNewLocator(STUDENT_PARENT_REPORT, stdname)), "Student Parent generated report page is not being displayed");

	}

	public DistrictAdminHomepage navigateToDistrictAdmin() {
		// TODO Auto-generated method stub
		return new DistrictAdminHomepage(driver);
	}
		
		
		 
		
	
	

}

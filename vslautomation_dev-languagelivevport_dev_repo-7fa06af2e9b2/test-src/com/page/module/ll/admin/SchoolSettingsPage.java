package com.page.module.ll.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.admin.SchoolSettingsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class SchoolSettingsPage extends SafeActions implements SchoolSettingsLocators{

	WebDriver driver;
	
	 public SchoolSettingsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	
	}
	 /**
	  * Verifies Summary tab is highlighted by default on Clicking Tools->District settings
	  */
	 public void verifySummaryTabHighlighted()
	 {
		 Assert.assertTrue(isElementPresent(SUMMARYTAB_ISSELECTED), "Summary Tab is not highlighted by default on Clicking Tools->District settings");
	 }
	 /**
		 * To Selects class from 'All classes' drop down
		 */
		public void selectClassFromAllClasses(String className) {
			setImplicitWait(LONGWAIT);
			isElementPresent(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN, "All Classes"), LONGWAIT);
			safeJavaScriptClick(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN, "All Classes"), LONGWAIT);
			safeClick(Dynamic.getNewLocator(ALLCLASSES_DRPDOWN,className + " LL"), LONGWAIT);

		}
		
		
	 /**
	  * This method navigates to the School settings fraae
	  */
	  public void moveToFrame()
	  {
		  selectFrame(SCHOOLSETTINGS_FRAME, LONGWAIT);
		 
	  }
	  
	   public void moveToDefaultFrame()
	   {
		   defaultFrame();
	   }
	   /**
	    * verifies Summary tab is loaded or not  by verifying Implementation Summary table is present or  not 
	    */
	  public void verifySummaryTabLoaded()
	  {
		  
		  Assert.assertTrue(isElementPresent(IMPLEMENTATIONSUMMARY_TABLE,LONGWAIT), "Implementation summary table is not loaded on opening 'District Settings'->'Summary' tab ");
	  }
	  /**
	   * verifies Implementation Summary table data in School Settings by comparing with the Implementation summary table available in Vport->My School->Summary page
	   * @param vportSummarytable
	   */
	  public void verifyImplementationSummaryTablewithVportSummaryTable(Map<String,String> vportSummarytable)
	  {
		//  Map<String, String> map = new HashMap<String, String>();
			List<WebElement> implementationSummaryRowHeadings= LocatorWebElements(IMPLEMENTATIONSUMMARY_TABLEROWS);
			List<WebElement> teachersRowValues = LocatorWebElements(IMPLEMENTATIONSUMMARY_VALUES);
			for (int i = 0; i <implementationSummaryRowHeadings.size(); i++) {
				
				String rowName=implementationSummaryRowHeadings.get(i).getText();
				String rowValue=teachersRowValues.get(i).getText();
				String no=vportSummarytable.get(rowName);
				System.out.println(no);
				Assert.assertEquals(vportSummarytable.get(rowName),rowValue,"Implemenation Summary table :"+ rowName+" row value  in Summary tab of Language live is not matched with the Implemenation Summary table in Vport ");
	  
			}
	  }	
			/**
			 * To Clicks on Roster sub tab in District Settings
			 */
			public void clickOnRosterTab()

			{
				safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "ROSTER"),LONGWAIT);
			}
			
			/**
			 * Verifies Roster Tab is loaded or not by 
			 */
			public void verifyRosterTabLoaded() {

				Assert.assertEquals(safeGetText(SCHOOLSETTINGSSUBTABS_HEADING, LONGWAIT),"Manage Roster","Manage Roster heading is not displayed on loading  'District Settings'->'Roster' tab ");
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
		            Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(ADDEDSTUDENTID_FIELD, studentId), LONGWAIT), "The student user with id("+studentId+") is not added to the class on My Class->Roster page");
		     }
		     
		     /**
		      * To find the number of students are displayed in the Roster table
		      * @return
		      */
		     public int GetNumberOfStudentsCountInRosterTable()
		     {
		    	 return LocatorWebElements(NOOFSTUDENTSINROSTER_TABLE).size();
		     }
		     
		     /**
		      * To get all student last names from the Roster table and returns them
		      * 	
		      * @return
		      */
		     public String[] getAllStudentsNamesFromRosterTable()
		     {
		    	 int noOfStudents=GetNumberOfStudentsCountInRosterTable();
		    	 String studentLastName[]=new  String[noOfStudents];
		    	  for(int i=0;i<noOfStudents;i++)
		    	  {
		    		  String x=safeGetText(Dynamic.getNewLocator(STUDENTNAMESINROSTER_TABLE, Integer.toString(i+1)),LONGWAIT);
		    		  studentLastName[i]=x.split(",")[0];
		    	  }
		    	   return studentLastName;
		     }
		     

				public Object[] getStudentsCountAndNamesInRosterTable()
				{
					int noOfStudentsCount=0;
					int currentpageStudents;
					
					ArrayList<String> studentLastName=new ArrayList<String>();
					System.out.println("---------------------"+isElementDisplayed(NEXT_LINK));
					if(isElementPresent(NEXT_LINK,SHORTWAIT))
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
						waitForSecs(6,"waiting for Result page load");
						safeJavaScriptClick(RESULTPAGE_1, LONGWAIT);	
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
		     
		     /**
		 	 * To Clicks on Roster sub tab in District Settings
		 	 */
		 	public void clickOnStudentsTab()

		 	{
		 		safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "STUDENTS"),LONGWAIT);
		 	}
		

		 	/**
			 * To Clicks on Targets sub tab in District Settings
			 */
			public void clickOnTargetsTab()

			{
				safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "TARGETS"),LONGWAIT);
			}
			
			/**
			 * To Clicks on Targets sub tab in District Settings
			 */
			public void clickOnBenchMarksTab()

			{
				safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "BENCHMARKS"),LONGWAIT);
			}
			
			/**
			 * To Clicks on Teachers and Classes sub tab in District Settings
			 */
			public void clickOnTeachersAndClassesTab()

			{
				safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "TEACHERS & CLASSES"),LONGWAIT);
			}
			
			/**
			 * Verifies Teachers and Classes  Tab is loaded or not 
			 */
			public void verifyTeachersAndClassesTabLoaded() {

				Assert.assertEquals(safeGetText(SCHOOLSETTINGSSUBTABS_HEADING, LONGWAIT),"Teachers and Classes","Teachers and Classes heading is not displayed on loading  'District Settings'->'Teachers&Classes' tab ");
			}
			
			/**
			 * To Clicks on Teachers and Classes sub tab in District Settings
			 */
			public void clickOnImportStudentsTab()

			{
				safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "IMPORT STUDENTS"),LONGWAIT);
			}
			
			/**
			 * Verifies Teachers and Classes  Tab is loaded or not 
			 */
			public void verifyImportStudentsTabLoaded() {

				Assert.assertEquals(safeGetText(SCHOOLSETTINGSSUBTABS_HEADING, LONGWAIT),"Import Students","Import Students heading is not displayed on loading  'District Settings'->'Teachers&Classes' tab ");
			}
			
			
			/**
			 * To Clicks on Licesnes sub tab in District Settings
			 */
			public void clickOnLicensesTab()

			{
				safeClick(Dynamic.getNewLocator(SCHOOLSETTINGS_SUBTABS, "LICENSES"),LONGWAIT);
			}
			
			/**
			 * Verifies Licenses  Tab is loaded or not 
			 */
			public void verifyLicensesTabLoaded() {

				Assert.assertEquals(safeGetText(SCHOOLSETTINGSSUBTABS_HEADING, LONGWAIT),"Licenses","Teachers and Classes heading is not displayed on loading  'District Settings'->'Teachers&Classes' tab ");
			}



}

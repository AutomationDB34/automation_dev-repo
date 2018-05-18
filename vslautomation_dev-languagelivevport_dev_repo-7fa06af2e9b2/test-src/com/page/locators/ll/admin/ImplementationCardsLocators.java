package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface ImplementationCardsLocators {
	
By WELCOME_FRAME=By.xpath("//*[@class='Cambium.App.PostLogin.vportFrame']");
By DISTRICTNAME_RADIOBUTTON=By.xpath("//label[contains(text(),'Language! Live 2015-2016')]");
By CONTINUE_BTN = By.xpath("//img[@class='Cambium.UI.ActionButton.rightCarrot']");


By YOURPROFILE_HEADING=By.className("titleBar");
By EMAILINWELCOMEPAGE_TEXT=By.id("userEmail");
By TRAININGOPTION_DRPDOWN=By.name("trainingAttendedId");
By SAVEANDCONTINUE=By.xpath((".//button[contains(text(),'Save & Continue')]"));
By ACCEPTTERMS_CHKBOX=By.name("hasAcceptedTermsOfUse"); 
By IMPLEMENTATION_LIST=By.xpath(".//ul[@class='progressBar']/li/div");
By lIMPLEMENTATION_LISTNAMES=By.xpath(".//ul[@class='progressBar']/li[%s]/div");



//Locators in About Tab
 By WATCHTHISVIDEO_HEADINGINGOALS=By.className("lowerTitleLine");	
 By TAB=By.id("%s");// change locator to ID

//Locators in Goals Tab
 By TITLEOFGOALSPAGE=By.xpath(".//div[text()='Decide how you will measure success this year.']");
  By USESTANDARDISEDMEASURES_CHKBOX=By.xpath("//input[@type='checkbox' and @name='useIndependentMeasuresProvidedWithProgram']");
  By USESTATEASSESSMENTS_CHKBOX=By.xpath("//input[@type='checkbox' and @name='useStateAssessmentAndCommonCoreStateStandards']");
  By USEINDEPENDENTMEASURES_CHKBOX=By.xpath("//input[@type='checkbox' and @name='useIndependentMeasuresForBenchMarks']");
 
//Locators in  participation  tab
   By TITLEOFPARTICIPATIONPAGE=By.xpath(".//div[text()='Determine student participation in the program.']");
   By DESCRIBEYOURPLACEMENT_TEXTAREA=By.id("placementStrategy");
   
   //Locators in Create Plan tab
   By TITLEOFCREATEPLANPAGE=By.xpath(".//div[text()='Create your implementation plan.']");
   By INSTRUCTIONSTARTDATE=By.id("implementationPlanExceptedStartDate");
   By INSTRUCTIONENDDATE=By.id("implementationPlanExpectedEndDate");
   By DAYS_DROPDOWN=By.id("daysPerWeek");
   By MINUTES_DRPDOWN=By.id("minutesPerDay");
   By TECHNOLOGY_OPTIONS= By.id("typicalTechnologyAccess");
   By BENCHMARK1_STARTDATE=By.id("implementationPlanBenchmark1StartDate");
   By BENCHMARK1_ENDDATE=By.id("implementationPlanBenchmark1EndDate");
   By BENCHMARK1NOTAPPLICABLE_CHKBOX=By.id("benchmark1datesNotAvailable");
   
   By BENCHMARK2_STARTDATE=By.id("implementationPlanBenchmark2StartDate");
   By BENCHMARK2_ENDDATE=By.id("implementationPlanBenchmark2EndDate");
   By BENCHMARK2NOTAPPLICABLE_CHKBOX=By.id("benchmark2datesNotAvailable");
   
   By BENCHMARK3_STARTDATE=By.id("implementationPlanBenchmark3StartDate");
      By BENCHMARK3_ENDDATE=By.id("implementationPlanBenchmark3EndDate");
      By BENCHMARK3NOTAPPLICABLE_CHKBOX=By.id("benchmark3datesNotAvailable");
      
    By COMMENTS_TEXTAREA=By.id("implementationComments");
    
    //Locators in review Plan tab
    By DISTRICTCALENDAR_PANE=By.xpath(".//div[text()='District Calendar']/../div[%s]");
    By BENCHMARKWINDOWS_PANE=By.xpath(".//div[text()='Benchmark Windows']/../div[%s]");
    By INSTRUCTIONALTARGETS_PANE=By.xpath(".//div[text()='Instructional Targets']/../div[%s]");
    By INSTRUCTIONALTARGETSDAYSMINUTES=By.xpath(".//div[text()='Instructional Targets']/../div[%s]/span");
    
    By TECHNOLOGYACCESS_PANE=By.xpath(".//div[text()='Technology Access']/../div[%s]");
    
    
   //Locators for Training tab
    By TITLEOFTRAININGPAGE=By.xpath(".//div[text()='Organize teacher training for ']");
    
    //Locators for Technology tab
    By TITLEOFTECHONOLOGYPAGE=By.xpath(".//div[text()='Get the technology right.']");
     By REVIEWMODELOPTIONS_TEXTAREA=By.id("studentComputerAccess");
     By MINIMUMSYSMREQUIREMENTS_TEXTAREA=By.id("districtCommitComputers");
     By  BANDWIDTH_TEXTAREA=By.id("districtBandwidth");
     By FULLNAME_TXT=By.id("nameField");
     By EMAIL_TXT=By.name("primaryTechnologyContactEmail");
     By PHONENUMBER_TXT=By.id("phoneField");
     
        
     //Locators for IMPORTDATA tab
 
       By TITLEOFIMPORTDATAPAGE=By.xpath(".//div[text()='Import data to set up teachers, classes, and']");
      By GOTODASHBOARD_BTN=By.xpath(".//button[text()='Go to My Dashboard']");
      
       
     By SAVEANDGOTOMYDASHBOARD=By.id("saveClose");
 	By REVIEW_LINKS=By.xpath("//div[contains(@class,'Cambium.App.Dashboards.District2.PreImplAndLaunch.b2')]//div[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.sqr']//span[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.link']");

   
   By IMPLEMENTATIONCARDS_FRAME=By.className("Cambium.App.Dashboards.VPort.vportFrame");
  
   
   By SUBDISTRICT_LOGIN = By.xpath("//h3[contains(text(),'You are attempting to log in as a sub-district user. You must log into LANGUAGE! Live as either a district or campus user.')]");
   
}

package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface LLHomePageLocators {
	
	By MAINTABS_NAMES=By.xpath(".//span[contains(@class,'Cambium.UI.Tabs.Tabs.tab Cambium.LanguageLive.UI.DashboardMenu.primaryTab')][text()='%s']");
	// By DASHBOARD_TAB=By.xpath(".//span[@name='Dashboard']");
	By TABS_NAMES = By.xpath(".//td[@class='Cambium.LanguageLive.UI.DashboardMenu.secondContainer']//td//span[text()='%s']/span");
	By TITLEFORTABS = By.xpath("//td[@class='Cambium.LanguageLive.UI.DashboardMenu.content Cambium.CSS.loadable']//td[text()='%s']");
	
	//Locators for selecting Tabs
	By DASHBOARD_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_gauge");
	By STARTUPREPORTS_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_barGraph");
	By COURSEREPORTS_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_barGraph");
	By BENCHMARKREPORTS_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_arrowToTarget");
	By NOTIFICATIONSREPORT_ICON = By.className("Cambium.LanguageLive.UI.DashboardMenu.tabIcon_bell");


	By PANESINHOMEPAGE_HEADINGS = By.xpath("(//tr[@class='Cambium.App.Dashboards.District2.row'])[2]//td[text()='%s']");
	
	// Locators in Dashboard->Preimplementation frame 
	By PREIMPLEMENTATIONLAUNCHPANE_HEADING = By.xpath("//table[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.tbl1']//span[text()='Pre-Implementation & Launch']");
	
	By GETTINGSTARTEDSTEPS_LINKS = By.xpath("//table[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.steps']//tr/td[2]");
	By IMPLEMENTATIONPLAN_SUBHEADINGS=By.xpath("//div[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.topic']");
	By REVIEW_LINKS=By.xpath("//div[contains(@class,'Cambium.App.Dashboards.District2.PreImplAndLaunch.b2')]//div[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.sqr']//span[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.link']");
	By TEACHERTRAINING_SUBHEADING=By.xpath("//div[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.topic'][text()='Teacher Training']");
	
	//Locators in Dashboard->Need Help frmae
	By SUPPORTMOBILE_NUMBER=By.xpath("//td[@class='Cambium.App.Dashboards.District2.NeedHelp.col2']/div[%s]");
	By EMAILSUPPORT_LINK=By.xpath("//a[@class='Cambium.App.Dashboards.District2.NeedHelp.pri Cambium.App.Dashboards.District2.NeedHelp.link']");
	
	//Locators in Dashboard-->Startup Frame
	By STUDENTS_SUBHEADING=By.xpath("//div[@class='Cambium.App.Dashboards.District2.StartUp.blueHdrText'][text()='Students']");
	By TEACHERS_SUBHEADING=By.xpath("//div[@class='Cambium.App.Dashboards.District2.StartUp.blueHdrText'][text()='Teachers']");
	By STUDENTSTARTUPREPORT_LINK=By.xpath("//span[text()='View Student Start Up Detail Report']");
	By TEACHERSTARTUPREPORT_LINK=By.xpath("//span[text()='View Teacher Start Up Detail Report']");
	By TEACHERSROWSNAMESINSTARTUP_ROWS=By.xpath("//table[@class='Cambium.App.Dashboards.District2.StartUp.teachers']//td[@class='Cambium.App.Dashboards.District2.StartUp.item']");
	By TEACHERSROWSVALUESINSTARTUP_ROWS=By.xpath("//table[@class='Cambium.App.Dashboards.District2.StartUp.teachers']//td[@class='Cambium.App.Dashboards.District2.StartUp.val']");
	By STUDENTSROWSNAMESINSTARTUP_ROWS=By.xpath("//table[@class='Cambium.App.Dashboards.District2.StartUp.students']//td[@class='Cambium.App.Dashboards.District2.StartUp.item']");
	By STUDENTSROWSVALUESINSTARTUP_ROWS=By.xpath("//table[@class='Cambium.App.Dashboards.District2.StartUp.students']//td[@class='Cambium.App.Dashboards.District2.StartUp.val']");
	
	//Locators in Dashboard->Technology Frame
	By TECHNOLOGY_SUBHEADINGS=By.xpath("(//div[@class='Cambium.App.Dashboards.District2.Technology.blueHdrText'])[%s]");
	By LEARN_LINK=By.xpath("//span[@data-type='explain']");
	By TECHNOLOGYISSUESDIALOGBOX_HEADING=By.xpath("//*[@class='Cambium.LanguageLive.UI.Well.col Cambium.LanguageLive.UI.Well.title']");
	By TECHNOLOGYISSUESDIALOGBOX_CLOSE=By.xpath("//div[contains(@class,'Cambium.App.Dashboards.District2.Technology.ExplainTickets.closerX')]");
		
	//Locators in Dashboard->Course Progress & Performance frame
	 By COURSEPROGRESSPERFORMANCE_SUBHEADINGS=By.xpath("(//div[@class='Cambium.App.Dashboards.District2.CourseProgress.hdr Cambium.App.Dashboards.District2.CourseProgress.pri'])[%s]");
	 By ONPACE_LINKS=By.xpath("//*[@class='Cambium.App.Dashboards.District2.CourseProgress.item'][text()='%s']");
	 By ONPACE_SCORE=By.xpath("//*[@class='Cambium.App.Dashboards.District2.CourseProgress.item'][text()='%s']/../td[2]/span");
	 By WORDANDTEXTTRAININGPERFORMANCE_LINKS=By.xpath("//td[text()='%s']/../../tr/td[text()='%s']");
	By WORDANDTEXTTRAININGPERFORMANCE_SCORES=By.xpath("(//td[text()='%s']/../../tr/td[text()='%s']/..//span)[1]");
	 
	By COURSEPROGRESSANDPERFORMACEDIALOGPRIMARY_HEADING=By.xpath("//span[@class='Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.primaryTitle']");
	By COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING=By.xpath("//span[@class='Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.secondaryTitle']");
	By SCHOOLSANDCLASSESSUBTAB_HEADING=By.xpath("(//div[contains(@class,'Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.hdr Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.pri')])[2]");

	By COURSEPROGRESSANDPERFORMANCE_CLOSE=By.xpath("//div[contains(@class,'Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.closerX')]");
		
	//Locators in Bench mark testing Frame
	
	By UNMATCHEDSCORES_TAB=By.xpath("//span[text()='Unmatched Scores']");
	By MATCHEDSCORES_TAB=By.xpath("//span[text()='Matched Scores']");
	By BECHAMRKTESTING_SUBHEADINGS=By.xpath("//div[@class='Cambium.App.Dashboards.District2.BenchmarkTesting.primaryHdr']");
	By SCORESINBENCHMARKTESTING_GRAPH=By.xpath("(//*[@class='Cambium.App.Dashboards.District2.BenchmarkTesting.tbl1']//*[name()='svg']//*[name()='g'][@class='highcharts-data-labels']//*[name()='text'])[%s]");
	
	
	
	By SCHOOLS_SUBHEADING=By.xpath("//td[@value='schools']");
	By CLASSES_SUBHEADING=By.xpath("//td[@value='classes']");
	By COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE=By.xpath("(//td[.//span[text()='%s']])[4]//following-sibling::td[3]/span[1]");
	By COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE_ALL=By.xpath(".//span[contains(@class,'Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.pct Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer')]");
	By COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE_INDIVIDUAL=By.xpath("(//span[contains(@class,'Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.pct Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer')])[%s]");
	By COURSEPROGRESSANDPERFORMACEDIALOGSCHOOLS_PERCENTAGE=By.xpath("(//td[.//span[text()='%s']])[4]//following-sibling::td[2]/span[1]");
	//View profile
	//By USER_DROPDOWN = By.xpath("//td[@class='Cambium.LanguageLive.UI.DashboardMenu.UserMenu.arrowCol']/span");
	By VIEWPROFILE_LINK=By.xpath("//td[@value='profile']");
	
	
//>>>>>>> origin/Admin-Scenarios
//
//		// Locators in Dashboard->Preimplementation frame 
//		By PREIMPLEMENTATIONLAUNCHPANE_HEADING = By.xpath("//table[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.tbl1']//span[text()='Pre-Implementation & Launch']");
//		By PANESINHOMEPAGE_HEADINGS = By.xpath("//tr[@class='Cambium.App.Dashboards.District2.row']//td[text()='%s']");
//		By GETTINGSTARTEDSTEPS_LINKS = By.xpath("//table[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.steps']//tr/td[2]");
//		By IMPLEMENTATIONPLAN_SUBHEADINGS=By.xpath("//div[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.topic']");
//		By REVIEW_LINKS=By.xpath("(//span[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.link'])[%s]");
//		By TEACHERTRAINING_SUBHEADING=By.xpath("//div[@class='Cambium.App.Dashboards.District2.PreImplAndLaunch.topic'][text()='Teacher Training']");
//		
//		//Locators in Dashboard->Need Help frmae
//		By SUPPORTMOBILE_NUMBER=By.xpath("//td[@class='Cambium.App.Dashboards.District2.NeedHelp.col2']/div[%s]");
//		By EMAILSUPPORT_LINK=By.xpath("//a[@class='Cambium.App.Dashboards.District2.NeedHelp.pri Cambium.App.Dashboards.District2.NeedHelp.link']");
//		
//		//Locators in Dashboard-->Startup Frame
//		By STUDENTS_SUBHEADING=By.xpath("//div[@class='Cambium.App.Dashboards.District2.StartUp.blueHdrText'][text()='Students']");
//		By TEACHERS_SUBHEADING=By.xpath("//div[@class='Cambium.App.Dashboards.District2.StartUp.blueHdrText'][text()='Teachers']");
//		By STUDENTSTARTUPREPORT_LINK=By.xpath("//span[text()='View Student Start Up Detail Report']");
//		By TEACHERSTARTUPREPORT_LINK=By.xpath("//span[text()='View Teacher Start Up Detail Report']");
//		
//		//Locators in Dashboard->Technology Frame
//		By TECHNOLOGY_SUBHEADINGS=By.xpath("(//div[@class='Cambium.App.Dashboards.District2.Technology.blueHdrText'])[%s]");
//		By LEARN_LINK=By.xpath("//span[@data-type='explain']");
//		By TECHNOLOGYISSUESDIALOGBOX_HEADING=By.xpath("//*[@class='Cambium.LanguageLive.UI.Well.col Cambium.LanguageLive.UI.Well.title']");
//		By TECHNOLOGYISSUESDIALOGBOX_CLOSE=By.xpath("//div[contains(@class,'Cambium.App.Dashboards.District2.Technology.ExplainTickets.closerX')]");
//			
//		//Locators in Dashboard->Course Progress & Performance frame
//		 By COURSEPROGRESSPERFORMANCE_SUBHEADINGS=By.xpath("(//div[@class='Cambium.App.Dashboards.District2.CourseProgress.hdr Cambium.App.Dashboards.District2.CourseProgress.pri'])[%s]");
//		 By ONPACE_LINKS=By.xpath("//*[@class='Cambium.App.Dashboards.District2.CourseProgress.item'][text()='%s']");
//		 By ONPACE_SCORE=By.xpath("//*[@class='Cambium.App.Dashboards.District2.CourseProgress.item'][text()='%s']/../td[2]/span");
//		 By WORDANDTEXTTRAININGPERFORMANCE_LINKS=By.xpath("//td[text()='%s']/../../tr/td[text()='%s']");
//		By WORDANDTEXTTRAININGPERFORMANCE_SCORES=By.xpath("(//td[text()='%s']/../../tr/td[text()='%s']/..//span)[1]");
//		 
//		By COURSEPROGRESSANDPERFORMACEDIALOGPRIMARY_HEADING=By.xpath("//span[@class='Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.primaryTitle']");
//		By COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING=By.xpath("//span[@class='Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.secondaryTitle']");
//		By SCHOOLSANDCLASSESSUBTAB_HEADING=By.xpath("(//div[contains(@class,'Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.hdr Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.pri')])[2]");
//		
//		By SCHOOLS_SUBHEADING=By.xpath("//td[@value='schools']");
//		By CLASSES_SUBHEADING=By.xpath("//td[@value='classes']");
//		By COURSEPROGRESSANDPERFORMACEDIALOG_PERCENTAGE=By.xpath("//td[@class='Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.col3']/span[1]");
//		By COURSEPROGRESSANDPERFORMANCE_CLOSE=By.xpath("//div[contains(@class,'Cambium.App.Dashboards.District2.CourseProgress.MiddleLayer.closerX')]");
//		
		By START_BTN = By.xpath("//button[@data-type='WT']");
		By COURSE_LINK = By.name("Course");
		By CONTINUE_BTN = By.xpath("//img[@class='Cambium.UI.ActionButton.rightCarrot']");
		By WT_PAGE = By.id("Cambium.LanguageLive.Course.20.empty");

		By SHORTCUT_MENU = By.className("Cambium.LanguageLive.UI.BundlePicker.menu");

		By LEVEL_WT = By.xpath(
				"//td[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.level Cambium.LanguageLive.trainingArea_wordTraining')]//div[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.levelTitle')][contains(text(),'%s')]");
		
		By LESSON = By.xpath(
				"//td[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.level Cambium.LanguageLive.trainingArea_wordTraining ')]//div[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.levelTitle')][contains(text(),'%s')]/following-sibling::table/tbody/tr%s/td/table/tbody/tr%s/td/div");

		By ACTIVITY = By.xpath(
				"//td[@class='Cambium.LanguageLive.UI.BundlePicker.level Cambium.LanguageLive.trainingArea_wordTraining ']//div[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.levelTitle')][contains(text(),'%s')]/following-sibling::table/tbody/tr%s/td/table/tbody/tr%s/td/table/tbody/tr/td[contains(text(),%s)]");


		By STUDENT_STADIUMBACKGROUND = By.className("Cambium.App.StudentHomePage.stadiumBackground"); 
		
		 By STUDENT_STADIUM_LESSON_SECTION = By.className("Cambium.App.StudentHomePage.talkBubble");
		 By TT_VIEWPOWERPASS_FEEDBACK_LINK = By.xpath("//button[contains(@class,'Cambium.App.StudentHomePage.TT')][contains(text(),'View Power Pass Feedback')]");
		 
		 By TT_STARTPOWERPASS_LINK = By.xpath("//button[contains(@class,'Cambium.App.StudentHomePage.TT')][contains(text(),'Start Power Pass')]");
		 

		 By L1U1Lesson = By.xpath(
			"//td[@class='Cambium.LanguageLive.UI.BundlePicker.level Cambium.LanguageLive.trainingArea_wordTraining ']//div[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.levelTitle')][contains(text(), 'Level 1')]/following-sibling::table/tbody/tr%s/td/table/tbody/tr%s/td/div");

		 By activity = By.xpath(
			"//td[@class='Cambium.LanguageLive.UI.BundlePicker.level Cambium.LanguageLive.trainingArea_wordTraining ']//div[contains(@class,'Cambium.LanguageLive.UI.BundlePicker.levelTitle')][contains(text(), 'Level 1')]/following-sibling::table/tbody/tr%s/td/table/tbody/tr%s/td/table/tbody/tr/td[contains(.,%s)]");

		 
	

}
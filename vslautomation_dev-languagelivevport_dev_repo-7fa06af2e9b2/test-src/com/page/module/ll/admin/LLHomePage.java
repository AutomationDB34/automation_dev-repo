package com.page.module.ll.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;

import com.datamanager.ConfigManager;
import com.page.locators.ll.admin.LLHomePageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.page.module.ll.teacherrole.TeacherRoleCoursePage;
import com.page.module.ll.teacherrole.TeacherRoleToolsPage;
import com.page.module.ll.teacherrole.TeacherToolsCourseResourcesPage;
import com.page.module.ll.teacherrole.TeacherViewProfileAboutMePage;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

public class LLHomePage extends CommonFunctionalities implements LLHomePageLocators {

	String WordTrainingpacePercentageinHome;
	String textTrainingpacePercentageinHome;
	//String score1;
	String score2;
	ConfigManager sys = new ConfigManager();
	WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public LLHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * This method verifies language Live Dashbard
	 */
	public void verifyLanguageLiveDashBoard() {
		waitForPageToLoad();
		boolean bDashboardTabExists = isElementPresent(Dynamic.getNewLocator(TABS_NAMES, "Dashboard"), LONGWAIT);
		Assert.assertTrue(bDashboardTabExists,
				"Dash Board page is not opened after completion of implementation cards ");
	}

	/**
	 * This method clicks on Reports->Dash board tab
	 */
	public void clickDashBoradTab() {
		waitForPageToLoad();
		isElementPresent(Dynamic.getNewLocator(TABS_NAMES, "Dashboard"), LONGWAIT);
		safeJavaScriptClick(Dynamic.getNewLocator(TABS_NAMES, "Dashboard"), LONGWAIT);
	}

	/**
	 * This method clicks on Reports->Course Reports tab
	 */
	public CourseReportsPage clickCourseReportsTab() {

		isElementPresent(Dynamic.getNewLocator(TABS_NAMES, "Course Reports"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(TABS_NAMES, "Course Reports"), LONGWAIT);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return new CourseReportsPage(driver);
	}

	/**
	 * This method clicks on Reports->Benchmark reports tab
	 */
	public BenchMarkReportsPage clickBenchMarkReportsTab() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		safeActionsClick(Dynamic.getNewLocator(TABS_NAMES, "Benchmark Reports"), VERYLONGWAIT);
		return new BenchMarkReportsPage(driver);
	}

	/**
	 * This method clicks on Reports->Notifications report tab
	 */
	public NotificationReportsPage clickNotificationReportTab() {
		waitForPageToLoad();
		safeActionsClick(Dynamic.getNewLocator(TABS_NAMES, "Notifications Report"), VERYLONGWAIT);
		return new NotificationReportsPage(driver);
	}

	/**
	 * This method clicks on Tools Tab
	 */
	public CourseResourcesPage clickOnToolsTab() {
		safeClick(Dynamic.getNewLocator(MAINTABS_NAMES, "Tools"), LONGWAIT);
		waitForSecs(5,"Waiting to load the elements");
		return new CourseResourcesPage(driver);
	}

	/**
	 * This method clicks on Classes Tab
	 */
	public ClassWallPage clickOnClassesTab() {
		safeClick(Dynamic.getNewLocator(MAINTABS_NAMES, "Classes"), LONGWAIT);
		waitForSecs(4 ,"Waiting for classwall tab to load");
		return new ClassWallPage(driver);
	}

	/**
	 * This method clicks on Courses Tab
	 */
	public TeacherRoleCoursePage clickOnCoursesTab() {
		safeClick(Dynamic.getNewLocator(MAINTABS_NAMES, "Course"), LONGWAIT);
		return new TeacherRoleCoursePage(driver);
	}

	/**
	 * Verifies DashBoard tab
	 *
	 */
	public void verifyDashBoardTab() 
	{
		waitForSecs(5, "Waiting dashboard to load");
		isElementClickable(Dynamic.getNewLocator(TABS_NAMES, "Dashboard"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(TABS_NAMES, "Dashboard"), LONGWAIT);
		boolean bDashboardIconExists = isElementDisplayed(DASHBOARD_ICON);
		Assert.assertTrue(bDashboardIconExists, "DashBoard tab icon is not displayed ");
		isElementPresent(Dynamic.getNewLocator(TITLEFORTABS, "Dashboard"), LONGWAIT);
		isElementPresent(Dynamic.getNewLocator(TITLEFORTABS, "Dashboard"), LONGWAIT);
		boolean bDashboardHeadingExists = isElementDisplayed(Dynamic.getNewLocator(TITLEFORTABS, "Dashboard"));
		Assert.assertTrue(bDashboardHeadingExists, "Dash board page Heading is not displayed  ");
	}

	/**
	 * Verifies Start Up Reports tab
	 * 
	 * @throws InterruptedException
	 *
	 */
	public void verifyStartUpReportsTab() {
		waitForSecs(1);
		isElementClickable(Dynamic.getNewLocator(TABS_NAMES, "Start Up Reports"), LONGWAIT);
		safeActionsClick(Dynamic.getNewLocator(TABS_NAMES, "Start Up Reports"), LONGWAIT);

		boolean bStartUpReportsIconExists = isElementDisplayed(STARTUPREPORTS_ICON);
		Assert.assertTrue(bStartUpReportsIconExists, "Icon of Start Up Reports tab  is not displayed ");
		isElementPresent(Dynamic.getNewLocator(TITLEFORTABS, "Start Up Reports"), VERYLONGWAIT);
		boolean bStartUpReportsHeadingExists = isElementDisplayed(
				Dynamic.getNewLocator(TITLEFORTABS, "Start Up Reports"));
		Assert.assertTrue(bStartUpReportsHeadingExists, "Heading for Start Up Reports page is not displayed");
	}

	/**
	 * Verifies Course Reports tab
	 * 
	 * @throws InterruptedException
	 *
	 */
	public void verifyCourseReportsTab() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementClickable(Dynamic.getNewLocator(TABS_NAMES, "Course Reports"), LONGWAIT);
		safeActionsClick(Dynamic.getNewLocator(TABS_NAMES, "Course Reports"), VERYLONGWAIT);
		boolean bCourseReportsIconExists = isElementDisplayed(COURSEREPORTS_ICON);
		Assert.assertTrue(bCourseReportsIconExists, "Icon of  Course Reports tab  is not displayed ");

		boolean bCourseReportsHeadingExists = isElementPresent(
				Dynamic.getNewLocator(TITLEFORTABS, "Course Performance Reports"), VERYLONGWAIT);
		Assert.assertTrue(bCourseReportsHeadingExists, "Heading for Course Reports page is not displayed  ");
	}

	/**
	 * Verifies Benchmark Reports tab
	 *
	 */
	public void verifyBenchmarkReportsTab() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementClickable(Dynamic.getNewLocator(TABS_NAMES, "Benchmark Reports"), LONGWAIT);
		safeActionsClick(Dynamic.getNewLocator(TABS_NAMES, "Benchmark Reports"), VERYLONGWAIT);
		boolean bBenchmarkReportsIconExists = isElementDisplayed(BENCHMARKREPORTS_ICON);
		Assert.assertTrue(bBenchmarkReportsIconExists, "Icon of  Benchmark Reports tab  is not displayed ");

		boolean bBenchmarkReportsHeadingExists = isElementDisplayed(
				Dynamic.getNewLocator(TITLEFORTABS, "Benchmark Report"));
		Assert.assertTrue(bBenchmarkReportsHeadingExists, "Heading for  Benchmark Reports page is not displayed  ");
	}

	/**
	 * Verifies Notifications Report tab
	 *
	 */
	public void verifyNotificationsReportTab() {
		safeActionsClick(Dynamic.getNewLocator(TABS_NAMES, "Notifications Report"), VERYLONGWAIT);
		boolean bNotificationReportIconExists = isElementDisplayed(NOTIFICATIONSREPORT_ICON);
		Assert.assertTrue(bNotificationReportIconExists, "Icon of  Benchmark Reports tab  is not displayed ");

		boolean bNotificationReportHeadingExists = isElementDisplayed(
				Dynamic.getNewLocator(TITLEFORTABS, "Notifications Report"));
		Assert.assertTrue(bNotificationReportHeadingExists, "Heading for  Benchmark Reports page is not displayed  ");
	}

	/**
	 * Verifies All frames Pre-Implementation & Launch, Need help?, Start Up,
	 * Technology, Course Progress & Performance, Benchmark Testing are enabled
	 * in Dash board Home Page for District user
	 */
	public void verifyAllFramesEnabledInHomePageforDistrictUser() {
		refresh();
		setImplicitWait(VERYLONGWAIT);
		boolean bPreImplementationFrameExists = isElementDisplayed(PREIMPLEMENTATIONLAUNCHPANE_HEADING);
		Assert.assertTrue(bPreImplementationFrameExists,
				"Pre Implemetation & launch Frame doesn't exists in  Home Page Dashboard");

		boolean bNeedHelpFrameExists = isElementDisplayed(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Need help?"));
		Assert.assertTrue(bNeedHelpFrameExists, "Need Help? Frame doesn't exists in Home Page Dashboard");

		boolean bTechnologyFrameExists = isElementDisplayed(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Technology"));
		Assert.assertTrue(bTechnologyFrameExists, "Technology Frame doesn't exists in  Home Page Dashboard");

		boolean bStartUpFrameExists = isElementDisplayed(Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Start Up"));
		Assert.assertTrue(bStartUpFrameExists, "Start Up Frame doesn't exists in Home Page Dashboard");

		boolean bCourseProgressPerformanceFrameExists = isElementPresent(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Course Progress & Performance"), VERYLONGWAIT);
		Assert.assertTrue(bCourseProgressPerformanceFrameExists,
				"course Progress & Performance Frame doesn't exists in  Home Page Dashboard");

		boolean bBenchmarkTestingFrameExists = isElementDisplayed(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Benchmark Testing"));
		Assert.assertTrue(bBenchmarkTestingFrameExists,
				"Benchmark Testing Frame doesn't exists in  Home Page Dashboard");

		nullifyImplicitWait();
	}

	/**
	 * Verifies All frames Pre-Implementation & Launch, Need help?, Start Up,
	 * Course Progress & Performance, Benchmark Testing are enabled in Dash
	 * board Home Page for campus User
	 */
	public void verifyAllFramesEnabledInHomePageforCampusUser() {
		refresh();
		setImplicitWait(VERYLONGWAIT);
		boolean bPreImplementationFrameExists = isElementDisplayed(PREIMPLEMENTATIONLAUNCHPANE_HEADING);
		Assert.assertTrue(bPreImplementationFrameExists,
				"Pre Implemetation & launch Frame doesn't exists in  Home Page Dashboard");

		boolean bNeedHelpFrameExists = isElementDisplayed(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Need help?"));
		Assert.assertTrue(bNeedHelpFrameExists, "Need Help? Frame doesn't exists in Home Page Dashboard");

		// boolean
		// bTechnologyFrameExists=isElementDisplayed(Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS,
		// "Technology"));
		// Assert.assertTrue(bTechnologyFrameExists,"Technology Frame doesn't
		// exists in Home Page Dashboard");

		boolean bStartUpFrameExists = isElementDisplayed(Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Start Up"));
		Assert.assertTrue(bStartUpFrameExists, "Start Up Frame doesn't exists in Home Page Dashboard");

		boolean bCourseProgressPerformanceFrameExists = isElementDisplayed(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Course Progress & Performance"));
		Assert.assertTrue(bCourseProgressPerformanceFrameExists,
				"course Progress & Performance Frame doesn't exists in  Home Page Dashboard");

		boolean bBenchmarkTestingFrameExists = isElementDisplayed(
				Dynamic.getNewLocator(PANESINHOMEPAGE_HEADINGS, "Benchmark Testing"));
		Assert.assertTrue(bBenchmarkTestingFrameExists,
				"Benchmark Testing Frame doesn't exists in  Home Page Dashboard");

		nullifyImplicitWait();
	}

	/**
	 * Verify links in 'Getting started steps' section of Pre-Implementation &
	 * Launch
	 * 
	 * @param Steps
	 */
	public void verifyGettingStartedStepsforDistrictUser(String[] Steps) {

		List<WebElement> gettingStartedLinks = LocatorWebElements(GETTINGSTARTEDSTEPS_LINKS);
		for (int i = 0; i < gettingStartedLinks.size(); i++) {
			String linkText = gettingStartedLinks.get(i).getText();
			Assert.assertEquals(linkText, Steps[i],
					"The link " + Steps[i] + " is not displayed in the Getting Started steps Frame");

		}
	}

	public void verifyGettingStartedStepsforCampusUser(String[] Steps) {

		List<WebElement> gettingStartedLinks = LocatorWebElements(GETTINGSTARTEDSTEPS_LINKS);
		for (int i = 0; i < gettingStartedLinks.size(); i++) {
			String linkText = gettingStartedLinks.get(i).getText();

			// Steps[3]="Review Plan";
			Assert.assertEquals(linkText, Steps[i],
					"The link " + Steps[i] + " is not displayed in the Getting Started steps Frame");

		}
	}

	/**
	 * Verify District calendar,INstructional Targets, Benchmark windows,
	 * Technology access sub headings in Pre-Implementation & Launch for
	 * District user
	 * 
	 * @param implementationPane_Headings
	 */
	public void verifyImplementationPlanforDistrictUser(String[] implementationPane_Headings) {
		List<WebElement> subHeadings = LocatorWebElements(IMPLEMENTATIONPLAN_SUBHEADINGS);
		for (int i = 0; i < subHeadings.size() - 1; i++) {
			String SubHeadingsText = subHeadings.get(i).getText();

			Assert.assertEquals(SubHeadingsText, implementationPane_Headings[i], "The Sub heading"
					+ implementationPane_Headings[i] + " is not displayed in Implementation Plan  Frame");

		}
	}

	/**
	 * Verify District calendar,INstructional Targets, Benchmark windows,
	 * Technology access sub headings in Pre-Implementation & Launch for Campus
	 * user
	 * 
	 * @param implementationPane_Headings
	 */
	public void verifyImplementationPlanforCampusUser(String[] implementationPane_Headings) {
		List<WebElement> subHeadings = LocatorWebElements(IMPLEMENTATIONPLAN_SUBHEADINGS);
		for (int i = 0; i < subHeadings.size() - 1; i++) {
			String SubHeadingsText = subHeadings.get(i).getText();
			Assert.assertEquals(SubHeadingsText, implementationPane_Headings[i], "The Sub heading"
					+ implementationPane_Headings[i] + " is not displayed in Implementation Plan  Frame");

		}
	}

	/**
	 * Clicks Review link in Implentation Plan section
	 * 
	 * @return
	 */
	public ImplementationCardsPage clickReviewinImplementationPlan() {

		safeClick(REVIEW_LINKS);
		waitForSecs(10);

		return new ImplementationCardsPage(driver);
	}

	/**
	 * Verify Training stats section in Pre-Implementation & Launch frame
	 */
	public void verifyTrainingStats() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isElementPresent(TEACHERTRAINING_SUBHEADING, VERYLONGWAIT);
		String text = safeGetText(TEACHERTRAINING_SUBHEADING, VERYLONGWAIT);
		Assert.assertEquals(text, "Teacher Training",
				"Teacher Training sub heading is not Displayed in Training Stats Frame");
		boolean breviewlinkexists = isElementClickable(Dynamic.getNewLocator(REVIEW_LINKS, "1"));
		Assert.assertTrue(breviewlinkexists, "Review Link doesn't present in Traning stats Frame");
	}

	/*
	 * verifies Need Help frame in Dash board
	 */
	public void verifyNeedHelp() {
		waitForSecs(5);
		isElementDisplayed(Dynamic.getNewLocator(SUPPORTMOBILE_NUMBER, "1"));
		String txt = safeGetText(Dynamic.getNewLocator(SUPPORTMOBILE_NUMBER, "1"), VERYLONGWAIT);
		Assert.assertTrue(txt.contains("Call 800.547.6747"), "Support Mobile number is not displayed in Need's help frame");
		Assert.assertEquals(safeGetText(Dynamic.getNewLocator(SUPPORTMOBILE_NUMBER, "2"), MEDIUMWAIT),
				"8:30 AM - 5:30 PM Central", "Support time  is not displayed in Need's help frame");
		txt = safeGetText(EMAILSUPPORT_LINK, MEDIUMWAIT);
		Assert.assertEquals(txt, "E-mail Support", "Email support link  is not displayed in Need's help frame");
		nullifyImplicitWait();
	}

	/**
	 * Verifies Start up frame in Dash board
	 */
	public void verifyStartUpFrame() {

		waitForSecs(5);
		isElementPresent(STUDENTS_SUBHEADING, LONGWAIT);
		boolean bStudentsSubHeadingPresent = isElementPresent(STUDENTS_SUBHEADING, LONGWAIT);
		Assert.assertTrue(bStudentsSubHeadingPresent, "Students Sub heading is not present in  Startup frame");
		boolean bTeachersSubHeadingPresent = isElementPresent(TEACHERS_SUBHEADING, LONGWAIT);
		Assert.assertTrue(bTeachersSubHeadingPresent, "Teachers Sub heading is not present in  Startup frame");

	}

	/**
	 * To clicks on View Student StartUp Detail Report link in Start up frame
	 */
	public StartupReportspage clickViewStudentStartUpDetailReport() {
		safeClick(STUDENTSTARTUPREPORT_LINK, VERYLONGWAIT);
		if(sys.getProperty("CurrentlyRunningBrowserName").equalsIgnoreCase("chrome"))
			refresh();
		return new StartupReportspage(driver);

	}

	/**
	 * To clicks on View teachers StartUp Detail Report link in Start up frame
	 */
	public StartupReportspage clickViewTeacherStartUpDetailReport() {
		refresh();
		safeClick(TEACHERSTARTUPREPORT_LINK, VERYLONGWAIT);
		return new StartupReportspage(driver);
	}

	/**
	 * Verifies Technology frame in Dash board
	 */
	public void verifyTechnologyframe() {
		waitForPageToLoad();
		String supporttickets = safeGetText(Dynamic.getNewLocator(TECHNOLOGY_SUBHEADINGS, "1"), LONGWAIT);
		Assert.assertEquals(supporttickets, "SUPPORT TICKETS",
				"Support Tickets sub heading is not displayed in Technology frame");
		String releaseNotes = safeGetText(Dynamic.getNewLocator(TECHNOLOGY_SUBHEADINGS, "2"), LONGWAIT);
		Assert.assertEquals(releaseNotes, "RELEASE NOTES",
				"Release Notes	 sub heading is not displayed in Technology frame");
	}

	/**
	 * clicks on Learn link in technology frame
	 */
	public void clickLearnLink() 
	{
		waitForPageToLoad();
		refresh();
		waitForSecs(10,"Waiting to Learn Link");
		isElementClickable(LEARN_LINK, LONGWAIT);
		safeJavaScriptClick(LEARN_LINK, MEDIUMWAIT);
	}

	/**
	 * verifies learn link is opened or not
	 */
	public void verifyLearnLink() 
	{
		waitForPageToLoad();
		waitForSecs(10,"Waiting for technology dialogbox");
		isElementPresent(TECHNOLOGYISSUESDIALOGBOX_HEADING);
		String technologyIssues_Heading = safeGetText(TECHNOLOGYISSUESDIALOGBOX_HEADING, LONGWAIT);
		Assert.assertEquals(technologyIssues_Heading, "Technology Issues",
				"Technology Issues dialog is not opened on clicking 'Learn' link in Technology Frame");

	}

	/**
	 * closes technology issues dialog
	 * 
	 * @param imagePath
	 */
	public void closeTechnologyIssuesDialog()

	{
		refresh();
	}

	/**
	 * verifies course progress performance frame in dashboard
	 */
	public void verifyCourseProgressPerformance() {
		refresh();
		waitForPageToLoad();
		String txt = safeGetText(Dynamic.getNewLocator(COURSEPROGRESSPERFORMANCE_SUBHEADINGS, "1"), LONGWAIT);
		Assert.assertEquals(txt, "On Pace",
				"'On Pace' sub heading is not displayed in Course Progress& performance Frame");

		txt = safeGetText(Dynamic.getNewLocator(COURSEPROGRESSPERFORMANCE_SUBHEADINGS, "2"), LONGWAIT);
		Assert.assertEquals(txt, "Word Training Performance",
				" Word Training Performance sub heading is not displayed in Course Progress& performance Frame");

		txt = safeGetText(Dynamic.getNewLocator(COURSEPROGRESSPERFORMANCE_SUBHEADINGS, "3"), LONGWAIT);
		Assert.assertEquals(txt, "Text Training Performance",
				" Text Training Performance sub heading is not displayed in Course Progress& performance Frame");
		refresh();

	}

	/**
	 * clicks on word training link in course progress performance frame
	 */
	public void clickWordTrainingLinkandGetPacePercentage() {
		boolean bWordTrainingLinkExists = isElementClickable(Dynamic.getNewLocator(ONPACE_LINKS, "Word Training"));
		Assert.assertTrue(bWordTrainingLinkExists,
				"Word Training link doesn't exists in Course Progress & Performance frame");
		WordTrainingpacePercentageinHome = safeGetText(Dynamic.getNewLocator(ONPACE_SCORE, "Word Training"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(ONPACE_LINKS, "Word Training"));

	}

	/**
	 * To verify schools on pace percentage in Course Progress->Word Training
	 * Pacing by School dilaog
	 */
	public void verifyWordTrainingDialogandSchoolsPacePercentage() {
		waitForPageToLoad();
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGPRIMARY_HEADING, VERYLONGWAIT),
				"Course Progress", "The heading 'Course Progress' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING, VERYLONGWAIT),
				"Word Training Pacing by School",
				"The heading 'Word Training Pacing by School' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(SCHOOLSANDCLASSESSUBTAB_HEADING, VERYLONGWAIT),
				"Schools on Pace in Word Training", "The Schools sub tab heading doesn't Matched");
		// verify pace percentage in Schools tab
		String pacePercentageinDialog = safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE, LONGWAIT);
		Assert.assertEquals(pacePercentageinDialog, WordTrainingpacePercentageinHome,
				"The Pace percentage in Home page->On pace pane  and percentage in Course progress->Schools dialog doesn't matched");
	}

	/**
	 * Clicks on classes tab in 'Course Progress › Word Training Pacing by
	 * School ' dialog
	 */
	public void clickClassesSubTab() {

		safeClick(CLASSES_SUBHEADING);

	}

	/**
	 * To verify classes on pace percentage in 'Course Progress->Word Training
	 * Pacing by Class' dialog
	 */
	public void verifyWordTrainingDialogandClassesPacePercentage() {
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING, VERYLONGWAIT),
				"Word Training Pacing by Class",
				"The heading 'Word Training Pacing by Class' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(SCHOOLSANDCLASSESSUBTAB_HEADING, VERYLONGWAIT),
				"Classes on Pace in Word Training", "The Schools sub tab heading doesn't Matched");
		// verify pace percentage in Schools tab
		String pacePercentageinDialog = safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE, LONGWAIT);
		Assert.assertEquals(pacePercentageinDialog, WordTrainingpacePercentageinHome,
				"The Pace percentage in Home page->On pace pane  and percentage in Course progress->Classes dialog doesn't matched");
	}

	public void closeCourseProgressDialog() {
		safeClick(COURSEPROGRESSANDPERFORMANCE_CLOSE);
	}

	/**
	 * clicks on Text training link in course progress performance frame
	 */
	public void clickTextTrainingLinkandGetPacePercentage() {
		boolean bTextTrainingLinkExists = isElementClickable(Dynamic.getNewLocator(ONPACE_LINKS, "Text Training"));
		Assert.assertTrue(bTextTrainingLinkExists,
				"Text Training link doesn't exists in Course Progress & Performance frame");
		textTrainingpacePercentageinHome = safeGetText(Dynamic.getNewLocator(ONPACE_SCORE, "Text Training"), LONGWAIT);
		safeClick(Dynamic.getNewLocator(ONPACE_LINKS, "Text Training"));

	}

	/**
	 * To verify schools on pace percentage in Course Progress->Text Training
	 * Pacing by School dialog
	 */
	public void verifyTextTrainingDialogandSchoolsPacePercentage() {
		waitForPageToLoad();
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGPRIMARY_HEADING, VERYLONGWAIT),
				"Course Progress", "The heading 'Course Progress' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING, VERYLONGWAIT),
				"Text Training Pacing by School",
				"The heading 'Text Training Pacing by School' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(SCHOOLSANDCLASSESSUBTAB_HEADING, VERYLONGWAIT),
				"Schools on Pace in Text Training", "The Schools sub tab heading doesn't Matched");
		// verify pace percentage in Schools tab
		String pacePercentageinDialog = safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE, LONGWAIT);
		Assert.assertEquals(pacePercentageinDialog, textTrainingpacePercentageinHome,
				"The Pace percentage in Home page->On pace pane  and percentage in Course progress->Schools dialog doesn't matched");
	}

	/**
	 * To verify classes on pace percentage in 'Course Progress->text Training
	 * Pacing by Class' dialog
	 */
	public void verifyTextTrainingDialogandClassesPacePercentage() {
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING, VERYLONGWAIT),
				"Text Training Pacing by Class",
				"The heading 'Text Training Pacing by Class' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(SCHOOLSANDCLASSESSUBTAB_HEADING, VERYLONGWAIT),
				"Classes on Pace in Text Training", "The Schools sub tab heading doesn't Matched");
		// verify pace percentage in Schools tab
		String pacePercentageinDialog = safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE, LONGWAIT);
		Assert.assertEquals(pacePercentageinDialog, textTrainingpacePercentageinHome,
				"The Pace percentage in Home page->On pace pane  and percentage in Course progress->Classes dialog doesn't matched");
	}

	/**
	 * Gets Lesson L1 score in Word Training Performance pane in Course Progress
	 * & Performance frame and clicks on ti
	 */
	public String getScoreofL1LessoninWordTrainingPerformaceandClick() {
		String score1 = safeGetText(
				Dynamic.getNewLocator(WORDANDTEXTTRAININGPERFORMANCE_SCORES, new String[] { "Lessons", "L1" }),
				LONGWAIT);
		safeClick(Dynamic.getNewLocator(WORDANDTEXTTRAININGPERFORMANCE_LINKS, new String[] { "Lessons", "L1" }),
				LONGWAIT);
		return score1;
	}

	/**
	 * To verify school score in Word Training Lesson Scores By School dialog
	 */
	public void verifyWordTrainingLesssonDialogandSchoolsScores(String schoolName,String score1) {
		waitForPageToLoad();
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGPRIMARY_HEADING, VERYLONGWAIT),
				"Course Performance", "The heading 'Course Performance' is not displayed in Course Performance dialog");
		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING, VERYLONGWAIT),
				"Word Training Lesson Scores By School",
				"The heading 'Word Training Lesson Scores By School' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(SCHOOLSANDCLASSESSUBTAB_HEADING, VERYLONGWAIT),
				"Distribution of Scores in Word Training Lessons", "The Schools sub tab heading doesn't Matched");
		// verify pace percentage in Schools tab
		String scoreinSchoolsTab = safeGetText(
				Dynamic.getNewLocator(COURSEPROGRESSANDPERFORMACEDIALOGSCHOOLS_PERCENTAGE, schoolName), LONGWAIT);
		Assert.assertEquals(score1, scoreinSchoolsTab,
				"The Score  in Home page->Lesson L1 pane  and percentage in Course performace->Schools dialog doesn't matched");
	}

	/**
	 * To verify classes score in Word Training Lesson Scores By School dialog
	 */
	public void verifyWordTrainingLessonDialogandClassesScore(String className,String score1) {

		Assert.assertEquals(safeGetText(COURSEPROGRESSANDPERFORMACEDIALOGSECONDARY_HEADING, VERYLONGWAIT),
				"Word Training Lesson Scores by Class",
				"The heading 'Word Training Lesson Scores by Class' is not displayed in Course Progres dialog");
		Assert.assertEquals(safeGetText(SCHOOLSANDCLASSESSUBTAB_HEADING, VERYLONGWAIT),
				"Distribution of Scores in Word Training Lessons", "The Classes sub tab heading doesn't Matched");
		// verify pace percentage in Schools tab
	/*	String scoreinclasstab1 = safeGetText(
				Dynamic.getNewLocator(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE, className), LONGWAIT);
		log.info(scoreinclasstab1);
		scrollIntoElementView(Dynamic.getNewLocator(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE, className));*/
		
		double total=0;
		List<WebElement> all_Progress_values = LocatorWebElements(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE_ALL);
		log.info("all_Progress_values.size()"+all_Progress_values.size());
		for(int i = 1; i<=all_Progress_values.size();i++)
		{
			scrollIntoElementView(Dynamic.getNewLocator(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE_INDIVIDUAL, String.valueOf(i)));
			String scoreinclasstab = safeGetText(
					Dynamic.getNewLocator(COURSEPROGRESSANDPERFORMACEDIALOGCLASSES_PERCENTAGE_INDIVIDUAL, String.valueOf(i)), LONGWAIT);
			scoreinclasstab = scoreinclasstab.replace("%", "");
			total += Integer.parseInt(scoreinclasstab);
			log.info("scoreinclasstab+"+ i +"+="+scoreinclasstab);
			log.info("total = "+total);
		}
		String AVG = String.valueOf((double)(total/all_Progress_values.size()))+"%";
		log.info("AVG = "+AVG);
		refresh();
		waitForPageToLoad();
		waitForSecs(7);
		Assert.assertEquals(score1, AVG,
				"The Score  in Home page->Lesson L1 pane  and percentage in Course performace->classes dialog doesn't matched");
	}

	public void closeCoursePerformancedialog() {
		refresh();
	}

	/**
	 * To verify PAR, To SCRF and TWS-4 score in Benchmark testing frame
	 * ->Matched score tab
	 * 
	 * @param MatchedScores
	 */
	public void verifyBenchMarkTestingMatchedScore(String[] matchedScores)

	{
		waitForSecs(3, "Waiting for dashboard to load completely");
		refresh();
		isElementPresent(BECHAMRKTESTING_SUBHEADINGS, VERYLONGWAIT);
		isElementDisplayed(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "1"));
		waitForSecs(5);
		if (!matchedScores[0].equalsIgnoreCase(" ")) 
		{
			//setHighlight(driver.findElement(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "1")));
			//waitForSecs(100, "wait fo elementd to load");
			//isElementDisplayed(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "1"));
			//scrollIntoElementView(By.xpath("//*[@class='Cambium.App.Dashboards.District2.BenchmarkTesting.tbl1']"));
			String B1PARScore = safeGetText(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "1"), VERYLONGWAIT);
			Assert.assertEquals(B1PARScore, matchedScores[0] + "L",
					"MAtched Scores->B1 PAR score is not matched in Matched Scores tab");
		}
		if (!matchedScores[1].equalsIgnoreCase(" ")) {
			String B1TOSCRFSCORE = safeGetText(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "4"),
					VERYLONGWAIT);
			Assert.assertEquals(B1TOSCRFSCORE, matchedScores[1],
					"MAtched Scores->B1 TOSCRF score is not matched in matched scores tab");
		}
		if (!matchedScores[2].equalsIgnoreCase(" ")) {
			String B1TWS4SCORE = safeGetText(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "7"), VERYLONGWAIT);
			Assert.assertEquals(B1TWS4SCORE, matchedScores[2],
					"MAtched Scores->B1 TTWS 4 score is not matched in matched scores tab");
		}
	}

	public void clickUnmatchedScorestabinBenchmarkTesting() {
		safeClick(UNMATCHEDSCORES_TAB);

	}

	/**
	 * To verify PAR, To SCRF and TWS-4 score in Benchmark testing frame
	 * ->UnMatched score tab
	 * 
	 * @param unMatchedScores
	 */
	public void verifyBenchMarkTestingUnMatchedScore(String[] unMatchedScores)

	{

		waitForPageToLoad();
		isElementPresent(BECHAMRKTESTING_SUBHEADINGS, VERYLONGWAIT);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isElementDisplayed(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "1"));
		if (!unMatchedScores[0].equalsIgnoreCase(" ")) {
			String B1PARScore = safeGetText(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "1"), VERYLONGWAIT);
			Assert.assertEquals(B1PARScore, unMatchedScores[0] + "L",
					"Matched Scores->B1 PAR score is not matched in Matched Scores tab");
		}
		if (!unMatchedScores[0].equalsIgnoreCase(" ")) {
			String B1TOSCRFSCORE = safeGetText(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "4"),
					VERYLONGWAIT);
			Assert.assertEquals(B1TOSCRFSCORE, unMatchedScores[1],
					"Matched Scores->B1 TOSCRF score is not matched in matched scores tab");
		}
		if (!unMatchedScores[0].equalsIgnoreCase(" ")) {
			String B1TWS4SCORE = safeGetText(Dynamic.getNewLocator(SCORESINBENCHMARKTESTING_GRAPH, "7"), VERYLONGWAIT);
			Assert.assertEquals(B1TWS4SCORE, unMatchedScores[2],
					"Matched Scores->B1 TTWS 4 score is not matched in matched scores tab");
		}

	}

	/**
	 * Reads Teacher data in Dashboard-> Start up frame
	 * 
	 * @return Map
	 */
	public Map<String, String> readTeachersdatainStartUpFrame() {
		Map<String, String> map = new HashMap<String, String>();
		List<WebElement> teachersRowNames = LocatorWebElements(TEACHERSROWSNAMESINSTARTUP_ROWS);
		List<WebElement> teachersRowValues = LocatorWebElements(TEACHERSROWSVALUESINSTARTUP_ROWS);
		for (int i = 0; i < teachersRowNames.size(); i++) {
			map.put(teachersRowNames.get(i).getText().toUpperCase(), teachersRowValues.get(i).getText());
		}
		return map;

	}

	/**
	 * Reads Teacher data in Dashboard-> Start up frame
	 * 
	 * @return Map
	 */
	public String[] readStudentsdatainStartUpFrame() {

		List<WebElement> StundentsRowNames = LocatorWebElements(STUDENTSROWSNAMESINSTARTUP_ROWS);
		List<WebElement> StudentsRowValues = LocatorWebElements(STUDENTSROWSVALUESINSTARTUP_ROWS);
		String[] values = new String[StudentsRowValues.size()];
		for (int i = 0; i < StudentsRowValues.size(); i++) {
			values[i] = StudentsRowValues.get(i).getText();
		}

		return values;
	}

	public TeacherViewProfileAboutMePage navigateToViewProfile() 
	{
		waitForSecs(8, "Waiting User Dropdown to load");
		isElementPresent(USER_DROPDOWN, LONGWAIT);
		safeActionsClick(USER_DROPDOWN, LONGWAIT);
		safeActionsClick(VIEWPROFILE_LINK, MEDIUMWAIT);
		return new TeacherViewProfileAboutMePage(driver);
	}

}

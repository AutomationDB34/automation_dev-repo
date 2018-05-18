package com.page.module.vport;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;

import com.page.locators.vport.DistrictTrackContactsLocators;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;
import com.utilities.UtilityMethods;

public class DistrictTrackContactsPage extends CommonFunctionalitiesVPort implements DistrictTrackContactsLocators {

	private WebDriver driver;

	public DistrictTrackContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	/**
	 * Purpose- To verify Contacts page under 'Districts/Tracks' heading
	 * 
	 */
	public void verifyDistrictTrackContactsPage(String trackName) {
		//waitForSecs(10);
		waitForPageToLoad();
		boolean bIsTrackNameDisplayed = isElementDisplayed(Dynamic.getNewLocator(TRACKNAME_HEADING, trackName));
		Assert.assertTrue(bIsTrackNameDisplayed, "Track name is not displayed on Contacts page");
	}

	/**
	 * Purpose- To navigate to 'School tracks' page and returns DistrictTrackSchoolTracksPage
	 * 
	 */
	public DistrictTrackSchoolTracksPage clickSchoolTrackstab() {
		safeClick(SCHOOLTRACKS_TAB);
		return new DistrictTrackSchoolTracksPage(driver);
	}

	/**
	 * Purpose- To click on Materials tab
	 * @return 
	 */
	public DistrictTrackMaterialsPage clickMaterialsTab()
	{
		safeClick(MATERIALS_TAB, LONGWAIT);
		waitForPageToLoad(LONGWAIT);
		return new DistrictTrackMaterialsPage(driver);


	}

	/**
	 * Click On IPT Tab
	 */
	public void clickOnIPTTab() 
	{
		safeClick(IPT_LINK, MEDIUMWAIT);
	}

	/**
	 * To click on Technology
	 */
	public void clickOnTechnologyTab() {
		safeClick(TECHNOLOGY_TAB, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Verify the Cutomer InterFace
	 */
	public void verifyCustomerInterface()
	{
		Assert.assertTrue(isElementPresent(CUSTOMER_INTERFACE, MEDIUMWAIT),"Cutomer interface is not loaded");
		setHighlight(driver.findElement(CUSTOMER_INTERFACE));
	}
	/**
	 * Verify the radio buttons for three scores
	 */
	public void verifyTheRadioButtons() 
	{
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(BENCHMARK_SCORE_RADIO,"1"), MEDIUMWAIT),"Bencha Marks On button Not Available");
		setHighlight(driver.findElement(Dynamic.getNewLocator(BENCHMARK_SCORE_RADIO,"1")));
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(BENCHMARK_SCORE_RADIO,"2"), MEDIUMWAIT),"Bencha Marks Off button Not Available");
		setHighlight(driver.findElement(Dynamic.getNewLocator(BENCHMARK_SCORE_RADIO,"2")));
		
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(MANAGE_ROASTER_RADIO,"1"), MEDIUMWAIT),"Manage Roster On button Not Available");
		setHighlight(driver.findElement(Dynamic.getNewLocator(MANAGE_ROASTER_RADIO,"1")));
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(MANAGE_ROASTER_RADIO,"2"), MEDIUMWAIT),"Manage Roster OFF button Not Available");
		setHighlight(driver.findElement(Dynamic.getNewLocator(MANAGE_ROASTER_RADIO,"2")));
		
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(PROGRESS_MONITORING_RADIO,"1"), MEDIUMWAIT),"Progress Monitor On button Not Available");
		setHighlight(driver.findElement(Dynamic.getNewLocator(PROGRESS_MONITORING_RADIO,"1")));
		Assert.assertTrue(isElementPresent(Dynamic.getNewLocator(PROGRESS_MONITORING_RADIO,"2"), MEDIUMWAIT),"Progress Monitor Off button Not Available");
		setHighlight(driver.findElement(Dynamic.getNewLocator(PROGRESS_MONITORING_RADIO,"2")));
	}

	/**
	 * Verify the Save Changes Button
	 */
	public void verifyTheSaveChangesButton()
	{
		Assert.assertTrue(isElementPresent(SAVECHANGES_BUTTON, MEDIUMWAIT),"Select Boxes not Available there is No Assessment plans are added");
		setHighlight(driver.findElement(SAVECHANGES_BUTTON));
	}

	/**
	 * Verify the Assessment plans
	 */
	public void verifyTheAssessmentsplansSelectOptions() 
	{
		Assert.assertTrue(isElementPresent(SELECT_BOXES, MEDIUMWAIT),"Select Boxes not Available there is No Assessment plans are added");
		setHighlight(driver.findElement(SELECT_BOXES));
	}

	/**
	 * To click on the Adminstration Link
	 */
	public void clickOnAdministrationLink() 
	{
		safeClick(ADMINISTRATION_LINK,MEDIUMWAIT);
		waitForPageToLoad();
		
	}
	
	/**
	 * click on Assessment plans tab
	 */
	public void clickOnAssessmentPlansTab() 
	{
		safeClick(ASSESSMENT_PLANS_TAB, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Click on Add Assessment Plan button
	 */
	public void clickOnAddAssessmentPlanButton() {
		safeClick(ADD_ASSESSMENT_PLAN_BUTTON, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/** 
	 * Enter Dummy Assessment plan Name
	 * @param dummyAssessmentPlanName
	 */
	public String enterPlanName(String dummyAssessmentPlanName) {
		String dynamicName = dummyAssessmentPlanName+UtilityMethods.get4DRandomNumber();
		safeType(ASSESSMENT_PLAN_NAME_TEXT, dynamicName, MEDIUMWAIT);
		waitForPageToLoad();
		return dynamicName;
	}

	/**
	 * Select Grade 
	 * @param string
	 */
	public void selectGradeLevel(int index) {
		safeSelectOptionInDropDownByIndexValue(SELECT_GRADE, index, MEDIUMWAIT);
		waitForSecs(2);
	}

	/**
	 * to make the assessment plan active
	 */
	public void clickOnActiveCheckBox() 
	{
		safeClick(ACTIVE_CHECK_BOX, MEDIUMWAIT);
	}

	/**
	 * Select edition to 
	 * @param i
	 */
	public void selectEdition(int index) {
		safeSelectOptionInDropDownByIndexValue(SELECT_EDITION, index, MEDIUMWAIT);
		waitForSecs(1);
	}

	/**
	 * Click on Add profile
	 */
	public void clickOnAddProfileButton() 
	{
		safeClick(ADD_PROFILE_BUTTON, MEDIUMWAIT);
		waitForSecs(1);
	}

	/**
	 * To enter the Profile Sequence
	 * @param profileSequence
	 */
	public void enterAssessmentPlanSequence(String profileSequence) 
	{
		safeType(PROFILE_SEQUENCE_NUMBER_TEXT, profileSequence, MEDIUMWAIT);
		
	}

	/**
	 * Enter Data PM count
	 * @param string
	 */
	public void enterPmCount(String string) {
		safeType(PM_COUNT_TEXT, string, MEDIUMWAIT);
		
	}

	/**
	 * EnterMinimum score
	 * @param string
	 */
	public void enterMinimumScore(String string) {
		safeType(MINIMUM_SCORE_TEXT, string, MEDIUMWAIT);
		
	}

	/**
	 * Entermaximum score
	 * @param string
	 */
	public void enterMaximumScore(String string) {
		safeType(MAXIMUM_SCORE_TEXT, string, MEDIUMWAIT);
		
	}

	/**
	 * Click On Save
	 */
	public void clickOnSaveAndContinue() {
		safeClick(SAVE_CONTINUE_BUTTON, MEDIUMWAIT);
		waitForPageToLoad();
		
	}

	/**
	 * Click on Update Button
	 */
	public void ClickOnUpdateButton() {
		safeClick(UPDATE_BUTTON, MEDIUMWAIT);
		waitForPageToLoad();
		
	}

	/**
	 * Verify the Saved Button
	 * @param assessMentPlanName
	 */
	public void verifyTheAddedAssessMentPlan(String assessMentPlanName) 
	{
		waitForSecs(2);
		boolean assessmentPrasence = isElementPresent(
				Dynamic.getNewLocator(SAVED_ASSESSMENT_PLAN_NAME, assessMentPlanName), MEDIUMWAIT);
		Assert.assertTrue(assessmentPrasence,"Assessment Not Saved Successfully");
		scrollIntoElementView(Dynamic.getNewLocator(SAVED_ASSESSMENT_PLAN_NAME, assessMentPlanName));
		setHighlight(driver.findElement(Dynamic.getNewLocator(SAVED_ASSESSMENT_PLAN_NAME, assessMentPlanName)));
		
	}

	/**
	 * Navigate to Technology 
	 * @param trackName
	 */
	public VportTrackFilterPage clickOnDistrictTracksTab() 
	{
		safeClick(DISTRICTS_TRACKS_LINK, MEDIUMWAIT);		
		return new VportTrackFilterPage(driver);
	}

	/**
	 * Click add row to add assessment plan
	 */
	public void clickOnAddRow() 
	{
		safeClick(ADD_ROW, MEDIUMWAIT);
		waitForPageToLoad();
	}

	/**
	 * Select the created Plan
	 * @param newPlanName
	 */
	public void selectCreatedAssessmentPlan(String newPlanName) 
	{
		safeSelectOptionInDropDownByVisibleText(SELECTED_ASSESSMENT_PLAN, newPlanName, MEDIUMWAIT);
		waitForSecs(1);
		
	}

	/**
	 * Click On save Changes
	 */
	public void clickOnSaveChangesInTechnologyTab() 
	{
		safeClick(SAVECHANGES_BUTTON, MEDIUMWAIT);
		waitForPageToLoad();
		
	}

	/**
	 * Verify the Saved Plan
	 * @param newPlanName
	 */
	public void verifySavedAssessmentPlan(String newPlanName) 
	{
		waitForPageToLoad();
		waitForSecs(4);
		boolean savedSucessfully = isElementPresent(
				Dynamic.getNewLocator(SAVED_ASSESSMENT_PLAN_IN_TECHNOLOGY_TAB,newPlanName), MEDIUMWAIT);
		Assert.assertTrue(savedSucessfully,"Assessment Plan not saved successfully");
		setHighlight(driver.findElement(Dynamic.getNewLocator(SAVED_ASSESSMENT_PLAN_IN_TECHNOLOGY_TAB,newPlanName)));
	}
	
	
}

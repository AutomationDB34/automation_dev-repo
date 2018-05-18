package com.page.module.ll.teacherrole;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.page.locators.ll.teacherrole.TeacherRoleCoursePageLocators;
import com.page.module.ll.level1activities.CommonFunctionalities;
import com.selenium.SafeActions;
import com.testng.Assert;

public class TeacherRoleCoursePage extends CommonFunctionalities implements TeacherRoleCoursePageLocators{

	private WebDriver driver;
	
	public TeacherRoleCoursePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/**
	 * Purpose- To verify that course page is loaded successfully
	 */
	
	public void verifyThatCoursePageIsLoaded()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(COURSETAB_SELECTED, LONGWAIT), "Course tab is not displayed as highlighted even after clicking on it");
		Assert.assertTrue(isElementPresent(COURSETAB_SECTION, LONGWAIT), "Course page content is not loaded");
	}
	
	/**
	 * Purpose - To click on Level1 option
	 */
	
	public void clickOnLevelOneOption()
	{
		nullifyImplicitWait();
		int levelOneLocatorCount = getLocatorCount(COURSE_LEVELONE_SELECTED);
		if(levelOneLocatorCount==0)
		{	
		setImplicitWait(IMPLICITWAIT);
		safeClick(COURSE_LEVELONE_TAB, LONGWAIT);
		}
	}
	
	/**
	 * Purpose - To click on Level2 option
	 */
	
	public void clickOnLevelTwoOption()
	{
		nullifyImplicitWait();
		int levelOneLocatorCount = getLocatorCount(COURSE_LEVELTWO_SELECTED);		
		if(levelOneLocatorCount==0)
		{	
		setImplicitWait(IMPLICITWAIT);
		safeClick(COURSE_LEVELTWO_TAB, LONGWAIT);
		}
	}
	
	/**
	 * Purpose - To navigate to Word Training tab
	 */
	public void navigateToWordTrainingTab() {
		safeClick(COURSE_WT_TAB, LONGWAIT);	
		
	}
	
	/**
	 * Purpose - To navigate to Text Training tab
	 */
	
	public void navigateToTextTrainingTab()
	{
		safeClick(COURSE_TT_TAB, LONGWAIT);		
	}
	
	/**
	 * Purpose- To verify that text training content is loaded for Level 1
	 */
	
	public void verifyThatTextTrainingTabIsLoadedForLevel1()
	{
		waitForPageToLoad();
		setImplicitWait(LONGWAIT);
		Assert.assertTrue(isElementPresent(COURSE_TT_TAB_SELECTED, LONGWAIT),"Text Training tab under Course page is not highlighted even afer clicking on it");
		Assert.assertTrue(isElementPresent(COURSE_TTTAB_LEVEL1_SECTION, LONGWAIT),"Text Training tab under Course page is not loaded");
		nullifyImplicitWait();
	}
	/**
	 * Purpose- To verify that text training content is loaded for Level 2
	 */
	public void verifyThatTextTrainingTabIsLoadedForLevel2()
	{
		waitForPageToLoad();
		setImplicitWait(LONGWAIT);
		Assert.assertTrue(isElementPresent(COURSE_TT_TAB_SELECTED, LONGWAIT),"Text Training tab under Course page is not highlighted even afer clicking on it");
		Assert.assertTrue(isElementPresent(COURSE_TTTAB_LEVEL2_SECTION, LONGWAIT),"Text Training tab under Course page is not loaded");
		nullifyImplicitWait();
	}
	
	
	/**
	 * Purpose- To verify that word training content is loaded for Level 1
	 */
	
	public void verifyThatWordTrainingTabIsLoadedForLevel1()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(COURSE_WT_TAB_SELECTED, LONGWAIT),"word Training tab under Course page is not highlighted even afer navigating to Course page");
		Assert.assertTrue(isElementPresent(COURSE_WTTAB_LEVEL1_SECTION, LONGWAIT),"Word Training tab under Course page is not loaded");
	}
	
	/**
	 * Purpose- To verify that word training content is loaded for Level 2
	 */
	
	public void verifyThatWordTrainingTabIsLoadedForLevel2()
	{
		waitForPageToLoad();
		Assert.assertTrue(isElementPresent(COURSE_WT_TAB_SELECTED, LONGWAIT),"word Training tab under Course page is not highlighted even afer navigating to Course page");
		Assert.assertTrue(isElementPresent(COURSE_WTTAB_LEVEL2_SECTION, LONGWAIT),"Word Training tab under Course page is not loaded");
	}
	
	
	
	/**
	 * Purpose -- To Read an activity named 'Sort (Nouns and Verbs)' under text training tab in Level1 
	 * @param  courseTTSortNounsAndVerbsDroppingAreaImage, isIEBrowser
	 * @throws AWTException 
	 */
	
	public void completeTTActivityAndVerifySummaryMessageForLevel1(String courseTTSortNounsAndVerbsDroppingAreaImage,boolean isIEBrowser)
	{
		nullifyImplicitWait();
		int unitOneLocatorCount = getLocatorCount(UNITONE_BTN_SELECTED);		
		if(unitOneLocatorCount==0)
		{	
		setImplicitWait(IMPLICITWAIT);
		safeClick(UNITONE_BTN, LONGWAIT);
		}
		Assert.assertTrue(isElementPresent(COURSE_TTTAB_LEVEL1_SECTION, LONGWAIT),"Text Training tab content under Course page is not loaded after clicking on the unit 1 tab");
		safeClick(COURSE_TT_LEVEL1_ACTIVITY, LONGWAIT);		
		Assert.assertTrue(isElementPresent(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT), "Text Training activity instructions tooltip is not displayed");		
		safeClick(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT);
		Assert.assertTrue(isElementPresent(NUMBEROFDOTS_AREA, LONGWAIT), "Text Training activity content is not loaded(number of dots section)");
		int totalNumberOfDotsDisplayed = getLocatorCount(NUMBEROFDOTS_COUNT);
		if(isIEBrowser)
		{
			safeClickUsingSikuli(courseTTSortNounsAndVerbsDroppingAreaImage, "clicking on Noun Area section of the Course->Text training activity 'Sort Nouns And Verbs' using sikuli", LONGWAIT);
		}
		for(int i=1;i<=totalNumberOfDotsDisplayed;i++)
		{
			if(i<totalNumberOfDotsDisplayed)
			{
				dragAndDrop(OPTION_TOBE_DRAGGED, NOUN_SECTION_AREA_TO_DROP_WORD, LONGWAIT);
				Assert.assertTrue(isElementPresent(VOLUME_GREEN_ICON, LONGWAIT), "Draggable word option is not loaded properly");
			}
			else
			{
				dragAndDrop(OPTION_TOBE_DRAGGED, NOUN_SECTION_AREA_TO_DROP_WORD, LONGWAIT);
			}
		}
		
		Assert.assertTrue(isElementPresent(SUMMARY_MESSAGE, LONGWAIT), "The summary message 'Summary pages only display student data' is not being displayed after completion of the text training activity named  'Sort (Nouns and Verbs)'");
		
		safeClick(SUMMARY_CONTINUE_BTN, LONGWAIT);
		
		waitForPageToLoad();
		
		Assert.assertTrue(isElementPresent(COURSETAB_SECTION, LONGWAIT), "User is not taken to course page after completion of the text training activity 'Sort (Nouns and Verbs)'");
	}
	
	
	/**
	 * Purpose -- To Read an activity named 'Sort (Nouns and Verbs)' under text training tab in Level 2
	 * @param  courseTTSortNounsAndVerbsDroppingAreaImage, isIEBrowser
	 * @throws AWTException 
	 */
	
	public void completeTTActivityAndVerifySummaryMessageForLevel2(String courseTTSortNounsAndVerbsDroppingAreaImage,boolean isIEBrowser)
	{
		nullifyImplicitWait();
		int unitOneLocatorCount = getLocatorCount(UNITONE_BTN_SELECTED);		
		if(unitOneLocatorCount==0)
		{	
		setImplicitWait(IMPLICITWAIT);
		safeClick(UNITONE_BTN, LONGWAIT);
		}
		Assert.assertTrue(isElementPresent(COURSE_TTTAB_LEVEL2_SECTION, LONGWAIT),"Text Training tab content under Course page is not loaded after clicking on the unit 1 tab");
		safeClick(COURSE_TT_LEVEL2_ACTIVITY, LONGWAIT);		
		Assert.assertTrue(isElementPresent(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT), "Text Training activity instructions tooltip is not displayed");		
		safeClick(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT);
		Assert.assertTrue(isElementPresent(NUMBEROFDOTS_AREA, LONGWAIT), "Text Training activity content is not loaded(number of dots section)");
		int totalNumberOfDotsDisplayed = getLocatorCount(NUMBEROFDOTS_COUNT);
		if(isIEBrowser)
		{
			safeClickUsingSikuli(courseTTSortNounsAndVerbsDroppingAreaImage, "clicking on Noun Area section of the Course->Text training activity 'Sort Nouns And Verbs' using sikuli", LONGWAIT);
		}
		for(int i=1;i<=totalNumberOfDotsDisplayed;i++)
		{
			if(i<totalNumberOfDotsDisplayed)
			{
				dragAndDrop(OPTION_TOBE_DRAGGED, NOUN_SECTION_AREA_TO_DROP_WORD, LONGWAIT);
				Assert.assertTrue(isElementPresent(VOLUME_GREEN_ICON, LONGWAIT), "Draggable word option is not loaded properly");
			}
			else
			{
				dragAndDrop(OPTION_TOBE_DRAGGED, NOUN_SECTION_AREA_TO_DROP_WORD, LONGWAIT);
			}
		}
		
		Assert.assertTrue(isElementPresent(SUMMARY_MESSAGE, LONGWAIT), "The summary message 'Summary pages only display student data' is not being displayed after completion of the text training activity named  'Sort (Nouns and Verbs)'");
		
		safeClick(SUMMARY_CONTINUE_BTN, LONGWAIT);
		
		waitForPageToLoad();
		
		Assert.assertTrue(isElementPresent(COURSETAB_SECTION, LONGWAIT), "User is not taken to course page after completion of the text training activity 'Sort (Nouns and Verbs)'");
	}
	
	/**
	 * Purpose -- To Read an activity named 'Listen and Identify' under word training tab in Level 2
	 */
	
	public void completeWTActivityAndVerifySummaryMessageInLevel2()
	{
		nullifyImplicitWait();
		int unitOneLocatorCount = getLocatorCount(UNITONE_BTN_SELECTED);		
		if(unitOneLocatorCount==0)
		{	
		setImplicitWait(IMPLICITWAIT);
		safeClick(UNITONE_BTN, LONGWAIT);
		}
		Assert.assertTrue(isElementPresent(COURSE_WTTAB_LEVEL2_SECTION, LONGWAIT),"word Training tab content under Course page is not loaded after clicking on the unit 1 tab");
		safeClick(COURSE_WT_LEVEL2_ACTIVITY, LONGWAIT);		
		Assert.assertTrue(isElementPresent(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT), "Word Training activity instructions tooltip is not displayed");		
		safeClick(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT);
		Assert.assertTrue(isElementPresent(NUMBEROFDOTS_AREA, LONGWAIT), "Word Training activity content is not loaded(number of dots section)");
		int totalNumberOfDotsDisplayed = getLocatorCount(NUMBEROFDOTS_COUNT);

		for(int i=1;i<=totalNumberOfDotsDisplayed;i++)
		{
			if(i<totalNumberOfDotsDisplayed)
			{
				safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);
				nullifyImplicitWait();
				int wrongWordCount = getLocatorCount(COURSE_WT_WRONG_WORD_CROSSMARK);
				if(wrongWordCount==1)
				{
					setImplicitWait(IMPLICITWAIT);
					
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
					
					safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
				
				}
				else
				{
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
				}					
		
			}
			else
			{
				safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);
				nullifyImplicitWait();
				int wrongWordCount = getLocatorCount(COURSE_WT_WRONG_WORD_CROSSMARK);
				if(wrongWordCount==1)
				{
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
					setImplicitWait(IMPLICITWAIT);
					safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);									
				}
			}
		}
		
		Assert.assertTrue(isElementPresent(SUMMARY_WT_MESSAGE, LONGWAIT), "The summary message 'Summary pages only display student data' is not being displayed after completion of the text training activity named  'Sort (Nouns and Verbs)'");
		
		safeClick(SUMMARY_WT_CONTINUE_BTN, LONGWAIT);
		
		waitForPageToLoad();
		
		Assert.assertTrue(isElementPresent(COURSETAB_SECTION, LONGWAIT), "User is not taken to course page after completion of the text training activity 'Sort (Nouns and Verbs)'");
	}
	
	
	/**
	 * Purpose -- To Read an activity named 'Listen and Identify' under word training tab in Level 1
	 */
	
	public void completeWTActivityAndVerifySummaryMessageInLevel1()
	{
		nullifyImplicitWait();
		int unitOneLocatorCount = getLocatorCount(UNITONE_BTN_SELECTED);		
		if(unitOneLocatorCount==0)
		{	
		setImplicitWait(IMPLICITWAIT);
		safeClick(UNITONE_BTN, LONGWAIT);
		}
		Assert.assertTrue(isElementPresent(COURSE_WTTAB_LEVEL1_SECTION, LONGWAIT),"word Training tab content under Course page is not loaded after clicking on the unit 1 tab");
		safeClick(COURSE_WT_LEVEL1_ACTIVITY, LONGWAIT);		
		Assert.assertTrue(isElementPresent(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT), "Word Training activity instructions tooltip is not displayed");		
		safeClick(INSTRUCTIONS_TOOLTIP_CLOSE_BTN, LONGWAIT);
		Assert.assertTrue(isElementPresent(NUMBEROFDOTS_AREA, LONGWAIT), "Word Training activity content is not loaded(number of dots section)");
		int totalNumberOfDotsDisplayed = getLocatorCount(NUMBEROFDOTS_COUNT);

		for(int i=1;i<=totalNumberOfDotsDisplayed;i++)
		{
			if(i<totalNumberOfDotsDisplayed)
			{
				safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);
				nullifyImplicitWait();
				int wrongWordCount = getLocatorCount(COURSE_WT_WRONG_WORD_CROSSMARK);
				if(wrongWordCount==1)
				{
					setImplicitWait(IMPLICITWAIT);
					
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
					
					safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
				
				}
				else
				{
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
				}					
		
			}
			else
			{
				safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);
				nullifyImplicitWait();
				int wrongWordCount = getLocatorCount(COURSE_WT_WRONG_WORD_CROSSMARK);
				if(wrongWordCount==1)
				{
					Assert.assertTrue(isElementPresent(COURSE_WT_AUDIO_PROGRESS_ENABLED, LONGWAIT), "Audio progress bar is not enabled after clicking the word");
					setImplicitWait(IMPLICITWAIT);
					safeClick(COURSE_WT_DRAGGABLE_WORD, LONGWAIT);									
				}
			}
		}
		
		Assert.assertTrue(isElementPresent(SUMMARY_WT_MESSAGE, LONGWAIT), "The summary message 'Summary pages only display student data' is not being displayed after completion of the text training activity named  'Sort (Nouns and Verbs)'");
		
		safeClick(SUMMARY_WT_CONTINUE_BTN, LONGWAIT);
		
		waitForPageToLoad();
		
		Assert.assertTrue(isElementPresent(COURSETAB_SECTION, LONGWAIT), "User is not taken to course page after completion of the text training activity 'Sort (Nouns and Verbs)'");
	}
	
	
	
	
	/**
	 * Purpose-- To click on Sight Words link under Course Level 1 section
	 */
	
	public TeacherCourseSightWordsPage clickOnSightWordsLink()
	{
		safeClick(SIGHTWORDS_LINK, LONGWAIT);
		
		return new TeacherCourseSightWordsPage(driver);
	}

	/**
	 * Purpose is to click on the Sound library link available for Level 1 under course tab
	 */
	public void clickOnSoundLibraryLink() {
		waitForSecs(10, "Waiting for page to load");
		safeClick(SOUND_LIBRARY_LINK, LONGWAIT);		
	}
	
	/**
	 * Purpose is to veridy the consonant and vowels sounds tabs in pop up 
	 */
	public void verifyConsonantAndVowelSections() {
		waitForPageToLoad(5);
		safeClick(CONSONANTS_TAB, LONGWAIT);
		List <WebElement> consonant_count = LocatorWebElements(CONSONANTS_SOUNDS);
		String consonants_unlocked = safeGetText(UNLOCKED_CONSONANT_SOUNDS, LONGWAIT);
		if(consonants_unlocked.substring(9, 11).equals(Integer.toString(consonant_count.size())) ){
			System.out.println("Consonants sounds unlockedcount and tiles dispalyed is same");
		}
		
		safeClick(VOWELS_TAB, LONGWAIT);
		List <WebElement> vowel_count = LocatorWebElements(VOWELS_SOUNDS);
		String vowels_unlocked = safeGetText(UNLOCKED_VOWEL_SOUNDS, LONGWAIT);
		if(vowels_unlocked.substring(9, 11).equals(Integer.toString(vowel_count.size())) ){
			System.out.println("Vowels sounds unlockedcount and tiles dispalyed is same");
		}
		
		refresh();
		
	}

	
}

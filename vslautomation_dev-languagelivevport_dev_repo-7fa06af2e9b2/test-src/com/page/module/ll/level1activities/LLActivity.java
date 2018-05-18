package com.page.module.ll.level1activities;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.data.testdata.LLData;
import com.datamanager.ExcelManager;

import java.awt.AWTException;
import java.awt.Robot;

import org.apache.log4j.Logger;
import com.page.locators.ll.admin.LLHomePageLocators;
import com.page.module.ll.goals.FluencyCheckGoalRecordingPage;
import com.page.module.ll.goals.ReadPassagesGoalRecordingPage;
import com.page.module.ll.goals.ReadSentencesGoalRecordingPage;
import com.page.module.ll.goals.ReadWordsPage;
import com.page.module.ll.goals.SaySoundsGoalPage;
import com.page.module.ll.goals.SentenceCompletionGoalPage;
import com.page.module.ll.goals.SpellWordsGoalPage;
import com.page.module.ll.goals.StressedSyllablesGoalPage;
import com.page.module.ll.level2activities.AddingSuffixes;
import com.page.module.ll.level2activities.AssociationWall;
import com.page.module.ll.level2activities.BigWordStrategy;
import com.page.module.ll.level2activities.BlendAndReadAlternate;
import com.page.module.ll.level2activities.BreakingWords;
import com.page.module.ll.level2activities.ClosedSyllable;
import com.page.module.ll.level2activities.ColumnMatching;
import com.page.module.ll.level2activities.CompoundWords;
import com.page.module.ll.level2activities.DoubleVowelIdentification;
import com.page.module.ll.level2activities.FillInTheBlanks;
import com.page.module.ll.level2activities.IndependentReading;
import com.page.module.ll.level2activities.IndependentRecording;
import com.page.module.ll.level2activities.KeyConceptQuiz;
import com.page.module.ll.level2activities.Memory;
import com.page.module.ll.level2activities.OverviewRecap;
import com.page.module.ll.level2activities.PhraseSelection;
import com.page.module.ll.level2activities.Shuffle;
import com.page.module.ll.level2activities.SortByFunction;
import com.page.module.ll.level2activities.SortByPattern;
import com.page.module.ll.level2activities.StressedSyllables;
import com.page.module.ll.level2activities.SyllableSort;
import com.page.module.ll.level2activities.VowelCorrespondence;
import com.page.module.ll.level2activities.WordBuilding;
import com.page.module.ll.level2activities.WordConstruction;
import com.page.module.ll.level2activities.WordGenerator;
import com.page.module.ll.level2activities.WordList;
import com.page.module.ll.level2activities.WordRadiator;
import com.page.module.ll.teacherrole.TeacherRoleStudentPowerPassTTActivityActions;
import com.selenium.Dynamic;
import com.selenium.SafeActions;
import com.testng.Assert;

 
public class LLActivity extends CommonFunctionalities implements LLHomePageLocators {

	private WebDriver driver;
	Logger log = Logger.getLogger(getClass());

	public LLActivity(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void verifyHomepage() {
		boolean wtStartButtonExists = isElementPresent(COURSE_LINK, LONGWAIT);
		Assert.assertTrue(wtStartButtonExists, "WT start button is not being displayed on Home page");
		Assert.assertTrue(isElementPresent(STUDENT_STADIUMBACKGROUND, LONGWAIT), "Home page is not loaded for student user");
		Assert.assertTrue(isElementPresent(STUDENT_STADIUM_LESSON_SECTION, LONGWAIT), "Home page is not loaded for student user");		
	}

	public void clickStartButton() 
	{
		safeClick(START_BTN, LONGWAIT);
	}

	 public enum ReturnPage{SENTENCE_COMPLETION,READ_WORDS, SPELL_WORDS, STRESSED_SYLLABLES,READPASSAGEGOALNONRECORDING,FLUENCYCHECKGOALRECORDING,READSENTENCESGOALRECORDING,SAYSOUNDSGOAL};

	  
	 public Object clickContinueButtonOnWordTrainingPage(ReturnPage returnPage) {
	  safeClick(CONTINUE_BTN, LONGWAIT);
	  waitForPageToLoad(LONGWAIT);
	  switch (returnPage) {
	  case READPASSAGEGOALNONRECORDING:
	   return new ReadPassagesGoalRecordingPage(driver);
	  case FLUENCYCHECKGOALRECORDING:
	   return new FluencyCheckGoalRecordingPage(driver);
	  case READSENTENCESGOALRECORDING:
	   return new ReadSentencesGoalRecordingPage(driver);
	  case SAYSOUNDSGOAL:
	  	return new SaySoundsGoalPage(driver);
	  case SPELL_WORDS:
		   return new SpellWordsGoalPage(driver);
	  case STRESSED_SYLLABLES:
	  		return new StressedSyllablesGoalPage(driver);
	  case SENTENCE_COMPLETION:
		   return new SentenceCompletionGoalPage(driver);
	  case READ_WORDS:
		  return new ReadWordsPage(driver);
	  default:
	   return null;
	  }
	 }
	
	/*
	 * purpose of the Method is used to enable the KeyStroke and select the unit
	 * , Lesson and Activity/bundle name
	 */

	 public String[] getActivityDetails(int rowNum, LLData lldata){
		  ExcelManager e =  new ExcelManager(lldata.EXCEL_PATH);
		  String[] activitydetails = new String[5];
		  for(int i=0; i<5;i++){		   
		   activitydetails[i]=e.getExcelCellData("Unique Activities", i, rowNum);
		  }
		  return activitydetails;
	 }
		  
	 
	public Object bundleSelector(int rowNum, boolean isIE , ActivityType activityType, LLData lldata , String testtype) {

			  
		safeClick(START_BTN, LONGWAIT);
		waitForPageToLoad(LONGWAIT);

		boolean continueButtonExists = isElementPresent(CONTINUE_BTN, LONGWAIT);
		Assert.assertTrue(continueButtonExists, "continue button is not being displayed on Home page");


		testSendkeys(isIE);
		boolean shortcutMenuExists = isElementPresent(SHORTCUT_MENU, LONGWAIT);
		Assert.assertTrue(shortcutMenuExists, "Shortcut menu is not being displayed ");

		String[] Activity = getActivityDetails(rowNum, lldata);
		System.out.println(Activity.length);

		String level = Activity[0];
		System.out.println(level);
		String unit = "[" + Activity[1] + "]";
		String lesson = "[" + Activity[2] + "]";
		String rc_bundle = "'" + Activity[3] + "'";
		String qc_bundle = "'" + Activity[4] + "'";

		safeClick(Dynamic.getNewLocator(LEVEL_WT, level));
		safeClick(Dynamic.getNewLocator(LESSON, level, unit, lesson));
		if (testtype.equalsIgnoreCase("QC")) {
			safeClick(Dynamic.getNewLocator(ACTIVITY, level, unit, lesson, qc_bundle));
		} else {
			safeClick(Dynamic.getNewLocator(ACTIVITY, level, unit, lesson, rc_bundle));
		}

		switch (activityType) {
		case BLEND_AND_READ:
			return new BlendAndRead(driver);
		case PHONEME_AND_GRAPHEME:
			return new PhonemeAndGrapheme(driver);
		case LISTEN_AND_IDENTIFY_KEYWORD:
			return new ListenAndIdentifyKeyword(driver);
		case MATCH_PHONEME_GRAHEME:
			return new MatchPhonemeToGrapheme(driver);
		case SOUND_LIBRARY:
			return new SoundLibrary(driver);
		case RHYMING:
			return new Rhyming(driver);
		case PHRASES_AND_SENTENCES:
			return new PhrasesAndSentences(driver);
		case STRETCHINGPREVIEW:
			return new StretchingPreview(driver);
		case SYLLABIFICATION:
			return new Syllabification(driver);
		case SEEANDIDENTIFY:
			return new SeeAndIdentify(driver);
		case LISTEN_IDENTIFY_WITH_SUMMARY:
			return new ListenAndIdentifyKeywordWithSummary(driver);
		case STRETCHING:
			return new Stretching(driver);
		case REAL_OR_NONSENSE:
			return new RealOrNonsense(driver);
		case BUILD_WORD_FAMILY:
			return new BuildaWordFamily(driver);
		case DICTATION:
			return new Dictation(driver);
		case WORD_SORT_SUMMARY:
			return new WordSortwithSummary(driver);
		case SENTENCE_COMPLETION:
			return new SentenceCompletion(driver);
		case LISTEN_ANSWER_YES_NO:
			return new ListenAndAnswerYesNo(driver);
		case WORD_SORT_MULTI_COLUMN:
			return new WordSortMultiColumn(driver);
		case SENTENCE_COMPLETION_SPELLING:
			return new SentenceCompletionSpelling(driver);
		case IDENTIFY_WORD_ENDING_SOUND:
			return new IdentifyWordEndingSound(driver);
		case IDENTIFY_WORD_ENDINGS:
			return new IdentifyWordEndings(driver);
		case STRETCHING_WITH_NO_ERROR_CORRECTION:
			return new StretchingWithNoErrorCorrection(driver);
		case RHYMING_ADVANCED:
			return new RhymingAdvanced(driver);
		case SYLLABIFICATION_TYPE:
			return new SyllabificationTyping(driver);
		case SENT_COMPLETION_NO_ERROR:
			return new SentenceCompletionWithNoErrorCorrection(driver);
		case INDEPENDENT_READING:
			return new IndependentReading(driver);
		case INDEPENDENT_RECORDING:
			return new IndependentRecording(driver);
		case KEY_CONCEPT_QUIZ:
			return new KeyConceptQuiz(driver);
		case VOWEL_CORRESPONDENCE:
			return new VowelCorrespondence(driver);
		case WORD_LIST:
			return new WordList(driver);
		case OVERVIEW_RECAP:
			return new OverviewRecap(driver);
		case CLOSED_SYLLABLE:
			return new ClosedSyllable(driver);
		case FILL_IN_THE_BLANKS:
			return new FillInTheBlanks(driver);
		case SYLLABLE_SORT:
			return new SyllableSort(driver);
		case WORD_CONSTRUCTION:
			return new WordConstruction(driver);
		case DOUBLE_VOWEL_IDENTIFICATION:
			return new DoubleVowelIdentification(driver);
		case WORD_BUILDING:
			return new WordBuilding(driver);
		case COMPOUND_WORDS:
			return new CompoundWords(driver);
		case SORT_BY_PATTERN:
			return new SortByPattern(driver);
		case BLEND_AND_READ_ALTERNATE:
			return new BlendAndReadAlternate(driver);
		case SORT_BY_FUNCTION:
			return new SortByFunction(driver);
		case SHUFFLE:
			return new Shuffle(driver);
		case STRESSED_SYLLABLES:
			return new StressedSyllables(driver);
		case BREAKING_WORDS:
			return new BreakingWords(driver);
		case BIG_WROD_STRATEGY:
			return new BigWordStrategy(driver);
		case ADDING_SUFFIXES:
			return new AddingSuffixes(driver);
		case MEMORY:
			return new Memory(driver);
		case PHRASE_SELECTION:
			return new PhraseSelection(driver);
		case WORD_RADIATOR:
			return new WordRadiator(driver);
		case WORD_GENERATOR:
			return new WordGenerator(driver);
		case COLUMN_MATCHING:
			return new ColumnMatching(driver);
		case ASSOCIATION_WALL:
			return new AssociationWall(driver);
		default:
			return null;
		}
		
	}

	public enum ActivityType {
		ASSOCIATION_WALL, COLUMN_MATCHING, WORD_GENERATOR, WORD_RADIATOR, PHRASE_SELECTION, MEMORY, ADDING_SUFFIXES, BIG_WROD_STRATEGY, BREAKING_WORDS, STRESSED_SYLLABLES, WORD_CONSTRUCTION, SHUFFLE, SORT_BY_FUNCTION, BLEND_AND_READ_ALTERNATE, COMPOUND_WORDS, SORT_BY_PATTERN, WORD_BUILDING, DOUBLE_VOWEL_IDENTIFICATION, INDEPENDENT_READING, INDEPENDENT_RECORDING, VOWEL_CORRESPONDENCE, SYLLABLE_SORT, FILL_IN_THE_BLANKS, CLOSED_SYLLABLE, WORD_LIST, OVERVIEW_RECAP, KEY_CONCEPT_QUIZ, BLEND_AND_READ, SENT_COMPLETION_NO_ERROR, SYLLABIFICATION_TYPE, RHYMING_ADVANCED, STRETCHING_WITH_NO_ERROR_CORRECTION, IDENTIFY_WORD_ENDINGS, IDENTIFY_WORD_ENDING_SOUND, SENTENCE_COMPLETION_SPELLING, WORD_SORT_MULTI_COLUMN, LISTEN_ANSWER_YES_NO, SENTENCE_COMPLETION, WORD_SORT_SUMMARY, DICTATION, PHONEME_AND_GRAPHEME, LISTEN_AND_IDENTIFY_KEYWORD, MATCH_PHONEME_GRAHEME, SOUND_LIBRARY, REAL_OR_NONSENSE, RHYMING, PHRASES_AND_SENTENCES, STRETCHINGPREVIEW, SYLLABIFICATION, SEEANDIDENTIFY, LISTEN_IDENTIFY_WITH_SUMMARY, STRETCHING, BUILD_WORD_FAMILY
	};
	public void testSendkeys(boolean isIE){

		if (isIE) {
			waitForSecs(2);
			try
			{
			Robot robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
			}
			catch(AWTException e)
			{
				e.printStackTrace();
			}
		} else {
			Actions action = new Actions(driver);
			action.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).build().perform();
			action.keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).build().perform();
		}
	}

	/**
	 * Purpose to click 'View Power Pass FeedBack' link as student user
	 */
	
	public TeacherRoleStudentPowerPassTTActivityActions clickOnViewPowerPassFeedback(boolean isStudentDisplayedWithViewPowerPassFeedBack)
	{
		if(isStudentDisplayedWithViewPowerPassFeedBack)
		{
		safeClick(TT_VIEWPOWERPASS_FEEDBACK_LINK, LONGWAIT);
		waitForPageToLoad();
		}
		return new TeacherRoleStudentPowerPassTTActivityActions(driver);
	}
	
	/**
	 * Purpose to click 'Start Power Pass' link as student user
	 */
	
	public TeacherRoleStudentPowerPassTTActivityActions clickOnStartPowerPassLink()
	{
		safeClick(TT_STARTPOWERPASS_LINK, LONGWAIT);
		waitForPageToLoad();
		
		return new TeacherRoleStudentPowerPassTTActivityActions(driver);
	}
	
	/**
	 * Purpose - To verify that view power pass feedback link is displayed for student user on top of cricket stadium background
	 */
	
	public boolean isStudentDisplayedWithViewPowerPassFeedbackLink()
	{
		nullifyImplicitWait();
		int viewPowerPassFeedbackLinkCount = getLocatorCount(TT_VIEWPOWERPASS_FEEDBACK_LINK);
		if(viewPowerPassFeedbackLinkCount==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
}

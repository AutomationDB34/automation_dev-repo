package com.page.locators.ll.teacherrole;

import org.openqa.selenium.By;

public interface TeacherRoleCoursePageLocators {

	By COURSETAB_SELECTED = By.xpath("//span[@name='Course' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	By COURSETAB_SECTION = By.className("Cambium.App.CourseGuide.main_content");
	
	By COURSE_LEVELONE_TAB = By.name("Level1");
	By COURSE_LEVELONE_SELECTED = By.xpath("//span[@name='Level1' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	
	By COURSE_LEVELTWO_TAB = By.name("Level2");
	By COURSE_LEVELTWO_SELECTED = By.xpath("//span[@name='Level2' and contains(@class,'Cambium.UI.Tabs.Tabs.selected')]");
	
	By COURSE_WT_TAB = By.name("wordtraining");
	By COURSE_WT_TAB_SELECTED = By.xpath("//span[@name='wordtraining' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By COURSE_WTTAB_LEVEL1_SECTION = By.xpath("//div[contains(@class,'Cambium.App.CourseGuide.Level1.WordTraining.WT')]");
	By COURSE_WT_LEVEL1_ACTIVITY = By.xpath("(//a[@class='Cambium.App.CourseGuide.Level1.WordTraining.teacherGuideLink'][text()='Listen and Identify'])[1]");
	By COURSE_WTTAB_LEVEL2_SECTION = By.xpath("//div[contains(@class,'Cambium.App.CourseGuide.Level2.WordTraining.WT')]");
	By COURSE_WT_LEVEL2_ACTIVITY = By.xpath("(//a[@class='Cambium.App.CourseGuide.Level2.WordTraining.teacherGuideLink'][text()='Listen and Identify'][text()='Listen and Identify'])[1]");
	
	By COURSE_WT_DRAGGABLE_WORD = By.xpath("(//span[@class='Cambium.UI.Draggable2.txt'])[1]");
	By COURSE_WT_WRONG_WORD_CROSSMARK = By.xpath("//div[contains(@class,'cambium_ui_state_box Cambium.UI.StateBox.wrong')]");
	By COURSE_WT_AUDIO_PROGRESS_ENABLED = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioProgressButton') and not(@disabled)]");
	
	By SUMMARY_WT_MESSAGE = By.xpath("//div[@class='Cambium.Bundles.ListenAndIdentify.Summary.serverMessage'][text()='Summary pages only display student data.']");
	By SUMMARY_WT_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.ListenAndIdentify.Summary.continue')]");

	
	By COURSE_TT_TAB = By.name("texttraining");
	By COURSE_TT_TAB_SELECTED = By.xpath("//span[@name='texttraining' and contains(@class,'Cambium.LanguageLive.UI.Tabs.selected')]");
	By UNITONE_BTN = By.xpath("//div[contains(@class,'Cambium.UI.ResourceUnitNav.unitNumber')][text()='1']");
	By UNITONE_BTN_SELECTED = By.xpath("//div[contains(@class,'Cambium.UI.ResourceUnitNav.selectedLesson')][text()='1']");
	By COURSE_TTTAB_LEVEL1_SECTION = By.xpath("//div[contains(@class,'Cambium.App.CourseGuide.Level1.TextTraining.TT')]");
	By COURSE_TTTAB_LEVEL2_SECTION = By.xpath("//div[contains(@class,'Cambium.App.CourseGuide.Level2.TextTraining.TT')]");
	By COURSE_TT_LEVEL1_ACTIVITY = By.xpath("//a[@class='Cambium.App.CourseGuide.Level1.TextTraining.teacherGuideLink'][text()='Sort (Nouns and Verbs)']");
	By COURSE_TT_LEVEL2_ACTIVITY = By.xpath("//a[@class='Cambium.App.CourseGuide.Level2.TextTraining.teacherGuideLink'][text()='Sort (Nouns and Verbs)']");
	By INSTRUCTIONS_TOOLTIP_CLOSE_BTN = By.className("Cambium.LanguageLive.UI.InstructionsMenu.closerX");
	
	By NUMBEROFDOTS_AREA = By.className("Cambium.UI.StepBubbleBar.dotContainer");
	By NUMBEROFDOTS_COUNT = By.xpath("//div[@class='Cambium.UI.StepBubbleBar.dotContainer']//div[@class='Cambium.UI.StepBubbleBar.progressDotRed']");
	
	//By NOUN_SECTION_AREA_TO_DROP_WORD = By.xpath("(//div[@class='Cambium.Bundles.Sorting.SortByFunction.scrollableContainer' and @data-index='0']//td[@class='Cambium.Bundles.Sorting.SortByFunction.dataContainer'])[1]");
	By NOUN_SECTION_AREA_TO_DROP_WORD = By.xpath("//div[@class='Cambium.Bundles.Sorting.SortByFunction.scrollableContainer' and @data-index='0']");
	By OPTION_TOBE_DRAGGED = By.xpath("//span[contains(@class,'Cambium.UI.Draggable2.originator')]//span[@class='Cambium.UI.Draggable2.txt']");
	By VOLUME_GREEN_ICON = By.xpath("//button[contains(@class,'Cambium.UI.Buttons.AudioButton.active')]");
	
	By SUMMARY_MESSAGE = By.xpath("//div[@class='Cambium.Bundles.Sorting.SortByFunction.Summary.serverMessage'][text()='Summary pages only display student data.']");
	By SUMMARY_CONTINUE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Sorting.SortByFunction.Summary.continue')]");
	
	By SIGHTWORDS_LINK = By.className("Cambium.App.CourseGuide.sightwords ");
	
	By SOUND_LIBRARY_LINK = By.xpath("//span[contains(text(),'Sound Library')]");
	
	By SOUNDLIBRARY_POPUP = By.xpath("//td[contains(text(),'Sound Library')]");
	By CONSONANTS_TAB = By.xpath("//div[contains(text(),'Consonants')]");
	By VOWELS_TAB = By.xpath("//div[contains(text(),'Vowels')]");
	
	By CONSONANTS_SOUNDS = By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.unlockedC')]");
	By VOWELS_SOUNDS =By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.unlockedV ')]");
	
	By UNLOCKED_CONSONANT_SOUNDS = By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.left')]/span[2]");
	By UNLOCKED_VOWEL_SOUNDS = By.xpath("//div[contains(@class,'Cambium.UI.SoundLibrary.left')]/span[2]");
	
	
	
			
	
}

package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface ReadPassagesGoalLocators {

//Locators for GATE WAY GOALS VIDEO WINDOW 
By GATEWAYGOALSVIDEOSWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");

//Locators for FLUENCY VIDEO WINDOW
By PASSGEFLUENCYVIDEOWINDOW_FADEOUT = By.xpath("//div[@class='Cambium.UI.Windows.ModalMovie.replayContainer Cambium.UI.Windows.ModalMovie.fadeOut']");
By PASSGEFLUENCYVIDEOWINDOW_CONTINUE_BTN = By.xpath("//button[@class='Cambium.UI.ActionButton Cambium.UI.Windows.ModalMovie.closer cambium_ui_action_button']");

//Locators for READY TO PREVIEW HEADING TEXT WINDOW
By READYTOPREVIEWHEADING_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
By READYTOPREVIEWWINDOWSTART_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

//Locators for READING PASSGE TEXT WINDOW
By READINGPASSGE_TEXT_SECTION = By.xpath(".//div[@class='cambium_bundles_gateway_read_passage Cambium.Bundles.Gateway.ReadPassage']") ;
By READINGPASSGE_TEXTWORDS_LIST = By.xpath("//div[@class='Cambium.Bundles.Gateway.ReadPassage.passage ']//div");
By READPASSGEWINDOW_CONTINUE_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.ReadPassage.buttonSet']/button[.='Continue']");

//Locators for COMPLETE THE SENTENCES IN THE TEXT WINDOW
By COMPLETETHESENTENCESINTHEPASSAGE_TEXT = By.xpath(".//div[@class='Cambium.Bundles.Gateway.TransitionPractice.caption']");
By COMPLETETHESENTENCESINTHEPASSAGE_CONTINUE_BTN =By.xpath(".//div[@class='Cambium.Bundles.Gateway.TransitionPractice.buttonContainer']/button[contains(text(),'Continue')]");

//Locators for READY TO START HEADING TEXT WINDOW
By READYTOSTARTHEADINGFIRSTTIME_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
By READYTOSTARTWINDOWFIRSTTIME_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

//Locators for FILL IN THE BLANKS FOR PASSGE WINDOW
By FILLINTHEBLANK_SECTION = By.xpath(".//div[@class='Cambium.Bundles.Gateway.ReadPassagePractice.passage']");
By FILLINTHEBLANKS_LIST = By.xpath(".//div[@class='Cambium.Bundles.Gateway.ReadPassagePractice.passage']/div");
By FILLINTHEBLANKSFIRST_ANSWEROPTION = By.xpath(".//div[@class='Cambium.Bundles.Gateway.ReadPassagePractice.passage']/div[%s]/div[2]");
By FILLINTHEBLANKSFIRST_ANSWEROPTIONWITHSTYLE = By.xpath(".//div[@class='Cambium.Bundles.Gateway.ReadPassagePractice.passage']/div[%s]/div[2][@style='display: none;']");
By FILLINTHEBLANKSSECOND_ANSWEROPTION = By.xpath(".//div[@class='Cambium.Bundles.Gateway.ReadPassagePractice.passage']/div[%s]/div[3]");
By FILLINTHEBLANKSWINDOW_CONTINUE_BTN = By.xpath(".//div[@class='Cambium.Bundles.Gateway.ReadPassagePractice.buttonContainer']/button[.='Continue']");

//Locators for READ ALONG AND LISTEN TEXT WINDOW
By READALONGANDLISTEN_TEXT = By.xpath(".//div[@class='Cambium.Bundles.Gateway.TransitionPractice.caption']");
By READALONGANDLISTENWINDOW_CONTINUE_BTN = By.xpath(".//div[@class='Cambium.Bundles.Gateway.TransitionPractice.buttonContainer']/button[contains(text(),'Continue')]");

//Locators for READY TO START READING HEADING TEXT WINDOW
By READYTOSTARTHEADINGSECONDTIME_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
By READYTOSTARTWINDOWSTARTSECONDTIME_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

//Locators for AUDIO PROGRESS BAR PASSGE WINDOW
By AUDIOPROGRESS_BAR = By.xpath("//div[@class='Cambium.UI.PercentageBar Cambium.UI.Buttons.AudioProgressButton.bar cambium_ui_percentage_bar']");
By AUDIOPROGRESSBARWINDOW_CONTINUE_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.ReadPassage.buttonSet']/button[.='Continue']");

//Locators for YOU ARE READY TO TAKE THE TEST HEADING TEXT WINDOW
By YOUAREREADYTOTAKETEST_TEXT = By.xpath(".//div[@class='Cambium.Bundles.Gateway.TransitionPractice.caption']");
By YOUAREREADYTOTAKETESTWINDOW_CONTINUE_BTN = By.xpath(".//div[@class='Cambium.Bundles.Gateway.TransitionPractice.buttonContainer']/button[contains(text(),'Continue')]");

//Locators for Ready to record window
By READY_TO_RECORD = By.xpath("//span[contains(text(),'Ready to record?')]");
By START_BTN = By.xpath("//button[contains(text(),'Start')]");
By CONTINUE_BTN = By.xpath("//button[contains(text(),'Continue')]");

By RECORDING_TIMER= By.xpath("//div[@class='Cambium.Bundles.Gateway.Recording.Passage.timerContainer']");
By RECORDING_PASSAGE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Recording.Passage.passage ']");
By STOP_TIMER_BTN = By.xpath("//button[contains(text(),'Stop Timer')]");

By READY_TO_UPLOAD_RECORDING_POPUP = By.xpath("//div[contains(text(),'Ready to upload your recording.')]");
By ENCODE_RECORDING_POPUP = By.xpath("//div[contains(text(),'Encoding your recording.')]");
By UPLOAD_YOUR_RECORDING_POPUP = By.xpath("//div[contains(text(),'Uploading your recording.')]");
By UPLOAD_COMPLETE_POPUP = By.xpath("//div[contains(text(),'Upload complete.')]");


By REVIEW_POPUP = By.xpath("//span[contains(text(),'Review your recordings.')]");

By PASSAGE_REVIEW_PAGE = By.xpath("//div[contains(text(),'Click on any words you recorded wrong.')]");
By PASSAGE_WORD = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.passageWord']");
By WRONG_WORD = By.xpath("//div[contains(@class,'Cambium.Bundles.Gateway.Grading.Passage.passageWord')][%s]");

By LAST_WORD = By.xpath("//div[contains(text(),'Click on the last word you read.')]");

By RETAKE_TEST_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.Summary.retakeTest cambium_ui_action_button')]");
By RETAKE_BTN = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.Summary.sendANote')]/following-sibling::button[contains(text(),'Retake Test')]");
//By RETAKE_TEST_BTN = By.xpath("//button[contains(text(),'Retake Test')]");
By SEND_A_NOTE_LINK = By.xpath("//button[contains(@class,'Cambium.Bundles.Gateway.Summary.sendANote ')]");





















//Locators for READY TO SPEAK HEADING TEXT WINDOW
By READYTOSPEAK_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
By READYTOSPEAKWINDOW_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

//Locators for RECORDING PASSGE WINDOW 
By RECORDINGPASSAGEWINDOW_STOPTIMER_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.Recording.Passage.buttonContainer']/button[.='Stop Timer']");

//Locators for REVIEW YOUR READING HEADING TEXT WINDOW
By REVIEWYOURREADING_TEXT = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//span[@class='Cambium.UI.Windows.Gateway.heading']");
By REVIEWYOURREADINGWINDOW_START_BTN = By.xpath(".//div[@class='Cambium.UI.Windows.Gateway.window']//button[contains(text(),'Start')]");

//Locators for CLICK ON ANY WORDS YOU SAID WRONG WINDOW
By CLICKONANYWORDSYOUSAIDWRONGWINDOW_HEADERTITLE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.instr'][.='Click on any words you said wrong.']");
By CLICKONANYWORDSYOUSAIDWRONGWORDS_LIST = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.passage ']/div");
By CLICKONANYWORDSYOUSAIDWRONGWORDS_FIRSTWORD = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.passage ']/div[1]");
By CLICKONANYWORDSYOUSAIDWRONGWINDOW_CONTINUE_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.buttonContainer']/button[.='Continue']");

//Locators for CLICK ON THE LAST WORD YOU READ WINDOW
By CLICKONTHELASTWORDYOUREAD_HEADERTITLE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.instr'][.='Click on the last word you read.']");
By CLICKONTHELASTWORDYOUREADWORDS_LIST = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.passage ']/div");
By CLICKONTHELASTWORDYOUREADWORDS_TENTHWORD = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.passage ']/div[10]");
By CLICKONTHELASTWORDYOUREADWORDS_LASTWORD = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.passage ']/div[%s]");
By CLICKONTHELASTWORDYOUREADWORDS_CONTINUE_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.Grading.Passage.buttonContainer']/button[.='Continue']");

//Locators for TEST RESULTS SUMMARY SECTION WINDOW
By TESTRESULTSSUMMARYWINDOW_HEADERTITLE = By.xpath("//div[@class='Cambium.Bundles.Gateway.Summary.summaryHeadTitle'][.='Test Results']");
By TESTRESULTSSUMMARYWINDOW_SCORE_FIELD = By.xpath("//table[@class='Cambium.UI.ScoreBoard cambium_ui_score_board']//tr[@class='Cambium.CSS.GatewayScoreboardRow Cambium.UI.ScoreBoard.values']/td[1]");
By TESTRESULTSSUMMARYWINDOW_SUBMITFEEDBACK_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.Summary.buttonContainer']//button[.='Submit for Feedback']");

//Locators for YOUR RECORDING SUBMITTED HEADING TEXT WINDOW
By YOURRECORDINGSUBMITTED_TEXT = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionTest.caption']");
By YOURRECORDINGSUBMITTEDWINDOW_CONTINUE_BTN = By.xpath("//div[@class='Cambium.Bundles.Gateway.TransitionTest.buttonSet Cambium.Bundles.Gateway.TransitionTest.set1']//button[.='Continue']");

//Locators for WORDS PER MINUTE PROGRESS CHART WINDOW
By WORDSPERMINUTEPROGRESSCHARTWINDOW_HEADERTITLE = By.xpath("//td[@class='Cambium.Bundles.FluencyCheck.Progress.progressHeader']");
By WORDSPERMINUTEPROGRESSCHARTWINDOW_SCORESPOT = By.xpath("//div[@class='Cambium.Bundles.FluencyCheck.Progress.plottableRegion']/span");
By WORDSPERMINUTEPROGRESSCHARTWINDOW_CONTINUE_BTN = By.xpath("//td[@class='Cambium.Bundles.FluencyCheck.Progress.progressFooter']/button[.='Continue']");

}

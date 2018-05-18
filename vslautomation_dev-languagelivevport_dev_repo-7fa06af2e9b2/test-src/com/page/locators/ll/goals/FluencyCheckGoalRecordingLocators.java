package com.page.locators.ll.goals;

import org.openqa.selenium.By;

public interface FluencyCheckGoalRecordingLocators {
	
	//Locators for Ready To Start Recording? popup
	
	By READY_TO_START_RECORDING_POPUP_HEADER = By.xpath("//span[@class='Cambium.UI.Windows.Gateway.heading'][text()='Ready to start recording?']");
	By START_BTN = By.xpath("//button[text()='Start']");
	
	//Fluency Reading passage section locators
	By FLUENCY_READING_PASSAGE_BODY = By.className("Cambium.Bundles.FluencyCheck.Recording.passageContainer");	
	By FLUENCY_READING_PASSGE_STOPRECORDING_BTN = By.xpath("//button[text()='Stop Recording']");
	
	//Ready to upload your recording popup locators
	By READY_TO_UPLOAD_RECORDING_HEADER = By.xpath("//div[@class='Cambium.LanguageLive.UI.UploadRecordingModal.header'][text()='Ready to upload your recording.']");	
	By ENCODING_YOUR_RECORDING_HEADER = By.xpath("//div[@class='Cambium.LanguageLive.UI.UploadRecordingModal.header'][text()='Encoding your recording.']");	
	By UPLOADING_YOUR_RECORDING_HEADER = By.xpath("//div[@class='Cambium.LanguageLive.UI.UploadRecordingModal.header'][text()='Uploading your recording.']");
	By UPLOAD_COMPLETE_HEADER = By.xpath("//div[@class='Cambium.LanguageLive.UI.UploadRecordingModal.header'][text()='Upload complete.']");
	
	//Click on the last word you read popup locators
	By CLICKONTHELASTWORDYOUREAD_HEADER = By.xpath("//span[@class='Cambium.UI.Windows.Gateway.heading'][text()='Click on the last word you read.']");
	
	
	//Click on the last word you read passage area locators
	By LASTWORD_YOU_READ_CONTENT = By.className("Cambium.Bundles.FluencyCheck.LastWord.passageContainer");
	By LASTWORD_YOU_READ_CONTENT_WORDS = By.xpath("//div[@class='Cambium.Bundles.FluencyCheck.LastWord.passageContainer']//div");
	By CLICKONTHELASTWORDYOUREADWORDS_TENTHWORD = By.xpath("(//div[@class='Cambium.Bundles.FluencyCheck.LastWord.passageContainer']//div)[10]");
	By LASTWORD_YOU_READ_WORD_TOBECLICKED = By.xpath("(//div[@class='Cambium.Bundles.FluencyCheck.LastWord.passageContainer']//div)[%s]");
	By CONTINUE_BTN = By.xpath("//button[text()='Continue']");
	
	//Fluency check summary content section locators
	By FLUENCY_CHECK_SUMMARY_SECTION = By.className("Cambium.Bundles.FluencyCheck.Summary.content");
	By FLUENCY_CHECK_SUMMARY_SCORE =  By.className("Cambium.CSS.fluencyCheckDisplay");
	By SUBMIT_YOUR_RECORDING_BTN = By.xpath("//button[text()='Submit Recording']");
	
	//Your recording has been received section locators
	By YOURRECORDINGHASBEENRECEIVED_MESSAGE = By.xpath("//div[text()='Your recording has been received.']");
	
	//Locators for WORDS PER MINUTE PROGRESS CHART WINDOW
	By WORDSPERMINUTEPROGRESSCHARTWINDOW_HEADERTITLE = By.xpath("//td[@class='Cambium.Bundles.FluencyCheck.Progress.progressHeader']");
	By WORDSPERMINUTEPROGRESSCHARTWINDOW_SCORESPOT = By.xpath("//div[@class='Cambium.Bundles.FluencyCheck.Progress.plottableRegion']/span");
	By WORDSPERMINUTEPROGRESSCHARTWINDOW_CONTINUE_BTN = By.xpath("//td[@class='Cambium.Bundles.FluencyCheck.Progress.progressFooter']/button[.='Continue']");	
}

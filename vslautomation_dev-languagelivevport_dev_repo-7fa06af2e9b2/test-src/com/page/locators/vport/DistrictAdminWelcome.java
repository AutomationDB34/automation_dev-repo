package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictAdminWelcome {
	
	public static By EMAIL_ADDRESS = By.xpath("//input[@type='text'][@name='email']");
	public static By TRAINING_OPTIONS = By.name("training[0].trainingAttendedId");
	public static By TOU_CHECKBOX = By.name("hasAcceptedTermsOfUse");
	public static By OK_BTN = By.className("submit");	
}

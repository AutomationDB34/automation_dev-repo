package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictTrackTechnologyLocators {
			
	public static By ADDROW_BTN = By.cssSelector("img[name='Add Row']");
	public static By AVAILABLEASSESSMENTPLANS = By.cssSelector("table[id='dynamicTable'] tr");
	public static By ENABLEDRADIOBUTTONSFORASSESSMENT = By.cssSelector("table[id='dynamicTable'] td>div>input[value='1']:checked[type='radio']");
	public static By LOGOUT_LINK = By.xpath(".//table[@id='header']//a[.='Log Out']");	
}

package com.page.locators.vport;

import org.openqa.selenium.By;

public interface DistrictTrackSchoolTracksLocators {

	
	public static By TRACKNAME_HEADING=By.xpath(".//div[@id='printSection']//td[contains(text(),'%s')]");
	public static By SCHOOLNAME=By.xpath("//td[text()='%s']");
	public static By SCHOOLNAME_ROW=By.xpath("//td[text()='%s']/../td[%s]");
	public static By CHECKBOX_SCHOOL=By.xpath("//td[text()='%s']/../td[1]/input");
	public static By INHERIT_RADIOBTN=By.xpath("//td[text()='%s']/../td[%s]//input[3]");
	public static By SAVECHANGES_BTN= By.id("save_changes2");
	
	public static By PI_ICON = By.xpath("//img[contains(@name,'%s')]");
	
	
			
}

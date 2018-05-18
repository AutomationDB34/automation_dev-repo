package com.page.locators.ll.admin;

import org.openqa.selenium.By;

public interface ClassMatesLocators {

	By CLASSMATESPAGE_HEADING=By.xpath("//td[@class='Cambium.App.Classmates.col Cambium.App.Classmates.title' and text()='Classmates']");
	By CLASSSELECTOR_DRPDWN=By.xpath("//table[@class='Cambium.LanguageLive.UI.SelectMenu.ClassSelector.menuTable']//td");
	By CLASSSNAMEIN_CLASSSELECTOR_DRPDWN=By.xpath("//td[contains(@class,'Cambium.UI.Menu.item Cambium.LanguageLive.UI.SelectMenu.ClassSelector.option') and text()='%s']");
	
	By TEACHER_NAME=By.xpath("//div[@class='Cambium.App.Classmates.teacherName']/div[text()='t. %s']");
	By STUDENTS_COUNT=By.xpath("//div[@class='Cambium.App.Classmates.studentName']");
	By STUDENT_NAMESLIST=By.xpath("(//table[@class='Cambium.App.Classmates.list Cambium.App.Classmates.students']//td//div[@class='Cambium.App.Classmates.lastName'])[%s]");
	By STUDENT_NAME=By.xpath("//div[@class='Cambium.App.Classmates.lastName' and text()='%s']");
	By STUDENT_NAME_IN_CLASSMATE_PAGE = By.xpath("//div[contains(text(),'%s')]");
	
	By USERPROFILEABOUT_TAB=By.className("Cambium.LanguageLive.UI.DashboardMenu.userName");
	By USERPROFILE_NAME=By.className("Cambium.App.UserProfile.AboutMe.userName");
	
}

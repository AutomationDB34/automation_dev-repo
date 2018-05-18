package com.data.testdata;

import com.datamanager.ConfigManager;

public class VportData {
	
	ConfigManager appData = new ConfigManager("App");
	public final String vportURL = appData.getProperty("App.VPORT.URL");//constructURL(appData);
	public final String vportUsername = appData.getProperty("App.Username");
	public final String vportPassword = appData.getProperty("App.Password");

	// track filter data
	public final String productName = appData.getProperty("App.ProductName");
	public final String userType = appData.getProperty("District.UserType");
	public final String alpha = appData.getProperty("District.Alphabet");

	// Add District details
	public final String Districtname = appData.getProperty("District.DistrictName");
	public final String Address = appData.getProperty("District.Address");
	public final String DistCity = appData.getProperty("District.City");
	public final String Country = appData.getProperty("District.Country");
	public final String State = appData.getProperty("District.State");
	public final String ZipCode = appData.getProperty("District.Zipcode");
	//public final String AddProduct = appData.getProperty("District.AddProduct");
	public final String Status = appData.getProperty("District.Status");
	public final String Year = appData.getProperty("District.Year");
	
	//School Data
	
		public final String schoolName=appData.getProperty("School.Schoolname");
		public final String Code=appData.getProperty("School.Code");
		public final String Address1=appData.getProperty("School.Address1");
		public final String SchoolCity=appData.getProperty("School.City");
		public final String zipCode=appData.getProperty("School.ZipCode");
		
		
		//District User Data
		
		public final String distUserLogin=appData.getProperty("DistrictUser.Login");
		public final String distUserFirstName=appData.getProperty("DistrictUser.FirstName");
		public final String distUserLastName=appData.getProperty("DistrictUser.LastName");
		public final String distUserPassword=appData.getProperty("DistrictUser.Password");

		//School User Data
		public final String schoolUserFirstName=appData.getProperty("SchoolUser.FirstName");
		public final String schoolUserLastName=appData.getProperty("SchoolUser.LastName");
		public final String schoolUserEmail=appData.getProperty("App.TestEmail");
		public final String schoolUserLogin=appData.getProperty("SchoolUser.login");
		public final String schoolUserPassword=appData.getProperty("SchoolUser.Password");


	// Data on District track Materials page
	public final String licencegradelevel = appData.getProperty("App.LicenceGradeLevel");
	public final String licenceseatcount = appData.getProperty("App.LicenceSeatCount");
	public final String reasonforaddinglicence = appData.getProperty("App.ReasonForAddingLicence");
	public final String addLicenceAlertMessage = appData.getProperty("App.AddLicenceAlertMessage");
	
	//District Admin privacy page data
	public final String districtAdminName = appData.getProperty("DistrictAdmin.Name");
	public final String districtAdminTitle = appData.getProperty("DistrictAdmin.Title");
	
	//District Admin Profile information  data
	public final String districtAdminEMail = appData.getProperty("App.TestEmail");
	public final String districtAdmintraining = appData.getProperty("DistrictAdmin.TrainingOption");
	
	
	//Teacher Data
	public final String teacherFirstName = appData.getProperty("Teacher.FirstName");
	public final String teacherLastName = appData.getProperty("Teacher.LastName");
	public final String teacherUserId = appData.getProperty("Teacher.UserId");
	public final String teacherPassword = appData.getProperty("Teacher.Password");
	public final String teacherEmail=appData.getProperty("App.TestEmail");
	
	
	//District Admin Credentials
	 public final String   districtAdminUserName=appData.getProperty("DistrictAdminUserName");
	 public final String   districtAdminPassword=appData.getProperty("DistrictAdminPassword");
	 public final String   districtAdminSchoolName=appData.getProperty("DistrictAdminSchoolName");
	 public final String   districAdminTrackName=appData.getProperty("TrackName");
	   //Default Data for Assessments
     public final String  teacher=appData.getProperty("Teacher");
     public final String  levelAStudnetUserID=appData.getProperty("LevelAStudnetUserID");
     public final String  levelAStudnetID=appData.getProperty("LevelAStudnetID");
     public final String  levelAClass=appData.getProperty("LevelAClass");
     public final String  levelDClass=appData.getProperty("LevelDClass");
     
     public final String  levelDStudnetUserID=appData.getProperty("LevelDStudnetUserID");
     public final String  levelDStudnetID=appData.getProperty("LevelDStudnetID");

	 
	  public final String class1=appData.getProperty("Class1");
	  public final String class2=appData.getProperty("Class2");
	  public final String class3=appData.getProperty("Class3");
		
	  // Add Students To Class information data
	 public final String   studentLastName=appData.getProperty("Student.LastName");
     public final String   studentFirstName=appData.getProperty("Student.FirstName");
     public final String   studentID=appData.getProperty("Student.ID");
     public final String   studentGradeLevel=appData.getProperty("Student.GradeLevel");
     public final String   studentDOB=appData.getProperty("Student.DOB");
     
     //Student Licenses types
      public final String  pP_T2RStudent=appData.getProperty("PP/T2RStudent");
      public final String  onlineAssessments=appData.getProperty("OnlineAssessments");
      public final String  T2R=appData.getProperty("T2R");
      public final String  pP_T2R_EdplicityStudent=appData.getProperty("PP/T2R/EdplicityStudent");
       
   //Student Online Assessments Types
//      public final String AssessmentTimePeriod=appData.getProperty("TimePeriod");

	
	public final String reasonForCreatingLicenceImagePath = System.getProperty("user.dir")+appData.getProperty("App.ReasonForCreatingLicenceImagePath");

	
	
	private String constructURL(ConfigManager app){
		
		String url=app.getProperty("App.VPORT.URL");
		String strStage=app.getProperty("App.Stage");
		
		if(!strStage.equalsIgnoreCase("prod")){
			url=url.replace("vport", "qa.vport");
		}
		return url;
	}
	
	
	public enum UserRole {
	    PRINCIPAL("Prinicipal"),
	    CAMPUS_COACH("Campus Coach"),
	    CAMPUS_USER("Campus User"),
	    RESOURCE_USER("Resource User"),
	    TEACHER("Teacher");

	    private String name;

	    UserRole(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return this.name;
	    }   
	}
	
	
	private enum Product {
	    VPORT("VPORT Product"),
	    PASSPORT("Passport"),
	    UNIVERSALLITERASY("Universal Literacy"),
	    LANGUAGELIVE("Language! Live"),
	    RIDE_BIB("RIDE-BIB"),
	    ESOLUTIONS("eSolutions");

	    private String name;

	    Product(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return this.name;
	    }   
	}
	public String selectProduct(String productKey){
		return Product.valueOf(productKey).getName();
	}
	
	public String assessmentScore(String key)
	{
		return appData.getProperty(key);
	}

	 public final String vportDistrictAdminUserName = appData.getProperty("VportDistrictAdmin.UserName");
	 public final String vportDistrictAdminPassword = appData.getProperty("VportDistrictAdmin.Password");
	 public final String vportDistrictAdminSchoolName = appData.getProperty("VportDistrictAdmin.SchoolName");
	 
	 public final String vportImportStudents_Option1 = appData.getProperty("Vport.ImportStudents_Option1");
	 public final String vportImportStudents_Option2 = appData.getProperty("Vport.ImportStudents_Option2");
	 public final String internetExplorerSave = appData.getProperty("download.internetExplorerSave");
	 public final String RosterStudentDownloadedTemplateFilePath = appData
				.getProperty("App.RosterStudentDownloadedTemplateFilePath");

	 public final String DNIntroductionSkip = appData.getProperty("DN.IntroductionVideoSkipImagePath");
	 public final String DNContinueBtn = appData.getProperty("DN.ContinueButtonImagePath");
	 public final String DNAnswer1 = appData.getProperty("DN.Answer1ImagePath");
	 public final String DNAnswer2 = appData.getProperty("DN.Answer2ImagePath");
	 public final String DNReturnToStudnetCenter = appData.getProperty("DN.ReturnToStudentCenterImagePath");
	 public final String DORF_Assessment_Btn = appData.getProperty("DN.DorfAssessmentImagePath");
	 public final String DORF_Assessment_start_Btn = appData.getProperty("DN.DorfStartAssessmentImagePath");
	 public final String DORF_LastWord_Btn = appData.getProperty("DN.DorfLastWordImagePath");
	 public final String DORF_Conitnue_Btn = appData.getProperty("DN.DorfContinueBtnImagePath");
	 public final String DORF_FinishAssessment_Btn = appData.getProperty("DN.DorfFinishAssessmentImagePath");
	 
	 //VPORT LOGIN PAGE
	 public final String SYSTEMREQUIREMENTS = appData.getProperty("App.SYSTEMREQUIREMENTS");
	 public final String CUSTOMERSUPPORT = appData.getProperty("App.CUSTOMERSUPPORT");
	 public final String FBSHARE = appData.getProperty("APP.FBSHARE");
	 
	 public final String VSL_URL = appData.getProperty("App.VSL.URL");
	public final String DummyAssessmentPlanName = appData.getProperty("DummyAssessmentPlanName");
			 
	 
}

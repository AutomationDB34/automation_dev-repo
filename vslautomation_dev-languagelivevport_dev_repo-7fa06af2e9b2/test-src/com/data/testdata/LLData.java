package com.data.testdata;

import com.datamanager.ConfigManager;

public class LLData {

	ConfigManager appData = new ConfigManager("App");
	// public final String vportURL = constructURL(appData);
	public final String URL = appData.getProperty("App.LL.URL");
	public final String productName = appData.getProperty("App.ProductName2");

	public final String teacherLLUsername = appData.getProperty("TeacherLL.Username");
	public final String teacherLLPassword = appData.getProperty("TeacherLL.Password");

	// Language Live Read Passage Goal Activity data
	public final String readyToPreviewText = appData.getProperty("LL.ReadyToPreview");
	public final String completeTheSentencesInTheText = appData.getProperty("LL.CompleteTheSentenceText");
	public final String readyToStartText = appData.getProperty("LL.ReadyToStartText");
	public final String readAlongAndListenToModelText = appData.getProperty("LL.ReadAlongAndListenToModelText");
	public final String readyToStartReadingText = appData.getProperty("LL.ReadyToStartReadingText");
	public final String youAreReadyToTakeTheTestText = appData.getProperty("LL.YouAreReadyToTakeTheTestText");
	public final String readyToSpeakText = appData.getProperty("LL.ReadyToSpeakText");
	public final String reviewYourReadingText = appData.getProperty("LL.ReviewYourReadingText");
	public final String yourRecordingSubmittedText = appData.getProperty("LL.YourRecordingSubmittedText");

	public final String testEmail = appData.getProperty("App.TestEmail");

	// Create Students data
	public final String studentID = appData.getProperty("Student.ID");
	public final String studentGradeLevel = appData.getProperty("Student.GradeLevel");
	public final String studentDOB = appData.getProperty("Student.DOB");
	public final String numberOfStudentsToCreate = appData.getProperty("Student.NumberOfStudentsToCreate");

	// Path to the Sikuli image of Microphone Setup
	public final String MICROPHONE_IMAGE = appData.getProperty("LL.MicrophoneAllowRadiobuttonImagePath");

	public final String llDistrictAdmin = appData.getProperty("LL.DistrictAdmin");
	public final String llCampusAdmin = appData.getProperty("LL.CampusAdmin");

	// Path to the Sikuli image to close the Sound library new modal
	public final String SOUNDLIBRARY_IMAGE = appData.getProperty("LL.SoundLibraryNewModalCoseImagePath");

	// Path to the Sikuli image to close the Technology Issues Dialog
	public final String TECHNOLOGYISSUESCLOSE_IMAGE = appData.getProperty("LL.TechnologyIssuesCloseButton");

	// Path to the Sikuli image to close the Technology Issues Dialog
	public final String SENTENCE_COMPLETION_GOAL_IMAGE = appData.getProperty("LL.SentenceCompleionGoalTextArea");

	// Path to the Test data in Excel sheet
	public final String EXCEL_PATH = appData.getProperty("Excel.Path");

	// SchoolName
	public final String LLSchoolName = appData.getProperty("VportDistrictAdmin.SchoolName");

	// Class Name
	public final String LLClassName = appData.getProperty("VportDistrictAdmin.ClassName");

	// Language Live Teacher Role data

	public final String teacherRoleLLUsername = appData.getProperty("TeacherRoleLL.Username");
	public final String teacherRoleLLPassword = appData.getProperty("TeacherRoleLL.Password");

	public final String newTeacherLLTrainingOption = appData.getProperty("NewTeacherLL.TrainingOption");
	public final String teacherRoleLLClassName = appData.getProperty("TeacherRoleLL.ClassName");
	public final String teacherRoleLLStudentLastName = appData.getProperty("TeacherRoleLLStudent.LastName");
	public final String teacherRoleLLStudentFirstName = appData.getProperty("TeacherRoleLLStudent.FirstName");
	public final String teacherRoleLLStudentWTLevel = appData.getProperty("TeacherRoleLLStudentWTLevel");
	public final String teacherRoleLLStudentWTLesson = appData.getProperty("TeacherRoleLLStudentWTLesson");
	public final String teacherRoleLLStudentSightWords = appData.getProperty("TeacherRoleLLStudentSightWords");
	public final String teacherRoleLLStudentWTUnitPercentageScore = appData
			.getProperty("TeacherRoleLLStudentWTUnitPercentageScore");
	public final String teacherRoleLLStudentSWBOTSScore = appData.getProperty("TeacherRoleLLStudentSWBOTSScore");
	public final String teacherRoleLLStudentSWGamesPlayedCount = appData
			.getProperty("TeacherRoleLLStudentSWGamesPlayedCount");
	public final String teacherRoleLLStudentTTPracticeActivity = appData
			.getProperty("TeacherRoleLLStudentTTPracticeActivity");
	public final String teacherRoleLLStudentTTPracticeActivityScore = appData
			.getProperty("TeacherRoleLLStudentTTPracticeActivityScore");
	public final String teacherRoleLLStudentTTContentMastery = appData
			.getProperty("TeacherRoleLLStudentTTContentMastery");
	public final String teacherRoleLLStudentTTContentMasteryScore = appData
			.getProperty("TeacherRoleLLStudentTTContentMasteryScore");
	public final String teacherRoleLLStudentTTPowerPass = appData.getProperty("TeacherRoleLLStudentTTPowerPass");
	public final String teacherRoleLLStudentTTPowerPassScore = appData
			.getProperty("TeacherRoleLLStudentTTPowerPassScore");
	public final String teacherRoleLLStudentTTUnit = appData.getProperty("TeacherRoleLLStudentTTUnit");
	public final String teacherRoleLLAlertsAutoPassStudentLastName = appData
			.getProperty("TeacherRoleLLAlertsAutoPassStudent.LastName");
	public final String teacherRoleLLAssignmentsAssignTextStudentLastName = appData
			.getProperty("TeacherRoleLLAssignmentsAssignTextStudent.LastName");
	public final String teacherRoleLLCourseResourcesWTLevel = appData
			.getProperty("TeacherRoleLLCourseResourcesWTLevel");
	public final String teacherRoleLLCourseResourcesTTLevel = appData
			.getProperty("TeacherRoleLLCourseResourcesTTLevel");
	public final String teacherRoleLLCourseResourcesProgramPlanningPDFURL = appData
			.getProperty("TeacherRoleLLCourseResourcesProgramPlanningPDFURL");
	public final String teacherRoleLLCourseResourcesUnitNumber = appData
			.getProperty("TeacherRoleLLCourseResourcesUnitNumber");
	public final String teacherRoleLLCourseTTSortNounAndVerbsNounArea = appData
			.getProperty("TeacherRoleLLCourseTTSortNounAndVerbsNounArea");
	public final String teacherRoleLLClassWallAssignmentTitle = appData
			.getProperty("TeacherRoleLLClassWallAssignmentTitle");
	public final String teacherRoleLLClassWallAssignmentDesc = appData
			.getProperty("TeacherRoleLLClassWallAssignmentDesc");
	public final String teacherRoleLLClassWallAssignmentCredit = appData
			.getProperty("TeacherRoleLLClassWallAssignmentCredit");
	public final String teacherRoleLLClassWallAssignmentTimeInHours = appData
			.getProperty("TeacherRoleLLClassWallAssignmentTimeInHours");
	public final String teacherRoleLLClassWallAssignmentTimeInMinutes = appData
			.getProperty("TeacherRoleLLClassWallAssignmentTimeInMinutes");
	public final String teacherRoleLLClassWallAssignmentTimeInAMPM = appData
			.getProperty("TeacherRoleLLClassWallAssignmentTimeInAMPM");
	public final String teacherRoleLLClassClassResourcesLevel = appData
			.getProperty("TeacherRoleLLClassClassResourcesLevel");
	public final String teacherRoleLLClassLeaderboardsLevel = appData
			.getProperty("TeacherRoleLLClassLeaderboardsLevel");
	public final String teacherRoleLLTTReviewFeedBackStudentLastName = appData
			.getProperty("TeacherRoleLLTTReviewFeedBackStudentLastName");
	public final String student1LevelOption = appData.getProperty("Student1.LevelOption");
	public final String student1UnitOption = appData.getProperty("Student1.UnitOption");
	public final String student1LessonOption = appData.getProperty("Student1.LessonOption");
	public final String student1RecordingRequired = appData.getProperty("Student1.RecordingRequired");
	public final String student2LevelOption = appData.getProperty("Student2.LevelOption");
	public final String student2UnitOption = appData.getProperty("Student2.UnitOption");
	public final String student2LessonOption = appData.getProperty("Student2.LessonOption");
	public final String student2RecordingRequired = appData.getProperty("Student2.RecordingRequired");
	public final String student3LevelOption = appData.getProperty("Student3.LevelOption");
	public final String student3UnitOption = appData.getProperty("Student3.UnitOption");
	public final String student3LessonOption = appData.getProperty("Student3.LessonOption");
	public final String student3RecordingRequired = appData.getProperty("Student3.RecordingRequired");
	
	public final String StudentLesson1Score = appData.getProperty("TeacherRoleWTLesson1Score");
	public final String StudentLesson2Score = appData.getProperty("TeacherRoleWTLesson2Score");
	public final String StudentLesson3Score = appData.getProperty("TeacherRoleWTLesson3Score");
	public final String StudentLesson4Score = appData.getProperty("TeacherRoleWTLesson4Score");

	public final String StudentReadPassageScore = appData.getProperty("TeacherRoleReadPassageGoalScore");
	
	// Language Live Rhyming Activity Data

	public final String RhyminTile1 = appData.getProperty("Rhyming.Tile1");
	public final String RhyminTile2 = appData.getProperty("Rhyming.Tile2");
	public final String RhyminTile3 = appData.getProperty("Rhyming.Tile3");
	public final String RhyminTile4 = appData.getProperty("Rhyming.Tile4");
	public final String RhyminTile5 = appData.getProperty("Rhyming.Tile5");
	public final String RhyminTile6 = appData.getProperty("Rhyming.Tile6");
	public final String RhyminTile7 = appData.getProperty("Rhyming.Tile7");
	public final String RhyminTile8 = appData.getProperty("Rhyming.Tile8");
	public final String RhyminTile9 = appData.getProperty("Rhyming.Tile9");
	public final String RhyminTile10 = appData.getProperty("Rhyming.Tile10");

	// Language Live Word Construction Activity Data

	public final String WordConstructionTile1 = appData.getProperty("WordConstruction.Tile1");
	public final String WordConstructionTile2 = appData.getProperty("WordConstruction.Tile2");
	public final String WordConstructionTile3 = appData.getProperty("WordConstruction.Tile3");
	public final String WordConstructionTile4 = appData.getProperty("WordConstruction.Tile4");
	public final String WordConstructionTile5 = appData.getProperty("WordConstruction.Tile5");
	public final String WordConstructionTile6 = appData.getProperty("WordConstruction.Tile6");
	public final String WordConstructionTile7 = appData.getProperty("WordConstruction.Tile7");
	public final String WordConstructionTile8 = appData.getProperty("WordConstruction.Tile8");
	public final String WordConstructionTile9 = appData.getProperty("WordConstruction.Tile9");
	public final String WordConstructionTile10 = appData.getProperty("WordConstruction.Tile10");
	public final String WordConstructionTile11 = appData.getProperty("WordConstruction.Tile11");
	public final String WordConstructionTile12 = appData.getProperty("WordConstruction.Tile12");
	public final String WordConstructionTile13 = appData.getProperty("WordConstruction.Tile13");
	public final String WordConstructionTile14 = appData.getProperty("WordConstruction.Tile14");

	// Language Live Memory Activity Data
	public final String memoryBlueTile1 = appData.getProperty("Memory.BlueTile1");
	public final String memoryBlueTile2 = appData.getProperty("Memory.BlueTile2");
	public final String memoryBlueTile3 = appData.getProperty("Memory.BlueTile3");
	public final String memoryBlueTile4 = appData.getProperty("Memory.BlueTile4");
	public final String memoryBlueTile5 = appData.getProperty("Memory.BlueTile5");
	public final String memoryBlueTile6 = appData.getProperty("Memory.BlueTile6");
	public final String memoryBlueTile7 = appData.getProperty("Memory.BlueTile7");
	public final String memoryBlueTile8 = appData.getProperty("Memory.BlueTile8");

	public final String memoryRedTile1 = appData.getProperty("Memory.RedTile1");
	public final String memoryRedTile2 = appData.getProperty("Memory.RedTile2");
	public final String memoryRedTile3 = appData.getProperty("Memory.RedTile3");
	public final String memoryRedTile4 = appData.getProperty("Memory.RedTile4");
	public final String memoryRedTile5 = appData.getProperty("Memory.RedTile5");
	public final String memoryRedTile6 = appData.getProperty("Memory.RedTile6");
	public final String memoryRedTile7 = appData.getProperty("Memory.RedTile7");
	public final String memoryRedTile8 = appData.getProperty("Memory.RedTile8");

	// Language Live Word Generator Activity Data
	public final String wordGeneratorTile1 = appData.getProperty("WordGenerator.Tile1");
	public final String wordGeneratorTile2 = appData.getProperty("WordGenerator.Tile2");
	public final String wordGeneratorTile3 = appData.getProperty("WordGenerator.Tile3");
	public final String wordGeneratorTile4 = appData.getProperty("WordGenerator.Tile4");
	public final String wordGeneratorTile5 = appData.getProperty("WordGenerator.Tile5");
	public final String wordGeneratorTile6 = appData.getProperty("WordGenerator.Tile6");
	public final String wordGeneratorTile7 = appData.getProperty("WordGenerator.Tile7");
	public final String wordGeneratorTile8 = appData.getProperty("WordGenerator.Tile8");
	public final String wordGeneratorTile9 = appData.getProperty("WordGenerator.Tile9");
	public final String wordGeneratorTile10 = appData.getProperty("WordGenerator.Tile10");
	public final String wordGeneratorTile11 = appData.getProperty("WordGenerator.Tile11");

	// Language Live Column Matching Activity Data
	public final String columnMatchingleftTile1 = appData.getProperty("ColumnMatching.Tile1");
	public final String columnMatchingleftTile2 = appData.getProperty("ColumnMatching.Tile3");
	public final String columnMatchingleftTile3 = appData.getProperty("ColumnMatching.Tile5");
	public final String columnMatchingleftTile4 = appData.getProperty("ColumnMatching.Tile7");
	public final String columnMatchingleftTile5 = appData.getProperty("ColumnMatching.Tile9");
	public final String columnMatchingleftTile6 = appData.getProperty("ColumnMatching.Tile11");

	public final String columnMatchingrightTile1 = appData.getProperty("ColumnMatching.Tile2");
	public final String columnMatchingrightTile2 = appData.getProperty("ColumnMatching.Tile4");
	public final String columnMatchingrightTile3 = appData.getProperty("ColumnMatching.Tile6");
	public final String columnMatchingrightTile4 = appData.getProperty("ColumnMatching.Tile8");
	public final String columnMatchingrightTile5 = appData.getProperty("ColumnMatching.Tile10");
	public final String columnMatchingrightTile6 = appData.getProperty("ColumnMatching.Tile12");

	// Path to the Sikuli image for Syllabification mouse pointer issue
	public final String syllabificationMousepointerImage = appData.getProperty("Syllabification.Mousepointer");

	// Path to the Sikuli image for Stretching mouse pointer issue
	public final String stretchingMousepointerImage = appData.getProperty("StretchingStep1.Mousepointer");

	// Path to the Sikuli image for Rhyming Left container mouse pointer issue
	public final String rhymingLeftContainerImage = appData.getProperty("RhymingLeftContainer.Mousepointer");

	// Path to the Sikuli image for Rhyming Right container mouse pointer issue
	public final String rhymingRightContainerImage = appData.getProperty("RhymingRightContainer.Mousepointer");

	// Path to the Sikuli image for Sentence completion mouse pointer issue
	public final String SentenceCompletionMousePointerImage = appData.getProperty("SentenceCompletion.Mousepointer");

	// Path to the Sikuli image for Sentence completion mouse pointer issue
	public final String SentCompletionWithNoErrorMousePointerImage = appData
			.getProperty("SentCompletionWithNoError.Mousepointer");

	// Path to the Sikuli image for Compound Words mouse pointer issue
	public final String compoundWordsMousePointerImage = appData.getProperty("CompoundWords.Mousepointer");

	// Path to the Sikuli image for Sentence completion mouse pointer issue
	public final String wordConstructionLeftMousePointerImage = appData
			.getProperty("WordConstructionLeftContainer.Mousepointer");

	// Path to the Sikuli image for Sentence completion mouse pointer issue
	public final String wordConstructionRighttMousePointerImage = appData
			.getProperty("WordConstructionRightContainer.Mousepointer");

	// Student Level1 credentials
	public final String stretchingPreviewUN = appData.getProperty("StretchingPreview.student");
	public final String stretchingUN = appData.getProperty("Stretching.student");
	public final String syllabificationUN = appData.getProperty("Syllabification.student");
	public final String blendAndReadUN = appData.getProperty("BlendAndRead.student");
	public final String reviewActivityUN = appData.getProperty("ReviewActivity.student");
	public final String tutorialActivityUN = appData.getProperty("TutorialAndReviewActivity.student");
	public final String sentenceCompletionStudent = appData.getProperty("SentenceCompletion.student");
	public final String sentenceCompletionSpellingStudent = appData.getProperty("SentenceCompletionSpellinh.student");
	public final String sentenceCompletionWithNoErrorStudent = appData
			.getProperty("SentenceCompletionWithNoError.student");
	public final String dictationStudent = appData.getProperty("Dictation.student");
	public final String syllabificationTypingStudent = appData.getProperty("SyllabificationTyping.student");
	public final String wordSortStudent = appData.getProperty("wordSortWithSumamry.student");
	public final String wordMulSortStudent = appData.getProperty("wordSortMultiColumn.student");
	public final String realOrNonsenseStudent = appData.getProperty("RealAndNonsense.student");
	public final String stretchingNoErrorStudent = appData.getProperty("StretchingNoError.student");
	public final String rhymingStudent = appData.getProperty("Rhyming.student");
	public final String rhymingAdvStudent = appData.getProperty("RhymingAdvance.student");
	public final String BuildWordStudent = appData.getProperty("BuildaWordFamily.student");
	public final String IdentifyWordEndStudent = appData.getProperty("IdentifyWordEnd.student");
	public final String IdentifyWordSoundStudent = appData.getProperty("IdentifyWordSound.student");
	public final String ListenYesNoStudent = appData.getProperty("ListenYesNo.student");

	// Level 2 student credentials
	public final String irReadStudent = appData.getProperty("IRRead.student");
	public final String irRecordStudent = appData.getProperty("IRRecord.student");
	public final String syllableSortStudent = appData.getProperty("L2Sorting1.student");
	public final String sortByPatternStudent = appData.getProperty("L2Sorting2.student");
	public final String sortByFunctionStudent = appData.getProperty("L2Sorting3.student");
	public final String bigWordStrategyStudent = appData.getProperty("L2DragandDrop.student");
	public final String wordRadiatorStudent = appData.getProperty("L2WordRadiator.student");
	public final String wordGeneratorStudent = appData.getProperty("L2WordGenerator.student");
	public final String associationWallStudent = appData.getProperty("L2AssociationWall.student");
	public final String columnMatchingStudent = appData.getProperty("L2ColumnMatching.student");
	public final String checkUnderstandingStudent = appData.getProperty("L2CheckUnderstanding.student");
	public final String breakingwordsstudent = appData.getProperty("L2Breakingwords.student");
	public final String addingsuffixesstudent = appData.getProperty("L2Addingsuffixes.student");
	public final String blendAndReadAlternatestudent = appData.getProperty("L2BlendAndReadAlternate.student");
	public final String shufflestudent = appData.getProperty("L2Shuffle.student");
	public final String wordconstructionstudent = appData.getProperty("L2Wordconstruction.student");
	public final String wordbuildingstudent = appData.getProperty("L2Wordbuilding.student");
	public final String CheckUnderstandingstudent1 = appData.getProperty("L2CheckUnderstanding1.student");
	public final String CheckUnderstandingstudent2 = appData.getProperty("L2CheckUnderstanding2.student");
	public final String CheckUnderstandingstudent3 = appData.getProperty("L2CheckUnderstanding3.student");
	public final String CheckUnderstandingstudent4 = appData.getProperty("L2CheckUnderstanding4.student");
	public final String CheckUnderstandingstudent5 = appData.getProperty("L2CheckUnderstanding5.student");
	public final String closedSyllableStudent = appData.getProperty("L2ClosedSyllable.student");

	// District user and Campus User Course Reports data
	public final String adminLLStudentWordTrainingStudentAverage = appData
			.getProperty("AdminLLStudentWordTrainingStudentAverage");
	public final String adminLLStudentWordTrainingU1Lesson1Score = appData
			.getProperty("AdminLLStudentWordTrainingU1Lesson1Score");
	public final String adminLLStudentWordTrainingU1Lesson2Score = appData
			.getProperty("AdminLLStudentWordTrainingU1Lesson2Score");
	public final String adminLLStudentWordTrainingU1Lesson3Score = appData
			.getProperty("AdminLLStudentWordTrainingU1Lesson3Score");
	public final String adminLLStudentWordTrainingU1Lesson4Score = appData
			.getProperty("AdminLLStudentWordTrainingU1Lesson4Score");
	public final String adminLLStudentTextTrainingStudentAverage = appData
			.getProperty("AdminLLStudentTextTrainingStudentAverage");
	public final String adminLLStudentTextTrainingUnit1Score = appData
			.getProperty("AdminLLStudentTextTrainingUnit1Score");

	// Data for Excel sheet
	public final String IEEnterFilePath = appData
			.getProperty("App.IEEnterFilePath");
	public final String IEBrowseFilePath = appData.getProperty("App.IEBrowseFilePath");
	public final String IEUploadOpenButton = appData.getProperty("App.IEUploadOpenButton");
	public final String IESubmitButton = appData.getProperty("App.IESubmitButton");
	public final String FileUploadSuccessfulInIE = appData.getProperty("App.FileUploadSuccessfulInIE");
	public final String ProceedWithImportInIE = appData.getProperty("App.ProceedWithImportInIE");
	public final String SuccessfulUploadInIE = appData.getProperty("App.SuccessfulUploadInIE");
	
	
	public final String RosterStudentDownloadedTemplateFilePath = appData
			.getProperty("App.RosterStudentDownloadedTemplateFilePath");
	public final String ExcelSheetName = appData.getProperty("Excel.SheetName");
	public final String RowNumbertoEnterData = appData.getProperty("Row.Rownumber");

	// Data in ClassWall
	public final String WallDescriptionData = appData.getProperty("Wall.Description");

	// Data For Edit Profile of User

	public final String UserProfileBirthPlace = appData.getProperty("User.BirthPlace");
	// Common Goal Data
	public final String Goal_ReadyToStartText = appData.getProperty("Goal.ReadyStartText");
	public final String Goal_ReadyToReviewText = appData.getProperty("Goal.ReadyToReviewText");
	public final String Goal_ReadyToRecordText = appData.getProperty("Goal.ReadyToRecordText");
	public final String Goal_Reviewyourrecordings = appData.getProperty("Goal.Reviewyourrecordings");
	public final String Goal_ReadyToStartTest = appData.getProperty("Goal.ReadyToStartTest");
	public final String Goal_ReadyToSpeak = appData.getProperty("Goal.ReadyToSpeak");
	
	// Data for LL_001_Goals
	public final String LL001_Goals_Student = appData.getProperty("LL001_Goals_Student");
	public final String LL001_Goals_Student_Level = appData.getProperty("LL001_Goals_Student_Level");
	public final String LL001_Goals_Student_Unit = appData.getProperty("LL001_Goals_Student_Unit");
	public final String LL001_Goals_Student_Lession = appData.getProperty("LL001_Goals_Student_Lession");
	public final String LL001_Goals_Student_Recording_Need = appData.getProperty("LL001_Goals_Student_Recording_Need");

	// Data for LL_006_Goals
	public final String LL006_Goals_Student = appData.getProperty("LL006_Goals_Student");
	public final String LL006_Goals_Student_Level = appData.getProperty("LL006_Goals_Student_Level");
	public final String LL006_Goals_Student_Unit = appData.getProperty("LL006_Goals_Student_Unit");
	public final String LL006_Goals_Student_Lession = appData.getProperty("LL006_Goals_Student_Lession");
	public final String LL006_Goals_Student_Recording_Need = appData.getProperty("LL006_Goals_Student_Recording_Need");

	// Data for LL_005_Goal
	public final String LL005_Goals_Student_Level = appData.getProperty("LL005_Goal_Student_level");
	public final String LL005_Goals_Student_Unit = appData.getProperty("LL005_Goals_Student_Unit");
	public final String LL005_Goals_Student_Goal = appData.getProperty("LL005_Goals_Student_Goal");
	public final String LL005_Goals_Student_Recording_Need = appData.getProperty("LL005_Goals_Student_Recording_Need");

	// Data for LL_008_Goal
	public final String LL008_Goals_Student_Level = appData.getProperty("LL008_Goals_Student_level");
	public final String LL008_Goals_Student_Unit = appData.getProperty("LL008_Goals_Student_Unit");
	public final String LL008_Goals_Student_Goal = appData.getProperty("LL008_Goals_Student_Goal");
	public final String LL008_Goals_Student_Recording_Need = appData.getProperty("LL008_Goals_Student_Recording_Need");

	// Data for LL_007_Goals
	public final String LL007_Goals_Student = appData.getProperty("LL007_Goals_Student");
	public final String LL007_Goals_Student_Level = appData.getProperty("LL007_Goals_Student_Level");
	public final String LL007_Goals_Student_Unit = appData.getProperty("LL007_Goals_Student_Unit");
	public final String LL007_Goals_Student_Lession = appData.getProperty("LL007_Goals_Student_Lession");
	public final String LL007_Goals_Student_Recording_Need = appData.getProperty("LL007_Goals_Student_Recording_Need");

	// Data for LL_002_Goals
	public final String LL002_Goals_Student_Level = appData.getProperty("LL002_Goals_Student_Level");
	public final String LL002_Goals_Student_Unit = appData.getProperty("LL002_Goals_Student_Unit");
	public final String LL002_Goals_Student_Lesson = appData.getProperty("LL002_Goals_Student_Lesson");
	public final String LL002_Goals_Student_Recording_Need = appData.getProperty("LL002_Goals_Student_Recording_Need");

	
	public final String teacher_stdcreation = appData.getProperty("Teacher.login");
	public final String internetExplorerSave = appData.getProperty("download.internetExplorerSave");
	
	public final String benchmark_studentname = appData.getProperty("Benchmarkscore.Student");
	public final String studentscore = appData.getProperty("Teacherrole.B1score");
	public final String studentLexilescore = appData.getProperty("Teacherrole.Lexilescore");

	public final String kitabooPageTitle = appData.getProperty("LL_Teacher_041_Kitaboo_Page_Title");

}

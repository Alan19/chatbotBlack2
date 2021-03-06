package groupFiles;

import java.util.Scanner;

public class JaviyMajor extends Object implements Chatbot{
	
	private static boolean inMajorLoop;
	private static String MajorResponse;
	private static int grade;
	private static int counter;
	private static int loopCounter;
	private static int majorCount;
	
	
	private static String[] bioScienceStatements = 

		{"In junior year you will take AP Biology (double period) and in senior year you will take AP Psychology",
				"Classes you will take in this major are Genetics,Human Anatomy,and AP classes",
				"Your teachers in this major may be found here http://www.bths.edu/apps/pages/index.jsp?uREC_ID=30105&type=d&termREC_ID=&pREC_ID=staff",
				"The Biological Sciences major provides an overview of the life sciences. Students will be exposed to subtopics in biology including biochemistry, energy, genetics, evolution and ecology. Students will learn the internal structures and functions of the human body by dissecting various organisms, will acquire lab techniques in biotechnology in the state-of-the-art genetics lab, and will study human behavior with a focus on neuroscience. Students who have an interest in the life sciences, the health field or in conducting lab-based science research should apply to this major."};
	
	private static String[] chemistryStatements = 
		{"In junior year you will take AP Chemistry (Double Period)",
				"Classes you will take in this major are Modern Instrumental Chemical Analysis,Organic Chemistry (1 semester/double period),Forensic Quantitative Analysis (1 semester/double period), and AP classes",
				"Your teachers in this major may be found here http://www.bths.edu/apps/pages/index.jsp?uREC_ID=30106&type=d&termREC_ID=&pREC_ID=staff",
				"Professionals who benefit from a foundation in chemistry are extremely diverse in their interests.  Many are researchers in fields such as medicine, synthetic methods, structural & functional materials, environmental sciences, biochemistry, agriculture, and current & future energies.  But, many more also consider themselves business developers, engineers, manufacturers, regulators, lawyers, entrepreneurs, and policy makers.  What they have in common is a curiosity about and a background in the nature of matter, how it changes, and how it can be controlled to meet human needs."};

	private static String[] collegePrepStatements = 
		{"In junior year you will take AP Human Geography and in senior year you will take AP Principles of Computer Science",
				"Classes you will take throughout this major are PLTW CEA,Criminal Law, ELA Elective Course,and your AP classes",
				"Your teachers in this major may be found here http://www.bths.edu/apps/pages/index.jsp?uREC_ID=18380&type=d&termREC_ID=&pREC_ID=staff or http://www.bths.edu/apps/pages/index.jsp?uREC_ID=18383&type=d&termREC_ID=&pREC_ID=staff"};

	private static String[] financeStatements = 
		{"In junior year you will take AP Macro-Economics and AP Micro-Economics, in senior year you will take AP Calculus AB/BC and AP Statistics",
				"Classes you will take throughout this major are Principles of Accounting,Finance & Investments,and Introduction to Business Law",
				"Your teachers in this major may be found here: http://www.bths.edu/apps/pages/index.jsp?uREC_ID=18380&type=d&termREC_ID=&pREC_ID=staff or http://www.bths.edu/apps/pages/index.jsp?uREC_ID=18383&type=d&termREC_ID=&pREC_ID=staff",
				"Not available"};

	private static String[] mediaStatements = 
		{"In junior year you have no mandatiory AP classes",
				"Classes you will take throughout this major are  Adobe Visual Design,Adobe Digital Video,and MAYA Digital Animation",
				"Your teachers in this major may be found here http://www.bths.edu/apps/pages/index.jsp?uREC_ID=18380&type=d&termREC_ID=&pREC_ID=staff",
				};

	private static String[] softwareStatements = 
		{"In junior year you will take AP Principles of Computer Science and in senior year you will take AP Java",
				"Classes you will take throughout this major are Introduction to Programming Through Web Development, Oracle Academy Database Development Level I, and it's AP Classes",
				"Your teachers in this major may be found here http://www.bths.edu/apps/pages/index.jsp?uREC_ID=18380&type=d&termREC_ID=&pREC_ID=staff",
				"The computer science industry continues to evolve quickly.  Companies are consistently looking for new and more efficient ways to communicate their information over the web and manage their data and traffic flow.  Companies like Google are redefining the way the industry operates. "
						+ "Students in the Software Engineering Major learn how to program from the most elementary concepts to some of the most advanced.  They will develop problem solving skills through the use of a variety of web application languages, Java, and SQL.  Our courses are designed to train students to apply their knowledge and ready themselves for the vital specializations offered at the university level and in the workforce."};

	private static Scanner input;
	
	private String[] existingMajors = {"biosci","bioscience","chem","chemistry"," collegeprep",
			"finance","media","software"};
	
	private String[] calmResponses = 
		{"I already said I don't have this major in my database.","Please move on","Please select an input that I can comprehend","Can you follow the directions?"};
	private String[] angryResponses =
		{"Okay seriously. Stop searching for something that's not in my database.",
				"How are you in Tech again?","WOW you are really speical -cough- -cough-",
				"I WILL: KILL YOU IF U SAY IT AGAIN! XD","You need jesus","God added an extra dose of stupid when he made you :P"
				,"I bet you don't have any friends","SHUT UP, you lower the IQ of the entire street when you talk"};
	
	
	private static int [] studentGrades = {50,55,60,65,70,75,80,85,90,95};
	private static String [] yourGrades = {"0","0","0","0","0","0"};
	private static String [] subjects = {"Overall","Math","English","Science","Digital Electronics","Social Studies"};
	private static String gradeResponse;
	
	
	public JaviyMajor(){
		majorCount = 0;
		counter = 0;
		loopCounter = 0;
	}
	
	
	public void talk() {
		inMajorLoop = true;
		ZhenMain.println("Welcome to my Brooklyn Tech major database, I can handle: Bioscience, Chemistry, CollegePrep, Finance, Media, and Software. My database can't handle more than that. Type quit to go back.");
		while(inMajorLoop){
			//static call on promptInputmethod from JaviyMain
			MajorResponse = ZhenMain.promptInput();
			checkOtherTriggers(MajorResponse);
			//Create helper method to make you exit out if you try to search for a major other than the ones listed
			if(MajorResponse.indexOf("quit")>=0){
				inMajorLoop = false;
				ZhenMain.promptForever();
			}
			if(loopCounter>=1)
			{
				promptForeverInMajor();
			}
			else if(majorsExist(MajorResponse)==true){
				ZhenMain.println("What else would you like to know about APs, classes, teachers. and/or description of the major of your choice?");
				loopCounter++;
				promptForeverInMajor();
			}
			else
			{
				majorDoesntExist();
			}
		}
	}

	
	private static void basicQuestions(int info) {
			if(ZhenMain.findKeyword(MajorResponse,"software",0)>=0)ZhenMain.println(softwareStatements[info]);
			if(ZhenMain.findKeyword(MajorResponse,"bio sci",0)>=0 || ZhenMain.findKeyword(MajorResponse,"bioscience",0)>=0
					|| ZhenMain.findKeyword(MajorResponse,"biosci",0)>=0)ZhenMain.println(bioScienceStatements[info]);
			if(ZhenMain.findKeyword(MajorResponse,"media",0)>=0)ZhenMain.println(mediaStatements[info]);
			if(ZhenMain.findKeyword(MajorResponse,"collegeprep",0)>=0)ZhenMain.println(collegePrepStatements[info]);
			if(ZhenMain.findKeyword(MajorResponse,"finance",0)>=0)ZhenMain.println(financeStatements[info]);
			if(ZhenMain.findKeyword(MajorResponse,"chem",0)>=0 || ZhenMain.findKeyword(MajorResponse,"chemistry",0)>=0)ZhenMain.println(chemistryStatements[info]);
	}
	
	public static void promptForeverInMajor() {
		MajorResponse = ZhenMain.promptInput();
		MajorResponse.toLowerCase();
			if(MajorResponse.indexOf("ap") >= 0 || MajorResponse.indexOf("aps") >= 0){
				basicQuestions(0);
			}
			else if(MajorResponse.indexOf("classes")>=0 || MajorResponse.indexOf("class")>=0){
				basicQuestions(1);
			}
			else if(MajorResponse.indexOf("grades")>=0 || MajorResponse.indexOf("gpa")>=0 || MajorResponse.indexOf("get into")>=0){
				getChanceOfMajor();
			}
			else if(MajorResponse.indexOf("teachers")>=0)
			{
				basicQuestions(3);
			}
			else if(MajorResponse.indexOf("description")>=0)
			{
				basicQuestions(4);
			}
			else
			{
				ZhenMain.println("I don't understand");
				majorCount++;
			}
		}
		//helper method to compare you to other students that want that major
	
		private static void findYourMajor() {
			
			for(int i=0;i < subjects.length;i++){
				System.out.println("What's your " + subjects[i] + " average?");
				gradeResponse = ZhenMain.promptInput();
				//int gradeAsInteger = Integer.parseInt(gradeResponse);
				//method to stop it if integer is greater than 120
				//yourGrades[i] = gradeAsInteger;
				 String integerString = gradeResponse;
				 boolean isInteger = false;
				 int value = 0;
				 while(!isInteger){
				 try{
				 value = Integer.parseInt(integerString);
				 //will not continue if an error above is thrown
				 isInteger = true;//exits loop if entry is valid
				 }catch(NumberFormatException e){
					 System.out.println("You must enter an integer. You better try again.");
				 integerString = gradeResponse;
				 }
				 	
				 }
 			 	 if(Integer.parseInt(integerString)>105){
				 		yourGrades[i] = "105";
				 	}else if(Integer.parseInt(integerString)<0){
				 		yourGrades[i] = "0";
				 	}else if(Integer.parseInt(integerString)<105 && Integer.parseInt(integerString)>0){
				 		yourGrades[i] = integerString;
				 	}
			 }
				
		}
		
	private static void getChanceOfMajor() {
		//String []gradeArray = {"0","0","0","0","0","0"};
		//System.out.println("What are your grades in Math, English, Digital Electronics, Social Studies, Science and Overall Average?");
		//helper method to get all the grades you want
		findYourMajor();
		int [] students = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
				0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<students.length-1;i++){
		int randomGrade = (int) (Math.random()*studentGrades.length);
		students[i] = students[i] + studentGrades[randomGrade];
		}
		if(ZhenMain.findKeyword(MajorResponse,"software",0)>=0){
			int softwarePowerIndex = (Integer.parseInt(yourGrades[0])+Integer.parseInt(yourGrades[1])+Integer.parseInt(yourGrades[3])+Integer.parseInt(yourGrades[3]))/4;
			for(int j = 0;j<students.length-1;j++){
				if(students[j]<=softwarePowerIndex){
					counter++;
				}
			}
			if(counter>=100)System.out.print("You have a great chance of getting into your major");
			if(counter<100 && counter>=50)System.out.print("You have a good into your major");
			if(counter<50)System.out.print("You have a bad chance of getting into your major");
		}
		if(ZhenMain.findKeyword(MajorResponse,"biosci",0)>=0 || ZhenMain.findKeyword(MajorResponse,"bioscience",0)>=0){
			int bioPowerIndex = (Integer.parseInt(yourGrades[0])+Integer.parseInt(yourGrades[3])+Integer.parseInt(yourGrades[3]))/3;
			
				for(int j = 0;j<students.length-1;j++){
					if(students[j]<=bioPowerIndex){
						counter++;
					}
				}
				if(counter>=100)System.out.print("You have a great chance of getting into your major");
				if(counter<100 && counter>=50)System.out.print("You have a good into your major");
				if(counter<50)System.out.print("You have a bad chance of getting into your major");
		
		}
		if(ZhenMain.findKeyword(MajorResponse,"media",0)>=0){
			int mediaPowerIndex = (Integer.parseInt(yourGrades[0])+Integer.parseInt(yourGrades[4])+Integer.parseInt(yourGrades[4]))/3;
			{
				for(int j = 0;j<students.length-1;j++){
					if(students[j]<=mediaPowerIndex){
						counter++;
					}
				}
				if(counter>=100)System.out.print("You have a great chance of getting into your major");
				if(counter<100 && counter>=50)System.out.print("You have a good into your major");
				if(counter<50)System.out.print("You have a bad chance of getting into your major");
			}
		}
		if(ZhenMain.findKeyword(MajorResponse,"collegeprep",0)>=0){
			System.out.println("You have a 100% chance of getting into this major.");
			}
		
			if(ZhenMain.findKeyword(MajorResponse,"finance",0)>=0){
				int financePowerIndex = (Integer.parseInt(yourGrades[0])+Integer.parseInt(yourGrades[1])+Integer.parseInt(yourGrades[5]))/3;
				{
				for(int j = 0;j<students.length-1;j++){
					if(students[j]<=financePowerIndex){
						counter++;
					}
				}
				if(counter>=100)System.out.print("You have a great chance of getting into your major");
				if(counter<100 && counter>=50)System.out.print("You have a good into your major");
				if(counter<50)System.out.print("You have a bad chance of getting into your major");
			}
		}
		if(ZhenMain.findKeyword(MajorResponse,"chem",0)>=0 || ZhenMain.findKeyword(MajorResponse,"chemistry",0)>=0){
			int chemPowerIndex = (Integer.parseInt(yourGrades[0])+Integer.parseInt(yourGrades[1])+Integer.parseInt(yourGrades[4])+Integer.parseInt(yourGrades[4]))/4;
			{
				for(int j = 0;j<students.length-1;j++){
					if(students[j]<=chemPowerIndex){
						counter++;
					}
				}
				if(counter>=100)System.out.print("You have a great chance of getting into your major");
				if(counter<100 && counter>=50)System.out.print("You have a good into your major");
				if(counter<50)System.out.print("You have a bad chance of getting into your major");
			}
		
		}
		
	}

	private void majorDoesntExist() {
		majorCount++;
		if(majorCount>=10){
			ZhenMain.println("YOU ARE HOPELESS STOP USING ME AND I HOPE YOU DONT GET INTO THE MAJOR YOU WANT!");
			inMajorLoop = false;
			ZhenMain.promptForever();
		}
		if(majorCount>=4 && majorCount<10){
			int reponseSelection = (int)(Math.random()*angryResponses.length);
			ZhenMain.println(angryResponses[reponseSelection]);
		}
		if(majorCount<4)
		{
			int reponseSelection = (int)(Math.random()*calmResponses.length);
			ZhenMain.println(calmResponses[reponseSelection]);
		}
	}


	private boolean majorsExist(String userInput) {
		for(int i = 0; i < existingMajors.length ;i++){
			if(ZhenMain.findKeyword(userInput, existingMajors[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}


	public boolean isTriggered(String userInput) {
		String[] triggers = {"majors?","majors","software","media","finance"
				,"college prep","chemistry","bioScience","major"};
		//create a for loop to iterate
		//through your array of triggers
		for(int i = 0; i < triggers.length ;i++){
			if(ZhenMain.findKeyword(userInput,triggers[i],0) >= 0){
				return true;
		}
	}
		return false;
	}
	private void checkOtherTriggers(String input){
		if(ZhenMain.testing.isTriggered(input))
		{
			inMajorLoop = false;
			ZhenMain.println("...*sigh*...");
			ZhenMain.testing.talk();
		}
		if (ZhenMain.grammar.isTriggered(input)){
			inMajorLoop = false;	
			ZhenMain.println("...*sigh*...");
			ZhenMain.grammar.talk();
		}
		else if(ZhenMain.college.isTriggered(input)){
			inMajorLoop = false;
			ZhenMain.println("...*sigh*...");
			ZhenMain.college.talk();
		}
	}
	

}

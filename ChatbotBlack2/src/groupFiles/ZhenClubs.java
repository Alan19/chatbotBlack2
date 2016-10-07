package groupFiles;

public class ZhenClubs implements Chatbot{

	private boolean inTestingLoop;
	private String testingResponse;
	private int calmCounter;
	private String[] calmResponse = {"I don't understand what you mean.", "I can help you with clubs but maybe you need something else.", "I can't do anything if I don't know what you're saying.", "Take some time to think about what you need to ask"};
	private String[] angryResponse = {"Don't you have something better to do?", "You won't be able to stay in a club or team if you act like this.", "Acting like this is a great way to get excluded from trips.", "I'm think you might need to see a psychiatrist.", "You're going to have a hard time getting recommendation letters from your teacher if you keep avoiding the topic."};
	
	@Override
	public void talk() {
		calmCounter = 0;
		inTestingLoop = true;
		while(inTestingLoop){
			//Static call on promptInput method from main class
			ZhenMain.println("Do you need help with your clubs or classes?");
			String[] clubTriggers = {"club", "clubs", "credit", "credits"};
			String[] electiveTriggers = {"elective", "electives", "classes", "class"};
			testingResponse = ZhenMain.promptInput();
			checkOtherTriggers(testingResponse);
			if(triggerArrayCheck(testingResponse, clubTriggers)){
				ZhenMain.println(clubInfo());				
			}
			else if(triggerArrayCheck(testingResponse, electiveTriggers)){
				ZhenMain.println(classInfo());
			}
			else if(calmCounter <= 5){
				ZhenMain.println(calmResponse[ZhenMain.pickRandomElement(calmResponse.length)]);
				calmCounter += 1;
			}
			else{
				ZhenMain.println(angryResponse[ZhenMain.pickRandomElement(angryResponse.length)]);
			}
		}

	}

	private String classInfo() {
		String environmental = "The goal of the AP Environmental Science Course is to provide students with the scientific principles, concepts, and methodologies required to understand the inter-relationships of the natural world, to identify and analyze environmental problems both natural and human-made, to evaluate the relative risks associated with these problems, and to examine alternative solutions for resolving or preventing them.";
		String forensics = "This course will teach you about the Crime Scene, Physical Evidence, Physical Properties: Glass and Soil, Organic Analysis, Inorganic Analysis, The Microscope, Hairs, Fibers and Paint, Drugs, Forensic Technology, Forensic Aspects of Arson and Explosion Investigations, Forensic Serology, DNA: The Indispensable Forensic Science Tool, Fingerprints, Firearms, Tool Marks, Document and Voice Examination, Computer Forensics, Forensic Science and the Internet, and the future of forensic criminology";
		String java = "This course is an introduction Object Oriented programming using JAVA as a platform. In addition to the basic tools of programming, the course consists of Object Oriented Program Design, Program Implementation, Program Analysis, Standard Data Structures, Standard Algorithms, and Computing in Context.";
		String band = "This course is designed to teach the student how to develop the skills necessary to play in a high school level band.  The student should know and will build upon basic music theory and the rudiments of music.";
		String orchestra = "The student will learn fourth position, minor scales, and many professional level exercises. The student will also be introduced to the band instruments, and we will perform in full orchestra format. The student will perform in 2 major concerts per year as well as other special assemblies and events.";
		
		int numberOfFreePeriods;
		String[] courseDescription = {environmental, forensics, java, band, orchestra};
		String[] triggerWords = {"environmental", "forensics", "java", "band", "orchestra"};
		int[] periodsTaken = {2, 1, 2, 1, 1};
		ZhenMain.println("Brooklyn Tech offers many electives. Some of the electives offered are AP Environmental Science, Forensics, Band, Orchestra and AP Java. How many free periods do you have?");
		numberOfFreePeriods = getIntegerInput();
		ZhenMain.println("Which course do you wish to learn about?");
		testingResponse = ZhenMain.promptInput();
		
		for(int i = 0; i < triggerWords.length; i++){
			if(ZhenMain.findKeyword(testingResponse, triggerWords[i], 0) >= 0){
				if(numberOfFreePeriods >= periodsTaken[i]){
					return courseDescription[i];					
				}
				else{
					return courseDescription[i] + " You might not be able to take this course as you do not have enough free periods.";
				}
			}
		}
		if(calmCounter <= 5){
			calmCounter += 1;
			return calmResponse[ZhenMain.pickRandomElement(calmResponse.length)];
		}
		else{
			return angryResponse[ZhenMain.pickRandomElement(angryResponse.length)];
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"classes", "club", "credits", "electives", "diploma", "clubs", "credit", "class", "elective"};
		for(int index = 0; index < triggers.length; index++){
			if(ZhenMain.findKeyword(userInput, triggers[index], 0) >= 0){
				return true;
			}
		}
		return false;
	}

	private static int getNonZeroIntegerInputLessThan8() {
		ZhenMain.println("Please enter a nonzero positive integer that is less than or equal to 8.");
		String integerString = ZhenMain.promptInput();
		boolean isInteger = false;
		boolean isPositive = false;
		int value = 0;
		while(!isInteger || !isPositive){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
				if(value <= 0 || value > 8){
					isPositive = false;
					ZhenMain.println("You must enter a positive integer that is less than or equal to 8.");
					integerString = ZhenMain.promptInput();
				}
				else{
					isPositive = true;
				}
			}catch(NumberFormatException e){
				ZhenMain.println("You must enter a positive integer. You better try again.");
				integerString = ZhenMain.promptInput();
			}
		}
		return value;
	}
	
	private static int getIntegerInputLessThan32() {
		ZhenMain.println("Please enter an non-negative integer less than or equal to 32.");
		String integerString = ZhenMain.promptInput();
		boolean isInteger = false;
		boolean isPositive = false;
		int value = 0;
		while(!isInteger || !isPositive){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
				if(value < 0 || value > 32){
					isPositive = false;
					ZhenMain.println("You must enter an non-negative integer less than or equal to 32.");
					integerString = ZhenMain.promptInput();
				}
				else{
					isPositive = true;
				}
			}catch(NumberFormatException e){
				ZhenMain.println("You must enter an integer. You better try again.");
				integerString = ZhenMain.promptInput();
			}
		}
		return value;
	}
	
	private static int getIntegerInput() {
		ZhenMain.println("Please enter an non-negative integer.");
		String integerString = ZhenMain.promptInput();
		boolean isInteger = false;
		boolean isPositive = false;
		int value = 0;
		while(!isInteger || !isPositive){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
				if(value < 0){
					isPositive = false;
					ZhenMain.println("You must enter an non-negative integer less than or equal to 32.");
					integerString = ZhenMain.promptInput();
				}
				else{
					isPositive = true;
				}
			}catch(NumberFormatException e){
				ZhenMain.println("You must enter an integer. You better try again.");
				integerString = ZhenMain.promptInput();
			}
		}
		return value;
	}

	//Calls club credit algorithm after getting information from user
	private String clubInfo(){
		ZhenMain.println("How many semesters until you graduate?");
		int remainingSemesters = getNonZeroIntegerInputLessThan8();
		ZhenMain.println("How many club credits do you have now?");
		int currentCredits = getIntegerInputLessThan32();
		return getClubCredits(remainingSemesters,currentCredits);
	}

	private String checkPlurality(String word, int number) {
		if(number == 1){
			return word;
		}
		else{
			return word + "s";
		}
	}

	private String getClubCredits(int semesters, int currentCredits){
		int remainingCredits = 32-currentCredits;
		double averageCreditsPerSemester = Math.ceil((double)remainingCredits / semesters);
		int teamNumber;
		int regularClubs;
		if(remainingCredits <= 0){
			return "You don't have to join any clubs this year. However, it's never bad to spend time with students after class if you have the time!";
		}
		else{
			if(averageCreditsPerSemester >= 8){
				teamNumber = (int) Math.floor(averageCreditsPerSemester / 8);
				averageCreditsPerSemester -= (8 * teamNumber);
				regularClubs = (int) Math.ceil(averageCreditsPerSemester / 4);
				int[] clubTypes = {teamNumber, regularClubs};
				//Recommends joining a team if credits are really needed, otherwise, recommends more clubs
				if(regularClubs >= 1 && teamNumber <= 0){
					return "You should join " + clubTypes[0] + checkPlurality(" team", clubTypes[0]) + " this year.";					
				}
				else if(regularClubs <= 0 && teamNumber >= 1){
					return "You should join " + teamNumber + checkPlurality(" team", regularClubs) + " this year.";					
				}
				else{
					return "You should join " + clubTypes[0] + checkPlurality(" team", clubTypes[0]) + " and " + clubTypes[1] + checkPlurality(" club", clubTypes[1]) + " this year.";					
				}
			}
			else{
				regularClubs = (int) Math.ceil(averageCreditsPerSemester / 4);
				return "You should join " + regularClubs + checkPlurality(" club", regularClubs) + " this year.";
			}
		}
	}
	
	private void checkOtherTriggers(String input){
		if(ZhenMain.major.isTriggered(input))
		{
			inTestingLoop = false;
			ZhenMain.println("Although that's not related to the topic...");
			ZhenMain.major.talk();
		}
		else if (ZhenMain.grammar.isTriggered(input)){
			//Exit while loop
			inTestingLoop = false;
			//Go to the school's talk method
			ZhenMain.grammar.talk();
		}
		else if(ZhenMain.college.isTriggered(input)){
			inTestingLoop = false;
			ZhenMain.println("Although that's not related to the topic...");
			ZhenMain.college.talk();
		}
	}
	
	private boolean triggerArrayCheck(String input, String[] triggerList){
		for(int index = 0; index < triggerList.length; index++){
			if(ZhenMain.findKeyword(input, triggerList[index], 0) >= 0){
				return true;
			}
		}
		return false;
	}

}

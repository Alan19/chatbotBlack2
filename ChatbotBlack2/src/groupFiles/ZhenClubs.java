package groupFiles;

public class ZhenClubs implements Chatbot{

	private boolean inTestingLoop;
	private String testingResponse;
	private int calmCounter;
	private String[] calmResponse = {"I don't understand what you mean.", "I can help you with clubs but maybe you need something else.", "I can't do anything if I don't know what you're saying."};
	private String[] angryResponse = {"Don't you have something better to do?", "You won't be able to stay in a club or team if you act like this."};
	
	@Override
	public void talk() {
		calmCounter = 0;
		inTestingLoop = true;
		while(inTestingLoop){
			//Static call on promptInput method from main class
			ZhenMain.println("Do you need help with your clubs or classes?");
			testingResponse = ZhenMain.promptInput();
			checkOtherTriggers(testingResponse);
			if(ZhenMain.findKeyword(testingResponse, "clubs", 0) >= 0 || ZhenMain.findKeyword(testingResponse, "credits", 0) >= 0){
				ZhenMain.println(clubInfo());				
			}
			else if(ZhenMain.findKeyword(testingResponse, "class", 0) >= 0){
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

	@SuppressWarnings("unused")
	private String classInfo() {
		String environmental = "The goal of the AP Environmental Science Course is to provide students with the scientific principles, concepts, and methodologies required to understand the inter-relationships of the natural world, to identify and analyze environmental problems both natural and human-made, to evaluate the relative risks associated with these problems, and to examine alternative solutions for resolving or preventing them.";
		String forensics = "This course will teach you about the Crime Scene, Physical Evidence, Physical Properties: Glass and Soil, Organic Analysis, Inorganic Analysis, The Microscope, Hairs, Fibers and Paint, Drugs, Forensic Technology, Forensic Aspects of Arson and Explosion Investigations, Forensic Serology, DNA: The Indispensable Forensic Science Tool, Fingerprints, Firearms, Tool Marks, Document and Voice Examination, Computer Forensics, Forensic Science and the Internet, and the future of forensic criminology";
		String java = "This course is an introduction Object Oriented programming using JAVA as a platform. In addition to the basic tools of programming, the course consists of Object Oriented Program Design, Program Implementation, Program Analysis, Standard Data Structures, Standard Algorithms, and Computing in Context.";
		String calculus = "This course extends the ideas and techniques of single-variable Calculus into multi-dimensional space.Understanding functions of several variables through geometric and analytic means will be emphasized, and the techniques in the calculus of multi-variable functions will be developed. In addition, the calculus of parametric and vector-valued functions will be explored.";
		
		String[] courseDescription = {environmental, forensics, java, calculus};
		String[] triggerWords = {"environmental", "forensics", "java", "multivariable calculus"};
		ZhenMain.println("Brooklyn Tech offers many electives. Some of the electives offered are AP Environmental Science, Forensics, Multivariable Calculus, and AP Java. Which course do you wish to learn about?");
		testingResponse = ZhenMain.promptInput();
		for(int i = 0; i <= triggerWords.length; i++){
			if(ZhenMain.findKeyword(testingResponse, triggerWords[i], 0) >= 0){
				return courseDescription[i];
			}
			else if(calmCounter <= 5){
				calmCounter += 1;
				return calmResponse[ZhenMain.pickRandomElement(calmResponse.length)];
			}
			else{
				return angryResponse[ZhenMain.pickRandomElement(angryResponse.length)];
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
		String[] triggers = {"classes", "club", "credits", "electives", "diploma", "clubs", "credit", "class"};
		for(int index = 0; index < triggers.length; index++){
			if(ZhenMain.findKeyword(userInput, triggers[index], 0) >= 0){
				return true;
			}
		}
		return false;
	}

	private static int getNonZeroIntegerInput() {
		ZhenMain.println("Please enter a nonzero integer.");
		String integerString = ZhenMain.promptInput();
		boolean isInteger = false;
		boolean isPositive =false;
		int value = 0;
		while(!isInteger || !isPositive){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
				if(value <= 0){
					isPositive = false;
					ZhenMain.println("You must enter a positive integer.");
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
	
	private static int getIntegerInput() {
		ZhenMain.println("Please enter an integer.");
		String integerString = ZhenMain.promptInput();
		boolean isInteger = false;
		boolean isPositive =false;
		int value = 0;
		while(!isInteger || !isPositive){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
				if(value < 0){
					isPositive = false;
					ZhenMain.println("You must enter a nonzero integer.");
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
		int remainingSemesters = getNonZeroIntegerInput();
		ZhenMain.println("How many club credits do you have now?");
		int currentCredits = getIntegerInput();
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
		int averageCreditsPerSemester = (int) Math.ceil(remainingCredits / semesters);
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
				if(regularClubs >= 1){
					return "You should join " + clubTypes[0] + checkPlurality(" team", clubTypes[0]) + " and " + clubTypes[1] + checkPlurality(" club", clubTypes[1]) + " this year.";					
				}
				else{
					return "You should join " + regularClubs + checkPlurality(" club", regularClubs) + " this year.";
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
			ZhenMain.college.talk();
		}
	}

}

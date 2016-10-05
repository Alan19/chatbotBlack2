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
			ZhenMain.println("Type 'quit' to go back");
			testingResponse = ZhenMain.promptInput();
			if(testingResponse.indexOf("quit") >= 0){
				inTestingLoop = false;
				ZhenMain.promptForever();
			}
			else if(testingResponse.indexOf("club") >= 0){
				ZhenMain.println(clubInfo());				
			}
			else if(testingResponse.indexOf("class") >= 0){
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
		
		return null;
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"sleep", "studying", "procrastinating", "kill", "unfair", "sexist", "racist", "change classes", "club"};
		for(int index = 0; index < triggers.length; index++){
			if(userInput.indexOf(triggers[index]) >= 0){
				return true;
			}
		}
		return false;
	}

	private static int getIntegerInput() {
		ZhenMain.println("Please enter an integer.");
		String integerString = ZhenMain.promptInput();
		boolean isInteger = false;
		int value = 0;
		while(!isInteger){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
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
		int remainingSemesters = getIntegerInput();
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
			regularClubs = (int) Math.ceil(averageCreditsPerSemester / 4);
			if(regularClubs > 5){
				regularClubs = 5;
			}
			averageCreditsPerSemester -= regularClubs * 4;
			teamNumber = (int) Math.ceil(averageCreditsPerSemester / 8);
			int[] clubTypes = {teamNumber, regularClubs};
			return "You should join " + clubTypes[0] + " " + checkPlurality("team", clubTypes[0]) + " and " + clubTypes[1] + " " + checkPlurality("club", clubTypes[1]) + " this year.";
		}
	}

}

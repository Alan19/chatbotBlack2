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
			else if(calmCounter <= 5){
				ZhenMain.println(calmResponse[ZhenMain.pickRandomElement(calmResponse.length)]);
				calmCounter += 1;
			}
			else{
				ZhenMain.println(angryResponse[ZhenMain.pickRandomElement(angryResponse.length)]);
			}
		}
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"homework", "sleep", "studying", "procrastinating", "kill", "unfair", "sexist", "racist", "change classes", "club"};
		for(int index = 0; index < triggers.length; index++){
			if(userInput.indexOf(triggers[index]) >= 0){
				return true;
			}
		}
		return false;
	}
	
	//Calls club credit algorithm after getting information from user
	private String clubInfo(){
		ZhenMain.println("How many semesters until you graduate?");
		testingResponse = ZhenMain.promptInput();
		int remainingSemesters = Integer.parseInt(testingResponse);
		ZhenMain.println("and how many club credits do you have now?");
		testingResponse = ZhenMain.promptInput();
		int currentCredits = Integer.parseInt(testingResponse);
		int[] teams = getClubCredits(remainingSemesters,currentCredits);
		return "You should join " + teams[0] + " teams and " + teams[1] + " clubs";
	}
	
	private int[] getClubCredits(int semesters, int currentCredits){
		int remainingCredits = 32-currentCredits;
		int averageCreditsPerSemester = (int) Math.ceil(remainingCredits / semesters);
		System.out.println(averageCreditsPerSemester);
		int teamNumber;
		int regularClubs;
		if(remainingCredits <= 0){
			int[] clubTypes = {0, 0};
			return clubTypes;
		}
		else{
			regularClubs = (int) Math.ceil(averageCreditsPerSemester / 4);
			if(regularClubs > 5){
				regularClubs = 5;
			}
			averageCreditsPerSemester -= regularClubs * 4;
			teamNumber = (int) Math.ceil(averageCreditsPerSemester / 8);
			int[] clubTypes = {teamNumber, regularClubs};
			return clubTypes;
		}
	}

}

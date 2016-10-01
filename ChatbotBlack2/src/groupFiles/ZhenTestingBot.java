package groupFiles;

public class ZhenTestingBot implements Chatbot{

	private boolean inTestingLoop;
	private String testingResponse;
	@Override
	public void talk() {
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
				ZhenMain.println("How many semesters until you graduate?");
				testingResponse = ZhenMain.promptInput();
				int remainingSemesters = Integer.parseInt(testingResponse);
				ZhenMain.println("and how many club credits do you have now?");
				testingResponse = ZhenMain.promptInput();
				int currentCredits = Integer.parseInt(testingResponse);
				int[] teams = getClubCredits(remainingSemesters,currentCredits);
				ZhenMain.println("You should join " + teams[0] + " teams and " + teams[1] + " clubs");
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

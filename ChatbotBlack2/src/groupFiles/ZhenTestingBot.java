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
			else if(testingResponse.indexOf("clubs") >= 0){
				ZhenMain.println("How many semesters until you graduate and how many club credits do you have now?");
				int[] teams = getClubCredits(2,5);
				ZhenMain.println("You should join " + teams[0] + " and " + teams[1] + "clubs");
			}
		}
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"homework", "sleep", "studying", "procrastinating", "kill", "unfair", "sexist", "racist", "change classes"};
		for(int index = 0; index < triggers.length; index++){
			System.out.println(triggers[index] + "," + userInput);
			System.out.println(triggers[index] == userInput);
			if(triggers[index] == userInput){
				System.out.println("Hi!");
				return true;
			}
		}
		return false;
	}
	private int[] getClubCredits(int semesters, int currentCredits){
		int remainingCredits = 32-currentCredits;
		int teamNumber;
		int regularClubs;
		if(remainingCredits <= 0){
			int[] clubTypes = {0, 0};
			return clubTypes;
		}
		else{
			teamNumber = remainingCredits / 8;
			remainingCredits -= teamNumber * 8;
			regularClubs = remainingCredits + 1;
			int[] clubTypes = {teamNumber, regularClubs};
			return clubTypes;
		}
	}

}

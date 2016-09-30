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
		}
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"homework", "sleep", "studying", "procrastinating", "kill", "unfair", "sexist", "racist", "change classes"};
		for(int index = 0; index < triggers.length; index++){
			if(triggers[index] == userInput){
				return true;
			}
		}
		return false;
	}
	private int[] getClubCredits(int semesters, int currentCredits){
		int remainingCredits = 32-currentCredits;
		int teamNumber;
		if(remainingCredits <= 0){
			return 0;
		}
		else{
			teamNumber = remainingCredits / 8;
			
		}
	}

}

package groupFiles;

public class ZhenTestingBot implements Chatbot{

	private boolean inTestingLoop;
	private String testingResponse;
	@Override
	public void talk() {
		inTestingLoop = true;
		while(inTestingLoop){
			//Static call on promptInput method from main class
			ZhenMain.println("Type 'quit' to go back");
			testingResponse = ZhenMain.promptInput();
			if(testingResponse.indexOf("quit") >= 0){
				inTestingLoop = false;
				ZhenMain.promptForever();
			}
			ZhenMain.println("That's my favorite part about school too!");
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

}

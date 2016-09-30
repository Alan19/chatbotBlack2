package groupFiles;

public class AhmedCollege implements Chatbot{
	
	private boolean inCollegeLoop;
	private String collegeResponse;
//	
	public void talk() {
		inCollegeLoop = true;
		while(inCollegeLoop){
			ZhenMain.println("(Type 'quit' to go back.)");
			 //static call on promptInput method from ZhenMain Class
			collegeResponse = ZhenMain.promptInput();
			if(collegeResponse.indexOf("quit") >= 0){
				inCollegeLoop = false;
				ZhenMain.promptForever();
			}
			else{
				ZhenMain.println("I'm glad you're so concerned about your future! " +
						"Tell me about your test scores first.");
			}
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"sat", "act", "college", "future"};
		
		for(int i=0; i < triggers.length; i++){
			if(ZhenMain.findKeyword(userInput, triggers[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}
	
	private String analyzeTestScores(){
		
	}

}

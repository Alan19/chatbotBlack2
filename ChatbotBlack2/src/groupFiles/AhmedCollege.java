package groupFiles;

public class AhmedCollege {
	
//	private boolean inCollegeLoop;
//	private String collegeResponse;
//	
//	public void talk() {
//		inCollegeLoop = true;
//		while(inCollegeLoop){
//			ZhenMain.print("(Type 'quit' to go back.)");
//			 //static call on promptInput method from ZhenMain Class
//			collegeResponse = ZhenMain.promptInput();
//			if(collegeResponse.indexOf("quit") >= 0){
//				inCollegeLoop = false;
//				ZhenMain.promptForever();
//			}
//			else{
//				ZhenMain.print("That answer was wack too.");
//			}
//		}
//	}

	public boolean isTriggered(String userInput) {
		//String[] triggers = {"SAT", "ACT", "college"};
		//can use for to iterate thru array and input
		
		if(ZhenMain.findKeyword(userInput, "college", 0) >= 0){
			return true;
		}
		if(ZhenMain.findKeyword(userInput, "SAT", 0) >= 0){
			return true;
		}
		return false;
	}

}

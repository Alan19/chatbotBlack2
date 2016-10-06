package groupFiles;

public class AhmedCollege implements Chatbot{
	
private boolean inCollegeLoop;
	private String collegeResponse;
	private int testScore;
	private int average;
	
	private String[] scoreInsults = {"That low?", "May I suggest Clown College?", "I hope you have some sort of talent to compensate.", "You ever see those get rich quick ads? Take up their offer."};
	private String[] scoreCompliments = {"Hey, that's pretty good!", "Wow, are you Einstein's reincarnate?", "Neat!", "Cool beans!"};
	private String[] scoreIndifferents = {"That aiiii.", "Hmm.", "That's okay I guess", "Wow, that's an A for average."};
	
	private String[] reachSchools = {"Harvard", "Yale", "MIT"};//each school type will have grade requirements
	private String[] matchSchools = {"Stonybrook", "", ""};
	private String[] safetySchools = {"", "", ""};
	
	//idea: have bot ask what college the user wants to attend, if not in array
	//add it by asking if it a reach, match, or safety
	public void talk() { 
		inCollegeLoop = true;
		AhmedMain.print("I'm glad you're concerned about college. Let's start off by telling me your standardized test scores.");
		while(inCollegeLoop){
			collegeResponse = AhmedMain.promptInput();
			scoreResponse(collegeResponse);
		}
	}
	
	private void scoreResponse(String input){ //could be condensed/abstracted
		testScore = getTestScore(input);
		System.out.println(testScore); //change test score upon asking for which test
		if(AhmedMain.findKeyword(input, "ACT", 0) >= 0){
			if(testScore < 30){
				int responseIndex = (int)(Math.random()*scoreInsults.length);
				AhmedMain.print(scoreInsults[responseIndex]);
			}
			else if(testScore >= 30 && testScore <=33){
				int responseIndex = (int)(Math.random()*scoreIndifferents.length);
				AhmedMain.print(scoreIndifferents[responseIndex]);
			}
			else{
				int responseIndex = (int)(Math.random()*scoreCompliments.length);
				AhmedMain.print(scoreCompliments[responseIndex]);
			}
		}
		else if(AhmedMain.findKeyword(input, "SAT", 0) >= 0){
			if(testScore < 1150){
				int responseIndex = (int)(Math.random()*scoreInsults.length);
				AhmedMain.print(scoreInsults[responseIndex]);
			}
			else if(testScore >= 1150 && testScore <= 1480){
				int responseIndex = (int)(Math.random()*scoreIndifferents.length);
				AhmedMain.print(scoreIndifferents[responseIndex]);
			}
			else{
				int responseIndex = (int)(Math.random()*scoreCompliments.length);
				AhmedMain.print(scoreCompliments[responseIndex]);
			}
		}
		else{
			AhmedMain.print("Which test?"); //needs refining
		}
	}
	
	
	private int getTestScore(String input){
		int scorePos = -1;
		String testScore = "";
		String currentInput = input; //turns out this wasn't needed
		String[] numeralStrings = {"0","1","2","3","4","5","6","7","8","9"};
		
		for(int i=0; i<currentInput.length()-1; i++){	
			String firstChar = currentInput.substring(i,i+1);
			
			if(scorePos < 0){
				for(int j=0; j<numeralStrings.length; j++){
					if(firstChar.equals(numeralStrings[j])){
						scorePos = currentInput.indexOf(firstChar);
						break;
					}
				}
			}
		}
		if(scorePos > -1){
			String[] punctuationArr = {",", ".", "?", " ", "!"};
			int punctuationIndex = -1;
			String parsedInput = currentInput.substring(scorePos);
			
			for(int i=0; i<punctuationArr.length; i++){
				if(AhmedMain.findKeyword(parsedInput, punctuationArr[i], 0) >= 0){
					punctuationIndex = parsedInput.indexOf(punctuationArr[i]);
					break;
				}
			}
			if(punctuationIndex > -1)
				testScore = parsedInput.substring(0, punctuationIndex);
			else
				testScore = parsedInput;
			return Integer.parseInt(testScore);
		}
		else{
			return -1;
		}
	}

	public boolean isTriggered(String userInput) {
		String[] triggers = {"college", "my future", "university"};
		for(int i=0; i<triggers.length; i++){
			if(AhmedMain.findKeyword(userInput, triggers[i], 0) >= 0)
				return true;
		}
		return false;
	}
}

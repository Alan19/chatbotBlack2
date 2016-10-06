package groupFiles;

public class AhmedCollege implements Chatbot{
	
private boolean inCollegeLoop;
	private String collegeResponse;
	private int testScore = 0;
	private int average = 0;
	private String testTaken;
	
	private String[] scoreInsults = {"That low?", "May I suggest Clown College?", "I hope you have some sort of talent to compensate.", "You ever see those get rich quick ads? Take up their offer."};
	private String[] scoreCompliments = {"Hey, that's pretty good!", "Wow, are you Einstein's reincarnate?", "Neat!", "Cool beans!"};
	private String[] scoreIndifferents = {"That aiiii.", "Hmm.", "That's okay I guess", "Wow, that's an A for average."};
	private String[] scoreImpossible = {"There's no need to lie to protect your fragile ego.", ""};
	
	private String[] impatientResponses = {"Cmon now, let's cooperate.", ""};
	
	private String[] reachSchools = {"Harvard", "Yale", "MIT"};//each school type will have grade requirements
	private String[] matchSchools = {"Stonybrook", "Match University", "Just Right School"};
	private String[] safetySchools = {"Community College", "ITT Tech", "School for the Safe and Talented"};
	
	//idea: have bot ask what college the user wants to attend, if not in array
	//add it by asking if it a reach, match, or safety
	public void talk(){
		inCollegeLoop = true;
		ZhenMain.println("I'm glad you're concerned about college!!!!11!!one!!");
		while(inCollegeLoop){
			ZhenMain.println("What would you like to know about college?");
			collegeResponse = ZhenMain.promptInput();
			if(ZhenMain.findKeyword(collegeResponse, "colleges", 0) >= 0)
				scoreResponse(collegeResponse);
			if(ZhenMain.findKeyword(collegeResponse, "test", 0) >= 0)
				scoreResponse(collegeResponse);
		}
	}
	
	private void scoreResponse(String input){ //could be condensed/abstracted
		testScore = getTestScore(collegeResponse);
		if(ZhenMain.findKeyword(input, "ACT", 0) >= 0 && testScore > -1){
			if(testScore < 30){
				int responseIndex = (int)(Math.random()*scoreInsults.length);
				ZhenMain.println(scoreInsults[responseIndex]);
			}
			else if(testScore >= 30 && testScore <= 33){
				int responseIndex = (int)(Math.random()*scoreIndifferents.length);
				ZhenMain.println(scoreIndifferents[responseIndex]);
			}
			else{
				int responseIndex = (int)(Math.random()*scoreCompliments.length);
				ZhenMain.println(scoreCompliments[responseIndex]);
			}
		}
		else if(ZhenMain.findKeyword(input, "SAT", 0) >= 0 && testScore > -1){
			if(testScore < 1150){
				int responseIndex = (int)(Math.random()*scoreInsults.length);
				ZhenMain.println(scoreInsults[responseIndex]);
			}
			else if(testScore >= 1150 && testScore <= 1480){
				int responseIndex = (int)(Math.random()*scoreIndifferents.length);
				ZhenMain.println(scoreIndifferents[responseIndex]);
			}
			else{
				int responseIndex = (int)(Math.random()*scoreCompliments.length);
				ZhenMain.println(scoreCompliments[responseIndex]);
			}
		}
		else{
			ZhenMain.println("Which test?");
			collegeResponse = ZhenMain.promptInput();
			testTaken = collegeResponse;
			scoreResponse(testTaken);
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
				if(ZhenMain.findKeyword(parsedInput, punctuationArr[i], 0) >= 0){
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
		String[] triggers = {"college", "my future", "university", "sat", "act"};
		for(int i=0; i<triggers.length; i++){
			if(ZhenMain.findKeyword(userInput, triggers[i], 0) >= 0)
				return true;
		}
		return false;
	}
	
	private void checkOtherTriggers(String input){
		if(ZhenMain.major.isTriggered(input))
		{
			inCollegeLoop = false;
			ZhenMain.major.talk();
		}
		else if (ZhenMain.grammar.isTriggered(input)){
			inCollegeLoop = false;	
			ZhenMain.grammar.talk();
		}
		else if(ZhenMain.clubs.isTriggered(input)){
			inCollegeLoop = false;
			ZhenMain.clubs.talk();
		}
	}


}

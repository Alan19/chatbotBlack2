package groupFiles;

public class AhmedCollege implements Chatbot{
	
private boolean inCollegeLoop;
	private String collegeResponse;
	private int testScore = -1;
	private String testTaken;
	private int interestCounter;
	
	private String[] scoreInsults = {"That low?", "May I suggest Clown College?", "I hope you have some sort of talent to compensate.", "You ever see those get rich quick ads? Take up their offer."};
	private String[] scoreCompliments = {"Hey, that's pretty good!", "Wow, are you Einstein's reincarnate?", "Neat!", "Cool beans!"};
	private String[] scoreIndifferents = {"That aiiii.", "Hmm.", "That's okay I guess", "Wow, that's an A for average."};
	private String[] scoreImpossible = {"There's no need to lie to protect your fragile ego.", "'Lying is pretty bad' -Confucious probably", "I will send you to the dean for lying."};
	
	private String[] annoyedResponses = {"Cmon now, work with me.", "Make some sense you neanderthal.", "Let's stop playing games."};
	
	private String[][] collegeArray = {{"Harvard", "Yale", "MIT"}, {"Stonybrook", "Match University", "Just Right School"}, {"Community College", "ITT Tech", "School for the Safe and Talented"}};
	
	private String[][] collegeStatements = {{" is quite the competitive school.", " has a really low acceptance rate. You better be good.", " will be difficult to be admitted into."},{" has decent facilities."," is pretty ight.", " has a fair admission rate."}, {" is alright, I guess.", " is pretty easy to get into.", " is light."}};
	
	public void talk(){
		inCollegeLoop = true;
		interestCounter = 2;
		ZhenMain.println("I'm glad you're concerned about college!!!!11!!one!!");
		while(inCollegeLoop){
			ZhenMain.println("What would you like to know about college?");
			collegeResponse = ZhenMain.promptInput();
			checkOtherTriggers(collegeResponse);
			
			if(interestCounter > 0){
				if(ZhenMain.findKeyword(collegeResponse, "colleges", 0) >= 0)
					uniResponse();
				else if(ZhenMain.findKeyword(collegeResponse, "tests", 0) >= 0)
					scoreResponse();
				else{
					interestCounter--;
					ZhenMain.println(annoyedResponses[(int)(Math.random()*annoyedResponses.length)] + "If you're still interested, please respond in such a way I can understand you.");
				}
			}
			else{
				ZhenMain.println("Alright, you're clearly having an aneurysm and you're about to give me one too. Let's start this over.");
				inCollegeLoop = false;
				ZhenMain.promptForever();
			}
		}
	}
	
	private void uniResponse(){
		ZhenMain.println("What college or school do you have in mind?");
		String uniAnswer = ZhenMain.promptInput();
		boolean foundResponse = false;
		
		for(int i=0;i<collegeArray.length; i++){
			for(int j=0;j<collegeArray[i].length;j++){
				if(ZhenMain.findKeyword(uniAnswer, collegeArray[i][j], 0) >= 0){
					ZhenMain.println(collegeArray[i][j] + collegeStatements[i][(int)(Math.random()*collegeStatements[i].length)]);
					foundResponse = true;
					break;
				}
			}
		}
		
		if(foundResponse == false){
			ZhenMain.println("Hmm, I've never heard of that. Would you classify it as a 'reach', 'match', or a 'safety'?");
			String typeAnswer = ZhenMain.promptInput();
			
			if(ZhenMain.findKeyword(typeAnswer, "reach", 0) >= 0){
				collegeArray[0] = addString(collegeArray[0], uniAnswer);
				System.out.println(collegeArray[0][3]);
				ZhenMain.println("That's good to know.");
			}
			else if(ZhenMain.findKeyword(typeAnswer, "match", 0) >= 0){
				collegeArray[1] = addString(collegeArray[1], uniAnswer);
				ZhenMain.println("I'll remember that");
			}
			else if(ZhenMain.findKeyword(typeAnswer, "safety", 0) >= 0){
				collegeArray[2] = addString(collegeArray[2], uniAnswer);
				System.out.println(collegeArray[2]);
				ZhenMain.println("Thanks for the info.");
			}
			else{
				ZhenMain.println("I don't understand what you're saying. I'll figure it out on my own.");
			}
		}
	}
	
	private void scoreResponse(){ 
		String testResponse;
		ZhenMain.println("So tell me what scores you got on your standardized test.");
		testResponse = ZhenMain.promptInput();
		
		if(testScore == -1 && testTaken == null){
			testScore = getTestScore(testResponse);
			if(ZhenMain.findKeyword(testResponse, "ACT", 0) >= 0 && testScore > -1){
				testTaken = "ACT";
				if(testScore < 30){
					int responseIndex = (int)(Math.random()*scoreInsults.length);
					ZhenMain.println(scoreInsults[responseIndex]);
				}
				else if(testScore >= 30 && testScore <= 33){
					int responseIndex = (int)(Math.random()*scoreIndifferents.length);
					ZhenMain.println(scoreIndifferents[responseIndex]);
				}
				else if(testScore > 36){
					int responseIndex = (int)(Math.random()*scoreImpossible.length);
					ZhenMain.println(scoreImpossible[responseIndex]);
				}
				else{
					int responseIndex = (int)(Math.random()*scoreCompliments.length);
					ZhenMain.println(scoreCompliments[responseIndex]);
				}
			}
			else if(ZhenMain.findKeyword(testResponse, "SAT", 0) >= 0 && testScore > -1){
				testTaken = "SAT";
				if(testScore < 1150){
					int responseIndex = (int)(Math.random()*scoreInsults.length);
					ZhenMain.println(scoreInsults[responseIndex]);
				}
				else if(testScore >= 1150 && testScore <= 1480){
					int responseIndex = (int)(Math.random()*scoreIndifferents.length);
					ZhenMain.println(scoreIndifferents[responseIndex]);
				}
				else if(testScore > 1600){
					int responseIndex = (int)(Math.random()*scoreImpossible.length);
					ZhenMain.println(scoreImpossible[responseIndex]);
				}
				else{
					int responseIndex = (int)(Math.random()*scoreCompliments.length);
					ZhenMain.println(scoreCompliments[responseIndex]);
				}
			}
			else{
				testScore = -1;
				ZhenMain.println("I'm a little slow today so next time you answer this will you say your score and test in the same sentence? For me of course, not for any other reason.");
			}
		}
		else{
			ZhenMain.println("Wait, you've already told me your test score!!! You got a " + testScore + " on the " + testTaken + ".");
		}
	}
	
	private static String[] addString(String[] array, String newStr){
	    String[] newArr = new String[array.length + 1];
  
	    for (int i = 0; i < array.length; i++){
	        newArr[i] = array[i];
	    }   
	    newArr[newArr.length - 1] = newStr;

	    return newArr;
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
				if(parsedInput.indexOf(punctuationArr[i]) >= 0){
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
		else if(ZhenMain.testing.isTriggered(input)){
			inCollegeLoop = false;
			ZhenMain.testing.talk();
		}
	}

}

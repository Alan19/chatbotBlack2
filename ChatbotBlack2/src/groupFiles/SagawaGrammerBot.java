package groupFiles;


public class SagawaGrammerBot implements Chatbot {

	private boolean inGrammerLoop;
	private String grammerResponse;
	private int grammerCount;
	private String[] escalatingResponses = {"Say Sorry", "Look, just say you're sorry", "...is it that hard to say sorry?", "Here, let me spell it for you: S-o-r-r-y.", "I'm done talking with you. Come back when you want to apologize.", "..."};
	public SagawaGrammerBot(){
		grammerCount = 0;
	}

	public void talk() {
		inGrammerLoop = true;
		grammerCount = 0;
		while(inGrammerLoop){
			grammerResponse = ZhenMain.promptInput();
			checkOtherTriggers(grammerResponse);
			int lowerCase = ZhenMain.findKeyword(grammerResponse,  "sorry", 0);
			ZhenMain.println(escalatingResponses[grammerCount]);
			if((lowerCase >= 0 && noNegations(grammerResponse, lowerCase))){
				ZhenMain.println("Apology accepted.");
				inGrammerLoop = false;
				ZhenMain.promptForever();
			}
			if (grammerCount < 5){
				grammerCount++;
			}
			
		}
	}
	
	
	//we
	@Override
	public boolean isTriggered(String userInput) {
		if (ZhenMain.findKeyword(userInput,  "your",  0) >= 0){
			int yourPsn = ZhenMain.findKeyword(userInput,  "your",  0);
			String checkStringA = userInput.substring(yourPsn, yourPsn+3);
			String checkStringThe = userInput.substring(yourPsn, yourPsn+5);
			if (checkStringA.equals(" a ") || checkStringA.equals(" A ")){
				ZhenMain.println("Oh my! Please apologize for your bad grammer - unless you meant to say I OWN a " + errorFragment(userInput));
				return true;
			}
			if (checkStringThe.toLowerCase().equals(" the ")){
				ZhenMain.println("Oh my! Please apologize for your bad grammer - unless you meant to say I OWN a " + errorFragment(userInput));
				return true;
			}
		}
		return false;
	}
	
	private static String errorFragment(String searchString) {
		int yourPsn = ZhenMain.findKeyword(searchString,  "your",  0);
		int locationOfSpace1 = 0;
		int locationOfSpace2 = 0;
		int locationOfSpace3 = 0;
		for (int i = yourPsn; i < searchString.length(); i++){
			if (searchString.substring(i, i+1) == " "){
				locationOfSpace1 = i+1;
				break;
			}
		}
		for (int i = yourPsn+locationOfSpace1; i < searchString.length(); i++){
			if (searchString.substring(i, i+1) == " "){
				locationOfSpace2 = i+1;
				break;
			}
		}
		for (int i = yourPsn+locationOfSpace2; i < searchString.length(); i++){
			if (searchString.substring(i, i+1) == " "){
				locationOfSpace3 = i+1;
				break;
			}
		}
		return searchString.substring(locationOfSpace2, (locationOfSpace3 - 1));
	}
	
	private static boolean noNegations(String searchString, int psn) {
		if((psn - 6 >= 0) && searchString.substring(psn-6, psn-1).equals(" not ")){
			return false;
		}
		return true;
	}
	
	private void checkOtherTriggers(String input){
		if(ZhenMain.major.isTriggered(input))
		{
			inGrammerLoop = false;
			ZhenMain.println("...*sigh*...");
			ZhenMain.major.talk();
		}
		else if (ZhenMain.testing.isTriggered(input)){
			inGrammerLoop = false;	
			ZhenMain.println("...*sigh*...");
			ZhenMain.testing.talk();
		}
		else if(ZhenMain.college.isTriggered(input)){
			inGrammerLoop = false;
			ZhenMain.println("...*sigh*...");
			ZhenMain.college.talk();
		}
	}

}

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
			if((lowerCase >= 0)){
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
		if (ZhenMain.findKeyword(userInput,  "your",  0) >= 0 && userInput.length() > 8){
			int yourPsn = ZhenMain.findKeyword(userInput,  "your",  0);
			String checkStringA = userInput.substring(yourPsn+4, yourPsn+7);
			String checkStringThe = userInput.substring(yourPsn+4, yourPsn+9);
			if (checkStringA.equals(" a ") || checkStringA.equals(" A ")){
				ZhenMain.println("Oh my! Please apologize for your bad grammer - unless you meant to say I OWN " + errorFragment(userInput));
				return true;
			}
			if (checkStringThe.toLowerCase().equals(" the ")){
				ZhenMain.println("Oh my! Please apologize for your bad grammer - unless you meant to say I OWN " + errorFragment(userInput));
				return true;
			}
		}
		return false;
	}
	
	private static String errorFragment(String searchString) {
		int yourPsn = ZhenMain.findKeyword(searchString,  "your",  0);
		int notThis = yourPsn + 5;
		return searchString.substring(notThis, searchString.length());
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

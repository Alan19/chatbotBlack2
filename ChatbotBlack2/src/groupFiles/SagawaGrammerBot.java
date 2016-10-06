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
		ZhenMain.println("Oh my! Please apologize for your bad grammer - unless you meant to say I OWN a ");
		grammerCount = 0;
		while(inGrammerLoop){
			grammerResponse = ZhenMain.promptInput();
			int lowerCase = ZhenMain.findKeyword(grammerResponse,  "sorry", 0);
			ZhenMain.println(""+lowerCase);
			if((lowerCase >= 0 && noNegations(grammerResponse, lowerCase))){
				ZhenMain.println("Apology accepted.");
				inGrammerLoop = false;
				ZhenMain.promptForever();
			}
			ZhenMain.println(escalatingResponses[grammerCount]);
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
				//ZhenMain.println(errorFragment(userInput));
				return true;
			}
			if (checkStringThe.toLowerCase().equals(" the ")){
				//ZhenMain.println(errorFragment(userInput));
				return true;
			}
		}
		return false;
	}
	
	private static String errorFragment(String searchString) {
		int yourPsn = ZhenMain.findKeyword(searchString,  "your",  0);
		int spaceCount = 0;
		int trackerNumber = 1;
		int locationOfSpace = 0;
		int locationOfSpace2 = 0;
		while (spaceCount < 2 && locationOfSpace < searchString.length()){
			locationOfSpace = yourPsn + trackerNumber;
			if (searchString.substring((yourPsn + (trackerNumber-1)), (yourPsn + trackerNumber)) == " ") {
				spaceCount++;
			}
			trackerNumber++;
		}
		while (spaceCount < 3 && locationOfSpace < searchString.length()){
			locationOfSpace2 = yourPsn + trackerNumber;
			if (searchString.substring(yourPsn + (trackerNumber-1), yourPsn + trackerNumber) == " ") {
				spaceCount++;
			}
			trackerNumber++;
		}
		return searchString.substring(locationOfSpace, (locationOfSpace2 - 1));
	}
	
	private static boolean noNegations(String searchString, int psn) {
		if((psn - 6 >= 0) && searchString.substring(psn-6, psn-1).equals(" not ")){
			return false;
		}
		return true;
	}

}

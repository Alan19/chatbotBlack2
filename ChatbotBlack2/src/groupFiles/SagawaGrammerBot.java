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
		ZhenMain.println("Oh my! Please apologize for your bad grammer - ");
		grammerCount = 0;
		while(inGrammerLoop){
			grammerResponse = ZhenMain.promptInput();
			int lowerCase = grammerResponse.indexOf("sorry");
			ZhenMain.println(""+lowerCase);
			int upperCase = grammerResponse.indexOf("Sorry");
			if((lowerCase >= 0 && noNegations(grammerResponse, lowerCase)) || (upperCase >= 0 && noNegations(grammerResponse, upperCase))){
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
			System.out.println(checkStringA);
			String checkStringThe = userInput.substring(yourPsn, yourPsn+5);
			if (checkStringA.equals(" a ") || checkStringA.equals(" A ")){
				return true;
			}
			if (checkStringThe.toLowerCase().equals(" the ")){
				return true;
			}
		}
		return false;
	}
	
	private static boolean noNegations(String searchString, int psn) {
		if((psn - 6 >= 0) && searchString.substring(psn-6, psn).equals("not ")){
			return false;
		}
		return true;
	}

}

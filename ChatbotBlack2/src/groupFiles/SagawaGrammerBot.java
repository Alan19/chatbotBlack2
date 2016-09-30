package groupFiles;


public class SagawaGrammerBot implements Chatbot {

	private boolean inGrammerLoop;
	private String grammerResponse;

	public void talk() {
		inGrammerLoop = true;
		ZhenMain.println("That was a bad use of 'your'. Apologize");
		while(inGrammerLoop){
			grammerResponse = ZhenMain.promptInput();
			if(grammerResponse.indexOf("I'm sorry") >= 0){
				ZhenMain.println("Apology accepted.");
				inGrammerLoop = false;
				ZhenMain.promptForever();
			}
			ZhenMain.println("Apologize");
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

}

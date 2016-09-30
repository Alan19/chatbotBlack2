package groupFiles;


public class SagawaGrammerBot implements Chatbot {

	private boolean inGrammerLoop;
	private String grammerResponse;

	public void talk() {
		inGrammerLoop = true;
		ZhenMain.println("That was a bad use of 'your'. Apologize");
		while(inGrammerLoop){
			ZhenMain.println("Checkmate.");
			grammerResponse = ZhenMain.promptInput();
			if(grammerResponse.indexOf("I'm sorry") >= 0){
				ZhenMain.println("Apology accepted. How are you?");
				inGrammerLoop = false;
				ZhenMain.promptForever();
			}
			ZhenMain.println("Apologize");
		}
	}
	//w
	@Override
	public boolean isTriggered(String userInput) {
		System.out.println("check");
		if (ZhenMain.findKeyword(userInput,  "your",  0) >= 0){
			System.out.println("check");
			int yourPsn = ZhenMain.findKeyword(userInput,  "your",  0);
			String checkStringA = userInput.substring(yourPsn+4, yourPsn+7);
			String checkStringThe = userInput.substring(yourPsn+4, yourPsn+9);
			if (checkStringA.equals(" a ") || checkStringA.equals(" A ")){
				System.out.println("check");
				return true;
			}
			if (checkStringThe.toLowerCase().equals(" the ")){
				System.out.println("check");
				return true;
			}
		}
		return false;
	}

}

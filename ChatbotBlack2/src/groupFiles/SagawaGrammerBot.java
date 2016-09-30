package groupFiles;

public class SagawaGrammerBot implements Chatbot {

	private String grammerResponse;
	private boolean inGrammerLoop;
	
	private String[] calmResponses = {"We already said hello. Let's move the conversation along", "You said hello already. Did you forget?"};
	private String[] angryResponses = {"Let's talk about something else already", "...", "stop it stop it stop it", "HoW wAS YOur DAY? WaIT LET mE GuesS: HELLo, righT?"};
	
	private int grammerCount;

	public SagawaGrammerBot(){
		grammerCount = 0;
	}
	
	public void talk() {
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		if (ZhenMain.findKeyword(userInput,  "your",  0) >= 0){
			int yourPsn = ZhenMain.findKeyword(userInput,  "your",  0);
			String checkStringA = userInput.substring(yourPsn, yourPsn+3);
			String checkStringThe = userInput.substring(yourPsn, yourPsn+5);
			String checkStringTheRight = checkStringThe.toLowerCase();
			if (checkStringA.equals(" a ") || checkStringA.equals(" A ")){
				return true;
			}
			if (checkStringTheRight.equals(" the ")){
				return true;
			}
		}
		return false;
	}

}

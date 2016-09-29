package groupFiles;

public class SagawaGrammerBot implements Chatbot {

	private String grammerResponse;
	private boolean inGrammerLoop;
	
	private String[] calmResponses = {"We already said hello. Let's move the conversation along", "You said hello already. Did you forget?"};
	private String[] angryResponses = {"Let's talk about something else already", "...", "stop it stop it stop it", "HoW wAS YOur DAY? WaIT LET mE GuesS: HELLo, righT?"};
	
	private int grammerCount;

	public SagawaGrammerBot(){
		helloCount = 0;
}
	
	public void talk() {
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		// TODO Auto-generated method stub
		return false;
	}

}

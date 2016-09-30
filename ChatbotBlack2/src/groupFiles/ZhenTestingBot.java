package groupFiles;

public class ZhenTestingBot implements Chatbot{

	private boolean inTestingLoop;
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"homework", "sleep", "studying", "procrastinating", "kill", "unfair", "sexist", "racist", "change classes"};
		for(int index = 0; index < triggers.length; index++){
			if(triggers[index] == userInput){
				inTestingLoop = true;
				break;
			}
		}
		return false;
	}

}

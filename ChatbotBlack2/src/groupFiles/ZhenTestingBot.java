package groupFiles;

public class ZhenTestingBot implements Chatbot{

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"homework", "sleep", "studying", "procrastinating", "kill", "unfair", "sexist", "racist", "change classes"};
		
		return false;
	}

}

package groupFiles;

import java.util.Scanner;

public class ZhenMain {
	static String response;
	static boolean inMainLoop;
	static Scanner input;
	static String user;

	static Chatbot major;
	static Chatbot testing;
	static Chatbot grammar;
	static Chatbot college;

	
	//List all the chatbots available under this class
	
	//Add group chatbots below (see example)
	//static Chatbot school;
	
	public static void main(String[] args) {
		//demonstrateStringMethods();
		createFields();
		promptName();
		promptForever();
	}
	
	public static void promptName() {
		println("Enter your name");
		user = input.nextLine();
		println("Glad to meet you " + user + ".For the rest of time, I will always call you " + user + ".You may call me computer. We should become friends.");
	}

	public static void promptForever() {
		inMainLoop = true;
		while(true){
			println("Hi, " + user + ". How are you?");
			response = promptInput();
			if(findKeyword(response, "good", 0) >= 0){
				println("That's wonderful. So glad you feel good.");
			}

			else if(major.isTriggered(response))
			{
				inMainLoop = false;
			}
			else if (grammar.isTriggered(response)){
				//Exit while loop
				inMainLoop = false;
				
				//Go to the school's talk method
				grammar.talk();
			}
			else if(testing.isTriggered(response)){
				inMainLoop = false;
				testing.talk();
			}
			else if(college.isTriggered(response)){
				inMainLoop = false;
				college.talk();

			}
			else{
				println("I don't understand");
			}
		}
	}
	
	public static int findKeyword(String searchString, String keyword, int startPSN) {
		searchString = searchString.trim();
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		System.out.println("The phrase is " + searchString);
		System.out.println("The keyword is " + keyword);
		int psn = searchString.indexOf(keyword);
		System.out.println("The keyword was found at " + psn);
		//Keep searching until context keyword found
		while(psn >= 0){
			//Assume preceded and followed by space
			String before = "";
			String after = "";
			//Check character in front if it exists
			if(psn > 0){
				before = searchString.substring(psn - 1, psn);
				System.out.println("the character before is " + before);
			}
			//Check if there is a character after the keyword
			if(psn + keyword.length() < searchString.length()){
				after = searchString.substring(psn =  keyword.length(), psn + keyword.length() + 1);
				System.out.println("the character after is " + after);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0 &&  noNegations(searchString, psn)){
				System.out.println("Found " + keyword + " at " + psn);
				return psn;
			}
			else{
				psn = searchString.indexOf(keyword, psn+1);
				System.out.println("Did not find " + keyword + " checking position " + psn);
			}
		}
		return -1;
	}

	private static boolean noNegations(String searchString, int psn) {
		/**This is a helper method. A helper method is a method designed for helping designed for "helping" a larger method. Because of this, helper methods are generally private because they are only used used by the methods they are helping. Also, the project is expected to have a lot of helper methods because they make code more READABLE
		 */
		//Check to see if the word "no " is in the front of psn
		//Check to see if there are 3 spaces in front then check to see if "no " is there
		if((psn - 3 >= 0) && searchString.substring(psn-3, psn).equals("no ")){
			return false;
		}
		//Check for "not "
		if((psn - 6 >= 0) && searchString.substring(psn-6, psn).equals("not ")){
			return false;
		}
		//Check for "never "
		if((psn - 4 >= 0) && searchString.substring(psn-4, psn).equals("never ")){
			return false;
		}
		return true;
	}

	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
	}
	
	public static void createFields() {
		input = new Scanner(System.in);
		user = "";
		
		//Initialize group chatbots below
		grammar = new SagawaGrammerBot();
		testing = new ZhenTestingBot();
		college = new AhmedCollege();
		major = new JaviyMajor();
	}
	
	public static void println(String s){
		String printString = "";
		int cutoff = 500;
		//Check for words to add or s has a length > 0
		while(s.length() > 0){
			String cut = "";
			String nextWord = "";
			//Check to see if the next word will fit on the line AND there must still be words to add
			while(cut.length() + nextWord.length() < cutoff && s.length() > 0){
				//Adds the next word to the line
				cut += nextWord;
				
				s = s.substring(nextWord.length());
				
				//Identify the following word without the space
				int endOfWord = s.indexOf(" ");
				//If there are no more spaces, this is the last word so add the whole thing
				if(endOfWord == -1){
					endOfWord = s.length() - 1;
				}
				
				nextWord = s.substring(0, endOfWord + 1);
			}
			printString += cut + "\n";
		}
		
		System.out.println(printString);
	}
	
	public static int pickRandomElement(int end){
		return (int) Math.random()*end; 
	}

}

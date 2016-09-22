package introduction;

import java.util.Scanner;

public class StringPractice {
	
	static Scanner input;
	static String user;
	
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
		while(true){
			promptInput();
		}
	}
	
	public static void promptInput() {
		println("Please type something " + user);
		String userInput = input.nextLine();
		println("Congratulations! You typed: " + userInput);
	}
	
	public static void createFields() {
		input = new Scanner(System.in);
		user = "";
		
	}
	
	public static void println(String s){
		String printString = s;
		int cutoff = 20;
		if(printString.length() > cutoff){
			for(int i = 0; i*cutoff < s.length(); i++){
				printString += getCut(s, cutoff, i+1) + "\n";
			}
		}
		
		System.out.println(printString);
	}

	private static String getCut(String s, int cutoff, int cut){
		int cutIndex = cut * cutoff;
		if(cutIndex > s.length()) cutIndex = s.length();
		String currentCut = s.substring(0, cutIndex);
		int indexOfLastSpace = currentCut.length()-1;
		for(int i = currentCut.length()-1; i >= 0; i--){
			String letter = currentCut.substring(i, i+1);
			if(letter.equals(" ")){
				indexOfLastSpace = i;
				break;
			}
		}
		currentCut = currentCut.substring(0, indexOfLastSpace - 1);
		return currentCut;
	}
	public static void demonstrateStringMethods(){
		String text1 = new String("Hello World");
		String text2 = "Hello World";
		
		if(text1.equals(text2)){
			System.out.println("These strings are equal");			
		}
		println(text1);
		
		String word1 = "Aardvark";
		String word2 = "Zyzzyva";
		
		if(word1.compareTo(word2) < 0){
			println("Word 1 comes before Word 2");
		}
	}
}

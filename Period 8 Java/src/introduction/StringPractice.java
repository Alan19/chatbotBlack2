package introduction;

public class StringPractice {

	public static void main(String[] args) {
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
	public static void println(String s){
		System.out.println(s);
	}

}

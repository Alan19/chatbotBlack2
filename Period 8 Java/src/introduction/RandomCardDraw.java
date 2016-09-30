package introduction;

public class RandomCardDraw {

	public static void main(String[] args) {
		String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};
		String[] cards = {"Jack", "Queen", "King", "Ace", "Two", "Three", "Four" , "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
		System.out.println("The " + cards[generateZeroToThirteen()] + " of " + suits[generateZeroToThree()]);
	}
	
	public static int generateZeroToThree(){
		double rand = (Math.random()*4);
		int num = (int) rand;
		return num;
	}
	public static int generateZeroToThirteen(){
		double rand = (Math.random()*13);
		int num = (int) rand;
		return num;
	}
}

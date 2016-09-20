package introduction;

public class RandomDiceRoll {

	public static void main(String[] args) {
		//Declare variable; logic test; increment
		int[] results = new int[6];
		for(int index = 0; index < 500; index++){
			int result = rollUnfairDie();
			//System.out.println("Roll #" + (index + 1) + ": " + result);
			results[result-1]++;
		}
		//Prints the results
		for(int index = 0; index < 6; index++){
			System.out.println((index+1) + " appeared " + results[index] + " times.");			
		}
	}
	
	//Returns 1,2,3,4,5,6 with equal probability
	public static int rollFairDie(){
		double rand = Math.random();
		//Returns a double (0,1)
		int roll = (int) (6*rand) + 1;
		//[1,6]
		return roll;
	}
	
	public static int rollUnfairDie(){
		int sum = 1;
		for (int index = 0; index < 5; index++){
			double rand = Math.random();
			int num = (int) (2*rand);
			if(num == 0){
				sum = sum + 1;
			}
			else{
				return sum;
			}
		}
		return sum;
	}
}

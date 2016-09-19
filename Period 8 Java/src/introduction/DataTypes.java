package introduction;

public class DataTypes {

	public static void main(String[] args) {
		System.out.println(5.0/2);
		System.out.println((double) 5.0/2);
		System.out.println(5/2);
		//The third returns 2 instead of 2.5 as the first two are doubles while the third is an int which does not store decimals.
		System.out.println(3+5.0/2+5*2);
		System.out.println(3.0+5/2+5*2);
		//Changing the position of the double changed the output because 5/2 is an operation using two ints and this will return an int which would be 2 instead of 2.5
		System.out.println((int)(3.0 + 5)/(2 + 5 * 2));
		//The first evaluates everything properly as doubles are placed in the correct places while the second one is not. The third uses a different order of operations while casted as an int which removes the decimals.
		if(42 == 42.0) System.out.println("42 equals 42.0");
		//Testing Precision
		double d1 = 4.64; 
		double d2 = 2.0;
		double d3 = 2.64;

		System.out.println("d1 : " + d1); 
		System.out.println("d2 : " + d2); 
		System.out.println("d3 : " + d3);  
		System.out.println("d1 - d2 : " + (d1 - d2));
		//The variables in the quotes are ignored and the variables outside of the quotes are evaluated properly
		
		/*String s = 1;
		System.out.println(s);
		Will not compile because 1 is an int and the type is a string*/
		
		/*String s = (String)1;
		System.out.println(s);
		Ints cannot be cast into a string*/
		
		/*String s = "1";
		System.out.println(s);*/

		/*String s = ""+1;
		System.out.println(s);
		
		String s = "Happy "+18+"th birthday!";
		System.out.println(s);
		
		String s = "Happy 18th birthday!";
		System.out.println(s);
		
		String s = "Happy "+54/3+"th birthday!";
		System.out.println(s);

		String s = "Happy "+(54/3)+"th birthday!";
		System.out.println(s);
		
		int m = 22;
		int n = 7;
		System.out.println("m/n is "+(m/n));*/
		
		int m = 22;
		int n = 7;
		System.out.println("m/n is "+((double)m/n));
		



	}

}

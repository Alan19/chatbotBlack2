package introduction;

public class OOPExample {

	public static void main(String[] args) {
		Student jillian = new Senior("Jillian", true);
		Student joseph = new Sophmore("Joseph", "Software");
		Student jordan = new Junior("Jordan", "US History");
		Senior jenny = new Senior("Jenny", true);

				
		jillian.talk();		
		joseph.talk();
		jordan.talk();
		((Student)jenny).talk();
		jenny.greet();
		//The other methods of casting on the website do not work but casting does not produce the message that the superclass is supposed to create
	}

}

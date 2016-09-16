package introduction;

public class Senior extends Student {

	private Boolean enoughCredits;
	
	public Senior(String name, Boolean clubs) {
		super(name);
		this.enoughCredits = clubs;
	}
	
	public void talk(){
		super.talk();
		System.out.println("... and I am a senior!");
		if (enoughCredits){
			System.out.println("It looks like I have to join more clubs this year.");
		}
		else{
			System.out.println("Maybe I won't have to join any clubs this year!");
		}
	}
}

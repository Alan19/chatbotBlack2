package introduction;

public class Sophmore extends Student {
	
	private String favoriteMajor;
	
	public Sophmore(String name, String major) {
		super(name);
		this.favoriteMajor = major;
	}
	
	public void talk(){
		super.talk();
		System.out.println("... and I am a sophmore! My favorite major is " + favoriteMajor);
	}

}

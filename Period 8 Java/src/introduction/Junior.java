package introduction;

public class Junior extends Student {
	
	private String favoriteAP;
	
	public Junior(String name, String AP) {
		super(name);
		this.favoriteAP = AP;
	}
	
	public void talk(){
		super.talk();
		System.out.println("... and I am a junior! My favorite AP is " + favoriteAP);
	}
}

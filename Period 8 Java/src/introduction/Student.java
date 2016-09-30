package introduction;

public class Student {
	//Fields
	private String name;
	
	//Constructor (Initializes Fields)
	public Student(String name){
		this.name = name;
	}
	
	public void talk(){
		System.out.println("Hello, my name is " + name);
	}
	

}

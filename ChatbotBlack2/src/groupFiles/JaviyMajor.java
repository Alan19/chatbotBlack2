package groupFiles;

public class JaviyMajor extends Object implements Chatbot{
	
	private boolean inMajorLoop;
	private String MajorResponse;
//	private String[] aerospaceStatements = 
		{};
//	private String[] architectureStatements = 
		{};
	private String[] bioScienceStatements = 
		{};
	private String[] chemistryStatements = 
		{};
//	private String[] civilStatements = 
//		{};
	private String[] collegePrepStatements = 
		{};
//	private String[] electricalStatements = 
//		{};
//	private String[] enviromentalStatements = 
		{};
	private String[] financeStatements = 
		{};
//	private String[] gatewayStatements = 
//		{};
//	private String[] industrialStatements = 
//		{};
//	private String[] lawStatements = 
//		{};
//	private String[] mathStatements = 
//		{};
//	private String[] mechStatements = 
//		{};
	private String[] mediaStatements = 
		{};
//	private String[] physicsStatements = 
//		{};
//	private String[] socialStatements = 
//		{};
	private String[] softwareStatements = 
		{};
	private String[] existingMajors = {"biosci","bioscience","chem","chemistry"," collegeprep",
			"finance","media","software"};
	
	public void talk() {
		inMajorLoop = true;
		while(inMajorLoop){
			ZhenMain.println("Welcome to my Brooklyn Tech major database, "
					+ "I can handle:Bioscience,Chemistry,CollegePrep,Finance,Media, and Software."
					+ "My database can't handle more than that.Type quit to go back.");
			//static call on promptInputmethod from JaviyMain
			MajorResponse = ZhenMain.promptInput();

			//Create helper method to make you exit out if you try to search for a major other than the ones listed
			if(MajorResponse.indexOf("quit")>=0){
				inMajorLoop = false;
				ZhenMain.promptForever();
			}
			if(majorsExist(MajorResponse)==true){
				ZhenMain.println("That's that's great let's talk about the major you are interested in.");
			}
			ZhenMain.println("That's the worst part about Majors.");
		}
		
	}

	
	private boolean majorsExist(String userInput) {
		for(int i = 0; i < existingMajors.length ;i++){
			if(ZhenMain.findKeyword(userInput, existingMajors[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}


	public boolean isTriggered(String userInput) {
		String[] triggers = {"major","brooklyn tech","teacher","software","media","finance"
				,"college prep","chemistry","bioScience"};
		//create a for loop to iterate
		//through your array of triggers
		for(int i = 0; i < triggers.length ;i++){
			if(ZhenMain.findKeyword(userInput, triggers[i], 0) >= 0){
				return true;
		}
	}
		return false;
	}
	

}

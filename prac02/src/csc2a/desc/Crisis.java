package csc2a.desc;

public class Crisis {
	private String ID;
	private String Name;
	private String Team;
	private double Priority;
	private Event[] events;
	private int amountEvents;
//	private int totalSeverity;
	
	//constructor for initializing the instance variables
	public Crisis(String Name, String Team, int amount) {
		this.ID = null;
		this.Name = Name;
		this.Team = Team;
		this.Priority = 12;
		amountEvents = amount;
		this.events = new Event[amountEvents];
	}
	
	//method that will be used to create events
	public void craeteEvents(int amount) {
		int i = 1;
		String ID, Name, Category;
		int Severity;
		boolean Responded; 
		if (amount > 0) {
			while(i <= amount) {
				//if the program required user input, the user can be prompted
				ID = "ID_"+i;
				Name = "Event_"+i;
				Category = "Category_"+i;
				Severity = i * 3;;
				//Responded = the user can be prompted right here
				if (i == 1) {//if prompting user there is no need for the if statement
					Responded = true;
				}else
					Responded = false;
				events[i - 1] = new Event(ID, Name, Category, Severity, Responded);
				i++;
			}
		}
		
	}
	
	//method that will be used to get the priority of the Crisis
	public void set_Priority() {
		if (events != null) {
			int total = 0;
			for (int i = 0; i < amountEvents; i++) {
				total += events[i].getSeverity();
			}
			Priority = total/amountEvents;
		}
	}
	
	//method that will be used to display the Crisis content
	public void displayCrisis() {
		System.out.println("\t\t_Crisis_");
		System.out.printf("ID\t\t\t\t: %s\n"
				+ "Crisis Name\t\t\t: %s\n"
				+ "Crisis Team\t\t\t: %s\n", ID, Name, Team);
		System.out.println("Crisis Priority\t\t\t: " + Priority +"\n");
		for (int i = 0; i < amountEvents; i++) {
			events[i].display();
		}
	}
	
	//setter
	public void setID(String ID) {
		this.ID = ID;
	}
}

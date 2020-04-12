package csc2a.desc;

public class Crisis {
	private String ID;
	private String Name;
	private String Team;
	private double Priority;
	private Event[] events;
	private int amountEvents;
	
	//constructor for initializing the instance variables
	public Crisis(String ID, String Name, String Team, int amount) {
		this.ID = ID;
		this.Name = Name;
		this.Team = Team;
		this.Priority = 0;
		amountEvents = amount;
		this.events = new Event[amountEvents];
	}
	
	//method that will be used to create events
	public void craeteEvents(String EventContent, int amount) {
		int i = 0;
		String[] eventFirst = EventContent.split("\\n");
		if (amount > 0) {
			while(i < amount) {
				String[] eventSecond = eventFirst[i].split("\\s+");
				String val = (eventSecond[3].replaceAll("\\[[A-Z]+@", "")).replaceAll("\\]", " ").replaceAll("\\s+", "") ;
				events[i] = new Event((eventSecond[0]).replaceAll("[a-z]+", ""), eventSecond[1]+' '+eventSecond[2], Integer.parseInt(val), Boolean.parseBoolean(eventSecond[4]));
				//events[i].display();
				i++;
			}
		}
	}
	
	//method that will be used to get the total severity
	public int getSeverity(String EventContent, int amount) {
		int i = 0;
		int total = 0;
		String[] eventFirst = EventContent.split("\\n");
		if (amount > 0) {
			while(i < amount) {
				String[] eventSecond = eventFirst[i].split("\\s+");
				String val = (eventSecond[3].replaceAll("\\[[A-Z]+@", "")).replaceAll("\\]", " ").replaceAll("\\s+", "") ;
				total += Integer.parseInt(val);
				i++;
			}
		}
		System.out.println(total);
		return (total);
	}
	
	//method that is going to be used to display the content of the events
	public void display(int amount) {
		for (int i = 0; i < amount; i++) {
			events[i].display();
		}
	}
	
	//getters
	public double getPriority() {
		return (Priority);
	}
	
	public String getTeam() {
		return (Team);
	}
	
	public String getName() {
		return (Name);
	}
	
	public String getID() {
		return (ID);
	}
	
	public Event[] getEvent() {
		return (events);
	}
	
	//setter for priority
	public void setpriority(double set) {
		Priority = set;
	}
}

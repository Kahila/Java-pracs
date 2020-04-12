package csc2a.desc;

public class Event {
	private String ID;
	private String Name;
	private String Category;
	private int Severity;
	private boolean Responded;
	
	//constructor to initialize the private content within the class
	public Event(String ID, String Name, String Category, int Severity, boolean Responded) {
		if (Severity <= 10  && Severity >= 0) {//severity can only be between 0 and 10
			this.ID = ID;
			this.Name = Name;
			this.Category = Category;
			this.Severity = Severity;
			this.Responded = Responded;			
		}else {
			System.out.println("the severity is out of range");
			System.exit(-1);
		}
	}
	
	//getter
	public int getSeverity() {
		return (Severity);
	}

	
	//method that will be used to display the content in the variables
	public void display() {
		System.out.println("\t\t_EVENT_");
		System.out.printf("ID\t\t\t\t:%s\n"
				+ "Name\t\t\t\t:%s\n"
				+ "Category\t\t\t:%s\n"
				+ "Severity\t\t\t:%d\n", ID, Name, Category, Severity);
		System.out.println("Responded\t\t\t:" + Responded + '\n');
	}
}

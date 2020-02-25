package csc2a.desc.models;

//IMPORTS
import csc2a.desc.models.E_EVENT_CATEGORY;

/****
 * 
 * @author: KALOMBO_AK_218095095
 * @Prac 03
 */
public class Events {
	private String EV_ID;
	private String EV_NAME;
	private E_EVENT_CATEGORY EV_CATEGORY;
	private int EV_SEVERITY;
	private boolean EV_RESPONDED;
	
	//Parameterized constructor 
	public Events(String iD, String name, E_EVENT_CATEGORY _category, int _severity, boolean responded) {
		EV_ID = iD;//a unique alphanumeric ID
		EV_NAME = name;//the name of the event
		EV_CATEGORY = _category;//the category of the event
		EV_SEVERITY = _severity;//how severe is the event on a scale of 1-10
		EV_RESPONDED = responded;//has the event been responded to
	}
	
	//setters for private vars
	public void setID(String ID) {
		this.EV_ID = ID;
	}
	public void setName(String Name) {
		this.EV_NAME = Name;
	}
	public void setSeverity(int Severity) {
		this.EV_SEVERITY = Severity;
	}
	public void setResponded(boolean Responded) {
		this.EV_RESPONDED = Responded;
	}
	
	//getters for private vars
	public String getID() {
		return (this.EV_ID);
	}
	public String getName() {
		return (this.EV_NAME);
	}
	public E_EVENT_CATEGORY getCategory() {
		return (this.EV_CATEGORY);
	}
	public int getSeverity() {
		return (this.EV_SEVERITY);
	}
	public boolean getResponded() {
		return (this.EV_RESPONDED);
	}
	
	//method that prints the event to the std out
	public void printEvent() {
		System.out.printf("> ID: %s - %s[str:%s|wks:%s] - R%d", EV_ID, EV_NAME, EV_CATEGORY, EV_SEVERITY, EV_RESPONDED);
	}
}
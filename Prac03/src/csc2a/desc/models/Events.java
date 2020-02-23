package csc2a.desc.models;

//IMPORTS
import java.util.Scanner;
import java.io.File;

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
//	public void setCategory(String Category) {
//		this.EV_CATEGORY = Category;
//	}
	
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
}
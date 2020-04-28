package csc2a.desc.model;

public class ReportEntity {
	private int X = 0;
	private int Y = 0;
	private Event event;//the event class is defined in the DESC.jar file
	
	//constructor 
	public ReportEntity(int X, int Y, Event event) {
		this.X = X;
		this.Y = Y;
		this.event = event;// instanciating the event object here
		this.event.issueReport(X, Y);//method of the contained Entity to display the report. 
	}
	
	//getter for event
	public Event getEvent() {
		return (event);
	}
}

package csc2a.desc;
import java.util.Scanner;

//crises class that composes of Events
public class Crises{
    private String Name;
    private String Team;
    private static  double Priority;
    private int ID;
    private static Event CrisesEvent;
    private static Event CrisesEventTwo;

    /*constructor for the Crises class
    will be used to initialize attributes
    */
    public Crises(String Name, String Team, int ID){
        this.Name = Name;
        this.Team = Team;
        // this.Priority = Priority;
        this.ID = ID;
    }

    //getter methods that will be used to get private attributes
    public int getID(){
        return (this.ID);
    }
    public String getTeam(){
        return this.Team;
    }
    public double getPriority(){
        return this.Priority;
    }
    public String getName(){
        return (this.Name);
    }

    // method that will be used to create events
    public static void createEvent() {
        Scanner input;
        String eventName;
        String Category;
        String _Severity;
        int Severity;
        int totSeverity = 0;

        // creating event one
        input = new Scanner(System.in);
        // System.out.printf("what is the name of event 1 ? ");
        eventName = "FIRE";
        // System.out.printf("what is the Category of UJ burning ? ");
        Severity = 6;
        totSeverity = Severity;
        if (Severity > 5)
            Category = "Team A";
        else
            Category = "Team B";

        // System.out.printf("what is the severity level of event (scale 1-10) 1 ? ");
        CrisesEvent = new Event(1, eventName, Category, Severity, true);
 
        eventName = "FLOOD";
        // System.out.printf("what is the Severity of Cat stuck in tree? ");
        Severity = 9;
        totSeverity = Severity;
        if (Severity > 5)
            Category = "Team A";
        else
            Category = "Team B";
 
        CrisesEventTwo = new Event(2, eventName, Category, Severity, true);
        input.close();
        totSeverity += Severity;
        Crises.Priority = (CrisesEvent.getSeverity() + CrisesEventTwo.getSeverity())/2;
    }

    public static void createEventTwo() {
        Scanner input;
        String eventName;
        String Category;
        String _Severity;
        int Severity;
        int totSeverity = 0;

        eventName = "UJ is Flooding";
        // System.out.printf("what is the Category of UJ burning ? ");
        Severity = 8;
//        totSeverity = Severity;
        if (Severity > 5)
            Category = "Team A";
        else
            Category = "Team B";

        // System.out.printf("what is the severity level of event (scale 1-10) 1 ? ");
        CrisesEvent = new Event(1, eventName, Category, Severity, true);
 
        eventName = "student stuck in venue";
        // System.out.printf("what is the Severity of Cat stuck in tree? ");
        Severity = 4;
        totSeverity = Severity;
        if (Severity > 5)
            Category = "Team A";
        else
            Category = "Team B";
 
        CrisesEventTwo = new Event(2, eventName, Category, Severity, true);
        // input.close();
//        totSeverity += Severity;
        Crises.Priority = (CrisesEventTwo.getSeverity() + CrisesEvent.getSeverity())/2;
    }

    //this method will be used to display the content of both events
    public static void display(){
        System.out.println("____________________________________\n\t\tEVENTS\n____________________________________");
        System.out.printf("ID           : %d\n", CrisesEvent.getID());
        System.out.printf("Name         : %s\n", CrisesEvent.getName());
        System.out.printf("Category     : %s\n", CrisesEvent.getCategory());
        System.out.printf("Severity     : %d\n", CrisesEvent.getSeverity());
        System.out.printf("Responded    : %s\n", CrisesEvent.getResponse());
        System.out.printf("\n");
        System.out.printf("ID           : %d\n", CrisesEventTwo.getID());
        System.out.printf("Name         : %s\n", CrisesEventTwo.getName());
        System.out.printf("Category     : %s\n", CrisesEventTwo.getCategory());
        System.out.printf("Severity     : %d\n", CrisesEventTwo.getSeverity());
        System.out.printf("Responded    : %s\n", CrisesEventTwo.getResponse());
    }

    //method that will be used to add events
}
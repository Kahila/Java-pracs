package csc2a.desc;

public class Event{
    /*the constructor will be used to initialize the instance of the event*/
    public Event(int ID, String Name, String Category, int Severity, boolean Responded){
        this.ID = ID;
        this.Name = Name;
        this.Category = Category;
        this.Severity = Severity;
        this.Responded = Responded;
    }
    private String Name;
    private int ID;
    private String Category;
    private int Severity;
    private boolean Responded;

    /*methods that will be used to get the private content 
    Name, ID, Category
    Severity and Responded*/
    public int getID(){
        return this.ID;
    }
    //methods that will be used to get the private content severity
    public int getSeverity(){
        return this.Severity;
    }

    //methods that will be used to get the private content Name
    public String getName(){
        return this.Name;
    }

    //methods that will be used to get the private content Response
    public boolean getResponse(){
        return this.Responded;
    }

    //methods that will be used to get the private content Category
    public String getCategory(){
        return this.Category;
    }
}
import csc2a.desc.*;

public class Main{
    private static Crises crisesOne;
    private static Crises crisesTwo;
    private double priAveOne;
    private int priAveTwo;

    //method that will be used to display the crises content
    public static void displayOne(){
        System.out.println("******************************************\n\t\tCrises : 1\n******************************************");
        System.out.printf("Name             : %s\n", crisesOne.getName());
        System.out.printf("Team             : %s\n", crisesOne.getTeam());
        System.out.printf("ID               : %d\n", crisesOne.getID());
        System.out.printf("Priority         : %f\n", crisesOne.getPriority());

        crisesOne.display();//method that will display the events within each Crises one
    }

    public static void displayTwo(){
        System.out.println("******************************************\n\t\tCrises : 2\n******************************************");
        System.out.printf("Name             : %s\n", crisesTwo.getName());
        System.out.printf("Team             : %s\n", crisesTwo.getTeam());
        System.out.printf("ID               : %d\n", crisesTwo.getID());
        System.out.printf("Priority         : %f\n", crisesTwo.getPriority());

        crisesTwo.display();//method that will display the events within each Crises two
    }

    //main method will be ran first
    public static void main(String[] args) {
        crisesOne = new Crises("Fire", "Team A", 1);
        // System.out.println("*input information for events in Team A (Building Fire)");
        crisesOne.createEvent();

        crisesTwo = new Crises("Flooding", "Team B", 2);
        // System.out.println("*input information for events in Team B (Cat on tree)");
        crisesTwo.createEventTwo();
        
        Main.displayOne();
        Main.displayTwo();
    }
}

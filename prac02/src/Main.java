import csc2a.desc.Crisis;

public class Main {
	
	public static void main(String[] args) {
		String Name; String Team;
		String ID;
		int amount = 2;//user can be prompted for the amount of Crisis to input
		int amountEvent = 0;
		Crisis[] crisis = new Crisis[amount];
		for (int i = 1; i <= amount; i++) {
			Name = "crisis_"+i;
			Team = "Team_"+i;
			ID = "ID_"+i;
			amountEvent = 2;//user can be prompted for the amount of events in Each crisis
			crisis[i - 1] = new Crisis(Name, Team, amountEvent);
			crisis[i - 1].setID(ID);
			crisis[i - 1].craeteEvents(amountEvent);
			crisis[i - 1].set_Priority();
			crisis[i - 1].displayCrisis();
		}
	}

}

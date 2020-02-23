/****
 * 
 * @author: KALOMBO_AK_218095095
 * @Prac 03
 */

package csc2a.desc.models;

public class Crisis {
	private int CR_ID;
	private String CR_NAME;
	private String CR_TEAM;
	
	//constructor that will be used to initialize instances of the Crisis class
	public Crisis(int ID, String Name, String Team) {
		this.CR_ID = ID;
		this.CR_NAME = Name;
		this.CR_TEAM = Team;
	}
	
	//getters for private vars
	public int getID() {
		return (this.CR_ID);
	}
	public String getName() {
		return (this.CR_NAME);
	}
	public String getTeam() {
		return (this.CR_TEAM);
	}
}
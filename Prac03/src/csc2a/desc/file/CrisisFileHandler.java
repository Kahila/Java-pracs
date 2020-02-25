
/****
 * 
 * @author: KALOMBO_AK_218095095
 * @Prac 03
 */
package csc2a.desc.file;

//imports
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import csc2a.desc.models.Crisis;
import csc2a.desc.models.Events;
import csc2a.desc.models.E_EVENT_CATEGORY;


public class CrisisFileHandler {
	//Regex that will match the Crisis information
	private static final Pattern CrPattern = Pattern.compile("[A-Z0-9]{6}\\t([A-Za-z]+\\s)+\"([A-Za-z]+(\\s)?)+\"");//will be in a static method
	//Regex that will match the Crisis information
	private static final Pattern EvPattern = Pattern.compile("[A-Z0-9]{6}\\t([A-Za-z]+\\\\s)+\\\\[[A-Z]+\\\\|[A-Z]+\\\\]\\\\t\\\\d+");
	
	/*method that will be used to read
	 line by line of a file
	 * */
	@SuppressWarnings("null")
	public static Crisis readCrisis(File CR_FILE) {
		Crisis crisis = null; //return reference
		//checking if the file exists
		if(!CR_FILE.exists()) {
			System.err.println("Error: File is not valid");
			return (crisis);
		}
		Scanner scCrisis = null;
		try {
			scCrisis = new Scanner(CR_FILE);//open file
			if (!scCrisis.hasNext()) {
				System.err.println("Error: The fire is empty");
				return (crisis);
			}
			String getCrisis = scCrisis.nextLine();
			//validating with Regex
			Matcher MatchHeadCrisis = CrPattern.matcher(getCrisis);
			if (!MatchHeadCrisis.matches()) {
				System.err.println("Error: the Crisis format is invalid");
				return (crisis);
			}
			//breaking up the Crisis header using the Tokenizer
			StringTokenizer crHeadTokenizer = new StringTokenizer(getCrisis, "\t");
			String ID 	  = crHeadTokenizer.nextToken();
			String Name   = crHeadTokenizer.nextToken();
			String Team = crHeadTokenizer.nextToken();
			Team = Team.substring(1,Team.length()-1);//removing spaces
			System.out.printf("***Crisis Header***\nCrisis_ID: %S\nCrisis_Nm: %s\nCrisis_Tm: %s\n\n", ID, Name, Team);
			
			while(scCrisis.hasNext()) {
				String _event = scCrisis.nextLine();
				//Validate line with Regex
				Matcher match_event = EvPattern.matcher(_event);
				//If the Regex match fails, then print an error
				if(!match_event.matches()) {
					System.err.format("Member Hero does not match:\r%s%n", _event);
				}else {
					//Create a event;
					Events NewEvent = makeEvent(_event);
					crisis.addEvent(NewEvent);
				}
			}
		}catch(FileNotFoundException fnfex) {
			System.err.format("Error: File %s does not exist%", CR_FILE.getAbsolutePath());
		}finally {
			//Close the file
			if(scCrisis != null) {
				scCrisis.close();
			}
		}
		return (crisis);
	}
	
	//method that will be used to create Events
	private static Events makeEvent(String _event) {
		/*
		 * Format of a Events
		 */
		StringTokenizer EV_Tokens = new StringTokenizer(_event, "\t");
		String ID 			= EV_Tokens.nextToken();
		String Name 		= EV_Tokens.nextToken();
		String Category 	= EV_Tokens.nextToken();
		boolean Responded	= Boolean.parseBoolean(EV_Tokens.nextToken());
		
		//Get Category and Severity
		Category = Category.substring(1,Category.length()-1);
		//Split at the |
		StringTokenizer CategoryTokens = new StringTokenizer(Category, "@");
		E_EVENT_CATEGORY _category = E_EVENT_CATEGORY.valueOf(CategoryTokens.nextToken());
		int _severity = Integer.parseInt(CategoryTokens.nextToken());
		
		System.out.printf("***Member***\nID: %S\nNm: %s\nStr: %s\nWkns: %d\nRnwn: %d\n", ID,Name, _category.toString(), _severity, Responded);
		
		//Create Hero
		Events event = new Events(ID, Name, _category, _severity, Responded);
		return event;
	}
	
}

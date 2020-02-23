
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
import csc2a.desc.models.*;

public class CrisisFileHandler {
	//Regex that will match the Crisis information
	private static final Pattern CrPattern = Pattern.compile("[A-Z0-9]{6}\\t([A-Za-z]+\\s)+\"([A-Za-z]+(\\s)?)+\"");//will be in a static method
	//Regex that will match the Crisis information
	private static final Pattern EvPattern = Pattern.compile("[A-Z0-9]{6}\\t([A-Za-z]+\\\\s)+\\\\[[A-Z]+\\\\|[A-Z]+\\\\]\\\\t\\\\d+");
	
	/*method that will be used to read
	 line by line of a file
	 * */
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
		}
		return (crisis);
	}
}

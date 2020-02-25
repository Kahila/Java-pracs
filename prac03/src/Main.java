/****
 * 
 * @author: KALOMBO_AK_218095095
 * @Prac 03
 */

import java.io.File;
import csc2a.desc.models.Crisis;
import csc2a.desc.file.CrisisFileHandler;

public class Main {

	public static void main(String[] args) {
		System.out.printf("==============================\nRead Crisis From File\n==============================\n");
		File teamFile = new File("data/Crisis_Messages", "C04H76 - Clean.txt");
		Crisis CR_FromFile = CrisisFileHandler.readCrisis(teamFile);
		System.out.println();
		System.out.printf("==============================\nCrisis Information\n==============================\n");
		CR_FromFile.printCrisis();
	}

}
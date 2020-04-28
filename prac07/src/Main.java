//Imports
import csc2a.desc.gui.CrisisPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author: Mr B Greaves
 * @edited: AK Kalombo
 * (Dystopian Emergency Services Council)
 * @version P06
 */
public class Main extends Application{
	//Scene for our Crisis to be placed on the Stage
	private CrisisPane pane = null;

	public static void main(String[] args) {		
		//Launch the JavaFX Application
		launch(args);
	}
	
	//Implement the start method required to get the Stage for the JavaFX Application
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("DESC Crisis Viewer");
		//Create the CrisisPane
		pane = new CrisisPane();
		//Set the Scene
		Scene scene = new Scene(pane);
		primaryStage.setWidth(400 + 15*50);
		primaryStage.setHeight(100 + 15*50);
		primaryStage.setScene(scene);
		//Open the Curtains
		primaryStage.show();		
	}
}

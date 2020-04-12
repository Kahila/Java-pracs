import csc2a.desc.ui.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	 @Override
	    public void start(Stage primaryStage) {
		 CrisisPane crPane = new CrisisPane(primaryStage);
	 }
}

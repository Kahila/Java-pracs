package csc2a.desc.ui;

import csc2a.desc.model.Crisis;
import csc2a.desc.file.CrisisFileHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.stage.FileChooser; //file chooser
//import javafx.stage.FileChooser; // will be used to set initial directory
import javafx.stage.Stage;

import java.io.File;

public class CrisisPane extends StackPane {
	private Crisis crisis;
//	private CrisisFileHandler handle = new CrisisFileHandler();
	
	public CrisisPane(Stage primaryStage) {
		MenuBar menuBar = new MenuBar();
		 MenuItem mit1 = new MenuItem("File");
		 MenuItem mit2 = new MenuItem("Open");
		 Menu menu = new Menu("Menu");
		 FileChooser chooser = new FileChooser();
		 StackPane stack = new StackPane();
		 GridPane gridCr = new GridPane();
		 TextArea text = new TextArea();
		 GridPane gridEv = new GridPane();
		 Accordion acc = new Accordion();
		 TitledPane[] titlePane = new TitledPane[2];
		 titlePane[0] = new TitledPane("Crisis information", gridCr); 
		 titlePane[1] = new TitledPane("Events", gridEv);
		 
		 
		 mit1.setOnAction(value ->{
			 File file = chooser.showOpenDialog(null);
			 if (file != null) {
				 this.crisis = CrisisFileHandler.readCrisis(file);
				 mit2.setOnAction(val ->{
					 text.setText("ID\t\t\t\t: "+crisis.getCrisisID() +"\n"
								+ "Crisis Name\t\t\t: "+crisis.getCrisisName() +"\n"
								+ "Crisis Team\t\t\t: " + crisis.getCrisisTeam() +"\n"
								+ "Crisis Priority\t\t\t: " + crisis.getCrisisPriority() + "\n");
					 acc.getPanes().addAll(titlePane);
					 gridCr.getChildren().add(text);
					 gridEv.getChildren().add(new TextArea(displayEV()));
//					 acc.setExpandedPane(titlePane[0]);
					 
					 Scene scene2 = new Scene(acc, 300, 300);
					 primaryStage.setScene(scene2);
				 });
			 }
		 });
		 
		 menu.getItems().add(mit1);
		 menu.getItems().add(mit2);
		 menuBar.getMenus().add(menu);
		 
		 stack.getChildren().add(menuBar);
		 
		 Scene scene = new Scene(stack, 300, 300);
		 primaryStage.setScene(scene);
	     primaryStage.show();
	}
	
//	 method that will display crisis information
	 public String displayEV() {
		int i = 0;
		String var = null;
		while (crisis.getEvent(i) != null) {
			var += "Event ID\t\t\t\t: "+crisis.getEvent(i).getEventID()
					+ "\nEvent Name\t\t\t\t: "+crisis.getEvent(i).getEventName()
					+ "\nEvent Severity\t\t\t\t: "+crisis.getEvent(i).getEventSeverity()
					+ "\nEvent Category\t\t\t\t: "+crisis.getEvent(i).getEventCategory()
					+ "\nEvent Responded\t\t\t\t: "+crisis.getEvent(i).getEventResponded() +"\n\n";
			i++;
		}
			return (var);
	 }
}

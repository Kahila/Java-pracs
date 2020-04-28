package csc2a.desc.gui;
//Imports
import csc2a.desc.model.Crisis;
import java.io.File;

import csc2a.desc.file.BinaryReportFileHandler;
import csc2a.desc.file.CrisisFileHandler;
import csc2a.desc.model.Event;
import csc2a.desc.model.InvalidEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
/**
 * @author Mr Greaves
 * @version P05
 */
public class CrisisPane extends StackPane{
	
	//Crisis to be displayed on the Scene
	private Crisis crisis = null;
	
	//Form controls
	private MenuBar menuBar = null;
	
	/**
	 * Default Constructor
	 */
	public CrisisPane() {
		//Our Constructor code
		menuBar = new MenuBar();
		Menu menu = new Menu("File");
		Menu binaryMenu = new Menu("Binary File");
		TitledPane title = new TitledPane();
		menuBar.getMenus().add(menu);
		menuBar.getMenus().add(binaryMenu);
		MenuItem mi1 = new MenuItem("Open");
		MenuItem mil2 = new MenuItem("Open");
		menu.getItems().add(mi1);
		binaryMenu.getItems().add(mil2);
		//Add action Listener
		mi1.setOnAction(e -> {
			//Open File Chooser
			final FileChooser fc = new FileChooser();
			fc.setTitle("Choose Crisis File");
			fc.setInitialDirectory(new File("./data"));
			File file = fc.showOpenDialog(null);
			if(file != null) {
				//Set canvas data after reading from file
				setCrisis(CrisisFileHandler.readCrisis(file));
			}
		});
		
		//setting the menu item to allow selection of file on action
		mil2.setOnAction(value ->{
			//Open File Chooser
			final FileChooser fc = new FileChooser();
			fc.setTitle("Choose Reprt File");
			fc.setInitialDirectory(new File("./data"));
			File file = fc.showOpenDialog(null);
			if (file != null) {
				BinaryReportFileHandler report = new BinaryReportFileHandler();
				report.readCrisisReports(file);
			}
		});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(menuBar);
		getChildren().add(layout);
		setWidth(400);
		setWidth(500);
	}
	/**
	 * Method to set the Crisis to be displayed in the Pane
	 * @param item Crisis to be set
	 */
	public void setCrisis(Crisis item) {
		this.crisis = item;
		createChildren();
	}
	/**
	 * Method to create the component nodes of the Pane
	 */
	public void createChildren() {
		if(crisis != null) {
			//Make root node for the Scene
			Accordion accordion = new Accordion();
			
			//Start making child nodes...
			
			//Create the Crisis Pane
			TitledPane tpcrisis = new TitledPane();
			tpcrisis.setText("Crisis Information");
			GridPane grid = new GridPane();
			grid.setVgap(4); //Add some spacing
			grid.setPadding(new Insets(5,5,5,5)); //Add some padding
			grid.add(new Label("Name: "), 0, 0);
			grid.add(new TextField(crisis.getCrisisName()), 1, 0);
			grid.add(new Label("ID: "), 0, 1);
			grid.add(new TextField(crisis.getCrisisID()), 1, 1);
			grid.add(new Label("Team: "), 0, 2);
			grid.add(new TextField(crisis.getCrisisTeam()), 1, 2);
			grid.add(new Label("Priority: "), 0, 3);
			ProgressBar pgb = new ProgressBar();		
			pgb.setProgress(Math.round(crisis.getCrisisPriority())/10.0);
			grid.add(pgb, 1, 3);
			//Add child node
			tpcrisis.setContent(grid);
			
			
			//Create Event Panes
			TitledPane tpEvents = new TitledPane();
			tpEvents.setText("Events");
			ScrollPane spEvents = new ScrollPane();
			VBox vbEvents = new VBox();
			for(Event e: crisis.getEvents()) {
				vbEvents.getChildren().add(createEventGrid(e));
			}
			//Add as children
			spEvents.setContent(vbEvents);
			tpEvents.setContent(spEvents);
			
			accordion.getPanes().add(tpcrisis);
			accordion.getPanes().add(tpEvents);
			
			//Set the root node of the Scene
			getChildren().clear();
			getChildren().addAll(accordion);			
		}
	}
	/**
	 * Helper method to create a grid node from an Event
	 * @param event The Event for the grid to be created from
	 * @return the created Grid
	 */
	public GridPane createEventGrid(Event event) {
		GridPane grid = new GridPane();
		grid.setVgap(4);
		grid.setPadding(new Insets(5,5,5,5));
		
		//Bonus: Colour the Pane of the InvalidHero red
		if(event instanceof InvalidEvent) {
			grid.setStyle("-fx-background-color: indianred");
		}
		
		//Use the helper method to create a labeled text box
		grid.add(createLabeledTextbox("Name: ", event.getEventName()), 0, 0);
		
		//Create the rest of the labels and text fields
		grid.add(new Label("ID: "), 0, 1);
		grid.add(new TextField(event.getEventID()), 1, 1);
		
		grid.add(new Label("Category: "), 0, 2);
		grid.add(new TextField(event.getEventCategory().toString()), 1, 2);
				
		grid.add(new Label("Severity: "), 0, 4);
		
		//Create progress bar to show hero's renown
		ProgressBar pgb = new ProgressBar();		
		pgb.setProgress(Math.round(event.getEventSeverity())/10.0);
		grid.add(pgb, 1, 4);
		
		grid.add(new Label("Responded: "), 0, 3);
		grid.add(new TextField(""+event.getEventResponded()), 1, 3);
		return grid;
	}
	/**
	 * Helper method to create a grid with a label and text field
	 * @param label The text for the label
	 * @param text The text to go in the text field
	 * @return the created Grid
	 */
	public GridPane createLabeledTextbox(String label, String text) {
		GridPane grid = new GridPane();
		grid.add(new Label(label), 0, 1);
		grid.add(new TextField(text), 1, 1);
		return grid;
	}

}

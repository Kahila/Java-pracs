package csc2a.desc.gui;
//Imports
import csc2a.desc.model.Crisis;
import java.io.File;

import csc2a.desc.file.BinaryReportFileHandler;
import csc2a.desc.file.CrisisFileHandler;
import csc2a.desc.model.Event;
import csc2a.desc.model.InvalidEvent;
import csc2a.desc.model.ReportEntity;
import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import csc2a.desc.gui.ReportCanvas;
/**
 * @author Mr Greaves
 * (
 * @version P06
 */
public class CrisisPane extends StackPane{
	
	//Crisis to be displayed on the Scene
	private Crisis crisis = null;
	//Array of ReportEntity objects to be used in the next practical (Added for P06)
	private ReportEntity[] reports = null;
	private BorderPane borderPane = null;
	private ReportCanvas rc = null;
	//Form controls
	private MenuBar menuBar = null;
	GraphicsContext gc = null;
	/**
	 * Default Constructor
	 */
	public CrisisPane() {
		borderPane = new BorderPane();
		rc = new ReportCanvas();
		//Our Constructor code
		menuBar = new MenuBar();
		Menu menu = new Menu("File");
		menuBar.getMenus().add(menu);
		MenuItem mi1 = new MenuItem("Open");
		menu.getItems().add(mi1);
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
		//Binary File menu (Added for P06)
		Menu binaryMenu = new Menu("Binary");
		menuBar.getMenus().add(binaryMenu);
		MenuItem mi2 = new MenuItem("Open Crisis Report");
		binaryMenu.getItems().add(mi2);
		mi2.setOnAction(e -> {
			//Open File Chooser
			final FileChooser fc = new FileChooser();
			fc.setTitle("Choose Crisis Report File");
			fc.setInitialDirectory(new File("./data/Crisis Reports"));
			
			File crisisFile = fc.showOpenDialog(null);
			if(crisisFile != null) {
				//Read Crisis Report File to get CrisisID
				File reportFile = BinaryReportFileHandler.readBinaryForFileName(crisisFile);
				if(reportFile != null) {
					//Open Crisis File to set the ReportEntity[] reports
					setCrisis(CrisisFileHandler.readCrisis(reportFile));
			
//					System.out.println();
					//Read the Mission File to draw the Mission Area
					reports = BinaryReportFileHandler.readCrisisReports(crisisFile, this.crisis);
					Reports();
				}
			}
		});
		
		
		VBox layout = new VBox();
		layout.getChildren().addAll(menuBar);
		getChildren().add(layout);
		setWidth(400);
		setWidth(500);
	}
	
	public void Reports() {
		//Add canvas to the Scene Graph		
		borderPane.setCenter(rc);
		//Set the data for the canvas
		rc.drawCanvas(); //This will automatically force the Canvas to redraw
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
			borderPane.setLeft(accordion);
			getChildren().clear();
			getChildren().addAll(borderPane);			
		}
	}
	
	
	///methods that will be used to set the Graphical Context
//	public void SetGC(GraphicsContext gc) {
//		this.gc = gc;
//	}
//	
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
//			gc.fillRect(1*50, 1*50, 50, 50);
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

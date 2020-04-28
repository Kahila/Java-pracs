/**
 * This node will be responsible for drawing a virtual satellite view of the reported Crisis area
 * @author AK Kalombo
 * 
 * @version P07
 */

package csc2a.desc.gui;
import csc2a.desc.model.Event;
import csc2a.desc.model.InvalidEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import csc2a.desc.model.InvalidEvent;


public class ReportCanvas extends Canvas{
	
	private static int SIZE = 15*50;
	CrisisPane cp = null;
	
	//initializing the instance variables in Default constructor
	public ReportCanvas() {
		setWidth(SIZE);
		setHeight(SIZE);
		//cp = new CrisisPane();
	}
	
	//method to draw object to the canvas
	public void drawCanvas() {
		
		GraphicsContext gc = getGraphicsContext2D();
		//cp.SetGC(gc);
		//drawing to the grid
		for (int r = 0; r < 15; r++) {
			for (int c = 0; c < 15; c++) {
				gc.strokeRect(c*50, r*50, 50, 50);
				gc.fillRect(4*50, 2*50, 50, 50);
				gc.setFill(Color.BLUE);
				gc.fillRect(13*50, 6*50, 50, 50);
				gc.fillRect(14*50, 12*50, 50, 50);
				gc.setFill(Color.RED);
				gc.fillRect(3*50, 5*50, 50, 50);
			}
		}
	}
	
	//method that will be used to set the colors
	public Color setColor(Event event)
	{
		Color color = Color.WHITE;
		if(event instanceof InvalidEvent)
		{
			color = (Color.RED);
		}
		return (color);
	}
}

package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import java.util.List;

public class PainterController {
	
	@FXML
	private Pane drawingAreaPane;
	private String tool = "";
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	
	@FXML
	void menuButtonPressed(ActionEvent event) {
		tool = ((RadioButton)event.getSource()).getText();
	}
	
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle =  new Circle();
		if (tool.equals("Pen")) {
			newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);			
		}
		else if (tool.equals("Eraser")){
			newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);	
		}
		if (event.getX() >= 0 && event.getX() <= drawingAreaPane.getWidth() &&
			event.getY() >= 0 && event.getY() <= drawingAreaPane.getHeight()) {
			drawingAreaPane.getChildren().add(newCircle);
		}
	}
}

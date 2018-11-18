import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

// Rectangle Stuffs
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;

// Buttons
import javafx.scene.control.Button;

// Text
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;

public class camera_gui extends Application {
    float ButtonHeight = 630.0f;

    	@Override
	public void start(Stage stage) throws Exception {
	    //Button_1 - Detect Camera
	    Button button1 = new Button("Detect Camera");
       	    button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    button1.setLayoutX(10.0f);
	    button1.setLayoutY(ButtonHeight);
	    button1.setMinWidth(100.0f);
	    button1.setMinHeight(50.0f);

	    
	    //Button 2 - Take Picture
	    Button button2 = new Button("Take Picture");
	    button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    button2.setLayoutX(300.0f);
	    button2.setLayoutY(ButtonHeight);
	    button2.setMinWidth(100.0f);
	    button2.setMinHeight(50.0f);
	    
	    //Button 3 - Share Picture
	    Button button3 = new Button("Share Picture");
	    button3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    button3.setLayoutX(600.0f);
	    button3.setLayoutY(ButtonHeight);
	    button3.setMinWidth(100.0f);
	    button3.setMinHeight(50.0f);

	    
	    // Draw rectangle and its properties
	    Rectangle rectangle = new Rectangle();
	    rectangle.setX(10.0f);
	    rectangle.setY(40.0f);
	    rectangle.setWidth(1000.0f);
	    rectangle.setHeight(575.0f);

	    // Draw rectangle of updates.
	    Rectangle rectangle2 = new Rectangle();
	    rectangle2.setX(1030.0f);
	    rectangle2.setY(50.0f);
	    rectangle2.setWidth(300.0f);
	    rectangle2.setHeight(500.0f);

	    //Text 1 - Detect Camera
	    Text text1 = new Text();
	    text1.setText("Detect Camera by Pressing 1, \n or clicking the button");
	    text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
	    text1.setFill(Color.WHITE);
	    text1.setX(50.0f);
	    text1.setY(500.0f);
	    
	    //Text 2 - Log
	    Text text2 = new Text();
	    text2.setText("Log...");
	    text2.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
	    text2.setFill(Color.WHITE);
	    text2.setX(1040.0f);
	    text2.setY(70.0f);

	    
	    // Text 3 - LTOR
	    Text text3 = new Text();
	    text3.setText("Written by Michael Verano\nFor bug fixes, email michael.verano@nyumc.org");
	    text3.setFont(Font.font("verdana", FontPosture.REGULAR, 10));
	    text3.setFill(Color.WHITE);
	    text3.setX(1050.0f);
	    text3.setY(650.0f);

	    
	    //Create Groupings
	    Group root = new Group(rectangle, button1, button2, button3, rectangle2,
				   text1, text2, text3);

	    
	    //Creating a scene object
	    Scene scene = new Scene(root, 1350, 700, Color.GREY);
	    
	    //Setting title to the Stage
	    stage.setTitle("LTOR Camera Controller");

	    //Adding scene to the stage
	    stage.setScene(scene);

	    
	    //Displaying to the contents of the stage
	    stage.show();
	    
	}
    public static void main(String args[]){
	launch(args);
    }

    
}

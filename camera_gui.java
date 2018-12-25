import java.lang.*;
import java.io.*;
import java.util.List;

// JavaFX
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.effect.*;
import javafx.scene.input.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


// Rectangle Stuffs
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;


// Text
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;

// Import functionalities - packages
import camera.operations.detect_camera;
import camera.operations.take_picture;
import camera.operations.parse_text;
import camera.operations.removeJPG;
import camera.operations.findJPG;
import camera.operations.configuration;
import camera.operations.credentials_gui;
import camera.operations.encode_settings;
//import camera.operations.email_image;;

//Import image functions
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.layout.VBox;

//Pop ups
import javafx.stage.Popup;
import javafx.stage.Modality;

public class camera_gui extends Application {
    float ButtonHeight = 630.0f;
    DropShadow shadow = new DropShadow();

       @Override
	public void start(Stage stage) throws Exception {
	    //Text 1 - Detect Camera
	    Text text1 = new Text();
	    text1.setText("Detect Camera by Pressing 1, \n or clicking the button");
	    text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
	    text1.setFill(Color.WHITE);
	    text1.setX(50.0f);
	    text1.setY(500.0f);

       	    //Text 2 - Log
	    Text text2 = new Text();
	    text2.setWrappingWidth(300);
	    text2.setText("Log...");
	    text2.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
	    text2.setFill(Color.WHITE);
	    text2.setX(1040.0f);
	    text2.setY(70.0f);

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

	    
	   //Button_1 - Detect Camera
	    Button button1 = new Button("Detect Camera");
       	    button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    button1.setLayoutX(10.0f);
	    button1.setLayoutY(ButtonHeight);
	    button1.setMinWidth(100.0f);
	    button1.setMinHeight(50.0f);

	    //Button 1 Actions - shadow when mouse cursor on top
	    button1.addEventHandler(MouseEvent.MOUSE_ENTERED,
	    			    new EventHandler<MouseEvent>() {
	    				public void handle(MouseEvent e) {
	    				    button1.setEffect(shadow);
	    				}});	 
       	    button1.addEventHandler(MouseEvent.MOUSE_EXITED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    button1.setEffect(null);
					}});
	    
	    //Button 1 When Clicked - Run gphoto2 auto-detect
	    button1.addEventHandler(MouseEvent.MOUSE_CLICKED,
	    			    new EventHandler<MouseEvent>() {
	    				public void handle(MouseEvent e) {
					    text1.setText("Detecting Camera...");
					    detect_camera auto_detect = new detect_camera();
	    				    List outputList = auto_detect.start();

					    //Replace Text2
					    if (outputList.size() < 4) {
						text1.setText("Camera not detected...");
						text2.setText("---");
					    };

					    if  (outputList.size() == 4) {
						String raw_text = outputList.get(3).toString();
						rectangle.setFill(Color.BLACK);
						text1.setText("Camera detected.");
					        text2.setText(raw_text);
					    };
	    				}});

	    
	    //Button 2 - Take Picture
	    Button button2 = new Button("Take Picture");
	    button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    button2.setLayoutX(300.0f);
	    button2.setLayoutY(ButtonHeight);
	    button2.setMinWidth(100.0f);
	    button2.setMinHeight(50.0f);

	    //Button 2 Actions - shadow when mouse cursor on top
	    button2.addEventHandler(MouseEvent.MOUSE_ENTERED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    button2.setEffect(shadow);
					}});
	    button2.addEventHandler(MouseEvent.MOUSE_EXITED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    button2.setEffect(null);
					}});
	    button2.addEventHandler(MouseEvent.MOUSE_CLICKED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    //Remove JPG items
					    removeJPG remove_jpg = new removeJPG();
					    remove_jpg.start();
					    
					    detect_camera auto_detect = new detect_camera();
					    List outputList = auto_detect.start();
					    
					    if (outputList.size() == 4) {
						text1.setText("Taking photo...");
						take_picture take_a_pic = new take_picture();
						take_a_pic.start();

					        text2.setText("Photo Taken");
						
						findJPG find_jpg = new findJPG();
						String jpg_file = find_jpg.start();
						
						parse_text parse_a_text = new parse_text();
						String JPG_file = parse_a_text.start(jpg_file);
						System.out.println(JPG_file);

						Image image = new Image(JPG_file);
						ImageView imageView = new ImageView(image);
						imageView.setX(10f);
						imageView.setY(40f);

						imageView.setFitHeight(575f);
						imageView.setFitWidth(1000f);

						text1.setText(null);
						rectangle.setFill(new ImagePattern(image));

					    } else {
						text1.setText("Picture not taken");
						text2.setText("Error occurred");
					    }
					}});
				   

	    
	    //Button 3 - Share Picture
	    Button button3 = new Button("Log In");
	    button3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
	    button3.setLayoutX(600.0f);
	    button3.setLayoutY(ButtonHeight);
	    button3.setMinWidth(100.0f);
	    button3.setMinHeight(50.0f);
	    
      	    // Button 3 Actions - Shadow when mouse cursor on top
	    button3.addEventHandler(MouseEvent.MOUSE_ENTERED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    button3.setEffect(shadow);
					}});
	    button3.addEventHandler(MouseEvent.MOUSE_EXITED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    button3.setEffect(null);
					}});
	    button3.addEventHandler(MouseEvent.MOUSE_CLICKED,
				    new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
					    //Test if config file exists
					    configuration configs = new configuration();
					    boolean need_to_setup = configs.start();

					    //Create pop up to get config credentials
					    if (need_to_setup == true) {

						Text gmailText = new Text("Gmail Account: ");
						Text passText = new Text("Password");

						TextField gmailtxtField = new TextField();
						PasswordField passTextField = new PasswordField();

						Button submitButton = new Button("Submit");

						GridPane gridPane = new GridPane();

						//Set up GridPane
						gridPane.setMinSize(400, 200);
						gridPane.setVgap(5);
						gridPane.setHgap(5);
						gridPane.setAlignment(Pos.CENTER);

						//Arranging the nodes in the grid
						gridPane.add(gmailText, 0, 0);
						gridPane.add(gmailtxtField, 1, 0);
						gridPane.add(passText, 0, 1);
						gridPane.add(passTextField, 1, 1);
						gridPane.add(submitButton, 0, 2);

						//Set new stage and scene for login
						final Stage dialog = new Stage();
						dialog.initModality(Modality.APPLICATION_MODAL);
						dialog.initOwner(stage);
						
						Scene dialogScene = new Scene(gridPane);
						dialog.setScene(dialogScene);
						dialog.show();

						
						//Store user account and password.
					    	submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
					    				     new EventHandler<MouseEvent>() {

					    					 public void handle(MouseEvent e) {
					    					 	encode_settings encoding = new encode_settings();
					    					 	String[] encoded_data = encoding.start_encoding(gmailtxtField.getText(), passTextField.getText());

					    						 //STORE USER ACCOUNT AND PASSWORD IN .PROPERTIES FILE
					    						 configs.configure_file(encoded_data[0], encoded_data[1]);

											 // System.out.println(encoded_data[0]);
					    	   					 // System.out.println(encoded_data[1]);

	   				     					        //CLOSE POP UP.
					    					        dialog.close();

											button3.setText("Send To");
					    					 }
					    				     });
					    } else {
					        button3.setText("Send To");
						text1.setText("Already Logged in.");
						
					    }

					    //SELECT USER TO SEND DATA TO
				       	    button3.addEventHandler(MouseEvent.MOUSE_CLICKED,
						    new EventHandler<MouseEvent>() {
							public void handle(MouseEvent e) {
							    final Stage send_Stage  = new Stage();

							    Text send_to_text = new Text("Send to email: ");
							    TextField send_to_textField = new TextField();
							    Button submit2 = new Button("Submit");

							    GridPane gridPane_2 = new GridPane();

		      	      				    gridPane_2.setMinSize(400, 200);
						            gridPane_2.setVgap(5);
						            gridPane_2.setHgap(5);
						            gridPane_2.setAlignment(Pos.CENTER);

							    gridPane_2.add(send_to_text, 0, 0);
							    gridPane_2.add(send_to_textField, 1, 0);
							    gridPane_2.add(submit2, 0, 1);

							    final Stage dialog2 = new Stage();
							    dialog2.initModality(Modality.APPLICATION_MODAL);
							    dialog2.initOwner(stage);
							    
							    Scene SendData = new Scene(gridPane_2);
							    dialog2.setScene(SendData);
							    dialog2.show();

							    submit2.addEventHandler(MouseEvent.MOUSE_CLICKED,
										    new EventHandler<MouseEvent>() {
											public void handle(MouseEvent e) {
											    // LEFT OFF HERE
											    // PASS THE VALUE OF THE TEXT FIELD TO A VARIABLE.
			

											    
											    dialog2.close();
											}
										    });
										    
							    
							}
						    });

					   
				    

					    //FIND THE JPG FILE
					    
					    //LOG INTO GOOGLE ACCOUNT
					    //email_image email = new email_image();
					    //email.start(var_1, var_2, var_3, var_4);
					    
					    //store password and email in variable from .properties file.
					    
					    //Test if users exist.
					    
					    //Send picture to email.
					}});

	    
	    
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

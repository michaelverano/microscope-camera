package camera.operations;
import java.io.*;
import java.util.*;

public class configuration {

    public boolean start() {
	try {
	    File file = new File("./camera_gui.properties");
            boolean fvar = file.createNewFile();
	if (fvar) {
	    // configuration new_settings = new configuration();
	    // new_settings.configure_file();
	    System.out.println("Config file has been created successfully.");
	    return true;
	} else {
     	    System.out.println("Config file is already present at the location.");
	    return false;
	    }
	} catch (IOException e) {
	    System.out.println("Exception Occurred: ");
	    e.printStackTrace();
	    return false;
	}	
    }

    

    //Create a function that fills the file with configurations.
    public void configure_file() {
	
    }

    public static void main(String arg[]) {
	configuration configs = new configuration();
        configs.start();
    }
}

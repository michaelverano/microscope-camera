//package camera.operations;
import java.io.*;
import java.util.*;

public class configuration {

    public void start() {
	try {
	    File file = new File("./camera_gui.properties");
            boolean fvar = file.createNewFile();
	if (fvar) {
	    System.out.println("Config file has been created successfully.");
	    //Fill file with configurations.
	} else {
     	    System.out.println("Config file is already present at the location.");
	    }
	} catch (IOException e) {
	    System.out.println("Exception Occurred: ");
	    e.printStackTrace();
	}
    }

    //Create a function that fills the file with configurations.

    public static void main(String arg[]) {
	configuration configs = new configuration();
        configs.start();
    }
}

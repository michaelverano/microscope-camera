package camera.operations;
import java.io.*;
import java.util.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
//import java.io.BufferedReader.readLine();

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
    public void configure_file(String user_name, String password) {

	try {

	    Path file_ = Paths.get("./camera_gui.properties");
	    byte[] user_nameToBytes = user_name.getBytes();
	    byte[] passwordToBytes = password.getBytes();
	    byte[] new_line = "\n".getBytes();
	    Files.write(file_, user_nameToBytes, StandardOpenOption.APPEND);
	    Files.write(file_, new_line, StandardOpenOption.APPEND);
	    Files.write(file_, passwordToBytes, StandardOpenOption.APPEND);

	    //String read = Files.readAllLines(file_).get(0);
	    // assertEquals(str, read);
	      
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
    }

    //Retrieve data
    public String[] retrieve_user_info()  {
        String file_link = "./camera_gui.properties";

	
	try {
	    Path file_ = Paths.get(file_link);
	    String username = Files.readAllLines(file_).get(0);
	    String password = Files.readAllLines(file_).get(1);

	    return new String[] {username, password};

	} catch (IOException e){
	    System.out.println("properties file created.");

	    //e.printStackTrace();
	}
	return null;
    } 

    public void delete_properties_file() {
	try {
	    File file_ = new File("./camera_gui.properties");
	    file_.delete();
	} catch (Exception e) {
	    
	}
	

    }

    
    public static void main(String arg[]) {
	configuration configs = new configuration();
	// configs.start();
	// configs.configure_file("Test_1", "
	configs.retrieve_user_info();
    }
}

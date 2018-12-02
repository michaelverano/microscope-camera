package camera.operations;
import java.io.*;

public class take_picture {

    public String start() {
	String s = null;

	try {
	    // run gphoto2 --capture-image
	    Process p = Runtime.getRuntime().exec("gphoto2 --capture-image");

	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	    System.out.println("Running gphoto2 --capture-image");
	    while ((s = stdInput.readLine()) != null) {
		System.out.println(s);
	    }

	
	    if (stdError.readLine() != null) {
	    System.out.println("An error occured when running the program: ");
	    	while ((s = stdError.readLine()) != null) {
		    	System.out.println(s);
		}
	    }


	}
	catch (IOException e) {
	    e.printStackTrace();

	    return "Camera Error";
	    
	}

	return null;
    }

    public static void main(String arg[]) {
	take_picture take_a_pic = new take_picture();
	take_a_pic.start();
    }

}
	

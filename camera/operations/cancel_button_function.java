package camera.operations;
import java.io.*;

public class cancel_button_function {
    public void start() {
	String s = null;

	try {
	    // run *.properties
	    Process p = Runtime.getRuntime().exec("rm camera_gui.properties");

	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	    System.out.println("Removing camera_gui.properties files");
	    while ((s = stdInput.readLine()) != null) {
		System.out.println(s);
	    }

	}

	catch (IOException e) {
	    System.out.println("An error occurred when running cancel_button_function.");
	    e.printStackTrace();
	    System.exit(-1);
	}

    }

    public static void main(String args[]) {
	cancel_button_function cancel_button = new cancel_button_function();
	cancel_button.start();
    }

}

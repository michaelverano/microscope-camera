import java.io.*;

public class detect_camera {
    public static void main(String args[]) {
	String s = null;
	
	try {
	    // run gphoto2 --auto-detect command
	    Process p = Runtime.getRuntime().exec("gphoto2 --auto-detect");

	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	    System.out.println("Running gphoto2 --autodetect");
	    while ((s = stdInput.readLine()) != null) {
		System.out.println(s);
	    }

	    // Escape program if no runtime stdErrors exist.
	    if (stdError.readLine() == null) {
		System.exit(0);
	    }

		
	    System.out.println("An error occured when running the program: ");
	    while ((s = stdError.readLine()) != null) {
		System.out.println(s);
	    }

	    System.exit(0);
	}

	catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}
        
    }
}

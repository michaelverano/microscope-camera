//package camera.operations;
import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class detect_camera_test {

    public void start() {
	String s = null;
	
	try {
	    // run gphoto2 --auto-detect command
	    Process p = Runtime.getRuntime().exec("gphoto2 --auto-detect");

	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	    System.out.println("Running gphoto2 --autodetect");

	    //List<String> outputList = new ArrayList<String>();
	    //outputList.add("Running gphoto2 --autodetect");
	    while ((s = stdInput.readLine()) != null) {
		System.out.println(s);
		//outputList.add(s);
	    }

	    // warning for errors.
	    if (stdError.readLine() != null) {
		System.out.println("An error occured when running the program: ");
		System.out.println(s);
	    }
		
	    
	}

	catch (IOException e) {
	    e.printStackTrace();
	    System.exit(-1);
	}

    }

    public static void main(String args[]) {
	detect_camera_test auto_detect = new detect_camera_test();
	auto_detect.start();
    }
}

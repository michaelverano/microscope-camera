//package camera.operations;
import java.io.*;

public class download_pictures {

    public void start() {
	String s = null;

	try {
	    //run gphoto2 --get-all-files
	    Process p = Runtime.getRuntime().exec("gphoto2 --get-all-files");

	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	    System.out.println("Running gphoto2 --get-all-files");
	    while ((s = stdInput.readLine()) != null) {
		System.out.println(s);
	    }

	    if (stdError.readLine() != null) {
		System.out.println("An Error Occurred when running the program: ");
		while ((s = stdError.readLine()) != null) {
		    System.out.println(s);
		}
	    }
	}

	catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String argsp[]) {
	download_pictures download_pics = new download_pictures();
	download_pics.start();
    }
}

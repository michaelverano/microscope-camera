import java.io.*;


public class java_bash_test {
    

    public static void main(String args[]) {
	String s = null;

	try {
	    
	    // run the unix "ls" command
	    // using the Runtime exec method:
	    Process p = Runtime.getRuntime().exec("gphoto2 --capture-image-and-download");

	    BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

	    BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

	    System.out.println("Here are the items in your current directory.\n");
	    while ((s = stdInput.readLine()) != null) {
		System.out.println(s);
	    }

	    // read any errors from the attempted command
	    System.out.println("Here is the standard error of the command (if any):\n");
	    while ((s = stdError.readLine()) != null) {
		System.out.println(s);
	    }

	    System.exit(0);
	
	}

	catch (IOException e) {
	    System.out.println("An exception occured:");
	    e.printStackTrace();
	    System.exit(-1);
	}
    }
}

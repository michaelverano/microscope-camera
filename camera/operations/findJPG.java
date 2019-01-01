package camera.operations;
import java.io.*;
import java.util.*;

public class findJPG {
    
    public String start() {
        File folder = new File(".");
	File[] listOfFiles = folder.listFiles();
	ArrayList<String> JPGs = new ArrayList<String>(0);
	
	for (int i = 0; i < listOfFiles.length; i++) {
	    if (listOfFiles[i].toString().endsWith(".JPG")) {
		//System.out.println(listOfFiles[i].toString());
		JPGs.add(listOfFiles[i].toString());
	    }
	    
	}

	//System.out.println(JPGs.toString());


	if (JPGs.size() == 0) {
	    return  "No JPGs found.";	
	}
	
	if (JPGs.size() == 1) {
	    System.out.println(JPGs.get(0));
	    //System.out.println("Test");
	    return JPGs.get(0);
	}

	if (JPGs.size() > 1) {
	    return "More than one JPG found.";
	}

	return "test 2";
    }
    
    public static void main(String args[]) {
	findJPG find_jpg = new findJPG();
        String jpg_file = find_jpg.start();
    }
}

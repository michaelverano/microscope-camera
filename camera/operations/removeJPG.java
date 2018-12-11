package camera.operations;
import java.io.*;
import java.util.*;

public class removeJPG {

    public void start() {
	File folder = new File(".");
	File[] listOfFiles = folder.listFiles();

	//System.out.println(Arrays.toString(listOfFiles));
	//System.out.println(listOfFiles.length);
	
        for (int i = 0; i < listOfFiles.length; i++) {
	    if (listOfFiles[i].toString().endsWith(".JPG")) {
		System.out.println("Deleting " + listOfFiles[i].toString());
		listOfFiles[i].delete();
	    }
	    
	}
    }
	
    
    public static void main(String args[]) {
	removeJPG remove_jpg = new removeJPG();
	remove_jpg.start();	
    }
}

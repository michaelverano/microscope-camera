package camera.operations;
import java.io.*;
import java.util.*;

public class parse_text {
    
    public String start() {
	String textString = "Saving file as P1010003.JPG";

	System.out.println(textString);

	// split string
	String[] splitted = textString.split(" ");

	System.out.println(Arrays.toString(splitted));

	// Get last item
	String last_item = splitted[splitted.length-1];

	System.out.println(last_item);
	return last_item;
	
    }

    
    public static void main(String arg[]) {
	parse_text parse_text = new parse_text();
	String outPutItem = parse_text.start();
	System.out.println(outPutItem);
    }
}

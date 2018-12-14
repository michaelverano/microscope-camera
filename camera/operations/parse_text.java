package camera.operations;
import java.io.*;
import java.util.*;

public class parse_text {
    
    public String start(String jpg_file) {
	String textString = jpg_file;

	//System.out.println(textString);

	// split string
	String[] splitted = textString.split(" ");
	
	//System.out.println(Arrays.toString(splitted));

	// Get last item
	String last_item = splitted[splitted.length-1];

	// Strip the ./
	String cleaned_item = last_item.replace("./", "");
	
	//System.out.println(cleaned_item);
	return cleaned_item;
	
    }

    
    public static void main(String arg[]) {
	parse_text parse_text = new parse_text();
	String outPutItem = parse_text.start("./1010101.JPG");
	System.out.println(outPutItem);
    }
}

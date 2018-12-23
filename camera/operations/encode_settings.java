package camera.operations;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

import java.lang.*;
import java.lang.String;
import java.nio.charset.StandardCharsets;

public class encode_settings {
    public String[] start_encoding(String user_name, String pass_word) {
	byte[] password_message = pass_word.getBytes(StandardCharsets.UTF_8);
	String encoded_password = Base64.getEncoder().encodeToString(password_message);
	//System.out.println(encoded_password);

	byte[] user_message = user_name.getBytes(StandardCharsets.UTF_8);
	String encoded_user = Base64.getEncoder().encodeToString(user_message);
	//System.out.println(encoded_user);

	//Testing only
        encode_settings decode_tests = new encode_settings();
	decode_tests.start_decoding(encoded_user, encoded_password);

	return new String[] {encoded_user, encoded_password} ;

    }

    public String[] start_decoding(String encoded_user, String encoded_password) {
	byte[] decoded_user = Base64.getDecoder().decode(encoded_user);
	String utf8_user = new String(decoded_user, StandardCharsets.UTF_8);
	//System.out.println(utf8_user);

	byte[] decoded_password = Base64.getDecoder().decode(encoded_password);
	String utf8_password = new String(decoded_password, StandardCharsets.UTF_8);
	//System.out.println(utf8_password);

	return new String[] {utf8_user, utf8_password};
    }
    
    

    public static void main(String[] args) {
	encode_settings encoding = new encode_settings();
	encoding.start_encoding("hello", "world");
    }
}

package encryption;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class FileOperations {

	// Create a directory, Declaring path and file name
	private static final String DIRECTORY_PATH = "data/";
	private static final String FILE_NAME = "encrypted.txt";
	public static String text;

	// create directory method that checks if directory exists
	public static void createDir() {
		File directory = new File(DIRECTORY_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
		}

	}

	// generate random text to encrypt and decrypt
	public static String generateText() throws IOException {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10; // length
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		text = generatedString;
		return generatedString;
	}
	
	public static void writeText(String text) throws IOException{
		Files.write(Paths.get(DIRECTORY_PATH + FILE_NAME), text.getBytes());

	}

	// read text from file
	public static String readText() throws IOException {
		return new String(Files.readAllBytes(Paths.get(DIRECTORY_PATH + FILE_NAME)));
	}

}

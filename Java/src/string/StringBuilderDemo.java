package string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StringBuilderDemo {
	
	public static void main(String[] args) throws IOException{
		long timeStart = System.currentTimeMillis();
		String result = readAllLinesFromFile();
		System.out.println(result);
		long delta1 = (System.currentTimeMillis() - timeStart);
		System.out.println("------");
		
		timeStart = System.currentTimeMillis();
		result = readAllLinesFromFileWithStringBuilder();
		System.out.println(result);
		long delta2 = (System.currentTimeMillis() - timeStart);
		System.out.println("-------");
		
		System.out.println("Time for operation with string " + delta1);
		System.out.println("Time for operation with StringBuilder " + delta2);
		
		
	}
	
	private static String readAllLinesFromFile() throws IOException{
		String resultString = "";
		List<String> allines = Files.readAllLines(Paths.get("test.txt"));
		for (String line : allines) {
			resultString += line;
			resultString += System.lineSeparator();
		}
		return resultString;
	}
	
	private static String readAllLinesFromFileWithStringBuilder() throws IOException{
		StringBuilder sb = new StringBuilder();
		List<String> allines = Files.readAllLines(Paths.get("test.txt"));
		for (String	line : allines) {
			sb.append(line).append(System.lineSeparator());
		}
		return sb.toString();

	}

}

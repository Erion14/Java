 package inputandoutputstreams;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	
	public static void main(String[] args) throws IOException{
		File file = new File("testDirectory");
		file.mkdir();
		
		file = new File("testDirectory2\\inerTestDirectory");
		file.mkdirs();
		
		file = new File("testDirectory3" + File.separator + "innerTestDirectory");
		if (file.mkdirs()) {
			System.out.println("Success");
		} else {
			System.out.println("Files exist");
		}
		
		System.out.println("File separator : " + File.separator);
		System.out.println("Path separator : " + file.pathSeparator );
		
		String toWrite = "asdasdasd" + System.lineSeparator() + "new line";
		
		
		file = new File("result.csv");
		file.createNewFile();
		
		file.exists();
		if (file.isDirectory()) {
			File[] files = file.listFiles();
		}
		
		file.getAbsolutePath();
		file.canExecute();
		file.isFile();
		file.isHidden();
		
		File[] listFiles = file.listFiles(pathname -> pathname.getName().endsWith(".java"));
		
		new File("C:\\Program Files\\Java");
		
	}
}

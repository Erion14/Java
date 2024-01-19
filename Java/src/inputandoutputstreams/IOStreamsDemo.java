package inputandoutputstreams;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamsDemo {

		public static void main(String[] args) throws IOException {
			String filepath = "testDirectory" + File.separator + "demo.txt";
			String textToWrite = "Some text example " + System.lineSeparator() + "with Line separator and cyrylic "
					+ "characters: Erioni bossi " + System.lineSeparator();
			
			writeFileToPathFileOutputStream(filepath, textToWrite);
			
			
			
		}
		private static void writeFileToPathFileOutputStream(String path, String textToWrite) 
				throws FileNotFoundException, IOException{
					FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(path);
					byte[] bytes = textToWrite.getBytes();
					fos.write(bytes);
				} finally {
					if (fos != null) {
						fos.close();
					}
				}
				}
		private static void writeFileToPathFileOutputStreamWithBuffer(String path, String textToWrite)
				throws FileNotFoundException, IOException{
			try(var fbos = new BufferedOutputStream(new FileOutputStream(path))){
				fbos.write(textToWrite.getBytes());
			}
		}
		
}

package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	static private FileHandler simpleTextFileHandler;
	static private SimpleFormatter simpleFormatter;
	
	static private FileHandler htmlFileHandler;
	static private Formatter htmlFormatter;
	
	static public void setup() throws IOException{
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.setLevel(Level.FINE);
		
		simpleTextFileHandler.setLevel(Level.SEVERE);
		
		
		// Txt formatter
		simpleFormatter = new SimpleFormatter();
		simpleTextFileHandler.setFormatter(simpleFormatter);
		logger.addHandler(simpleTextFileHandler);
		
		// html formatter
		htmlFormatter = new SimpleFormatter();
		htmlFileHandler.setFormatter(htmlFormatter);
		logger.addHandler(htmlFileHandler);
	}

}

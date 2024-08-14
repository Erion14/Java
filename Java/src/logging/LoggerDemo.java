package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerDemo {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static FileHandler simpleTextFileHandler;

    public static void setup() throws IOException {
        // Initialize the FileHandler
        simpleTextFileHandler = new FileHandler("mylog.txt", true);
        simpleTextFileHandler.setFormatter(new SimpleFormatter());

        // Attach the FileHandler to the logger
        LOGGER.addHandler(simpleTextFileHandler);
    }

    public void doSomethingAndLog() {
        LOGGER.setLevel(Level.SEVERE);
        
        LOGGER.severe("SEVERE Log");
        LOGGER.warning("WARNING Log");
        LOGGER.info("Info Log");
        LOGGER.finest("FINEST Really not important");

        LOGGER.setLevel(Level.INFO);
        LOGGER.severe("SEVERE Log");
        LOGGER.warning("WARNING Log");
        LOGGER.info("Info Log");
        LOGGER.finest("Finest Really not important");
    }

    public static void main(String[] args) {
        LoggerDemo loggerDemo = new LoggerDemo();
        try {
            // Corrected the method call to use LoggerDemo.setup()
            LoggerDemo.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        loggerDemo.doSomethingAndLog();
    }
}

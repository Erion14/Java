package inputandoutputstreams.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigMap {
	
	public String getValueFromConfigMap(Path configMapFilePath, String keyname)
					throws IOException{
		
	Properties properties = new Properties();
	
	properties.load(Files.newBufferedReader(configMapFilePath));
	
	Map<String, String> configMap = new HashMap<>();
	properties.forEach((key,value) -> configMap.put(key.toString(), value.toString()));
	
	return configMap.get(keyname);
		
	}
}

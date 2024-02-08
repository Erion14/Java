package annotation;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	@SuppressWarnings(value = "rawtypes")
	public static void main(String[] args) {
		List list = new ArrayList();
	}
	
	@Override
	@Author(name = "Erion Ademi")
	public String toString() {
		return "Demo ";
	}

}

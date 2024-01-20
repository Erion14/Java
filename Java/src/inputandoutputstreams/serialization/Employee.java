package inputandoutputstreams.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class Employee implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private Map<String, String> props;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getProps() {
		return props;
	}
	public void setProps(Map<String, String> props) {
		this.props = props;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", props=" + props + "]";
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		oos.defaultWriteObject();
		System.out.println("Serialization in progress");
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
		ois.defaultReadObject();
		System.out.println("Deserialization in progress");
	}
	
	
	
	
	

	
	
}

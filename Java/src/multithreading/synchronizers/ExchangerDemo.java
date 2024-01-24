package multithreading.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;

public class ExchangerDemo {
	
	public static void main(String[] args) throws InterruptedException{
		Exchanger<String> exchanger = new Exchanger<>();
	
		Runnable task1 = () -> {
			try {
				String msg = exchanger.exchange("message from task 1");
				System.out.println("Received from another thread in task 1: " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable task2 = () -> {
			try {
				String msg = exchanger.exchange("message from task 2");
				System.out.println("Received from another thread in task 2: " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		var es = Executors.newCachedThreadPool();
		es.submit(task1);
		es.submit(task2);
		
		es.shutdown();
	}

}

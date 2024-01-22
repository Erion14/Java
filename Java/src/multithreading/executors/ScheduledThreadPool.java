package multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {
		var es = Executors.newScheduledThreadPool(4);
		es.schedule(() -> System.out.println("Scheduled Example " + Thread.currentThread().getName()), 1, TimeUnit.MILLISECONDS);
		es.shutdown();
	}

}

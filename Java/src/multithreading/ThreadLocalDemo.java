package multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo implements Runnable {

	private static ThreadLocal<Integer> transactionId = new ThreadLocal<Integer>();

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalDemo runnable = new ThreadLocalDemo();

		var thread1 = new Thread(runnable);
		var thread2 = new Thread(runnable);

		thread1.start();
		thread2.start();
	}

	public void run() {
		transactionId.set((int) (Math.random() * 100));
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
		}
		System.out.println(transactionId.get());
	}
}

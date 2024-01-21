package multithreading;

import java.util.concurrent.TimeUnit;

public class InhertiableThreadLocalDemo {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
	private static InheritableThreadLocal<String> inhertiableThreadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			System.out.println("-Thread 1 -");
			threadLocal.set("-Thread 1 - ThreadLocal-");
			inhertiableThreadLocal.set("--Thread 1 - InheritableThreadLocal--");

			System.out.println(threadLocal.get());
			System.out.println(inhertiableThreadLocal.get());

			Thread childThread = new Thread(() -> {
				System.out.println("--Child thread--");
				System.out.println(threadLocal.get());
				System.out.println(inhertiableThreadLocal.get());
			});
			childThread.start();

		});
		thread1.start();

		Thread thread2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {

			}
			System.out.println("--Thread 2 --");
			System.out.println(threadLocal.get());
			System.out.println(inhertiableThreadLocal.get());
	
		});
	thread2.start();
	}

}

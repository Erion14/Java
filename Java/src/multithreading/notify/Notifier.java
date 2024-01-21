package multithreading.notify;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable {
	private Message message;

	public Notifier(Message message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " started");
		try {
			TimeUnit.MILLISECONDS.sleep(199);
			synchronized (message) {
				message.setMessage(name + " Notifier work done");
				message.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Notifier work done");

	}

}

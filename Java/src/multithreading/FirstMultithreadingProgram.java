package multithreading;

public class FirstMultithreadingProgram extends Thread {
	public static void main(String[] args) {
		Runnable task = new DefaultRunnable();
		Thread t1 = new Thread(task);

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("New thread! name is :" + Thread.currentThread().getName());
			}
		});
		Thread t3 = new FirstMultithreadingProgram();

		Thread t4 = new Thread(
				() -> System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName()));

		Thread t5 = new Thread(FirstMultithreadingProgram::execute);

		System.out.println("Current thread name is " + Thread.currentThread().getName());
		t1.run(); // will also be executed in main thread

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

	public static void execute() {
		System.out.println("New thread Name is: " + Thread.currentThread().getName());
	}

	@Override
	public void run() {
		System.out.println("New thread Name is: " + Thread.currentThread().getName());
	}

}

class DefaultRunnable implements Runnable {

	private String externalString;

	public DefaultRunnable(String externalString) {
		super();
		this.externalString = externalString;
	}

	public DefaultRunnable() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I'm a new thread! Im :" + Thread.currentThread().getName());

	}

}
package multithreading.exercises;

import java.util.concurrent.TimeUnit;

public class Ex3 implements Runnable {
	
	public int counter1 = 0;
	
	public int counter2 = 0;

	@Override
	public void run() {
		try {
			synchronized(this) {
			while (true) {
				System.out.println(counter1 + " == " + counter2);
				counter1++;
				TimeUnit.MILLISECONDS.sleep(10);
				counter2++;
				TimeUnit.MILLISECONDS.sleep(10);
			}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		Ex3 obj = new Ex3();
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		
		t1.start();
		t2.start();
		
		TimeUnit.SECONDS.sleep(3);
		t1.interrupt();
		t2.interrupt();
	}

}

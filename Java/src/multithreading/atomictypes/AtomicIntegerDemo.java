package multithreading.atomictypes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import multithreading.synchronizedblock.SynchronizedIncrement;

public class AtomicIntegerDemo {
	
	private static AtomicInteger counter = new AtomicInteger();
	
	public static void main(String[] args)  throws InterruptedException{
		List<Thread> allThreads = new ArrayList<>();
		int numberOfIncrements = 10000;
		
		for (int i = 0; i < numberOfIncrements; i++) {
			var t = new Thread(AtomicIntegerDemo::increment);
			allThreads.add(t);
			t.start();
		}
		
		for (Thread thread : allThreads) {
			thread.join();
		}
		
		System.out.println(counter);
		}
	public synchronized static void increment() {
		counter.incrementAndGet();
	}
	}



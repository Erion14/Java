package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
	public static void main(String[] args) {
        AtomicInteger atomicCounter = new AtomicInteger(0);

        // Atomic increment
        int incrementedValue = atomicCounter.incrementAndGet();
        System.out.println("Incremented Value: " + incrementedValue);

        // Atomic decrement
        int decrementedValue = atomicCounter.decrementAndGet();
        System.out.println("Decremented Value: " + decrementedValue);

        // Atomic update
        atomicCounter.updateAndGet(value -> value * 2);
        System.out.println("Updated Value: " + atomicCounter.get());
    }
}

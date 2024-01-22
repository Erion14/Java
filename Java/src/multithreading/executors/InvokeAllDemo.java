package multithreading.executors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAllDemo {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		List<Callable<String>> tasks = List.of(() -> "Task 1", () -> "Task 2", () -> "Task 3");

		try {
			List<String> results = executorService.invokeAll(tasks).stream().map(future -> {
				try {
					return future.get();
				} catch (InterruptedException | ExecutionException e) {
					throw new RuntimeException(e);
				}
			}).toList();

			results.forEach(System.out::println);
		} finally {
			executorService.shutdown();
		}
	}
}

package multithreading.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiDimensionalArrayDemo {

	private static final int COLUMNS = 100;
	private static final int ROWS = 4;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[][] matrix = SearchEngine.createRandomMatrix(ROWS, COLUMNS);

		SearchEngine se = new SearchEngine(matrix);

		System.out.println("==== Demo of Multithreading Search====");
		System.out.println("Max element in matrix: " + se.getMaxElementInMatrixMultiThreading());
		System.out.println("Time of multithreading search: " + se.getTimeOfMultiThreadingSearch());

		System.out.println();
		System.out.println("--- Demo of Single-thread search ---");
		System.out.println("Max element in matrix: " + se.getMaxElementInMatrixSingleThreading());
		System.out.println("Time of singlethreading search: " + se.getTimeOfSingleThreadingSearch());

		System.out.println("\n Printing the futureList: ");
		for (Future<Integer> future : se.getFutureList()) {
			System.out.println(future.get());
		}

	}

}

class SearchEngine {

	private int[][] matrix;

	private int maxInMatrix;

	private long timeOfMultiThreadingSearch;

	private long timeOfSingleThreadingSearch;

	
	private List<Future<Integer>> futuresList;

	public SearchEngine(int[][] matrix) {
		this.matrix = matrix;
		futuresList = new ArrayList<>();
	}

	
	public long getTimeOfMultiThreadingSearch() {
		return timeOfMultiThreadingSearch;
	}

	
	public long getTimeOfSingleThreadingSearch() {
		return timeOfSingleThreadingSearch;
	}

	public List<Future<Integer>> getFutureList() {
		return futuresList;
	}

	
	public int getMaxElementInMatrixMultiThreading() throws InterruptedException, ExecutionException {
		Callable<Integer>[] arrFinders = createFindersForArray(this.matrix);
		long start = System.nanoTime();
		runFinders(arrFinders);
		maxInMatrix = findMaxOfAllThreads(futuresList);
		long finish = System.nanoTime();
		timeOfMultiThreadingSearch = (finish - start) / 1_000_000;
		return maxInMatrix;
	}

	private Callable<Integer>[] createFindersForArray(int[][] matrix) {
		Finder[] finders = new Finder[matrix.length];
		IntStream.range(0, finders.length).forEach(i -> finders[i] = new Finder(i));
		return finders;
	}

	
	private void runFinders(Callable<Integer>[] arrFinders) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<Integer>> futures = es.invokeAll(Arrays.asList(arrFinders));
		this.futuresList.addAll(futures);
		es.shutdown();
	}

	
	private int findMaxInRow(int row) throws InterruptedException {
		int maxInRow = matrix[row][0];
		for (int j = 1; j < matrix[row].length; j++) {
			TimeUnit.MILLISECONDS.sleep(1);
			if (maxInRow < matrix[row][j]) {
				maxInRow = matrix[row][j];
			}
		}
		return maxInRow;
	}

	
	private int findMaxOfAllThreads(List<Future<Integer>> futureList) throws ExecutionException, InterruptedException {
		int max = futureList.get(0).get();
		for (Future<Integer> future : futureList) {
			if (future.get() > max) {
				max = future.get();
			}
		}
		return max;
	}

	
	public int getMaxElementInMatrixSingleThreading() throws InterruptedException {
		long start = System.nanoTime();
		int maxInRow = matrix[0][0];
		int max = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			maxInRow = findMaxInRow(i);
			if (maxInRow > max) {
				max = maxInRow;
			}
		}
		long finish = System.nanoTime();
		timeOfSingleThreadingSearch = (finish - start) / 1_000_000;
		return max;
	}

	

	public static int[][] createRandomMatrix(int rows, int cols) {
		Random random = new Random();
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = random.nextInt();
			}
		}
		return matrix;
	}

	private class Finder implements Callable<Integer> {

		private int threadId;

		public Finder(int threadId) {
			this.threadId = threadId;
		}

		@Override
		public Integer call() throws Exception {
			int maxOfThread = findMaxInRow(threadId);
			return maxOfThread;
		}

	}

}

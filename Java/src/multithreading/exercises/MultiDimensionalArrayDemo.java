package multithreading.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiDimensionalArrayDemo {

	private static final int COLUMNS = 100;
	private static final int ROWS = 4;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

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

	public List<Future<Integer>> getFuturesList() {
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

	private int findMaxOfAllThreads(List<Future<Integer>> futuresList) 
			throws InterruptedException, ExecutionException {
		int max = futuresList.get(0).get();
		for (Future<Integer> future : futuresList) {
			if(future.get()>max) {
				max = future.get();
			}
		}
		return max;
	}

	private void runFinders(Callable<Integer>[] arrFinders) {
		// TODO Auto-generated method stub

	}

	private Callable<Integer>[] createFindersForArray(int[][] matrix) {
		Finder[] finders = new Finder[matrix.length];
		IntStream.range(0, finders.length).forEach(i -> finders[i] = new Finder(i));
		return finders;
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

	public int findMaxInRow(int row) throws InterruptedException {
		int maxInRow = matrix[row][0];
		for (int i = 0; i < matrix[row].length; i++) {
			TimeUnit.MILLISECONDS.sleep(1);
			if (maxInRow < matrix[row][i]) {
				maxInRow = matrix[row][i];
			}

		}
		return maxInRow;
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

}

class Finder implements Callable<Integer> {
	private int threadId;
	private SearchEngine searchEngine;

	public Finder(int threadId) {
		this.threadId = threadId;
	}

	@Override
	public Integer call() throws Exception {
		int maxOfThread = searchEngine.findMaxInRow(threadId);
		return maxOfThread;
	}
}
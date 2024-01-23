package multithreading.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWithThreads {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		SumTask sumTask = new SumTask(array, 0, array.length);

		int result = forkJoinPool.invoke(sumTask);

		System.out.println("Result: " + result);

		forkJoinPool.shutdown();
	}

}

class SumTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 5;
	private int[] array;
	private int start, end;

	public SumTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	protected Integer compute() {
		if (end - start <= THRESHOLD) {
			int sum = 0;
			for (int i = start; i < end; i++) {
				sum += array[i];
			}
			return sum;
		} else {
		
			int mid = (start + end) / 2;
			SumTask leftTask = new SumTask(array, start, mid);
			SumTask rightTask = new SumTask(array, mid, end);

			leftTask.fork();
			rightTask.fork();

			int leftResult = leftTask.join();
			int rightResult = rightTask.join();

			return leftResult + rightResult;
		}
	}
}
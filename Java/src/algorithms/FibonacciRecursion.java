package algorithms;

public class FibonacciRecursion {
	public static void main(String[] args) {
	int n = 10;
	
	System.out.println("Fibonacci sequence");
	
	for (int i = 0; i < n; i++) {
		System.out.println(fibonacci(i) + " ");
	}
	
	}
	

	
	
	
	public static int fibonacci(int x) {
		if ( x <= 1) {
			return x;
		}
		else {
			return fibonacci(x - 1) + fibonacci(x - 2);
		}
	}
}

package algorithms;

public class FactorialRecursion {

	public static void main(String[] args) {
		int n = 5;
		System.out.println(factorial(n));
	}

	public static int factorial(int x) {
		int result = 0;
		if (x == 1) {
			return x;
		} else {

			return x * factorial(x - 1);
		}
	}
}

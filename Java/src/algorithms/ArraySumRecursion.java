package algorithms;

import java.util.Arrays;

public class ArraySumRecursion {
	
	
	public static void main(String[] args) {
		 int[] numbers = {4, 2, 6, 2};
	        int sum = sumArray(numbers);
	        System.out.println("Sum of array elements: " + sum);
		
	}

	
	
	public static int sumArray(int[] array) {
		 if (array.length == 0) {
	            return 0; // Base case: Empty array has sum 0
	        } else {
	        	 return array[0] + sumArray(Arrays.copyOfRange(array, 1, array.length));
	        }
	    
		
		
		
	}
	
	
	
}

package algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class SelectionSort {

	public static void main(String[] args) {
		int[] numbers = new int[5];

		numbers[0] = 4;
		numbers[1] = 20;
		numbers[2] = 5;
		numbers[3] = 9;
		numbers[4] = 10;
		
		System.out.println(findSmallest(numbers));
		System.out.println(Arrays.toString(selectionSort(numbers)));

	}

	public static int findSmallest(int[] array) {
	    int smallestIndex = 0;

	    for (int i = 1; i < array.length; i++) {
	        if (array[i] < array[smallestIndex]) {
	            smallestIndex = i;
	        }
	    }
	    return smallestIndex;
	}
	
	public static int[] selectionSort(int[] array) {
	    int length = array.length;

	    for (int i = 0; i < length - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < length; j++) {
	            if (array[j] < array[minIndex]) {
	                minIndex = j;
	            }
	        }
	        int temp = array[minIndex];
	        array[minIndex] = array[i];
	        array[i] = temp;
	    }

	    return array;
	}
}

package algorithms;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		// Declare array with 5 numbers
		int[] numbers = new int[5];

		numbers[0] = 4;
		numbers[1] = 1;
		numbers[2] = 5;
		numbers[3] = 9;
		numbers[4] = 10;

		Arrays.sort(numbers);

//		Print the guess
		System.out.println(binarysearch(numbers, 10));

	}

	public static int binarysearch(int[] numbers, int gues) {
		int low = 0;
		int high = numbers.length - 1;

//		While we haven't narrowed it down to one element keep running
		while (low <= high) {
//			mid is low + high divided by two which tells us the middle element
			int mid = (low + high) / 2;
//			The first is to check the middle element
			int guess = numbers[mid];
//			If its the middle element return the middle element
			if (guess == gues) {
				return mid;
			}
//			If the guess is too high make the high point of the array one before the middle
			if (guess > gues) {
				high = mid - 1;
// 			If the guess was too low make the middle value higher than the previous middle
			} else {
				low = mid + 1;
			}

		}
		return -1; // Element was not found

	}

}

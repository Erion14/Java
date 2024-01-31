package algorithms;

import java.util.Arrays;


public class BinarySearchRecursion {

    public static void main(String[] args) {
        int[] numbers = { 4, 1, 5, 9, 10 };
        Arrays.sort(numbers);
        System.out.println(binarySearch(numbers, 10, 0, numbers.length - 1));
    }

    public static int binarySearch(int[] numbers, int guess, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            int gues = numbers[mid];

            if (gues == guess) {
                return mid;
            } else if (gues < guess) { 
                return binarySearch(numbers, guess, mid + 1, high);
            } else {
                return binarySearch(numbers, guess, low, mid - 1);
            }
        }
        return -1;
    }
}
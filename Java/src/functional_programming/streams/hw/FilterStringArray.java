package functional_programming.streams.hw;

import java.util.Arrays;
import java.util.Scanner;

public class FilterStringArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter words seperated by space ");
		String userInput = sc.nextLine();
		System.out.println("Please, enter a minumum word length to filter words :");
		int minLength = sc.nextInt();
		
		String[] words = userInput.split("\\s+");
		String[] filteredWords = filterWordsByLength(minLength, words);
		System.out.println(Arrays.toString(filteredWords));
	}

	private static String[] filterWordsByLength(int minLength, String[] words) {
		return Arrays.stream(words)
				.filter(s -> s.length() >= minLength)
				.toArray(String[]::new);
		
	}

}

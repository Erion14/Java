package multithreading.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordCounter {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter your text:");
		String inputText = scanner.nextLine();

		Map<String, Integer> wordCounts = countWords(inputText);
		printWordCounts(wordCounts);

		scanner.close();
	}

	private static Map<String, Integer> countWords(String text) {
		List<String> tokens = tokenizeText(text);

		int numThreads = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);

		List<Future<Map<String, Integer>>> futures = new ArrayList<>();

		int chunkSize = tokens.size() / numThreads;
		int startIndex = 0;

		for (int i = 0; i < numThreads; i++) {
			int endIndex = (i == numThreads - 1) ? tokens.size() : startIndex + chunkSize;
			List<String> subTokens = tokens.subList(startIndex, endIndex);
			startIndex = endIndex;

			WordCounterTask task = new WordCounterTask(subTokens);
			futures.add(executor.submit(task));
		}

		Map<String, Integer> wordCounts = new ConcurrentHashMap<>();
		for (Future<Map<String, Integer>> future : futures) {
			try {
				Map<String, Integer> partialCounts = future.get();
				mergeWordCounts(wordCounts, partialCounts);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		executor.shutdown();
		return wordCounts;
	}

	private static List<String> tokenizeText(String text) {
		List<String> tokens = new ArrayList<>();
		String[] words = text.split("\\s+");
		for (String word : words) {
			word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
			if (!word.isEmpty()) {
				tokens.add(word);
			}
		}
		return tokens;
	}

	private static void mergeWordCounts(Map<String, Integer> wordCounts, Map<String, Integer> partialCounts) {
		for (Map.Entry<String, Integer> entry : partialCounts.entrySet()) {
			wordCounts.merge(entry.getKey(), entry.getValue(), Integer::sum);
		}
	}

	private static void printWordCounts(Map<String, Integer> wordCounts) {
		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}

class WordCounterTask implements Callable<Map<String, Integer>> {
	private final List<String> tokens;

	public WordCounterTask(List<String> tokens) {
		this.tokens = tokens;
	}

	@Override
	public Map<String, Integer> call() {
		Map<String, Integer> wordCounts = new HashMap<>();
		for (String token : tokens) {
			wordCounts.put(token, wordCounts.getOrDefault(token, 0) + 1);
		}
		return wordCounts;
	}
}

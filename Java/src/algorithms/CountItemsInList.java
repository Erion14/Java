package algorithms;

public class CountItemsInList {
	public static void main(String[] args) {
		int[] array = { 1, 4, 5, 2, 3, 4 };
		int count = countlist(array, 0);
		System.out.println(count);
	}

	public static int countlist(int[] array, int index) {
		if (index >= array.length) {
			return 0; 
		} else {
			return 1 + countlist(array, index + 1); 
		}
	}
}
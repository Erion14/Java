package algorithms;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
	    numbers.add(5);
	    numbers.add(2);
	    numbers.add(3);
	    List<Integer> sortedNumbers = quicksort(numbers);
	    System.out.println(sortedNumbers);
	
	}
	
	  
	  
	  public static List<Integer> quicksort(List<Integer> array) {
	        if (array.size() < 2) {
	            return array;
	        } else {
	            int pivot = array.get(0);
	            List<Integer> less = new ArrayList<>();
	            List<Integer> greater = new ArrayList<>();

	            for (int i = 1; i < array.size(); i++) {
	                if (array.get(i) <= pivot) {
	                    less.add(array.get(i));
	                } else {
	                    greater.add(array.get(i));
	                }
	            }

	            List<Integer> sorted = new ArrayList<>();
	            sorted.addAll(quicksort(less));
	            sorted.add(pivot);
	            sorted.addAll(quicksort(greater));
	            return sorted;
	        }
	    }

	

	  }

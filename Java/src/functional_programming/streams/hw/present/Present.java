package functional_programming.streams.hw.present;

import java.util.Arrays;
import java.util.Objects;

public class Present {
	
	private static final int DEFAULT_GIFT_CAPACITY = 10;
	private Sweet[] sweets;
	private int lastIndexAdded;
	
	{
		sweets = new Sweet[DEFAULT_GIFT_CAPACITY];
	}
	
	public void addSweet(Sweet sweet) {
		if(sweet == null) {
			return;
		}
		if (sweets.length <= lastIndexAdded) {
			sweets = Arrays.copyOf(sweets,	sweets.length * 2);
			
		}
		sweets[lastIndexAdded++] = sweet;
	}
	
	public double calculateTotalWeight() {
		return Arrays.stream(sweets)
				.filter(Objects::nonNull)
				.mapToDouble(sweet -> sweet.getWeight())
				.sum();
	}
	
	public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
		return Arrays.stream(sweets)
				.filter(Objects::nonNull)
				.filter( (sweet) -> {
					if (sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight) {
						return true;
						
					} else {
						return false;
					}
				})
				.toArray(Sweet[]::new);
	}
	
	public Sweet[] getSweets() {
		return Arrays.stream(sweets)
				.filter(Objects::nonNull)
				.toArray(Sweet[]::new);
	}

}

package functional_programming.streams.hw.present;

import java.util.Arrays;

public class Demo {
	
	public static void main(String[] args) {
		Sweet candy = new ChocolateCandy();
		candy.setName("Toblerone");
		candy.setSugarWeight(0.54);
		candy.setWeight(0.05);
		
		Cookie cookie = new Oreo();
		cookie.setName("Oreo");
		cookie.setDoughWeight(0.3);
		cookie.setSugarWeight(0.1);
		cookie.setWeight(0.2);
		
		Sweet lollipop = new Lollipop();
		lollipop.setName("Strawberry");
		lollipop.setWeight(0.4);
		lollipop.setSugarWeight(0.3);
		
		Present present = new Present();
		present.addSweet(lollipop);
		present.addSweet(cookie);
		present.addSweet(candy);
		
		Sweet[] filterSweets = present.filterSweetsBySugarRange(0, 0.3);
		System.out.println(Arrays.toString(filterSweets));
		System.out.println("Total Weight of the present " + present.calculateTotalWeight());
	}

}

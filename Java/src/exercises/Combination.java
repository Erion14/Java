package exercises;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public static void main(String[] args) {
		int[] nums = {1,2,4,5,7};
		List<List<Integer>> permutations = permute(nums);
		for (List<Integer> combination : permutations) {
			System.out.println(combination);
		}
	}


	
	
	public static List<List<Integer>> permute(int [] nums){
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result, new ArrayList<>(), nums);
		return result;
	}
	
	// method generates the combination
	private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
		// as long as the temp list size is not larger than the nums list it will generate combinations
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
        	// generate combination
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
	}
}

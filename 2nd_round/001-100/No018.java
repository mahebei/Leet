package no001_100;

import java.util.*;

public class No018 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;
				int sum = nums[i] + nums[j];
				int k = j + 1, l = nums.length - 1;
				while (k < l) {
					if (k > j + 1 && nums[k] == nums[k - 1]) k++;
					else if (sum + nums[k] + nums[l] < 0) k++;
					else if (sum + nums[k] + nums[l] > 0) l--;
					else {
						List<Integer> item = new ArrayList<>();
						item.add(nums[i]);
						item.add(nums[j]);
						item.add(nums[k]);
						item.add(nums[l]);
						res.add(new ArrayList<>(item));
						k++;
					}
				}
			}
		}
		return res;
	}
}

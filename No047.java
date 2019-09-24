package no001_100;

import java.util.*;

public class No047 {
	public List<List<Integer>> per(List<List<Integer>> res, List<Integer> items, List<Integer> nums) {
		if (nums.isEmpty()) {
			res.add(new ArrayList<>(items));
			return res;
		}
		for (int i = 0; i < nums.size(); i++) {
			if (i > 0 && nums.get(i) == nums.get(i - 1)) continue;
			items.add(nums.get(i));
			nums.remove(i);
			res = per(res, items, nums);
			nums.add(i, items.get(items.size() - 1));
			items.remove(items.size() - 1);
		}
		return res;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> numList = new ArrayList<>();
		Arrays.sort(nums);
		for (int num : nums) {
			numList.add(num);
		}
		return per(new ArrayList<>(), new ArrayList<>(), numList);

	}
}

package no001_100;

import java.util.*;

public class No046 {
	public List<List<Integer>> per(List<List<Integer>> res, List<Integer> items, List<Integer> nums) {
		if (nums.isEmpty()) {
			res.add(new ArrayList<>(items));
			return res;
		}
		for (int i = 0; i < nums.size(); i++) {
			items.add(nums.get(i));
			nums.remove(i);
			res = per(res, items, nums);
			nums.add(i, items.get(items.size() - 1));
			items.remove(items.size() - 1);
		}
		return res;
	}

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> numList = new ArrayList<>();
		for (int num : nums) {
			numList.add(num);
		}
		return per(new ArrayList<>(), new ArrayList<>(), numList);
	}
}

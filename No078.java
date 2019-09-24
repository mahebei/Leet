package no001_100;

import java.util.*;

public class No078 {
	public List<List<Integer>> subsets(List<List<Integer>> res, List<Integer> item, int i, int[] nums) {
		res.add(new ArrayList<>(item));
		for (; i < nums.length; i++) {
			item.add(nums[i]);
			res = subsets(res, item, i + 1, nums);
			item.remove(item.size() - 1);
		}
		return res;
	}

	public List<List<Integer>> subsets(int[] nums) {
		return subsets(new ArrayList<>(), new ArrayList<>(), 0, nums);
	}
}

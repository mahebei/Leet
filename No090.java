package no001_100;

import java.util.*;

public class No090 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		res.add(item);
		int l, r, len = 0;
		for (int i = 0; i < nums.length; i++) {
			r = res.size();
			if (i != 0 && nums[i] == nums[i - 1]) l = r - len;
			else l = 0;
			len = r - l;
			for (int j = l; j < r; j++) {
				item = new ArrayList<>(res.get(j));
				item.add(nums[i]);
				res.add(item);
			}
		}
		return res;
	}
}

package no001_100;

import java.util.Arrays;

public class No016 {
	public int threeSumClosest(int[] nums, int target) {
		int res = 0, diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					if (target - sum < diff) {
						res = sum;
						diff = target - sum;
					}
					j++;
				} else if (sum > target) {
					if (sum - target < diff) {
						res = sum;
						diff = sum - target;
					}
					k--;
				} else return target;

			}
		}
		return res;
	}
}

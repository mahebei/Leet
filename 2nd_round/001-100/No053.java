package no001_100;

public class No053 {
	public int maxSubArray(int[] nums) {
		if (nums.length == 0) return 0;
		int res = nums[0], currMax = res;
		for (int i = 1; i < nums.length; i++) {
			currMax = (nums[i] > currMax + nums[i]) ? nums[i] : currMax + nums[i];
			res = Math.max(res, currMax);
		}
		return res;
	}
}

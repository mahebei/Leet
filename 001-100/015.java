/*
15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		if (nums.length < 3) {
			return res;
		}
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int sum = -nums[i];
			int hi = nums.length - 1;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int lo = j;
				while (lo < hi) {
					if (nums[lo] + nums[hi] < sum) {
						break;
					} else if (nums[lo] + nums[hi] > sum) {
						hi--;
					} else {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						break;
					}
				}
			}
		}
		return res;
	}
}

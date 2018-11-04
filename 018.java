/*
Given an array nums of n integers and an integer target, are there elements a, b, c, 
and d in nums such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		if (nums.length < 4) {
			return res;
		}
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int sum = target -nums[i] - nums[j];
				int hi = nums.length - 1;
				for (int k = j + 1; k < nums.length - 1; k++) {
					if (k > j + 1 && nums[k] == nums[k - 1]) {
						continue;
					}
					int lo = k;
					while (lo < hi) {
						if (nums[lo] + nums[hi] < sum) {
							break;
						} else if (nums[lo] + nums[hi] > sum) {
							hi--;
						} else {
							res.add(Arrays.asList(nums[i], nums[j], nums[lo],
									nums[hi]));
							break;
						}
					}
				}
			}
		}
		return res;
	}
}

/*
152. Maximum Product Subarray
Medium

Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
	public int maxProduct(int[] nums) {
		int min = nums[0], max = min, res = min;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tem = max;
				max = min;
				min = tem;
			}
			min = Math.min(nums[i], min * nums[i]);
			max = Math.max(nums[i], max * nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}

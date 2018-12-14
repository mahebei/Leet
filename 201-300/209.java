/*
209. Minimum Size Subarray Sum
Medium

Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/

class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) return 0;
		int l = 0, sum = 0, res = nums.length + 1;
		for (int r = 0; r < nums.length; r++) {
			sum += nums[r];
			while (sum >= s){
				res = Math.min(res, r - l + 1);
				sum -= nums[l++];
			}
		}
		if (res == nums.length + 1) return 0;
		return res;
	}
}

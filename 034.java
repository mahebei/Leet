/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
	public int[] searchRange(int[] nums, int target) {
		int l = 0, r = nums.length;
		int m = (l + r) / 2;
		int[] res = {-1, -1};
		while (l < r) {
			if (nums[m] > target) {
				r = m;
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				break;
			}
			m = (l + r) / 2;
		}
		if (l == r){
			return res;
		}
		res[0] = m;
		res[1] = m;
		l = 0; r = m + 1;
		m = (l + r) / 2;
		while (l < r){
			if (nums[m] < nums[res[0]]){
				l = m + 1;
			}else {
				r = m;
			}
			m = (l + r) / 2;
		}
		res[0] = m;
		l = res[1]; r = nums.length;
		m = (l + r) / 2;
		while (l < r){
			if (nums[m] > nums[res[0]]){
				r = m;
			}else {
				l = m + 1;
			}
			m = (l + r) / 2;
		}
		res[1] = m - 1;
		return res; 
	}
}

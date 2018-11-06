/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
	public int search(int[] nums, int target) {
		int res = -1;
		if (nums.length == 0) {
			return res;
		}
		int l = 0, r = nums.length;
		int m = (l + r) / 2;
		while (l < r) {
			m = (l + r) / 2;
			if (nums[m] > nums[l]) {
				if (target >= nums[l] && target < nums[m]) {
					r = m;
				} else {
					l = m;
				}
			} else {
				if (target >= nums[l] || target < nums[m]) {
					r = m;
				} else {
					l = m;
				}
			}
		}
		if (nums[m] == target) {
			return m;
		} else {
			return -1;
		}
	}
}

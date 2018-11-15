/*
35. Search Insert Position
Easy

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/

class Solution {
	public int search(int[] nums, int target, int l, int h) {
		if (l == h - 1) {
			if (target <= nums[l]) {
				return l;
			} else {
				return l + 1;
			}
		}
		int m = (l + h) / 2;
		if (nums[m] == target) {
			return m;
		}
		if (nums[m] > target) {
			return search(nums, target, l, m);
		} else {
			return search(nums, target, m, h);
		}
	}
	public int searchInsert(int[] nums, int target) {
		return search(nums, target, 0, nums.length);
	}
}

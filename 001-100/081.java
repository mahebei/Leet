/*
81. Search in Rotated Sorted Array II
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/

class Solution {
	public boolean search(int[] nums, int target) {
		int l = 0, h = nums.length;
		while (l < h) {
			int m = (l + h) / 2;
			if (nums[m] == target) {
				return true;
			}
			if (nums[l] < nums[m]) {//23444,
				if (target < nums[m] && target >= nums[l]) {
					h = m;
				} else {
					l = m;
				}
			} else if (nums[l] > nums[m]) {//51233
				if (target > nums[m] && target < nums[l]) {
					l = m + 1;
				} else {
					h = m;
				}
			} else {
				l++;
			}
		}
		return false;
	}
}

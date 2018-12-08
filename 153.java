/*
153. Find Minimum in Rotated Sorted Array
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

class Solution {
	public int findMin(int[] nums) {
		int min = nums[0];
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] > nums[l]) {
				min = Math.min(min, Math.min(nums[l], nums[r]));
				l = m + 1;
			} else {
				min = Math.min(min, Math.min(nums[m], nums[r]));
				r = m - 1;
			}
		}
		return min;
	}
}

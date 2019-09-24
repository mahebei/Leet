/*
154. Find Minimum in Rotated Sorted Array II
Hard

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
*/

class Solution {
	public int findMin(int[] nums) {
		int min = nums[0];
		int l = 0, r = nums.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] > nums[l]) {
				min = Math.min(min, nums[l]);
				l = m + 1;
			} else if (nums[m] < nums[l]){
				min = Math.min(min, nums[m]);
				r = m;
			}else {
				min = Math.min(min, nums[l]);
				l++;
			}
		}
		return min;
	}
}

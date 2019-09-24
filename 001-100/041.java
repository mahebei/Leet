/*
41. First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/

class Solution {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int tem = nums[i];
			while (tem > 0 && tem <= nums.length && nums[tem - 1] != tem) {
				tem = nums[tem - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tem;
			}
		}
		for (int i = 1; i <= nums.length; i++) {
			if (i != nums[i - 1]) {
				return i;
			}
		}
		return nums.length + 1;
	}
}

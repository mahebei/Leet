/*
324. Wiggle Sort II
Medium

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

class Solution {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		int l = 0, r = len / 2 * 2 - 1;
		int[] tem = new int[len];
		int i = 0;
		while (i < len) {
			tem[i] = nums[(len - 1) / 2 - i / 2];
			i++;
			if (i < len) {
				tem[i] = nums[len - i / 2 - 1];
				i++;
			}
		}
		System.arraycopy(tem, 0, nums, 0, len);
	}
}
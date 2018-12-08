/*
164. Maximum Gap
Hard

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.
*/

class Solution {
	public int maximumGap(int[] nums) {
		if (nums.length < 2) return 0;
		int max = nums[0], min = max;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		int gap = (int) Math.ceil((float) (max - min + 1) / nums.length); // Pigeonhole principle
		int[] bucketsMin = new int[nums.length];
		int[] bucketsMax = new int[nums.length];
		Arrays.fill(bucketsMin, Integer.MAX_VALUE);
		Arrays.fill(bucketsMax, Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			int idx = (nums[i] - min) / gap;
			bucketsMin[idx] = Math.min(nums[i], bucketsMin[idx]);
			bucketsMax[idx] = Math.max(nums[i], bucketsMax[idx]);
		}
		int res = 0;
		int pre = min;
		for (int i = 0; i < nums.length; i++) {
			if (bucketsMin[i] != Integer.MAX_VALUE || bucketsMax[i] != Integer.MIN_VALUE) {
				res = Math.max(res, bucketsMin[i] - pre);
				pre = bucketsMax[i];
			}
		}
		return res;
	}
}

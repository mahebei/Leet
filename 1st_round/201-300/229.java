/*
229. Majority Element II
Medium

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

class Solution {
	public List<Integer> majorityElement(int[] nums) {
		if (nums.length == 0) return new LinkedList<>();
		int num1 = nums[0], num2 = nums[0];
		int count1 = 0, count2 = 0;
		for (int num : nums) {
			if (num == num1) count1++;
			else if (num == num2) count2++;
			else if (count2 == 0) {
				num2 = num;
				count2 = 1;
			} else if (count1 == 0) {
				num1 = num;
				count1 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == num1) count1++;
			else if (num == num2) count2++;
		}
		List<Integer> res = new LinkedList<>();
		if (count1 > nums.length / 3) res.add(num1);
		if (count2 > nums.length / 3) res.add(num2);
		return res;
	}
}

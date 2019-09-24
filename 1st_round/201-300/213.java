/*
213. House Robber II
Medium

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/

class Solution {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length <= 2) return Math.max(nums[0], nums[nums.length - 1]);
		int[] memo1 = new int[nums.length];
		int[] memo2 = new int[nums.length];
		memo1[1] = nums[0];
		memo2[1] = nums[1];
		for (int i = 1; i < nums.length - 1; i++) {
			memo1[i + 1] = Math.max(memo1[i], memo1[i - 1] + nums[i]);
			memo2[i + 1] = Math.max(memo2[i], memo2[i - 1] + nums[i + 1]);
		}
		return Math.max(memo1[nums.length - 1], memo2[nums.length - 1]);
	}
}

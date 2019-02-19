/*
494. Target Sum
Medium

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

class Solution {
	public int calculate(int[] nums, int S, int[][] memo, int i, int sum) {
		if (i == nums.length) {
			if (sum == S) return 1;
			else return 0;
		}
		if (memo[i][sum + 1000] != 0) return memo[i][sum + 1000];
		int count = calculate(nums, S, memo, i + 1, sum + nums[i]);
		count += calculate(nums, S, memo, i + 1, sum - nums[i]);
		memo[i][sum + 1000] = count;
		return count;
	}

	public int findTargetSumWays(int[] nums, int S) {
		int[][] memo = new int[nums.length][2001];
		for (int[] m : memo) {
			Arrays.fill(m, 0);
		}
		return calculate(nums, S, memo, 0, 0);
	}
}

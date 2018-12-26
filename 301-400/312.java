/*
312. Burst Balloons
Hard

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

class Solution {
	public int getNum(int[] nums, int i) {
		if (i < 0 || i >= nums.length) return 1;
		return nums[i];
	}

	public int maxCoins(int[] nums, int l, int r, int[][] memo) {
		if (l > r) return 0;
		if (memo[l][r] != 0) return memo[l][r];
		int max = 0;
		for (int i = l; i <= r; i++) {
			// i is the index of ballon burst last.
			int coins = maxCoins(nums, l, i - 1, memo) + maxCoins(nums, i + 1, r, memo)
					            + getNum(nums, l - 1) * getNum(nums, i) * getNum(nums, r + 1);
			max = Math.max(max, coins);
		}
		memo[l][r] = max;
		return max;
	}

	public int maxCoins(int[] nums) {
		int[][] memo = new int[nums.length][nums.length];
		return maxCoins(nums, 0, nums.length - 1, memo);
	}
}

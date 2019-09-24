/*
322. Coin Change
Medium

You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
	public int coinChange(int[] coins, int amount) {
		int[] memo = new int[amount + 1];
		Arrays.fill(memo, amount + 1);
		memo[0] = 0;
		for (int i = 0; i < amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i + 1 - coins[j] >= 0)
					memo[i + 1] = Math.min(memo[i + 1], memo[i + 1 - coins[j]] + 1);
			}
		}
		return memo[amount] == amount + 1 ? -1 : memo[amount];
	}
}

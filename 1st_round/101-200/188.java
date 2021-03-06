/*
188. Best Time to Buy and Sell Stock IV
Hard

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
*/

class Solution {
    public int maxProfit(int k, int[] prices) {
		if (k >= prices.length / 2) { //When k >= length / 2, it's big enough to get the most profit.
			int sum = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) sum += prices[i] - prices[i - 1];
			}
			return sum;
		}
        int[][] memo = new int[k + 1][prices.length];
		for (int i = 1; i < k + 1; i++) {
			int maxBuy = -prices[0];
			for (int j = 1; j < prices.length; j++) {
				//Compare max of after finished i transations 1 day before, and finished i-1 transactions then sell at Day j
				memo[i][j] = Math.max(memo[i][j - 1], maxBuy + prices[j]);
				maxBuy = Math.max(maxBuy, memo[i - 1][j - 1] - prices[j]); //Max of after last transaction and buy without sell.
			}
		}
		return memo[k][prices.length - 1];
    }
}

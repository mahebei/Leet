/*
309. Best Time to Buy and Sell Stock with Cooldown
Medium

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int[] buy = new int[prices.length]; // Last action is to buy before or at day i
		int[] sell = new int[prices.length]; // Last action is to sell before or at day i
		int[] cool = new int[prices.length]; // Last action is to coll before or at day i
		buy[0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			buy[i] = Math.max(cool[i - 1] - prices[i], buy[i - 1]); // cooled then buy at day i, or bought and holding
			sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]); // bought then sell at day i, or sold without buying
			cool[i] = Math.max(cool[i - 1], sell[i - 1]); // cool and cool again, or sell then cool
		}
		return Math.max(sell[prices.length - 1], cool[prices.length - 1]);
	}
}

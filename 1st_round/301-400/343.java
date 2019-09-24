/*
343. Integer Break
Medium

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.
*/

class Solution {
	public int integerBreak(int n) {
		int[] memo = new int[n + 1];
		memo[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j <= i / 2; j++) {
				memo[i] = Math.max(memo[i], Math.max(j, memo[j]) * Math.max(i - j, memo[i - j]));
			}
		}
		return memo[n];
	}
}

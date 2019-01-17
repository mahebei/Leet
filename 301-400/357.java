/*
357. Count Numbers with Unique Digits
Medium

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
*/

class Solution {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) return 1;
		int[] memo = new int[n + 1];
		memo[0] = 1;
		for (int i = 1; i <= n; i++) {
			int tem = 9;
			for (int j = 9; j > 10 - i; j--) {
				tem *= j;
			}
			memo[i] = tem + memo[i - 1];
		}
		return memo[n];
	}
}

/*
233. Number of Digit One
Hard

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example:

Input: 13
Output: 6 
Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
*/

/*
	Count all the nums in each digit. 
	Line 24: if n in certain digit is 0, 
			such as 201 on tens, there are 2 * 10 ones on tens for all 201 nums (10-19 and 110-119)
	Line 25: if n in certain digit is 1, 
			such as 215 on tens, there are 5 + 1 more than case 0 (210-215)
	Line 26: if n in certain digit is 2-9, 
			such as 299 on tens, there are 10 more than case 0 (210-219)
*/
class Solution {
	public int countDigitOne(int n) {
		int res = 0;
		for (long i = 1; i <= n; i *= 10) {
			res += n / i / 10 * i;
			if (n / i % 10 == 1) res += n % i + 1;
			else if (n / i % 10 > 1) res += i;
		}
		return res;
	}
}

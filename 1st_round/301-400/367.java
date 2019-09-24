/*
367. Valid Perfect Square
Easy

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
*/

class Solution {
	public boolean isPerfectSquare(int num) {
		if (num < 0) return false;
		long l = 0, r = 50000;
		while (l < r - 1) {
			long m = (l + r) / 2;
			if (m * m == num) return true;
			if (m * m < num) l = m + 1;
			if (m * m > num) r = m;
		}
		return l * l == num;
	}
}

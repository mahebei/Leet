/*
371. Sum of Two Integers
Easy

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
*/

class Solution {
	public int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;
		while (b != 0) {
			int c = a & b;
			a ^= b;
			b = c << 1;
		}
		return a;
	}
}

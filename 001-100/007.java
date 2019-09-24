/*
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
[−2^31,  2^31 − 1]. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/


class Solution {
	public int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
				return 0;
			}
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
				return 0;
			}
			ans = ans * 10 + x % 10;
			x /= 10;
		}
		return ans;
	}
}

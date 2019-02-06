/*
479. Largest Palindrome Product
Hard

Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

 

Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

 

Note:

The range of n is [1,8].
*/

class Solution {
	public int largestPalindrome(int n) {
		if (n == 1) return 9;
		int up = (int) Math.pow(10, n) - 1;
		int half = up - 2;
		while (half > up / 10) {
			long pal = Long.parseLong(half + new StringBuilder().append(half).reverse().toString());
			for (long i = up; i > up / 10; i--) {
				if (i * i < pal || pal / i > up) break;
				if (pal % i == 0) return (int) (pal % 1337);
			}
			half--;
		}
		return up;
	}
}

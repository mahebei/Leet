/*
372. Super Pow
Medium

Your task is to calculate ab mod 1337 where a is a positive integer 
and b is an extremely large positive integer given in the form of an array.

Example 1:

Input: a = 2, b = [3]
Output: 8
Example 2:

Input: a = 2, b = [1,0]
Output: 1024
*/

class Solution {
	public int getPow(int a, int b) {
		int res = 1;
		for (int i = 0; i < b; i++) {
			res = res * a % 1337;
		}
		return res;
	}

	public int superPow(int a, int[] b) {
		a %= 1337;
		if (a == 0) return 0;
		int res = 1;
		for (int i = b.length - 1; i >= 0; i--) {
			res = res * getPow(a, b[i]) % 1337;
			a = getPow(a, 10);
		}
		return res;
	}
}

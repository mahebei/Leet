/*
264. Ugly Number II
Medium

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/

class Solution {
	public int nthUglyNumber(int n) {
		if (n < 1) return 0;
		if (n == 1) return 1;
		int res[] = new int[n];
		res[0] = 1;
		int l1 = 0, l2 = 0, l3 = 0;
		for (int i = 1; i < n; i++) {
			int next = Math.min(res[l1] * 2, Math.min(res[l2] * 3, res[l3] * 5));
			res[i] = next;
			while (res[l1] * 2 <= next) l1++;
			while (res[l2] * 3 <= next) l2++;
			while (res[l3] * 5 <= next) l3++;
		}
		return res[n - 1];
	}
}

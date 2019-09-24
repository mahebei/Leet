/*
59. Spiral Matrix II
Medium

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
	public int[][] generateMatrix(int n) {
		int res[][] = new int[n][n];
		int sideLen = n - 1;
		int count = 1;
		while (sideLen > 0) {
			for (int i = 0; i < sideLen; i++) {
				res[(n - sideLen) / 2][(n - sideLen) / 2 + i] = count++;
			}
			for (int i = 0; i < sideLen; i++) {
				res[(n - sideLen) / 2 + i][(n + sideLen) / 2] = count++;
			}
			for (int i = 0; i < sideLen; i++) {
				res[(n + sideLen) / 2][(n + sideLen) / 2 - i] = count++;
			}
			for (int i = 0; i < sideLen; i++) {
				res[(n + sideLen) / 2 - i][(n - sideLen) / 2] = count++;
			}
			sideLen -= 2;
		}
		if (sideLen == 0) {
			res[(n - 1) / 2][(n - 1) / 2] = count;
		}
		return res;
	}
}

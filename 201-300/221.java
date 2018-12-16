/*
221. Maximal Square
Medium

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

class Solution {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0) return 0;
		int res = 0;
		int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					memo[i][j] = Math.min(memo[i - 1][j - 1], Math.min(memo[i - 1][j], memo[i][j - 1])) + 1;
					res = Math.max(res, memo[i][j]);
				}
			}
		}
		return res * res;
	}
}

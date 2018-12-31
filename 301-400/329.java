/*
329. Longest Increasing Path in a Matrix
Hard

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

class Solution {
	public int getLen(int[][] matrix, int[][] memo, int i, int j) {
		if (memo[i][j] > 0) return memo[i][j];
		int max = 1;
		if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
			max = Math.max(max, 1 + getLen(matrix, memo, i - 1, j));
		}
		if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
			max = Math.max(max, 1 + getLen(matrix, memo, i, j - 1));
		}
		if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j]) {
			max = Math.max(max, 1 + getLen(matrix, memo, i + 1, j));
		}
		if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1]) {
			max = Math.max(max, 1 + getLen(matrix, memo, i, j + 1));
		}
		memo[i][j] = max;
		return max;
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) return 0;
		int[][] memo = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = getLen(matrix, memo, i, j);
				max = Math.max(max, memo[i][j]);
			}
		}
		return max;
	}
}

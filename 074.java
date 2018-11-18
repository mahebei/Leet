/*
74. Search a 2D Matrix
Medium

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

class Solution {
	public boolean searchCol(int[][] matrix, int target, int row, int l, int h) {
		if (l >= h) return false;
		int m = (l + h) / 2;
		if (matrix[row][m] == target) return true;
		if (matrix[row][m] < target) return searchCol(matrix, target, row, m + 1, h);
		return searchCol(matrix, target, row, l, m);
	}
	public int searchRow(int[][] matrix, int target, int l, int h) {
		if (l == h - 1) {
			return l;
		}
		int m = (l + h) / 2;
		if (matrix[m][0] <= target) {
			return searchRow(matrix, target, m, h);
		} else {
			return searchRow(matrix, target, l, m);
		}
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) return false;
		int row = searchRow(matrix, target, 0, matrix.length);
		return searchCol(matrix, target, row, 0, matrix[0].length);
	}
}

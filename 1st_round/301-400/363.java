/*
363. Max Sum of Rectangle No Larger Than K
Hard

Given a non-empty 2D matrix matrix and an integer k, 
find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2 
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).
Note:

The rectangle inside the matrix must have an area > 0.
What if the number of rows is much larger than the number of columns?
*/

class Solution {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			int lineSum = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				lineSum += matrix[i][j];
				sum[i + 1][j + 1] = sum[i][j + 1] + lineSum;
			}
		}
		int ret = Integer.MIN_VALUE;
		for (int i = 1; i <= matrix.length; ++i) {
			for (int j = 1; j <= matrix[0].length; ++j) {
				for (int ii = 0; ii < i; ++ii) {
					for (int jj = 0; jj < j; ++jj) {
						int tmp = sum[i][j] - sum[ii][j] - sum[i][jj] + sum[ii][jj];
						if (tmp <= k)
							ret = Math.max(ret, tmp);
					}
				}
			}
		}
		return ret;
	}
}

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		if (matrix.length == 0) {
			return res;
		}
		int m = matrix[0].length - 1;
		int n = matrix.length - 1;
		int round = 0;
		while (m > 0 && n > 0) {
			for (int i = 0; i < m; i++) {
				res.add(matrix[round][i + round]);
			}
			for (int i = 0; i < n; i++) {
				res.add(matrix[i + round][m + round]);
			}
			for (int i = 0; i < m; i++) {
				res.add(matrix[n + round][m + round - i]);
			}
			for (int i = 0; i < n; i++) {
				res.add(matrix[n + round - i][round]);
			}
			round++;
			m -= 2;
			n -= 2;
		}
		if (m >= 0 && n >= 0)
			if (m > 0 || (m == 0 && n == 0)) {
				for (int i = 0; i <= m; i++) {
					res.add(matrix[round][round + i]);
				}
			} else if (n > 0) {
				for (int i = 0; i <= n; i++) {
					res.add(matrix[round + i][round]);
				}
			}
		return res;
	}
}

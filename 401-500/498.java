/*
498. Diagonal Traverse
Medium

301

209

Favorite

Share
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

 

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Note:

The total number of elements of the given matrix will not exceed 10,000.
*/

class Solution {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0) return new int[0];
		int[] res = new int[matrix.length * matrix[0].length];
		int i = 0, j = 0, sign = -1;
		for (int n = 0; n < res.length; n++) {
			res[n] = matrix[i][j];
			if (sign == -1 && i == 0) {
				if (j < matrix[0].length - 1) j++;
				else i++;
				sign *= -1;
			} else if (sign == 1 && j == 0) {
				if (i < matrix.length - 1) i++;
				else j++;
				sign *= -1;
			} else if (sign == 1 && i == matrix.length - 1) {
				j++;
				sign *= -1;
			} else if (sign == -1 && j == matrix[0].length - 1) {
				i++;
				sign *= -1;
			} else {
				i += sign;
				j += sign * -1;
			}
		}
		return res;
	}
}

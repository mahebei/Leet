/*
85. Maximal Rectangle
Hard

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/

/*
This can be treated as a 2D version of Problem 84, each row is a Problem 84, the heights are continous '1's from current row up.
*/

class Solution {
	public int maximalRectangle(char[][] matrix) {
		int res = 0;
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != '0') {
					matrix[i][j] += matrix[i - 1][j] - '0';
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			Stack<Integer> stack = new Stack<>();
			int count;
			for (int j = 0; j < matrix[0].length; j++) {
				if (stack.isEmpty() || matrix[i][j] - '0' >= stack.peek()) {
					stack.push(matrix[i][j] - '0');
				} else {
					count = 0;
					while (!stack.isEmpty() && stack.peek() > matrix[i][j] - '0') {
						count++;
						int pop = stack.pop();
						if (pop * count > res) res = pop * count;
					}
					for (int k = 0; k <= count; k++) {
						stack.push(matrix[i][j] - '0');
					}
				}
			}
			count = 0;
			while (!stack.isEmpty()) {
				int height = stack.pop();
				count++;
				if (height * count > res) res = height * count;
			}
		}
		return res;
	}
}

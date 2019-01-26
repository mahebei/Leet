/*
417. Pacific Atlantic Water Flow
Medium

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/

class Solution {
	public void dfs(int i, int j, int[][] matrix, boolean[][] memo, int pre) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] < pre || memo[i][j]) return;
		memo[i][j] = true;
		dfs(i + 1, j, matrix, memo, matrix[i][j]);
		dfs(i, j + 1, matrix, memo, matrix[i][j]);
		dfs(i - 1, j, matrix, memo, matrix[i][j]);
		dfs(i, j - 1, matrix, memo, matrix[i][j]);
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if (matrix.length == 0) return res;
		int row = matrix.length, col = matrix[0].length;
		boolean[][] memo1 = new boolean[row][col];
		boolean[][] memo2 = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			dfs(i, 0, matrix, memo1, matrix[i][0]);
			dfs(i, col - 1, matrix, memo2, matrix[i][col - 1]);
		}
		for (int j = 0; j < col; j++) {
			dfs(0, j, matrix, memo1, matrix[0][j]);
			dfs(row - 1, j, matrix, memo2, matrix[row - 1][j]);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (memo1[i][j] && memo2[i][j]) res.add(new int[]{i, j});
			}
		}
		return res;
	}
}

package no001_100;

import java.util.Arrays;

class No063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0) return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] memo = new int[m][n];
		memo[0][0] = 1;
		for (int i = 1; i < m; i++) {
			memo[i][0] = (obstacleGrid[i][0] == 0) ? 1 : 0;
		}
		for (int j = 1; j < n; j++) {
			memo[0][j] = (obstacleGrid[0][j] == 0) ? 1 : 0;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				memo[i][j] = (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
			}
		}
		return memo[m - 1][n - 1];
	}
}
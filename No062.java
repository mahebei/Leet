package no001_100;

import java.util.Arrays;

class No062 {
	public int uniquePaths(int m, int n) {
		if (m * n == 0) return 0;
		int[][] memo = new int[m][n];
		Arrays.fill(memo[0], 1);
		for (int[] nums : memo) {
			nums[0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
			}
		}
		return memo[m - 1][n - 1];
	}
}
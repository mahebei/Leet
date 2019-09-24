package no001_100;

public class No059 {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int num = 0, d = 0;
		while (num < n * n) {
			for (int i = d; i < n - d; i++) {
				res[d][i] = ++num;
			}
			for (int i = d + 1; i < n - d; i++) {
				res[i][n - d - 1] = ++num;
			}
			for (int i = n - d - 2; i > d; i--) {
				res[n - 1 - d][i] = ++num;
			}
			for (int i = n - d - 1; i > d; i--) {
				res[i][d] = ++num;
			}
			d++;
		}
		return res;
	}
}

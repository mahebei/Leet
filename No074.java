package no001_100;

public class No074 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		int l = 0, r = matrix.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (matrix[m][0] == target) return true;
			if (matrix[m][0] > target) r = m;
			else l = m + 1;
		}
		int i = l - 1;
		if (i < 0) i = 0;
		l = 0;
		r = matrix[0].length;
		while (l < r) {
			int m = (l + r) / 2;
			if (matrix[i][m] == target) return true;
			if (matrix[i][m] > target) r = m;
			else l = m + 1;
		}
		return false;
	}
}

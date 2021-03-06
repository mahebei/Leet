package no001_100;

public class No073 {
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0) return;
		boolean row = false, col = false;
		for (int[] nums : matrix) {
			if (nums[0] == 0) {
				col = true;
				break;
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				row = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (row) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (col) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}

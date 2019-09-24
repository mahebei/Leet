package no001_100;

public class No048 {
	public void rotate(int[][] matrix) {
		int len = matrix.length, depth = 0;
		while (depth < len / 2) {
			for (int i = depth; i < len - depth - 1; i++) {
				int temp = matrix[depth][i];
				matrix[depth][i] = matrix[len - i - 1][depth];
				matrix[len - i - 1][depth] = matrix[len - depth - 1][len - i - 1];
				matrix[len - depth - 1][len - i - 1] = matrix[i][len - depth - 1];
				matrix[i][len - depth - 1] = temp;
			}
			depth++;
		}
	}
}

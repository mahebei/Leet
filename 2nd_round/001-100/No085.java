package no001_100;

import java.util.Stack;

public class No085 {
	public static int maximalRectangle(char[][] matrix) {
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			Stack<Integer> s = new Stack<>();
			int count = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (i > 0 && matrix[i][j] == '1') {
					matrix[i][j] += matrix[i - 1][j] -'0';
				}
				int height = matrix[i][j] - '0';
				if (s.isEmpty() || height >= s.peek()) s.push(height);
				else {
					while (!s.isEmpty() && s.peek() > height) {
						res = Math.max(res, s.pop() * ++count);
					}
					while (count > 0) {
						s.push(height);
						count--;
					}
					s.push(height);
				}
			}
			while (!s.isEmpty()) {
				res = Math.max(res, s.pop() * ++count);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		return res;
	}

	public static void main(String[] args) {
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		System.out.println(maximalRectangle(matrix));
	}
}

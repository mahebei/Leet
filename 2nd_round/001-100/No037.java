package no001_100;

import java.util.HashSet;

public class No037 {
	public static boolean validate(char[][] board, int i, int j, char ch) {
		for (int k = 0; k < 9; k++) {
			if (board[i][k] == ch) return false;
			if (board[k][j] == ch) return false;
		}
		i = i / 3 * 3;
		j = j / 3 * 3;
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (board[i + k][j + l] == ch) return false;
			}
		}
		return true;
	}

	public static boolean dfs(char[][] board, int i, int j) {
		while (i < 9) {
			while (j < 9) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; k++) {
						if (validate(board, i, j, k)) {
							board[i][j] = k;
							if (dfs(board, i, j + 1)) return true;
							else board[i][j] = '.';
						}
					}
					return false;
				}
				j++;
			}
			j = 0;
			i++;
		}
		return true;
	}

	public static void solveSudoku(char[][] board) {
		dfs(board, 0, 0);
	}

	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

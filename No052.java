package no001_100;

import java.util.*;

public class No052 {
	public boolean isValid(char[][] board, int i, int j) {
		int len = board.length;
		for (int k = 0; k < len; k++) {
			if (k == i) continue;
			if (board[k][j] == 'Q') return false;
		}
		int offset = -Math.max(i, j);
		while (offset < len - Math.min(i, j)) {
			if (offset != 0) {
				if (i + offset >= 0 && j + offset >= 0 && i + offset < len && j + offset < len && board[i + offset][j + offset] == 'Q')
					return false;
				if (i + offset >= 0 && j - offset >= 0 && i + offset < len && j - offset < len && board[i + offset][j - offset] == 'Q')
					return false;
			}
			offset++;
		}
		return true;
	}

	public int solve(int res, char[][] board, int i) {
		if (i == board.length) return 1;
		for (int j = 0; j < board.length; j++) {
			if (isValid(board, i, j)) {
				board[i][j] = 'Q';
				res += solve(res, board, i + 1);
				board[i][j] = '.';
			}
		}
		return res;
	}

	public int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] line : board) {
			Arrays.fill(line, '.');
		}
		return solve(0, board, 0);
	}
}

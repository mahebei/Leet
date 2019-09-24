package no001_100;

import java.util.*;

public class No051 {
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

	public List<List<String>> solve(List<List<String>> res, char[][] board, int i) {
		if (i == board.length) {
			List<String> curr = new ArrayList<>();
			for (char[] line : board) {
				curr.add(new String(line));
			}
			res.add(curr);
			return res;
		}
		for (int j = 0; j < board.length; j++) {
			if (isValid(board, i, j)) {
				board[i][j] = 'Q';
				res = solve(res, board, i + 1);
				board[i][j] = '.';
			}
		}
		return res;
	}

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] line : board) {
			Arrays.fill(line, '.');
		}
		return solve(new ArrayList<>(), board, 0);
	}
}

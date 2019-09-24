package no001_100;

public class No079 {
	public boolean exist(char[][] board, String word, int i, int j) {
		if (word.isEmpty()) return true;
		if (i > 0 && board[i - 1][j] == word.charAt(0)) {
			char curr = board[i - 1][j];
			board[i - 1][j] = '.';
			if (exist(board, word.substring(1), i - 1, j)) return true;
			board[i - 1][j] = curr;
		}
		if (j > 0 && board[i][j - 1] == word.charAt(0)) {
			char curr = board[i][j - 1];
			board[i][j - 1] = '.';
			if (exist(board, word.substring(1), i, j - 1)) return true;
			board[i][j - 1] = curr;
		}
		if (i < board.length - 1 && board[i + 1][j] == word.charAt(0)) {
			char curr = board[i + 1][j];
			board[i + 1][j] = '.';
			if (exist(board, word.substring(1), i + 1, j)) return true;
			board[i + 1][j] = curr;
		}
		if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(0)) {
			char curr = board[i][j + 1];
			board[i][j + 1] = '.';
			if (exist(board, word.substring(1), i, j + 1)) return true;
			board[i][j + 1] = curr;
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j + 1] == word.charAt(0)) {
					char curr = board[i][j];
					board[i][j] = '.';
					if (exist(board, word.substring(1), i, j)) return true;
					board[i][j] = curr;
				}
			}
		}
		return false;
	}
}

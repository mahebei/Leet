/*
79. Word Search
Medium

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution {
	public boolean check(char[][] board, String word, int row, int col) {
		if (word.isEmpty()) return true;
		if (row > 0) {
			if (board[row - 1][col] == word.charAt(0)) {
				char tem = board[row - 1][col];
				board[row - 1][col] = '.';
				if (check(board, word.substring(1), row - 1, col)) {
					board[row - 1][col] = tem;
					return true;
				}
				board[row - 1][col] = tem;
			}
		}
		if (col > 0) {
			if (board[row][col - 1] == word.charAt(0)) {
				char tem = board[row][col - 1];
				board[row][col - 1] = '.';
				if (check(board, word.substring(1), row, col - 1)) {
					board[row][col - 1] = tem;
					return true;
				}
				board[row][col - 1] = tem;
			}
		}
		if (row < board.length - 1) {
			if (board[row + 1][col] == word.charAt(0)) {
				char tem = board[row + 1][col];
				board[row + 1][col] = '.';
				if (check(board, word.substring(1), row + 1, col)) {
					board[row + 1][col] = tem;
					return true;
				}
				board[row + 1][col] = tem;
			}
		}
		if (col < board[0].length - 1) {
			if (board[row][col + 1] == word.charAt(0)) {
				char tem = board[row][col + 1];
				board[row][col + 1] = '.';
				if (check(board, word.substring(1), row, col + 1)) {
					board[row][col + 1] = tem;
					return true;
				}
				board[row][col + 1] = tem;
			}
		}
		return false;
	}
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					char tem = board[i][j];
					board[i][j] = '.';
					if (check(board, word.substring(1), i, j)) {
						board[i][j] = tem;
						return true;
					}
					board[i][j] = tem;
				}
			}
		}
		return false;
	}
}

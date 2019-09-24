/*
52. N-Queens II
Hard

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

class Solution {
	public boolean validate(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == 'Q' || board[i][col] == 'Q'
					|| (col - (row - i) >= 0 && col - (row - i) < board.length && board[i][col - (row - i)] == 'Q')
					|| (col + (row - i) >= 0 && col + (row - i) < board.length && board[i][col + (row - i)] == 'Q')
			) {
				return false;
			}
		}
		return true;
	}
	public int getSolution(char[][] board, int col, int res) {
		if (col == board.length) {
			return res + 1;
		}
		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, col)) {
				board[i][col] = 'Q';
				res = getSolution(board, col + 1, res);
				board[i][col] = '.';
			}
		}
		return res;
	}
	public int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		return getSolution(board, 0, 0);
	}
}

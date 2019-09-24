/*
51. N-Queens
Hard

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/

class Solution {
	public boolean validate(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == 'Q' || board[row][i] == 'Q'
					|| ((col - (row - i) >= 0 && col - (row - i) < board.length) && board[i][col - (row - i)] == 'Q')
					|| ((col + (row - i) >= 0 && col + (row - i) < board.length) && board[i][col + (row - i)] == 'Q')) {
				return false;
			}
		}
		return true;
	}
	public void solve(char[][] board, int col, List<List<String>> res) {
		if (col == board.length) {
			List<String> solution = new LinkedList<>();
			for (int i = 0; i < board.length; i++) {
				String row = new String(board[i]);
				solution.add(row);
			}
			res.add(new LinkedList<>(solution));
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (validate(board, i, col)) {
				board[i][col] = 'Q';
				solve(board, col + 1, res);
				board[i][col] = '.';
			}
		}
		return;
	}
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new LinkedList<>();
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		solve(board, 0, res);
		return res;
	}
}

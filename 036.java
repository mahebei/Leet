/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
1.Each row must contain the digits 1-9 without repetition.
2.Each column must contain the digits 1-9 without repetition.
3.Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.


A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true


Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Note:
•A Sudoku board (partially filled) could be valid but is not necessarily solvable.
•Only the filled cells need to be validated according to the mentioned rules.
•The given board contain only digits 1-9 and the character '.'.
•The given board size is always 9x9.

*/

class Solution {
	public boolean isValid(char[][] board, int x, int y, int x0, int y0) {
		int[] set = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		for (int i = x; i < x0; i++) {
			for (int j = y; j < y0; j++) {
				char ch = board[i][j];
				if (ch != '.') {
					if (set[ch - '1']++ > 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!isValid(board, i, 0, i + 1, 9)) {
				return false;
			}
			if (!isValid(board, 0, i, 9, i + 1)) {
				return false;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!isValid(board, i * 3, j * 3, i * 3 + 3, j * 3 + 3)) {
					return false;
				}
			}
		}
		return true;
	}
}

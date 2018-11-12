/*
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
*/

public class Solution {
	pravite boolean isValid(char[][] board, int x, int y, char ch) {
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == ch) {
				return false;
			}
			if (board[i][y] == ch) {
				return false;
			}
		}
		for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
			for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
				if (board[i][j] == ch) {
					return false;
				}
			}
		}
		return true;
	}
	private boolean solve(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 1; k <= 9; k++) {
						if (isValid(board, i, j, (char) ('0' + k))) {
							board[i][j] = (char) ('0' + k);
							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	public void solveSudoku(char[][] board) {
		solve(board);
	}
}

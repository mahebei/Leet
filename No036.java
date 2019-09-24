package no001_100;

import java.util.HashSet;

public class No036 {
	public boolean isValidSudoku(char[][] board) {
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					if (set1.contains(num)) return false;
					set1.add(num);
				}
				if (board[j][i] != '.') {
					int num = board[j][i] - '0';
					if (set2.contains(num)) return false;
					set2.add(num);
				}
			}
			set1.clear();
			set2.clear();
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (board[i + k][j + l] != '.') {
							int num = board[i + k][j + l] - '0';
							if (set1.contains(num)) return false;
							set1.add(num);
						}
					}
				}
				set1.clear();
			}
		}
		return true;
	}
}

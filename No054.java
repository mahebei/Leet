package no001_100;

import java.util.*;

public class No054 {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int h = matrix.length - 1, w = matrix[0].length - 1, d = 0;
		while (h - d * 2 > 0 && w - 2 * d > 0) {
			for (int i = d; i < w - d; i++) {
				res.add(matrix[d][i]);
			}
			for (int i = d; i < h - d; i++) {
				res.add(matrix[i][w - d]);
			}
			for (int i = w - d; i > d; i--) {
				res.add(matrix[h - d][i]);
			}
			for (int i = h - d; i > d; i--) {
				res.add(matrix[i][d]);
			}
			d++;
		}
		if (res.size() == (h + 1) * (w + 1)) return res;
		if (w - d * 2 > 0) {
			for (int i = d; i <= w - d; i++) {
				res.add(matrix[d][i]);
			}
		} else if (h - d * 2 > 0){
			for (int i = d; i <= h - d; i++) {
				res.add(matrix[i][w - d]);
			}
		} else if ((w - d * 2 == 0 && h - d * 2 == 0)) {
			res.add(matrix[d][d]);
		}
		return res;
	}
}

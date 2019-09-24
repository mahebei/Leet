package no001_100;

public class No072 {
	public int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		if (len1 == 0) return len2;
		if (len2 == 0) return len1;
		int[][] memo = new int[len1 + 1][len2 + 1];
		memo[0][0] = 0;
		for (int i = 0; i <= len1; i++) {
			memo[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			memo[0][j] = j;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				int min = memo[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) min++;
				memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + 1;
				if (memo[i][j] > min) memo[i][j] = min;
			}
		}
		return memo[len1][len2];
	}
}

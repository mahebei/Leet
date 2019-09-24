package no001_100;

public class No097 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) return false;
		if (s3.isEmpty()) return true;
		boolean[][] memo = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				memo[i][j] = i > 0 && memo[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
						             || j > 0 && memo[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)
						             || i == 0 && j == 0;
			}
		}
		return memo[s1.length()][s2.length()];
	}
}

package no001_100;

public class No044 {
	public static boolean isMatch(String s, String p) {
		boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
		memo[s.length()][p.length()] = true;
		int i = p.length();
		while (i > 0 && memo[s.length()][i] && p.charAt(i - 1) == '*') memo[s.length()][--i] = true;
		for (i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (p.charAt(j) == '*') {
					memo[i][j] = memo[i][j + 1] || memo[i + 1][j] || memo[i + 1][j + 1];
				} else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) memo[i][j] = memo[i + 1][j + 1];

			}
		}
		return memo[0][0];
	}

	public static void main(String[] args) {
		System.out.println(isMatch("adceb", "*a*b"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("cb", "?a"));
		System.out.println(isMatch("acdcb", "a*c?b"));

	}
}
